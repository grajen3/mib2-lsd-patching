/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.diagnose.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.diagnose.DSIComponentProtectionReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIComponentProtectionReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.diagnose.DSIComponentProtection");
    private static int dynamicHandle = 0;
    private DSIComponentProtectionReply p_DSIComponentProtectionReply;

    public DSIComponentProtectionReplyService(DSIComponentProtectionReply dSIComponentProtectionReply) {
        super(new ServiceInstanceID("54043ffd-5930-5fd1-b6a9-e318c74a2c35", DSIComponentProtectionReplyService.nextDynamicHandle(), "925d4129-9d5f-5cbc-b7b4-c8e3ce749dfb", "dsi.diagnose.DSIComponentProtection"));
        this.p_DSIComponentProtectionReply = dSIComponentProtectionReply;
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
                case 2: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    byte by = iDeserializer.getInt8();
                    this.p_DSIComponentProtectionReply.authStringResponse(string, string2, by);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIComponentProtectionReply.asyncException(n, string, n2);
                    break;
                }
                case 9: {
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_DSIComponentProtectionReply.yyIndication(string, string3);
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

