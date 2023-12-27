/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.connectedradio;

public class RadioStationStream {
    public String requestURL;
    public int qualityType;
    public int offset;

    public RadioStationStream() {
        this.requestURL = null;
        this.qualityType = 0;
        this.offset = 0;
    }

    public RadioStationStream(String string, int n, int n2) {
        this.requestURL = string;
        this.qualityType = n;
        this.offset = n2;
    }

    public String getRequestURL() {
        return this.requestURL;
    }

    public int getQualityType() {
        return this.qualityType;
    }

    public int getOffset() {
        return this.offset;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("RadioStationStream");
        stringBuffer.append('(');
        stringBuffer.append("requestURL");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.requestURL);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("qualityType");
        stringBuffer.append('=');
        stringBuffer.append(this.qualityType);
        stringBuffer.append(',');
        stringBuffer.append("offset");
        stringBuffer.append('=');
        stringBuffer.append(this.offset);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

