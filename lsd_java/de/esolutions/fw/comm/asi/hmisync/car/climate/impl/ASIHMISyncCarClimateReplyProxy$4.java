/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.climate.impl;

import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.climate.impl.ASIHMISyncCarClimateReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.car.impl.IntBaseTypeSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarClimateReplyProxy$4
implements ISerializable {
    private final /* synthetic */ IntBaseType val$AirconTempZone1;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarClimateReplyProxy this$0;

    ASIHMISyncCarClimateReplyProxy$4(ASIHMISyncCarClimateReplyProxy aSIHMISyncCarClimateReplyProxy, IntBaseType intBaseType, boolean bl) {
        this.this$0 = aSIHMISyncCarClimateReplyProxy;
        this.val$AirconTempZone1 = intBaseType;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        IntBaseTypeSerializer.putOptionalIntBaseType(iSerializer, this.val$AirconTempZone1);
        iSerializer.putBool(this.val$isValid);
    }
}

