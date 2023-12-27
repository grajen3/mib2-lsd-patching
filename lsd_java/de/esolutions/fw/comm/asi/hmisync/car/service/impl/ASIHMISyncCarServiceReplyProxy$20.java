/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.impl.FloatBaseTypeSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarServiceReplyProxy$20
implements ISerializable {
    private final /* synthetic */ FloatBaseType val$VehicleSpeed;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarServiceReplyProxy this$0;

    ASIHMISyncCarServiceReplyProxy$20(ASIHMISyncCarServiceReplyProxy aSIHMISyncCarServiceReplyProxy, FloatBaseType floatBaseType, boolean bl) {
        this.this$0 = aSIHMISyncCarServiceReplyProxy;
        this.val$VehicleSpeed = floatBaseType;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        FloatBaseTypeSerializer.putOptionalFloatBaseType(iSerializer, this.val$VehicleSpeed);
        iSerializer.putBool(this.val$isValid);
    }
}

