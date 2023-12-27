/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.radio.EPGShortProgramInfo;

public class EPGFullProgramInfo {
    public EPGShortProgramInfo shortInfo;
    public int contentGroup;
    public String detailProgramInfo;

    public EPGFullProgramInfo() {
        this.shortInfo = null;
        this.contentGroup = 0;
        this.detailProgramInfo = "";
    }

    public EPGFullProgramInfo(EPGShortProgramInfo ePGShortProgramInfo, int n, String string) {
        this.shortInfo = ePGShortProgramInfo;
        this.contentGroup = n;
        this.detailProgramInfo = string;
    }

    public EPGShortProgramInfo getShortInfo() {
        return this.shortInfo;
    }

    public int getContentGroup() {
        return this.contentGroup;
    }

    public String getDetailProgramInfo() {
        return this.detailProgramInfo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1200);
        stringBuffer.append("EPGFullProgramInfo");
        stringBuffer.append('(');
        stringBuffer.append("shortInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.shortInfo);
        stringBuffer.append(',');
        stringBuffer.append("contentGroup");
        stringBuffer.append('=');
        stringBuffer.append(this.contentGroup);
        stringBuffer.append(',');
        stringBuffer.append("detailProgramInfo");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.detailProgramInfo);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

