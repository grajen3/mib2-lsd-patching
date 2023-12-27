/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerLandmarkPlayerReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIMapViewerLandmarkPlayerReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.map.DSIMapViewerLandmarkPlayer");
    private static int dynamicHandle = 0;
    private DSIMapViewerLandmarkPlayerReply p_DSIMapViewerLandmarkPlayerReply;

    public DSIMapViewerLandmarkPlayerReplyService(DSIMapViewerLandmarkPlayerReply dSIMapViewerLandmarkPlayerReply) {
        super(new ServiceInstanceID("092f40d2-a577-5fe4-a881-b0305ea769fd", DSIMapViewerLandmarkPlayerReplyService.nextDynamicHandle(), "91c9169e-f7a0-5ecf-b7d7-a01090d43d37", "dsi.map.DSIMapViewerLandmarkPlayer"));
        this.p_DSIMapViewerLandmarkPlayerReply = dSIMapViewerLandmarkPlayerReply;
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
                case 8: {
                    float f2 = iDeserializer.getFloat();
                    this.p_DSIMapViewerLandmarkPlayerReply.showLandmark(f2);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIMapViewerLandmarkPlayerReply.asyncException(n, string, n2);
                    break;
                }
                case 10: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIMapViewerLandmarkPlayerReply.yyIndication(string, string2);
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

