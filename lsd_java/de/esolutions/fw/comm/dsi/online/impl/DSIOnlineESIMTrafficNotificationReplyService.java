/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIOnlineESIMTrafficNotificationReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIOnlineESIMTrafficNotificationReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.online.DSIOnlineESIMTrafficNotification");
    private static int dynamicHandle = 0;
    private DSIOnlineESIMTrafficNotificationReply p_DSIOnlineESIMTrafficNotificationReply;

    public DSIOnlineESIMTrafficNotificationReplyService(DSIOnlineESIMTrafficNotificationReply dSIOnlineESIMTrafficNotificationReply) {
        super(new ServiceInstanceID("e3bba10c-31d4-5d08-9056-c5f5d5344f28", DSIOnlineESIMTrafficNotificationReplyService.nextDynamicHandle(), "0e21486a-016f-5ff7-8b2b-4794252c2e45", "dsi.online.DSIOnlineESIMTrafficNotification"));
        this.p_DSIOnlineESIMTrafficNotificationReply = dSIOnlineESIMTrafficNotificationReply;
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
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIOnlineESIMTrafficNotificationReply.updateESIMNotification(string, n, n2);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIOnlineESIMTrafficNotificationReply.asyncException(n, string, n3);
                    break;
                }
                case 8: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIOnlineESIMTrafficNotificationReply.yyIndication(string, string2);
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

