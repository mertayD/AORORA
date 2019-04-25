package com.example.aorora.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aorora.R;
import com.example.aorora.interfaces.OnItemClickListener;
import com.example.aorora.model.RetroPhoto;

import java.util.List;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.GridViewHolder> {
    private List<RetroPhoto> dataList;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public GridViewAdapter(Context context, List<RetroPhoto> dataList, OnItemClickListener clickListener){
        this.context = context;
        this.dataList = dataList;
        onItemClickListener = clickListener;
    }


    class GridViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView userName;
        ImageView coverImage;

        GridViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            userName = mView.findViewById(R.id.friends_user_name_tv);
            coverImage = mView.findViewById(R.id.cover_image_friends);
        }
    }

    @NonNull
    @Override
    public GridViewAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_friends_grid, parent, false);
        return new GridViewAdapter.GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewAdapter.GridViewHolder customViewHolder, final int position) {
        customViewHolder.userName.setText(dataList.get(position).getTitle().substring(1,4));
        Log.e("POSITION", "" + position);
        switch (position){
            case 0:
                customViewHolder.coverImage.setImageResource(R.drawable.orange_butterfly_image);
                break;
            case 1:
                customViewHolder.coverImage.setImageResource(R.drawable.blue_butterfly_image);
                break;
            case 2:
                customViewHolder.coverImage.setImageResource(R.drawable.red_butterfly_image);
                break;
            case 3:
                customViewHolder.coverImage.setImageResource(R.drawable.green_butterfly_image);
                break;
            case 4:
                customViewHolder.coverImage.setImageResource(R.drawable.yellow_butterfly_image);
                break;
            case 5:
                customViewHolder.coverImage.setImageResource(R.drawable.purple_butterfly_image);
                break;
             default:
                 customViewHolder.coverImage.setImageResource(R.drawable.orange_butterfly_image);
                 break;
        }

        customViewHolder.coverImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(v, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
