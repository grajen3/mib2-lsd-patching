/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

public class PoiOnlineSearchValuelistElement {
    public int longitude;
    public int latitude;
    public String name;
    public String street;
    public String postal;
    public String city;
    public String region;
    public String country;
    public String phone;
    public String url;
    public String description;
    public byte type;
    public String statusurl;
    public String imageUrl;
    public int category;
    public String additionalData;

    public PoiOnlineSearchValuelistElement() {
        this.longitude = -1;
        this.latitude = -1;
        this.name = "";
        this.street = "";
        this.postal = "";
        this.city = "";
        this.region = "";
        this.country = "";
        this.phone = "";
        this.url = "";
        this.description = "";
        this.type = 0;
        this.statusurl = "";
        this.imageUrl = "";
        this.category = -1;
        this.additionalData = "";
    }

    public PoiOnlineSearchValuelistElement(int n, int n2, String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, byte by, String string10, String string11, int n3, String string12) {
        this.longitude = n;
        this.latitude = n2;
        this.name = string;
        this.street = string2;
        this.postal = string3;
        this.city = string4;
        this.region = string5;
        this.country = string6;
        this.phone = string7;
        this.url = string8;
        this.description = string9;
        this.type = by;
        this.statusurl = string10;
        this.imageUrl = string11;
        this.category = n3;
        this.additionalData = string12;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public String getName() {
        return this.name;
    }

    public String getStreet() {
        return this.street;
    }

    public String getPostal() {
        return this.postal;
    }

    public String getCity() {
        return this.city;
    }

    public String getRegion() {
        return this.region;
    }

    public String getCountry() {
        return this.country;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getUrl() {
        return this.url;
    }

    public String getDescription() {
        return this.description;
    }

    public String getStatusurl() {
        return this.statusurl;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public byte getType() {
        return this.type;
    }

    public int getCategory() {
        return this.category;
    }

    public String getAdditionalData() {
        return this.additionalData;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1100);
        stringBuffer.append("PoiOnlineSearchValuelistElement");
        stringBuffer.append('(');
        stringBuffer.append("longitude");
        stringBuffer.append('=');
        stringBuffer.append(this.longitude);
        stringBuffer.append(',');
        stringBuffer.append("latitude");
        stringBuffer.append('=');
        stringBuffer.append(this.latitude);
        stringBuffer.append(',');
        stringBuffer.append("name");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.name);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("street");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.street);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("postal");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.postal);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("city");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.city);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("region");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.region);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("country");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.country);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("phone");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.phone);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("url");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.url);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("description");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.description);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("statusurl");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.statusurl);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("imageUrl");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.imageUrl);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("category");
        stringBuffer.append('=');
        stringBuffer.append(this.category);
        stringBuffer.append(',');
        stringBuffer.append("additionalData");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.additionalData);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

