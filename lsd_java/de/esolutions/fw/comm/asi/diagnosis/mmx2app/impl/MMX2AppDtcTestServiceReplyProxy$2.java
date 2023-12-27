/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2AppDtcTestServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2AppDtcTestServiceReplyProxy$2
implements ISerializable {
    private final /* synthetic */ long val$internalDtc;
    private final /* synthetic */ MMX2AppDtcTestServiceReplyProxy this$0;

    MMX2AppDtcTestServiceReplyProxy$2(MMX2AppDtcTestServiceReplyProxy mMX2AppDtcTestServiceReplyProxy, long l) {
        this.this$0 = mMX2AppDtcTestServiceReplyProxy;
        this.val$internalDtc = l;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putUInt32(this.val$internalDtc);
    }
}

