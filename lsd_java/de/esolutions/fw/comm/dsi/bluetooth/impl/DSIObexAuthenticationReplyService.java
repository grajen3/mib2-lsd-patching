/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bluetooth.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.bluetooth.DSIObexAuthenticationReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIObexAuthenticationReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.bluetooth.DSIObexAuthentication");
    private static int dynamicHandle = 0;
    private DSIObexAuthenticationReply p_DSIObexAuthenticationReply;

    public DSIObexAuthenticationReplyService(DSIObexAuthenticationReply dSIObexAuthenticationReply) {
        super(new ServiceInstanceID("d9c776d8-fb7d-57c9-b9c2-b1889d5cc65a", DSIObexAuthenticationReplyService.nextDynamicHandle(), "5ca256d6-dd8e-51a6-a099-6e1956ccceeb", "dsi.bluetooth.DSIObexAuthentication"));
        this.p_DSIObexAuthenticationReply = dSIObexAuthenticationReply;
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
                case 1: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIObexAuthenticationReply.authenticationRequired(n, bl, string);
                    break;
                }
                case 5: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIObexAuthenticationReply.indAuthentication(bl);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIObexAuthenticationReply.asyncException(n, string, n2);
                    break;
                }
                case 10: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIObexAuthenticationReply.yyIndication(string, string2);
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

