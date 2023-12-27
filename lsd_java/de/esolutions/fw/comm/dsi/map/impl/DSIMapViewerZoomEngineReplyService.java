/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerZoomEngineReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIMapViewerZoomEngineReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.map.DSIMapViewerZoomEngine");
    private static int dynamicHandle = 0;
    private DSIMapViewerZoomEngineReply p_DSIMapViewerZoomEngineReply;

    public DSIMapViewerZoomEngineReplyService(DSIMapViewerZoomEngineReply dSIMapViewerZoomEngineReply) {
        super(new ServiceInstanceID("e66e2809-cb0c-5c13-a5a3-2dbaeacc08ce", DSIMapViewerZoomEngineReplyService.nextDynamicHandle(), "2ff38b18-4828-5546-afad-f644f0526a3d", "dsi.map.DSIMapViewerZoomEngine"));
        this.p_DSIMapViewerZoomEngineReply = dSIMapViewerZoomEngineReply;
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
                case 14: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerZoomEngineReply.updateAutoZoomEnabled(bl, n);
                    break;
                }
                case 15: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerZoomEngineReply.updateManoeuvreZoomEnabled(bl, n);
                    break;
                }
                case 16: {
                    float f2 = iDeserializer.getFloat();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerZoomEngineReply.updateRecommendedZoom(f2, n);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIMapViewerZoomEngineReply.updateZoomEngineState(n, n2);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIMapViewerZoomEngineReply.asyncException(n, string, n3);
                    break;
                }
                case 18: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIMapViewerZoomEngineReply.yyIndication(string, string2);
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

