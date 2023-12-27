/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

public class MapFlag {
    public int geoX;
    public int geoY;
    public int styleIndex;
    public long handle;

    public MapFlag() {
        this.geoX = 0;
        this.geoY = 0;
        this.styleIndex = 0;
        this.handle = 0L;
    }

    public MapFlag(int n, int n2, int n3, long l) {
        this.geoX = n;
        this.geoY = n2;
        this.styleIndex = n3;
        this.handle = l;
    }

    public int getGeoX() {
        return this.geoX;
    }

    public int getGeoY() {
        return this.geoY;
    }

    public int getStyleIndex() {
        return this.styleIndex;
    }

    public long getHandle() {
        return this.handle;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("MapFlag");
        stringBuffer.append('(');
        stringBuffer.append("geoX");
        stringBuffer.append('=');
        stringBuffer.append(this.geoX);
        stringBuffer.append(',');
        stringBuffer.append("geoY");
        stringBuffer.append('=');
        stringBuffer.append(this.geoY);
        stringBuffer.append(',');
        stringBuffer.append("styleIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.styleIndex);
        stringBuffer.append(',');
        stringBuffer.append("handle");
        stringBuffer.append('=');
        stringBuffer.append(this.handle);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

