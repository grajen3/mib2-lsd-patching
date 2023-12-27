/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

public class AirconSteeringWheelHeater {
    public boolean heating;
    public boolean currentState;
    public boolean autoHeating;
    public boolean adjustViaSeatHeating;
    public int heatingStep;

    public AirconSteeringWheelHeater() {
        this.heating = false;
        this.currentState = false;
        this.autoHeating = false;
        this.adjustViaSeatHeating = false;
        this.heatingStep = 0;
    }

    public AirconSteeringWheelHeater(boolean bl, boolean bl2, boolean bl3, boolean bl4, int n) {
        this.heating = bl;
        this.currentState = bl2;
        this.autoHeating = bl3;
        this.adjustViaSeatHeating = bl4;
        this.heatingStep = n;
    }

    public boolean isHeating() {
        return this.heating;
    }

    public boolean isCurrentState() {
        return this.currentState;
    }

    public boolean isAutoHeating() {
        return this.autoHeating;
    }

    public boolean isAdjustViaSeatHeating() {
        return this.adjustViaSeatHeating;
    }

    public int getHeatingStep() {
        return this.heatingStep;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("AirconSteeringWheelHeater");
        stringBuffer.append('(');
        stringBuffer.append("heating");
        stringBuffer.append('=');
        stringBuffer.append(this.heating);
        stringBuffer.append(',');
        stringBuffer.append("currentState");
        stringBuffer.append('=');
        stringBuffer.append(this.currentState);
        stringBuffer.append(',');
        stringBuffer.append("autoHeating");
        stringBuffer.append('=');
        stringBuffer.append(this.autoHeating);
        stringBuffer.append(',');
        stringBuffer.append("adjustViaSeatHeating");
        stringBuffer.append('=');
        stringBuffer.append(this.adjustViaSeatHeating);
        stringBuffer.append(',');
        stringBuffer.append("heatingStep");
        stringBuffer.append('=');
        stringBuffer.append(this.heatingStep);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

