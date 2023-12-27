/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bluetooth.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.bluetooth.DSIObjectPushReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIObjectPushReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.bluetooth.DSIObjectPush");
    private static int dynamicHandle = 0;
    private DSIObjectPushReply p_DSIObjectPushReply;

    public DSIObjectPushReplyService(DSIObjectPushReply dSIObjectPushReply) {
        super(new ServiceInstanceID("cadd98a6-ed14-5525-a167-28ccee45b259", DSIObjectPushReplyService.nextDynamicHandle(), "f444e780-ab12-56fe-b796-99483239ba21", "dsi.bluetooth.DSIObjectPush"));
        this.p_DSIObjectPushReply = dSIObjectPushReply;
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
                case 17: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIObjectPushReply.updateOPPIncomingObject(string, string2, n, n2);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIObjectPushReply.responseOPPAbortSending(n);
                    break;
                }
                case 10: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIObjectPushReply.responseOPPAcceptObject(n);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIObjectPushReply.responseOPPSendContacts(n);
                    break;
                }
                case 13: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIObjectPushReply.responseOPPSendMessages(n);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIObjectPushReply.responseOPPSendBinary(n);
                    break;
                }
                case 18: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIObjectPushReply.updateVCardsReceived(string, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIObjectPushReply.asyncException(n, string, n3);
                    break;
                }
                case 19: {
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_DSIObjectPushReply.yyIndication(string, string3);
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

