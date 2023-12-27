/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.climate.impl;

import de.esolutions.fw.comm.asi.hmisync.car.climate.impl.ASIHMISyncCarClimateReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarClimateReplyProxy$6
implements ISerializable {
    private final /* synthetic */ boolean val$AirconMaxAC;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarClimateReplyProxy this$0;

    ASIHMISyncCarClimateReplyProxy$6(ASIHMISyncCarClimateReplyProxy aSIHMISyncCarClimateReplyProxy, boolean bl, boolean bl2) {
        this.this$0 = aSIHMISyncCarClimateReplyProxy;
        this.val$AirconMaxAC = bl;
        this.val$isValid = bl2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putBool(this.val$AirconMaxAC);
        iSerializer.putBool(this.val$isValid);
    }
}

