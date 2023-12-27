/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio.impl;

import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncAudioReplyProxy$4
implements ISerializable {
    private final /* synthetic */ short[] val$ReplyIDs;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncAudioReplyProxy this$0;

    ASIHMISyncAudioReplyProxy$4(ASIHMISyncAudioReplyProxy aSIHMISyncAudioReplyProxy, short[] sArray, boolean bl) {
        this.this$0 = aSIHMISyncAudioReplyProxy;
        this.val$ReplyIDs = sArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalInt16VarArray(this.val$ReplyIDs);
        iSerializer.putBool(this.val$isValid);
    }
}

