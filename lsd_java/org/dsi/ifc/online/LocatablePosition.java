/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

public class LocatablePosition {
    public long longitude;
    public long latitude;
    public String country;
    public int bearing;
    public String roadNumber;
    public int functionalRoadClass;
    public int formOfWay;
    public boolean isStopOver;
    public String[] routeCriteria;

    public LocatablePosition() {
        this.longitude = 0L;
        this.latitude = 0L;
        this.country = null;
        this.bearing = -1;
        this.roadNumber = null;
        this.functionalRoadClass = -1;
        this.formOfWay = -1;
        this.isStopOver = false;
        this.routeCriteria = null;
    }

    public LocatablePosition(long l, long l2, String string, int n, String string2, int n2, int n3, boolean bl, String[] stringArray) {
        this.longitude = l;
        this.latitude = l2;
        this.country = string;
        this.bearing = n;
        this.roadNumber = string2;
        this.functionalRoadClass = n2;
        this.formOfWay = n3;
        this.isStopOver = bl;
        this.routeCriteria = stringArray;
    }

    public long getLongitude() {
        return this.longitude;
    }

    public long getLatitude() {
        return this.latitude;
    }

    public String getCountry() {
        return this.country;
    }

    public int getBearing() {
        return this.bearing;
    }

    public String getRoadNumber() {
        return this.roadNumber;
    }

    public int getFunctionalRoadClass() {
        return this.functionalRoadClass;
    }

    public int getFormOfWay() {
        return this.formOfWay;
    }

    public boolean isIsStopOver() {
        return this.isStopOver;
    }

    public String[] getRouteCriteria() {
        return this.routeCriteria;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(600);
        stringBuffer.append("LocatablePosition");
        stringBuffer.append('(');
        stringBuffer.append("longitude");
        stringBuffer.append('=');
        stringBuffer.append(this.longitude);
        stringBuffer.append(',');
        stringBuffer.append("latitude");
        stringBuffer.append('=');
        stringBuffer.append(this.latitude);
        stringBuffer.append(',');
        stringBuffer.append("country");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.country);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("bearing");
        stringBuffer.append('=');
        stringBuffer.append(this.bearing);
        stringBuffer.append(',');
        stringBuffer.append("roadNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.roadNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("functionalRoadClass");
        stringBuffer.append('=');
        stringBuffer.append(this.functionalRoadClass);
        stringBuffer.append(',');
        stringBuffer.append("formOfWay");
        stringBuffer.append('=');
        stringBuffer.append(this.formOfWay);
        stringBuffer.append(',');
        stringBuffer.append("isStopOver");
        stringBuffer.append('=');
        stringBuffer.append(this.isStopOver);
        stringBuffer.append(',');
        stringBuffer.append("routeCriteria");
        stringBuffer.append('[');
        if (this.routeCriteria != null) {
            stringBuffer.append(this.routeCriteria.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.routeCriteria != null) {
            int n = this.routeCriteria.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append('\"');
                stringBuffer.append(this.routeCriteria[i2]);
                stringBuffer.append('\"');
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.routeCriteria);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

