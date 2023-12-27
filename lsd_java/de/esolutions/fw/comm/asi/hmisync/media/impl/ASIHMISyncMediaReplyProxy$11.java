/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaPlaylistState;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaPlaylistStateSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaReplyProxy$11
implements ISerializable {
    private final /* synthetic */ MediaPlaylistState val$ListState;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncMediaReplyProxy this$0;

    ASIHMISyncMediaReplyProxy$11(ASIHMISyncMediaReplyProxy aSIHMISyncMediaReplyProxy, MediaPlaylistState mediaPlaylistState, boolean bl) {
        this.this$0 = aSIHMISyncMediaReplyProxy;
        this.val$ListState = mediaPlaylistState;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        MediaPlaylistStateSerializer.putOptionalMediaPlaylistState(iSerializer, this.val$ListState);
        iSerializer.putBool(this.val$isValid);
    }
}

