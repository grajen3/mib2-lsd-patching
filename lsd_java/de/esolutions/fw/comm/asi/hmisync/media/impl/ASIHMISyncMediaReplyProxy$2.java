/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaEntrySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaReplyProxy$2
implements ISerializable {
    private final /* synthetic */ boolean val$success;
    private final /* synthetic */ int val$index;
    private final /* synthetic */ MediaEntry[] val$list;
    private final /* synthetic */ ASIHMISyncMediaReplyProxy this$0;

    ASIHMISyncMediaReplyProxy$2(ASIHMISyncMediaReplyProxy aSIHMISyncMediaReplyProxy, boolean bl, int n, MediaEntry[] mediaEntryArray) {
        this.this$0 = aSIHMISyncMediaReplyProxy;
        this.val$success = bl;
        this.val$index = n;
        this.val$list = mediaEntryArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putBool(this.val$success);
        iSerializer.putInt32(this.val$index);
        MediaEntrySerializer.putOptionalMediaEntryVarArray(iSerializer, this.val$list);
    }
}

