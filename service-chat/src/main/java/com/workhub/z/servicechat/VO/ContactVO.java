package com.workhub.z.servicechat.VO;

/**
*@Description: 最近联系人前端交互实体类
*@Author: 忠
*@date: 2019/5/10
*/
public class ContactVO {
    private String id;//用户id
    private String name;//名称
    private String time;//最近联系时间
    private String lastMessage;//最后一条消息
    private String avatar;//头像
    private int unreadNum;//未读消息条数
    private boolean atMe;//是否@我
    private boolean isTop;//是否置顶
    private boolean isMute;//
    private boolean isGroup;//群组消息
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }
    public String getLastMessage() {
        return lastMessage;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setUnreadNum(int unreadNum) {
        this.unreadNum = unreadNum;
    }
    public int getUnreadNum() {
        return unreadNum;
    }

    public void setAtMe(boolean atMe) {
        this.atMe = atMe;
    }
    public boolean getAtMe() {
        return atMe;
    }

    public void setIsTop(boolean isTop) {
        this.isTop = isTop;
    }
    public boolean getIsTop() {
        return isTop;
    }

    public void setIsMute(boolean isMute) {
        this.isMute = isMute;
    }
    public boolean getIsMute() {
        return isMute;
    }

    public void setIsGroup(boolean isGroup) {
        this.isGroup = isGroup;
    }
    public boolean getIsGroup() {
        return isGroup;
    }

}