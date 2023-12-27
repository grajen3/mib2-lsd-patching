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

public class DSIMobileEquipmentListenerDelegate
implements DSIMobileEquipmentListener {
    public DSIMobileEquipmentListener receiver;

    @Override
    public void responseAbortNetworkRegistration(int n) {
        if (this.receiver != null) {
            this.receiver.responseAbortNetworkRegistration(n);
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        if (this.receiver != null) {
            this.receiver.asyncException(n, string, n2);
        }
    }

    @Override
    public void responseAbortNetworkSearch(int n) {
        if (this.receiver != null) {
            this.receiver.responseAbortNetworkSearch(n);
        }
    }

    @Override
    public void responseAcceptCall(int n) {
        if (this.receiver != null) {
            this.receiver.responseAcceptCall(n);
        }
    }

    @Override
    public void responseCallForward(CFResponseData[] cFResponseDataArray, int n) {
        if (this.receiver != null) {
            this.receiver.responseCallForward(cFResponseDataArray, n);
        }
    }

    @Override
    public void responseCallWaiting(int n, int n2) {
        if (this.receiver != null) {
            this.receiver.responseCallWaiting(n, n2);
        }
    }

    @Override
    public void responseChangeSIMCode(int n, int n2) {
        if (this.receiver != null) {
            this.receiver.responseChangeSIMCode(n, n2);
        }
    }

    @Override
    public void responseCLIR(int n, int n2, int n3) {
        if (this.receiver != null) {
            this.receiver.responseCLIR(n, n2, n3);
        }
    }

    @Override
    public void responseDialNumber(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
        if (this.receiver != null) {
            this.receiver.responseDialNumber(n, suppServiceResponseStruct);
        }
    }

    @Override
    public void responseDialOperator(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
        if (this.receiver != null) {
            this.receiver.responseDialOperator(n, suppServiceResponseStruct);
        }
    }

    @Override
    public void responseSendDTMF(int n) {
        if (this.receiver != null) {
            this.receiver.responseSendDTMF(n);
        }
    }

    @Override
    public void updateDTMFTonePlaying(String string, int n) {
        if (this.receiver != null) {
            this.receiver.updateDTMFTonePlaying(string, n);
        }
    }

    @Override
    public void updateEmergencyNumbers(EmergencyNumbers emergencyNumbers, int n) {
        if (this.receiver != null) {
            this.receiver.updateEmergencyNumbers(emergencyNumbers, n);
        }
    }

    @Override
    public void responseRemoveOtherSIM(int n) {
        if (this.receiver != null) {
            this.receiver.responseRemoveOtherSIM(n);
        }
    }

    @Override
    public void responseSIMPINRequired(int n) {
        if (this.receiver != null) {
            this.receiver.responseSIMPINRequired(n);
        }
    }

    @Override
    public void updateOtherSIMAvailable(boolean bl, int n) {
        if (this.receiver != null) {
            this.receiver.updateOtherSIMAvailable(bl, n);
        }
    }

    @Override
    public void updateSIMPINRequired(boolean bl, int n) {
        if (this.receiver != null) {
            this.receiver.updateSIMPINRequired(bl, n);
        }
    }

    @Override
    public void responseHangupCall(int n) {
        if (this.receiver != null) {
            this.receiver.responseHangupCall(n);
        }
    }

    @Override
    public void responseJoinCalls(int n) {
        if (this.receiver != null) {
            this.receiver.responseJoinCalls(n);
        }
    }

    @Override
    public void responseNetworkRegistration(int n) {
        if (this.receiver != null) {
            this.receiver.responseNetworkRegistration(n);
        }
    }

    @Override
    public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n) {
        if (this.receiver != null) {
            this.receiver.responseNetworkSearch(networkProviderArray, n);
        }
    }

    @Override
    public void responseUnlockOtherSIM(int n) {
        if (this.receiver != null) {
            this.receiver.responseUnlockOtherSIM(n);
        }
    }

    @Override
    public void responseUnlockSIM(int n) {
        if (this.receiver != null) {
            this.receiver.responseUnlockSIM(n);
        }
    }

    @Override
    public void responseCheckSIMPINCode(int n) {
        if (this.receiver != null) {
            this.receiver.responseCheckSIMPINCode(n);
        }
    }

    @Override
    public void responseRestoreFactorySettings(int n) {
        if (this.receiver != null) {
            this.receiver.responseRestoreFactorySettings(n);
        }
    }

    @Override
    public void responseSetHandsFreeMode(int n) {
        if (this.receiver != null) {
            this.receiver.responseSetHandsFreeMode(n);
        }
    }

    @Override
    public void responseSetAutomaticPinEntryActive(int n) {
        if (this.receiver != null) {
            this.receiver.responseSetAutomaticPinEntryActive(n);
        }
    }

    @Override
    public void responseSetAutomaticRedialActive(int n) {
        if (this.receiver != null) {
            this.receiver.responseSetAutomaticRedialActive(n);
        }
    }

    @Override
    public void responseServiceCodeAbort(int n) {
        if (this.receiver != null) {
            this.receiver.responseServiceCodeAbort(n);
        }
    }

    @Override
    public void responseSplitCall(int n) {
        if (this.receiver != null) {
            this.receiver.responseSplitCall(n);
        }
    }

    @Override
    public void responseSwapCalls(int n) {
        if (this.receiver != null) {
            this.receiver.responseSwapCalls(n);
        }
    }

    @Override
    public void responseTelPower(int n) {
        if (this.receiver != null) {
            this.receiver.responseTelPower(n);
        }
    }

    @Override
    public void updateActivationState(ActivationStateStruct activationStateStruct, int n) {
        if (this.receiver != null) {
            this.receiver.updateActivationState(activationStateStruct, n);
        }
    }

    @Override
    public void updateAutomaticPinEntryActive(boolean bl, int n) {
        if (this.receiver != null) {
            this.receiver.updateAutomaticPinEntryActive(bl, n);
        }
    }

    @Override
    public void updateAutomaticRedialActive(boolean bl, int n) {
        if (this.receiver != null) {
            this.receiver.updateAutomaticRedialActive(bl, n);
        }
    }

    @Override
    public void updateBatteryChargeLevel(int n, int n2) {
        if (this.receiver != null) {
            this.receiver.updateBatteryChargeLevel(n, n2);
        }
    }

    @Override
    public void updateCallDurationList(CallDuration[] callDurationArray, int n) {
        if (this.receiver != null) {
            this.receiver.updateCallDurationList(callDurationArray, n);
        }
    }

    @Override
    public void updateCallList(CallInformation[] callInformationArray, int n) {
        if (this.receiver != null) {
            this.receiver.updateCallList(callInformationArray, n);
        }
    }

    @Override
    public void updateCDMAThreeWayCallingSetting(boolean bl, int n) {
        if (this.receiver != null) {
            this.receiver.updateCDMAThreeWayCallingSetting(bl, n);
        }
    }

    @Override
    public void updateCradlePlugInState(int n, int n2) {
        if (this.receiver != null) {
            this.receiver.updateCradlePlugInState(n, n2);
        }
    }

    @Override
    public void updateDisconnectReason(DisconnectReason disconnectReason, int n) {
        if (this.receiver != null) {
            this.receiver.updateDisconnectReason(disconnectReason, n);
        }
    }

    @Override
    public void updateEmergencyCallActive(EmergencyCallSetting emergencyCallSetting, int n) {
        if (this.receiver != null) {
            this.receiver.updateEmergencyCallActive(emergencyCallSetting, n);
        }
    }

    @Override
    public void updateEnhancedPrivacyMode(boolean bl, int n) {
        if (this.receiver != null) {
            this.receiver.updateEnhancedPrivacyMode(bl, n);
        }
    }

    @Override
    public void updateHandsFreeMode(int n, int n2) {
        if (this.receiver != null) {
            this.receiver.updateHandsFreeMode(n, n2);
        }
    }

    @Override
    public void updateLockState(LockStateStruct lockStateStruct, int n) {
        if (this.receiver != null) {
            this.receiver.updateLockState(lockStateStruct, n);
        }
    }

    @Override
    public void updateMailboxContent(MailboxDialingNumber[] mailboxDialingNumberArray, int n) {
        if (this.receiver != null) {
            this.receiver.updateMailboxContent(mailboxDialingNumberArray, n);
        }
    }

    @Override
    public void updateMICMuteState(int n, int n2) {
        if (this.receiver != null) {
            this.receiver.updateMICMuteState(n, n2);
        }
    }

    @Override
    public void updateNADTemperature(NADTemperatureStruct nADTemperatureStruct, int n) {
        if (this.receiver != null) {
            this.receiver.updateNADTemperature(nADTemperatureStruct, n);
        }
    }

    @Override
    public void updatePhoneInformation(PhoneInformation phoneInformation, int n) {
        if (this.receiver != null) {
            this.receiver.updatePhoneInformation(phoneInformation, n);
        }
    }

    @Override
    public void updateNetworkProvider(NetworkProviderName networkProviderName, int n) {
        if (this.receiver != null) {
            this.receiver.updateNetworkProvider(networkProviderName, n);
        }
    }

    @Override
    public void updateNetworkType(int n, int n2) {
        if (this.receiver != null) {
            this.receiver.updateNetworkType(n, n2);
        }
    }

    @Override
    public void updatePrivacyMode(boolean bl, int n) {
        if (this.receiver != null) {
            this.receiver.updatePrivacyMode(bl, n);
        }
    }

    @Override
    public void updateRegisterState(RegisterStateStruct registerStateStruct, int n) {
        if (this.receiver != null) {
            this.receiver.updateRegisterState(registerStateStruct, n);
        }
    }

    @Override
    public void updateServiceCodeType(ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
        if (this.receiver != null) {
            this.receiver.updateServiceCodeType(serviceCodeTypeStruct, n);
        }
    }

    @Override
    public void updateServiceNumbers(ServiceNumbers serviceNumbers, int n) {
        if (this.receiver != null) {
            this.receiver.updateServiceNumbers(serviceNumbers, n);
        }
    }

    @Override
    public void updateSignalQuality(int n, int n2) {
        if (this.receiver != null) {
            this.receiver.updateSignalQuality(n, n2);
        }
    }

    @Override
    public void updateSuppServiceResponse(SuppServiceResponseStruct suppServiceResponseStruct, int n) {
        if (this.receiver != null) {
            this.receiver.updateSuppServiceResponse(suppServiceResponseStruct, n);
        }
    }

    @Override
    public void updateServiceProvider(ServiceProvider serviceProvider, int n) {
        if (this.receiver != null) {
            this.receiver.updateServiceProvider(serviceProvider, n);
        }
    }

    @Override
    public void updateNADMode(int n, int n2) {
        if (this.receiver != null) {
            this.receiver.updateNADMode(n, n2);
        }
    }

    @Override
    public void responseSetCDMAThreeWayCallingSetting(int n) {
        if (this.receiver != null) {
            this.receiver.responseSetCDMAThreeWayCallingSetting(n);
        }
    }

    @Override
    public void responseSetAutomaticEmergencyCallActive(int n) {
        if (this.receiver != null) {
            this.receiver.responseSetAutomaticEmergencyCallActive(n);
        }
    }

    @Override
    public void responseSetMailboxContent(int n) {
        if (this.receiver != null) {
            this.receiver.responseSetMailboxContent(n);
        }
    }

    @Override
    public void responseSetPrivacyMode(int n) {
        if (this.receiver != null) {
            this.receiver.responseSetPrivacyMode(n);
        }
    }

    @Override
    public void responseSetSIMAliases(int n) {
        if (this.receiver != null) {
            this.receiver.responseSetSIMAliases(n);
        }
    }

    @Override
    public void responseSetMICMuteState(int n) {
        if (this.receiver != null) {
            this.receiver.responseSetMICMuteState(n);
        }
    }

    @Override
    public void responseSetOptimizationMode(int n, int n2) {
        if (this.receiver != null) {
            this.receiver.responseSetOptimizationMode(n, n2);
        }
    }

    @Override
    public void responseSetNADMode(int n, int n2) {
        if (this.receiver != null) {
            this.receiver.responseSetNADMode(n, n2);
        }
    }

    @Override
    public void updateMicGainLevel(int n, int n2) {
        if (this.receiver != null) {
            this.receiver.updateMicGainLevel(n, n2);
        }
    }

    @Override
    public void updateSIMAliasInformation(SIMAliasInformation sIMAliasInformation, int n) {
        if (this.receiver != null) {
            this.receiver.updateSIMAliasInformation(sIMAliasInformation, n);
        }
    }

    @Override
    public void updateOptimizationMode(int n, int n2) {
        if (this.receiver != null) {
            this.receiver.updateOptimizationMode(n, n2);
        }
    }

    @Override
    public void responseSetPhoneReminderSetting(int n) {
        if (this.receiver != null) {
            this.receiver.responseSetPhoneReminderSetting(n);
        }
    }

    @Override
    public void responseSetPrefixActivated(int n) {
        if (this.receiver != null) {
            this.receiver.responseSetPrefixActivated(n);
        }
    }

    @Override
    public void responseSetPrefixContent(int n) {
        if (this.receiver != null) {
            this.receiver.responseSetPrefixContent(n);
        }
    }

    @Override
    public void updatePhoneReminderSetting(boolean bl, int n) {
        if (this.receiver != null) {
            this.receiver.updatePhoneReminderSetting(bl, n);
        }
    }

    @Override
    public void updatePrefixActivated(boolean bl, int n) {
        if (this.receiver != null) {
            this.receiver.updatePrefixActivated(bl, n);
        }
    }

    @Override
    public void updatePrefixContent(String string, int n) {
        if (this.receiver != null) {
            this.receiver.updatePrefixContent(string, n);
        }
    }

    @Override
    public void updateWidebandSpeech(boolean bl, int n) {
        if (this.receiver != null) {
            this.receiver.updateWidebandSpeech(bl, n);
        }
    }

    @Override
    public void responseSetPhoneRingtone(int n) {
        if (this.receiver != null) {
            this.receiver.responseSetPhoneRingtone(n);
        }
    }

    @Override
    public void updatePhoneRingtone(int n, String string, int n2) {
        if (this.receiver != null) {
            this.receiver.updatePhoneRingtone(n, string, n2);
        }
    }

    @Override
    public void responseSetFavorites(int n) {
        if (this.receiver != null) {
            this.receiver.responseSetFavorites(n);
        }
    }

    @Override
    public void updateFavorites(Favorite[] favoriteArray, int n) {
        if (this.receiver != null) {
            this.receiver.updateFavorites(favoriteArray, n);
        }
    }

    @Override
    public void updateSAPUpgradeActive(boolean bl, int n) {
        if (this.receiver != null) {
            this.receiver.updateSAPUpgradeActive(bl, n);
        }
    }

    @Override
    public void responseSetSIMName(int n) {
        if (this.receiver != null) {
            this.receiver.responseSetSIMName(n);
        }
    }

    @Override
    public void responseSetESIMActive(int n) {
        if (this.receiver != null) {
            this.receiver.responseSetESIMActive(n);
        }
    }

    @Override
    public void updateEUICCID(String string, int n) {
        if (this.receiver != null) {
            this.receiver.updateEUICCID(string, n);
        }
    }

    @Override
    public void updateESIMMSISDN(String string, int n) {
        if (this.receiver != null) {
            this.receiver.updateESIMMSISDN(string, n);
        }
    }

    @Override
    public void updateESimActive(boolean bl, int n) {
        if (this.receiver != null) {
            this.receiver.updateESimActive(bl, n);
        }
    }

    @Override
    public void updateESimB2BMode(boolean bl, int n) {
        if (this.receiver != null) {
            this.receiver.updateESimB2BMode(bl, n);
        }
    }

    @Override
    public void updateCallstacksIsReverted(boolean bl, int n) {
        if (this.receiver != null) {
            this.receiver.updateCallstacksIsReverted(bl, n);
        }
    }

    @Override
    public void updateLastAnsweredNumbers(CallStackEntry[] callStackEntryArray, int n) {
        if (this.receiver != null) {
            this.receiver.updateLastAnsweredNumbers(callStackEntryArray, n);
        }
    }

    @Override
    public void updateLastDialedNumbers(CallStackEntry[] callStackEntryArray, int n) {
        if (this.receiver != null) {
            this.receiver.updateLastDialedNumbers(callStackEntryArray, n);
        }
    }

    @Override
    public void updateMissedNumbers(CallStackEntry[] callStackEntryArray, int n) {
        if (this.receiver != null) {
            this.receiver.updateMissedNumbers(callStackEntryArray, n);
        }
    }

    @Override
    public void updateMEDataValidity(int n, int n2) {
        if (this.receiver != null) {
            this.receiver.updateMEDataValidity(n, n2);
        }
    }

    @Override
    public void updateMissedCallIndicator(MissedCallIndicator missedCallIndicator, int n) {
        if (this.receiver != null) {
            this.receiver.updateMissedCallIndicator(missedCallIndicator, n);
        }
    }

    @Override
    public void updateSpeechRecognitionAvailable(int n, int n2) {
        if (this.receiver != null) {
            this.receiver.updateSpeechRecognitionAvailable(n, n2);
        }
    }

    @Override
    public void updateSpeechRecognitionActive(int n, int n2) {
        if (this.receiver != null) {
            this.receiver.updateSpeechRecognitionActive(n, n2);
        }
    }

    @Override
    public void updateSpeechRecognitionType(int n, int n2) {
        if (this.receiver != null) {
            this.receiver.updateSpeechRecognitionType(n, n2);
        }
    }

    @Override
    public void responseStartSpeechRecognition(int n) {
        if (this.receiver != null) {
            this.receiver.responseStartSpeechRecognition(n);
        }
    }

    @Override
    public void responseStopSpeechRecognition(int n) {
        if (this.receiver != null) {
            this.receiver.responseStopSpeechRecognition(n);
        }
    }
}

