/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device.driverassistance;

import de.vw.mib.asl.api.car.vo.comfort.BrakeViewOptionsData;
import de.vw.mib.asl.api.car.vo.comfort.ComfortViewOptionAdapter;
import de.vw.mib.asl.api.car.vo.comfort.RGSViewOptionsData;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.car.model.FunctionState;
import de.vw.mib.asl.internal.car.model.MappingTable;
import de.vw.mib.asl.internal.car.model.device.driverassistance.AssistantsDevice;

class AssistantsDevice$4
extends ComfortViewOptionAdapter {
    private final /* synthetic */ AssistantsDevice this$0;

    AssistantsDevice$4(AssistantsDevice assistantsDevice) {
        this.this$0 = assistantsDevice;
    }

    @Override
    public void updateRGSViewOptions(RGSViewOptionsData rGSViewOptionsData, int n) {
        this.this$0.mappingList.add(33, rGSViewOptionsData.getPreCrashSystem(), n);
        this.this$0.updateModel();
    }

    @Override
    public void updateRGSDevice(int n) {
        this.this$0.mappingList.add(33, n);
        this.this$0.updateModel();
    }

    @Override
    public void updateBrakeViewOptions(BrakeViewOptionsData brakeViewOptionsData, int n) {
        if (n == 0) {
            this.this$0.updateStabilityProgramState(new FunctionState(brakeViewOptionsData.getBrakeEscMode().getState(), MappingTable.getModelValue(brakeViewOptionsData.getBrakeEscMode().getAvailableReason())));
            if (brakeViewOptionsData.isSystemType()) {
                ServiceManager.aslPropertyManager.valueChangedInteger(10846, 0);
            } else {
                ServiceManager.aslPropertyManager.valueChangedInteger(10846, 1);
            }
        } else {
            this.this$0.updateStabilityProgramState(new FunctionState(1, MappingTable.getModelValue(n)));
        }
    }

    @Override
    public void updateBrakeDevice(int n) {
        this.this$0.updateStabilityProgramState(new FunctionState(1, MappingTable.getModelValue(n)));
        this.this$0.updateModel();
    }
}

