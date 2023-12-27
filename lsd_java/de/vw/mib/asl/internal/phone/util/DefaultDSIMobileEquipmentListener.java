/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.util;

import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.CallDuration;
import org.dsi.ifc.telephoneng.CallInformation;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentListener;
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

public class DefaultDSIMobileEquipmentListener
implements DSIMobileEquipmentListener {
    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void responseAbortNetworkRegistration(int n) {
    }

    @Override
    public void responseAbortNetworkSearch(int n) {
    }

    @Override
    public void responseAcceptCall(int n) {
    }

    @Override
    public void responseCallForward(CFResponseData[] cFResponseDataArray, int n) {
    }

    @Override
    public void responseCallWaiting(int n, int n2) {
    }

    @Override
    public void responseChangeSIMCode(int n, int n2) {
    }

    @Override
    public void responseCLIR(int n, int n2, int n3) {
    }

    @Override
    public void responseDialNumber(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
    }

    @Override
    public void responseDialOperator(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
    }

    @Override
    public void responseSendDTMF(int n) {
    }

    @Override
    public void updateDTMFTonePlaying(String string, int n) {
    }

    @Override
    public void updateEmergencyNumbers(EmergencyNumbers emergencyNumbers, int n) {
    }

    @Override
    public void responseRemoveOtherSIM(int n) {
    }

    @Override
    public void responseSIMPINRequired(int n) {
    }

    @Override
    public void updateOtherSIMAvailable(boolean bl, int n) {
    }

    @Override
    public void updateSIMPINRequired(boolean bl, int n) {
    }

    @Override
    public void responseHangupCall(int n) {
    }

    @Override
    public void responseJoinCalls(int n) {
    }

    @Override
    public void responseNetworkRegistration(int n) {
    }

    @Override
    public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n) {
    }

    @Override
    public void responseUnlockOtherSIM(int n) {
    }

    @Override
    public void responseUnlockSIM(int n) {
    }

    @Override
    public void responseCheckSIMPINCode(int n) {
    }

    @Override
    public void responseRestoreFactorySettings(int n) {
    }

    @Override
    public void responseSetHandsFreeMode(int n) {
    }

    @Override
    public void responseSetAutomaticPinEntryActive(int n) {
    }

    @Override
    public void responseSetAutomaticRedialActive(int n) {
    }

    @Override
    public void responseServiceCodeAbort(int n) {
    }

    @Override
    public void responseSplitCall(int n) {
    }

    @Override
    public void responseSwapCalls(int n) {
    }

    @Override
    public void responseTelPower(int n) {
    }

    @Override
    public void updateActivationState(ActivationStateStruct activationStateStruct, int n) {
    }

    @Override
    public void updateAutomaticPinEntryActive(boolean bl, int n) {
    }

    @Override
    public void updateAutomaticRedialActive(boolean bl, int n) {
    }

    @Override
    public void updateBatteryChargeLevel(int n, int n2) {
    }

    @Override
    public void updateCallDurationList(CallDuration[] callDurationArray, int n) {
    }

    @Override
    public void updateCallList(CallInformation[] callInformationArray, int n) {
    }

    @Override
    public void updateCDMAThreeWayCallingSetting(boolean bl, int n) {
    }

    @Override
    public void updateCradlePlugInState(int n, int n2) {
    }

    @Override
    public void updateDisconnectReason(DisconnectReason disconnectReason, int n) {
    }

    @Override
    public void updateEmergencyCallActive(EmergencyCallSetting emergencyCallSetting, int n) {
    }

    @Override
    public void updateEnhancedPrivacyMode(boolean bl, int n) {
    }

    @Override
    public void updateHandsFreeMode(int n, int n2) {
    }

    @Override
    public void updateLockState(LockStateStruct lockStateStruct, int n) {
    }

    @Override
    public void updateMailboxContent(MailboxDialingNumber[] mailboxDialingNumberArray, int n) {
    }

    @Override
    public void updateMICMuteState(int n, int n2) {
    }

    @Override
    public void updateNADTemperature(NADTemperatureStruct nADTemperatureStruct, int n) {
    }

    @Override
    public void updatePhoneInformation(PhoneInformation phoneInformation, int n) {
    }

    @Override
    public void updateNetworkProvider(NetworkProviderName networkProviderName, int n) {
    }

    @Override
    public void updateNetworkType(int n, int n2) {
    }

    @Override
    public void updatePrivacyMode(boolean bl, int n) {
    }

    @Override
    public void updateRegisterState(RegisterStateStruct registerStateStruct, int n) {
    }

    @Override
    public void updateServiceCodeType(ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
    }

    @Override
    public void updateServiceNumbers(ServiceNumbers serviceNumbers, int n) {
    }

    @Override
    public void updateSignalQuality(int n, int n2) {
    }

    @Override
    public void updateSuppServiceResponse(SuppServiceResponseStruct suppServiceResponseStruct, int n) {
    }

    @Override
    public void updateServiceProvider(ServiceProvider serviceProvider, int n) {
    }

    @Override
    public void updateNADMode(int n, int n2) {
    }

    @Override
    public void responseSetCDMAThreeWayCallingSetting(int n) {
    }

    @Override
    public void responseSetAutomaticEmergencyCallActive(int n) {
    }

    @Override
    public void responseSetMailboxContent(int n) {
    }

    @Override
    public void responseSetPrivacyMode(int n) {
    }

    @Override
    public void responseSetSIMAliases(int n) {
    }

    @Override
    public void responseSetMICMuteState(int n) {
    }

    @Override
    public void responseSetOptimizationMode(int n, int n2) {
    }

    @Override
    public void responseSetNADMode(int n, int n2) {
    }

    @Override
    public void updateMicGainLevel(int n, int n2) {
    }

    @Override
    public void updateSIMAliasInformation(SIMAliasInformation sIMAliasInformation, int n) {
    }

    @Override
    public void updateOptimizationMode(int n, int n2) {
    }

    @Override
    public void responseSetPhoneReminderSetting(int n) {
    }

    @Override
    public void responseSetPrefixActivated(int n) {
    }

    @Override
    public void responseSetPrefixContent(int n) {
    }

    @Override
    public void updatePhoneReminderSetting(boolean bl, int n) {
    }

    @Override
    public void updatePrefixActivated(boolean bl, int n) {
    }

    @Override
    public void updatePrefixContent(String string, int n) {
    }

    @Override
    public void updateWidebandSpeech(boolean bl, int n) {
    }

    @Override
    public void responseSetPhoneRingtone(int n) {
    }

    @Override
    public void updatePhoneRingtone(int n, String string, int n2) {
    }

    @Override
    public void responseSetFavorites(int n) {
    }

    @Override
    public void updateFavorites(Favorite[] favoriteArray, int n) {
    }

    @Override
    public void updateSAPUpgradeActive(boolean bl, int n) {
    }

    @Override
    public void responseSetSIMName(int n) {
    }

    @Override
    public void responseSetESIMActive(int n) {
    }

    @Override
    public void updateEUICCID(String string, int n) {
    }

    @Override
    public void updateESIMMSISDN(String string, int n) {
    }

    @Override
    public void updateESimActive(boolean bl, int n) {
    }

    @Override
    public void updateESimB2BMode(boolean bl, int n) {
    }

    @Override
    public void updateCallstacksIsReverted(boolean bl, int n) {
    }

    @Override
    public void updateLastAnsweredNumbers(CallStackEntry[] callStackEntryArray, int n) {
    }

    @Override
    public void updateLastDialedNumbers(CallStackEntry[] callStackEntryArray, int n) {
    }

    @Override
    public void updateMissedNumbers(CallStackEntry[] callStackEntryArray, int n) {
    }

    @Override
    public void updateMEDataValidity(int n, int n2) {
    }

    @Override
    public void updateMissedCallIndicator(MissedCallIndicator missedCallIndicator, int n) {
    }

    @Override
    public void updateSpeechRecognitionAvailable(int n, int n2) {
    }

    @Override
    public void updateSpeechRecognitionActive(int n, int n2) {
    }

    @Override
    public void updateSpeechRecognitionType(int n, int n2) {
    }

    @Override
    public void responseStartSpeechRecognition(int n) {
    }

    @Override
    public void responseStopSpeechRecognition(int n) {
    }
}

