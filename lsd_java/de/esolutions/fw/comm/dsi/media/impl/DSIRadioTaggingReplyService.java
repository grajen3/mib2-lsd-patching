/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.media.DSIRadioTaggingReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIRadioTaggingReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.media.DSIRadioTagging");
    private static int dynamicHandle = 0;
    private DSIRadioTaggingReply p_DSIRadioTaggingReply;

    public DSIRadioTaggingReplyService(DSIRadioTaggingReply dSIRadioTaggingReply) {
        super(new ServiceInstanceID("e7a79385-c2e2-59e6-8480-d08d3c150175", DSIRadioTaggingReplyService.nextDynamicHandle(), "435a193d-31a2-5c0b-ad87-6a10d4b15544", "dsi.media.DSIRadioTagging"));
        this.p_DSIRadioTaggingReply = dSIRadioTaggingReply;
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
                case 8: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIRadioTaggingReply.tagResult(n);
                    break;
                }
                case 10: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIRadioTaggingReply.updateCompatibleDevAvail(n, n2);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIRadioTaggingReply.groupTagsResult(n, n3);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIRadioTaggingReply.asyncException(n, string, n4);
                    break;
                }
                case 11: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIRadioTaggingReply.yyIndication(string, string2);
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

