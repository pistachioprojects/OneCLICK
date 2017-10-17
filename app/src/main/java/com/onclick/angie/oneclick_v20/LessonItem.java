package com.onclick.angie.oneclick_v20;

/**
 * Created by Angie on 10/17/2017.
 */

public class LessonItem {

    private  String lesson_id;
    private  String lesson_description;
    private  String lesson_video_id;
    private int lesson_number;

    private String lesson_parent_id;

    public LessonItem() {
    }

    public LessonItem(String lesson_id, String lesson_description, String lesson_video_id, int lesson_number, String lesson_parent_id) {
        this.lesson_id = lesson_id;
        this.lesson_description = lesson_description;
        this.lesson_video_id = lesson_video_id;
        this.lesson_number = lesson_number;
        this.lesson_parent_id = lesson_parent_id;
    }

    public String getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(String lesson_id) {
        this.lesson_id = lesson_id;
    }

    public String getLesson_description() {
        return lesson_description;
    }

    public void setLesson_description(String lesson_description) {
        this.lesson_description = lesson_description;
    }

    public String getLesson_video_id() {
        return lesson_video_id;
    }

    public void setLesson_video_id(String lesson_video_id) {
        this.lesson_video_id = lesson_video_id;
    }

    public int getLesson_number() {
        return lesson_number;
    }

    public void setLesson_number(int lesson_number) {
        this.lesson_number = lesson_number;
    }

    public String getLesson_parent_id() {
        return lesson_parent_id;
    }

    public void setLesson_parent_id(String lesson_parent_id) {
        this.lesson_parent_id = lesson_parent_id;
    }
}
