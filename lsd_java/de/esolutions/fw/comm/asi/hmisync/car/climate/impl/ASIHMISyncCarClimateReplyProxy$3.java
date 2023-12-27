/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.climate.impl;

import de.esolutions.fw.comm.asi.hmisync.car.climate.impl.ASIHMISyncCarClimateReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarClimateReplyProxy$3
implements ISerializable {
    private final /* synthetic */ short[] val$ReplyIDs;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarClimateReplyProxy this$0;

    ASIHMISyncCarClimateReplyProxy$3(ASIHMISyncCarClimateReplyProxy aSIHMISyncCarClimateReplyProxy, short[] sArray, boolean bl) {
        this.this$0 = aSIHMISyncCarClimateReplyProxy;
        this.val$ReplyIDs = sArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalInt16VarArray(this.val$ReplyIDs);
        iSerializer.putBool(this.val$isValid);
    }
}

