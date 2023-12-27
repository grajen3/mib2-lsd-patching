/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio.impl;

import de.esolutions.fw.comm.asi.hmisync.audio.A2LSState;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.A2LSStateSerializer;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncAudioReplyProxy$8
implements ISerializable {
    private final /* synthetic */ A2LSState val$A2LSState;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncAudioReplyProxy this$0;

    ASIHMISyncAudioReplyProxy$8(ASIHMISyncAudioReplyProxy aSIHMISyncAudioReplyProxy, A2LSState a2LSState, boolean bl) {
        this.this$0 = aSIHMISyncAudioReplyProxy;
        this.val$A2LSState = a2LSState;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        A2LSStateSerializer.putOptionalA2LSState(iSerializer, this.val$A2LSState);
        iSerializer.putBool(this.val$isValid);
    }
}

