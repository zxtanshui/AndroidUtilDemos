package com.xinxiong.androidutilsdemo.testbean;

/**
 * Created by zhangxin on 17/9/13.
 */

public class GroupList {
    public String groupId;
    public String groupName;
    public String groupIcon;
    public String groupTotal;
    public String groupSort;
    public FriendList friendList;

    @Override
    public String toString() {
        return "GroupList{" +
                "groupId='" + groupId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", groupIcon='" + groupIcon + '\'' +
                ", groupTotal='" + groupTotal + '\'' +
                ", groupSort='" + groupSort + '\'' +
                ", friendList=" + friendList +
                '}';
    }
}
