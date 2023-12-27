/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OlsDiagServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2OlsDiagServiceReplyProxy$2
implements ISerializable {
    private final /* synthetic */ long val$msg_id;
    private final /* synthetic */ MMX2OlsDiagServiceReplyProxy this$0;

    MMX2OlsDiagServiceReplyProxy$2(MMX2OlsDiagServiceReplyProxy mMX2OlsDiagServiceReplyProxy, long l) {
        this.this$0 = mMX2OlsDiagServiceReplyProxy;
        this.val$msg_id = l;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt32(this.val$msg_id);
    }
}

