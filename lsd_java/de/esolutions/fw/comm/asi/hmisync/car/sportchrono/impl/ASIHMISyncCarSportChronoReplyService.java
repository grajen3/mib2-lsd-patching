/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.ASIHMISyncCarSportChronoReply;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.RecordingRange;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCHeader;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCRefLapData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCRefLapHeader;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.TransferState;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.RecordingRangeSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.SCDataSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.SCHeaderSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.SCRefLapDataSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.SCRefLapHeaderSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.TransferStateSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarSportChronoReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.car.sportchrono.ASIHMISyncCarSportChrono");
    private static int dynamicHandle = 0;
    private ASIHMISyncCarSportChronoReply p_ASIHMISyncCarSportChronoReply;

    public ASIHMISyncCarSportChronoReplyService(ASIHMISyncCarSportChronoReply aSIHMISyncCarSportChronoReply) {
        super(new ServiceInstanceID("38295c72-4d73-4857-919d-548f4e0abbdd", ASIHMISyncCarSportChronoReplyService.nextDynamicHandle(), "98008024-b4e6-5a1f-8cf9-1c1a2dc9dad6", "asi.hmisync.car.sportchrono.ASIHMISyncCarSportChrono"));
        this.p_ASIHMISyncCarSportChronoReply = aSIHMISyncCarSportChronoReply;
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
                case 7: {
                    SCData[] sCDataArray = SCDataSerializer.getOptionalSCDataVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncCarSportChronoReply.responseRecordData(sCDataArray, n);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    SCData[] sCDataArray = SCDataSerializer.getOptionalSCDataVarArray(iDeserializer);
                    int n2 = iDeserializer.getInt32();
                    this.p_ASIHMISyncCarSportChronoReply.responseTrackData(n, sCDataArray, n2);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_ASIHMISyncCarSportChronoReply.responseInitTrackTransfer(n, n3);
                    break;
                }
                case 8: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_ASIHMISyncCarSportChronoReply.responseSetTrackData(n, n4);
                    break;
                }
                case 29: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_ASIHMISyncCarSportChronoReply.responseSetReferenceLap(n, n5);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    SCRefLapData[] sCRefLapDataArray = SCRefLapDataSerializer.getOptionalSCRefLapDataVarArray(iDeserializer);
                    int n6 = iDeserializer.getInt32();
                    this.p_ASIHMISyncCarSportChronoReply.responseReferenceLapData(n, sCRefLapDataArray, n6);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    this.p_ASIHMISyncCarSportChronoReply.responseSaveReferenceLap(n);
                    break;
                }
                case 15: {
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarSportChronoReply.updateASIVersion(string, bl);
                    break;
                }
                case 20: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarSportChronoReply.updateRequestIDs(sArray, bl);
                    break;
                }
                case 19: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarSportChronoReply.updateReplyIDs(sArray, bl);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarSportChronoReply.updateSCVisibilityState(n, bl);
                    break;
                }
                case 16: {
                    SCHeader sCHeader = SCHeaderSerializer.getOptionalSCHeader(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarSportChronoReply.updateActiveRecord(sCHeader, bl);
                    break;
                }
                case 17: {
                    SCData sCData = SCDataSerializer.getOptionalSCData(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarSportChronoReply.updateActiveRecordData(sCData, bl);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarSportChronoReply.updateRecordMode(n, bl);
                    break;
                }
                case 22: {
                    SCHeader[] sCHeaderArray = SCHeaderSerializer.getOptionalSCHeaderVarArray(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarSportChronoReply.updateTrackList(sCHeaderArray, bl);
                    break;
                }
                case 23: {
                    TransferState transferState = TransferStateSerializer.getOptionalTransferState(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarSportChronoReply.updateTransferState(transferState, bl);
                    break;
                }
                case 25: {
                    long l = iDeserializer.getInt64();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarSportChronoReply.updateRecordingTime(l, bl);
                    break;
                }
                case 24: {
                    RecordingRange recordingRange = RecordingRangeSerializer.getOptionalRecordingRange(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarSportChronoReply.updateRecordingRange(recordingRange, bl);
                    break;
                }
                case 33: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarSportChronoReply.updateSelectedReferenceLapUid(n, bl);
                    break;
                }
                case 32: {
                    SCRefLapHeader[] sCRefLapHeaderArray = SCRefLapHeaderSerializer.getOptionalSCRefLapHeaderVarArray(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncCarSportChronoReply.updateReferenceLapList(sCRefLapHeaderArray, bl);
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

