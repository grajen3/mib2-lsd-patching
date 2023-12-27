/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.api.system.proximity.ProximityListener;
import de.vw.mib.asl.api.system.proximity.ProximityService;
import de.vw.mib.asl.internal.system.AslTargetSystemPowerManagementHandling;

class AslTargetSystemPowerManagementHandling$4
implements ProximityListener {
    private final /* synthetic */ ProximityService val$proximityService;
    private final /* synthetic */ AslTargetSystemPowerManagementHandling this$0;

    AslTargetSystemPowerManagementHandling$4(AslTargetSystemPowerManagementHandling aslTargetSystemPowerManagementHandling, ProximityService proximityService) {
        this.this$0 = aslTargetSystemPowerManagementHandling;
        this.val$proximityService = proximityService;
        this.onUserInteractionProximityChanged(this.val$proximityService.getCurrentUserInteractionState());
    }

    @Override
    public void onUserInteractionProximityChanged(boolean bl) {
        if (bl) {
            this.this$0.putDisplayAwake(4);
        } else {
            this.this$0.putDisplayAsleep(4);
        }
    }

    @Override
    public void onProximityChanged(boolean bl) {
    }
}

