/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio.impl;

import de.esolutions.fw.comm.asi.hmisync.audio.AudioState;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.AudioStateSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncAudioReplyProxy$5
implements ISerializable {
    private final /* synthetic */ AudioState val$AudioContext;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncAudioReplyProxy this$0;

    ASIHMISyncAudioReplyProxy$5(ASIHMISyncAudioReplyProxy aSIHMISyncAudioReplyProxy, AudioState audioState, boolean bl) {
        this.this$0 = aSIHMISyncAudioReplyProxy;
        this.val$AudioContext = audioState;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        AudioStateSerializer.putOptionalAudioState(iSerializer, this.val$AudioContext);
        iSerializer.putBool(this.val$isValid);
    }
}

