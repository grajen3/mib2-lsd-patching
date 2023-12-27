/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

public class TrafficWxEntry {
    public int seekID;
    public int contentLink;
    public String marketName;
    public String marketNameAbbrevation;

    public TrafficWxEntry() {
        this.seekID = 0;
        this.contentLink = 0;
        this.marketName = "";
        this.marketNameAbbrevation = "";
    }

    public TrafficWxEntry(int n, int n2, String string, String string2) {
        this.seekID = n;
        this.contentLink = n2;
        this.marketName = string;
        this.marketNameAbbrevation = string2;
    }

    public int getSeekID() {
        return this.seekID;
    }

    public int getContentLink() {
        return this.contentLink;
    }

    public String getMarketName() {
        return this.marketName;
    }

    public String getMarketNameAbbrevation() {
        return this.marketNameAbbrevation;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("TrafficWxEntry");
        stringBuffer.append('(');
        stringBuffer.append("seekID");
        stringBuffer.append('=');
        stringBuffer.append(this.seekID);
        stringBuffer.append(',');
        stringBuffer.append("contentLink");
        stringBuffer.append('=');
        stringBuffer.append(this.contentLink);
        stringBuffer.append(',');
        stringBuffer.append("marketName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.marketName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("marketNameAbbrevation");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.marketNameAbbrevation);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

