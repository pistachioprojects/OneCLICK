package com.onclick.angie.courseseeder;

/**
 * Created by Angie on 10/16/2017.
 */

public class LessonInfo {

    String lesson_id;
    String lesson_description;
    String lesson_video_id;
    String lesson_parent_id;
    int lesson_number;

    public LessonInfo() {
    }

    public LessonInfo(String lesson_id, String lesson_description, String lesson_video_id,  String lesson_parent_id, int lesson_number) {
        this.lesson_id = lesson_id;
        this.lesson_description = lesson_description;
        this.lesson_video_id = lesson_video_id;
        this.lesson_parent_id = lesson_parent_id;
        this.lesson_number = lesson_number;
    }

    public String getLesson_id() {
        return lesson_id;
    }

    public String getLesson_description() {
        return lesson_description;
    }

    public String getLesson_video_id() {
        return lesson_video_id;
    }

    public String getLesson_parent_id() {
        return lesson_parent_id;
    }

    public int getLesson_number() {
        return lesson_number;
    }
}
