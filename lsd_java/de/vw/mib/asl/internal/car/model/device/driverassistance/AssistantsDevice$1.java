/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.driverassistance;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.internal.car.model.device.driverassistance.AssistantsDevice;

class AssistantsDevice$1
implements CarFunctionState {
    private final /* synthetic */ AssistantsDevice this$0;

    AssistantsDevice$1(AssistantsDevice assistantsDevice) {
        this.this$0 = assistantsDevice;
    }

    @Override
    public int getState() {
        return 0;
    }

    @Override
    public int getAvailableReason() {
        return 0;
    }
}

