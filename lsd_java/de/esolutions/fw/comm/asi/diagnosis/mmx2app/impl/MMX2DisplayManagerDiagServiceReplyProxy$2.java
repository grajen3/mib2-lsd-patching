/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2DisplayManagerDiagServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2DisplayManagerDiagServiceReplyProxy$2
implements ISerializable {
    private final /* synthetic */ long val$msg_id;
    private final /* synthetic */ int val$action;
    private final /* synthetic */ int val$input;
    private final /* synthetic */ short val$display;
    private final /* synthetic */ MMX2DisplayManagerDiagServiceReplyProxy this$0;

    MMX2DisplayManagerDiagServiceReplyProxy$2(MMX2DisplayManagerDiagServiceReplyProxy mMX2DisplayManagerDiagServiceReplyProxy, long l, int n, int n2, short s) {
        this.this$0 = mMX2DisplayManagerDiagServiceReplyProxy;
        this.val$msg_id = l;
        this.val$action = n;
        this.val$input = n2;
        this.val$display = s;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt32(this.val$msg_id);
        iSerializer.putEnum(this.val$action);
        iSerializer.putEnum(this.val$input);
        iSerializer.putUInt8(this.val$display);
    }
}

