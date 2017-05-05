package com.xqs.datedemo.app;



public class APIConfig {
    public static final String API_BASE_URL = "http://piccheck.jcloud.com";

    public static final String BASE_IMAGE = "http://img20.360buyimg.com/n1/";

    public static final String pin = "0aa642c72db6xx";
    public static final String venderId = "17714";

    public static String getImageUrl(String imgUrlEndPoint) {
        return "http://m.360buyimg.com/cv/s" + App.sScreenWidth + "x" + App.sScreenHeight + "_" + imgUrlEndPoint;
    }

}
