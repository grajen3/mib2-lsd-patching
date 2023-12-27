/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swap;

public class SFscHistory {
    public int swid;
    public String timestamp;
    public String loginfo;

    public SFscHistory() {
        this.swid = 0;
        this.timestamp = null;
        this.loginfo = null;
    }

    public SFscHistory(int n, String string, String string2) {
        this.swid = n;
        this.timestamp = string;
        this.loginfo = string2;
    }

    public int getSwid() {
        return this.swid;
    }

    public String getTimeStamp() {
        return this.timestamp;
    }

    public String getLoginfo() {
        return this.loginfo;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("SFscHistory");
        stringBuffer.append('(');
        stringBuffer.append("swid");
        stringBuffer.append('=');
        stringBuffer.append(this.swid);
        stringBuffer.append(',');
        stringBuffer.append("timestamp");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.timestamp);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("loginfo");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.loginfo);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

