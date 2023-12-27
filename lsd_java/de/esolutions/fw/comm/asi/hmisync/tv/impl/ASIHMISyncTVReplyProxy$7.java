/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncTVReplyProxy$7
implements ISerializable {
    private final /* synthetic */ long val$TunerConfig;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncTVReplyProxy this$0;

    ASIHMISyncTVReplyProxy$7(ASIHMISyncTVReplyProxy aSIHMISyncTVReplyProxy, long l, boolean bl) {
        this.this$0 = aSIHMISyncTVReplyProxy;
        this.val$TunerConfig = l;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt64(this.val$TunerConfig);
        iSerializer.putBool(this.val$isValid);
    }
}

