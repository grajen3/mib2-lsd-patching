/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.sound.impl;

import de.esolutions.fw.comm.asi.hmisync.sound.SoundRange;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.SoundRangeSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncSoundReplyProxy$6
implements ISerializable {
    private final /* synthetic */ SoundRange val$BassRange;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncSoundReplyProxy this$0;

    ASIHMISyncSoundReplyProxy$6(ASIHMISyncSoundReplyProxy aSIHMISyncSoundReplyProxy, SoundRange soundRange, boolean bl) {
        this.this$0 = aSIHMISyncSoundReplyProxy;
        this.val$BassRange = soundRange;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        SoundRangeSerializer.putOptionalSoundRange(iSerializer, this.val$BassRange);
        iSerializer.putBool(this.val$isValid);
    }
}

