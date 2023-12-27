/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.voiceencoder.impl;

import de.esolutions.fw.comm.asi.speech.voiceencoder.impl.VoiceEncoderReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class VoiceEncoderReplyProxy$1
implements ISerializable {
    private final /* synthetic */ int val$res;
    private final /* synthetic */ long val$chunkSizeAvail;
    private final /* synthetic */ VoiceEncoderReplyProxy this$0;

    VoiceEncoderReplyProxy$1(VoiceEncoderReplyProxy voiceEncoderReplyProxy, int n, long l) {
        this.this$0 = voiceEncoderReplyProxy;
        this.val$res = n;
        this.val$chunkSizeAvail = l;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$res);
        iSerializer.putUInt32(this.val$chunkSizeAvail);
    }
}

