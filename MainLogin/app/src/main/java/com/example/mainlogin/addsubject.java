package com.example.mainlogin;

public class addsubject {
    int nid;
    String course,branch,year,subject,set;

    public addsubject(int nid, String course, String branch, String year, String subject, String set) {
        this.nid = nid;
        this.course = course;
        this.branch = branch;
        this.year = year;
        this.subject = subject;
        this.set = set;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }
}
