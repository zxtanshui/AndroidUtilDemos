package com.xinxiong.androidutilsdemo.bean;

/**
 * Created by zhangxin on 17/9/19.
 */

public class BeanTemo1 {
    public String userName;
    public String visitorName;
    public int visitSource;

    @Override
    public String toString() {
        return "BeanTemo1{" +
                "userName='" + userName + '\'' +
                ", visitorName='" + visitorName + '\'' +
                ", visitSource='" + visitSource + '\'' +
                '}';
    }
}
