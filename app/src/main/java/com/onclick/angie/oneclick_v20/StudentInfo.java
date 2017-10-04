package com.onclick.angie.oneclick_v20;

/**
 * Created by Angie on 9/13/2017.
 */

public class StudentInfo {

    String student_id;
    String student_firstname;
    String student_lastame;
    String student_email;

    public StudentInfo(){

    }

    public StudentInfo(String student_id, String student_firstname, String student_lastame, String student_email) {
        this.student_id = student_id;
        this.student_firstname = student_firstname;
        this.student_lastame = student_lastame;
        this.student_email = student_email;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getStudent_firstname() {
        return student_firstname;
    }

    public void setStudent_firstname(String student_firstname) {
        this.student_firstname = student_firstname;
    }

    public String getStudent_lastame() {
        return student_lastame;
    }

    public void setStudent_lastame(String student_lastame) {
        this.student_lastame = student_lastame;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }
}
