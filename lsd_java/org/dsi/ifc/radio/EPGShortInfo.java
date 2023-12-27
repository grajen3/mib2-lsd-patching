/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.radio.EPGExtendedShortProgramInfo;
import org.dsi.ifc.radio.EPGShortProgramInfo;

public class EPGShortInfo {
    public int ensID;
    public int ensECC;
    public long sID;
    public int sCIDI;
    public EPGShortProgramInfo nowProgramInfo;
    public EPGShortProgramInfo nextProgramInfo;
    public EPGExtendedShortProgramInfo extendedProgramInfo;

    public EPGShortInfo() {
        this.ensID = 0;
        this.ensECC = 0;
        this.sID = 0L;
        this.sCIDI = 0;
        this.nowProgramInfo = null;
        this.nextProgramInfo = null;
        this.extendedProgramInfo = null;
    }

    public EPGShortInfo(int n, int n2, long l, int n3, EPGShortProgramInfo ePGShortProgramInfo, EPGShortProgramInfo ePGShortProgramInfo2, EPGExtendedShortProgramInfo ePGExtendedShortProgramInfo) {
        this.ensID = n;
        this.ensECC = n2;
        this.sID = l;
        this.sCIDI = n3;
        this.nowProgramInfo = ePGShortProgramInfo;
        this.nextProgramInfo = ePGShortProgramInfo2;
        this.extendedProgramInfo = ePGExtendedShortProgramInfo;
    }

    public int getEnsID() {
        return this.ensID;
    }

    public int getEnsECC() {
        return this.ensECC;
    }

    public long getSID() {
        return this.sID;
    }

    public int getSCIDI() {
        return this.sCIDI;
    }

    public EPGShortProgramInfo getNowProgramInfo() {
        return this.nowProgramInfo;
    }

    public EPGShortProgramInfo getNextProgramInfo() {
        return this.nextProgramInfo;
    }

    public EPGExtendedShortProgramInfo getExtendedProgramInfo() {
        return this.extendedProgramInfo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3350);
        stringBuffer.append("EPGShortInfo");
        stringBuffer.append('(');
        stringBuffer.append("ensID");
        stringBuffer.append('=');
        stringBuffer.append(this.ensID);
        stringBuffer.append(',');
        stringBuffer.append("ensECC");
        stringBuffer.append('=');
        stringBuffer.append(this.ensECC);
        stringBuffer.append(',');
        stringBuffer.append("sID");
        stringBuffer.append('=');
        stringBuffer.append(this.sID);
        stringBuffer.append(',');
        stringBuffer.append("sCIDI");
        stringBuffer.append('=');
        stringBuffer.append(this.sCIDI);
        stringBuffer.append(',');
        stringBuffer.append("nowProgramInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.nowProgramInfo);
        stringBuffer.append(',');
        stringBuffer.append("nextProgramInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.nextProgramInfo);
        stringBuffer.append(',');
        stringBuffer.append("extendedProgramInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.extendedProgramInfo);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

