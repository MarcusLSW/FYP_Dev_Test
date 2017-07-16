package com.xmppserver.model.entities;

import java.util.ArrayList;

/**
 * Created by Marcus on 13-Jul-17.
 */
public class GroupChat {
    private ArrayList<String> members;
    private String name;
    private boolean isActive;
    private String groupId;

    public GroupChat(ArrayList<String> members, String name, boolean isActive, String groupId) {
        this.members = members;
        this.name = name;
        this.isActive = isActive;
        this.groupId = groupId;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void addMember(String u){
        members.add(u);
    }

    public void addMember(String...users){
        for (String u : users){
            members.add(u);
        }
    }

    public void removeMember(User u){
        members.remove(u);
    }

    public String getUuid() {
        return groupId;
    }

    public void setUuid(String groupId) {
        this.groupId = groupId;
    }
}
