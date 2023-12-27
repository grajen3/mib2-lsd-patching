/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.phone.services.wirelesscharging;

public interface WirelessChargingUpdate {
    public static final int CHARGER_STATE_NOT_ACTIVE;
    public static final int CHARGER_STATE_ACTIVE;
    public static final int CHARGER_STATE_ERROR;

    default public void onWirelessChargingChanged(int n) {
    }
}

