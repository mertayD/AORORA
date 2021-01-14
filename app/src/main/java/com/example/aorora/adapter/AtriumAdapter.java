package com.example.aorora.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.aorora.R;

public class AtriumAdapter extends RecyclerView.Adapter<AtriumAdapter.AtriumViewHolder> {
    Context context;
    int imgs[];

    //This will take in the names, descs, and images to be held in our recyclerview.
    public AtriumAdapter(Context ct, int img[]){
        imgs = img;
        context = ct;
    }


    @NonNull
    @Override
    public AtriumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.atrium_row, parent, false);
        AtriumViewHolder atriumViewHolder = new AtriumViewHolder(view);
        return atriumViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AtriumViewHolder atriumAdapterHolder, int i) {
        atriumAdapterHolder.butterflyImage.setImageResource(imgs[i]);
    }

    @Override
    public int getItemCount() {
        return imgs.length;
    }

    public class AtriumViewHolder extends RecyclerView.ViewHolder{
        ImageView butterflyImage;
        public AtriumViewHolder(@NonNull View itemView) {
            super(itemView);
            butterflyImage = itemView.findViewById(R.id.butterfly_img);
        }
    }
}
