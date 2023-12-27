/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncTVReplyProxy$10
implements ISerializable {
    private final /* synthetic */ byte val$TerminalMode;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncTVReplyProxy this$0;

    ASIHMISyncTVReplyProxy$10(ASIHMISyncTVReplyProxy aSIHMISyncTVReplyProxy, byte by, boolean bl) {
        this.this$0 = aSIHMISyncTVReplyProxy;
        this.val$TerminalMode = by;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt8(this.val$TerminalMode);
        iSerializer.putBool(this.val$isValid);
    }
}

