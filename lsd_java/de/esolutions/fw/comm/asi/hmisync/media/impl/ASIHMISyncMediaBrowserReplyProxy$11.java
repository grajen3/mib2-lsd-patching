/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaEntrySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaBrowserReplyProxy$11
implements ISerializable {
    private final /* synthetic */ MediaEntry[] val$BrowseFolder;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncMediaBrowserReplyProxy this$0;

    ASIHMISyncMediaBrowserReplyProxy$11(ASIHMISyncMediaBrowserReplyProxy aSIHMISyncMediaBrowserReplyProxy, MediaEntry[] mediaEntryArray, boolean bl) {
        this.this$0 = aSIHMISyncMediaBrowserReplyProxy;
        this.val$BrowseFolder = mediaEntryArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        MediaEntrySerializer.putOptionalMediaEntryVarArray(iSerializer, this.val$BrowseFolder);
        iSerializer.putBool(this.val$isValid);
    }
}

