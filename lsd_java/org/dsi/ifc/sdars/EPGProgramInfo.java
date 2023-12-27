/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

public class EPGProgramInfo {
    public int programID;
    public int seriesID;
    public int startTime;
    public int endTime;
    public String shortProgramName;
    public String longProgramName;
    public int epgFlag;

    public EPGProgramInfo() {
        this.programID = 0;
        this.seriesID = 0;
        this.startTime = 0;
        this.endTime = 0;
        this.shortProgramName = "";
        this.longProgramName = "";
        this.epgFlag = 0;
    }

    public EPGProgramInfo(int n, int n2, int n3, int n4, String string, String string2, int n5) {
        this.programID = n;
        this.seriesID = n2;
        this.startTime = n3;
        this.endTime = n4;
        this.shortProgramName = string;
        this.longProgramName = string2;
        this.epgFlag = n5;
    }

    public int getProgramID() {
        return this.programID;
    }

    public int getSeriesID() {
        return this.seriesID;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public String getShortProgramName() {
        return this.shortProgramName;
    }

    public String getLongProgramName() {
        return this.longProgramName;
    }

    public int getEpgFlag() {
        return this.epgFlag;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(450);
        stringBuffer.append("EPGProgramInfo");
        stringBuffer.append('(');
        stringBuffer.append("programID");
        stringBuffer.append('=');
        stringBuffer.append(this.programID);
        stringBuffer.append(',');
        stringBuffer.append("seriesID");
        stringBuffer.append('=');
        stringBuffer.append(this.seriesID);
        stringBuffer.append(',');
        stringBuffer.append("startTime");
        stringBuffer.append('=');
        stringBuffer.append(this.startTime);
        stringBuffer.append(',');
        stringBuffer.append("endTime");
        stringBuffer.append('=');
        stringBuffer.append(this.endTime);
        stringBuffer.append(',');
        stringBuffer.append("shortProgramName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.shortProgramName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("longProgramName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.longProgramName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("epgFlag");
        stringBuffer.append('=');
        stringBuffer.append(this.epgFlag);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

