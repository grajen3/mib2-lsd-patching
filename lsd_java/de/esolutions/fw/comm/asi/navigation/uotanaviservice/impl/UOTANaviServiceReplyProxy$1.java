/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.uotanaviservice.impl;

import de.esolutions.fw.comm.asi.navigation.uotanaviservice.impl.UOTANaviServiceReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class UOTANaviServiceReplyProxy$1
implements ISerializable {
    private final /* synthetic */ short val$uniqueId;
    private final /* synthetic */ UOTANaviServiceReplyProxy this$0;

    UOTANaviServiceReplyProxy$1(UOTANaviServiceReplyProxy uOTANaviServiceReplyProxy, short s) {
        this.this$0 = uOTANaviServiceReplyProxy;
        this.val$uniqueId = s;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt16(this.val$uniqueId);
    }
}

