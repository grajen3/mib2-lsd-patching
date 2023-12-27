/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2MediaDiagServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2MediaDiagServiceReplyProxy$3
implements ISerializable {
    private final /* synthetic */ long val$msg_id;
    private final /* synthetic */ int val$terminalNumber;
    private final /* synthetic */ MMX2MediaDiagServiceReplyProxy this$0;

    MMX2MediaDiagServiceReplyProxy$3(MMX2MediaDiagServiceReplyProxy mMX2MediaDiagServiceReplyProxy, long l, int n) {
        this.this$0 = mMX2MediaDiagServiceReplyProxy;
        this.val$msg_id = l;
        this.val$terminalNumber = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt32(this.val$msg_id);
        iSerializer.putEnum(this.val$terminalNumber);
    }
}

