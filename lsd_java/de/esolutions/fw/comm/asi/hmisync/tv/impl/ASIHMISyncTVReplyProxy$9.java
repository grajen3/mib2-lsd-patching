/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncTVReplyProxy$9
implements ISerializable {
    private final /* synthetic */ byte val$SeekStatus;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncTVReplyProxy this$0;

    ASIHMISyncTVReplyProxy$9(ASIHMISyncTVReplyProxy aSIHMISyncTVReplyProxy, byte by, boolean bl) {
        this.this$0 = aSIHMISyncTVReplyProxy;
        this.val$SeekStatus = by;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt8(this.val$SeekStatus);
        iSerializer.putBool(this.val$isValid);
    }
}

