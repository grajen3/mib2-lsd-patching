/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction.transformer;

public class BatteryControlCollector {
    public int posId;
    public String profileName;
    public int targetChargeLevel;
    public int temperatureUnit;
    public int temperatureValue;
    public boolean isAirConditioning;
    public boolean isCharing;
    public boolean isUsedByTimer;
    public boolean isWindowHeating;
    public int maxCurrent;
    public int NR_StartHour;
    public int NR_StartMinutes;
    public int NR_EndHour;
    public int NR_EndMinutes;
    public int powerProviderId;
    public boolean isNightRate;
    public int hmiId;

    public BatteryControlCollector() {
        this.posId = 0;
        this.profileName = "";
        this.targetChargeLevel = 0;
        this.temperatureUnit = 0;
        this.temperatureValue = 0;
        this.isAirConditioning = false;
        this.isCharing = false;
        this.isUsedByTimer = false;
        this.isWindowHeating = false;
        this.maxCurrent = 0;
        this.NR_StartHour = 0;
        this.NR_StartMinutes = 0;
        this.NR_EndHour = 0;
        this.NR_EndMinutes = 0;
        this.powerProviderId = 0;
        this.isNightRate = false;
        this.hmiId = 0;
    }

    public BatteryControlCollector(int n, int n2, int n3, int n4, int n5, String string, boolean bl, boolean bl2, boolean bl3, boolean bl4, int n6, int n7, int n8, int n9, int n10, boolean bl5, int n11) {
        this.posId = n;
        this.profileName = string;
        this.targetChargeLevel = n5;
        this.temperatureUnit = n3;
        this.temperatureValue = n2;
        this.isAirConditioning = bl;
        this.isCharing = bl2;
        this.isUsedByTimer = bl3;
        this.isWindowHeating = bl4;
        this.maxCurrent = n4;
        this.NR_StartHour = n6;
        this.NR_StartMinutes = n7;
        this.NR_EndHour = n8;
        this.NR_EndMinutes = n9;
        this.powerProviderId = n10;
        this.isNightRate = bl5;
        this.hmiId = n11;
    }
}

