package com.xqs.datedemo.util;

/**
 * Created by xiaoqingsong on 2017/5/5.
 */

public class JniUtil {
    static {
        System.loadLibrary("JniSDK");
    }

    public static native int add(int a,int b);
}
