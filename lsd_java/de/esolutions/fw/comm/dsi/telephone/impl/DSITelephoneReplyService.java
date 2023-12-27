/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.telephone.DSITelephoneReply;
import de.esolutions.fw.comm.dsi.telephone.impl.ActivationStateStructSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.CFResponseDataSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.CallDurationSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.CallInformationSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.DisconnectReasonSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.EmergencyCallSettingSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.EmergencyNumbersSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.FavoriteSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.LockStateStructSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.MailboxDialingNumberSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.NADTemperatureStructSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.NetworkProviderNameSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.NetworkProviderSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.PhoneInformationSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.RegisterStateStructSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.SIMAliasInformationSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.ServiceCodeTypeStructSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.ServiceNumbersSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.ServiceProviderSerializer;
import de.esolutions.fw.comm.dsi.telephone.impl.SuppServiceResponseStructSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.telephone.ActivationStateStruct;
import org.dsi.ifc.telephone.CFResponseData;
import org.dsi.ifc.telephone.CallDuration;
import org.dsi.ifc.telephone.CallInformation;
import org.dsi.ifc.telephone.DisconnectReason;
import org.dsi.ifc.telephone.EmergencyCallSetting;
import org.dsi.ifc.telephone.EmergencyNumbers;
import org.dsi.ifc.telephone.Favorite;
import org.dsi.ifc.telephone.LockStateStruct;
import org.dsi.ifc.telephone.MailboxDialingNumber;
import org.dsi.ifc.telephone.NADTemperatureStruct;
import org.dsi.ifc.telephone.NetworkProvider;
import org.dsi.ifc.telephone.NetworkProviderName;
import org.dsi.ifc.telephone.PhoneInformation;
import org.dsi.ifc.telephone.RegisterStateStruct;
import org.dsi.ifc.telephone.SIMAliasInformation;
import org.dsi.ifc.telephone.ServiceCodeTypeStruct;
import org.dsi.ifc.telephone.ServiceNumbers;
import org.dsi.ifc.telephone.ServiceProvider;
import org.dsi.ifc.telephone.SuppServiceResponseStruct;

