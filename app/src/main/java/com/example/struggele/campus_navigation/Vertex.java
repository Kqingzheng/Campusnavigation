package com.example.struggele.campus_navigation;

public class Vertex {

    private String name;            //顶点名字
    private boolean known;          //顶点是否已知

    private double x;               //顶点横坐标
    private double y;               //顶点纵坐标

    //构造函数
    public Vertex(){
        this.known = false;
    }
    public Vertex(String name){
        this();
        this.name = name;
    }

    //名字操作
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


	/*//是否已知操作
	public boolean isKnown(){
        return known;
    }
    public void setKnown(boolean known){
        this.known = known;
    }*/

    //坐标操作
    public void input(double x,double y){
        this.x=x;
        this.y=y;
    }
    public double getx(){
        return x;
    }
    public double gety(){
        return y;
    }
}