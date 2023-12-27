/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.global.CarViewOption;

public class MirrorViewOptions {
    public CarViewOption mirrorLowering;
    public CarViewOption mirrorSyncAdjust;
    public CarViewOption mirrorFolding;
    public CarViewOption mirrorDimming;
    public CarViewOption mirrorHeating;
    public CarViewOption mirrorSetFactoryDefault;

    public MirrorViewOptions() {
        this.mirrorLowering = null;
        this.mirrorSyncAdjust = null;
        this.mirrorFolding = null;
        this.mirrorDimming = null;
        this.mirrorHeating = null;
        this.mirrorSetFactoryDefault = null;
    }

    public MirrorViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6) {
        this.mirrorLowering = carViewOption;
        this.mirrorSyncAdjust = carViewOption2;
        this.mirrorFolding = carViewOption3;
        this.mirrorDimming = carViewOption4;
        this.mirrorHeating = carViewOption5;
        this.mirrorSetFactoryDefault = carViewOption6;
    }

    public CarViewOption getMirrorLowering() {
        return this.mirrorLowering;
    }

    public CarViewOption getMirrorSyncAdjust() {
        return this.mirrorSyncAdjust;
    }

    public CarViewOption getMirrorFolding() {
        return this.mirrorFolding;
    }

    public CarViewOption getMirrorDimming() {
        return this.mirrorDimming;
    }

    public CarViewOption getMirrorHeating() {
        return this.mirrorHeating;
    }

    public CarViewOption getMirrorSetFactoryDefault() {
        return this.mirrorSetFactoryDefault;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(6250);
        stringBuffer.append("MirrorViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("mirrorLowering");
        stringBuffer.append('=');
        stringBuffer.append(this.mirrorLowering);
        stringBuffer.append(',');
        stringBuffer.append("mirrorSyncAdjust");
        stringBuffer.append('=');
        stringBuffer.append(this.mirrorSyncAdjust);
        stringBuffer.append(',');
        stringBuffer.append("mirrorFolding");
        stringBuffer.append('=');
        stringBuffer.append(this.mirrorFolding);
        stringBuffer.append(',');
        stringBuffer.append("mirrorDimming");
        stringBuffer.append('=');
        stringBuffer.append(this.mirrorDimming);
        stringBuffer.append(',');
        stringBuffer.append("mirrorHeating");
        stringBuffer.append('=');
        stringBuffer.append(this.mirrorHeating);
        stringBuffer.append(',');
        stringBuffer.append("mirrorSetFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.mirrorSetFactoryDefault);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

