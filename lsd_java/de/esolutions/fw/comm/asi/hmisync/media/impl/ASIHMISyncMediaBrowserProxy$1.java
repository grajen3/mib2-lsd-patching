/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserProxy;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaSourceSlotSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaBrowserProxy$1
implements ISerializable {
    private final /* synthetic */ MediaSourceSlot val$slot;
    private final /* synthetic */ ASIHMISyncMediaBrowserProxy this$0;

    ASIHMISyncMediaBrowserProxy$1(ASIHMISyncMediaBrowserProxy aSIHMISyncMediaBrowserProxy, MediaSourceSlot mediaSourceSlot) {
        this.this$0 = aSIHMISyncMediaBrowserProxy;
        this.val$slot = mediaSourceSlot;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        MediaSourceSlotSerializer.putOptionalMediaSourceSlot(iSerializer, this.val$slot);
    }
}

