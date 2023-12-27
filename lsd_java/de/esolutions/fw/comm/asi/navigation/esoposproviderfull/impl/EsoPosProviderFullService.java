/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl;

import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.EsoPosProviderFullReply;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.EsoPosProviderFullS;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.EsoPosProviderFullReplyProxy;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.sConfigSerializer;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sConfig;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class EsoPosProviderFullService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.navigation.esoposproviderfull.EsoPosProviderFull");
    private EsoPosProviderFullS p_EsoPosProviderFull;

    public EsoPosProviderFullService(int n, EsoPosProviderFullS esoPosProviderFullS) {
        super(new ServiceInstanceID("3a8ac390-4251-11e3-9434-000c29e68a4a", n, "2c5da29e-82ab-5b99-8f06-68cfdd97c847", "asi.navigation.esoposproviderfull.EsoPosProviderFull"));
        this.p_EsoPosProviderFull = esoPosProviderFullS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new EsoPosProviderFullReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 8: {
                    boolean bl = iDeserializer.getBool();
                    this.p_EsoPosProviderFull.setActive(bl, (EsoPosProviderFullReplyProxy)iProxyFrontend);
                    break;
                }
                case 15: {
                    sConfig sConfig2 = sConfigSerializer.getOptionalsConfig(iDeserializer);
                    this.p_EsoPosProviderFull.setConfig(sConfig2, (EsoPosProviderFullReplyProxy)iProxyFrontend);
                    break;
                }
                case 16: {
                    this.p_EsoPosProviderFull.setNotification((EsoPosProviderFullReplyProxy)iProxyFrontend);
                    break;
                }
                case 18: {
                    long l = iDeserializer.getUInt32();
                    this.p_EsoPosProviderFull.setNotification(l, (EsoPosProviderFullReply)((EsoPosProviderFullReplyProxy)iProxyFrontend));
                    break;
                }
                case 17: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_EsoPosProviderFull.setNotification(lArray, (EsoPosProviderFullReply)((EsoPosProviderFullReplyProxy)iProxyFrontend));
                    break;
                }
                case 12: {
                    this.p_EsoPosProviderFull.clearNotification((EsoPosProviderFullReplyProxy)iProxyFrontend);
                    break;
                }
                case 14: {
                    long l = iDeserializer.getUInt32();
                    this.p_EsoPosProviderFull.clearNotification(l, (EsoPosProviderFullReply)((EsoPosProviderFullReplyProxy)iProxyFrontend));
                    break;
                }
                case 13: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_EsoPosProviderFull.clearNotification(lArray, (EsoPosProviderFullReply)((EsoPosProviderFullReplyProxy)iProxyFrontend));
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

