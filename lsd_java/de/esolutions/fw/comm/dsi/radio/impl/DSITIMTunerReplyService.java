/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.radio.DSITIMTunerReply;
import de.esolutions.fw.comm.dsi.radio.impl.TIMMemoUsageSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.TIMMessageSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.TIMStatusSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.radio.TIMMemoUsage;
import org.dsi.ifc.radio.TIMMessage;
import org.dsi.ifc.radio.TIMStatus;

public class DSITIMTunerReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.radio.DSITIMTuner");
    private static int dynamicHandle = 0;
    private DSITIMTunerReply p_DSITIMTunerReply;

    public DSITIMTunerReplyService(DSITIMTunerReply dSITIMTunerReply) {
        super(new ServiceInstanceID("ab0b1ccd-1313-5f02-b980-547d67d84062", DSITIMTunerReplyService.nextDynamicHandle(), "0a22f7d7-07bf-5008-901e-a11aaff4d3a8", "dsi.radio.DSITIMTuner"));
        this.p_DSITIMTunerReply = dSITIMTunerReply;
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
                    TIMMessage[] tIMMessageArray = TIMMessageSerializer.getOptionalTIMMessageVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITIMTunerReply.updateTIMMessageList(tIMMessageArray, n);
                    break;
                }
                case 14: {
                    TIMStatus tIMStatus = TIMStatusSerializer.getOptionalTIMStatus(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITIMTunerReply.updateTIMStatus(tIMStatus, n);
                    break;
                }
                case 12: {
                    TIMMemoUsage tIMMemoUsage = TIMMemoUsageSerializer.getOptionalTIMMemoUsage(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITIMTunerReply.updateTIMMemoUsage(tIMMemoUsage, n);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSITIMTunerReply.updateTIMAvailable(n, n2);
                    break;
                }
                case 5: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITIMTunerReply.playback(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSITIMTunerReply.asyncException(n, string, n3);
                    break;
                }
                case 15: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSITIMTunerReply.yyIndication(string, string2);
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

