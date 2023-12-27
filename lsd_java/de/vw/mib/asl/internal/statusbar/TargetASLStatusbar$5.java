/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.statusbar;

import de.vw.mib.asl.api.phone.services.wirelesscharging.WirelessChargingService;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallback;
import de.vw.mib.asl.internal.statusbar.TargetASLStatusbar;

class TargetASLStatusbar$5
implements ASLComponentAPICallback {
    private final /* synthetic */ TargetASLStatusbar this$0;

    TargetASLStatusbar$5(TargetASLStatusbar targetASLStatusbar) {
        this.this$0 = targetASLStatusbar;
    }

    @Override
    public void registered(Class clazz, Object object) {
        ((WirelessChargingService)object).register(this.this$0.wirelessChargingUpdate);
    }
}

