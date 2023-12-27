/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

import org.dsi.ifc.sdars.EPGProgramInfo;

public class EPGShortInfo {
    public int sID;
    public EPGProgramInfo[] epgProgramInfo;

    public EPGShortInfo() {
        this.sID = 0;
        this.epgProgramInfo = null;
    }

    public EPGShortInfo(int n, EPGProgramInfo[] ePGProgramInfoArray) {
        this.sID = n;
        this.epgProgramInfo = ePGProgramInfoArray;
    }

    public int getSID() {
        return this.sID;
    }

    public EPGProgramInfo[] getEpgProgramInfo() {
        return this.epgProgramInfo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("EPGShortInfo");
        stringBuffer.append('(');
        stringBuffer.append("sID");
        stringBuffer.append('=');
        stringBuffer.append(this.sID);
        stringBuffer.append(',');
        stringBuffer.append("epgProgramInfo");
        stringBuffer.append('[');
        if (this.epgProgramInfo != null) {
            stringBuffer.append(this.epgProgramInfo.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.epgProgramInfo != null) {
            int n = this.epgProgramInfo.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.epgProgramInfo[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.epgProgramInfo);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

