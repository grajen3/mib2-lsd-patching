/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.internal.system.AslTargetSystemVehicleStates;
import de.vw.mib.asl.internal.system.DsiGeneralVehicleStatesListenerAdapter;

class AslTargetSystemVehicleStates$5
extends DsiGeneralVehicleStatesListenerAdapter {
    private final /* synthetic */ AslTargetSystemVehicleStates this$0;

    AslTargetSystemVehicleStates$5(AslTargetSystemVehicleStates aslTargetSystemVehicleStates) {
        this.this$0 = aslTargetSystemVehicleStates;
    }

    @Override
    public void updateBrowserSlideShowVelocityThreshold(boolean bl, int n) {
        if (n == 1) {
            this.this$0.dsiGeneralVehicleStatesUpdateBrowserSlideShowVelocityThreshold(bl);
        }
    }

    @Override
    public void updateBrowserWebVelocityThreshold(boolean bl, int n) {
        if (n == 1) {
            this.this$0.dsiGeneralVehicleStatesUpdateBrowserWebVelocityThreshold(bl);
        }
    }

    @Override
    public void updateBTBondingVelocityThreshold(boolean bl, int n) {
        if (n == 1) {
            this.this$0.dsiGeneralVehicleStatesUpdateBTBondingVelocityThreshold(bl);
        }
    }

    @Override
    public void updateDestinationInputVelocityThreshold(boolean bl, int n) {
        if (n == 1) {
            this.this$0.dsiGeneralVehicleStatesUpdateDestinationInputVelocityThreshold(bl);
        }
    }

    @Override
    public void updateMessagingVelocityThreshold(boolean bl, int n) {
        if (n == 1) {
            this.this$0.dsiGeneralVehicleStatesUpdateMessagingVelocityThreshold(bl);
        }
    }

    @Override
    public void updateRadiotextVelocityThreshold(boolean bl, int n) {
        if (n == 1) {
            this.this$0.dsiGeneralVehicleStatesUpdateRadiotextVelocityThreshold(bl);
        }
    }

    @Override
    public void updateTVVelocityThreshold(boolean bl, int n) {
        if (n == 1) {
            this.this$0.dsiGeneralVehicleStatesUpdateTVVelocityThreshold(bl, n);
        }
    }

    @Override
    public void updateVehicleStandstill(boolean bl, int n) {
        if (n == 1) {
            this.this$0.dsiGeneralVehicleStatesUpdateVehicleStandstill(bl, n);
        }
    }
}

