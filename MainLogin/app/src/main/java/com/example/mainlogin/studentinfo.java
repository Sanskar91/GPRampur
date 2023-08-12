package com.example.mainlogin;

public class studentinfo{
    String rollno,name,course,branch,year,mobno,email,pass,fname,fmobno;

    public studentinfo(String rollno, String name, String course, String branch, String year, String mobno, String email, String pass, String fname, String fmobno) {
        this.rollno = rollno;
        this.name = name;
        this.course = course;
        this.branch = branch;
        this.year = year;
        this.mobno = mobno;
        this.email = email;
        this.pass = pass;
        this.fname = fname;
        this.fmobno = fmobno;
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getMobno() {
        return mobno;
    }

    public void setMobno(String mobno) {
        this.mobno = mobno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFmobno() {
        return fmobno;
    }

    public void setFmobno(String fmobno) {
        this.fmobno = fmobno;
    }
}
