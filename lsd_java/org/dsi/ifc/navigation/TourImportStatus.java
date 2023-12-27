/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class TourImportStatus {
    public int currentIndex;
    public int lastIndex;
    public int status;

    public TourImportStatus() {
        this.currentIndex = 0;
        this.lastIndex = 0;
        this.status = 0;
    }

    public TourImportStatus(int n, int n2, int n3) {
        this.currentIndex = n;
        this.lastIndex = n2;
        this.status = n3;
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public int getLastIndex() {
        return this.lastIndex;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("TourImportStatus");
        stringBuffer.append('(');
        stringBuffer.append("currentIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.currentIndex);
        stringBuffer.append(',');
        stringBuffer.append("lastIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.lastIndex);
        stringBuffer.append(',');
        stringBuffer.append("status");
        stringBuffer.append('=');
        stringBuffer.append(this.status);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

