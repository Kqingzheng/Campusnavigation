package com.example.struggele.campus_navigation;

public class Fruit {
    private String name;
    private String name1;
    private String name2;
    private int imageId;
    public Fruit(String name, String name1, String name2, int imageId)
    {
        this.name=name;
        this.name1=name1;
        this.name2=name2;
        this.imageId=imageId;
    }
    public String getName()
    {
        return name;
    }
    public String getName1()
    {
        return name1;
    }
    public String getName2()
    {
        return name2;
    }
    public int getImageId()
    {
        return imageId;
    }
}
