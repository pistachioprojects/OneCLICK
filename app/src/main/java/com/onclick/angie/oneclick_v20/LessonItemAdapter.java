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

/**
 * Created by Angie on 10/17/2017.
 */

public class LessonItemAdapter extends RecyclerView.Adapter<LessonItemAdapter.LessonItemViewHolder> {

    Context context;
    ArrayList<LessonItem> lessonItems;


    public LessonItemAdapter(Context context, ArrayList<LessonItem> lessonItems) {
        this.context = context;
        this.lessonItems = lessonItems;
    }


    @Override
    public LessonItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lesson_item, parent, false);
        LessonItemViewHolder holder = new LessonItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(LessonItemViewHolder holder, int position) {
        holder.lessonNum.setText(Integer.toString(lessonItems.get(position).getLesson_number()));
        holder.lessonTitle.setText(lessonItems.get(position).getLesson_description());

        holder.setItemClickListener(new LessonItemAdapter.ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                //Toast.makeText(context, courseItems.get(position).getCourse_title()+"-"+courseItems.get(position), Toast.LENGTH_LONG).show();
                final Intent intent = new Intent(context, CourseSubject.class);
                intent.putExtra("lesson_id", lessonItems.get(position).getLesson_id());
                intent.putExtra("lesson_description", lessonItems.get(position).getLesson_description());
                intent.putExtra("lesson_video_id", lessonItems.get(position).getLesson_video_id());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return lessonItems.size();
    }

    public class LessonItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView lessonNum;
        TextView lessonTitle;

        ItemClickListener itemClickListener;

        public LessonItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            lessonNum = (TextView) itemView.findViewById(R.id.course_lesson_number);
            lessonTitle = (TextView) itemView.findViewById(R.id.course_lesson_title);

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
