/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaReplyProxy$1
implements ISerializable {
    private final /* synthetic */ int val$reason;
    private final /* synthetic */ ASIHMISyncMediaReplyProxy this$0;

    ASIHMISyncMediaReplyProxy$1(ASIHMISyncMediaReplyProxy aSIHMISyncMediaReplyProxy, int n) {
        this.this$0 = aSIHMISyncMediaReplyProxy;
        this.val$reason = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$reason);
    }
}

