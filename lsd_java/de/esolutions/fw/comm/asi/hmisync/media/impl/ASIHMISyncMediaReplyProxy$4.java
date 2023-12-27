/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaReplyProxy$4
implements ISerializable {
    private final /* synthetic */ long val$entryId;
    private final /* synthetic */ int val$category;
    private final /* synthetic */ int val$resultcode;
    private final /* synthetic */ ASIHMISyncMediaReplyProxy this$0;

    ASIHMISyncMediaReplyProxy$4(ASIHMISyncMediaReplyProxy aSIHMISyncMediaReplyProxy, long l, int n, int n2) {
        this.this$0 = aSIHMISyncMediaReplyProxy;
        this.val$entryId = l;
        this.val$category = n;
        this.val$resultcode = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt64(this.val$entryId);
        iSerializer.putInt32(this.val$category);
        iSerializer.putInt32(this.val$resultcode);
    }
}

