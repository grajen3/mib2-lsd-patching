/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.media.DSIMediaRouterReply;
import de.esolutions.fw.comm.dsi.media.impl.AudioRouteSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.media.AudioRoute;

public class DSIMediaRouterReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.media.DSIMediaRouter");
    private static int dynamicHandle = 0;
    private DSIMediaRouterReply p_DSIMediaRouterReply;

    public DSIMediaRouterReplyService(DSIMediaRouterReply dSIMediaRouterReply) {
        super(new ServiceInstanceID("98796422-df67-5127-a3f4-765a519018ce", DSIMediaRouterReplyService.nextDynamicHandle(), "ab64d699-baa3-575a-9486-0e4b0bfe3b6d", "dsi.media.DSIMediaRouter"));
        this.p_DSIMediaRouterReply = dSIMediaRouterReply;
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
                case 7: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIMediaRouterReply.responseConfiguration(n, n2);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIMediaRouterReply.responseClientStatus(n, n3);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIMediaRouterReply.updateStreamingStatus(n, n4, n5);
                    break;
                }
                case 15: {
                    AudioRoute[] audioRouteArray = AudioRouteSerializer.getOptionalAudioRouteVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaRouterReply.updateActiveAudioRoutes(audioRouteArray, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIMediaRouterReply.asyncException(n, string, n6);
                    break;
                }
                case 17: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIMediaRouterReply.yyIndication(string, string2);
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

