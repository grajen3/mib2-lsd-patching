/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.komogfxstreamsink.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.komogfxstreamsink.DSIKOMOGfxStreamSinkReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIKOMOGfxStreamSinkReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.komogfxstreamsink.DSIKOMOGfxStreamSink");
    private static int dynamicHandle = 0;
    private DSIKOMOGfxStreamSinkReply p_DSIKOMOGfxStreamSinkReply;

    public DSIKOMOGfxStreamSinkReplyService(DSIKOMOGfxStreamSinkReply dSIKOMOGfxStreamSinkReply) {
        super(new ServiceInstanceID("6e1558ae-4cd5-5414-9ab7-734ff9d5d567", DSIKOMOGfxStreamSinkReplyService.nextDynamicHandle(), "343602ed-cdc1-5b2a-9bc2-3d899ca8180e", "dsi.komogfxstreamsink.DSIKOMOGfxStreamSink"));
        this.p_DSIKOMOGfxStreamSinkReply = dSIKOMOGfxStreamSinkReply;
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
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIKOMOGfxStreamSinkReply.updateGfxState(n, n2);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIKOMOGfxStreamSinkReply.updateRequestSync(n, n3);
                    break;
                }
                case 13: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIKOMOGfxStreamSinkReply.updateDataRate(n, n4);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIKOMOGfxStreamSinkReply.setFGLayerResult(n);
                    break;
                }
                case 5: {
                    this.p_DSIKOMOGfxStreamSinkReply.fadeInResult();
                    break;
                }
                case 7: {
                    this.p_DSIKOMOGfxStreamSinkReply.fadeOutResult();
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIKOMOGfxStreamSinkReply.asyncException(n, string, n5);
                    break;
                }
                case 16: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIKOMOGfxStreamSinkReply.yyIndication(string, string2);
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

