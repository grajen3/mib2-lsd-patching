/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.driving.impl;

import de.esolutions.fw.comm.asi.hmisync.car.driving.TADVehicleInfo;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.TADVehicleInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarDrivingReplyProxy$4
implements ISerializable {
    private final /* synthetic */ TADVehicleInfo val$TADVehicleInfo;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarDrivingReplyProxy this$0;

    ASIHMISyncCarDrivingReplyProxy$4(ASIHMISyncCarDrivingReplyProxy aSIHMISyncCarDrivingReplyProxy, TADVehicleInfo tADVehicleInfo, boolean bl) {
        this.this$0 = aSIHMISyncCarDrivingReplyProxy;
        this.val$TADVehicleInfo = tADVehicleInfo;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        TADVehicleInfoSerializer.putOptionalTADVehicleInfo(iSerializer, this.val$TADVehicleInfo);
        iSerializer.putBool(this.val$isValid);
    }
}

