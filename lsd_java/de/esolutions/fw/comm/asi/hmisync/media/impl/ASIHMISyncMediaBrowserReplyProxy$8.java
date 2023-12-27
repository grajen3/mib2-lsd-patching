/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaBrowserReplyProxy$8
implements ISerializable {
    private final /* synthetic */ int val$BrowseMode;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncMediaBrowserReplyProxy this$0;

    ASIHMISyncMediaBrowserReplyProxy$8(ASIHMISyncMediaBrowserReplyProxy aSIHMISyncMediaBrowserReplyProxy, int n, boolean bl) {
        this.this$0 = aSIHMISyncMediaBrowserReplyProxy;
        this.val$BrowseMode = n;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$BrowseMode);
        iSerializer.putBool(this.val$isValid);
    }
}

