/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2BluetoothDiagServiceReplyProxy$6
implements ISerializable {
    private final /* synthetic */ long val$msg_id;
    private final /* synthetic */ MMX2BluetoothDiagServiceReplyProxy this$0;

    MMX2BluetoothDiagServiceReplyProxy$6(MMX2BluetoothDiagServiceReplyProxy mMX2BluetoothDiagServiceReplyProxy, long l) {
        this.this$0 = mMX2BluetoothDiagServiceReplyProxy;
        this.val$msg_id = l;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt32(this.val$msg_id);
    }
}

