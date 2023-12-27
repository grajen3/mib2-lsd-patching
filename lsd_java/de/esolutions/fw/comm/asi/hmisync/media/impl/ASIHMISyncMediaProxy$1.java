/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaBrowserSelectionData;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaProxy;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaBrowserSelectionDataSerializer;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaSourceSlotSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaProxy$1
implements ISerializable {
    private final /* synthetic */ MediaSourceSlot val$slot;
    private final /* synthetic */ MediaBrowserSelectionData val$selectionData;
    private final /* synthetic */ ASIHMISyncMediaProxy this$0;

    ASIHMISyncMediaProxy$1(ASIHMISyncMediaProxy aSIHMISyncMediaProxy, MediaSourceSlot mediaSourceSlot, MediaBrowserSelectionData mediaBrowserSelectionData) {
        this.this$0 = aSIHMISyncMediaProxy;
        this.val$slot = mediaSourceSlot;
        this.val$selectionData = mediaBrowserSelectionData;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        MediaSourceSlotSerializer.putOptionalMediaSourceSlot(iSerializer, this.val$slot);
        MediaBrowserSelectionDataSerializer.putOptionalMediaBrowserSelectionData(iSerializer, this.val$selectionData);
    }
}

