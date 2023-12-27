/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.system.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.system.DSIHMIWatchDogReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIHMIWatchDogReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.system.DSIHMIWatchDog");
    private static int dynamicHandle = 0;
    private DSIHMIWatchDogReply p_DSIHMIWatchDogReply;

    public DSIHMIWatchDogReplyService(DSIHMIWatchDogReply dSIHMIWatchDogReply) {
        super(new ServiceInstanceID("8c5bbce5-380f-5df5-b19b-5ec1f7e75e4b", DSIHMIWatchDogReplyService.nextDynamicHandle(), "f66767ae-666c-576d-965d-bc3458fe4188", "dsi.system.DSIHMIWatchDog"));
        this.p_DSIHMIWatchDogReply = dSIHMIWatchDogReply;
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
                case 11: {
                    this.p_DSIHMIWatchDogReply.triggerErrorLogDump();
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIHMIWatchDogReply.updateQueryHeartbeat(n, n2);
                    break;
                }
                case 10: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIHMIWatchDogReply.asyncException(n, string, n3);
                    break;
                }
                case 13: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIHMIWatchDogReply.yyIndication(string, string2);
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

