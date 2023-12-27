/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl;

import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.EsoPosProviderFullProxy;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.sConfigSerializer;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sConfig;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;

class EsoPosProviderFullProxy$1
implements ISerializable {
    private final /* synthetic */ sConfig val$config;
    private final /* synthetic */ EsoPosProviderFullProxy this$0;

    EsoPosProviderFullProxy$1(EsoPosProviderFullProxy esoPosProviderFullProxy, sConfig sConfig2) {
        this.this$0 = esoPosProviderFullProxy;
        this.val$config = sConfig2;
    }

    @Override
    public void serialize(ISerializer iSerializer) {
        sConfigSerializer.putOptionalsConfig(iSerializer, this.val$config);
    }
}

