/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.NavPriceInfoSerializer;
import de.esolutions.fw.comm.dsi.global.impl.NavRectangleSerializer;
import de.esolutions.fw.comm.dsi.navigation.DSICombinedRouteListReply;
import de.esolutions.fw.comm.dsi.navigation.impl.CombinedRouteListElementSerializer;
import de.esolutions.fw.comm.dsi.navigation.impl.NavPoiInfoSerializer;
import de.esolutions.fw.comm.dsi.tmc.impl.TmcMessageSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavPriceInfo;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.tmc.TmcMessage;

public class DSICombinedRouteListReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.navigation.DSICombinedRouteList");
    private static int dynamicHandle = 0;
    private DSICombinedRouteListReply p_DSICombinedRouteListReply;

    public DSICombinedRouteListReplyService(DSICombinedRouteListReply dSICombinedRouteListReply) {
        super(new ServiceInstanceID("fc4f32e5-c610-5f8f-b354-15f3e219f8d2", DSICombinedRouteListReplyService.nextDynamicHandle(), "643fcaa1-9066-5b01-b59d-a05810f472eb", "dsi.navigation.DSICombinedRouteList"));
        this.p_DSICombinedRouteListReply = dSICombinedRouteListReply;
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
                case 16: {
                    int n = iDeserializer.getInt32();
                    this.p_DSICombinedRouteListReply.windowChanged(n);
                    break;
                }
                case 29: {
                    long l = iDeserializer.getInt64();
                    CombinedRouteListElement[] combinedRouteListElementArray = CombinedRouteListElementSerializer.getOptionalCombinedRouteListElementVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICombinedRouteListReply.combinedRouteListResult(l, combinedRouteListElementArray, n);
                    break;
                }
                case 34: {
                    TmcMessage tmcMessage = TmcMessageSerializer.getOptionalTmcMessage(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICombinedRouteListReply.trafficInformationResult(tmcMessage, n);
                    break;
                }
                case 28: {
                    NavPoiInfo navPoiInfo = NavPoiInfoSerializer.getOptionalNavPoiInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICombinedRouteListReply.poiInformationResult(navPoiInfo, n);
                    break;
                }
                case 15: {
                    long l = iDeserializer.getInt64();
                    long l2 = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSICombinedRouteListReply.updateElementsTotal(l, l2, n);
                    break;
                }
                case 33: {
                    long[] lArray = iDeserializer.getOptionalInt64VarArray();
                    NavRectangle navRectangle = NavRectangleSerializer.getOptionalNavRectangle(iDeserializer);
                    this.p_DSICombinedRouteListReply.getBoundingRectangleOfCombinedRouteListElementsResult(lArray, navRectangle);
                    break;
                }
                case 31: {
                    NavPriceInfo navPriceInfo = NavPriceInfoSerializer.getOptionalNavPriceInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICombinedRouteListReply.requestPriceInfoResult(navPriceInfo, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSICombinedRouteListReply.asyncException(n, string, n2);
                    break;
                }
                case 17: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSICombinedRouteListReply.yyIndication(string, string2);
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

