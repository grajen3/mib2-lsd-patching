/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.driverassistance;

import de.vw.mib.asl.api.car.vo.eco.EAViewOptionsData;
import de.vw.mib.asl.api.car.vo.eco.EcoViewOptionAdapter;
import de.vw.mib.asl.internal.car.model.device.driverassistance.AssistantsDevice;

class AssistantsDevice$3
extends EcoViewOptionAdapter {
    private final /* synthetic */ AssistantsDevice this$0;

    AssistantsDevice$3(AssistantsDevice assistantsDevice) {
        this.this$0 = assistantsDevice;
    }

    @Override
    public void updateEAViewOptions(EAViewOptionsData eAViewOptionsData, int n) {
        this.this$0.mappingList.add(31, eAViewOptionsData.getSystem(), n);
        this.this$0.updateModel();
    }

    @Override
    public void updateEADevice(int n) {
        this.this$0.mappingList.add(31, n);
        this.this$0.updateModel();
    }
}

