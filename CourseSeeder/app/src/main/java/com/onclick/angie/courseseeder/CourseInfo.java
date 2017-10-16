package com.onclick.angie.courseseeder;

/**
 * Created by Angie on 9/14/2017.
 */

public class CourseInfo {
    String course_id;
    String course_title;
    String course_description;
    String course_image_link;
    String course_availability;
    String course_branch;

    public CourseInfo(){
    }

    public CourseInfo(String course_id, String course_title, String course_description, String course_image_link, String course_availability, String course_branch) {
        this.course_id = course_id;
        this.course_title = course_title;
        this.course_description = course_description;
        this.course_image_link = course_image_link;
        this.course_availability = course_availability;
        this.course_branch = course_branch;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_title() {
        return course_title;
    }

    public String getCourse_description() {
        return course_description;
    }

    public String getCourse_image_link() {
        return course_image_link;
    }

    public String getCourse_availability() {
        return course_availability;
    }

    public String getCourse_branch() {
        return course_branch;
    }
}
