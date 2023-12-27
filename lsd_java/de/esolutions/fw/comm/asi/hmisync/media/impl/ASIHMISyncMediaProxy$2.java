/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaBrowserSelectionData;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaProxy;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaBrowserSelectionDataSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaProxy$2
implements ISerializable {
    private final /* synthetic */ MediaBrowserSelectionData val$data;
    private final /* synthetic */ ASIHMISyncMediaProxy this$0;

    ASIHMISyncMediaProxy$2(ASIHMISyncMediaProxy aSIHMISyncMediaProxy, MediaBrowserSelectionData mediaBrowserSelectionData) {
        this.this$0 = aSIHMISyncMediaProxy;
        this.val$data = mediaBrowserSelectionData;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        MediaBrowserSelectionDataSerializer.putOptionalMediaBrowserSelectionData(iSerializer, this.val$data);
    }
}

