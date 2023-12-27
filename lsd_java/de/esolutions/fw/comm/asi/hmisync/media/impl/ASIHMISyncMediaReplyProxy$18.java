/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.MediaPlayTime;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaPlayTimeSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMediaReplyProxy$18
implements ISerializable {
    private final /* synthetic */ MediaPlayTime val$PlayPosition;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncMediaReplyProxy this$0;

    ASIHMISyncMediaReplyProxy$18(ASIHMISyncMediaReplyProxy aSIHMISyncMediaReplyProxy, MediaPlayTime mediaPlayTime, boolean bl) {
        this.this$0 = aSIHMISyncMediaReplyProxy;
        this.val$PlayPosition = mediaPlayTime;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        MediaPlayTimeSerializer.putOptionalMediaPlayTime(iSerializer, this.val$PlayPosition);
        iSerializer.putBool(this.val$isValid);
    }
}

