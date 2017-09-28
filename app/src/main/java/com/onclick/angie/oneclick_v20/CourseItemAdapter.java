package com.onclick.angie.oneclick_v20;

import android.content.Context;
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
 * Created by Angie on 8/27/2017.
 */

public class CourseItemAdapter extends RecyclerView.Adapter<CourseItemAdapter.CourseItemViewHolder> {

    Context context;
    ArrayList<CourseItem> courseItems;

    private ClickListener clickListenerGrade11;
    private ClickListener clickListenerGrade12;

    public CourseItemAdapter(Context context, ArrayList<CourseItem> courseItems) {
        this.context = context;
        this.courseItems = courseItems;
    }


    public void setClickListenerGrade11 (ClickListener clickListenerGrade11) {
        this.clickListenerGrade11 = clickListenerGrade11;
    }

    public void setClickListenerGrade12 (ClickListener clickListenerGrade12) {
        this.clickListenerGrade12 = clickListenerGrade12;
    }


    @Override
    public CourseItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item, parent, false);
        CourseItemViewHolder holder = new CourseItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(CourseItemViewHolder holder, int position) {
        holder.title.setText(courseItems.get(position).getCrsTitle());
        PicassoClient.downloadImage(context, courseItems.get(position).getCrsImg(), holder.screenshot);
    }

    @Override
    public int getItemCount() {
        return courseItems.size();
    }

    public class CourseItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        ImageView screenshot;

        public CourseItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.course_title);
            screenshot = (ImageView) itemView.findViewById(R.id.course_screenshot);
        }

        @Override
        public void onClick(View v) {
            if (clickListenerGrade11 != null) {
                clickListenerGrade11.itemClickGrade11(v, getLayoutPosition());
            }

            if (clickListenerGrade12 != null) {
                clickListenerGrade12.itemClickGrade12(v, getLayoutPosition());
            }
        }
    }

    public interface ClickListener {
        public void itemClickGrade11 (View view, int position);
        public void itemClickGrade12 (View view, int position);
    }


}


