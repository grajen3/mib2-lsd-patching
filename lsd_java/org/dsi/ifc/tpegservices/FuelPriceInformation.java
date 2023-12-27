/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tpegservices;

import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.tpegservices.FuelPrice;

public class FuelPriceInformation {
    public String name;
    public DateTime lastUpdate;
    public FuelPrice priceInformation;
    public int latitude;
    public int longitude;
    public int contentId;
    public int navLocationId;

    public FuelPriceInformation() {
        this.name = null;
        this.lastUpdate = null;
        this.priceInformation = null;
        this.latitude = 0;
        this.longitude = 0;
        this.contentId = 0;
        this.navLocationId = 0;
    }

    public FuelPriceInformation(String string, DateTime dateTime, FuelPrice fuelPrice, int n, int n2, int n3, int n4) {
        this.name = string;
        this.lastUpdate = dateTime;
        this.priceInformation = fuelPrice;
        this.latitude = n;
        this.longitude = n2;
        this.contentId = n3;
        this.navLocationId = n4;
    }

    public String getName() {
        return this.name;
    }

    public DateTime getLastUpdate() {
        return this.lastUpdate;
    }

    public FuelPrice getPriceInformation() {
        return this.priceInformation;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getContentId() {
        return this.contentId;
    }

    public int getNavLocationId() {
        return this.navLocationId;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2350);
        stringBuffer.append("FuelPriceInformation");
        stringBuffer.append('(');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("lastUpdate");
        stringBuffer.append('=');
        stringBuffer.append(this.lastUpdate);
        stringBuffer.append(',');
        stringBuffer.append("priceInformation");
        stringBuffer.append('=');
        stringBuffer.append(this.priceInformation);
        stringBuffer.append(',');
        stringBuffer.append("latitude");
        stringBuffer.append('=');
        stringBuffer.append(this.latitude);
        stringBuffer.append(',');
        stringBuffer.append("longitude");
        stringBuffer.append('=');
        stringBuffer.append(this.longitude);
        stringBuffer.append(',');
        stringBuffer.append("contentId");
        stringBuffer.append('=');
        stringBuffer.append(this.contentId);
        stringBuffer.append(',');
        stringBuffer.append("navLocationId");
        stringBuffer.append('=');
        stringBuffer.append(this.navLocationId);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

