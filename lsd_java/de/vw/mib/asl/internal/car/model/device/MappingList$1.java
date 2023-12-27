/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model.device;

import de.vw.mib.asl.api.car.vo.CarFunctionState;
import de.vw.mib.asl.internal.car.model.device.MappingList;
import org.dsi.ifc.global.CarViewOption;

class MappingList$1
implements CarFunctionState {
    private final /* synthetic */ CarViewOption val$vo;
    private final /* synthetic */ MappingList this$0;

    MappingList$1(MappingList mappingList, CarViewOption carViewOption) {
        this.this$0 = mappingList;
        this.val$vo = carViewOption;
    }

    @Override
    public int getState() {
        return this.val$vo.getState();
    }

    @Override
    public int getAvailableReason() {
        return this.val$vo.getReason();
    }
}

