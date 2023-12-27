/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserProxy;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaEntrySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaBrowserProxy$2
implements ISerializable {
    private final /* synthetic */ MediaEntry[] val$folderStack;
    private final /* synthetic */ ASIHMISyncMediaBrowserProxy this$0;

    ASIHMISyncMediaBrowserProxy$2(ASIHMISyncMediaBrowserProxy aSIHMISyncMediaBrowserProxy, MediaEntry[] mediaEntryArray) {
        this.this$0 = aSIHMISyncMediaBrowserProxy;
        this.val$folderStack = mediaEntryArray;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        MediaEntrySerializer.putOptionalMediaEntryVarArray(iSerializer, this.val$folderStack);
    }
}

