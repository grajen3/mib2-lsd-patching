/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbSdsReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIAdbSdsReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.organizer.DSIAdbSds");
    private static int dynamicHandle = 0;
    private DSIAdbSdsReply p_DSIAdbSdsReply;

    public DSIAdbSdsReplyService(DSIAdbSdsReply dSIAdbSdsReply) {
        super(new ServiceInstanceID("d52e8b7b-22d1-582c-a00a-2d5a5a40ce7c", DSIAdbSdsReplyService.nextDynamicHandle(), "803e4a60-f8b0-5229-839b-b430e08ede41", "dsi.organizer.DSIAdbSds"));
        this.p_DSIAdbSdsReply = dSIAdbSdsReply;
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
                    int n = iDeserializer.getInt32();
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSIAdbSdsReply.getAllVoiceTagsResult(n, nArray);
                    break;
                }
                case 10: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbSdsReply.deleteVoiceTagsResult(n);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIAdbSdsReply.asyncException(n, string, n2);
                    break;
                }
                case 12: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIAdbSdsReply.yyIndication(string, string2);
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

