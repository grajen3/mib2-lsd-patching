/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaEntrySerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaReplyProxy$17
implements ISerializable {
    private final /* synthetic */ MediaEntry val$PlayingTrack;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncMediaReplyProxy this$0;

    ASIHMISyncMediaReplyProxy$17(ASIHMISyncMediaReplyProxy aSIHMISyncMediaReplyProxy, MediaEntry mediaEntry, boolean bl) {
        this.this$0 = aSIHMISyncMediaReplyProxy;
        this.val$PlayingTrack = mediaEntry;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        MediaEntrySerializer.putOptionalMediaEntry(iSerializer, this.val$PlayingTrack);
        iSerializer.putBool(this.val$isValid);
    }
}

