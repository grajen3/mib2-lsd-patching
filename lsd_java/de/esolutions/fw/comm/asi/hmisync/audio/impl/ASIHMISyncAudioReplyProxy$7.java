/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio.impl;

import de.esolutions.fw.comm.asi.hmisync.audio.VolumeLockState;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.VolumeLockStateSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncAudioReplyProxy$7
implements ISerializable {
    private final /* synthetic */ VolumeLockState val$VolumeLockState;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncAudioReplyProxy this$0;

    ASIHMISyncAudioReplyProxy$7(ASIHMISyncAudioReplyProxy aSIHMISyncAudioReplyProxy, VolumeLockState volumeLockState, boolean bl) {
        this.this$0 = aSIHMISyncAudioReplyProxy;
        this.val$VolumeLockState = volumeLockState;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        VolumeLockStateSerializer.putOptionalVolumeLockState(iSerializer, this.val$VolumeLockState);
        iSerializer.putBool(this.val$isValid);
    }
}

