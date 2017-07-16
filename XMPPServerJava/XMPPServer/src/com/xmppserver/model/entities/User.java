package com.xmppserver.model.entities;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Marcus on 13-Jul-17.
 */
public class User {
    private String email;
    private String name;
    private int contactNum;
    private String regionCode;
    private boolean isAdmin;
    private boolean isMale;

    //For all regId for user's phones
    private ArrayList<String> regId;

    public User(String email, String name, int contactNum, String regionCode,
                boolean isAdmin, boolean isMale, ArrayList<String> regId) {
        this.email = email;
        this.name = name;
        this.contactNum = contactNum;
        this.regionCode = regionCode;
        this.isAdmin = isAdmin;
        this.isMale = isMale;
        this.regId = regId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getContactNum() {
        return contactNum;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isMale() {
        return isMale;
    }

    public ArrayList<String> getRegId() {
        return regId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactNum(int contactNum) {
        this.contactNum = contactNum;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public void setRegId(ArrayList<String> regId) {
        this.regId = regId;
    }

    public void addRegId(String regId){
        this.regId.add(regId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
