/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaEntrySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaReplyProxy$19
implements ISerializable {
    private final /* synthetic */ MediaEntry[] val$PlaybackFolder;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncMediaReplyProxy this$0;

    ASIHMISyncMediaReplyProxy$19(ASIHMISyncMediaReplyProxy aSIHMISyncMediaReplyProxy, MediaEntry[] mediaEntryArray, boolean bl) {
        this.this$0 = aSIHMISyncMediaReplyProxy;
        this.val$PlaybackFolder = mediaEntryArray;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        MediaEntrySerializer.putOptionalMediaEntryVarArray(iSerializer, this.val$PlaybackFolder);
        iSerializer.putBool(this.val$isValid);
    }
}

