package com.onclick.angie.oneclick_v20;

/**
 * Created by Angie on 8/27/2017.
 */

public class CourseItem {

    private  String course_id;
    private String course_image_link;
    private String course_title;
    private String course_description;
    private String course_availability;
    private String course_branch;

    public CourseItem() {
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_image_link() {
        return course_image_link;
    }

    public void setCourse_image_link(String course_image_link) {
        this.course_image_link = course_image_link;
    }

    public String getCourse_title() {
        return course_title;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public String getCourse_availability() {
        return course_availability;
    }

    public void setCourse_availability(String course_availability) {
        this.course_availability = course_availability;
    }

    public String getCourse_branch() {
        return course_branch;
    }

    public void setCourse_branch(String course_branch) {
        this.course_branch = course_branch;
    }
}
