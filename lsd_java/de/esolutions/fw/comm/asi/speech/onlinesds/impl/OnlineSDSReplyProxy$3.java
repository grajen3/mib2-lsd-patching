/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.onlinesds.impl;

import de.esolutions.fw.comm.asi.speech.onlinesds.impl.OnlineSDSReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class OnlineSDSReplyProxy$3
implements ISerializable {
    private final /* synthetic */ int val$sessionId;
    private final /* synthetic */ OnlineSDSReplyProxy this$0;

    OnlineSDSReplyProxy$3(OnlineSDSReplyProxy onlineSDSReplyProxy, int n) {
        this.this$0 = onlineSDSReplyProxy;
        this.val$sessionId = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt16(this.val$sessionId);
    }
}

