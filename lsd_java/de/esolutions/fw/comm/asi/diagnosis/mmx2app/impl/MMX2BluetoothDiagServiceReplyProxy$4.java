/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2BluetoothDiagServiceReplyProxy$4
implements ISerializable {
    private final /* synthetic */ long val$msg_id;
    private final /* synthetic */ short val$whichLastPaired;
    private final /* synthetic */ MMX2BluetoothDiagServiceReplyProxy this$0;

    MMX2BluetoothDiagServiceReplyProxy$4(MMX2BluetoothDiagServiceReplyProxy mMX2BluetoothDiagServiceReplyProxy, long l, short s) {
        this.this$0 = mMX2BluetoothDiagServiceReplyProxy;
        this.val$msg_id = l;
        this.val$whichLastPaired = s;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt32(this.val$msg_id);
        iSerializer.putUInt8(this.val$whichLastPaired);
    }
}

