/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tmc.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.NavRectangleSerializer;
import de.esolutions.fw.comm.dsi.tmc.DSITmcOnRouteReply;
import de.esolutions.fw.comm.dsi.tmc.impl.SpeedAndFlowSegmentSerializer;
import de.esolutions.fw.comm.dsi.tmc.impl.TmcMessageSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.SpeedAndFlowSegment;
import org.dsi.ifc.tmc.TmcMessage;

public class DSITmcOnRouteReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.tmc.DSITmcOnRoute");
    private static int dynamicHandle = 0;
    private DSITmcOnRouteReply p_DSITmcOnRouteReply;

    public DSITmcOnRouteReplyService(DSITmcOnRouteReply dSITmcOnRouteReply) {
        super(new ServiceInstanceID("74c79aa7-6bd4-5d66-bfac-0d53682158d8", DSITmcOnRouteReplyService.nextDynamicHandle(), "5312e8a6-d68e-5264-81aa-0d1a74b1e2c9", "dsi.tmc.DSITmcOnRoute"));
        this.p_DSITmcOnRouteReply = dSITmcOnRouteReply;
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
                case 47: {
                    TmcMessage[] tmcMessageArray = TmcMessageSerializer.getOptionalTmcMessageVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITmcOnRouteReply.updateTmcMessagesAhead(tmcMessageArray, n);
                    break;
                }
                case 48: {
                    TmcMessage[] tmcMessageArray = TmcMessageSerializer.getOptionalTmcMessageVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITmcOnRouteReply.updateUrgentMessages(tmcMessageArray, n);
                    break;
                }
                case 46: {
                    TmcMessage tmcMessage = TmcMessageSerializer.getOptionalTmcMessage(iDeserializer);
                    this.p_DSITmcOnRouteReply.tmcMessage(tmcMessage);
                    break;
                }
                case 20: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSITmcOnRouteReply.updateTmcMessagesAheadCalculationHorizon(l, n);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITmcOnRouteReply.setTmcWarningModeResult(n);
                    break;
                }
                case 17: {
                    long[] lArray = iDeserializer.getOptionalInt64VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSITmcOnRouteReply.updateCurrentlyBlockedTMCMessages(lArray, n);
                    break;
                }
                case 2: {
                    long[] lArray = iDeserializer.getOptionalInt64VarArray();
                    long[] lArray2 = iDeserializer.getOptionalInt64VarArray();
                    this.p_DSITmcOnRouteReply.blockTMCMessagesResult(lArray, lArray2);
                    break;
                }
                case 16: {
                    long[] lArray = iDeserializer.getOptionalInt64VarArray();
                    long[] lArray3 = iDeserializer.getOptionalInt64VarArray();
                    this.p_DSITmcOnRouteReply.unblockTMCMessagesResult(lArray, lArray3);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITmcOnRouteReply.unblockAllTMCMessagesResult(n);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSITmcOnRouteReply.updateNaviCoreAvailableToChangeTMCBlockings(n, n2);
                    break;
                }
                case 45: {
                    TmcMessage tmcMessage = TmcMessageSerializer.getOptionalTmcMessage(iDeserializer);
                    NavRectangle navRectangle = NavRectangleSerializer.getOptionalNavRectangle(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITmcOnRouteReply.indicateTrafficEventNoticeMap(tmcMessage, navRectangle, n);
                    break;
                }
                case 49: {
                    SpeedAndFlowSegment[] speedAndFlowSegmentArray = SpeedAndFlowSegmentSerializer.getOptionalSpeedAndFlowSegmentVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITmcOnRouteReply.updateSpeedAndFlowAhead(speedAndFlowSegmentArray, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSITmcOnRouteReply.asyncException(n, string, n3);
                    break;
                }
                case 22: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSITmcOnRouteReply.yyIndication(string, string2);
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

