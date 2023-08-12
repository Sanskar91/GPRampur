package com.example.mainlogin;

public class adminaddassi {
    int id;
    String subject,desc,mark;

    public adminaddassi() {
    }

    public adminaddassi(int id, String subject, String desc,String mark) {
        this.id = id;
        this.subject = subject;
        this.desc = desc;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
