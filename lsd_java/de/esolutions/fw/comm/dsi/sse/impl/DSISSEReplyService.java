/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sse.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.sse.DSISSEReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSISSEReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.sse.DSISSE");
    private static int dynamicHandle = 0;
    private DSISSEReply p_DSISSEReply;

    public DSISSEReplyService(DSISSEReply dSISSEReply) {
        super(new ServiceInstanceID("5b093971-6a32-577c-b8c2-67ff28ae7835", DSISSEReplyService.nextDynamicHandle(), "b2203730-012f-5a3b-a9d9-4e3b6fc01483", "dsi.sse.DSISSE"));
        this.p_DSISSEReply = dSISSEReply;
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
                    this.p_DSISSEReply.responseSetMode(n);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSISSEReply.updateMode(n, n2);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSISSEReply.updateMicGainLevel(n, n3);
                    break;
                }
                case 8: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISSEReply.responseSetMicGainLevel(n);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSISSEReply.updateMicMuteState(n, n4);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISSEReply.responseSetMicMuteState(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSISSEReply.asyncException(n, string, n5);
                    break;
                }
                case 18: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSISSEReply.yyIndication(string, string2);
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

