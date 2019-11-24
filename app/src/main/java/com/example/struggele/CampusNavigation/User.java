package com.example.struggele.CampusNavigation;

import cn.bmob.v3.BmobUser;

public class User extends BmobUser {
    private Boolean sex;
    private String nick;
    private Integer age;
//    private ImageView imageView;
//    public ImageView getImageView(){
//        return this.imageView;
//    }
//    public void setImageView(ImageView imageView){
//        this.imageView=imageView;
//    }
    public boolean getSex() {
        return this.sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getNick() {
        return this.nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
