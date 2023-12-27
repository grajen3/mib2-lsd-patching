/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl;

import de.esolutions.fw.comm.asi.navigation.mapregioninfo.ComponentInfo;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.MapRegionInfoReply;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl.ComponentInfoSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MapRegionInfoReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.navigation.mapregioninfo.MapRegionInfo");
    private static int dynamicHandle = 0;
    private MapRegionInfoReply p_MapRegionInfoReply;

    public MapRegionInfoReplyService(MapRegionInfoReply mapRegionInfoReply) {
        super(new ServiceInstanceID("f6ed3bd2-c174-4a4c-a99f-5ca2e73a72e5", MapRegionInfoReplyService.nextDynamicHandle(), "ea59591a-319c-5eba-8c59-1bc981eda986", "asi.navigation.mapregioninfo.MapRegionInfo"));
        this.p_MapRegionInfoReply = mapRegionInfoReply;
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
                case 0: {
                    int n = iDeserializer.getUInt16();
                    ComponentInfo componentInfo = ComponentInfoSerializer.getOptionalComponentInfo(iDeserializer);
                    int n2 = iDeserializer.getEnum();
                    this.p_MapRegionInfoReply.replyGetDatabaseInfo(n, componentInfo, n2);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getUInt16();
                    ComponentInfo[] componentInfoArray = ComponentInfoSerializer.getOptionalComponentInfoVarArray(iDeserializer);
                    int n3 = iDeserializer.getEnum();
                    this.p_MapRegionInfoReply.replyGetMultipleDatabaseInfo(n, componentInfoArray, n3);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getUInt16();
                    ComponentInfo[] componentInfoArray = ComponentInfoSerializer.getOptionalComponentInfoVarArray(iDeserializer);
                    int n4 = iDeserializer.getEnum();
                    this.p_MapRegionInfoReply.replyGetRegionsInVicinity(n, componentInfoArray, n4);
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

