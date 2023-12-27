/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio.impl;

import de.esolutions.fw.comm.asi.hmisync.radio.ASIHMISyncRadioReply;
import de.esolutions.fw.comm.asi.hmisync.radio.CurrentStation;
import de.esolutions.fw.comm.asi.hmisync.radio.StationInfo;
import de.esolutions.fw.comm.asi.hmisync.radio.WavebandInfo;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.CurrentStationSerializer;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.StationInfoSerializer;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.WavebandInfoSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncRadioReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.radio.ASIHMISyncRadio");
    private static int dynamicHandle = 0;
    private ASIHMISyncRadioReply p_ASIHMISyncRadioReply;

    public ASIHMISyncRadioReplyService(ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        super(new ServiceInstanceID("c43514a0-a79e-4e4d-905c-816fe72baa19", ASIHMISyncRadioReplyService.nextDynamicHandle(), "5825259e-363b-5404-81a4-012a1205c9db", "asi.hmisync.radio.ASIHMISyncRadio"));
        this.p_ASIHMISyncRadioReply = aSIHMISyncRadioReply;
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
                    CurrentStation[] currentStationArray = CurrentStationSerializer.getOptionalCurrentStationVarArray(iDeserializer);
                    this.p_ASIHMISyncRadioReply.stationDetailsUpdated(currentStationArray);
                    break;
                }
                case 11: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncRadioReply.updateASIVersion(string, bl);
                    break;
                }
                case 18: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncRadioReply.updateRequestIDs(sArray, bl);
                    break;
                }
                case 17: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncRadioReply.updateReplyIDs(sArray, bl);
                    break;
                }
                case 14: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncRadioReply.updateBandList(nArray, bl);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncRadioReply.updateActiveBand(n, bl);
                    break;
                }
                case 22: {
                    StationInfo[] stationInfoArray = StationInfoSerializer.getOptionalStationInfoVarArray(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncRadioReply.updateRadioStationList(stationInfoArray, bl);
                    break;
                }
                case 21: {
                    CurrentStation currentStation = CurrentStationSerializer.getOptionalCurrentStation(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncRadioReply.updateActiveStation(currentStation, bl);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncRadioReply.updateSeekStatus(n, bl);
                    break;
                }
                case 19: {
                    WavebandInfo[] wavebandInfoArray = WavebandInfoSerializer.getOptionalWavebandInfoVarArray(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncRadioReply.updateWavebands(wavebandInfoArray, bl);
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

