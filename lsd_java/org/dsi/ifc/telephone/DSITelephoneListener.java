/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

import org.dsi.ifc.base.DSIListener;
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

public interface DSITelephoneListener
extends DSIListener {
    default public void responseAbortNetworkRegistration(int n) {
    }

    default public void responseAbortNetworkSearch(int n) {
    }

    default public void responseAcceptCall(int n) {
    }

    default public void responseCallForward(CFResponseData[] cFResponseDataArray, int n) {
    }

    default public void responseCallWaiting(int n, int n2) {
    }

    default public void responseChangeSIMCode(int n, int n2) {
    }

    default public void responseCLIR(int n, int n2, int n3) {
    }

    default public void responseDialNumber(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
    }

    default public void responseDialOperator(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
    }

    default public void responseSendDTMF(int n) {
    }

    default public void updateDTMFTonePlaying(String string, int n) {
    }

    default public void updateEmergencyNumbers(EmergencyNumbers emergencyNumbers, int n) {
    }

    default public void responseRemoveOtherSIM(int n) {
    }

    default public void responseAbortAlternatePhoneActivity(int n) {
    }

    default public void responseTogglePrioritizedPhoneDevice(int n) {
    }

    default public void responseSIMPINRequired(int n) {
    }

    default public void updateOtherSIMAvailable(boolean bl, int n) {
    }

    default public void updateSIMPINRequired(boolean bl, int n) {
    }

    default public void responseHangupCall(int n) {
    }

    default public void responseJoinCalls(int n) {
    }

    default public void responseNetworkRegistration(int n) {
    }

    default public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n) {
    }

    default public void responseUnlockOtherSIM(int n) {
    }

    default public void responseUnlockSIM(int n) {
    }

    default public void responseCheckSIMPINCode(int n) {
    }

    default public void responseRestoreFactorySettings(int n) {
    }

    default public void responseSetHandsFreeMode(int n) {
    }

    default public void responseSetAutomaticPinEntryActive(int n) {
    }

    default public void responseSetAutomaticRedialActive(int n) {
    }

    default public void responseServiceCodeAbort(int n) {
    }

    default public void responseSplitCall(int n) {
    }

    default public void responseSwapCalls(int n) {
    }

    default public void responseTelPower(int n) {
    }

    default public void updateActivationState(ActivationStateStruct activationStateStruct, int n) {
    }

    default public void updateActivationStateAssociated(ActivationStateStruct activationStateStruct, int n) {
    }

    default public void updateAutomaticPinEntryActive(boolean bl, int n) {
    }

    default public void updateAutomaticRedialActive(boolean bl, int n) {
    }

    default public void updateBatteryChargeLevel(int n, int n2) {
    }

    default public void updateCallDurationList(CallDuration[] callDurationArray, int n) {
    }

    default public void updateCallList(CallInformation[] callInformationArray, int n) {
    }

    default public void updateCDMAThreeWayCallingSetting(boolean bl, int n) {
    }

    default public void updateCradlePlugInState(int n, int n2) {
    }

    default public void updateDisconnectReason(DisconnectReason disconnectReason, int n) {
    }

    default public void updateEmergencyCallActive(EmergencyCallSetting emergencyCallSetting, int n) {
    }

    default public void updateEnhancedPrivacyMode(boolean bl, int n) {
    }

    default public void updateHandsFreeMode(int n, int n2) {
    }

    default public void updateLockState(LockStateStruct lockStateStruct, int n) {
    }

    default public void updateMailboxContent(MailboxDialingNumber[] mailboxDialingNumberArray, int n) {
    }

    default public void updateMICMuteState(int n, int n2) {
    }

    default public void updateNADTemperature(NADTemperatureStruct nADTemperatureStruct, int n) {
    }

    default public void updatePhoneInformation(PhoneInformation phoneInformation, int n) {
    }

    default public void updateNetworkProvider(NetworkProviderName networkProviderName, int n) {
    }

    default public void updateNetworkType(int n, int n2) {
    }

    default public void updatePrivacyMode(boolean bl, int n) {
    }

    default public void updateRegisterState(RegisterStateStruct registerStateStruct, int n) {
    }

    default public void updateServiceCodeType(ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
    }

    default public void updateServiceNumbers(ServiceNumbers serviceNumbers, int n) {
    }

    default public void updateSignalQuality(int n, int n2) {
    }

    default public void updateSuppServiceResponse(SuppServiceResponseStruct suppServiceResponseStruct, int n) {
    }

    default public void updateServiceProvider(ServiceProvider serviceProvider, int n) {
    }

    default public void updateNADMode(int n, int n2) {
    }

    default public void updateAlternatePhoneActivity(boolean bl, int n) {
    }

    default public void responseSetCDMAThreeWayCallingSetting(int n) {
    }

    default public void responseSetAutomaticEmergencyCallActive(int n) {
    }

    default public void responseSetMailboxContent(int n) {
    }

    default public void responseSetPrivacyMode(int n) {
    }

    default public void responseSetSIMAliases(int n) {
    }

    default public void responseSetMICMuteState(int n) {
    }

    default public void responseSetOptimizationMode(int n, int n2) {
    }

    default public void responseSetNADMode(int n, int n2) {
    }

    default public void updateMicGainLevel(int n, int n2) {
    }

    default public void updateSIMAliasInformation(SIMAliasInformation sIMAliasInformation, int n) {
    }

    default public void updateOptimizationMode(int n, int n2) {
    }

    default public void responseSetPhoneReminderSetting(int n) {
    }

    default public void responseSetPrefixActivated(int n) {
    }

    default public void responseSetPrefixContent(int n) {
    }

    default public void updatePhoneReminderSetting(boolean bl, int n) {
    }

    default public void updatePrefixActivated(boolean bl, int n) {
    }

    default public void updatePrefixContent(String string, int n) {
    }

    default public void updateWidebandSpeech(boolean bl, int n) {
    }

    default public void responseSetPhoneRingtone(int n) {
    }

    default public void updatePhoneRingtone(int n, String string, int n2) {
    }

    default public void responseSetFavorites(int n) {
    }

    default public void updateFavorites(Favorite[] favoriteArray, int n) {
    }

    default public void updateSAPUpgradeActive(boolean bl, int n) {
    }

    default public void responseSetSIMName(int n) {
    }

    default public void responseSetESIMActive(int n) {
    }

    default public void updateEUICCID(String string, int n) {
    }

    default public void updateESIMMSISDN(String string, int n) {
    }

    default public void updateESimActive(boolean bl, int n) {
    }

    default public void updateESimB2BMode(boolean bl, int n) {
    }
}

