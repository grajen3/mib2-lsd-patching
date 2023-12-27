/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.displaycontroller.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.displaycontroller.DSIDisplayControllerReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIDisplayControllerReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.displaycontroller.DSIDisplayController");
    private static int dynamicHandle = 0;
    private DSIDisplayControllerReply p_DSIDisplayControllerReply;

    public DSIDisplayControllerReplyService(DSIDisplayControllerReply dSIDisplayControllerReply) {
        super(new ServiceInstanceID("9b27c2ef-4e44-5e8f-b943-3e147e35ce14", DSIDisplayControllerReplyService.nextDynamicHandle(), "b2238660-5500-5c27-8846-14f8201a2f0e", "dsi.displaycontroller.DSIDisplayController"));
        this.p_DSIDisplayControllerReply = dSIDisplayControllerReply;
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
                case 5: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIDisplayControllerReply.getDisplayBrightness(n, n2);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIDisplayControllerReply.asyncException(n, string, n3);
                    break;
                }
                case 11: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIDisplayControllerReply.yyIndication(string, string2);
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

