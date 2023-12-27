/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaReplyProxy$13
implements ISerializable {
    private final /* synthetic */ boolean val$Mix;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncMediaReplyProxy this$0;

    ASIHMISyncMediaReplyProxy$13(ASIHMISyncMediaReplyProxy aSIHMISyncMediaReplyProxy, boolean bl, boolean bl2) {
        this.this$0 = aSIHMISyncMediaReplyProxy;
        this.val$Mix = bl;
        this.val$isValid = bl2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putBool(this.val$Mix);
        iSerializer.putBool(this.val$isValid);
    }
}

