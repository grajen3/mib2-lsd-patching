/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy;
import de.esolutions.fw.comm.dsi.global.impl.CarArrayListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

class DSICarAirConditionProxy$10
implements ISerializable {
    private final /* synthetic */ int val$row;
    private final /* synthetic */ CarArrayListUpdateInfo val$info;
    private final /* synthetic */ DSICarAirConditionProxy this$0;

    DSICarAirConditionProxy$10(DSICarAirConditionProxy dSICarAirConditionProxy, int n, CarArrayListUpdateInfo carArrayListUpdateInfo) {
        this.this$0 = dSICarAirConditionProxy;
        this.val$row = n;
        this.val$info = carArrayListUpdateInfo;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$row);
        CarArrayListUpdateInfoSerializer.putOptionalCarArrayListUpdateInfo(iSerializer, this.val$info);
    }
}

