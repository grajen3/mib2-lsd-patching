/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCContinueDrivingAssist {
    public boolean offEarlyMediumLate;

    public PDCContinueDrivingAssist() {
        this.offEarlyMediumLate = false;
    }

    public PDCContinueDrivingAssist(boolean bl) {
        this.offEarlyMediumLate = bl;
    }

    public boolean isOffEarlyMediumLate() {
        return this.offEarlyMediumLate;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("PDCContinueDrivingAssist");
        stringBuffer.append('(');
        stringBuffer.append("offEarlyMediumLate");
        stringBuffer.append('=');
        stringBuffer.append(this.offEarlyMediumLate);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

