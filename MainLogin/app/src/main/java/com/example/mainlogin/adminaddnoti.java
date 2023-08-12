package com.example.mainlogin;

public class adminaddnoti {
    int id;
    String subject,desc;

    public adminaddnoti() {
    }

    public adminaddnoti(int id, String subject, String desc) {
        this.id = id;
        this.subject = subject;
        this.desc = desc;
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
}
