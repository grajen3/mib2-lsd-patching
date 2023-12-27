/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.bc;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;

public class BCTermGeneralData {
    public FloatBaseType distance;
    public FloatBaseType speed;
    public int timeValue;

    public FloatBaseType getDistance() {
        return this.distance;
    }

    public void setDistance(FloatBaseType floatBaseType) {
        this.distance = floatBaseType;
    }

    public FloatBaseType getSpeed() {
        return this.speed;
    }

    public void setSpeed(FloatBaseType floatBaseType) {
        this.speed = floatBaseType;
    }

    public int getTimeValue() {
        return this.timeValue;
    }

    public void setTimeValue(int n) {
        this.timeValue = n;
    }

    public BCTermGeneralData() {
        this.distance = null;
        this.speed = null;
    }

    public BCTermGeneralData(FloatBaseType floatBaseType, FloatBaseType floatBaseType2, int n) {
        this.distance = floatBaseType;
        this.speed = floatBaseType2;
        this.timeValue = n;
    }

    public String toString() {
        return new StringBuffer("BCTermGeneralData{").append("distance=").append(this.distance).append(", speed=").append(this.speed).append(", timeValue=").append(this.timeValue).append("}").toString();
    }
}

