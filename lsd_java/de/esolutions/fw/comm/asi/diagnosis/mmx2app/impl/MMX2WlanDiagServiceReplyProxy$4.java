/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2WlanDiagServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2WlanDiagServiceReplyProxy$4
implements ISerializable {
    private final /* synthetic */ long val$msg_id;
    private final /* synthetic */ boolean val$active;
    private final /* synthetic */ String val$ssid;
    private final /* synthetic */ String val$password;
    private final /* synthetic */ int val$encMode;
    private final /* synthetic */ MMX2WlanDiagServiceReplyProxy this$0;

    MMX2WlanDiagServiceReplyProxy$4(MMX2WlanDiagServiceReplyProxy mMX2WlanDiagServiceReplyProxy, long l, boolean bl, String string, String string2, int n) {
        this.this$0 = mMX2WlanDiagServiceReplyProxy;
        this.val$msg_id = l;
        this.val$active = bl;
        this.val$ssid = string;
        this.val$password = string2;
        this.val$encMode = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt32(this.val$msg_id);
        iSerializer.putBool(this.val$active);
        iSerializer.putOptionalString(this.val$ssid);
        iSerializer.putOptionalString(this.val$password);
        iSerializer.putEnum(this.val$encMode);
    }
}

