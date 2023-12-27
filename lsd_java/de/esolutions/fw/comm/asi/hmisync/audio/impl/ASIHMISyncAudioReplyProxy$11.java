/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio.impl;

import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncAudioReplyProxy$11
implements ISerializable {
    private final /* synthetic */ int val$AudibleState;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncAudioReplyProxy this$0;

    ASIHMISyncAudioReplyProxy$11(ASIHMISyncAudioReplyProxy aSIHMISyncAudioReplyProxy, int n, boolean bl) {
        this.this$0 = aSIHMISyncAudioReplyProxy;
        this.val$AudibleState = n;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$AudibleState);
        iSerializer.putBool(this.val$isValid);
    }
}

