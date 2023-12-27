/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.driving;

public class TADConfiguration {
    public int rollAngleMaxScale;
    public int rollAngleStartSoftWarning;
    public int rollAngleStartHardWarning;
    public int pitchAngleMaxScale;
    public int pitchAngleStartSoftWarning;
    public int pitchAngleStartHardWarning;
    public boolean rollAngleInstallation;
    public boolean pitchAngleInstallation;

    public int getRollAngleMaxScale() {
        return this.rollAngleMaxScale;
    }

    public void setRollAngleMaxScale(int n) {
        this.rollAngleMaxScale = n;
    }

    public int getRollAngleStartSoftWarning() {
        return this.rollAngleStartSoftWarning;
    }

    public void setRollAngleStartSoftWarning(int n) {
        this.rollAngleStartSoftWarning = n;
    }

    public int getRollAngleStartHardWarning() {
        return this.rollAngleStartHardWarning;
    }

    public void setRollAngleStartHardWarning(int n) {
        this.rollAngleStartHardWarning = n;
    }

    public int getPitchAngleMaxScale() {
        return this.pitchAngleMaxScale;
    }

    public void setPitchAngleMaxScale(int n) {
        this.pitchAngleMaxScale = n;
    }

    public int getPitchAngleStartSoftWarning() {
        return this.pitchAngleStartSoftWarning;
    }

    public void setPitchAngleStartSoftWarning(int n) {
        this.pitchAngleStartSoftWarning = n;
    }

    public int getPitchAngleStartHardWarning() {
        return this.pitchAngleStartHardWarning;
    }

    public void setPitchAngleStartHardWarning(int n) {
        this.pitchAngleStartHardWarning = n;
    }

    public boolean isRollAngleInstallation() {
        return this.rollAngleInstallation;
    }

    public void setRollAngleInstallation(boolean bl) {
        this.rollAngleInstallation = bl;
    }

    public boolean isPitchAngleInstallation() {
        return this.pitchAngleInstallation;
    }

    public void setPitchAngleInstallation(boolean bl) {
        this.pitchAngleInstallation = bl;
    }

    public TADConfiguration() {
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

    public String toString() {
        return new StringBuffer("TADConfiguration{").append("rollAngleMaxScale=").append(this.rollAngleMaxScale).append(", rollAngleStartSoftWarning=").append(this.rollAngleStartSoftWarning).append(", rollAngleStartHardWarning=").append(this.rollAngleStartHardWarning).append(", pitchAngleMaxScale=").append(this.pitchAngleMaxScale).append(", pitchAngleStartSoftWarning=").append(this.pitchAngleStartSoftWarning).append(", pitchAngleStartHardWarning=").append(this.pitchAngleStartHardWarning).append(", rollAngleInstallation=").append(this.rollAngleInstallation).append(", pitchAngleInstallation=").append(this.pitchAngleInstallation).append("}").toString();
    }
}

