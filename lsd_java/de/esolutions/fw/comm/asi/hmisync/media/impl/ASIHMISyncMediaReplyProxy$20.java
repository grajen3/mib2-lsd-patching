/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaReplyProxy$20
implements ISerializable {
    private final /* synthetic */ int val$PlaybackPossible;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncMediaReplyProxy this$0;

    ASIHMISyncMediaReplyProxy$20(ASIHMISyncMediaReplyProxy aSIHMISyncMediaReplyProxy, int n, boolean bl) {
        this.this$0 = aSIHMISyncMediaReplyProxy;
        this.val$PlaybackPossible = n;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$PlaybackPossible);
        iSerializer.putBool(this.val$isValid);
    }
}

