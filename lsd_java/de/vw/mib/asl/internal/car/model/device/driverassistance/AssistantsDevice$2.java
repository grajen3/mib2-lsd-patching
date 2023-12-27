/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.driverassistance;

import de.vw.mib.asl.api.car.vo.kombi.BCViewOptionsData;
import de.vw.mib.asl.api.car.vo.kombi.KombiViewOptionAdapter;
import de.vw.mib.asl.internal.car.model.device.driverassistance.AssistantsDevice;

class AssistantsDevice$2
extends KombiViewOptionAdapter {
    private final /* synthetic */ AssistantsDevice this$0;

    AssistantsDevice$2(AssistantsDevice assistantsDevice) {
        this.this$0 = assistantsDevice;
    }

    @Override
    public void updateBCViewOptions(BCViewOptionsData bCViewOptionsData, int n) {
        this.this$0.bcViewOptions = bCViewOptionsData;
        this.this$0.bcRestriction = n;
        this.this$0.bcReceived = true;
        this.this$0.evaluateVzeVzaViewOptions();
    }

    @Override
    public void updateBCDevice(int n) {
        this.this$0.bcRestriction = n;
        this.this$0.bcReceived = true;
        this.this$0.evaluateVzeVzaDevice();
    }
}

