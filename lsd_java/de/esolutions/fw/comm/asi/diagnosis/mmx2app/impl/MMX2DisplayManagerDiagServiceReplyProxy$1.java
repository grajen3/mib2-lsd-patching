/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2DisplayManagerDiagServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2DisplayManagerDiagServiceReplyProxy$1
implements ISerializable {
    private final /* synthetic */ long val$msg_id;
    private final /* synthetic */ MMX2DisplayManagerDiagServiceReplyProxy this$0;

    MMX2DisplayManagerDiagServiceReplyProxy$1(MMX2DisplayManagerDiagServiceReplyProxy mMX2DisplayManagerDiagServiceReplyProxy, long l) {
        this.this$0 = mMX2DisplayManagerDiagServiceReplyProxy;
        this.val$msg_id = l;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt32(this.val$msg_id);
    }
}

