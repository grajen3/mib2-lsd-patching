/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.comm.dsi.caraircondition.impl.AirconNozzleListRecordSerializer;
import de.esolutions.fw.comm.dsi.caraircondition.impl.DSICarAirConditionProxy;
import de.esolutions.fw.comm.dsi.global.impl.CarArrayListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconNozzleListRecord;
import org.dsi.ifc.global.CarArrayListUpdateInfo;

class DSICarAirConditionProxy$11
implements ISerializable {
    private final /* synthetic */ int val$row;
    private final /* synthetic */ CarArrayListUpdateInfo val$info;
    private final /* synthetic */ AirconNozzleListRecord[] val$data;
    private final /* synthetic */ DSICarAirConditionProxy this$0;

    DSICarAirConditionProxy$11(DSICarAirConditionProxy dSICarAirConditionProxy, int n, CarArrayListUpdateInfo carArrayListUpdateInfo, AirconNozzleListRecord[] airconNozzleListRecordArray) {
        this.this$0 = dSICarAirConditionProxy;
        this.val$row = n;
        this.val$info = carArrayListUpdateInfo;
        this.val$data = airconNozzleListRecordArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$row);
        CarArrayListUpdateInfoSerializer.putOptionalCarArrayListUpdateInfo(iSerializer, this.val$info);
        AirconNozzleListRecordSerializer.putOptionalAirconNozzleListRecordVarArray(iSerializer, this.val$data);
    }
}

