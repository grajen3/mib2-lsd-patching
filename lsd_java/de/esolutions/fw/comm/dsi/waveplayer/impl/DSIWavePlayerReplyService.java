/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.waveplayer.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.waveplayer.DSIWavePlayerReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIWavePlayerReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.waveplayer.DSIWavePlayer");
    private static int dynamicHandle = 0;
    private DSIWavePlayerReply p_DSIWavePlayerReply;

    public DSIWavePlayerReplyService(DSIWavePlayerReply dSIWavePlayerReply) {
        super(new ServiceInstanceID("769ce35c-50ad-5d34-9ac5-cfccf1aedd73", DSIWavePlayerReplyService.nextDynamicHandle(), "353ec8df-dc25-5139-a159-43eaf2ee00e4", "dsi.waveplayer.DSIWavePlayer"));
        this.p_DSIWavePlayerReply = dSIWavePlayerReply;
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
                case 13: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIWavePlayerReply.updatePlayTone(n, n2);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIWavePlayerReply.updateAudioRequest(n, n3);
                    break;
                }
                case 10: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIWavePlayerReply.setPlayTone(n);
                    break;
                }
                case 3: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIWavePlayerReply.audioTriggerResponse(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIWavePlayerReply.asyncException(n, string, n4);
                    break;
                }
                case 14: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIWavePlayerReply.yyIndication(string, string2);
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

