/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.trafficregulation.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.trafficregulation.DSITrafficRegulationReply;
import de.esolutions.fw.comm.dsi.trafficregulation.impl.RoadClassSpeedInfoSerializer;
import de.esolutions.fw.comm.dsi.trafficregulation.impl.TrafficSignInformationOnRouteSerializer;
import de.esolutions.fw.comm.dsi.trafficregulation.impl.TrafficSignInformationSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;
import org.dsi.ifc.trafficregulation.TrafficSignInformationOnRoute;

public class DSITrafficRegulationReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.trafficregulation.DSITrafficRegulation");
    private static int dynamicHandle = 0;
    private DSITrafficRegulationReply p_DSITrafficRegulationReply;

    public DSITrafficRegulationReplyService(DSITrafficRegulationReply dSITrafficRegulationReply) {
        super(new ServiceInstanceID("6901e511-3231-50d4-b201-4f6cac639de8", DSITrafficRegulationReplyService.nextDynamicHandle(), "f1dc0de3-ddd5-522b-83a1-8a345754745f", "dsi.trafficregulation.DSITrafficRegulation"));
        this.p_DSITrafficRegulationReply = dSITrafficRegulationReply;
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
                    RoadClassSpeedInfo[] roadClassSpeedInfoArray = RoadClassSpeedInfoSerializer.getOptionalRoadClassSpeedInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITrafficRegulationReply.updateCountrySpeedInformation(roadClassSpeedInfoArray, n);
                    break;
                }
                case 20: {
                    TrafficSignInformation trafficSignInformation = TrafficSignInformationSerializer.getOptionalTrafficSignInformation(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITrafficRegulationReply.updateCurrentTrafficSign(trafficSignInformation, n);
                    break;
                }
                case 21: {
                    TrafficSignInformationOnRoute[] trafficSignInformationOnRouteArray = TrafficSignInformationOnRouteSerializer.getOptionalTrafficSignInformationOnRouteVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITrafficRegulationReply.updateTrafficSignOnRoute(trafficSignInformationOnRouteArray, n);
                    break;
                }
                case 5: {
                    RoadClassSpeedInfo[] roadClassSpeedInfoArray = RoadClassSpeedInfoSerializer.getOptionalRoadClassSpeedInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITrafficRegulationReply.requestRoadClassSpeedInfoForCountryResult(roadClassSpeedInfoArray, n);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSITrafficRegulationReply.updateTrailerStatus(n, n2);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSITrafficRegulationReply.asyncException(n, string, n3);
                    break;
                }
                case 13: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSITrafficRegulationReply.yyIndication(string, string2);
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

