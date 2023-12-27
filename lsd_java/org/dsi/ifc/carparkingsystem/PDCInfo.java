/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCInfo {
    public boolean limitedFunctionality;
    public boolean trunkOpen;

    public PDCInfo() {
        this.limitedFunctionality = false;
        this.trunkOpen = false;
    }

    public PDCInfo(boolean bl, boolean bl2) {
        this.limitedFunctionality = bl;
        this.trunkOpen = bl2;
    }

    public boolean isLimitedFunctionality() {
        return this.limitedFunctionality;
    }

    public boolean isTrunkOpen() {
        return this.trunkOpen;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("PDCInfo");
        stringBuffer.append('(');
        stringBuffer.append("limitedFunctionality");
        stringBuffer.append('=');
        stringBuffer.append(this.limitedFunctionality);
        stringBuffer.append(',');
        stringBuffer.append("trunkOpen");
        stringBuffer.append('=');
        stringBuffer.append(this.trunkOpen);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

