/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdisConfigProvider.impl;

import de.esolutions.fw.comm.asi.sdisConfigProvider.impl.SdisConfigProviderReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class SdisConfigProviderReplyProxy$1
implements ISerializable {
    private final /* synthetic */ int val$key;
    private final /* synthetic */ long val$value;
    private final /* synthetic */ SdisConfigProviderReplyProxy this$0;

    SdisConfigProviderReplyProxy$1(SdisConfigProviderReplyProxy sdisConfigProviderReplyProxy, int n, long l) {
        this.this$0 = sdisConfigProviderReplyProxy;
        this.val$key = n;
        this.val$value = l;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putInt32(this.val$key);
        iSerializer.putUInt32(this.val$value);
    }
}

