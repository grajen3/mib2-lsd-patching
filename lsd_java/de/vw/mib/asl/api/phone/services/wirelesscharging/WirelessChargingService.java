/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.phone.services.wirelesscharging;

import de.vw.mib.asl.api.phone.services.wirelesscharging.WirelessChargingUpdate;

public interface WirelessChargingService {
    default public void register(WirelessChargingUpdate wirelessChargingUpdate) {
    }

    default public void unregister(WirelessChargingUpdate wirelessChargingUpdate) {
    }
}

