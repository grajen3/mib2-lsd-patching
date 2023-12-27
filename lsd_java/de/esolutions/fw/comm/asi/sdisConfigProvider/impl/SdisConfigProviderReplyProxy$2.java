/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdisConfigProvider.impl;

import de.esolutions.fw.comm.asi.sdisConfigProvider.impl.SdisConfigProviderReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class SdisConfigProviderReplyProxy$2
implements ISerializable {
    private final /* synthetic */ String val$ASIVersion;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ SdisConfigProviderReplyProxy this$0;

    SdisConfigProviderReplyProxy$2(SdisConfigProviderReplyProxy sdisConfigProviderReplyProxy, String string, boolean bl) {
        this.this$0 = sdisConfigProviderReplyProxy;
        this.val$ASIVersion = string;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$ASIVersion);
        iSerializer.putBool(this.val$isValid);
    }
}

