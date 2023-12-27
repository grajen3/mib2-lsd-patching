/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.generic.impl;

import de.esolutions.fw.comm.asi.hmisync.generic.impl.ASIHMISyncGenericReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncGenericReplyProxy$4
implements ISerializable {
    private final /* synthetic */ short[] val$ReplyIDs;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncGenericReplyProxy this$0;

    ASIHMISyncGenericReplyProxy$4(ASIHMISyncGenericReplyProxy aSIHMISyncGenericReplyProxy, short[] sArray, boolean bl) {
        this.this$0 = aSIHMISyncGenericReplyProxy;
        this.val$ReplyIDs = sArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalInt16VarArray(this.val$ReplyIDs);
        iSerializer.putBool(this.val$isValid);
    }
}

