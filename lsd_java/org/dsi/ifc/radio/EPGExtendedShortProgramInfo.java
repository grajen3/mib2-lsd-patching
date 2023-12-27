/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.radio.EPGShortProgramInfo;

public class EPGExtendedShortProgramInfo {
    public EPGShortProgramInfo[] shortProgramInfoList;

    public EPGExtendedShortProgramInfo() {
        this.shortProgramInfoList = null;
    }

    public EPGExtendedShortProgramInfo(EPGShortProgramInfo[] ePGShortProgramInfoArray) {
        this.shortProgramInfoList = ePGShortProgramInfoArray;
    }

    public EPGShortProgramInfo[] getShortProgramInfoList() {
        return this.shortProgramInfoList;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("EPGExtendedShortProgramInfo");
        stringBuffer.append('(');
        stringBuffer.append("shortProgramInfoList");
        stringBuffer.append('[');
        if (this.shortProgramInfoList != null) {
            stringBuffer.append(this.shortProgramInfoList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.shortProgramInfoList != null) {
            int n = this.shortProgramInfoList.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.shortProgramInfoList[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.shortProgramInfoList);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

