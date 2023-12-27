/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.sound.impl;

import de.esolutions.fw.comm.asi.hmisync.sound.impl.ASIHMISyncSoundReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncSoundReplyProxy$22
implements ISerializable {
    private final /* synthetic */ int val$PresetPositionList;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncSoundReplyProxy this$0;

    ASIHMISyncSoundReplyProxy$22(ASIHMISyncSoundReplyProxy aSIHMISyncSoundReplyProxy, int n, boolean bl) {
        this.this$0 = aSIHMISyncSoundReplyProxy;
        this.val$PresetPositionList = n;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$PresetPositionList);
        iSerializer.putBool(this.val$isValid);
    }
}

