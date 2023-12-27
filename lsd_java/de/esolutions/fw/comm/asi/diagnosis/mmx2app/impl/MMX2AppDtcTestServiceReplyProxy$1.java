/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2AppDtcTestServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2AppDtcTestServiceReplyProxy$1
implements ISerializable {
    private final /* synthetic */ int val$regStatus;
    private final /* synthetic */ MMX2AppDtcTestServiceReplyProxy this$0;

    MMX2AppDtcTestServiceReplyProxy$1(MMX2AppDtcTestServiceReplyProxy mMX2AppDtcTestServiceReplyProxy, int n) {
        this.this$0 = mMX2AppDtcTestServiceReplyProxy;
        this.val$regStatus = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putEnum(this.val$regStatus);
    }
}

