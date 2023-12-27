/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.call;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.call.CallHandling$MobileEquipmentListener;
import de.vw.mib.asl.internal.phone.call.CallInformations$CallComparator;
import de.vw.mib.asl.internal.phone.call.CallState;
import de.vw.mib.asl.internal.phone.call.transformer.PhoneCallInformationCollector;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.phonetiles.call.transformer.PhoneTileSCallCallInformationsCollector;
import java.util.ArrayList;
import java.util.Arrays;
import org.dsi.ifc.telephoneng.CallDuration;
import org.dsi.ifc.telephoneng.CallInformation;
import org.dsi.ifc.telephoneng.DisconnectReason;

public class CallInformations {
    private static final int PHONE_MAX_CONFERENCE_PARTICIPANTS;
    private PhoneCallInformationCollector[] callInformationCollectors = new PhoneCallInformationCollector[0];
    private PhoneCallInformationCollector currentMainCallCollector = null;
    private int lastConferenceCallListSize = 0;
    private final IntObjectMap disconnectReasons = new IntObjectOptHashMap(7);
    private boolean lastAlternatePhoneActivity;
    private static final int CACHED_AUDIO_REQUEST_C0_NONE;
    private static final int CACHED_AUDIO_REQUEST_C1_RINGING;
    private static final int CACHED_AUDIO_REQUEST_C2_VOICE;
    private int cachedAudioRequest = 0;
    private int audioMngmtStatus = 0;
    private final CallState callState = new CallState();
    private CallHandling$MobileEquipmentListener mobileEquipment;

    public boolean isMultipleCalls() {
        int n = 0;
        for (int i2 = 0; i2 < this.callInformationCollectors.length; ++i2) {
            if (this.callInformationCollectors[i2].callInformation.telCallID == 0) continue;
            ++n;
        }
        return n > 1;
    }

    public boolean isEmpty() {
        return this.callInformationCollectors.length == 0;
    }

    private void updateCallInformationList(PhoneCallInformationCollector[] phoneCallInformationCollectorArray) {
        int n;
        Arrays.sort(phoneCallInformationCollectorArray, CallInformations$CallComparator.INSTANCE);
        int n2 = -1;
        int n3 = -1;
        int n4 = -1;
        block5: for (n = 0; n < phoneCallInformationCollectorArray.length; ++n) {
            switch (phoneCallInformationCollectorArray[n].callInformation.getTelCallState()) {
                case 4: {
                    n2 = n;
                    continue block5;
                }
                case 3: {
                    n3 = n;
                    continue block5;
                }
                case 6: {
                    n4 = n;
                    continue block5;
                }
            }
        }
        if (n2 != -1) {
            if (n4 != -1) {
                phoneCallInformationCollectorArray[n2].joinPossible = true;
            }
            if (n3 != -1) {
                phoneCallInformationCollectorArray[n3].replace = true;
            }
        }
        for (n = 0; n < phoneCallInformationCollectorArray.length; ++n) {
            phoneCallInformationCollectorArray[n].callDuration = ((PhoneCallInformationCollector)ListManager.getGenericASLList((int)1158).getRowItem((int)n)).callDuration;
            ListManager.getGenericASLList(1158).updateListItem(n, phoneCallInformationCollectorArray[n]);
        }
        PhoneCallInformationCollector[] phoneCallInformationCollectorArray2 = (PhoneCallInformationCollector[])ListManager.getGenericASLList(1158).getDSIObjects();
        if (phoneCallInformationCollectorArray2.length > phoneCallInformationCollectorArray.length) {
            for (int i2 = phoneCallInformationCollectorArray.length; i2 < phoneCallInformationCollectorArray2.length; ++i2) {
                CallInformation callInformation = new CallInformation();
                callInformation.telCallState = 0;
                callInformation.telCallID = 0;
                phoneCallInformationCollectorArray2[i2].callInformation = callInformation;
                phoneCallInformationCollectorArray2[i2].conferenceCallState = -1;
                ListManager.getGenericASLList(1158).updateListItem(i2, phoneCallInformationCollectorArray2[i2]);
            }
        }
    }

