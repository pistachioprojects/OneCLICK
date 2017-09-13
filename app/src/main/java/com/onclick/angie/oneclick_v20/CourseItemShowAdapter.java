package com.onclick.angie.oneclick_v20;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Angie on 9/11/2017.
 */

public class CourseItemShowAdapter extends RecyclerView.Adapter<CourseItemShowAdapter.AllCourseViewHolder>{

    List<CourseItemShow> data = Collections.emptyList();
    private LayoutInflater inflater;

    private ClickListener clickListener;

    public CourseItemShowAdapter (Context context, List<CourseItemShow> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    public void setClickListener (ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public AllCourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.course_show_item, parent, false);
        AllCourseViewHolder holder = new AllCourseViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(AllCourseViewHolder holder, int position) {
        CourseItemShow current = data.get(position);
        holder.screenshot.setImageResource(current.imageId);
        holder.title.setText(current.courseTitle);
        holder.sDescription.setText(current.shortDescription);
        holder.user.setText(current.userAvailability);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class AllCourseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView screenshot;
        TextView title;
        TextView sDescription;
        TextView user;

        public AllCourseViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            screenshot = (ImageView) itemView.findViewById(R.id.course_all_image);
            title = (TextView) itemView.findViewById(R.id.course_all_title);
            sDescription = (TextView) itemView.findViewById(R.id.course_all_shortdesc);
            user = (TextView) itemView.findViewById(R.id.course_all_availuser);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.itemClick(v, getLayoutPosition());
            }
        }
    }

    public interface ClickListener {
        public void itemClick (View view, int position);
    }

}
