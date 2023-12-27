/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.global.DateTime;

public class EPGShortProgramInfo {
    public String programInfo;
    public DateTime startTime;
    public DateTime endTime;

    public EPGShortProgramInfo() {
        this.programInfo = null;
        this.startTime = null;
        this.endTime = null;
    }

    public EPGShortProgramInfo(String string, DateTime dateTime, DateTime dateTime2) {
        this.programInfo = string;
        this.startTime = dateTime;
        this.endTime = dateTime2;
    }

    public String getProgramInfo() {
        return this.programInfo;
    }

    public DateTime getStartTime() {
        return this.startTime;
    }

    public DateTime getEndTime() {
        return this.endTime;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2150);
        stringBuffer.append("EPGShortProgramInfo");
        stringBuffer.append('(');
        stringBuffer.append("programInfo");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.programInfo);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("startTime");
        stringBuffer.append('=');
        stringBuffer.append(this.startTime);
        stringBuffer.append(',');
        stringBuffer.append("endTime");
        stringBuffer.append('=');
        stringBuffer.append(this.endTime);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

