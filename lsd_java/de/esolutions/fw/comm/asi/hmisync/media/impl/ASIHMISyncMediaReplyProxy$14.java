/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaReplyProxy$14
implements ISerializable {
    private final /* synthetic */ boolean val$RepeatTitle;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncMediaReplyProxy this$0;

    ASIHMISyncMediaReplyProxy$14(ASIHMISyncMediaReplyProxy aSIHMISyncMediaReplyProxy, boolean bl, boolean bl2) {
        this.this$0 = aSIHMISyncMediaReplyProxy;
        this.val$RepeatTitle = bl;
        this.val$isValid = bl2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putBool(this.val$RepeatTitle);
        iSerializer.putBool(this.val$isValid);
    }
}

