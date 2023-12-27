/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerRouteBlockReply;
import de.esolutions.fw.comm.dsi.map.impl.PointSerializer;
import de.esolutions.fw.comm.dsi.map.impl.RouteBrowserInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.RouteBrowserInfo;

public class DSIMapViewerRouteBlockReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.map.DSIMapViewerRouteBlock");
    private static int dynamicHandle = 0;
    private DSIMapViewerRouteBlockReply p_DSIMapViewerRouteBlockReply;

    public DSIMapViewerRouteBlockReplyService(DSIMapViewerRouteBlockReply dSIMapViewerRouteBlockReply) {
        super(new ServiceInstanceID("e35a4736-beb5-5ae2-b7ef-1987f635d39c", DSIMapViewerRouteBlockReplyService.nextDynamicHandle(), "6ffac28d-c4f7-5a0f-abce-6daaf18ea937", "dsi.map.DSIMapViewerRouteBlock"));
        this.p_DSIMapViewerRouteBlockReply = dSIMapViewerRouteBlockReply;
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
                case 18: {
                    RouteBrowserInfo routeBrowserInfo = RouteBrowserInfoSerializer.getOptionalRouteBrowserInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerRouteBlockReply.updateRBInfoOfSelectedSegments(routeBrowserInfo, n);
                    break;
                }
                case 7: {
                    Point point = PointSerializer.getOptionalPoint(iDeserializer);
                    int n = iDeserializer.getInt32();
                    long[] lArray = iDeserializer.getOptionalInt64VarArray();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIMapViewerRouteBlockReply.pickSegmentUidsInScreenSpaceResult(point, n, lArray, n2);
                    break;
                }
                case 5: {
                    long[] lArray = iDeserializer.getOptionalInt64VarArray();
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerRouteBlockReply.highLightSegmentUidsInMapResult(lArray, bl, n);
                    break;
                }
                case 14: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerRouteBlockReply.rBStartOfSelectionResult(l, n);
                    break;
                }
                case 9: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerRouteBlockReply.rBMarkNextSegmentResult(l, n);
                    break;
                }
                case 11: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerRouteBlockReply.rBMarkPreviousSegmentResult(l, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIMapViewerRouteBlockReply.asyncException(n, string, n3);
                    break;
                }
                case 19: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIMapViewerRouteBlockReply.yyIndication(string, string2);
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

