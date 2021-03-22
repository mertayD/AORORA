package com.example.aorora;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.annotation.NonNull;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.constraintlayout.solver.widgets.ResolutionDimension;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

import android.print.PrintAttributes;
import android.util.DisplayMetrics;
import android.util.Rational;
import android.util.Size;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.aorora.butterflyGame.Basket;
import com.example.aorora.butterflyGame.Butterfly;
import com.example.aorora.butterflyGame.ButterflyBasketOnDragListener;
import com.example.aorora.network.NetworkCalls;
import com.google.ar.sceneform.rendering.CameraProvider;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.Random;
import java.util.concurrent.ExecutionException;

/**
 * ButterflyGame Activity contains the butterfly catching game component of the ARORA app.
 * the game will start with just a "bucket" view on screen as well a text view displaying the
 * remaining time. once the timer is complete the view will intent to the atrium to show collected
 * butterflies.
 */
public class ButterflyGameActivity extends AppCompatActivity {

    //FIXME: add back button override
    //FIXME: add pause override

    Context butterflyGameContext;

    ConstraintLayout layout;
    ConstraintLayout.LayoutParams params;

    //30 seconds
    final private int MAX_TIMER_MILLISECONDS = 30000;

    private static final String[] CAMERA_PERMISSION =
            new String[] {Manifest.permission.CAMERA};

    private static final int CAMERA_REQUEST_CODE = 10;

    private Basket basket;

    private Butterfly bView;

    private Preview preview;
    private PreviewView cameraPreview;
    private Camera camera;
    private ListenableFuture<ProcessCameraProvider> cameraProviderFuture;

    private Switch cameraSwitch;

    private TextView gameTimeText;

    private long timeLeftInMilliseconds = MAX_TIMER_MILLISECONDS; //30 seconds

    private Random seed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterfly_game);

        butterflyGameContext = this;

        layout = (ConstraintLayout) findViewById(R.id.layout);
        basket = (Basket) findViewById(R.id.basket);
        cameraPreview = (PreviewView) findViewById(R.id.cameraView);
        cameraSwitch = (Switch) findViewById(R.id.cameraSwitch);
        gameTimeText = (TextView) findViewById(R.id.gameTimeText);

        //initialize camera preview
        cameraProviderFuture = ProcessCameraProvider.getInstance(this);

        cameraProviderFuture.addListener(() -> {
            try {
                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
                bindPreview(cameraProvider);
            } catch (ExecutionException | InterruptedException e) {
                //this shouldn't be reached
            }
        }, ContextCompat.getMainExecutor(this));

//        //set up onclicklistener to enable live camera background
//        cameraSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked)
//                {
//                    if(hasCameraPermission()) {
//                        cameraPreview.setVisibility(View.VISIBLE);
//                    } else {
//                        requestPermsission();
//                    }
//                } else {
//                    cameraPreview.setVisibility(View.GONE);
//                }
//            }
//        });

        seed = new Random();

        //GAME LIFECYCLE
        CountDownTimer gameTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {

                //update text in view to remaining time
                gameTimeText.setText(String.valueOf(l/1000));

                //try to spawn extra butterfly at any given second (1/4 chance)
                if(seed.nextInt() % 4 == 0)
                {
                    createRandomButterfly();
                }

                //spawn butterfly every 5 seconds after the start and not on zero
                if(timeLeftInMilliseconds/1000 != 30 &&
                        timeLeftInMilliseconds/1000 % 5 == 0 &&
                        timeLeftInMilliseconds/1000 <= 1 )
                {
                    createRandomButterfly();
                }
            }


            @Override
            public void onFinish() {

                endOfGameActions();

            }
        }.start();

    }

    private void bindPreview(@NonNull ProcessCameraProvider cameraProvider) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        ImageCapture imageCapture = new ImageCapture.Builder()
                .setTargetAspectRatio(AspectRatio.RATIO_4_3)
                .build();

        cameraPreview.setScaleType(PreviewView.ScaleType.FIT_CENTER);

        preview = new Preview.Builder()
                .build();

        CameraSelector cameraSelector = new CameraSelector.Builder()
                .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                .build();

        preview.setSurfaceProvider(cameraPreview.getSurfaceProvider());

        camera = cameraProvider.bindToLifecycle((LifecycleOwner)this, cameraSelector, preview);
    }

    private void endOfGameActions() {

        // update user info table local
        MainActivity.user_info.update_local_atrium(basket.basketContents);

        // update network db with hashmap
        NetworkCalls.updateUserAtrium(MainActivity.user_info.getUser_id(),
                            basket.basketContents, getApplicationContext());

        // implement atrium screen code
        startActivity(new Intent(butterflyGameContext, AtriumScreen.class));
        finish();
    }

    /**
     * creates a butterfly with a random common type, random x value within
     * the layouts bounds, random y value within layout bounds.
     */
    private void createRandomButterfly() {
        int typeID = seed.nextInt(Butterfly.Type.getCount());
        int x = seed.nextInt() % layout.getWidth();
        int y = seed.nextInt() % layout.getHeight();
        createButterfly( Butterfly.Type.valueOf(typeID), x, y);
    }


    /**
     * creates a butterfly view and adds it to the layout and starts the butterflies
     * animation to move around the screen. also adds an ButterflyBasketOnDragListener
     * to the butterfly.
     * @param type Butterfly.Type that will define the type of butterfly.
     * @param x coordinate for butterfly to be added to layout at
     * @param y coordinate for butterfly to be added to layout at
     * @return a reference to the butterfly added to layout.
     */
    private Butterfly createButterfly(Butterfly.Type type, float x, float y) {

        bView = new Butterfly(this, type);

        //adding constraint layout (neede to add view to layout)
        ConstraintLayout.LayoutParams newParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT);

        //width = 120dp
        float width = TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, 120,
                this.getResources().getDisplayMetrics() );
        newParams.width = (int) width;

        //height = 86dp
        float height = TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, 86,
                this.getResources().getDisplayMetrics() );
        newParams.height = (int) height;

        //set view coordinates
        bView.setX(x);
        bView.setY(y);

        layout.addView(bView, newParams);
        bView.spawnAnimation();

        //add listener to view assuming basket exists already
        bView.setOnTouchListener(new ButterflyBasketOnDragListener(bView, basket));

        //FIXME: be able to get width and height of parent view without bugs
        bView.animateToRandomPoints(720, 1472);

        return bView;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus) {
            hideSystemUI();
        }
    }

    /**
     * allows for activity to be fullscreen
     */
    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
        );
    }

    private void showSystemUI()
    {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );
    }

    private boolean hasCameraPermission() {
        return ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermsission()
    {
        ActivityCompat.requestPermissions(
                this,
                CAMERA_PERMISSION,
                CAMERA_REQUEST_CODE
        );
    }
}
