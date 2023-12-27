/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.radio.DSIAMFMTunerReply;
import de.esolutions.fw.comm.dsi.radio.impl.AMFMRadioTextSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.HdStationInfoSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.StationSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.WavebandInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.radio.AMFMRadioText;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.WavebandInfo;

public class DSIAMFMTunerReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.radio.DSIAMFMTuner");
    private static int dynamicHandle = 0;
    private DSIAMFMTunerReply p_DSIAMFMTunerReply;

    public DSIAMFMTunerReplyService(DSIAMFMTunerReply dSIAMFMTunerReply) {
        super(new ServiceInstanceID("624f70c8-a845-526d-98c4-395f6f0a04e3", DSIAMFMTunerReplyService.nextDynamicHandle(), "1596edb0-7f9a-5bb8-b0a7-43508fd050b7", "dsi.radio.DSIAMFMTuner"));
        this.p_DSIAMFMTunerReply = dSIAMFMTunerReply;
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
                case 67: {
                    Station[] stationArray = StationSerializer.getOptionalStationVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updateStationList(stationArray, n);
                    break;
                }
                case 69: {
                    Station[] stationArray = StationSerializer.getOptionalStationVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updateStationListMW(stationArray, n);
                    break;
                }
                case 68: {
                    Station[] stationArray = StationSerializer.getOptionalStationVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updateStationListLW(stationArray, n);
                    break;
                }
                case 55: {
                    WavebandInfo[] wavebandInfoArray = WavebandInfoSerializer.getOptionalWavebandInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updateWavebandInfoList(wavebandInfoArray, n);
                    break;
                }
                case 48: {
                    AMFMRadioText aMFMRadioText = AMFMRadioTextSerializer.getOptionalAMFMRadioText(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updateRadioText(aMFMRadioText, n);
                    break;
                }
                case 36: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updateAFSwitchStatus(bl, n);
                    break;
                }
                case 47: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updateREGSwitchStatus(n, n2);
                    break;
                }
                case 43: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updateLinkingUsageStatus(n, n3);
                    break;
                }
                case 38: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updateDetectedDevice(n, n4);
                    break;
                }
                case 35: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.tuneFrequencyStepsStatus(n);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.selectStationStatus(n);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.seekStationStatus(n);
                    break;
                }
                case 49: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updateRadioTextPlus(nArray, stringArray, n);
                    break;
                }
                case 65: {
                    Station station = StationSerializer.getOptionalStation(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updateSelectedStation(station, n);
                    break;
                }
                case 66: {
                    Station station = StationSerializer.getOptionalStation(iDeserializer);
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updateSelectedStationHD(station, n, n5);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.prepareTuningStatus(n);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.selectFrequencyStatus(n);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.setAMBandRangeStatus(n);
                    break;
                }
                case 8: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.forceFMUpdateStatus(n);
                    break;
                }
                case 45: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updatePiIgnoreSwitchStatus(bl, n);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.forceAMUpdateStatus(n);
                    break;
                }
                case 46: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updateRDSIgnoreSwitchStatus(bl, n);
                    break;
                }
                case 44: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updateMESwitchStatus(bl, n);
                    break;
                }
                case 42: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updateHdStatus(n, n6);
                    break;
                }
                case 40: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updateHdMode(n, n7);
                    break;
                }
                case 59: {
                    HdStationInfo hdStationInfo = HdStationInfoSerializer.getOptionalHdStationInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updateHdStationInfo(hdStationInfo, n);
                    break;
                }
                case 37: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updateAvailability(n, n8);
                    break;
                }
                case 39: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updateElectronicSerialCode(string, n);
                    break;
                }
                case 78: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.updateProfileState(n, n9, n10);
                    break;
                }
                case 71: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.profileChanged(n, n11);
                    break;
                }
                case 72: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.profileCopied(n, n12, n13);
                    break;
                }
                case 75: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.profileReset(n, n14);
                    break;
                }
                case 77: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.profileResetAll(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSIAMFMTunerReply.asyncException(n, string, n15);
                    break;
                }
                case 56: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIAMFMTunerReply.yyIndication(string, string2);
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

