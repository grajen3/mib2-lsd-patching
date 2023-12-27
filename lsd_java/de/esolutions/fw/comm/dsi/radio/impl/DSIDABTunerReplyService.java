/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.radio.DSIDABTunerReply;
import de.esolutions.fw.comm.dsi.radio.impl.AudioStatusSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.ComponentInfoSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.DABRadioTextPlusInfoSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.DABRadioTextSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.DABSlideShowInfoSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.DataServiceInfoSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.EPGFullInfoSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.EPGLogoSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.EPGShortInfoSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.EnsembleInfoSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.FrequencyInfoSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.IntellitextMenuSerializer;
import de.esolutions.fw.comm.dsi.radio.impl.ServiceInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.AudioStatus;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DABRadioText;
import org.dsi.ifc.radio.DABRadioTextPlusInfo;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.DataServiceInfo;
import org.dsi.ifc.radio.EPGFullInfo;
import org.dsi.ifc.radio.EPGLogo;
import org.dsi.ifc.radio.EPGShortInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.IntellitextMenu;
import org.dsi.ifc.radio.ServiceInfo;

public class DSIDABTunerReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.radio.DSIDABTuner");
    private static int dynamicHandle = 0;
    private DSIDABTunerReply p_DSIDABTunerReply;

    public DSIDABTunerReplyService(DSIDABTunerReply dSIDABTunerReply) {
        super(new ServiceInstanceID("3fbfdf95-fc8b-5629-8f28-b325d5f820f4", DSIDABTunerReplyService.nextDynamicHandle(), "61784239-985b-53d5-a461-2d04f297b9d6", "dsi.radio.DSIDABTuner"));
        this.p_DSIDABTunerReply = dSIDABTunerReply;
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
                case 52: {
                    EnsembleInfo ensembleInfo = EnsembleInfoSerializer.getOptionalEnsembleInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateSelectedEnsemble(ensembleInfo, n);
                    break;
                }
                case 54: {
                    ServiceInfo serviceInfo = ServiceInfoSerializer.getOptionalServiceInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateSelectedService(serviceInfo, n);
                    break;
                }
                case 51: {
                    ComponentInfo componentInfo = ComponentInfoSerializer.getOptionalComponentInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateSelectedComponent(componentInfo, n);
                    break;
                }
                case 53: {
                    FrequencyInfo frequencyInfo = FrequencyInfoSerializer.getOptionalFrequencyInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateSelectedFrequency(frequencyInfo, n);
                    break;
                }
                case 39: {
                    EnsembleInfo[] ensembleInfoArray = EnsembleInfoSerializer.getOptionalEnsembleInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateEnsembleList(ensembleInfoArray, n);
                    break;
                }
                case 55: {
                    ServiceInfo[] serviceInfoArray = ServiceInfoSerializer.getOptionalServiceInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateServiceList(serviceInfoArray, n);
                    break;
                }
                case 31: {
                    ComponentInfo[] componentInfoArray = ComponentInfoSerializer.getOptionalComponentInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateComponentList(componentInfoArray, n);
                    break;
                }
                case 33: {
                    DataServiceInfo[] dataServiceInfoArray = DataServiceInfoSerializer.getOptionalDataServiceInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateDataServiceList(dataServiceInfoArray, n);
                    break;
                }
                case 41: {
                    FrequencyInfo[] frequencyInfoArray = FrequencyInfoSerializer.getOptionalFrequencyInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateFrequencyList(frequencyInfoArray, n);
                    break;
                }
                case 49: {
                    DABRadioText dABRadioText = DABRadioTextSerializer.getOptionalDABRadioText(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateRadioText(dABRadioText, n);
                    break;
                }
                case 57: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateSyncStatus(n, n2);
                    break;
                }
                case 47: {
                    short s2 = iDeserializer.getInt16();
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateQuality(s2, n);
                    break;
                }
                case 32: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateDRCSwitchStatus(bl, n);
                    break;
                }
                case 45: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateLinkingSwitchStatus(n, n3);
                    break;
                }
                case 42: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateFrequencyTableSwitchStatus(n, n4);
                    break;
                }
                case 44: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateLinkingStatus(n, n5);
                    break;
                }
                case 46: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateLinkingUsageStatus(n, n6);
                    break;
                }
                case 29: {
                    AudioStatus audioStatus = AudioStatusSerializer.getOptionalAudioStatus(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateAudioStatus(audioStatus, n);
                    break;
                }
                case 35: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateDetectedDevice(n, n7);
                    break;
                }
                case 48: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateQualityInfo(string, n);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.selectServiceStatus(n);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.seekServiceStatus(n);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.tuneEnsembleStatus(n);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.selectDataServiceStatus(n);
                    break;
                }
                case 61: {
                    DABRadioTextPlusInfo dABRadioTextPlusInfo = DABRadioTextPlusInfoSerializer.getOptionalDABRadioTextPlusInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateRadioTextPlusInfo(dABRadioTextPlusInfo, n);
                    break;
                }
                case 34: {
                    DataServiceInfo dataServiceInfo = DataServiceInfoSerializer.getOptionalDataServiceInfo(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateDecodedDataService(dataServiceInfo, bl, string, n);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.forceLMUpdateStatus(n);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.prepareTuningStatus(n);
                    break;
                }
                case 40: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    ResourceLocator[] resourceLocatorArray = ResourceLocatorSerializer.getOptionalResourceLocatorVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateEpgLogo(nArray, resourceLocatorArray, n);
                    break;
                }
                case 66: {
                    EPGLogo[] ePGLogoArray = EPGLogoSerializer.getOptionalEPGLogoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateEpgLogoList(ePGLogoArray, n);
                    break;
                }
                case 62: {
                    DABSlideShowInfo dABSlideShowInfo = DABSlideShowInfoSerializer.getOptionalDABSlideShowInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateSlideShowInfo(dABSlideShowInfo, n);
                    break;
                }
                case 30: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateAvailability(n, n8);
                    break;
                }
                case 43: {
                    IntellitextMenu[] intellitextMenuArray = IntellitextMenuSerializer.getOptionalIntellitextMenuVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateIntellitext(intellitextMenuArray, n);
                    break;
                }
                case 38: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateEPGMode(n, n9);
                    break;
                }
                case 65: {
                    EPGShortInfo[] ePGShortInfoArray = EPGShortInfoSerializer.getOptionalEPGShortInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateEPGListData(ePGShortInfoArray, n);
                    break;
                }
                case 64: {
                    EPGFullInfo ePGFullInfo = EPGFullInfoSerializer.getOptionalEPGFullInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateEPGDetailData(ePGFullInfo, n);
                    break;
                }
                case 75: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.updateProfileState(n, n10, n11);
                    break;
                }
                case 68: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.profileChanged(n, n12);
                    break;
                }
                case 69: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.profileCopied(n, n13, n14);
                    break;
                }
                case 72: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.profileReset(n, n15);
                    break;
                }
                case 74: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.profileResetAll(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n16 = iDeserializer.getInt32();
                    this.p_DSIDABTunerReply.asyncException(n, string, n16);
                    break;
                }
                case 58: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIDABTunerReply.yyIndication(string, string2);
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

