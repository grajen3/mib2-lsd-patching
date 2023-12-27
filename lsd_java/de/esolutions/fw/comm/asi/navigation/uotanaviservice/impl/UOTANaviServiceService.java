/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.uotanaviservice.impl;

import de.esolutions.fw.comm.asi.navigation.mapregioninfo.ComponentInfo;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl.ComponentInfoSerializer;
import de.esolutions.fw.comm.asi.navigation.uotanaviservice.UOTANaviServiceS;
import de.esolutions.fw.comm.asi.navigation.uotanaviservice.impl.UOTANaviServiceReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class UOTANaviServiceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.navigation.uotanaviservice.UOTANaviService");
    private UOTANaviServiceS p_UOTANaviService;

    public UOTANaviServiceService(int n, UOTANaviServiceS uOTANaviServiceS) {
        super(new ServiceInstanceID("761c5633-4d14-4d62-9410-2cefd2161346", n, "4530e019-1027-5e9c-a559-78a464b914fe", "asi.navigation.uotanaviservice.UOTANaviService"));
        this.p_UOTANaviService = uOTANaviServiceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new UOTANaviServiceReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 1: {
                    int n = iDeserializer.getEnum();
                    this.p_UOTANaviService.registerClient(n, (UOTANaviServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    short s2 = iDeserializer.getInt16();
                    ComponentInfo[] componentInfoArray = ComponentInfoSerializer.getOptionalComponentInfoVarArray(iDeserializer);
                    int n = iDeserializer.getEnum();
                    this.p_UOTANaviService.respondVersionInfo(s2, componentInfoArray, n, (UOTANaviServiceReplyProxy)iProxyFrontend);
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

