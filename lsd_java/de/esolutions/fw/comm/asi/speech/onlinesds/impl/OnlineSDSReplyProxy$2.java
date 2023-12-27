/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds.impl;

import de.esolutions.fw.comm.asi.speech.onlinesds.AudioData;
import de.esolutions.fw.comm.asi.speech.onlinesds.impl.AudioDataSerializer;
import de.esolutions.fw.comm.asi.speech.onlinesds.impl.OnlineSDSReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class OnlineSDSReplyProxy$2
implements ISerializable {
    private final /* synthetic */ int val$sessionId;
    private final /* synthetic */ int val$dataState;
    private final /* synthetic */ AudioData val$data;
    private final /* synthetic */ OnlineSDSReplyProxy this$0;

    OnlineSDSReplyProxy$2(OnlineSDSReplyProxy onlineSDSReplyProxy, int n, int n2, AudioData audioData) {
        this.this$0 = onlineSDSReplyProxy;
        this.val$sessionId = n;
        this.val$dataState = n2;
        this.val$data = audioData;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt16(this.val$sessionId);
        iSerializer.putEnum(this.val$dataState);
        AudioDataSerializer.putOptionalAudioData(iSerializer, this.val$data);
    }
}

