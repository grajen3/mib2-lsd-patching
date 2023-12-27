/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.radio.DSIUnifiedTunerReply;
import de.esolutions.fw.comm.dsi.radio.impl.DABSlideShowInfoSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.UnifiedRadioTextPlusSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.UnifiedRadioTextSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.UnifiedStationSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.UnifiedRadioText;
import org.dsi.ifc.radio.UnifiedRadioTextPlus;
import org.dsi.ifc.radio.UnifiedStation;

public class DSIUnifiedTunerReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.radio.DSIUnifiedTuner");
    private static int dynamicHandle = 0;
    private DSIUnifiedTunerReply p_DSIUnifiedTunerReply;

    public DSIUnifiedTunerReplyService(DSIUnifiedTunerReply dSIUnifiedTunerReply) {
        super(new ServiceInstanceID("dfce4bfe-039b-5764-9c93-b4266b577aa7", DSIUnifiedTunerReplyService.nextDynamicHandle(), "30be144b-1646-5c36-a6a8-468b18b19830", "dsi.radio.DSIUnifiedTuner"));
        this.p_DSIUnifiedTunerReply = dSIUnifiedTunerReply;
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
                    int n = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.selectStationStatus(n);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.updateAudioStatus(n, n2);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.updateDetectedDevice(n, n3);
                    break;
                }
                case 20: {
                    UnifiedStation unifiedStation = UnifiedStationSerializer.getOptionalUnifiedStation(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.updateSelectedStation(unifiedStation, n);
                    break;
                }
                case 22: {
                    UnifiedStation[] unifiedStationArray = UnifiedStationSerializer.getOptionalUnifiedStationVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.updateStationList(unifiedStationArray, n);
                    break;
                }
                case 18: {
                    UnifiedRadioText unifiedRadioText = UnifiedRadioTextSerializer.getOptionalUnifiedRadioText(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.updateRadioText(unifiedRadioText, n);
                    break;
                }
                case 16: {
                    UnifiedRadioText unifiedRadioText = UnifiedRadioTextSerializer.getOptionalUnifiedRadioText(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.updateEnhancedRadioText(unifiedRadioText, n);
                    break;
                }
                case 19: {
                    UnifiedRadioTextPlus unifiedRadioTextPlus = UnifiedRadioTextPlusSerializer.getOptionalUnifiedRadioTextPlus(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.updateRadioTextPlus(unifiedRadioTextPlus, n);
                    break;
                }
                case 17: {
                    UnifiedRadioTextPlus unifiedRadioTextPlus = UnifiedRadioTextPlusSerializer.getOptionalUnifiedRadioTextPlus(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.updateEnhancedRadioTextPlus(unifiedRadioTextPlus, n);
                    break;
                }
                case 21: {
                    DABSlideShowInfo dABSlideShowInfo = DABSlideShowInfoSerializer.getOptionalDABSlideShowInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.updateSlideShowInfo(dABSlideShowInfo, n);
                    break;
                }
                case 5: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.listMode(n);
                    break;
                }
                case 13: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.stationFollowingMode(n);
                    break;
                }
                case 30: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.updateSoftLinkSwitchStatus(n, n4);
                    break;
                }
                case 29: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.updateRegModeStatus(n, n5);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.updateDeviceUsageStatus(n, n6);
                    break;
                }
                case 39: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.updateProfileState(n, n7, n8);
                    break;
                }
                case 32: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.profileChanged(n, n9);
                    break;
                }
                case 33: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.profileCopied(n, n10, n11);
                    break;
                }
                case 36: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.profileReset(n, n12);
                    break;
                }
                case 38: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.profileResetAll(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSIUnifiedTunerReply.asyncException(n, string, n13);
                    break;
                }
                case 23: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIUnifiedTunerReply.yyIndication(string, string2);
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

