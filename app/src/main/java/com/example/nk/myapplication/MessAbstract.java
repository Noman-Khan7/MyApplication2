package com.example.nk.myapplication;

public class MessAbstract {
    private String messName;
    private String messType;
    private String messRate;

    public MessAbstract() {

    }

    public MessAbstract(String messName, String messType, String messRate) {
        this.messName = messName;
        this.messType = messType;
        this.messRate = messRate;
    }

    public String getMessName() {
        return messName;
    }

    public void setMessName(String messName) {
        this.messName = messName;
    }

    public String getMessType() {
        return messType;
    }

    public void setMessType(String messType) {
        this.messType = messType;
    }

    public String getMessRate() {
        return messRate;
    }

    public void setMessRate(String messRate) {
       this.messRate = messRate;
    }

}
