/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.radio.EPGFullProgramInfo;

public class EPGExtendedFullProgramInfo {
    public EPGFullProgramInfo[] fullProgramInfoList;

    public EPGExtendedFullProgramInfo() {
        this.fullProgramInfoList = null;
    }

    public EPGExtendedFullProgramInfo(EPGFullProgramInfo[] ePGFullProgramInfoArray) {
        this.fullProgramInfoList = ePGFullProgramInfoArray;
    }

    public EPGFullProgramInfo[] getFullProgramInfoList() {
        return this.fullProgramInfoList;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("EPGExtendedFullProgramInfo");
        stringBuffer.append('(');
        stringBuffer.append("fullProgramInfoList");
        stringBuffer.append('[');
        if (this.fullProgramInfoList != null) {
            stringBuffer.append(this.fullProgramInfoList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.fullProgramInfoList != null) {
            int n = this.fullProgramInfoList.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.fullProgramInfoList[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.fullProgramInfoList);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

