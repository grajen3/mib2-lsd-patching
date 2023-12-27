/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2BluetoothDiagServiceReplyProxy$9
implements ISerializable {
    private final /* synthetic */ long val$msg_id;
    private final /* synthetic */ int val$action;
    private final /* synthetic */ int val$option;
    private final /* synthetic */ MMX2BluetoothDiagServiceReplyProxy this$0;

    MMX2BluetoothDiagServiceReplyProxy$9(MMX2BluetoothDiagServiceReplyProxy mMX2BluetoothDiagServiceReplyProxy, long l, int n, int n2) {
        this.this$0 = mMX2BluetoothDiagServiceReplyProxy;
        this.val$msg_id = l;
        this.val$action = n;
        this.val$option = n2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt32(this.val$msg_id);
        iSerializer.putEnum(this.val$action);
        iSerializer.putEnum(this.val$option);
    }
}

