/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaEntrySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaBrowserReplyProxy$3
implements ISerializable {
    private final /* synthetic */ boolean val$successful;
    private final /* synthetic */ int val$index;
    private final /* synthetic */ MediaEntry[] val$list;
    private final /* synthetic */ ASIHMISyncMediaBrowserReplyProxy this$0;

    ASIHMISyncMediaBrowserReplyProxy$3(ASIHMISyncMediaBrowserReplyProxy aSIHMISyncMediaBrowserReplyProxy, boolean bl, int n, MediaEntry[] mediaEntryArray) {
        this.this$0 = aSIHMISyncMediaBrowserReplyProxy;
        this.val$successful = bl;
        this.val$index = n;
        this.val$list = mediaEntryArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putBool(this.val$successful);
        iSerializer.putInt32(this.val$index);
        MediaEntrySerializer.putOptionalMediaEntryVarArray(iSerializer, this.val$list);
    }
}

