package com.onclick.angie.oneclick_v20;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Angie on 9/11/2017.
 */

public class CourseItemShowAdapter extends RecyclerView.Adapter<CourseItemShowAdapter.AllCourseViewHolder>{

    Context context;
    ArrayList<CourseItem> courseItems;


    public CourseItemShowAdapter (Context context, ArrayList<CourseItem> courseItems) {
        this.context = context;
        this.courseItems = courseItems;
    }


    @Override
    public AllCourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_show_item, parent, false);
        CourseItemShowAdapter.AllCourseViewHolder holder = new CourseItemShowAdapter.AllCourseViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(AllCourseViewHolder holder, int position) {

        holder.title.setText(courseItems.get(position).getCourse_title());
        holder.sDescription.setText(courseItems.get(position).getCourse_description());
        holder.avail.setText(courseItems.get(position).getCourse_availability());
        PicassoClient.downloadImage(context, courseItems.get(position).getCourse_image_link(), holder.screenshot);

        holder.setItemClickListener(new CourseItemAdapter.ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                //Toast.makeText(context, courseItems.get(position).getCourse_title()+"-"+courseItems.get(position), Toast.LENGTH_LONG).show();
                final Intent intent = new Intent(context, CourseOutline.class);
                intent.putExtra("course_id", courseItems.get(position).getCourse_id());
                intent.putExtra("course_branch", courseItems.get(position).getCourse_branch());
                intent.putExtra("course_title", courseItems.get(position).getCourse_title());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return courseItems.size();
    }

    public class AllCourseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView screenshot;
        TextView title;
        TextView sDescription;
        TextView avail;
        CourseItemAdapter.ItemClickListener itemClickListener;

        public AllCourseViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            screenshot = (ImageView) itemView.findViewById(R.id.course_all_image);
            title = (TextView) itemView.findViewById(R.id.course_all_title);
            sDescription = (TextView) itemView.findViewById(R.id.course_all_shortdesc);
            avail = (TextView) itemView.findViewById(R.id.course_all_availuser);
        }

        public void setItemClickListener(CourseItemAdapter.ItemClickListener itemClickListener) {
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
