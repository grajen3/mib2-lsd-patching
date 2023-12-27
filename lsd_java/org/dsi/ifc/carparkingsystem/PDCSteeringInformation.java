/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

public class PDCSteeringInformation {
    public boolean additionalInfo;
    public int trackDisplay;
    public boolean direction;
    public int radiusRearWheel;
    public int radiusFrontWheel;

    public PDCSteeringInformation() {
        this.additionalInfo = false;
        this.trackDisplay = 0;
        this.direction = false;
        this.radiusRearWheel = 0;
        this.radiusFrontWheel = 0;
    }

    public PDCSteeringInformation(boolean bl, int n, boolean bl2, int n2, int n3) {
        this.additionalInfo = bl;
        this.trackDisplay = n;
        this.direction = bl2;
        this.radiusRearWheel = n2;
        this.radiusFrontWheel = n3;
    }

    public boolean isAdditionalInfo() {
        return this.additionalInfo;
    }

    public int getTrackDisplay() {
        return this.trackDisplay;
    }

    public boolean isDirection() {
        return this.direction;
    }

    public int getRadiusRearWheel() {
        return this.radiusRearWheel;
    }

    public int getRadiusFrontWheel() {
        return this.radiusFrontWheel;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(300);
        stringBuffer.append("PDCSteeringInformation");
        stringBuffer.append('(');
        stringBuffer.append("additionalInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.additionalInfo);
        stringBuffer.append(',');
        stringBuffer.append("trackDisplay");
        stringBuffer.append('=');
        stringBuffer.append(this.trackDisplay);
        stringBuffer.append(',');
        stringBuffer.append("direction");
        stringBuffer.append('=');
        stringBuffer.append(this.direction);
        stringBuffer.append(',');
        stringBuffer.append("radiusRearWheel");
        stringBuffer.append('=');
        stringBuffer.append(this.radiusRearWheel);
        stringBuffer.append(',');
        stringBuffer.append("radiusFrontWheel");
        stringBuffer.append('=');
        stringBuffer.append(this.radiusFrontWheel);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

