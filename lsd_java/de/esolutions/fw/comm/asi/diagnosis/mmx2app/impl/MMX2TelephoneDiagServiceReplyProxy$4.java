/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2TelephoneDiagServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2TelephoneDiagServiceReplyProxy$4
implements ISerializable {
    private final /* synthetic */ long val$msg_id;
    private final /* synthetic */ int val$handsetNumber;
    private final /* synthetic */ MMX2TelephoneDiagServiceReplyProxy this$0;

    MMX2TelephoneDiagServiceReplyProxy$4(MMX2TelephoneDiagServiceReplyProxy mMX2TelephoneDiagServiceReplyProxy, long l, int n) {
        this.this$0 = mMX2TelephoneDiagServiceReplyProxy;
        this.val$msg_id = l;
        this.val$handsetNumber = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt32(this.val$msg_id);
        iSerializer.putEnum(this.val$handsetNumber);
    }
}

