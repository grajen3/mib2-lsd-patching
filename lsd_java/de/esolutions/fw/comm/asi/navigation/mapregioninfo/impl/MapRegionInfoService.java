/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl;

import de.esolutions.fw.comm.asi.navigation.mapregioninfo.MapRegionInfoS;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl.MapRegionInfoReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.comm.dsi.global.impl.NavRectangleSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;

public class MapRegionInfoService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.navigation.mapregioninfo.MapRegionInfo");
    private MapRegionInfoS p_MapRegionInfo;

    public MapRegionInfoService(int n, MapRegionInfoS mapRegionInfoS) {
        super(new ServiceInstanceID("3beb5497-ae2a-4128-9f05-6068d21ac40f", n, "f203c2e7-a0c6-56da-ae80-1a6f30666d1f", "asi.navigation.mapregioninfo.MapRegionInfo"));
        this.p_MapRegionInfo = mapRegionInfoS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new MapRegionInfoReplyProxy();
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
                    NavLocationWgs84 navLocationWgs84 = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
                    int n = iDeserializer.getUInt16();
                    this.p_MapRegionInfo.requestGetDatabaseInfo(navLocationWgs84, n, (MapRegionInfoReplyProxy)iProxyFrontend);
                    break;
                }
                case 4: {
                    NavLocationWgs84[] navLocationWgs84Array = NavLocationWgs84Serializer.getOptionalNavLocationWgs84VarArray(iDeserializer);
                    int n = iDeserializer.getUInt16();
                    this.p_MapRegionInfo.requestGetMultipleDatabaseInfo(navLocationWgs84Array, n, (MapRegionInfoReplyProxy)iProxyFrontend);
                    break;
                }
                case 6: {
                    NavRectangle navRectangle = NavRectangleSerializer.getOptionalNavRectangle(iDeserializer);
                    int n = iDeserializer.getUInt16();
                    this.p_MapRegionInfo.requestGetRegionsInVicinity(navRectangle, n, (MapRegionInfoReplyProxy)iProxyFrontend);
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

