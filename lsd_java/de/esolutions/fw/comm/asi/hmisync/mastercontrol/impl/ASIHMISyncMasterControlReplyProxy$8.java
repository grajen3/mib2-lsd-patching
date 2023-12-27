/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl;

import de.esolutions.fw.comm.asi.hmisync.mastercontrol.impl.ASIHMISyncMasterControlReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class ASIHMISyncMasterControlReplyProxy$8
implements ISerializable {
    private final /* synthetic */ int val$LockState;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ ASIHMISyncMasterControlReplyProxy this$0;

    ASIHMISyncMasterControlReplyProxy$8(ASIHMISyncMasterControlReplyProxy aSIHMISyncMasterControlReplyProxy, int n, boolean bl) {
        this.this$0 = aSIHMISyncMasterControlReplyProxy;
        this.val$LockState = n;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$LockState);
        iSerializer.putBool(this.val$isValid);
    }
}

