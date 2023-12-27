/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.elements.PhoneCallInformationElement;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.elements.PhoneConferenceCallInformationsElement;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallIncomingDiverted;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions0;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions1;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions2;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions3;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions4;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions5;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions6;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOutgoingDiverted_eCallConfirmationPending;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import de.vw.mib.bap.mqbab2.telephone.functions.CallState$CurrentCallOptionsMetaData;
import java.util.Iterator;

public final class CallState
extends Function
implements Property,
ASLTelephoneConstants,
PhoneServiceListener {
    private CallState_Status lastCallStateStatus = null;
    private boolean eCallConfirmationPending = false;
    private static final int PHONE_MAX_CONFERENCE_PARTICIPANTS;
    private static final int CALL_ID_OFFSET;
    private static final int CALL_ID_DUMMY;
    private static final int CALL_ID_ONE;
    private static final int CALL_ID_TWO;
    private static final int CALL_ID_THREE;
    private static final int CALL_ID_FOUR;
    private static final int CALL_ID_FIVE;
    private static final int CALL_ID_SIX;
    private static final int CALL_ID_SEVEN;
    private static final int CALL_ID_CONFERENCE;
    private static final int CALL_ID_INVALID;
    private static final int INVALID_NUMBER;
    protected static final int[] PHONE_LISTENER_IDS;
    protected static final int[] PHONE_LISTENER_HMI_EVENT_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallState_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        this.getPhoneService().addHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
        this.lastCallStateStatus = new CallState_Status();
        return this.lastCallStateStatus;
    }

    protected CallState_Status dequeueBAPEntity() {
        return (CallState_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallState_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallState_Status = CallState.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallState_Status);
    }

    protected void setCurrentCallState(CallState_Status callState_Status) {
        int[] nArray = new int[]{30, 31, 40, 41, 28, 26, 27, 29, 37, 38, 35, 39, 36, 32};
        this.context.updateStages(this, nArray, callState_Status);
    }

    protected void setCurrentCallStates(Object object) {
        int[] nArray = new int[]{25};
        this.context.updateStages(this, nArray, object);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 22;
    }

    private void sendCallStateStatus(CallState_Status callState_Status) {
        if (this.getDelegate().getPropertyListener(this).statusProperty(callState_Status, this)) {
            this.setCurrentCallStates(new int[]{callState_Status.callState0, callState_Status.callState1, callState_Status.callState2, callState_Status.callState3, callState_Status.callState4, callState_Status.callState5, callState_Status.callState6});
            this.lastCallStateStatus = callState_Status;
        }
    }

    private int getEncodedCallState(int n, int n2) {
        int n3;
        switch (n) {
            case 0: {
                n3 = 0;
                break;
            }
            case 3: {
                n3 = 1;
                break;
            }
            case 5: {
                n3 = 2;
                break;
            }
            case 1: 
            case 2: {
                n3 = 3;
                break;
            }
            case 6: {
                if (n2 == 4) {
                    n3 = 7;
                    break;
                }
                n3 = 4;
                break;
            }
            case 7: {
                n3 = 5;
                break;
            }
            case 4: {
                n3 = 8;
                break;
            }
            default: {
                n3 = 0;
            }
        }
        return n3;
    }

    private int getEncodedCallType(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 1;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            case 2: {
                n2 = 3;
                break;
            }
            case 3: {
                n2 = 4;
                break;
            }
            case 6: {
                n2 = 5;
                break;
            }
            case 5: 
            case 8: {
                n2 = 6;
                break;
            }
            case 4: {
                n2 = 7;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private void encodeCallOptions(CallState_Status callState_Status, CallState$CurrentCallOptionsMetaData callState$CurrentCallOptionsMetaData) {
        int n;
        int n2;
        Iterator iterator;
        boolean bl;
        int n32;
        int n4;
        int n5;
        int n6;
        int n7;
        boolean bl2;
        PhoneService phoneService = this.getPhoneService();
        CallState_Status$CallOptions0[] callState_Status$CallOptions0Array = new CallState_Status$CallOptions0[8];
        if (!callState$CurrentCallOptionsMetaData.activeCallPresent && !callState$CurrentCallOptionsMetaData.conferenceCallActive && callState$CurrentCallOptionsMetaData.incomingCallPresent) {
            callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.incomingCallID] = new CallState_Status$CallOptions0();
            callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.incomingCallID].acceptCall = true;
        }
        boolean bl3 = bl2 = ((n7 = phoneService.getTelephoneFeatures()) & 8) == 8;
        if (bl2 && !callState$CurrentCallOptionsMetaData.holdCallPresent && !callState$CurrentCallOptionsMetaData.conferenceCallHold && (callState$CurrentCallOptionsMetaData.activeCallPresent || callState$CurrentCallOptionsMetaData.conferenceCallActive)) {
            if (callState$CurrentCallOptionsMetaData.activeCallPresent) {
                callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.activeCallID] = new CallState_Status$CallOptions0();
                callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.activeCallID].callHold = true;
            }
            if (callState$CurrentCallOptionsMetaData.conferenceCallActive) {
                n6 = callState$CurrentCallOptionsMetaData.conferenceCallIds.length;
                for (n5 = 0; n5 < n6; ++n5) {
                    n4 = callState$CurrentCallOptionsMetaData.conferenceCallIds[n5];
                    if (n4 == -1) continue;
                    callState_Status$CallOptions0Array[n4] = callState_Status$CallOptions0Array[n4] == null ? new CallState_Status$CallOptions0() : callState_Status$CallOptions0Array[n4];
                    callState_Status$CallOptions0Array[n4].callHold = true;
                }
            }
        }
        int n8 = n6 = (n7 & 4) == 4 ? 1 : 0;
        if (n6 != 0) {
            int n9 = n5 = callState$CurrentCallOptionsMetaData.incomingCallPresent && !callState$CurrentCallOptionsMetaData.conferenceCallHold && !callState$CurrentCallOptionsMetaData.holdCallPresent && !callState$CurrentCallOptionsMetaData.activeCallPresent ? 1 : 0;
            if (n5 != 0) {
                callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.incomingCallID] = callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.incomingCallID] == null ? new CallState_Status$CallOptions0() : callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.incomingCallID];
                callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.incomingCallID].callHold = true;
            }
        }
        if (!callState$CurrentCallOptionsMetaData.activeCallPresent && !callState$CurrentCallOptionsMetaData.conferenceCallActive && (callState$CurrentCallOptionsMetaData.holdCallPresent || callState$CurrentCallOptionsMetaData.conferenceCallHold)) {
            if (callState$CurrentCallOptionsMetaData.holdCallPresent) {
                callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.holdCallID] = callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.holdCallID] == null ? new CallState_Status$CallOptions0() : callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.holdCallID];
                callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.holdCallID].resumeCall = true;
            }
            if (callState$CurrentCallOptionsMetaData.conferenceCallHold) {
                for (int n32 : callState$CurrentCallOptionsMetaData.conferenceCallIds) {
                    if (n32 == -1) continue;
                    callState_Status$CallOptions0Array[n32] = callState_Status$CallOptions0Array[n32] == null ? new CallState_Status$CallOptions0() : callState_Status$CallOptions0Array[n32];
                    callState_Status$CallOptions0Array[n32].resumeCall = true;
                }
            }
        }
        n5 = (n7 & 0x10) == 16 ? 1 : 0;
        n4 = (n7 & 0x40) == 64 ? 1 : 0;
        n32 = n5 != 0 || bl2 ? 1 : 0;
        boolean bl4 = bl = callState$CurrentCallOptionsMetaData.incomingCallPresent && (callState$CurrentCallOptionsMetaData.activeCallPresent && !callState$CurrentCallOptionsMetaData.conferenceCallHold && !callState$CurrentCallOptionsMetaData.holdCallPresent || callState$CurrentCallOptionsMetaData.conferenceCallActive && !callState$CurrentCallOptionsMetaData.holdCallPresent);
        if (bl) {
            CallState_Status$CallOptions0 callState_Status$CallOptions0 = callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.incomingCallID] = callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.incomingCallID] == null ? new CallState_Status$CallOptions0() : callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.incomingCallID];
            if (n32 != 0) {
                callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.incomingCallID].mpholdAcceptWaiting = true;
            }
        }
        if (callState$CurrentCallOptionsMetaData.incomingCallPresent && (callState$CurrentCallOptionsMetaData.activeCallPresent || callState$CurrentCallOptionsMetaData.conferenceCallActive) && (n32 == 0 || !bl)) {
            callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.incomingCallID] = callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.incomingCallID] == null ? new CallState_Status$CallOptions0() : callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.incomingCallID];
            callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.incomingCallID].mpreleaseActiceCallAcceptWaitingCall = true;
        }
        if ((callState$CurrentCallOptionsMetaData.activeCallPresent || callState$CurrentCallOptionsMetaData.conferenceCallActive) && (callState$CurrentCallOptionsMetaData.holdCallPresent || callState$CurrentCallOptionsMetaData.conferenceCallHold)) {
            iterator = phoneService.getConferenceCallInformations();
            int n10 = 0;
            while (iterator.hasNext()) {
                iterator.next();
                ++n10;
            }
            n2 = n10;
            int n11 = n = (phoneService.getCurrentPhoneProfile() != 2 || n5 != 0 || n4 != 0) && n2 <= 4 ? 1 : 0;
            if (callState$CurrentCallOptionsMetaData.activeCallPresent) {
                callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.activeCallID] = callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.activeCallID] == null ? new CallState_Status$CallOptions0() : callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.activeCallID];
                callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.activeCallID].mpswap = true;
                callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.activeCallID].ccjoin = n;
            }
            if (callState$CurrentCallOptionsMetaData.holdCallPresent) {
                callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.holdCallID] = callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.holdCallID] == null ? new CallState_Status$CallOptions0() : callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.holdCallID];
                callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.holdCallID].mpswap = true;
                callState_Status$CallOptions0Array[callState$CurrentCallOptionsMetaData.holdCallID].ccjoin = n;
            }
            iterator = phoneService.getConferenceCallInformations();
            while (iterator.hasNext()) {
                PhoneConferenceCallInformationsElement phoneConferenceCallInformationsElement = (PhoneConferenceCallInformationsElement)iterator.next();
                int n12 = phoneConferenceCallInformationsElement.getConferenceCallId();
                if (n12 == -1) continue;
                callState_Status$CallOptions0Array[n12] = callState_Status$CallOptions0Array[n12] == null ? new CallState_Status$CallOptions0() : callState_Status$CallOptions0Array[n12];
                callState_Status$CallOptions0Array[n12].mpswap = true;
                callState_Status$CallOptions0Array[n12].ccjoin = n;
            }
        }
        if (callState$CurrentCallOptionsMetaData.conferenceCallActive && !callState$CurrentCallOptionsMetaData.holdCallPresent || callState$CurrentCallOptionsMetaData.conferenceCallHold && !callState$CurrentCallOptionsMetaData.activeCallPresent && !callState$CurrentCallOptionsMetaData.incomingCallPresent) {
            iterator = phoneService.getConferenceCallInformations();
            while (iterator.hasNext()) {
                PhoneConferenceCallInformationsElement phoneConferenceCallInformationsElement = (PhoneConferenceCallInformationsElement)iterator.next();
                n2 = phoneConferenceCallInformationsElement.getConferenceSplitAvailable() ? 1 : 0;
                n = phoneConferenceCallInformationsElement.getConferenceCallId();
                if (n == -1) continue;
                callState_Status$CallOptions0Array[n] = callState_Status$CallOptions0Array[n] == null ? new CallState_Status$CallOptions0() : callState_Status$CallOptions0Array[n];
                callState_Status$CallOptions0Array[n].ccsplit = n2;
            }
        }
        this.copyCallOptions(callState_Status, callState_Status$CallOptions0Array);
    }

    private void copyCallOptions(CallState_Status callState_Status, CallState_Status$CallOptions0[] callState_Status$CallOptions0Array) {
        block9: for (int i2 = 1; i2 <= 7; ++i2) {
            CallState_Status$CallOptions0 callState_Status$CallOptions0 = callState_Status$CallOptions0Array[i2];
            if (callState_Status$CallOptions0 == null) continue;
            switch (i2) {
                case 1: {
                    this.encodeCallOptions0(callState_Status.callOptions0, callState_Status$CallOptions0);
                    continue block9;
                }
                case 2: {
                    this.encodeCallOptions1(callState_Status.callOptions1, callState_Status$CallOptions0);
                    continue block9;
                }
                case 3: {
                    this.encodeCallOptions2(callState_Status.callOptions2, callState_Status$CallOptions0);
                    continue block9;
                }
                case 4: {
                    this.encodeCallOptions3(callState_Status.callOptions3, callState_Status$CallOptions0);
                    continue block9;
                }
                case 5: {
                    this.encodeCallOptions4(callState_Status.callOptions4, callState_Status$CallOptions0);
                    continue block9;
                }
                case 6: {
                    this.encodeCallOptions5(callState_Status.callOptions5, callState_Status$CallOptions0);
                    continue block9;
                }
                case 7: {
                    this.encodeCallOptions6(callState_Status.callOptions6, callState_Status$CallOptions0);
                    continue block9;
                }
            }
        }
    }

    private void encodeCallOptions0(CallState_Status$CallOptions0 callState_Status$CallOptions0, CallState_Status$CallOptions0 callState_Status$CallOptions02) {
        callState_Status$CallOptions0.acceptCall = callState_Status$CallOptions02.acceptCall;
        callState_Status$CallOptions0.mpholdAcceptWaiting = callState_Status$CallOptions02.mpholdAcceptWaiting;
        callState_Status$CallOptions0.mpreleaseActiceCallAcceptWaitingCall = callState_Status$CallOptions02.mpreleaseActiceCallAcceptWaitingCall;
        callState_Status$CallOptions0.callHold = callState_Status$CallOptions02.callHold;
        callState_Status$CallOptions0.resumeCall = callState_Status$CallOptions02.resumeCall;
        callState_Status$CallOptions0.mpswap = callState_Status$CallOptions02.mpswap;
        callState_Status$CallOptions0.ccjoin = callState_Status$CallOptions02.ccjoin;
        callState_Status$CallOptions0.ccsplit = callState_Status$CallOptions02.ccsplit;
    }

    private void encodeCallOptions1(CallState_Status$CallOptions1 callState_Status$CallOptions1, CallState_Status$CallOptions0 callState_Status$CallOptions0) {
        callState_Status$CallOptions1.acceptCall = callState_Status$CallOptions0.acceptCall;
        callState_Status$CallOptions1.mpcallHoldAcceptWaitingCall = callState_Status$CallOptions0.mpholdAcceptWaiting;
        callState_Status$CallOptions1.mpreleaseActiceCallAcceptWaitingCall = callState_Status$CallOptions0.mpreleaseActiceCallAcceptWaitingCall;
        callState_Status$CallOptions1.callHold = callState_Status$CallOptions0.callHold;
        callState_Status$CallOptions1.resumeCall = callState_Status$CallOptions0.resumeCall;
        callState_Status$CallOptions1.mpswap = callState_Status$CallOptions0.mpswap;
        callState_Status$CallOptions1.ccjoin = callState_Status$CallOptions0.ccjoin;
        callState_Status$CallOptions1.ccsplit = callState_Status$CallOptions0.ccsplit;
    }

    private void encodeCallOptions2(CallState_Status$CallOptions2 callState_Status$CallOptions2, CallState_Status$CallOptions0 callState_Status$CallOptions0) {
        callState_Status$CallOptions2.acceptCall = callState_Status$CallOptions0.acceptCall;
        callState_Status$CallOptions2.mpcallHoldAcceptWaitingCall = callState_Status$CallOptions0.mpholdAcceptWaiting;
        callState_Status$CallOptions2.mpreleaseActiceCallAcceptWaitingCall = callState_Status$CallOptions0.mpreleaseActiceCallAcceptWaitingCall;
        callState_Status$CallOptions2.callHold = callState_Status$CallOptions0.callHold;
        callState_Status$CallOptions2.resumeCall = callState_Status$CallOptions0.resumeCall;
        callState_Status$CallOptions2.mpswap = callState_Status$CallOptions0.mpswap;
        callState_Status$CallOptions2.ccjoin = callState_Status$CallOptions0.ccjoin;
        callState_Status$CallOptions2.ccsplit = callState_Status$CallOptions0.ccsplit;
    }

    private void encodeCallOptions3(CallState_Status$CallOptions3 callState_Status$CallOptions3, CallState_Status$CallOptions0 callState_Status$CallOptions0) {
        callState_Status$CallOptions3.acceptCall = callState_Status$CallOptions0.acceptCall;
        callState_Status$CallOptions3.mpcallHoldAcceptWaitingCall = callState_Status$CallOptions0.mpholdAcceptWaiting;
        callState_Status$CallOptions3.mpreleaseActiceCallAcceptWaitingCall = callState_Status$CallOptions0.mpreleaseActiceCallAcceptWaitingCall;
        callState_Status$CallOptions3.callHold = callState_Status$CallOptions0.callHold;
        callState_Status$CallOptions3.resumeCall = callState_Status$CallOptions0.resumeCall;
        callState_Status$CallOptions3.mpswap = callState_Status$CallOptions0.mpswap;
        callState_Status$CallOptions3.ccjoin = callState_Status$CallOptions0.ccjoin;
        callState_Status$CallOptions3.ccsplit = callState_Status$CallOptions0.ccsplit;
    }

    private void encodeCallOptions4(CallState_Status$CallOptions4 callState_Status$CallOptions4, CallState_Status$CallOptions0 callState_Status$CallOptions0) {
        callState_Status$CallOptions4.acceptCall = callState_Status$CallOptions0.acceptCall;
        callState_Status$CallOptions4.mpcallHoldAcceptWaitingCall = callState_Status$CallOptions0.mpholdAcceptWaiting;
        callState_Status$CallOptions4.mpreleaseActiceCallAcceptWaitingCall = callState_Status$CallOptions0.mpreleaseActiceCallAcceptWaitingCall;
        callState_Status$CallOptions4.callHold = callState_Status$CallOptions0.callHold;
        callState_Status$CallOptions4.resumeCall = callState_Status$CallOptions0.resumeCall;
        callState_Status$CallOptions4.mpswap = callState_Status$CallOptions0.mpswap;
        callState_Status$CallOptions4.ccjoin = callState_Status$CallOptions0.ccjoin;
        callState_Status$CallOptions4.ccsplit = callState_Status$CallOptions0.ccsplit;
    }

    private void encodeCallOptions5(CallState_Status$CallOptions5 callState_Status$CallOptions5, CallState_Status$CallOptions0 callState_Status$CallOptions0) {
        callState_Status$CallOptions5.acceptCall = callState_Status$CallOptions0.acceptCall;
        callState_Status$CallOptions5.mpcallHoldAcceptWaitingCall = callState_Status$CallOptions0.mpholdAcceptWaiting;
        callState_Status$CallOptions5.mpreleaseActiceCallAcceptWaitingCall = callState_Status$CallOptions0.mpreleaseActiceCallAcceptWaitingCall;
        callState_Status$CallOptions5.callHold = callState_Status$CallOptions0.callHold;
        callState_Status$CallOptions5.resumeCall = callState_Status$CallOptions0.resumeCall;
        callState_Status$CallOptions5.mpswap = callState_Status$CallOptions0.mpswap;
        callState_Status$CallOptions5.ccjoin = callState_Status$CallOptions0.ccjoin;
        callState_Status$CallOptions5.ccsplit = callState_Status$CallOptions0.ccsplit;
    }

    private void encodeCallOptions6(CallState_Status$CallOptions6 callState_Status$CallOptions6, CallState_Status$CallOptions0 callState_Status$CallOptions0) {
        callState_Status$CallOptions6.acceptCall = callState_Status$CallOptions0.acceptCall;
        callState_Status$CallOptions6.mpcallHoldAcceptWaitingCall = callState_Status$CallOptions0.mpholdAcceptWaiting;
        callState_Status$CallOptions6.mpreleaseActiceCallAcceptWaitingCall = callState_Status$CallOptions0.mpreleaseActiceCallAcceptWaitingCall;
        callState_Status$CallOptions6.callHold = callState_Status$CallOptions0.callHold;
        callState_Status$CallOptions6.resumeCall = callState_Status$CallOptions0.resumeCall;
        callState_Status$CallOptions6.mpswap = callState_Status$CallOptions0.mpswap;
        callState_Status$CallOptions6.ccjoin = callState_Status$CallOptions0.ccjoin;
        callState_Status$CallOptions6.ccsplit = callState_Status$CallOptions0.ccsplit;
    }

    private void setCallincomingDiverted(CallState_Status$CallIncomingDiverted callState_Status$CallIncomingDiverted) {
        callState_Status$CallIncomingDiverted.call0Diverted = false;
        callState_Status$CallIncomingDiverted.call1Diverted = false;
        callState_Status$CallIncomingDiverted.call2Diverted = false;
        callState_Status$CallIncomingDiverted.call3Diverted = false;
        callState_Status$CallIncomingDiverted.call4Diverted = false;
        callState_Status$CallIncomingDiverted.call5Diverted = false;
        callState_Status$CallIncomingDiverted.call6Diverted = false;
    }

    private void setCallOutgoingDiverted_eCallConfirmationPending(CallState_Status$CallOutgoingDiverted_eCallConfirmationPending callState_Status$CallOutgoingDiverted_eCallConfirmationPending) {
        callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call0Diverted = false;
        callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call1Diverted = false;
        callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call2Diverted = false;
        callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call3Diverted = false;
        callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call4Diverted = false;
        callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call5Diverted = false;
        callState_Status$CallOutgoingDiverted_eCallConfirmationPending.call6Diverted = false;
        callState_Status$CallOutgoingDiverted_eCallConfirmationPending.eCallConfirmationPending = this.eCallConfirmationPending;
    }

    private void setCallStateStatusForConference(CallState_Status callState_Status, CallState$CurrentCallOptionsMetaData callState$CurrentCallOptionsMetaData, int n) {
        if (callState$CurrentCallOptionsMetaData.conferenceCallPresent) {
            Iterator iterator = this.getPhoneService().getConferenceCallInformations();
            while (iterator.hasNext()) {
                PhoneConferenceCallInformationsElement phoneConferenceCallInformationsElement = (PhoneConferenceCallInformationsElement)iterator.next();
                int n2 = phoneConferenceCallInformationsElement.getConferenceCallId();
                int n3 = phoneConferenceCallInformationsElement.getConferenceDisconnectReason();
                int n4 = this.getEncodedCallState(phoneConferenceCallInformationsElement.getConferenceCallState(), n3);
                switch (n2) {
                    case 1: {
                        callState_Status.callState0 = n4;
                        callState_Status.callType0 = n;
                        break;
                    }
                    case 2: {
                        callState_Status.callState1 = n4;
                        callState_Status.callType1 = n;
                        break;
                    }
                    case 3: {
                        callState_Status.callState2 = n4;
                        callState_Status.callType2 = n;
                        break;
                    }
                    case 4: {
                        callState_Status.callState3 = n4;
                        callState_Status.callType3 = n;
                        break;
                    }
                    case 5: {
                        callState_Status.callState4 = n4;
                        callState_Status.callType4 = n;
                        break;
                    }
                    case 6: {
                        callState_Status.callState5 = n4;
                        callState_Status.callType5 = n;
                        break;
                    }
                    case 7: {
                        callState_Status.callState6 = n4;
                        callState_Status.callType6 = n;
                        break;
                    }
                }
                if (n2 == 254) continue;
                callState$CurrentCallOptionsMetaData.conferenceCallIds[n2] = n2;
            }
        }
    }

    private void setCallStateStatusData(CallState_Status callState_Status) {
        Iterator iterator = this.getPhoneService().getCallInformations();
        CallState$CurrentCallOptionsMetaData callState$CurrentCallOptionsMetaData = new CallState$CurrentCallOptionsMetaData();
        int n = -1;
        int n2 = -1;
        while (iterator.hasNext()) {
            PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
            int n3 = phoneCallInformationElement.getCallDisconnectionReason();
            int n4 = this.getEncodedCallState(phoneCallInformationElement.getCallState(), n3);
            int n5 = this.getEncodedCallType(phoneCallInformationElement.getCallType());
            int n6 = phoneCallInformationElement.getCallID();
            switch (n6) {
                case 1: {
                    callState_Status.callState0 = n4;
                    callState_Status.callType0 = n5;
                    break;
                }
                case 2: {
                    callState_Status.callState1 = n4;
                    callState_Status.callType1 = n5;
                    break;
                }
                case 3: {
                    callState_Status.callState2 = n4;
                    callState_Status.callType2 = n5;
                    break;
                }
                case 4: {
                    callState_Status.callState3 = n4;
                    callState_Status.callType3 = n5;
                    break;
                }
                case 5: {
                    callState_Status.callState4 = n4;
                    callState_Status.callType4 = n5;
                    break;
                }
                case 6: {
                    callState_Status.callState5 = n4;
                    callState_Status.callType5 = n5;
                    break;
                }
                case 7: {
                    callState_Status.callState6 = n4;
                    callState_Status.callType6 = n5;
                    break;
                }
                case 254: {
                    n = n4;
                    n2 = n5;
                    callState$CurrentCallOptionsMetaData.conferenceCallPresent = true;
                    callState$CurrentCallOptionsMetaData.conferenceCallActive = n == 2;
                    callState$CurrentCallOptionsMetaData.conferenceCallHold = n == 5;
                    break;
                }
                case 0: {
                    break;
                }
                default: {
                    this.getLogger().error(32, "Invalid call ID received");
                }
            }
            if (n6 == 254) continue;
            switch (n4) {
                case 1: {
                    callState$CurrentCallOptionsMetaData.incomingCallID = n6;
                    callState$CurrentCallOptionsMetaData.incomingCallPresent = true;
                    break;
                }
                case 2: {
                    callState$CurrentCallOptionsMetaData.activeCallID = n6;
                    callState$CurrentCallOptionsMetaData.activeCallPresent = true;
                    break;
                }
                case 5: 
                case 8: {
                    callState$CurrentCallOptionsMetaData.holdCallID = n6;
                    callState$CurrentCallOptionsMetaData.holdCallPresent = true;
                    break;
                }
            }
        }
        this.setCallStateStatusForConference(callState_Status, callState$CurrentCallOptionsMetaData, n2);
        this.encodeCallOptions(callState_Status, callState$CurrentCallOptionsMetaData);
        this.setCallincomingDiverted(callState_Status.callIncomingDiverted);
        this.setCallOutgoingDiverted_eCallConfirmationPending(callState_Status.callOutgoingDiverted_eCallConfirmationPending);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(128, this);
    }

    @Override
    public void requestAcknowledge() {
        this.setCurrentCallState(this.lastCallStateStatus);
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
        this.eCallConfirmationPending = false;
    }

    @Override
    public void uninitialize() {
        this.getPhoneService().removePhoneServiceListener(this, PHONE_LISTENER_IDS);
        this.getPhoneService().removeHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(128, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void process(int n) {
        this.sendCallStateStatus(this.computeCallStateStatus());
    }

    private CallState_Status computeCallStateStatus() {
        CallState_Status callState_Status = this.dequeueBAPEntity();
        this.setCallStateStatusData(callState_Status);
        return callState_Status;
    }

    protected void emergencyCallConfirmationRequired() {
        this.eCallConfirmationPending = true;
        this.sendCallStateStatus(this.computeCallStateStatus());
    }

    protected void emergencyCallConfirmationCloseDialog() {
        this.eCallConfirmationPending = false;
        this.sendCallStateStatus(this.computeCallStateStatus());
    }

    @Override
    public void processHMIEvent(int n) {
        switch (n) {
            case 164: {
                this.emergencyCallConfirmationCloseDialog();
                break;
            }
            case 165: {
                this.emergencyCallConfirmationRequired();
                break;
            }
        }
    }

    @Override
    public void updatePhoneData(PhoneService phoneService, int n) {
        this.process(-1);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        PHONE_LISTENER_IDS = new int[]{1103, 1118, 1158, 1160};
        PHONE_LISTENER_HMI_EVENT_IDS = new int[]{164, 165};
    }
}

