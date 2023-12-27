/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system.ddp;

import de.vw.mib.asl.internal.impl.system.VehicleStatesListenerAdapter;
import de.vw.mib.asl.internal.impl.system.ddp.DdpInfoCollector;

class DdpInfoCollector$3
extends VehicleStatesListenerAdapter {
    private final /* synthetic */ DdpInfoCollector this$0;

    DdpInfoCollector$3(DdpInfoCollector ddpInfoCollector) {
        this.this$0 = ddpInfoCollector;
    }

    @Override
    public void updateDestinationInputVelocityThreshold(boolean bl, int n) {
        if (n != 1) {
            DdpInfoCollector.access$500(this.this$0, new StringBuffer().append("updateDestinationInputVelocityThreshold called with unexpected valid flag; validFlag should be 1 but was ").append(n).toString());
            return;
        }
        DdpInfoCollector.access$602(this.this$0, bl);
        DdpInfoCollector.access$100(this.this$0, this.this$0.isDdpRequired());
    }

    @Override
    public void updateParkingBrake(boolean bl, int n) {
        if (n != 1) {
            DdpInfoCollector.access$500(this.this$0, new StringBuffer().append("updateParkingBrake called with unexpected valid flag; validFlag should be 1 but was ").append(n).toString());
            return;
        }
        DdpInfoCollector.access$702(this.this$0, bl);
        DdpInfoCollector.access$100(this.this$0, this.this$0.isDdpRequired());
    }
}

