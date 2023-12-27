/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaBrowserReplyProxy$4
implements ISerializable {
    private final /* synthetic */ String val$ASIVersion;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncMediaBrowserReplyProxy this$0;

    ASIHMISyncMediaBrowserReplyProxy$4(ASIHMISyncMediaBrowserReplyProxy aSIHMISyncMediaBrowserReplyProxy, String string, boolean bl) {
        this.this$0 = aSIHMISyncMediaBrowserReplyProxy;
        this.val$ASIVersion = string;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$ASIVersion);
        iSerializer.putBool(this.val$isValid);
    }
}

