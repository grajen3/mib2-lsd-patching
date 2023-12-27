/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.internal.system.AslTargetSystemGeneral;
import de.vw.mib.asl.internal.system.DsiGeneralVehicleStatesListenerAdapter;

class AslTargetSystemGeneral$5
extends DsiGeneralVehicleStatesListenerAdapter {
    private final /* synthetic */ AslTargetSystemGeneral this$0;

    AslTargetSystemGeneral$5(AslTargetSystemGeneral aslTargetSystemGeneral) {
        this.this$0 = aslTargetSystemGeneral;
    }

    @Override
    public void updateDisplayDayNightDesign(boolean bl, int n) {
        if (n == 1) {
            this.this$0.dsiGeneralVehicleStatesUpdateDisplayDayNightDesign(bl);
        }
    }
}

