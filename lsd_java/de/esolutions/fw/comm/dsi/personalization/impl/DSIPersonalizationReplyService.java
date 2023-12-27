/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.personalization.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.personalization.DSIPersonalizationReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIPersonalizationReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.personalization.DSIPersonalization");
    private static int dynamicHandle = 0;
    private DSIPersonalizationReply p_DSIPersonalizationReply;

    public DSIPersonalizationReplyService(DSIPersonalizationReply dSIPersonalizationReply) {
        super(new ServiceInstanceID("7d391dea-7dea-58b1-b8be-fea9d4a1e349", DSIPersonalizationReplyService.nextDynamicHandle(), "f913ad4b-0134-5e84-b2e4-69d9bc951858", "dsi.personalization.DSIPersonalization"));
        this.p_DSIPersonalizationReply = dSIPersonalizationReply;
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
                case 4: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIPersonalizationReply.copyProfile(n, n2);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIPersonalizationReply.resetProfile(n);
                    break;
                }
                case 5: {
                    this.p_DSIPersonalizationReply.resetAllProfiles();
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIPersonalizationReply.asyncException(n, string, n3);
                    break;
                }
                case 10: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIPersonalizationReply.yyIndication(string, string2);
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

