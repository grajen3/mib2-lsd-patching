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
import de.esolutions.fw.comm.dsi.tmc.DSITmcReply;
import de.esolutions.fw.comm.dsi.tmc.impl.AreaWarningInfoSerializer;
import de.esolutions.fw.comm.dsi.tmc.impl.LocalHazardInformationSerializer;
import de.esolutions.fw.comm.dsi.tmc.impl.TmcListElementSerializer;
import de.esolutions.fw.comm.dsi.tmc.impl.TrafficSourceSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.AreaWarningInfo;
import org.dsi.ifc.tmc.LocalHazardInformation;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TrafficSource;

public class DSITmcReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.tmc.DSITmc");
    private static int dynamicHandle = 0;
    private DSITmcReply p_DSITmcReply;

    public DSITmcReplyService(DSITmcReply dSITmcReply) {
        super(new ServiceInstanceID("a73f6b98-aa3b-5dba-a907-2d574d8b6cb8", DSITmcReplyService.nextDynamicHandle(), "1672f1b5-572a-5457-b33e-fd154fd0e075", "dsi.tmc.DSITmc"));
        this.p_DSITmcReply = dSITmcReply;
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
                case 12: {
                    long l = iDeserializer.getInt64();
                    int n = iDeserializer.getInt32();
                    this.p_DSITmcReply.updateEventsOnRoute(l, n);
                    break;
                }
                case 13: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    long l2 = iDeserializer.getInt64();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSITmcReply.updateEventsTotal(n, l, l2, n2);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSITmcReply.updateTmcState(n, n3);
                    break;
                }
                case 22: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSITmcReply.updateActiveTrafficSources(nArray, n);
                    break;
                }
                case 14: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSITmcReply.updateIsEngineeringMode(bl, n);
                    break;
                }
                case 11: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSITmcReply.updateCurrentLanguage(string, n);
                    break;
                }
                case 15: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSITmcReply.updateIsTmcProAvailable(bl, n);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITmcReply.windowChange(n);
                    break;
                }
                case 41: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    TmcListElement[] tmcListElementArray = TmcListElementSerializer.getOptionalTmcListElementVarArray(iDeserializer);
                    this.p_DSITmcReply.tmcWindowResult(n, n4, tmcListElementArray);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSITmcReply.setMessageFilterResult(n, n5);
                    break;
                }
                case 26: {
                    long[] lArray = iDeserializer.getOptionalInt64VarArray();
                    this.p_DSITmcReply.getMessageIdsForListElementResult(lArray);
                    break;
                }
                case 39: {
                    NavRectangle navRectangle = NavRectangleSerializer.getOptionalNavRectangle(iDeserializer);
                    this.p_DSITmcReply.getBoundingRectangleForTrafficMessagesResult(navRectangle);
                    break;
                }
                case 32: {
                    AreaWarningInfo areaWarningInfo = AreaWarningInfoSerializer.getOptionalAreaWarningInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITmcReply.updateAreaWarning(areaWarningInfo, n);
                    break;
                }
                case 33: {
                    AreaWarningInfo[] areaWarningInfoArray = AreaWarningInfoSerializer.getOptionalAreaWarningInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITmcReply.updateAreaWarnings(areaWarningInfoArray, n);
                    break;
                }
                case 34: {
                    LocalHazardInformation[] localHazardInformationArray = LocalHazardInformationSerializer.getOptionalLocalHazardInformationVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITmcReply.updateLocalHazardInformation(localHazardInformationArray, n);
                    break;
                }
                case 36: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSITmcReply.updateTrafficFlowStatisticsStatus(bl, n);
                    break;
                }
                case 40: {
                    TrafficSource[] trafficSourceArray = TrafficSourceSerializer.getOptionalTrafficSourceVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITmcReply.updateTrafficSourceInformation(trafficSourceArray, n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSITmcReply.asyncException(n, string, n6);
                    break;
                }
                case 18: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSITmcReply.yyIndication(string, string2);
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

