/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaBrowserReplyProxy$10
implements ISerializable {
    private final /* synthetic */ boolean val$RawMode;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncMediaBrowserReplyProxy this$0;

    ASIHMISyncMediaBrowserReplyProxy$10(ASIHMISyncMediaBrowserReplyProxy aSIHMISyncMediaBrowserReplyProxy, boolean bl, boolean bl2) {
        this.this$0 = aSIHMISyncMediaBrowserReplyProxy;
        this.val$RawMode = bl;
        this.val$isValid = bl2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putBool(this.val$RawMode);
        iSerializer.putBool(this.val$isValid);
    }
}

