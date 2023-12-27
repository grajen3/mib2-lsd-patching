/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaReplyProxy$3
implements ISerializable {
    private final /* synthetic */ boolean val$successful;
    private final /* synthetic */ ASIHMISyncMediaReplyProxy this$0;

    ASIHMISyncMediaReplyProxy$3(ASIHMISyncMediaReplyProxy aSIHMISyncMediaReplyProxy, boolean bl) {
        this.this$0 = aSIHMISyncMediaReplyProxy;
        this.val$successful = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putBool(this.val$successful);
    }
}

