/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaSourceSlotSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaBrowserReplyProxy$7
implements ISerializable {
    private final /* synthetic */ MediaSourceSlot val$ActiveSlot;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncMediaBrowserReplyProxy this$0;

    ASIHMISyncMediaBrowserReplyProxy$7(ASIHMISyncMediaBrowserReplyProxy aSIHMISyncMediaBrowserReplyProxy, MediaSourceSlot mediaSourceSlot, boolean bl) {
        this.this$0 = aSIHMISyncMediaBrowserReplyProxy;
        this.val$ActiveSlot = mediaSourceSlot;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        MediaSourceSlotSerializer.putOptionalMediaSourceSlot(iSerializer, this.val$ActiveSlot);
        iSerializer.putBool(this.val$isValid);
    }
}

