/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.ASIHMISyncTVReply;
import de.esolutions.fw.comm.asi.hmisync.tv.ActiveStationInfo;
import de.esolutions.fw.comm.asi.hmisync.tv.KeySet;
import de.esolutions.fw.comm.asi.hmisync.tv.ParentalSettings;
import de.esolutions.fw.comm.asi.hmisync.tv.StationInfo;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ActiveStationInfoSerializer;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.KeySetSerializer;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ParentalSettingsSerializer;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.StationInfoSerializer;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncTVReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.hmisync.tv.ASIHMISyncTV");
    private static int dynamicHandle = 0;
    private ASIHMISyncTVReply p_ASIHMISyncTVReply;

    public ASIHMISyncTVReplyService(ASIHMISyncTVReply aSIHMISyncTVReply) {
        super(new ServiceInstanceID("f3fc2e4b-d25f-4479-9da4-6be3da7c1a1e", ASIHMISyncTVReplyService.nextDynamicHandle(), "7b078b73-244f-5129-b88a-1c945501d223", "asi.hmisync.tv.ASIHMISyncTV"));
        this.p_ASIHMISyncTVReply = aSIHMISyncTVReply;
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
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncTVReply.updateASIVersion(string, bl);
                    break;
                }
                case 20: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncTVReply.updateRequestIDs(sArray, bl);
                    break;
                }
                case 19: {
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncTVReply.updateReplyIDs(sArray, bl);
                    break;
                }
                case 23: {
                    StationInfo[] stationInfoArray = StationInfoSerializer.getOptionalStationInfoVarArray(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncTVReply.updateStationInfo(stationInfoArray, bl);
                    break;
                }
                case 21: {
                    ActiveStationInfo activeStationInfo = ActiveStationInfoSerializer.getOptionalActiveStationInfo(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncTVReply.updateActiveStationInfo(activeStationInfo, bl);
                    break;
                }
                case 22: {
                    long l = iDeserializer.getInt64();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncTVReply.updateActiveTVStationState(l, bl);
                    break;
                }
                case 24: {
                    long l = iDeserializer.getInt64();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncTVReply.updateTunerConfig(l, bl);
                    break;
                }
                case 14: {
                    KeySet[] keySetArray = KeySetSerializer.getOptionalKeySetVarArray(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncTVReply.updatePanelKeySet(keySetArray, bl);
                    break;
                }
                case 16: {
                    byte by = iDeserializer.getInt8();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncTVReply.updateSeekStatus(by, bl);
                    break;
                }
                case 18: {
                    byte by = iDeserializer.getInt8();
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncTVReply.updateTerminalMode(by, bl);
                    break;
                }
                case 15: {
                    ParentalSettings parentalSettings = ParentalSettingsSerializer.getOptionalParentalSettings(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_ASIHMISyncTVReply.updateParentalSettings(parentalSettings, bl);
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

