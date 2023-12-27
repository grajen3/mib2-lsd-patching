/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaBrowserReplyProxy$2
implements ISerializable {
    private final /* synthetic */ boolean val$successful;
    private final /* synthetic */ ASIHMISyncMediaBrowserReplyProxy this$0;

    ASIHMISyncMediaBrowserReplyProxy$2(ASIHMISyncMediaBrowserReplyProxy aSIHMISyncMediaBrowserReplyProxy, boolean bl) {
        this.this$0 = aSIHMISyncMediaBrowserReplyProxy;
        this.val$successful = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putBool(this.val$successful);
    }
}

