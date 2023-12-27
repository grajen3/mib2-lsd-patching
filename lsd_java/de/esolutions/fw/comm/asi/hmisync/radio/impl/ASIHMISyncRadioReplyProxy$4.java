/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio.impl;

import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncRadioReplyProxy$4
implements ISerializable {
    private final /* synthetic */ short[] val$ReplyIDs;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncRadioReplyProxy this$0;

    ASIHMISyncRadioReplyProxy$4(ASIHMISyncRadioReplyProxy aSIHMISyncRadioReplyProxy, short[] sArray, boolean bl) {
        this.this$0 = aSIHMISyncRadioReplyProxy;
        this.val$ReplyIDs = sArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalInt16VarArray(this.val$ReplyIDs);
        iSerializer.putBool(this.val$isValid);
    }
}

