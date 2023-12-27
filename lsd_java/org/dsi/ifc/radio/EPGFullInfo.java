/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.radio.EPGExtendedFullProgramInfo;
import org.dsi.ifc.radio.EPGFullProgramInfo;

public class EPGFullInfo {
    public int ensID;
    public int ensECC;
    public long sID;
    public int sCIDI;
    public EPGFullProgramInfo nowProgramInfo;
    public EPGFullProgramInfo nextProgramInfo;
    public EPGExtendedFullProgramInfo extendedProgramInfo;

    public EPGFullInfo() {
        this.ensID = 0;
        this.ensECC = 0;
        this.sID = 0L;
        this.sCIDI = 0;
        this.nowProgramInfo = null;
        this.nextProgramInfo = null;
        this.extendedProgramInfo = null;
    }

    public EPGFullInfo(int n, int n2, long l, int n3, EPGFullProgramInfo ePGFullProgramInfo, EPGFullProgramInfo ePGFullProgramInfo2, EPGExtendedFullProgramInfo ePGExtendedFullProgramInfo) {
        this.ensID = n;
        this.ensECC = n2;
        this.sID = l;
        this.sCIDI = n3;
        this.nowProgramInfo = ePGFullProgramInfo;
        this.nextProgramInfo = ePGFullProgramInfo2;
        this.extendedProgramInfo = ePGExtendedFullProgramInfo;
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

    public EPGFullProgramInfo getNowProgramInfo() {
        return this.nowProgramInfo;
    }

    public EPGFullProgramInfo getNextProgramInfo() {
        return this.nextProgramInfo;
    }

    public EPGExtendedFullProgramInfo getExtendedProgramInfo() {
        return this.extendedProgramInfo;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3350);
        stringBuffer.append("EPGFullInfo");
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

