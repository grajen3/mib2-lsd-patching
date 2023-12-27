/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.system;

import de.vw.mib.asl.internal.impl.system.VehicleStatesListenerAdapter;
import de.vw.mib.asl.internal.impl.system.VelocityThresholdServiceImpl;

class VelocityThresholdServiceImpl$3
extends VehicleStatesListenerAdapter {
    private final /* synthetic */ VelocityThresholdServiceImpl this$0;

    VelocityThresholdServiceImpl$3(VelocityThresholdServiceImpl velocityThresholdServiceImpl) {
        this.this$0 = velocityThresholdServiceImpl;
    }

    @Override
    public void updateDestinationInputVelocityThreshold(boolean bl, int n) {
        if (this.this$0.isThresholdExceeded() == bl) {
            return;
        }
        this.this$0.setThreadholdExceeded(bl);
        this.this$0.fireVelocityExceedanceChanged(bl);
    }
}

