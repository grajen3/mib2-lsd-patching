/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mobilityhorizon;

import org.dsi.ifc.mobilityhorizon.ConsumptionInfo;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;

public interface DSIMobilityHorizonC {
    default public void setConsumptionInfo(ConsumptionInfo[] consumptionInfoArray) {
    }

    default public void setLocations(MobilityHorizonLocation[] mobilityHorizonLocationArray) {
    }

    default public void setConsideredLocationTypes(int[] nArray) {
    }

    default public void setDriveTrainMode(int n) {
    }

    default public void requestLocationRangeLevel(int n) {
    }

    default public void setNotification(int[] nArray) {
    }

    default public void setNotification(int n) {
    }

    default public void setNotification() {
    }

    default public void clearNotification(int[] nArray) {
    }

    default public void clearNotification(int n) {
    }

    default public void clearNotification() {
    }

    default public void yySet(String string, String string2) {
    }
}

