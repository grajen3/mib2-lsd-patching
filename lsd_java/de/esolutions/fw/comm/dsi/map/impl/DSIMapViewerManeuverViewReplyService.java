/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerManeuverViewReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIMapViewerManeuverViewReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.map.DSIMapViewerManeuverView");
    private static int dynamicHandle = 0;
    private DSIMapViewerManeuverViewReply p_DSIMapViewerManeuverViewReply;

    public DSIMapViewerManeuverViewReplyService(DSIMapViewerManeuverViewReply dSIMapViewerManeuverViewReply) {
        super(new ServiceInstanceID("85c8b1c2-1f5f-52ad-afae-e1334b7bd44d", DSIMapViewerManeuverViewReplyService.nextDynamicHandle(), "1a500646-b59a-5441-9796-84145cd7f8f3", "dsi.map.DSIMapViewerManeuverView"));
        this.p_DSIMapViewerManeuverViewReply = dSIMapViewerManeuverViewReply;
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
                case 10: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIMapViewerManeuverViewReply.updateManoeuvreViewActive(n, n2);
                    break;
                }
                case 11: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMapViewerManeuverViewReply.updateManoeuvreViewsAvailable(sArray, n);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIMapViewerManeuverViewReply.updateBapExitViewId(n, n3);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIMapViewerManeuverViewReply.asyncException(n, string, n4);
                    break;
                }
                case 12: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIMapViewerManeuverViewReply.yyIndication(string, string2);
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

