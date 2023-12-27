/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio.impl;

import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncAudioReplyProxy$1
implements ISerializable {
    private final /* synthetic */ int val$resultCode;
    private final /* synthetic */ ASIHMISyncAudioReplyProxy this$0;

    ASIHMISyncAudioReplyProxy$1(ASIHMISyncAudioReplyProxy aSIHMISyncAudioReplyProxy, int n) {
        this.this$0 = aSIHMISyncAudioReplyProxy;
        this.val$resultCode = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$resultCode);
    }
}

