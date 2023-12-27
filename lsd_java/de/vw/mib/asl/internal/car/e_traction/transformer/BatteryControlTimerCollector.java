/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.e_traction.transformer;

import de.vw.mib.asl.internal.car.e_traction.transformer.BatteryControlProfileCollector;

public class BatteryControlTimerCollector {
    public int year;
    public int month;
    public int day;
    public int timeHours;
    public int timeMinutes;
    public int timeNextWeekDay;
    public boolean[] timeWeekDays;
    public int profileListIndex;
    public boolean isActivated;
    public int isCycle;
    public int posId;
    public int timer_currentDay;
    private BatteryControlProfileCollector profile;

    public BatteryControlProfileCollector getProfile() {
        return this.profile;
    }

    public void setProfile(BatteryControlProfileCollector batteryControlProfileCollector, int n) {
        if (this.profile != null) {
            this.profile.setUsedByTimer(false);
        }
        this.profile = batteryControlProfileCollector;
        if (batteryControlProfileCollector != null) {
            this.posId = batteryControlProfileCollector.posId;
            this.profileListIndex = n;
        } else {
            this.profileListIndex = 0;
        }
    }

    public void refreshIsUsed() {
        if (this.profile != null) {
            this.profile.setUsedByTimer(true);
        }
    }

    public BatteryControlTimerCollector() {
        this.timeHours = 0;
        this.timeMinutes = 0;
        this.timeNextWeekDay = 0;
        this.timeWeekDays = new boolean[]{false, false, false, false, false, false, false};
        this.profileListIndex = 0;
        this.isActivated = false;
        this.isCycle = 0;
        this.year = 0;
        this.month = 0;
        this.day = 0;
        this.posId = 0;
    }

    public BatteryControlTimerCollector(int n, int n2, int n3, int n4, int n5, int n6, boolean[] blArray, boolean bl, int n7, int n8) {
        this.timeHours = n;
        this.timeMinutes = n2;
        this.timeNextWeekDay = n6;
        this.timeWeekDays = blArray;
        this.profileListIndex = 0;
        this.isActivated = bl;
        this.isCycle = n7;
        this.year = n3;
        this.month = n4;
        this.day = n5;
        this.posId = n8;
    }

    public int getHour() {
        return this.timeHours;
    }

    public int getMinute() {
        return this.timeMinutes;
    }

    public int getNextWeekDay() {
        return this.timeNextWeekDay;
    }

    public boolean[] getTimeWeekDays() {
        return this.timeWeekDays;
    }

    public int getHmiId() {
        return this.profileListIndex;
    }

    public boolean isActive() {
        return this.isActivated;
    }

    public int getSerial() {
        return this.isCycle;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public int getPosId() {
        return this.posId;
    }

    public String getProfileName() {
        if (this.profile != null) {
            return this.profile.profileName;
        }
        return "";
    }

    public boolean isClimate() {
        if (this.profile != null) {
            return this.profile.isAirConditioning;
        }
        return false;
    }

    public boolean isCharging() {
        if (this.profile != null) {
            return this.profile.isCharing;
        }
        return false;
    }
}

