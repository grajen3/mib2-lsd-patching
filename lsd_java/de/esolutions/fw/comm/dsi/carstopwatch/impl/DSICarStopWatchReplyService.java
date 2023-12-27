/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carstopwatch.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carstopwatch.DSICarStopWatchReply;
import de.esolutions.fw.comm.dsi.carstopwatch.impl.StopWatchTimeSerializer;
import de.esolutions.fw.comm.dsi.carstopwatch.impl.StopWatchViewOptionsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carstopwatch.StopWatchTime;
import org.dsi.ifc.carstopwatch.StopWatchViewOptions;

public class DSICarStopWatchReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.carstopwatch.DSICarStopWatch");
    private static int dynamicHandle = 0;
    private DSICarStopWatchReply p_DSICarStopWatchReply;

    public DSICarStopWatchReplyService(DSICarStopWatchReply dSICarStopWatchReply) {
        super(new ServiceInstanceID("f4b74ed2-d785-568f-a5bb-7fbdc376e935", DSICarStopWatchReplyService.nextDynamicHandle(), "e4ecd900-215e-5ff5-8922-d8a027e6819b", "dsi.carstopwatch.DSICarStopWatch"));
        this.p_DSICarStopWatchReply = dSICarStopWatchReply;
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
                case 22: {
                    StopWatchViewOptions stopWatchViewOptions = StopWatchViewOptionsSerializer.getOptionalStopWatchViewOptions(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarStopWatchReply.updateStopWatchViewOptions(stopWatchViewOptions, n);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSICarStopWatchReply.updateStopWatchState(n, n2);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSICarStopWatchReply.updateStopWatchCurrentLapNumber(n, n3);
                    break;
                }
                case 17: {
                    StopWatchTime stopWatchTime = StopWatchTimeSerializer.getOptionalStopWatchTime(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarStopWatchReply.updateStopWatchTotalTime(stopWatchTime, n);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    StopWatchTime stopWatchTime = StopWatchTimeSerializer.getOptionalStopWatchTime(iDeserializer);
                    int n4 = iDeserializer.getInt32();
                    this.p_DSICarStopWatchReply.updateStopWatchLastSplitTime(n, stopWatchTime, n4);
                    break;
                }
                case 13: {
                    StopWatchTime stopWatchTime = StopWatchTimeSerializer.getOptionalStopWatchTime(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarStopWatchReply.updateStopWatchCurrentLapTime(stopWatchTime, n);
                    break;
                }
                case 14: {
                    StopWatchTime stopWatchTime = StopWatchTimeSerializer.getOptionalStopWatchTime(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSICarStopWatchReply.updateStopWatchLastLapTime(stopWatchTime, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSICarStopWatchReply.asyncException(n, string, n5);
                    break;
                }
                case 19: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSICarStopWatchReply.yyIndication(string, string2);
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

