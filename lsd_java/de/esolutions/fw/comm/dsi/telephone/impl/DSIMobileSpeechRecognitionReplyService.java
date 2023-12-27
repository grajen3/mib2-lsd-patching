/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.telephone.DSIMobileSpeechRecognitionReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIMobileSpeechRecognitionReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.telephone.DSIMobileSpeechRecognition");
    private static int dynamicHandle = 0;
    private DSIMobileSpeechRecognitionReply p_DSIMobileSpeechRecognitionReply;

    public DSIMobileSpeechRecognitionReplyService(DSIMobileSpeechRecognitionReply dSIMobileSpeechRecognitionReply) {
        super(new ServiceInstanceID("f14d948b-082d-5317-8e8d-ff2c2d47774f", DSIMobileSpeechRecognitionReplyService.nextDynamicHandle(), "5f606b95-6f71-5c15-a794-a18890d22182", "dsi.telephone.DSIMobileSpeechRecognition"));
        this.p_DSIMobileSpeechRecognitionReply = dSIMobileSpeechRecognitionReply;
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
                case 10: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIMobileSpeechRecognitionReply.updateSpeechRecognitionAvailable(n, n2);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIMobileSpeechRecognitionReply.updateSpeechRecognitionActive(n, n3);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIMobileSpeechRecognitionReply.updateSpeechRecognitionType(n, n4);
                    break;
                }
                case 5: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileSpeechRecognitionReply.responseStartSpeechRecognition(n);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileSpeechRecognitionReply.responseStopSpeechRecognition(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIMobileSpeechRecognitionReply.asyncException(n, string, n5);
                    break;
                }
                case 11: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIMobileSpeechRecognitionReply.yyIndication(string, string2);
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

