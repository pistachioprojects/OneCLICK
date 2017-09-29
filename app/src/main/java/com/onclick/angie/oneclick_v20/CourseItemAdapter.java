package com.onclick.angie.oneclick_v20;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Angie on 8/27/2017.
 */

public class CourseItemAdapter extends RecyclerView.Adapter<CourseItemAdapter.CourseItemViewHolder> {

    Context context;
    ArrayList<CourseItem> courseItems;


    public CourseItemAdapter(Context context, ArrayList<CourseItem> courseItems) {
        this.context = context;
        this.courseItems = courseItems;
    }


    @Override
    public CourseItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item, parent, false);
        CourseItemViewHolder holder = new CourseItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CourseItemViewHolder holder, int position) {
        holder.title.setText(courseItems.get(position).getCourse_title());
        PicassoClient.downloadImage(context, courseItems.get(position).getCourse_image_link(), holder.screenshot);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                //Toast.makeText(context, courseItems.get(position).getCourse_title()+"-"+courseItems.get(position), Toast.LENGTH_LONG).show();
                final Intent intent = new Intent(context, CourseSubject.class);
                intent.putExtra("course_id", courseItems.get(position).getCourse_id());
                intent.putExtra("course_title", courseItems.get(position).getCourse_title());
                intent.putExtra("course_video", courseItems.get(position).getCourse_video_id());
                intent.putExtra("course_description", courseItems.get(position).getCourse_description());

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return courseItems.size();
    }

    public class CourseItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        ImageView screenshot;
        ItemClickListener itemClickListener;

        public CourseItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.course_title);
            screenshot = (ImageView) itemView.findViewById(R.id.course_screenshot);
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition());
        }
    }

    public interface ItemClickListener {
        void onClick(View view, int position);
    }


}


