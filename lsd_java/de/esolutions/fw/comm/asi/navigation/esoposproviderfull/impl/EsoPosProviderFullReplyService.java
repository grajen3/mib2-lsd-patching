/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl;

import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.EsoPosProviderFullReply;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.sConfigSerializer;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.sMapPositionSerializer;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.sPositionSerializer;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sConfig;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sMapPosition;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sPosition;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class EsoPosProviderFullReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.navigation.esoposproviderfull.EsoPosProviderFull");
    private static int dynamicHandle = 0;
    private EsoPosProviderFullReply p_EsoPosProviderFullReply;

    public EsoPosProviderFullReplyService(EsoPosProviderFullReply esoPosProviderFullReply) {
        super(new ServiceInstanceID("4325a74a-4251-11e3-9bb9-000c29e68a4a", EsoPosProviderFullReplyService.nextDynamicHandle(), "995a4140-c7f3-5205-8335-d13059867b08", "asi.navigation.esoposproviderfull.EsoPosProviderFull"));
        this.p_EsoPosProviderFullReply = esoPosProviderFullReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 21: {
                    boolean bl = iDeserializer.getBool();
                    sConfig sConfig2 = sConfigSerializer.getOptionalsConfig(iDeserializer);
                    int n = iDeserializer.getEnum();
                    this.p_EsoPosProviderFullReply.updateState(bl, sConfig2, n);
                    break;
                }
                case 25: {
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    sMapPosition sMapPosition2 = sMapPositionSerializer.getOptionalsMapPosition(iDeserializer);
                    sPosition[] sPositionArray = sPositionSerializer.getOptionalsPositionVarArray(iDeserializer);
                    this.p_EsoPosProviderFullReply.updatePosition(stringArray, sMapPosition2, sPositionArray);
                    break;
                }
                case 19: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_EsoPosProviderFullReply.updateASIVersion(string, bl);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

