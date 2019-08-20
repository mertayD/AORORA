package com.example.aorora.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.aorora.MainActivity;
import com.example.aorora.R;
import com.example.aorora.interfaces.OnItemClickListener;
import com.example.aorora.model.QuestReport;
import com.example.aorora.interfaces.OnLikeListener;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import com.example.aorora.model.RetroPhoto;

import java.util.List;

import static java.lang.Math.min;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<QuestReport> dataList;
    private Context context;
    List<Integer> quest_type_ids;
    List<String> usernames;
    List<Integer> user_butterfly_types;
    String[] accomplishment_description;
    //Need to determine which button was pressed inside the specific RecyclerView
    private OnItemClickListener myLikeListener;


    public interface OnItemClickListener
    {
        void onItemClick(int position );
    }

    public void setOnItemClickListener( OnItemClickListener listener)
    {
        myLikeListener = listener;
    }

    public CustomAdapter(Context context,List<QuestReport> dataList,
                         List<Integer> quest_type_ids,
                         List<String> usernames,
                         List<Integer> user_butterfly_types,
                         String[] accomplishment_description
                         ){
        this.context = context;
        this.dataList = dataList;
        this.quest_type_ids = quest_type_ids;
        this.usernames = usernames;
        this.user_butterfly_types = user_butterfly_types;
        this.accomplishment_description = accomplishment_description;
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        TextView username_tv;
        TextView time_published;
        ImageView coverImage;
        ImageView like_button;
        //RelativeLayout rv_rel_layout_like_button;

        public CustomViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.notification_content_tv);
            username_tv = itemView.findViewById(R.id.user_name_notification_tv);
            time_published = itemView.findViewById(R.id.time_published_tv);
            coverImage = itemView.findViewById(R.id.coverImage);
            like_button = itemView.findViewById(R.id.like_button);

            like_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null)
                    {
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_comments_row, parent, false);
        //Was shown on stack exchange, will figure out why its not working
        CustomViewHolder holder = new CustomViewHolder( view, myLikeListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        String desc = accomplishment_description[quest_type_ids.get(position)-1];
        holder.txtTitle.setText(desc);
        holder.username_tv.setText(usernames.get(position));
        int butterfly_id = user_butterfly_types.get(position);
        Log.e("Butterfly ID : " , " " + butterfly_id);
        switch (butterfly_id){
            case 0:
                holder.coverImage.setImageResource(R.drawable.orange_butterfly_image);
                break;
            case 1:
                holder.coverImage.setImageResource(R.drawable.blue_butterfly_image);
                break;
            case 2:
                holder.coverImage.setImageResource(R.drawable.red_butterfly_image);
                break;
            case 3:
                holder.coverImage.setImageResource(R.drawable.green_butterfly_image);
                break;
            case 4:
                holder.coverImage.setImageResource(R.drawable.yellow_butterfly_image);
                break;
            case 5:
                holder.coverImage.setImageResource(R.drawable.purple_butterfly_image);
                break;
            default:
                holder.coverImage.setImageResource(R.drawable.purple_butterfly_image);
                break;
        }
    }

    @Override
    public int getItemCount() {

        return min(dataList.size(),20);
    }
}
