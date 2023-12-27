/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

public class DownloadInfo {
    public int count;
    public int numberOfItems;

    public DownloadInfo() {
        this.count = 0;
        this.numberOfItems = 0;
    }

    public DownloadInfo(int n, int n2) {
        this.count = n;
        this.numberOfItems = n2;
    }

    public int getCount() {
        return this.count;
    }

    public int getNumberOfItems() {
        return this.numberOfItems;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(150);
        stringBuffer.append("DownloadInfo");
        stringBuffer.append('(');
        stringBuffer.append("count");
        stringBuffer.append('=');
        stringBuffer.append(this.count);
        stringBuffer.append(',');
        stringBuffer.append("numberOfItems");
        stringBuffer.append('=');
        stringBuffer.append(this.numberOfItems);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

