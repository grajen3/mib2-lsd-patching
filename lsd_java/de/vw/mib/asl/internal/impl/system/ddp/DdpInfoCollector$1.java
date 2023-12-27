/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.ddp;

import de.vw.mib.asl.api.car.vehicle.VehicleServiceListenerAdapter;
import de.vw.mib.asl.internal.impl.system.ddp.DdpInfoCollector;

class DdpInfoCollector$1
extends VehicleServiceListenerAdapter {
    private final /* synthetic */ DdpInfoCollector this$0;

    DdpInfoCollector$1(DdpInfoCollector ddpInfoCollector) {
        this.this$0 = ddpInfoCollector;
    }

    @Override
    public void updateCarGearType(int n) {
        DdpInfoCollector.access$002(this.this$0, n);
        DdpInfoCollector.access$100(this.this$0, this.this$0.isDdpRequired());
    }

    @Override
    public void updateAutomaticGearShiftTransMode(int n) {
        DdpInfoCollector.access$202(this.this$0, n);
        DdpInfoCollector.access$100(this.this$0, this.this$0.isDdpRequired());
    }

    @Override
    public void updateClutchState(int n) {
        DdpInfoCollector.access$302(this.this$0, n);
        DdpInfoCollector.access$100(this.this$0, this.this$0.isDdpRequired());
    }
}

