/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncTVReplyProxy$6
implements ISerializable {
    private final /* synthetic */ long val$ActiveTVStationState;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncTVReplyProxy this$0;

    ASIHMISyncTVReplyProxy$6(ASIHMISyncTVReplyProxy aSIHMISyncTVReplyProxy, long l, boolean bl) {
        this.this$0 = aSIHMISyncTVReplyProxy;
        this.val$ActiveTVStationState = l;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt64(this.val$ActiveTVStationState);
        iSerializer.putBool(this.val$isValid);
    }
}

