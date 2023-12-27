/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class ValueListStatus {
    public int status;
    public int numberOfAvailableItems;
    public int distance;

    public ValueListStatus() {
        this.status = 0;
        this.numberOfAvailableItems = 0;
        this.distance = 0;
    }

    public ValueListStatus(int n, int n2, int n3) {
        this.status = n;
        this.numberOfAvailableItems = n2;
        this.distance = n3;
    }

    public int getStatus() {
        return this.status;
    }

    public int getNumberOfAvailableItems() {
        return this.numberOfAvailableItems;
    }

    public int getDistance() {
        return this.distance;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("ValueListStatus");
        stringBuffer.append('(');
        stringBuffer.append("status");
        stringBuffer.append('=');
        stringBuffer.append(this.status);
        stringBuffer.append(',');
        stringBuffer.append("numberOfAvailableItems");
        stringBuffer.append('=');
        stringBuffer.append(this.numberOfAvailableItems);
        stringBuffer.append(',');
        stringBuffer.append("distance");
        stringBuffer.append('=');
        stringBuffer.append(this.distance);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

