/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephoneng.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.telephoneng.DSIMobileEquipmentReply;
import de.esolutions.fw.comm.dsi.telephoneng.impl.ActivationStateStructSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.CFResponseDataSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.CallDurationSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.CallInformationSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.CallStackEntrySerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.DisconnectReasonSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.EmergencyCallSettingSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.EmergencyNumbersSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.FavoriteSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.LockStateStructSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.MailboxDialingNumberSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.MissedCallIndicatorSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.NADTemperatureStructSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.NetworkProviderNameSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.NetworkProviderSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.PhoneInformationSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.RegisterStateStructSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.SIMAliasInformationSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.ServiceCodeTypeStructSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.ServiceNumbersSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.ServiceProviderSerializer;
import de.esolutions.fw.comm.dsi.telephoneng.impl.SuppServiceResponseStructSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.CallDuration;
import org.dsi.ifc.telephoneng.CallInformation;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.dsi.ifc.telephoneng.DisconnectReason;
import org.dsi.ifc.telephoneng.EmergencyCallSetting;
import org.dsi.ifc.telephoneng.EmergencyNumbers;
import org.dsi.ifc.telephoneng.Favorite;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.MailboxDialingNumber;
import org.dsi.ifc.telephoneng.MissedCallIndicator;
import org.dsi.ifc.telephoneng.NADTemperatureStruct;
import org.dsi.ifc.telephoneng.NetworkProvider;
import org.dsi.ifc.telephoneng.NetworkProviderName;
import org.dsi.ifc.telephoneng.PhoneInformation;
import org.dsi.ifc.telephoneng.RegisterStateStruct;
import org.dsi.ifc.telephoneng.SIMAliasInformation;
import org.dsi.ifc.telephoneng.ServiceCodeTypeStruct;
import org.dsi.ifc.telephoneng.ServiceNumbers;
import org.dsi.ifc.telephoneng.ServiceProvider;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public class DSIMobileEquipmentReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.telephoneng.DSIMobileEquipment");
    private static int dynamicHandle = 0;
    private DSIMobileEquipmentReply p_DSIMobileEquipmentReply;

    public DSIMobileEquipmentReplyService(DSIMobileEquipmentReply dSIMobileEquipmentReply) {
        super(new ServiceInstanceID("b4f3ee31-c5b9-5453-92f4-4c6aa7a14932", DSIMobileEquipmentReplyService.nextDynamicHandle(), "ec77018c-22f8-5516-8db3-53e80e7b2c17", "dsi.telephoneng.DSIMobileEquipment"));
        this.p_DSIMobileEquipmentReply = dSIMobileEquipmentReply;
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
                case 51: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseAbortNetworkRegistration(n);
                    break;
                }
                case 52: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseAbortNetworkSearch(n);
                    break;
                }
                case 53: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseAcceptCall(n);
                    break;
                }
                case 165: {
                    CFResponseData[] cFResponseDataArray = CFResponseDataSerializer.getOptionalCFResponseDataVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseCallForward(cFResponseDataArray, n);
                    break;
                }
                case 56: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseCallWaiting(n, n2);
                    break;
                }
                case 57: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseChangeSIMCode(n, n3);
                    break;
                }
                case 54: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseCLIR(n, n4, n5);
                    break;
                }
                case 166: {
                    int n = iDeserializer.getInt32();
                    SuppServiceResponseStruct suppServiceResponseStruct = SuppServiceResponseStructSerializer.getOptionalSuppServiceResponseStruct(iDeserializer);
                    this.p_DSIMobileEquipmentReply.responseDialNumber(n, suppServiceResponseStruct);
                    break;
                }
                case 167: {
                    int n = iDeserializer.getInt32();
                    SuppServiceResponseStruct suppServiceResponseStruct = SuppServiceResponseStructSerializer.getOptionalSuppServiceResponseStruct(iDeserializer);
                    this.p_DSIMobileEquipmentReply.responseDialOperator(n, suppServiceResponseStruct);
                    break;
                }
                case 68: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSendDTMF(n);
                    break;
                }
                case 110: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateDTMFTonePlaying(string, n);
                    break;
                }
                case 117: {
                    EmergencyNumbers emergencyNumbers = EmergencyNumbersSerializer.getOptionalEmergencyNumbers(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateEmergencyNumbers(emergencyNumbers, n);
                    break;
                }
                case 65: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseRemoveOtherSIM(n);
                    break;
                }
                case 67: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSIMPINRequired(n);
                    break;
                }
                case 135: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateOtherSIMAvailable(bl, n);
                    break;
                }
                case 145: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateSIMPINRequired(bl, n);
                    break;
                }
                case 61: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseHangupCall(n);
                    break;
                }
                case 62: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseJoinCalls(n);
                    break;
                }
                case 63: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseNetworkRegistration(n);
                    break;
                }
                case 64: {
                    NetworkProvider[] networkProviderArray = NetworkProviderSerializer.getOptionalNetworkProviderVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseNetworkSearch(networkProviderArray, n);
                    break;
                }
                case 91: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseUnlockOtherSIM(n);
                    break;
                }
                case 92: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseUnlockSIM(n);
                    break;
                }
                case 58: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseCheckSIMPINCode(n);
                    break;
                }
                case 66: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseRestoreFactorySettings(n);
                    break;
                }
                case 76: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSetHandsFreeMode(n);
                    break;
                }
                case 71: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSetAutomaticPinEntryActive(n);
                    break;
                }
                case 72: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSetAutomaticRedialActive(n);
                    break;
                }
                case 69: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseServiceCodeAbort(n);
                    break;
                }
                case 88: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSplitCall(n);
                    break;
                }
                case 89: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSwapCalls(n);
                    break;
                }
                case 90: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseTelPower(n);
                    break;
                }
                case 101: {
                    ActivationStateStruct activationStateStruct = ActivationStateStructSerializer.getOptionalActivationStateStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateActivationState(activationStateStruct, n);
                    break;
                }
                case 102: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateAutomaticPinEntryActive(bl, n);
                    break;
                }
                case 103: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateAutomaticRedialActive(bl, n);
                    break;
                }
                case 104: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateBatteryChargeLevel(n, n6);
                    break;
                }
                case 106: {
                    CallDuration[] callDurationArray = CallDurationSerializer.getOptionalCallDurationVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateCallDurationList(callDurationArray, n);
                    break;
                }
                case 161: {
                    CallInformation[] callInformationArray = CallInformationSerializer.getOptionalCallInformationVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateCallList(callInformationArray, n);
                    break;
                }
                case 105: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateCDMAThreeWayCallingSetting(bl, n);
                    break;
                }
                case 109: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateCradlePlugInState(n, n7);
                    break;
                }
                case 111: {
                    DisconnectReason disconnectReason = DisconnectReasonSerializer.getOptionalDisconnectReason(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateDisconnectReason(disconnectReason, n);
                    break;
                }
                case 116: {
                    EmergencyCallSetting emergencyCallSetting = EmergencyCallSettingSerializer.getOptionalEmergencyCallSetting(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateEmergencyCallActive(emergencyCallSetting, n);
                    break;
                }
                case 118: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateEnhancedPrivacyMode(bl, n);
                    break;
                }
                case 120: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateHandsFreeMode(n, n8);
                    break;
                }
                case 123: {
                    LockStateStruct lockStateStruct = LockStateStructSerializer.getOptionalLockStateStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateLockState(lockStateStruct, n);
                    break;
                }
                case 126: {
                    MailboxDialingNumber[] mailboxDialingNumberArray = MailboxDialingNumberSerializer.getOptionalMailboxDialingNumberVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateMailboxContent(mailboxDialingNumberArray, n);
                    break;
                }
                case 125: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateMICMuteState(n, n9);
                    break;
                }
                case 131: {
                    NADTemperatureStruct nADTemperatureStruct = NADTemperatureStructSerializer.getOptionalNADTemperatureStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateNADTemperature(nADTemperatureStruct, n);
                    break;
                }
                case 136: {
                    PhoneInformation phoneInformation = PhoneInformationSerializer.getOptionalPhoneInformation(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updatePhoneInformation(phoneInformation, n);
                    break;
                }
                case 132: {
                    NetworkProviderName networkProviderName = NetworkProviderNameSerializer.getOptionalNetworkProviderName(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateNetworkProvider(networkProviderName, n);
                    break;
                }
                case 133: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateNetworkType(n, n10);
                    break;
                }
                case 141: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updatePrivacyMode(bl, n);
                    break;
                }
                case 142: {
                    RegisterStateStruct registerStateStruct = RegisterStateStructSerializer.getOptionalRegisterStateStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateRegisterState(registerStateStruct, n);
                    break;
                }
                case 146: {
                    ServiceCodeTypeStruct serviceCodeTypeStruct = ServiceCodeTypeStructSerializer.getOptionalServiceCodeTypeStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateServiceCodeType(serviceCodeTypeStruct, n);
                    break;
                }
                case 147: {
                    ServiceNumbers serviceNumbers = ServiceNumbersSerializer.getOptionalServiceNumbers(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateServiceNumbers(serviceNumbers, n);
                    break;
                }
                case 149: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateSignalQuality(n, n11);
                    break;
                }
                case 168: {
                    SuppServiceResponseStruct suppServiceResponseStruct = SuppServiceResponseStructSerializer.getOptionalSuppServiceResponseStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateSuppServiceResponse(suppServiceResponseStruct, n);
                    break;
                }
                case 148: {
                    ServiceProvider serviceProvider = ServiceProviderSerializer.getOptionalServiceProvider(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateServiceProvider(serviceProvider, n);
                    break;
                }
                case 130: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateNADMode(n, n12);
                    break;
                }
                case 73: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSetCDMAThreeWayCallingSetting(n);
                    break;
                }
                case 70: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSetAutomaticEmergencyCallActive(n);
                    break;
                }
                case 78: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSetMailboxContent(n);
                    break;
                }
                case 85: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSetPrivacyMode(n);
                    break;
                }
                case 86: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSetSIMAliases(n);
                    break;
                }
                case 77: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSetMICMuteState(n);
                    break;
                }
                case 80: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSetOptimizationMode(n, n13);
                    break;
                }
                case 79: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSetNADMode(n, n14);
                    break;
                }
                case 127: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateMicGainLevel(n, n15);
                    break;
                }
                case 144: {
                    SIMAliasInformation sIMAliasInformation = SIMAliasInformationSerializer.getOptionalSIMAliasInformation(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateSIMAliasInformation(sIMAliasInformation, n);
                    break;
                }
                case 134: {
                    int n = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateOptimizationMode(n, n16);
                    break;
                }
                case 81: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSetPhoneReminderSetting(n);
                    break;
                }
                case 83: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSetPrefixActivated(n);
                    break;
                }
                case 84: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSetPrefixContent(n);
                    break;
                }
                case 137: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updatePhoneReminderSetting(bl, n);
                    break;
                }
                case 139: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updatePrefixActivated(bl, n);
                    break;
                }
                case 140: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updatePrefixContent(string, n);
                    break;
                }
                case 151: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateWidebandSpeech(bl, n);
                    break;
                }
                case 82: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSetPhoneRingtone(n);
                    break;
                }
                case 138: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n17 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updatePhoneRingtone(n, string, n17);
                    break;
                }
                case 75: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSetFavorites(n);
                    break;
                }
                case 119: {
                    Favorite[] favoriteArray = FavoriteSerializer.getOptionalFavoriteVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateFavorites(favoriteArray, n);
                    break;
                }
                case 143: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateSAPUpgradeActive(bl, n);
                    break;
                }
                case 87: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSetSIMName(n);
                    break;
                }
                case 74: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseSetESIMActive(n);
                    break;
                }
                case 115: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateEUICCID(string, n);
                    break;
                }
                case 112: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateESIMMSISDN(string, n);
                    break;
                }
                case 113: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateESimActive(bl, n);
                    break;
                }
                case 114: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateESimB2BMode(bl, n);
                    break;
                }
                case 108: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateCallstacksIsReverted(bl, n);
                    break;
                }
                case 162: {
                    CallStackEntry[] callStackEntryArray = CallStackEntrySerializer.getOptionalCallStackEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateLastAnsweredNumbers(callStackEntryArray, n);
                    break;
                }
                case 163: {
                    CallStackEntry[] callStackEntryArray = CallStackEntrySerializer.getOptionalCallStackEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateLastDialedNumbers(callStackEntryArray, n);
                    break;
                }
                case 164: {
                    CallStackEntry[] callStackEntryArray = CallStackEntrySerializer.getOptionalCallStackEntryVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateMissedNumbers(callStackEntryArray, n);
                    break;
                }
                case 124: {
                    int n = iDeserializer.getInt32();
                    int n18 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateMEDataValidity(n, n18);
                    break;
                }
                case 128: {
                    MissedCallIndicator missedCallIndicator = MissedCallIndicatorSerializer.getOptionalMissedCallIndicator(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateMissedCallIndicator(missedCallIndicator, n);
                    break;
                }
                case 159: {
                    int n = iDeserializer.getInt32();
                    int n19 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateSpeechRecognitionAvailable(n, n19);
                    break;
                }
                case 158: {
                    int n = iDeserializer.getInt32();
                    int n20 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateSpeechRecognitionActive(n, n20);
                    break;
                }
                case 160: {
                    int n = iDeserializer.getInt32();
                    int n21 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.updateSpeechRecognitionType(n, n21);
                    break;
                }
                case 156: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseStartSpeechRecognition(n);
                    break;
                }
                case 157: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.responseStopSpeechRecognition(n);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n22 = iDeserializer.getInt32();
                    this.p_DSIMobileEquipmentReply.asyncException(n, string, n22);
                    break;
                }
                case 152: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIMobileEquipmentReply.yyIndication(string, string2);
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

