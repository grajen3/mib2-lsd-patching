/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.statusbar;

import de.vw.mib.asl.api.phone.services.wirelesscharging.WirelessChargingUpdate;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.internal.statusbar.TargetASLStatusbar;

class TargetASLStatusbar$1
implements WirelessChargingUpdate {
    private final /* synthetic */ TargetASLStatusbar this$0;

    TargetASLStatusbar$1(TargetASLStatusbar targetASLStatusbar) {
        this.this$0 = targetASLStatusbar;
    }

    @Override
    public void onWirelessChargingChanged(int n) {
        AbstractASLTarget.writeIntegerToDatapool(-67613440, n);
    }
}

