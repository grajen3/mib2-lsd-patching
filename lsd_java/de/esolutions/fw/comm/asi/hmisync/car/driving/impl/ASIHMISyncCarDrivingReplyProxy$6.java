/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.driving.impl;

import de.esolutions.fw.comm.asi.hmisync.car.driving.impl.ASIHMISyncCarDrivingReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarDrivingReplyProxy$6
implements ISerializable {
    private final /* synthetic */ float val$TADCurrentRollAngle;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarDrivingReplyProxy this$0;

    ASIHMISyncCarDrivingReplyProxy$6(ASIHMISyncCarDrivingReplyProxy aSIHMISyncCarDrivingReplyProxy, float f2, boolean bl) {
        this.this$0 = aSIHMISyncCarDrivingReplyProxy;
        this.val$TADCurrentRollAngle = f2;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putFloat(this.val$TADCurrentRollAngle);
        iSerializer.putBool(this.val$isValid);
    }
}

