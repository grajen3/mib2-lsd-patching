/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaSourceSlotSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaReplyProxy$8
implements ISerializable {
    private final /* synthetic */ MediaSourceSlot[] val$SourceList;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncMediaReplyProxy this$0;

    ASIHMISyncMediaReplyProxy$8(ASIHMISyncMediaReplyProxy aSIHMISyncMediaReplyProxy, MediaSourceSlot[] mediaSourceSlotArray, boolean bl) {
        this.this$0 = aSIHMISyncMediaReplyProxy;
        this.val$SourceList = mediaSourceSlotArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        MediaSourceSlotSerializer.putOptionalMediaSourceSlotVarArray(iSerializer, this.val$SourceList);
        iSerializer.putBool(this.val$isValid);
    }
}

