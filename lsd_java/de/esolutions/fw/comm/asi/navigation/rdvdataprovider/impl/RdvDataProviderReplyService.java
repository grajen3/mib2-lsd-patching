/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl;

import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RdvDataProviderReply;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RouteProviderSetting;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RouteProviderSettingSerializer;
import de.esolutions.fw.comm.asi.navigation.rdvtypes.RdvRouteOptions;
import de.esolutions.fw.comm.asi.navigation.rdvtypes.impl.RdvRouteOptionsSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavLocationWgs84;

public class RdvDataProviderReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.navigation.rdvdataprovider.RdvDataProvider");
    private static int dynamicHandle = 0;
    private RdvDataProviderReply p_RdvDataProviderReply;

    public RdvDataProviderReplyService(RdvDataProviderReply rdvDataProviderReply) {
        super(new ServiceInstanceID("3ee92857-84ba-4dfa-9faf-1d67977f4b5d", RdvDataProviderReplyService.nextDynamicHandle(), "0b921357-9ff8-587c-9c54-67ccfc58e880", "asi.navigation.rdvdataprovider.RdvDataProvider"));
        this.p_RdvDataProviderReply = rdvDataProviderReply;
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
                case 3: {
                    int n = iDeserializer.getEnum();
                    this.p_RdvDataProviderReply.registerForDataUpdateResult(n);
                    break;
                }
                case 5: {
                    int n = iDeserializer.getEnum();
                    this.p_RdvDataProviderReply.unregisterForDataUpdateResult(n);
                    break;
                }
                case 8: {
                    boolean bl = iDeserializer.getBool();
                    this.p_RdvDataProviderReply.updateDemoModeStatus(bl);
                    break;
                }
                case 9: {
                    boolean bl = iDeserializer.getBool();
                    this.p_RdvDataProviderReply.updateRouteGuidanceStatus(bl);
                    break;
                }
                case 10: {
                    RdvRouteOptions rdvRouteOptions = RdvRouteOptionsSerializer.getOptionalRdvRouteOptions(iDeserializer);
                    this.p_RdvDataProviderReply.updateCurrentRouteOptions(rdvRouteOptions);
                    break;
                }
                case 6: {
                    NavLocationWgs84[] navLocationWgs84Array = NavLocationWgs84Serializer.getOptionalNavLocationWgs84VarArray(iDeserializer);
                    this.p_RdvDataProviderReply.updateCurrentRoute(navLocationWgs84Array);
                    break;
                }
                case 11: {
                    NavLocationWgs84[] navLocationWgs84Array = NavLocationWgs84Serializer.getOptionalNavLocationWgs84VarArray(iDeserializer);
                    this.p_RdvDataProviderReply.updateStopovers(navLocationWgs84Array);
                    break;
                }
                case 13: {
                    RouteProviderSetting routeProviderSetting = RouteProviderSettingSerializer.getOptionalRouteProviderSetting(iDeserializer);
                    int n = iDeserializer.getEnum();
                    this.p_RdvDataProviderReply.setRouteProviderSettingResult(routeProviderSetting, n);
                    break;
                }
                case 1: {
                    NavLocationWgs84 navLocationWgs84 = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
                    this.p_RdvDataProviderReply.getCurrentPositionResult(navLocationWgs84);
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

