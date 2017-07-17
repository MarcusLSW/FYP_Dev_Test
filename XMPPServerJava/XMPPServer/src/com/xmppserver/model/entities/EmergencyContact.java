package com.xmppserver.model.entities;



/**
 * Created by MarcusLSW on 17-Jul-17.
 */
public class EmergencyContact {
    private String name;
    private int number;

    // e.g. Singapore = +65
    private String regionCode;

    private double lat;
    private double longi;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLogi() {
        return longi;
    }

    public void setLogi(double longi) {
        this.longi = longi;
    }

    public EmergencyContact(String name, int number, String regionCode, double lat, double longi) {

        this.name = name;
        this.number = number;
        this.regionCode = regionCode;
        this.lat = lat;
        this.longi = longi;
    }
}
