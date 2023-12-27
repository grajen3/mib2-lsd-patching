/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2WlanDiagServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2WlanDiagServiceReplyProxy$2
implements ISerializable {
    private final /* synthetic */ long val$msg_id;
    private final /* synthetic */ boolean val$active;
    private final /* synthetic */ MMX2WlanDiagServiceReplyProxy this$0;

    MMX2WlanDiagServiceReplyProxy$2(MMX2WlanDiagServiceReplyProxy mMX2WlanDiagServiceReplyProxy, long l, boolean bl) {
        this.this$0 = mMX2WlanDiagServiceReplyProxy;
        this.val$msg_id = l;
        this.val$active = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt32(this.val$msg_id);
        iSerializer.putBool(this.val$active);
    }
}

