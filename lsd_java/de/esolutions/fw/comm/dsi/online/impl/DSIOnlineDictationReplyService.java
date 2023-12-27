/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIOnlineDictationReply;
import de.esolutions.fw.comm.dsi.online.impl.DictationValueSentenceSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.online.DictationValueSentence;

public class DSIOnlineDictationReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.online.DSIOnlineDictation");
    private static int dynamicHandle = 0;
    private DSIOnlineDictationReply p_DSIOnlineDictationReply;

    public DSIOnlineDictationReplyService(DSIOnlineDictationReply dSIOnlineDictationReply) {
        super(new ServiceInstanceID("8713cd7d-139f-5bf7-8bce-1c82c0b4c605", DSIOnlineDictationReplyService.nextDynamicHandle(), "4c75da4a-03db-5a77-9740-90765e5413a6", "dsi.online.DSIOnlineDictation"));
        this.p_DSIOnlineDictationReply = dSIOnlineDictationReply;
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
                case 19: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineDictationReply.dictationResult(n);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIOnlineDictationReply.finishDictationResponse(n);
                    break;
                }
                case 20: {
                    DictationValueSentence dictationValueSentence = DictationValueSentenceSerializer.getOptionalDictationValueSentence(iDeserializer);
                    this.p_DSIOnlineDictationReply.dictationValueList(dictationValueSentence);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIOnlineDictationReply.asyncException(n, string, n2);
                    break;
                }
                case 22: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIOnlineDictationReply.yyIndication(string, string2);
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

