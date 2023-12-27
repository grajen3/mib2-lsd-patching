/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2BluetoothDiagServiceReplyProxy$11
implements ISerializable {
    private final /* synthetic */ long val$msg_id;
    private final /* synthetic */ short val$ioControl;
    private final /* synthetic */ short val$controlState;
    private final /* synthetic */ MMX2BluetoothDiagServiceReplyProxy this$0;

    MMX2BluetoothDiagServiceReplyProxy$11(MMX2BluetoothDiagServiceReplyProxy mMX2BluetoothDiagServiceReplyProxy, long l, short s, short s2) {
        this.this$0 = mMX2BluetoothDiagServiceReplyProxy;
        this.val$msg_id = l;
        this.val$ioControl = s;
        this.val$controlState = s2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt32(this.val$msg_id);
        iSerializer.putUInt8(this.val$ioControl);
        iSerializer.putUInt8(this.val$controlState);
    }
}

