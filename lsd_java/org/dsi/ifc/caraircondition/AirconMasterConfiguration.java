/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.caraircondition;

public class AirconMasterConfiguration {
    public boolean carDriverSide;
    public int numberOfZones;
    public boolean zl1r;
    public boolean zr1r;
    public boolean zl2r;
    public boolean zr2r;
    public boolean zl3r;
    public boolean zr3r;
    public boolean freshAirCartridge1;
    public boolean freshAirCartridge2;
    public boolean pureAirIonisator;
    public boolean pureAirFragrance;
    public boolean airQualityParticleSensor;
    public boolean airQualityInCarQualityCO2;
    public boolean airQualityInCarQualityPollution;
    public boolean airQualityOutsideCustomerThreshold;

    public AirconMasterConfiguration() {
        this.carDriverSide = false;
        this.numberOfZones = 0;
        this.zl1r = false;
        this.zr1r = false;
        this.zl2r = false;
        this.zr2r = false;
        this.zl3r = false;
        this.zr3r = false;
        this.freshAirCartridge1 = false;
        this.freshAirCartridge2 = false;
        this.pureAirIonisator = false;
        this.pureAirFragrance = false;
        this.airQualityParticleSensor = false;
        this.airQualityInCarQualityCO2 = false;
        this.airQualityInCarQualityPollution = false;
        this.airQualityOutsideCustomerThreshold = false;
    }

    public AirconMasterConfiguration(boolean bl, int n, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15) {
        this.carDriverSide = bl;
        this.numberOfZones = n;
        this.zl1r = bl2;
        this.zr1r = bl3;
        this.zl2r = bl4;
        this.zr2r = bl5;
        this.zl3r = bl6;
        this.zr3r = bl7;
        this.freshAirCartridge1 = bl8;
        this.freshAirCartridge2 = bl9;
        this.pureAirIonisator = bl10;
        this.pureAirFragrance = bl11;
        this.airQualityParticleSensor = bl12;
        this.airQualityInCarQualityCO2 = bl13;
        this.airQualityInCarQualityPollution = bl14;
        this.airQualityOutsideCustomerThreshold = bl15;
    }

    public boolean isCarDriverSide() {
        return this.carDriverSide;
    }

    public int getNumberOfZones() {
        return this.numberOfZones;
    }

    public boolean isZl1r() {
        return this.zl1r;
    }

    public boolean isZr1r() {
        return this.zr1r;
    }

    public boolean isZl2r() {
        return this.zl2r;
    }

    public boolean isZr2r() {
        return this.zr2r;
    }

    public boolean isZl3r() {
        return this.zl3r;
    }

    public boolean isZr3r() {
        return this.zr3r;
    }

    public boolean isFreshAirCartridge1() {
        return this.freshAirCartridge1;
    }

    public boolean isFreshAirCartridge2() {
        return this.freshAirCartridge2;
    }

    public boolean isPureAirIonisator() {
        return this.pureAirIonisator;
    }

    public boolean isPureAirFragrance() {
        return this.pureAirFragrance;
    }

    public boolean isAirQualityParticleSensor() {
        return this.airQualityParticleSensor;
    }

    public boolean isAirQualityInCarQualityCO2() {
        return this.airQualityInCarQualityCO2;
    }

    public boolean isAirQualityInCarQualityPollution() {
        return this.airQualityInCarQualityPollution;
    }

    public boolean isAirQualityOutsideCustomerThreshold() {
        return this.airQualityOutsideCustomerThreshold;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(800);
        stringBuffer.append("AirconMasterConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("carDriverSide");
        stringBuffer.append('=');
        stringBuffer.append(this.carDriverSide);
        stringBuffer.append(',');
        stringBuffer.append("numberOfZones");
        stringBuffer.append('=');
        stringBuffer.append(this.numberOfZones);
        stringBuffer.append(',');
        stringBuffer.append("zl1r");
        stringBuffer.append('=');
        stringBuffer.append(this.zl1r);
        stringBuffer.append(',');
        stringBuffer.append("zr1r");
        stringBuffer.append('=');
        stringBuffer.append(this.zr1r);
        stringBuffer.append(',');
        stringBuffer.append("zl2r");
        stringBuffer.append('=');
        stringBuffer.append(this.zl2r);
        stringBuffer.append(',');
        stringBuffer.append("zr2r");
        stringBuffer.append('=');
        stringBuffer.append(this.zr2r);
        stringBuffer.append(',');
        stringBuffer.append("zl3r");
        stringBuffer.append('=');
        stringBuffer.append(this.zl3r);
        stringBuffer.append(',');
        stringBuffer.append("zr3r");
        stringBuffer.append('=');
        stringBuffer.append(this.zr3r);
        stringBuffer.append(',');
        stringBuffer.append("freshAirCartridge1");
        stringBuffer.append('=');
        stringBuffer.append(this.freshAirCartridge1);
        stringBuffer.append(',');
        stringBuffer.append("freshAirCartridge2");
        stringBuffer.append('=');
        stringBuffer.append(this.freshAirCartridge2);
        stringBuffer.append(',');
        stringBuffer.append("pureAirIonisator");
        stringBuffer.append('=');
        stringBuffer.append(this.pureAirIonisator);
        stringBuffer.append(',');
        stringBuffer.append("pureAirFragrance");
        stringBuffer.append('=');
        stringBuffer.append(this.pureAirFragrance);
        stringBuffer.append(',');
        stringBuffer.append("airQualityParticleSensor");
        stringBuffer.append('=');
        stringBuffer.append(this.airQualityParticleSensor);
        stringBuffer.append(',');
        stringBuffer.append("airQualityInCarQualityCO2");
        stringBuffer.append('=');
        stringBuffer.append(this.airQualityInCarQualityCO2);
        stringBuffer.append(',');
        stringBuffer.append("airQualityInCarQualityPollution");
        stringBuffer.append('=');
        stringBuffer.append(this.airQualityInCarQualityPollution);
        stringBuffer.append(',');
        stringBuffer.append("airQualityOutsideCustomerThreshold");
        stringBuffer.append('=');
        stringBuffer.append(this.airQualityOutsideCustomerThreshold);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

