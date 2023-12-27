/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sTestStatusSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sTestStatus;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2AppDtcTestServiceProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class MMX2AppDtcTestServiceProxy$1
implements ISerializable {
    private final /* synthetic */ sTestStatus val$status;
    private final /* synthetic */ MMX2AppDtcTestServiceProxy this$0;

    MMX2AppDtcTestServiceProxy$1(MMX2AppDtcTestServiceProxy mMX2AppDtcTestServiceProxy, sTestStatus sTestStatus2) {
        this.this$0 = mMX2AppDtcTestServiceProxy;
        this.val$status = sTestStatus2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sTestStatusSerializer.putOptionalsTestStatus(iSerializer, this.val$status);
    }
}

