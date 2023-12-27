/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radio;

import org.dsi.ifc.radio.EPGLogoDescriptor;

public class EPGLogo {
    public int sID;
    public int ensID;
    public int ensECC;
    public int sCIDI;
    public EPGLogoDescriptor[] epgDescriptorList;

    public EPGLogo() {
        this.sID = 0;
        this.ensID = 0;
        this.ensECC = 0;
        this.sCIDI = 0;
        this.epgDescriptorList = null;
    }

    public EPGLogo(int n, int n2, int n3, int n4, EPGLogoDescriptor[] ePGLogoDescriptorArray) {
        this.sID = n;
        this.ensID = n2;
        this.ensECC = n3;
        this.sCIDI = n4;
        this.epgDescriptorList = ePGLogoDescriptorArray;
    }

    public int getEnsID() {
        return this.ensID;
    }

    public int getEnsECC() {
        return this.ensECC;
    }

    public int getSID() {
        return this.sID;
    }

    public int getSCIDI() {
        return this.sCIDI;
    }

    public EPGLogoDescriptor[] getEpgDescriptorList() {
        return this.epgDescriptorList;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("EPGLogo");
        stringBuffer.append('(');
        stringBuffer.append("sID");
        stringBuffer.append('=');
        stringBuffer.append(this.sID);
        stringBuffer.append(',');
        stringBuffer.append("ensID");
        stringBuffer.append('=');
        stringBuffer.append(this.ensID);
        stringBuffer.append(',');
        stringBuffer.append("ensECC");
        stringBuffer.append('=');
        stringBuffer.append(this.ensECC);
        stringBuffer.append(',');
        stringBuffer.append("sCIDI");
        stringBuffer.append('=');
        stringBuffer.append(this.sCIDI);
        stringBuffer.append(',');
        stringBuffer.append("epgDescriptorList");
        stringBuffer.append('[');
        if (this.epgDescriptorList != null) {
            stringBuffer.append(this.epgDescriptorList.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.epgDescriptorList != null) {
            int n = this.epgDescriptorList.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.epgDescriptorList[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.epgDescriptorList);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

