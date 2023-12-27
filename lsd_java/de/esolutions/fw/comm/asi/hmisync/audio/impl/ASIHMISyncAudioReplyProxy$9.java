/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio.impl;

import de.esolutions.fw.comm.asi.hmisync.audio.VolumeRange;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.ASIHMISyncAudioReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.audio.impl.VolumeRangeSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncAudioReplyProxy$9
implements ISerializable {
    private final /* synthetic */ VolumeRange val$VolumeRange;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncAudioReplyProxy this$0;

    ASIHMISyncAudioReplyProxy$9(ASIHMISyncAudioReplyProxy aSIHMISyncAudioReplyProxy, VolumeRange volumeRange, boolean bl) {
        this.this$0 = aSIHMISyncAudioReplyProxy;
        this.val$VolumeRange = volumeRange;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        VolumeRangeSerializer.putOptionalVolumeRange(iSerializer, this.val$VolumeRange);
        iSerializer.putBool(this.val$isValid);
    }
}

