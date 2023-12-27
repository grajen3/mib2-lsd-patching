/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

import org.dsi.ifc.navservicesapi.AddressData;

public class AddressDataSDIS {
    public double longitude;
    public double latitude;
    public AddressData[] addressData;
    public int distanceFromThisDestinationToFinalDestination;
    public int remainingTravelTimeToFinalDestination;

    public AddressDataSDIS() {
        this.longitude = 0.0;
        this.latitude = 0.0;
        this.addressData = null;
        this.distanceFromThisDestinationToFinalDestination = 0;
        this.remainingTravelTimeToFinalDestination = 0;
    }

    public AddressDataSDIS(double d2, double d3, AddressData[] addressDataArray, int n, int n2) {
        this.longitude = d2;
        this.latitude = d3;
        this.addressData = addressDataArray;
        this.distanceFromThisDestinationToFinalDestination = n;
        this.remainingTravelTimeToFinalDestination = n2;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public AddressData[] getAddressData() {
        return this.addressData;
    }

    public int getDistanceFromThisDestinationToFinalDestination() {
        return this.distanceFromThisDestinationToFinalDestination;
    }

    public int getRemainingTravelTimeToFinalDestination() {
        return this.remainingTravelTimeToFinalDestination;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(400);
        stringBuffer.append("AddressDataSDIS");
        stringBuffer.append('(');
        stringBuffer.append("longitude");
        stringBuffer.append('=');
        stringBuffer.append(this.longitude);
        stringBuffer.append(',');
        stringBuffer.append("latitude");
        stringBuffer.append('=');
        stringBuffer.append(this.latitude);
        stringBuffer.append(',');
        stringBuffer.append("addressData");
        stringBuffer.append('[');
        if (this.addressData != null) {
            stringBuffer.append(this.addressData.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.addressData != null) {
            int n = this.addressData.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.addressData[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.addressData);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("distanceFromThisDestinationToFinalDestination");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceFromThisDestinationToFinalDestination);
        stringBuffer.append(',');
        stringBuffer.append("remainingTravelTimeToFinalDestination");
        stringBuffer.append('=');
        stringBuffer.append(this.remainingTravelTimeToFinalDestination);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

