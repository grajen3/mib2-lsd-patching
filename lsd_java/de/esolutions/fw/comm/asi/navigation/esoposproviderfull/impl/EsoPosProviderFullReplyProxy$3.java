/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl;

import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.EsoPosProviderFullReplyProxy;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class EsoPosProviderFullReplyProxy$3
implements ISerializable {
    private final /* synthetic */ String val$ASIVersion;
    private final /* synthetic */ boolean val$isValid;
    private final /* synthetic */ EsoPosProviderFullReplyProxy this$0;

    EsoPosProviderFullReplyProxy$3(EsoPosProviderFullReplyProxy esoPosProviderFullReplyProxy, String string, boolean bl) {
        this.this$0 = esoPosProviderFullReplyProxy;
        this.val$ASIVersion = string;
        this.val$isValid = bl;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putOptionalString(this.val$ASIVersion);
        iSerializer.putBool(this.val$isValid);
    }
}

