/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.phone;

import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import java.util.Iterator;

public interface PhoneService {
    default public void addPhoneServiceListener(PhoneServiceListener phoneServiceListener, int[] nArray) {
    }

    default public void removePhoneServiceListener(PhoneServiceListener phoneServiceListener, int[] nArray) {
    }

    default public void addHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
    }

    default public void removeHMIEventListener(HMIEventListener hMIEventListener, int[] nArray) {
    }

    default public Iterator getCallInformations() {
    }

    default public Iterator getConferenceCallInformations() {
    }

    default public String getBluetoothDeviceName() {
    }

    default public String getBluetoothExternalDeviceName() {
    }

    default public boolean isBluetoothConnectedUserPopUpVisible() {
    }

    default public int getTelephoneFeatures() {
    }

    default public int getCurrentPhoneProfile() {
    }

    default public int getCurrentPhoneMediaProfile() {
    }

    default public int getCurrentPhoneOtherProfile() {
    }

    default public Iterator getMixedCalls() {
    }

    default public int getDataVolumeState() {
    }

    default public int getDataVolumeUplink() {
    }

    default public int getDataVolumeDownlink() {
    }

    default public Iterator getDialedCalls() {
    }

    default public boolean isPhoneLineFree() {
    }

    default public String getLastDialedNumber() {
    }

    default public int getNetworkState() {
    }

    default public String getNetworkName() {
    }

    default public int getNetworkType() {
    }

    default public int getDialingFailedReason() {
    }

    default public int getSelectedNumberType() {
    }

    default public String getEmergencyCallNumber() {
    }

    default public String getServiceCallNumber() {
    }

    default public String getInfoCallNumber() {
    }

    default public String getMailboxCallNumber() {
    }

    default public Iterator getPhonePresets() {
    }

    default public int getNetworkAccessDeviceState() {
    }

    default public int getPhoneActivationState() {
    }

    default public int getBluetoothState() {
    }

    default public int getBluetoothVisibility() {
    }

    default public boolean isPhonePrivacyModeActive() {
    }

    default public int getSimCardReaderType() {
    }

    default public int getBluetoothSoftwareDownloadState() {
    }

    default public boolean isRemoteSimAccessProfileSupported() {
    }

    default public int getSimCardState() {
    }

    default public boolean isExternalPhoneAvailable() {
    }

    default public boolean isInternalPhoneAvailable() {
    }

    default public boolean isNetworkingInternalSimDataModeOnly() {
    }

    default public int getCurrentPhoneCallCount() {
    }

    default public boolean isHandsfreeAudioEnabled() {
    }

    default public int getPhoneLockState() {
    }

    default public boolean isMicrophoneMuted() {
    }

    default public boolean isRingtoneMuted() {
    }

    default public int getCurrentMissedCallsCount() {
    }

    default public Iterator getMissedCalls() {
    }

    default public int getPhoneBatteryLevelWarning() {
    }

    default public int getPhoneBatteryLevel() {
    }

    default public boolean isPhoneCallActive() {
    }

    default public boolean isSignalStrengthAvailable() {
    }

    default public int getSignalStrength() {
    }

    default public int getContactsDownloadStatus() {
    }

    default public Iterator getReceivedCalls() {
    }

    default public boolean isMessagingAvailable() {
    }

    default public int getNumberOfNewMessages() {
    }

    default public boolean isMessageStorageFull() {
    }

    default public boolean isCallForwardingAvailable() {
    }

    default public Iterator getCallForwardings() {
    }

    default public int getPhoneDataConnectionType() {
    }

    default public void setMicrophoneMute(boolean bl) {
    }

    default public void setRingtoneMute(boolean bl) {
    }

    default public void clearNewMessageCounter() {
    }

    default public void startEmergencyCall() {
    }

    default public void startEmergencyCallInternal() {
    }

    default public void abortEmergencyCall() {
    }

    default public void acceptCall(int n) {
    }

    default public void acceptResponseAndHoldCall(int n) {
    }

    default public void joinCallToConference(int n) {
    }

    default public void splitCallFromConference(int n) {
    }

    default public void hangUpCall(int n) {
    }

    default public void replaceActiveWithIncomingCall() {
    }

    default public void removeCallFromConference(int n) {
    }

    default public void startCall(long l, String string) {
    }

    default public void setNumberForDailing(String string) {
    }

    default public void setCallStateToHold(int n) {
    }

    default public void setCallStateToResponseAndHold(int n) {
    }

    default public void resumeCall(int n) {
    }

    default public void clearMissedCallsCounter() {
    }

    default public void clearCallStack(int n) {
    }

    default public void setHandsfreeAudioModeActive(boolean bl) {
    }
}

