package com.tim.utils.string;

/**
 * Created by ace on 2017/9/10.
 */
public class StringUtil {
    public static String getObjectValue(Object obj){
        return obj==null?"":obj.toString();
    }
}
