/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl;

import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.EsoPosProviderFullReplyProxy;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.sConfigSerializer;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sConfig;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class EsoPosProviderFullReplyProxy$1
implements ISerializable {
    private final /* synthetic */ boolean val$active;
    private final /* synthetic */ sConfig val$config;
    private final /* synthetic */ int val$state;
    private final /* synthetic */ EsoPosProviderFullReplyProxy this$0;

    EsoPosProviderFullReplyProxy$1(EsoPosProviderFullReplyProxy esoPosProviderFullReplyProxy, boolean bl, sConfig sConfig2, int n) {
        this.this$0 = esoPosProviderFullReplyProxy;
        this.val$active = bl;
        this.val$config = sConfig2;
        this.val$state = n;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        iSerializer.putBool(this.val$active);
        sConfigSerializer.putOptionalsConfig(iSerializer, this.val$config);
        iSerializer.putEnum(this.val$state);
    }
}

