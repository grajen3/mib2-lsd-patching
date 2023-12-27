/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class TADConfiguration {
    public int rollAngleMaxScale;
    public int rollAngleStartSoftWarning;
    public int rollAngleStartHardWarning;
    public int pitchAngleMaxScale;
    public int pitchAngleStartSoftWarning;
    public int pitchAngleStartHardWarning;
    public boolean rollAngleInstallation;
    public boolean pitchAngleInstallation;

    public TADConfiguration() {
        this.rollAngleMaxScale = 0;
        this.rollAngleStartSoftWarning = 0;
        this.rollAngleStartHardWarning = 0;
        this.pitchAngleMaxScale = 0;
        this.pitchAngleStartSoftWarning = 0;
        this.pitchAngleStartHardWarning = 0;
        this.rollAngleInstallation = false;
        this.pitchAngleInstallation = false;
    }

    public TADConfiguration(int n, int n2, int n3, int n4, int n5, int n6, boolean bl, boolean bl2) {
        this.rollAngleMaxScale = n;
        this.rollAngleStartSoftWarning = n2;
        this.rollAngleStartHardWarning = n3;
        this.pitchAngleMaxScale = n4;
        this.pitchAngleStartSoftWarning = n5;
        this.pitchAngleStartHardWarning = n6;
        this.rollAngleInstallation = bl;
        this.pitchAngleInstallation = bl2;
    }

    public int getRollAngleMaxScale() {
        return this.rollAngleMaxScale;
    }

    public int getRollAngleStartSoftWarning() {
        return this.rollAngleStartSoftWarning;
    }

    public int getRollAngleStartHardWarning() {
        return this.rollAngleStartHardWarning;
    }

    public int getPitchAngleMaxScale() {
        return this.pitchAngleMaxScale;
    }

    public int getPitchAngleStartSoftWarning() {
        return this.pitchAngleStartSoftWarning;
    }

    public int getPitchAngleStartHardWarning() {
        return this.pitchAngleStartHardWarning;
    }

    public boolean isRollAngleInstallation() {
        return this.rollAngleInstallation;
    }

    public boolean isPitchAngleInstallation() {
        return this.pitchAngleInstallation;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(600);
        stringBuffer.append("TADConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("rollAngleMaxScale");
        stringBuffer.append('=');
        stringBuffer.append(this.rollAngleMaxScale);
        stringBuffer.append(',');
        stringBuffer.append("rollAngleStartSoftWarning");
        stringBuffer.append('=');
        stringBuffer.append(this.rollAngleStartSoftWarning);
        stringBuffer.append(',');
        stringBuffer.append("rollAngleStartHardWarning");
        stringBuffer.append('=');
        stringBuffer.append(this.rollAngleStartHardWarning);
        stringBuffer.append(',');
        stringBuffer.append("pitchAngleMaxScale");
        stringBuffer.append('=');
        stringBuffer.append(this.pitchAngleMaxScale);
        stringBuffer.append(',');
        stringBuffer.append("pitchAngleStartSoftWarning");
        stringBuffer.append('=');
        stringBuffer.append(this.pitchAngleStartSoftWarning);
        stringBuffer.append(',');
        stringBuffer.append("pitchAngleStartHardWarning");
        stringBuffer.append('=');
        stringBuffer.append(this.pitchAngleStartHardWarning);
        stringBuffer.append(',');
        stringBuffer.append("rollAngleInstallation");
        stringBuffer.append('=');
        stringBuffer.append(this.rollAngleInstallation);
        stringBuffer.append(',');
        stringBuffer.append("pitchAngleInstallation");
        stringBuffer.append('=');
        stringBuffer.append(this.pitchAngleInstallation);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

