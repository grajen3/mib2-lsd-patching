/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

public class StreetViewThumbnail {
    public int geoX;
    public int geoY;
    public int direction;
    public int thumbnailWidth;
    public int thumbnailHeight;
    public String description;
    public String url;

    public StreetViewThumbnail() {
        this.geoX = 0;
        this.geoY = 0;
        this.direction = 0;
        this.thumbnailWidth = 0;
        this.thumbnailHeight = 0;
        this.description = null;
        this.url = null;
    }

    public StreetViewThumbnail(int n, int n2, int n3, int n4, int n5, String string, String string2) {
        this.geoX = n;
        this.geoY = n2;
        this.direction = n3;
        this.thumbnailWidth = n4;
        this.thumbnailHeight = n5;
        this.description = string;
        this.url = string2;
    }

    public int getGeoX() {
        return this.geoX;
    }

    public int getGeoY() {
        return this.geoY;
    }

    public int getDirection() {
        return this.direction;
    }

    public int getThumbnailWidth() {
        return this.thumbnailWidth;
    }

    public int getThumbnailHeight() {
        return this.thumbnailHeight;
    }

    public String getDescription() {
        return this.description;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(450);
        stringBuffer.append("StreetViewThumbnail");
        stringBuffer.append('(');
        stringBuffer.append("geoX");
        stringBuffer.append('=');
        stringBuffer.append(this.geoX);
        stringBuffer.append(',');
        stringBuffer.append("geoY");
        stringBuffer.append('=');
        stringBuffer.append(this.geoY);
        stringBuffer.append(',');
        stringBuffer.append("direction");
        stringBuffer.append('=');
        stringBuffer.append(this.direction);
        stringBuffer.append(',');
        stringBuffer.append("thumbnailWidth");
        stringBuffer.append('=');
        stringBuffer.append(this.thumbnailWidth);
        stringBuffer.append(',');
        stringBuffer.append("thumbnailHeight");
        stringBuffer.append('=');
        stringBuffer.append(this.thumbnailHeight);
        stringBuffer.append(',');
        stringBuffer.append("description");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.description);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("url");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.url);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

