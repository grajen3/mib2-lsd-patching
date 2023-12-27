/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OocDiagServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2OocDiagServiceReplyProxy$2
implements ISerializable {
    private final /* synthetic */ long val$msg_id;
    private final /* synthetic */ int val$action;
    private final /* synthetic */ MMX2OocDiagServiceReplyProxy this$0;

    MMX2OocDiagServiceReplyProxy$2(MMX2OocDiagServiceReplyProxy mMX2OocDiagServiceReplyProxy, long l, int n) {
        this.this$0 = mMX2OocDiagServiceReplyProxy;
        this.val$msg_id = l;
        this.val$action = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt32(this.val$msg_id);
        iSerializer.putEnum(this.val$action);
    }
}

