/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.wirelesscharging;

import org.dsi.ifc.base.DSIListener;

public interface DSIWirelessChargingListener
extends DSIListener {
    default public void updateChargingInfo(int n, int n2) {
    }

    default public void updateBatteryLevel(int n, int n2) {
    }
}