    public void distributeCallList() {
        ArrayList arrayList = new ArrayList(5);
        ArrayList arrayList2 = new ArrayList(7);
        PhoneCallInformationCollector phoneCallInformationCollector = null;
        for (int i2 = 0; i2 < this.callInformationCollectors.length; ++i2) {
            PhoneCallInformationCollector phoneCallInformationCollector2 = this.callInformationCollectors[i2];
            if (phoneCallInformationCollector2.callInformation.telCallType == 4) {
                phoneCallInformationCollector = phoneCallInformationCollector2;
                arrayList.add(0, phoneCallInformationCollector);
                continue;
            }
            if (phoneCallInformationCollector2.callInformation.telMpty == 1) {
                arrayList2.add(phoneCallInformationCollector2);
                continue;
            }
            arrayList.add(phoneCallInformationCollector2);
        }
        if (phoneCallInformationCollector != null) {
            ASLPhoneData.getInstance().numberOfCallBoxes = arrayList.size();
            ASLPhoneData.getInstance().conferenceCallMaxedOut = arrayList2.size() >= 5;
            this.updateCallInformationList((PhoneCallInformationCollector[])arrayList.toArray(new PhoneCallInformationCollector[arrayList.size()]));
            ListManager.getGenericASLList(1160).updateList(arrayList2.toArray(new PhoneCallInformationCollector[arrayList2.size()]));
        } else {
            ASLPhoneData.getInstance().conferenceCallMaxedOut = false;
            ASLPhoneData.getInstance().numberOfCallBoxes = this.callInformationCollectors.length;
            this.updateCallInformationList(this.callInformationCollectors);
            ListManager.getGenericASLList(1160).updateList(new PhoneCallInformationCollector[0]);
        }
        if (arrayList2.size() == 0 && this.lastConferenceCallListSize != 0) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(564);
        }
        this.lastConferenceCallListSize = arrayList2.size();
    }

    public void updateDisconnectReason(DisconnectReason disconnectReason) {
        for (int i2 = this.callInformationCollectors.length - 1; i2 >= 0; --i2) {
            PhoneCallInformationCollector phoneCallInformationCollector = this.callInformationCollectors[i2];
            if (phoneCallInformationCollector.callInformation.telCallID != disconnectReason.callId) continue;
            phoneCallInformationCollector.disconnectReason = PhoneUtil.convertDisconnectReasonDSI2ASL(disconnectReason.disconnectReason);
        }
    }

    public boolean updateAlternatePhoneActivity(boolean bl) {
        if (bl == this.lastAlternatePhoneActivity) {
            return false;
        }
        ServiceManager.logger.trace(4, new StringBuffer().append("CallInformations.updateAlternatePhoneActivity() ").append(this.lastAlternatePhoneActivity).append(" -> ").append(bl).toString());
        this.lastAlternatePhoneActivity = bl;
        ServiceManager.aslPropertyManager.valueChangedBoolean(-679275264, bl);
        int n = 1;
        if (!Util.isNullOrEmpty(this.callInformationCollectors)) {
            n = this.callInformationCollectors[0].mobileEquipment.getRole() == 1 ? 0 : 1;
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(-645720832, n);
        return !bl;
    }

    public void updateCallCollector(CallInformation[] callInformationArray, CallHandling$MobileEquipmentListener callHandling$MobileEquipmentListener) {
        int n;
        PhoneCallInformationCollector[] phoneCallInformationCollectorArray = new PhoneCallInformationCollector[callInformationArray.length];
        boolean[] blArray = new boolean[7];
        boolean bl = true;
        Arrays.fill(blArray, true);
        for (n = 0; n < callInformationArray.length; ++n) {
            phoneCallInformationCollectorArray[n] = new PhoneCallInformationCollector();
            phoneCallInformationCollectorArray[n].callInformation = callInformationArray[n];
            phoneCallInformationCollectorArray[n].mobileEquipment = callHandling$MobileEquipmentListener;
            short s = callInformationArray[n].telCallID;
            DisconnectReason disconnectReason = (DisconnectReason)this.disconnectReasons.get(s);
            if (disconnectReason != null) {
                phoneCallInformationCollectorArray[n].disconnectReason = PhoneUtil.convertDisconnectReasonDSI2ASL(disconnectReason.disconnectReason);
            }
            if (s == 254) {
                bl = false;
                continue;
            }
            if (s <= 0) continue;
            blArray[s - 1] = false;
        }
        if (bl) {
            this.disconnectReasons.remove(254);
        }
        for (n = 0; n < blArray.length; ++n) {
            if (!blArray[n]) continue;
            this.disconnectReasons.remove(n + 1);
        }
        this.callInformationCollectors = phoneCallInformationCollectorArray;
    }

    public void updateCallCollector(CallDuration[] callDurationArray) {
        for (int i2 = 0; i2 < this.callInformationCollectors.length; ++i2) {
            PhoneCallInformationCollector phoneCallInformationCollector = this.callInformationCollectors[i2];
            boolean bl = false;
            for (int i3 = 0; i3 < callDurationArray.length; ++i3) {
                CallDuration callDuration = callDurationArray[i3];
                if (phoneCallInformationCollector.callInformation.telCallID != callDuration.telCallID) continue;
                phoneCallInformationCollector.callDuration = callDuration;
                bl = true;
            }
            if (bl) continue;
            ServiceManager.logger.error(4).append("CallDuration-Element not present in CallInformationCollector").log();
        }
    }

    public void clear() {
        if (!this.isEmpty()) {
            PhoneCallInformationCollector[] phoneCallInformationCollectorArray = new PhoneCallInformationCollector[]{};
            this.callInformationCollectors = phoneCallInformationCollectorArray;
        }
    }

    private void requestAudioConnectionIfPossible(AbstractASLTarget abstractASLTarget, boolean bl, CallHandling$MobileEquipmentListener callHandling$MobileEquipmentListener) {
        abstractASLTarget.trace("RequestPhoneConnectionIfPossible called.");
        if (this.audioMngmtStatus == 1 || this.audioMngmtStatus == 2) {
            PhoneUtil.requestPhoneAudioConnection(abstractASLTarget, bl, callHandling$MobileEquipmentListener);
        } else {
            this.cachedAudioRequest = bl ? 1 : 2;
            abstractASLTarget.trace(new StringBuffer().append("Set cached audio request to: ").append(this.cachedAudioRequest).toString());
        }
    }

    public void audioManagementStatus(AbstractASLTarget abstractASLTarget, int n) {
        this.audioMngmtStatus = n;
        abstractASLTarget.trace(new StringBuffer().append("AudioManagementStatus received:").append(this.audioMngmtStatus).append(", cached Connection is: ").append(this.cachedAudioRequest).toString());
        if (!(this.audioMngmtStatus != 1 && this.audioMngmtStatus != 2 || PhoneUtil.restoreAudioConnection(abstractASLTarget))) {
            abstractASLTarget.trace("No connection restored, set the cached one.");
            if (this.cachedAudioRequest != 0) {
                PhoneUtil.requestPhoneAudioConnection(abstractASLTarget, this.cachedAudioRequest == 1, this.mobileEquipment);
                this.cachedAudioRequest = 0;
                abstractASLTarget.trace("Reset cached audio request because request has been fulfilled.");
            }
        }
    }

    public boolean isAnyActive() {
        return !this.callState.allIdle;
    }

    public void handleCallStates(AbstractASLTarget abstractASLTarget) {
        CallInformation callInformation;
        int n;
        boolean bl = this.callState.allIdle;
        boolean bl2 = this.callState.ringing;
        this.callState.reset();
        PhoneCallInformationCollector[] phoneCallInformationCollectorArray = this.callInformationCollectors;
        boolean bl3 = phoneCallInformationCollectorArray.length == 1;
        this.callState.allIdle = phoneCallInformationCollectorArray.length == 0;
        PhoneCallInformationCollector[] phoneCallInformationCollectorArray2 = (PhoneCallInformationCollector[])ListManager.getGenericASLList(1158).getDSIObjects();
        ASLPhoneData.getInstance().usedCallLines = 0;
        for (n = 0; n < phoneCallInformationCollectorArray2.length; ++n) {
            if (phoneCallInformationCollectorArray2[n].callInformation.getTelCallState() == 0) continue;
            ++ASLPhoneData.getInstance().usedCallLines;
        }
        PhoneUtil.setFreeLine();
        if (this.callState.allIdle) {
            PhoneUtil.releaseAudioConnection(abstractASLTarget, false);
            PhoneUtil.releaseAudioConnection(abstractASLTarget, true);
            this.cachedAudioRequest = 0;
            this.sendDemuteRingToneIfNecessary(abstractASLTarget);
        }
        n = 0;
        int n2 = -1;
        boolean bl4 = false;
        int n3 = -1;
        boolean bl5 = false;
        int n4 = -1;
        block10: for (int i2 = 0; i2 < phoneCallInformationCollectorArray.length; ++i2) {
            PhoneCallInformationCollector phoneCallInformationCollector = phoneCallInformationCollectorArray[i2];
            callInformation = phoneCallInformationCollector.callInformation;
            if (callInformation.telCallType == 4) {
                phoneCallInformationCollector.conferenceCallState = callInformation.telCallState;
                phoneCallInformationCollector.conferenceActiveOtherHold = bl5;
                n4 = i2;
            }
            phoneCallInformationCollector.firstButtonAvailable = this.firstButtonAvailable(callInformation);
            switch (callInformation.telCallState) {
                case 5: {
                    if (callInformation.telCallType == 3) {
                        AbstractASLTarget.writeBooleanToDatapool(1156, false);
                    }
                    if (!bl2) continue block10;
                    PhoneUtil.releaseAudioConnection(abstractASLTarget, true);
                    continue block10;
                }
                case 3: {
                    if (bl3) {
                        this.requestAudioConnectionIfPossible(abstractASLTarget, true, phoneCallInformationCollector.mobileEquipment);
                        n = 1;
                    }
                    if (callInformation.telCallType == 3) {
                        AbstractASLTarget.writeBooleanToDatapool(1156, true);
                    }
                    if (!ASLPhoneData.getInstance().androidAutoShown) {
                        abstractASLTarget.sendHMIEvent(169);
                    }
                    n3 = i2;
                    continue block10;
                }
                case 1: {
                    abstractASLTarget.sendHMIEvent(162);
                    abstractASLTarget.sendHMIEvent(170);
                    abstractASLTarget.stopTimer(-1601830656);
                }
                case 2: {
                    if (bl3) {
                        this.requestAudioConnectionIfPossible(abstractASLTarget, false, phoneCallInformationCollector.mobileEquipment);
                        n = 1;
                    }
                    if (callInformation.telCallType != 3) continue block10;
                    AbstractASLTarget.writeBooleanToDatapool(1156, true);
                    continue block10;
                }
                case 8: {
                    if (!bl3) continue block10;
                    this.sendDemuteRingToneIfNecessary(abstractASLTarget);
                    this.requestAudioConnectionIfPossible(abstractASLTarget, false, phoneCallInformationCollector.mobileEquipment);
                    continue block10;
                }
                case 4: {
                    if (bl3) {
                        this.sendDemuteRingToneIfNecessary(abstractASLTarget);
                        this.requestAudioConnectionIfPossible(abstractASLTarget, false, phoneCallInformationCollector.mobileEquipment);
                    }
                    if (callInformation.telCallType == 3) {
                        AbstractASLTarget.writeBooleanToDatapool(1156, true);
                    }
                    if (callInformation.getTelMpty() != 0 && callInformation.getTelCallType() != 4) continue block10;
                    n2 = i2;
                    continue block10;
                }
                case 6: {
                    bl4 = true;
                    if (callInformation.telMpty != 0) continue block10;
                    if (n4 != -1) {
                        phoneCallInformationCollectorArray[n4].conferenceActiveOtherHold = true;
                        continue block10;
                    }
                    bl5 = true;
                    continue block10;
                }
            }
        }
        if (!this.callState.allIdle && this.mobileEquipment.getRole() == 1) {
            AbstractASLTarget.writeBooleanToDatapool(-8186624, true);
        } else {
            AbstractASLTarget.writeBooleanToDatapool(-8186624, false);
        }
        if (n2 != -1 && bl2 && n3 == -1) {
            abstractASLTarget.sendHMIEvent(160);
            if (this.mobileEquipment.isOutband()) {
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-2031208960);
                abstractASLTarget.sendSafe(eventGeneric);
            }
        }
        if (n2 != -1) {
            if (bl4) {
                phoneCallInformationCollectorArray[n2].joinPossible = true;
            }
            if (n3 != -1) {
                phoneCallInformationCollectorArray[n3].replace = true;
            }
        }
        this.notifyCallActive(n2 != -1);
        AbstractASLTarget.writeBooleanToDatapool(1154, n2 == -1 && bl4);
        EventGeneric eventGeneric = abstractASLTarget.getEventFactory().newEvent(-1578224128);
        eventGeneric.setBoolean(0, !this.callState.allIdle);
        abstractASLTarget.triggerObserver(-1578224128, eventGeneric);
        if (n == 0 && !this.callState.allIdle && bl) {
            this.requestAudioConnectionIfPossible(abstractASLTarget, false, this.mobileEquipment);
        }
        this.callState.ringing = n3 != -1;
        this.callState.lastCallStates.clear();
        for (int i3 = 0; i3 < phoneCallInformationCollectorArray.length; ++i3) {
            callInformation = phoneCallInformationCollectorArray[i3].callInformation;
            this.callState.lastCallStates.put(callInformation.telCallID, callInformation.telCallState);
        }
        this.setCurrentMainCollector(abstractASLTarget, bl3, n2);
        this.updatePhoneTileSCallInformation();
    }

    private void setCurrentMainCollector(AbstractASLTarget abstractASLTarget, boolean bl, int n) {
        this.currentMainCallCollector = null;
        if (!Util.isNullOrEmpty(this.callInformationCollectors)) {
            if (n != -1) {
                this.currentMainCallCollector = this.callInformationCollectors[n];
            }
            if (this.currentMainCallCollector == null) {
                for (int i2 = 0; i2 < this.callInformationCollectors.length; ++i2) {
                    if (this.callInformationCollectors[i2].callInformation.telCallType != 4) continue;
                    this.currentMainCallCollector = this.callInformationCollectors[i2];
                }
            }
            if (this.currentMainCallCollector == null) {
                this.currentMainCallCollector = this.callInformationCollectors[0];
            }
        } else {
            abstractASLTarget.warn().append("CallInformationCollector null or empty, no assignment done!").log();
        }
    }

    private void sendDemuteRingToneIfNecessary(AbstractASLTarget abstractASLTarget) {
        abstractASLTarget.sendSafe(ServiceManager.mGenericEventFactory.newEvent(5254, 1922634752, -1947322880));
    }

    private boolean firstButtonAvailable(CallInformation callInformation) {
        switch (callInformation.telCallState) {
            case 0: 
            case 1: 
            case 2: 
            case 5: {
                return false;
            }
            case 4: {
                return Util.isBitSet(8, ASLPhoneData.getInstance().getCurrentCallsTelFeat()) || ASLPhoneData.getInstance().callInformationCollectors.isMultipleCalls();
            }
        }
        for (int i2 = 0; i2 < ASLPhoneData.getInstance().incomingOrOutgoingCallIDs.size(); ++i2) {
            if (((Short)ASLPhoneData.getInstance().incomingOrOutgoingCallIDs.get(i2)).intValue() == callInformation.getTelCallID()) continue;
            return false;
        }
        return true;
    }

    void updatePhoneTileSCallInformation() {
        if (this.currentMainCallCollector != null) {
            Object[] objectArray = (PhoneTileSCallCallInformationsCollector[])ListManager.getGenericASLList(-127769088).getDSIObjects();
            CallInformation callInformation = this.currentMainCallCollector.callInformation;
            CallDuration callDuration = this.currentMainCallCollector.callDuration;
            objectArray[0].phonetiles_call_carrier_state = this.mobileEquipment.getRole() == 0 ? 0 : 1;
            objectArray[0].phonetiles_call_combined_number_type = PhoneUtil.convertPhoneTypeDSI2ASLCombined(callInformation.getTelRemNumberType());
            objectArray[0].phonetiles_call_duration = callDuration != null ? callDuration.getTelElapsedTime() : 0;
            objectArray[0].phonetiles_call_first_button_available = this.currentMainCallCollector.firstButtonAvailable;
            objectArray[0].phonetiles_call_first_button_state = PhoneUtil.getCallBoxFirstButtonState(this.currentMainCallCollector);
            objectArray[0].phonetiles_call_hang_up_button_available = PhoneUtil.isCallBoxHangupButtonAvailable(this.currentMainCallCollector);
            objectArray[0].phonetiles_call_name = callInformation.telRemName;
            objectArray[0].phonetiles_call_number = callInformation.telRemNumber;
            objectArray[0].phonetiles_call_picture = callInformation.telRemPictureId;
            objectArray[0].phonetiles_call_picture_available = callInformation.telRemPictureId != null;
            objectArray[0].phonetiles_call_second_button_available = PhoneUtil.isCallBoxSecondButtonAvailable(this.currentMainCallCollector);
            objectArray[0].phonetiles_call_second_button_state = PhoneUtil.getCallBoxSecondButtonState(this.currentMainCallCollector);
            objectArray[0].phonetiles_call_state = PhoneUtil.convertCallStateDSI2ASL(this.currentMainCallCollector);
            objectArray[0].phonetiles_call_type = PhoneUtil.convertCallTypeDSI2ASL(callInformation);
            ListManager.getGenericASLList(-127769088).updateList(objectArray);
        }
    }

    public void notifyCallActive(boolean bl) {
        AbstractASLTarget.writeBooleanToDatapool(1155, bl);
    }

    public boolean isCurrentCallPrimary() {
        return this.mobileEquipment == null || this.mobileEquipment.getRole() == 0;
    }

    public PhoneCallInformationCollector getActive() {
        for (int i2 = 0; i2 < this.callInformationCollectors.length; ++i2) {
            PhoneCallInformationCollector phoneCallInformationCollector = this.callInformationCollectors[i2];
            if (phoneCallInformationCollector.callInformation.telCallState != 4) continue;
            return phoneCallInformationCollector;
        }
        return null;
    }

    public void setFillingInstance(CallHandling$MobileEquipmentListener callHandling$MobileEquipmentListener) {
        this.mobileEquipment = callHandling$MobileEquipmentListener;
    }

    public boolean isFreeFor(CallHandling$MobileEquipmentListener callHandling$MobileEquipmentListener) {
        return this.mobileEquipment == null || this.mobileEquipment == callHandling$MobileEquipmentListener;
    }

    public CallHandling$MobileEquipmentListener getFillingInstance() {
        return this.mobileEquipment;
    }

    public PhoneCallInformationCollector getCurrentMainCallCollector() {
        return this.currentMainCallCollector;
    }
}

