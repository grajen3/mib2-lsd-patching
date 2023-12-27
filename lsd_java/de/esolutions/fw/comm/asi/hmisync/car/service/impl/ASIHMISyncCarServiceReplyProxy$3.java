/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service.impl;

import de.esolutions.fw.comm.asi.hmisync.car.service.impl.ASIHMISyncCarServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncCarServiceReplyProxy$3
implements ISerializable {
    private final /* synthetic */ short[] val$ReplyIDs;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncCarServiceReplyProxy this$0;

    ASIHMISyncCarServiceReplyProxy$3(ASIHMISyncCarServiceReplyProxy aSIHMISyncCarServiceReplyProxy, short[] sArray, boolean bl) {
        this.this$0 = aSIHMISyncCarServiceReplyProxy;
        this.val$ReplyIDs = sArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalInt16VarArray(this.val$ReplyIDs);
        iSerializer.putBool(this.val$isValid);
    }
}

