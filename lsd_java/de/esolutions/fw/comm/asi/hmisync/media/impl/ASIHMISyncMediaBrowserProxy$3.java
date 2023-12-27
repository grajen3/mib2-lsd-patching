/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserProxy;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaEntrySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaBrowserProxy$3
implements ISerializable {
    private final /* synthetic */ int val$selectionType;
    private final /* synthetic */ MediaEntry val$folder;
    private final /* synthetic */ ASIHMISyncMediaBrowserProxy this$0;

    ASIHMISyncMediaBrowserProxy$3(ASIHMISyncMediaBrowserProxy aSIHMISyncMediaBrowserProxy, int n, MediaEntry mediaEntry) {
        this.this$0 = aSIHMISyncMediaBrowserProxy;
        this.val$selectionType = n;
        this.val$folder = mediaEntry;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$selectionType);
        MediaEntrySerializer.putOptionalMediaEntry(iSerializer, this.val$folder);
    }
}

