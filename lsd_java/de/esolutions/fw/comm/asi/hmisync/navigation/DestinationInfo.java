/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation;

import java.util.Arrays;

public class DestinationInfo {
    public double longitude;
    public double latitude;
    public String country;
    public String city;
    public String street;
    public String junction;
    public String housenumber;
    public String poiName;
    public String[] formattedDestination;
    public int distanceFromStartOfDestinationToFinalDestination;
    public int distanceFromEndOfDestinationToFinalDestination;
    public double remainingTravelTimeToFinalDestination;

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double d2) {
        this.longitude = d2;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double d2) {
        this.latitude = d2;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String string) {
        this.country = string;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String string) {
        this.city = string;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String string) {
        this.street = string;
    }

    public String getJunction() {
        return this.junction;
    }

    public void setJunction(String string) {
        this.junction = string;
    }

    public String getHousenumber() {
        return this.housenumber;
    }

    public void setHousenumber(String string) {
        this.housenumber = string;
    }

    public String getPoiName() {
        return this.poiName;
    }

    public void setPoiName(String string) {
        this.poiName = string;
    }

    public String[] getFormattedDestination() {
        return this.formattedDestination;
    }

    public void setFormattedDestination(String[] stringArray) {
        this.formattedDestination = stringArray;
    }

    public int getDistanceFromStartOfDestinationToFinalDestination() {
        return this.distanceFromStartOfDestinationToFinalDestination;
    }

    public void setDistanceFromStartOfDestinationToFinalDestination(int n) {
        this.distanceFromStartOfDestinationToFinalDestination = n;
    }

    public int getDistanceFromEndOfDestinationToFinalDestination() {
        return this.distanceFromEndOfDestinationToFinalDestination;
    }

    public void setDistanceFromEndOfDestinationToFinalDestination(int n) {
        this.distanceFromEndOfDestinationToFinalDestination = n;
    }

    public double getRemainingTravelTimeToFinalDestination() {
        return this.remainingTravelTimeToFinalDestination;
    }

    public void setRemainingTravelTimeToFinalDestination(double d2) {
        this.remainingTravelTimeToFinalDestination = d2;
    }

    public DestinationInfo() {
    }

    public DestinationInfo(double d2, double d3, String string, String string2, String string3, String string4, String string5, String string6, String[] stringArray, int n, int n2, double d4) {
        this.longitude = d2;
        this.latitude = d3;
        this.country = string;
        this.city = string2;
        this.street = string3;
        this.junction = string4;
        this.housenumber = string5;
        this.poiName = string6;
        this.formattedDestination = stringArray;
        this.distanceFromStartOfDestinationToFinalDestination = n;
        this.distanceFromEndOfDestinationToFinalDestination = n2;
        this.remainingTravelTimeToFinalDestination = d4;
    }

    public String toString() {
        return new StringBuffer("DestinationInfo{").append("longitude=").append(this.longitude).append(", latitude=").append(this.latitude).append(", country=").append(this.country).append(", city=").append(this.city).append(", street=").append(this.street).append(", junction=").append(this.junction).append(", housenumber=").append(this.housenumber).append(", poiName=").append(this.poiName).append(", formattedDestination=").append("[").append(this.formattedDestination == null ? "null" : Arrays.asList(this.formattedDestination).toString()).append("]").append(", distanceFromStartOfDestinationToFinalDestination=").append(this.distanceFromStartOfDestinationToFinalDestination).append(", distanceFromEndOfDestinationToFinalDestination=").append(this.distanceFromEndOfDestinationToFinalDestination).append(", remainingTravelTimeToFinalDestination=").append(this.remainingTravelTimeToFinalDestination).append("}").toString();
    }
}

