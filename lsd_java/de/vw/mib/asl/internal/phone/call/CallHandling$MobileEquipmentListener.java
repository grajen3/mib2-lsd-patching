/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.call;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.api.impl.PhoneServiceImpl;
import de.vw.mib.asl.internal.phone.call.CallHandling;
import de.vw.mib.asl.internal.phone.call.dial.transformer.PhoneCallDialShortDialEmergencyNumbersCollector;
import de.vw.mib.asl.internal.phone.call.transformer.PhoneCallInformationCollector;
import de.vw.mib.asl.internal.phone.util.DefaultDSIMobileEquipmentListener;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.CallDuration;
import org.dsi.ifc.telephoneng.CallInformation;
import org.dsi.ifc.telephoneng.DSIMobileEquipment;
import org.dsi.ifc.telephoneng.DisconnectReason;
import org.dsi.ifc.telephoneng.EmergencyNumbers;
import org.dsi.ifc.telephoneng.ServiceCodeTypeStruct;
import org.dsi.ifc.telephoneng.ServiceNumbers;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public class CallHandling$MobileEquipmentListener
extends DefaultDSIMobileEquipmentListener {
    private final int role;
    private boolean isJoinOngoing = false;
    private boolean isAcceptOngoing = false;
    private boolean isSwapOngoing = false;
    private boolean isSplitOngoing = false;
    private final IntOptHashSet requestedHangupIDs = new IntOptHashSet();
    public CallInformation[] callList = new CallInformation[0];
    public CallDuration[] callDurationList = new CallDuration[0];
    private boolean widebandSpeechActive;
    private boolean handsFreeMode;
    private int telAudioMode;
    private int telMode;
    private short telFeat;
    private final /* synthetic */ CallHandling this$0;

    CallHandling$MobileEquipmentListener(CallHandling callHandling, int n) {
        this.this$0 = callHandling;
        this.role = n;
    }

    private DSIMobileEquipment getDSI() {
        if (this.role == 0) {
            return this.this$0.getPrimary();
        }
        return this.this$0.getAssociated();
    }

    public int getRole() {
        return this.role;
    }

    public short getTelFeat() {
        return this.telFeat;
    }

    public int getTelAudioMode() {
        return this.telAudioMode;
    }

    public int getTelMode() {
        return this.telMode;
    }

    @Override
    public void updateServiceNumbers(ServiceNumbers serviceNumbers, int n) {
        if (this.role == 0) {
            ASLPhoneData.getInstance().serviceNumbers = serviceNumbers;
            CallHandling.access$300(this.this$0);
            PhoneServiceImpl.getInstance().getSpecialNumbersUpdater().updateServiceNumbers(serviceNumbers);
        }
    }

    public void joinCalls() {
        if (!this.isJoinOngoing) {
            this.isJoinOngoing = true;
            this.getDSI().joinCalls();
        }
    }

    public void swapCalls() {
        if (!this.isSwapOngoing) {
            this.isSwapOngoing = true;
            this.getDSI().swapCalls();
        }
    }

    public void accept() {
        if (!this.isAcceptOngoing) {
            this.isAcceptOngoing = true;
            this.getDSI().acceptCall(CallHandling.access$400(this.this$0) == 1 ? 0 : 2);
        }
    }

    public void splitCall(PhoneCallInformationCollector phoneCallInformationCollector) {
        if (!this.isSplitOngoing) {
            this.isSplitOngoing = true;
            this.getDSI().splitCall(phoneCallInformationCollector.callInformation.telCallID);
        }
    }

    public void replace() {
        if (ASLPhoneData.getInstance().carPlayCallActive) {
            if (!this.isAcceptOngoing) {
                this.isAcceptOngoing = true;
                this.getDSI().acceptCall(CallHandling.access$400(this.this$0) == 1 ? 0 : 2);
            }
            this.this$0.triggerObserver(-2104665344, null);
        } else if (!this.isAcceptOngoing) {
            this.isAcceptOngoing = true;
            this.getDSI().acceptCall(1);
        }
    }

    @Override
    public void updateMICMuteState(int n, int n2) {
        ASLPhoneData.getInstance().micMuteState = n;
        AbstractASLTarget.writeBooleanToDatapool(1095, ASLPhoneData.getInstance().micMuteState == 0);
        AbstractASLTarget.writeBooleanToDatapool(-77437440, ASLPhoneData.getInstance().micMuteState == 0);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(705248512);
        eventGeneric.setBoolean(0, ASLPhoneData.getInstance().micMuteState == 0);
        this.this$0.sendSafe(eventGeneric);
        CallHandling.access$500(this.this$0).updatePhoneTileSCallInformation();
    }

    @Override
    public void updateEmergencyNumbers(EmergencyNumbers emergencyNumbers, int n) {
        Object[] objectArray;
        if (Util.isNullOrEmpty(emergencyNumbers.additionalEmergencyNumber)) {
            objectArray = new PhoneCallDialShortDialEmergencyNumbersCollector[]{new PhoneCallDialShortDialEmergencyNumbersCollector(emergencyNumbers.mainEmergencyNumber)};
        } else {
            emergencyNumbers.additionalEmergencyNumber = PhoneUtil.filterDuplicatedEmergencyNumbers(emergencyNumbers);
            objectArray = new PhoneCallDialShortDialEmergencyNumbersCollector[emergencyNumbers.additionalEmergencyNumber.length + 1];
            objectArray[0] = new PhoneCallDialShortDialEmergencyNumbersCollector(emergencyNumbers.mainEmergencyNumber);
            for (int i2 = 0; i2 < emergencyNumbers.additionalEmergencyNumber.length; ++i2) {
                objectArray[i2 + 1] = new PhoneCallDialShortDialEmergencyNumbersCollector(emergencyNumbers.additionalEmergencyNumber[i2]);
            }
        }
        ListManager.getGenericASLList(277091584).updateList(objectArray);
        ASLPhoneData.getInstance().emergencyNumbers = emergencyNumbers;
        AbstractASLTarget.writeStringToDatapool(1149, ASLPhoneData.getInstance().emergencyNumbers.mainEmergencyNumber);
        CallHandling.access$300(this.this$0);
        PhoneServiceImpl.getInstance().getSpecialNumbersUpdater().updateEmergencyNumbers(emergencyNumbers, CallHandling.access$600(this.this$0));
    }

    @Override
    public void responseSplitCall(int n) {
        this.isSplitOngoing = false;
        if (n != 0) {
            this.this$0.sendHMIEvent(465);
            if (n == 3) {
                this.this$0.sendHMIEvent(168);
            }
        }
    }

    @Override
    public void responseHangupCall(int n) {
        if (n != 0) {
            this.this$0.sendHMIEvent(464);
            this.requestedHangupIDs.clear();
        }
    }

    @Override
    public void responseSwapCalls(int n) {
        this.isSwapOngoing = false;
        if (n != 0) {
            this.this$0.sendHMIEvent(483);
        }
    }

    @Override
    public void responseAcceptCall(int n) {
        this.isAcceptOngoing = false;
        if (n != 0) {
            this.this$0.sendHMIEvent(467);
        }
    }

    @Override
    public void responseJoinCalls(int n) {
        this.isJoinOngoing = false;
        if (n != 0) {
            this.this$0.sendHMIEvent(468);
        }
    }

    @Override
    public void updateWidebandSpeech(boolean bl, int n) {
        this.widebandSpeechActive = bl;
        if ((CallHandling.access$700(this.this$0) == null || CallHandling.access$700(this.this$0).getRole() == this.getRole()) && CallHandling.access$400(this.this$0) != 0) {
            CallHandling.access$800(this.this$0, this);
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        switch (n2) {
            case 1005: 
            case 1006: {
                AbstractASLTarget.writeIntegerToDatapool(1090, 2);
                break;
            }
            case 1001: {
                this.requestedHangupIDs.clear();
                break;
            }
            case 1004: {
                this.isJoinOngoing = false;
                break;
            }
            case 1000: {
                this.isAcceptOngoing = false;
                break;
            }
            case 1003: {
                this.isSplitOngoing = false;
                break;
            }
            case 1002: {
                this.isSwapOngoing = false;
                break;
            }
        }
    }

    @Override
    public void updateActivationState(ActivationStateStruct activationStateStruct, int n) {
        this.telMode = activationStateStruct.telMode;
        this.telFeat = activationStateStruct.telFeat;
        if (this.role == 0) {
            CallHandling.access$902(this.this$0, activationStateStruct.telActivationState);
            CallHandling.access$1002(this.this$0, this.telMode);
        }
    }

    @Override
    public void updateCallList(CallInformation[] callInformationArray, int n) {
        try {
            CallInformation[] callInformationArray2 = this.callList;
            if (n == 1) {
                this.callList = callInformationArray;
            }
            boolean bl = CallHandling.access$1100((CallHandling)this.this$0)[0].callList.length != 0 && CallHandling.access$1100((CallHandling)this.this$0)[1].callList.length != 0 && !CallHandling.access$1200(this.this$0, CallHandling.access$1100((CallHandling)this.this$0)[0].callList) && !CallHandling.access$1200(this.this$0, CallHandling.access$1100((CallHandling)this.this$0)[1].callList);
            boolean bl2 = CallHandling.access$500(this.this$0).updateAlternatePhoneActivity(bl);
            if (bl && !CallHandling.access$500(this.this$0).isFreeFor(this)) {
                if (this.this$0.isTraceEnabled()) {
                    this.this$0.trace().append("callList ignored due to 2 non-empty callLists from different instances. Role: ").append(this.getRole()).log();
                }
                return;
            }
            if (!bl && Util.isNullOrEmpty(callInformationArray) && !CallHandling.access$500(this.this$0).isFreeFor(this)) {
                if (this.this$0.isTraceEnabled()) {
                    this.this$0.trace().append("Empty callList ignored due to non-empty callList from different instance. Role: ").append(this.getRole()).log();
                }
                return;
            }
            if (bl2) {
                CallHandling$MobileEquipmentListener callHandling$MobileEquipmentListener = CallHandling.access$1300(this.this$0, this);
                if (this.this$0.isTraceEnabled()) {
                    this.this$0.trace().append("CallList: returning to single activity. old:").append(CallHandling.access$500(this.this$0).getFillingInstance().getRole()).append(", new: ").append(callHandling$MobileEquipmentListener.getRole()).log();
                }
                if (CallHandling.access$1400(this.this$0)) {
                    this.this$0.stopTimer(-1551499008);
                    CallHandling.access$1402(this.this$0, false);
                }
                CallHandling.access$500(this.this$0).setFillingInstance(callHandling$MobileEquipmentListener);
                callHandling$MobileEquipmentListener.updateCallList(callHandling$MobileEquipmentListener.callList, n);
                callHandling$MobileEquipmentListener.updateCallDurationList(callHandling$MobileEquipmentListener.callDurationList, n);
                this.requestedHangupIDs.clear();
                if (callHandling$MobileEquipmentListener.getTelMode() == 3) {
                    ListManager.getGenericASLList(1245).updateList(CallHandling.access$1500());
                } else {
                    ListManager.getGenericASLList(1245).updateList(CallHandling.access$1600());
                    CallHandling.access$500(this.this$0).getFillingInstance().updateHandsFreeMode(0, 1);
                }
                return;
            }
            if (!Util.isNullOrEmpty(callInformationArray)) {
                CallHandling.access$500(this.this$0).setFillingInstance(this);
                CallHandling.access$800(this.this$0, this);
            } else {
                CallHandling.access$500(this.this$0).setFillingInstance(null);
            }
            CallHandling.access$702(this.this$0, this);
            this.this$0.trace(new StringBuffer().append("UpdateCallList with length: ").append(callInformationArray != null ? Integer.toString(callInformationArray.length) : "null").toString());
            CallHandling.access$1700(this.this$0, callInformationArray, this);
            if (callInformationArray != null && callInformationArray.length == 1 && callInformationArray[0].telCallState == 5 && callInformationArray2 != null && callInformationArray2.length == 1 && callInformationArray2[0].telCallState == 3) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-612166400);
            }
            CallHandling.access$500(this.this$0).handleCallStates(this.this$0);
            CallHandling.access$1802(this.this$0, true);
        }
        catch (GenericEventException genericEventException) {
            this.this$0.error(genericEventException);
        }
    }

    @Override
    public void updateCallDurationList(CallDuration[] callDurationArray, int n) {
        try {
            this.callDurationList = callDurationArray;
            if (CallHandling.access$500(this.this$0).isFreeFor(this)) {
                CallHandling.access$1900(this.this$0, callDurationArray);
            }
        }
        catch (GenericEventException genericEventException) {
            this.this$0.error(genericEventException);
        }
    }

    @Override
    public void updateDisconnectReason(DisconnectReason disconnectReason, int n) {
        if (CallHandling.access$500(this.this$0).isFreeFor(this)) {
            CallHandling.access$500(this.this$0).updateDisconnectReason(disconnectReason);
            CallHandling.access$500(this.this$0).distributeCallList();
            Object[] objectArray = (PhoneCallInformationCollector[])ListManager.getGenericASLList(1160).getDSIObjects();
            for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
                PhoneCallInformationCollector phoneCallInformationCollector = objectArray[i2];
                if (phoneCallInformationCollector.callInformation.telCallID != disconnectReason.callId) continue;
                phoneCallInformationCollector.disconnectReason = PhoneUtil.convertDisconnectReasonDSI2ASL(disconnectReason.disconnectReason);
            }
            ListManager.getGenericASLList(1160).updateList(objectArray);
        }
    }

    @Override
    public void updateServiceCodeType(ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
        if (!this.this$0.getTimerServer().isTimerActive(this.this$0.getTargetId(), -1601830656)) {
            this.this$0.info("Ignoring service code type because EV_PHONE_CALL_DIAL_UPDATECALLLIST_TIMER is not running.");
        } else {
            switch (serviceCodeTypeStruct.getTelDialNumberType()) {
                case 0: {
                    AbstractASLTarget.writeIntegerToDatapool(1152, 1);
                    break;
                }
                case 1: 
                case 2: {
                    AbstractASLTarget.writeIntegerToDatapool(1090, 0);
                    this.this$0.sendHMIEvent(196);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unknown DSIMobileEquipment.DIALNUMTYPE!");
                }
            }
        }
    }

    @Override
    public void updateSuppServiceResponse(SuppServiceResponseStruct suppServiceResponseStruct, int n) {
        AbstractASLTarget.writeBooleanToDatapool(260314368, CallHandling.access$2000(suppServiceResponseStruct));
        CallHandling.access$2100(this.this$0, suppServiceResponseStruct);
    }

    @Override
    public void updateHandsFreeMode(int n, int n2) {
        this.handsFreeMode = n == 0;
        this.telAudioMode = 0;
        switch (n) {
            case 0: {
                this.telAudioMode = 0;
                break;
            }
            case 1: {
                this.telAudioMode = 4;
                break;
            }
            case 2: {
                this.telAudioMode = 5;
                break;
            }
            case 4: {
                this.telAudioMode = 2;
                break;
            }
            case 3: {
                this.telAudioMode = 3;
                break;
            }
        }
        CallHandling.access$2202(this.this$0, this.telAudioMode);
        AbstractASLTarget.writeBooleanToDatapool(1238, this.isHandsFreeMode());
        if (CallHandling.access$500(this.this$0).isFreeFor(this)) {
            if (n != 0) {
                // empty if block
            }
        } else if (n == 0) {
            this.getDSI().requestSetHandsFreeMode(4);
        }
        CallHandling.access$500(this.this$0).updatePhoneTileSCallInformation();
    }

    public int getAslAudioMode() {
        return this.telAudioMode;
    }

    public boolean isHandsFreeMode() {
        return this.handsFreeMode || this.telMode != 3;
    }

    public boolean isOutband() {
        return !Util.isBitSet(1, (int)this.telFeat) || this.telMode != 3;
    }

    @Override
    public void responseDialNumber(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
        if (n != 0 && n != 1) {
            int n2 = 0;
            switch (n) {
                case 13: {
                    n2 = 1;
                    break;
                }
                case 12: {
                    n2 = 2;
                    break;
                }
                case 11: {
                    n2 = 3;
                    break;
                }
            }
            AbstractASLTarget.writeIntegerToDatapool(1161, n2);
            this.this$0.sendHMIEvent(163);
            this.this$0.stopTimer(-1601830656);
        }
        CallHandling.access$2100(this.this$0, suppServiceResponseStruct);
    }

    private void hangupCall(int n) {
        if (!this.requestedHangupIDs.contains(n)) {
            if (n != 255) {
                this.requestedHangupIDs.add(n);
            }
            this.getDSI().hangupCall(n);
        }
    }

    static /* synthetic */ int access$000(CallHandling$MobileEquipmentListener callHandling$MobileEquipmentListener) {
        return callHandling$MobileEquipmentListener.role;
    }

    static /* synthetic */ DSIMobileEquipment access$100(CallHandling$MobileEquipmentListener callHandling$MobileEquipmentListener) {
        return callHandling$MobileEquipmentListener.getDSI();
    }

    static /* synthetic */ void access$200(CallHandling$MobileEquipmentListener callHandling$MobileEquipmentListener, int n) {
        callHandling$MobileEquipmentListener.hangupCall(n);
    }

    static /* synthetic */ IntOptHashSet access$2300(CallHandling$MobileEquipmentListener callHandling$MobileEquipmentListener) {
        return callHandling$MobileEquipmentListener.requestedHangupIDs;
    }

    static /* synthetic */ boolean access$2400(CallHandling$MobileEquipmentListener callHandling$MobileEquipmentListener) {
        return callHandling$MobileEquipmentListener.widebandSpeechActive;
    }
}

