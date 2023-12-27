/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

public class TADMaxMinAngleReset {
    public boolean rollAngle;
    public boolean pitchAngle;

    public TADMaxMinAngleReset() {
        this.rollAngle = false;
        this.pitchAngle = false;
    }

    public TADMaxMinAngleReset(boolean bl, boolean bl2) {
        this.rollAngle = bl;
        this.pitchAngle = bl2;
    }

    public boolean isRollAngle() {
        return this.rollAngle;
    }

    public boolean isPitchAngle() {
        return this.pitchAngle;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("TADMaxMinAngleReset");
        stringBuffer.append('(');
        stringBuffer.append("rollAngle");
        stringBuffer.append('=');
        stringBuffer.append(this.rollAngle);
        stringBuffer.append(',');
        stringBuffer.append("pitchAngle");
        stringBuffer.append('=');
        stringBuffer.append(this.pitchAngle);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

