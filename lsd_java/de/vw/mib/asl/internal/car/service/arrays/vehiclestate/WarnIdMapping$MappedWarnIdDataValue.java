/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.service.arrays.vehiclestate;

import de.vw.mib.asl.internal.car.service.arrays.vehiclestate.WarnIdMapping;
import de.vw.mib.asl.internal.car.service.arrays.vehiclestate.WarnIdMapping$MappedWarnIdData;

class WarnIdMapping$MappedWarnIdDataValue
implements WarnIdMapping$MappedWarnIdData {
    final int warnId;
    final String iconImagePath;
    final int iconColor;
    final int componentId;
    final int componentColor;
    private final /* synthetic */ WarnIdMapping this$0;

    public WarnIdMapping$MappedWarnIdDataValue(WarnIdMapping warnIdMapping, int n, String string, int n2, int n3, int n4) {
        this.this$0 = warnIdMapping;
        this.warnId = n;
        this.iconImagePath = string;
        this.iconColor = n2;
        this.componentId = n3;
        this.componentColor = n4;
    }

    @Override
    public int getWarnId() {
        return this.warnId;
    }

    @Override
    public String getIconImagePath() {
        return this.iconImagePath;
    }

    @Override
    public int getIconColor() {
        return this.iconColor;
    }

    @Override
    public int getComponentId() {
        return this.componentId;
    }

    @Override
    public int getComponentColor() {
        return this.componentColor;
    }
}

