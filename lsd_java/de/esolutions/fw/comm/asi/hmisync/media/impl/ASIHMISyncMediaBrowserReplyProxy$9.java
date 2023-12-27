/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaBrowserReplyProxy$9
implements ISerializable {
    private final /* synthetic */ boolean val$DatabaseMode;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncMediaBrowserReplyProxy this$0;

    ASIHMISyncMediaBrowserReplyProxy$9(ASIHMISyncMediaBrowserReplyProxy aSIHMISyncMediaBrowserReplyProxy, boolean bl, boolean bl2) {
        this.this$0 = aSIHMISyncMediaBrowserReplyProxy;
        this.val$DatabaseMode = bl;
        this.val$isValid = bl2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putBool(this.val$DatabaseMode);
        iSerializer.putBool(this.val$isValid);
    }
}

