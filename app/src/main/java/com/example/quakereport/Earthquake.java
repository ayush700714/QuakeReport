package com.example.quakereport;

public class Earthquake {

    private double mag2;
    private String place2;
    private String place3;
    private  String date2;
    private  String url2;
    public Earthquake(double mag,String place1,String place12,String date,String url)
    {
         mag2=mag;
         place2=place1;
         place3=place12;
         date2=date;
         url2=url;
    }
    public double getmag()
    {
        return mag2;
    }
    public String getplace2()
    {
        return place2;
    }
    public String getplace3()
    {
        return place3;
    }
    public String getdate()
    {
        return date2;
    }
    public String geturl()
    {
        return url2;
    }
}
