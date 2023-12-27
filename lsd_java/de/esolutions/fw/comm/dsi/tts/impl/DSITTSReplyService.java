/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tts.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.tts.DSITTSReply;
import de.esolutions.fw.comm.dsi.tts.impl.LanguageVoiceInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.tts.LanguageVoiceInfo;

public class DSITTSReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.tts.DSITTS");
    private static int dynamicHandle = 0;
    private DSITTSReply p_DSITTSReply;

    public DSITTSReplyService(DSITTSReply dSITTSReply) {
        super(new ServiceInstanceID("8d1a024d-227e-5e50-ada7-839a66737794", DSITTSReplyService.nextDynamicHandle(), "80b3f4dc-2495-5caf-8fcf-ebd63773bdb5", "dsi.tts.DSITTS"));
        this.p_DSITTSReply = dSITTSReply;
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
                case 20: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSITTSReply.updateLanguage(string, n, n2, n3);
                    break;
                }
                case 19: {
                    LanguageVoiceInfo[] languageVoiceInfoArray = LanguageVoiceInfoSerializer.getOptionalLanguageVoiceInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITTSReply.updateAvailableLanguages(languageVoiceInfoArray, n);
                    break;
                }
                case 24: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSITTSReply.updateMarkerPassed(n, n4);
                    break;
                }
                case 16: {
                    short s2 = iDeserializer.getInt16();
                    int n = iDeserializer.getInt32();
                    this.p_DSITTSReply.responseSetLanguage(s2, n);
                    break;
                }
                case 14: {
                    short s3 = iDeserializer.getInt16();
                    int n = iDeserializer.getInt32();
                    this.p_DSITTSReply.responseInit(s3, n);
                    break;
                }
                case 13: {
                    short s4 = iDeserializer.getInt16();
                    int n = iDeserializer.getInt32();
                    this.p_DSITTSReply.responseAudioTrigger(s4, n);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSITTSReply.updateAudioRequest(n, n5);
                    break;
                }
                case 15: {
                    short s5 = iDeserializer.getInt16();
                    int n = iDeserializer.getInt32();
                    this.p_DSITTSReply.responsePlayTone(s5, n);
                    break;
                }
                case 17: {
                    short s6 = iDeserializer.getInt16();
                    int n = iDeserializer.getInt32();
                    this.p_DSITTSReply.responseSpeakPrompt(s6, n);
                    break;
                }
                case 23: {
                    short s7 = iDeserializer.getInt16();
                    int n = iDeserializer.getInt32();
                    this.p_DSITTSReply.responseSkipSpeaking(s7, n);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSITTSReply.asyncException(n, string, n6);
                    break;
                }
                case 21: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSITTSReply.yyIndication(string, string2);
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

