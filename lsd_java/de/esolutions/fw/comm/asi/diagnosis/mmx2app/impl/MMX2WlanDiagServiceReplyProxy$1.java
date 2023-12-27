/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2WlanDiagServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2WlanDiagServiceReplyProxy$1
implements ISerializable {
    private final /* synthetic */ long val$msg_id;
    private final /* synthetic */ MMX2WlanDiagServiceReplyProxy this$0;

    MMX2WlanDiagServiceReplyProxy$1(MMX2WlanDiagServiceReplyProxy mMX2WlanDiagServiceReplyProxy, long l) {
        this.this$0 = mMX2WlanDiagServiceReplyProxy;
        this.val$msg_id = l;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt32(this.val$msg_id);
    }
}

