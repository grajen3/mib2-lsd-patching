/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaActiveSourceState;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaActiveSourceStateSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaReplyProxy$9
implements ISerializable {
    private final /* synthetic */ MediaActiveSourceState val$ActiveSlotState;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncMediaReplyProxy this$0;

    ASIHMISyncMediaReplyProxy$9(ASIHMISyncMediaReplyProxy aSIHMISyncMediaReplyProxy, MediaActiveSourceState mediaActiveSourceState, boolean bl) {
        this.this$0 = aSIHMISyncMediaReplyProxy;
        this.val$ActiveSlotState = mediaActiveSourceState;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        MediaActiveSourceStateSerializer.putOptionalMediaActiveSourceState(iSerializer, this.val$ActiveSlotState);
        iSerializer.putBool(this.val$isValid);
    }
}

