package com.xinxiong.androidutilsdemo.testbean;

/**
 * Created by zhangxin on 17/9/13.
 */

public class TestBean {
   public String userGroupId;
   public String userName;
   public String crateTime;
   public GroupList groupList;

    @Override
    public String toString() {
        return "TestBean{" +
                "userGroupId='" + userGroupId + '\'' +
                ", userName='" + userName + '\'' +
                ", crateTime='" + crateTime + '\'' +
                ", groupList=" + groupList +
                '}';
    }
}
