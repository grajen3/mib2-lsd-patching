/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.internal.system.AslTargetSystemGeneral;
import de.vw.mib.asl.internal.system.DsiCarKombiListenerAdapter;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.global.CarBCTemperature;

class AslTargetSystemGeneral$7
extends DsiCarKombiListenerAdapter {
    private final /* synthetic */ AslTargetSystemGeneral this$0;

    AslTargetSystemGeneral$7(AslTargetSystemGeneral aslTargetSystemGeneral) {
        this.this$0 = aslTargetSystemGeneral;
    }

    @Override
    public void updateBCOutsideTemperature(CarBCTemperature carBCTemperature, int n) {
        if (n == 1) {
            this.this$0.dsiCarKombiUpdateBCOutsideTemperature(carBCTemperature);
        }
    }

    @Override
    public void updateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        if (n == 1) {
            this.this$0.dsiCarKombiUpdateBCViewOptions(bCViewOptions);
        }
    }
}

