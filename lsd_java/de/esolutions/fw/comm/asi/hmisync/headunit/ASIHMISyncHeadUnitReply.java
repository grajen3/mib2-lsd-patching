/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit;

import de.esolutions.fw.comm.asi.hmisync.headunit.CarConfiguration;
import de.esolutions.fw.comm.asi.hmisync.headunit.ClockDate;
import de.esolutions.fw.comm.asi.hmisync.headunit.ClockTime;

public interface ASIHMISyncHeadUnitReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void resetLanguage(int n, String string) {
    }

    default public void updateASIVersion(String string, boolean bl) {
    }

    default public void updateRequestIDs(short[] sArray, boolean bl) {
    }

    default public void updateReplyIDs(short[] sArray, boolean bl) {
    }

    default public void updateClockTime(ClockTime clockTime, boolean bl) {
    }

    default public void updateClockDate(ClockDate clockDate, boolean bl) {
    }

    default public void updateLanguage1(int n, boolean bl) {
    }

    default public void updateLanguage2(String string, boolean bl) {
    }

    default public void updateTemperatureUnit(int n, boolean bl) {
    }

    default public void updateSpeedUnit(int n, boolean bl) {
    }

    default public void updateDistanceUnit(int n, boolean bl) {
    }

    default public void updatePressureUnit(int n, boolean bl) {
    }

    default public void updateCarConfiguration(CarConfiguration carConfiguration, boolean bl) {
    }

    default public void updateRegion(int n, boolean bl) {
    }

    default public void updateExtCarConfiguration(int[] nArray, boolean bl) {
    }

    default public void updateSplashScreenCoding(short s, boolean bl) {
    }
}

