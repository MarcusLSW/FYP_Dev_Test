package Entities;

import java.util.ArrayList;

/**
 * Created by Marcus on 13-Jul-17.
 */
public class GroupChat {
    private ArrayList<User> members;
    private String name;
    private boolean isActive;

    public GroupChat(ArrayList<User> members, String name, boolean isActive) {
        this.members = members;
        this.name = name;
        this.isActive = isActive;
    }

    public ArrayList<User> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<User> members) {
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

    public void addMember(User u){
        members.add(u);
    }

    public void addMember(User...users){
        for (User u : users){
            members.add(u);
        }
    }

    public void removeMember(User u){
        members.remove(u);
    }
}
