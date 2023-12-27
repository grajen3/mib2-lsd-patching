/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl;

import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RdvDataProviderS;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RouteProviderSetting;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RdvDataProviderReplyProxy;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RouteProviderSettingSerializer;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class RdvDataProviderService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.navigation.rdvdataprovider.RdvDataProvider");
    private RdvDataProviderS p_RdvDataProvider;

    public RdvDataProviderService(int n, RdvDataProviderS rdvDataProviderS) {
        super(new ServiceInstanceID("1c1707c0-995c-4af9-98c2-afe3399d33b6", n, "791334e8-3d42-5162-9439-61521595702c", "asi.navigation.rdvdataprovider.RdvDataProvider"));
        this.p_RdvDataProvider = rdvDataProviderS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new RdvDataProviderReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 2: {
                    this.p_RdvDataProvider.registerForDataUpdate((RdvDataProviderReplyProxy)iProxyFrontend);
                    break;
                }
                case 4: {
                    this.p_RdvDataProvider.unregisterForDataUpdate((RdvDataProviderReplyProxy)iProxyFrontend);
                    break;
                }
                case 12: {
                    RouteProviderSetting routeProviderSetting = RouteProviderSettingSerializer.getOptionalRouteProviderSetting(iDeserializer);
                    this.p_RdvDataProvider.setRouteProviderSetting(routeProviderSetting, (RdvDataProviderReplyProxy)iProxyFrontend);
                    break;
                }
                case 0: {
                    this.p_RdvDataProvider.getCurrentPosition((RdvDataProviderReplyProxy)iProxyFrontend);
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