public class DSITelephoneReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.telephone.DSITelephone");
    private static int dynamicHandle = 0;
    private DSITelephoneReply p_DSITelephoneReply;

    public DSITelephoneReplyService(DSITelephoneReply dSITelephoneReply) {
        super(new ServiceInstanceID("25f12cfd-9271-53a9-85ac-a32c7e22c883", DSITelephoneReplyService.nextDynamicHandle(), "e93a466b-517c-5536-8f06-34a36a204a42", "dsi.telephone.DSITelephone"));
        this.p_DSITelephoneReply = dSITelephoneReply;
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
                case 40: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseAbortNetworkRegistration(n);
                    break;
                }
                case 41: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseAbortNetworkSearch(n);
                    break;
                }
                case 42: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseAcceptCall(n);
                    break;
                }
                case 44: {
                    CFResponseData[] cFResponseDataArray = CFResponseDataSerializer.getOptionalCFResponseDataVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseCallForward(cFResponseDataArray, n);
                    break;
                }
                case 45: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseCallWaiting(n, n2);
                    break;
                }
                case 46: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseChangeSIMCode(n, n3);
                    break;
                }
                case 43: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseCLIR(n, n4, n5);
                    break;
                }
                case 48: {
                    int n = iDeserializer.getInt32();
                    SuppServiceResponseStruct suppServiceResponseStruct = SuppServiceResponseStructSerializer.getOptionalSuppServiceResponseStruct(iDeserializer);
                    this.p_DSITelephoneReply.responseDialNumber(n, suppServiceResponseStruct);
                    break;
                }
                case 118: {
                    int n = iDeserializer.getInt32();
                    SuppServiceResponseStruct suppServiceResponseStruct = SuppServiceResponseStructSerializer.getOptionalSuppServiceResponseStruct(iDeserializer);
                    this.p_DSITelephoneReply.responseDialOperator(n, suppServiceResponseStruct);
                    break;
                }
                case 56: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSendDTMF(n);
                    break;
                }
                case 89: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateDTMFTonePlaying(string, n);
                    break;
                }
                case 92: {
                    EmergencyNumbers emergencyNumbers = EmergencyNumbersSerializer.getOptionalEmergencyNumbers(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateEmergencyNumbers(emergencyNumbers, n);
                    break;
                }
                case 53: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseRemoveOtherSIM(n);
                    break;
                }
                case 121: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseAbortAlternatePhoneActivity(n);
                    break;
                }
                case 122: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseTogglePrioritizedPhoneDevice(n);
                    break;
                }
                case 55: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSIMPINRequired(n);
                    break;
                }
                case 104: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateOtherSIMAvailable(bl, n);
                    break;
                }
                case 109: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateSIMPINRequired(bl, n);
                    break;
                }
                case 49: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseHangupCall(n);
                    break;
                }
                case 50: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseJoinCalls(n);
                    break;
                }
                case 51: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseNetworkRegistration(n);
                    break;
                }
                case 52: {
                    NetworkProvider[] networkProviderArray = NetworkProviderSerializer.getOptionalNetworkProviderVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseNetworkSearch(networkProviderArray, n);
                    break;
                }
                case 72: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseUnlockOtherSIM(n);
                    break;
                }
                case 73: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseUnlockSIM(n);
                    break;
                }
                case 47: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseCheckSIMPINCode(n);
                    break;
                }
                case 54: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseRestoreFactorySettings(n);
                    break;
                }
                case 62: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSetHandsFreeMode(n);
                    break;
                }
                case 59: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSetAutomaticPinEntryActive(n);
                    break;
                }
                case 60: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSetAutomaticRedialActive(n);
                    break;
                }
                case 57: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseServiceCodeAbort(n);
                    break;
                }
                case 69: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSplitCall(n);
                    break;
                }
                case 70: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSwapCalls(n);
                    break;
                }
                case 71: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseTelPower(n);
                    break;
                }
                case 81: {
                    ActivationStateStruct activationStateStruct = ActivationStateStructSerializer.getOptionalActivationStateStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateActivationState(activationStateStruct, n);
                    break;
                }
                case 131: {
                    ActivationStateStruct activationStateStruct = ActivationStateStructSerializer.getOptionalActivationStateStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateActivationStateAssociated(activationStateStruct, n);
                    break;
                }
                case 82: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateAutomaticPinEntryActive(bl, n);
                    break;
                }
                case 83: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateAutomaticRedialActive(bl, n);
                    break;
                }
                case 84: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateBatteryChargeLevel(n, n6);
                    break;
                }
                case 86: {
                    CallDuration[] callDurationArray = CallDurationSerializer.getOptionalCallDurationVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateCallDurationList(callDurationArray, n);
                    break;
                }
                case 124: {
                    CallInformation[] callInformationArray = CallInformationSerializer.getOptionalCallInformationVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateCallList(callInformationArray, n);
                    break;
                }
                case 85: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateCDMAThreeWayCallingSetting(bl, n);
                    break;
                }
                case 88: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateCradlePlugInState(n, n7);
                    break;
                }
                case 90: {
                    DisconnectReason disconnectReason = DisconnectReasonSerializer.getOptionalDisconnectReason(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateDisconnectReason(disconnectReason, n);
                    break;
                }
                case 91: {
                    EmergencyCallSetting emergencyCallSetting = EmergencyCallSettingSerializer.getOptionalEmergencyCallSetting(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateEmergencyCallActive(emergencyCallSetting, n);
                    break;
                }
                case 93: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateEnhancedPrivacyMode(bl, n);
                    break;
                }
                case 94: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateHandsFreeMode(n, n8);
                    break;
                }
                case 95: {
                    LockStateStruct lockStateStruct = LockStateStructSerializer.getOptionalLockStateStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateLockState(lockStateStruct, n);
                    break;
                }
                case 97: {
                    MailboxDialingNumber[] mailboxDialingNumberArray = MailboxDialingNumberSerializer.getOptionalMailboxDialingNumberVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateMailboxContent(mailboxDialingNumberArray, n);
                    break;
                }
                case 96: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateMICMuteState(n, n9);
                    break;
                }
                case 100: {
                    NADTemperatureStruct nADTemperatureStruct = NADTemperatureStructSerializer.getOptionalNADTemperatureStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateNADTemperature(nADTemperatureStruct, n);
                    break;
                }
                case 147: {
                    PhoneInformation phoneInformation = PhoneInformationSerializer.getOptionalPhoneInformation(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updatePhoneInformation(phoneInformation, n);
                    break;
                }
                case 101: {
                    NetworkProviderName networkProviderName = NetworkProviderNameSerializer.getOptionalNetworkProviderName(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateNetworkProvider(networkProviderName, n);
                    break;
                }
                case 102: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateNetworkType(n, n10);
                    break;
                }
                case 106: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updatePrivacyMode(bl, n);
                    break;
                }
                case 107: {
                    RegisterStateStruct registerStateStruct = RegisterStateStructSerializer.getOptionalRegisterStateStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateRegisterState(registerStateStruct, n);
                    break;
                }
                case 110: {
                    ServiceCodeTypeStruct serviceCodeTypeStruct = ServiceCodeTypeStructSerializer.getOptionalServiceCodeTypeStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateServiceCodeType(serviceCodeTypeStruct, n);
                    break;
                }
                case 111: {
                    ServiceNumbers serviceNumbers = ServiceNumbersSerializer.getOptionalServiceNumbers(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateServiceNumbers(serviceNumbers, n);
                    break;
                }
                case 113: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateSignalQuality(n, n11);
                    break;
                }
                case 114: {
                    SuppServiceResponseStruct suppServiceResponseStruct = SuppServiceResponseStructSerializer.getOptionalSuppServiceResponseStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateSuppServiceResponse(suppServiceResponseStruct, n);
                    break;
                }
                case 112: {
                    ServiceProvider serviceProvider = ServiceProviderSerializer.getOptionalServiceProvider(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateServiceProvider(serviceProvider, n);
                    break;
                }
                case 99: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateNADMode(n, n12);
                    break;
                }
                case 123: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateAlternatePhoneActivity(bl, n);
                    break;
                }
                case 61: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSetCDMAThreeWayCallingSetting(n);
                    break;
                }
                case 58: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSetAutomaticEmergencyCallActive(n);
                    break;
                }
                case 64: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSetMailboxContent(n);
                    break;
                }
                case 67: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSetPrivacyMode(n);
                    break;
                }
                case 68: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSetSIMAliases(n);
                    break;
                }
                case 63: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSetMICMuteState(n);
                    break;
                }
                case 66: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSetOptimizationMode(n, n13);
                    break;
                }
                case 65: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSetNADMode(n, n14);
                    break;
                }
                case 98: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateMicGainLevel(n, n15);
                    break;
                }
                case 108: {
                    SIMAliasInformation sIMAliasInformation = SIMAliasInformationSerializer.getOptionalSIMAliasInformation(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateSIMAliasInformation(sIMAliasInformation, n);
                    break;
                }
                case 103: {
                    int n = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateOptimizationMode(n, n16);
                    break;
                }
                case 128: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSetPhoneReminderSetting(n);
                    break;
                }
                case 129: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSetPrefixActivated(n);
                    break;
                }
                case 130: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSetPrefixContent(n);
                    break;
                }
                case 132: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updatePhoneReminderSetting(bl, n);
                    break;
                }
                case 133: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updatePrefixActivated(bl, n);
                    break;
                }
                case 134: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updatePrefixContent(string, n);
                    break;
                }
                case 142: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateWidebandSpeech(bl, n);
                    break;
                }
                case 138: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSetPhoneRingtone(n);
                    break;
                }
                case 141: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n17 = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updatePhoneRingtone(n, string, n17);
                    break;
                }
                case 137: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSetFavorites(n);
                    break;
                }
                case 139: {
                    Favorite[] favoriteArray = FavoriteSerializer.getOptionalFavoriteVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateFavorites(favoriteArray, n);
                    break;
                }
                case 143: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateSAPUpgradeActive(bl, n);
                    break;
                }
                case 146: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSetSIMName(n);
                    break;
                }
                case 149: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.responseSetESIMActive(n);
                    break;
                }
                case 152: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateEUICCID(string, n);
                    break;
                }
                case 150: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateESIMMSISDN(string, n);
                    break;
                }
                case 151: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateESimActive(bl, n);
                    break;
                }
                case 153: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.updateESimB2BMode(bl, n);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n18 = iDeserializer.getInt32();
                    this.p_DSITelephoneReply.asyncException(n, string, n18);
                    break;
                }
                case 115: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSITelephoneReply.yyIndication(string, string2);
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

