/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions.carplay;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayService;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayServiceListener;
import de.vw.mib.bap.mqbab2.common.api.carplay.datatypes.iterator.elements.CarPlayCall;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions0;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions1;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions2;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions3;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions4;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions5;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status$CallOptions6;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import de.vw.mib.bap.mqbab2.telephone.functions.carplay.CallStateCarPlay$CurrentCallOptionsMetaData;
import java.util.Iterator;

public final class CallStateCarPlay
extends Function
implements Property,
ASLTelephoneConstants,
CarPlayServiceListener {
    private static final int CALL_ID_ONE;
    private static final int CALL_ID_TWO;
    private static final int CALL_ID_THREE;
    private static final int CALL_ID_FOUR;
    private static final int CALL_ID_FIVE;
    private static final int CALL_ID_SIX;
    private static final int CALL_ID_SEVEN;
    private static final int CALL_ID_INVALID;
    private static int MAX_NUMBER_OF_CALLS;
    protected static final int[] CAR_PLAY_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallState_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getCarPlayService().addCarPlayServiceListener(this, CAR_PLAY_LISTENER_IDS);
        return this.computeCallStateStatus();
    }

    protected CallState_Status dequeueBAPEntity() {
        return (CallState_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallState_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallState_Status = CallStateCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallState_Status);
    }

    private void setCurrentCallState(CallState_Status callState_Status) {
        int[] nArray = new int[]{30, 31, 40, 41, 26, 27, 29, 37, 38, 35, 39, 32};
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

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(128, this);
    }

    @Override
    public void requestAcknowledge() {
        this.setCurrentCallState(this.computeCallStateStatus());
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getCarPlayService().removeCarPlayServiceListener(this, CAR_PLAY_LISTENER_IDS);
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

    private void sendCallStateStatus(CallState_Status callState_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(callState_Status, this);
    }

    private CallState_Status computeCallStateStatus() {
        CallState_Status callState_Status = this.dequeueBAPEntity();
        this.setCallStateStatusData(callState_Status);
        return callState_Status;
    }

    private void setCallStateStatusData(CallState_Status callState_Status) {
        Iterator iterator = this.getCarPlayService().getCarPlayCalls();
        CallStateCarPlay$CurrentCallOptionsMetaData callStateCarPlay$CurrentCallOptionsMetaData = new CallStateCarPlay$CurrentCallOptionsMetaData();
        CarPlayCall carPlayCall = null;
        while (iterator.hasNext()) {
            carPlayCall = (CarPlayCall)iterator.next();
            int n = this.getEncodedCallState(carPlayCall.getStatus(), carPlayCall.getDirection());
            int n2 = carPlayCall.getMappedCallID();
            switch (n2) {
                case 0: {
                    callState_Status.callState0 = n;
                    callState_Status.callType0 = 0;
                    break;
                }
                case 1: {
                    callState_Status.callState1 = n;
                    callState_Status.callType1 = 0;
                    break;
                }
                case 2: {
                    callState_Status.callState2 = n;
                    callState_Status.callType2 = 0;
                    break;
                }
                case 3: {
                    callState_Status.callState3 = n;
                    callState_Status.callType3 = 0;
                    break;
                }
                case 4: {
                    callState_Status.callState4 = n;
                    callState_Status.callType4 = 0;
                    break;
                }
                case 5: {
                    callState_Status.callState5 = n;
                    callState_Status.callType5 = 0;
                    break;
                }
                case 6: {
                    callState_Status.callState6 = n;
                    callState_Status.callType6 = 0;
                    break;
                }
                default: {
                    this.getLogger().error(32, "Invalid call ID received");
                }
            }
            switch (n) {
                case 1: {
                    callStateCarPlay$CurrentCallOptionsMetaData.incomingCallID = n2;
                    callStateCarPlay$CurrentCallOptionsMetaData.incomingCallPresent = true;
                    break;
                }
                case 2: {
                    callStateCarPlay$CurrentCallOptionsMetaData.activeCallID = n2;
                    callStateCarPlay$CurrentCallOptionsMetaData.activeCallPresent = true;
                    break;
                }
            }
        }
        this.encodeCallOptions(callState_Status, callStateCarPlay$CurrentCallOptionsMetaData);
    }

    private void encodeCallOptions(CallState_Status callState_Status, CallStateCarPlay$CurrentCallOptionsMetaData callStateCarPlay$CurrentCallOptionsMetaData) {
        CallState_Status$CallOptions0[] callState_Status$CallOptions0Array = new CallState_Status$CallOptions0[MAX_NUMBER_OF_CALLS];
        if (callStateCarPlay$CurrentCallOptionsMetaData.incomingCallPresent) {
            callState_Status$CallOptions0Array[callStateCarPlay$CurrentCallOptionsMetaData.incomingCallID] = new CallState_Status$CallOptions0();
            callState_Status$CallOptions0Array[callStateCarPlay$CurrentCallOptionsMetaData.incomingCallID].acceptCall = true;
        }
        this.copyCallOptions(callState_Status, callState_Status$CallOptions0Array);
    }

    private void copyCallOptions(CallState_Status callState_Status, CallState_Status$CallOptions0[] callState_Status$CallOptions0Array) {
        block9: for (int i2 = 0; i2 <= 6; ++i2) {
            CallState_Status$CallOptions0 callState_Status$CallOptions0 = callState_Status$CallOptions0Array[i2];
            if (callState_Status$CallOptions0 == null) continue;
            switch (i2) {
                case 0: {
                    this.encodeCallOptions0(callState_Status.callOptions0, callState_Status$CallOptions0);
                    continue block9;
                }
                case 1: {
                    this.encodeCallOptions1(callState_Status.callOptions1, callState_Status$CallOptions0);
                    continue block9;
                }
                case 2: {
                    this.encodeCallOptions2(callState_Status.callOptions2, callState_Status$CallOptions0);
                    continue block9;
                }
                case 3: {
                    this.encodeCallOptions3(callState_Status.callOptions3, callState_Status$CallOptions0);
                    continue block9;
                }
                case 4: {
                    this.encodeCallOptions4(callState_Status.callOptions4, callState_Status$CallOptions0);
                    continue block9;
                }
                case 5: {
                    this.encodeCallOptions5(callState_Status.callOptions5, callState_Status$CallOptions0);
                    continue block9;
                }
                case 6: {
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

    private int getEncodedCallState(int n, int n2) {
        int n3;
        switch (n) {
            case 1: {
                n3 = 2;
                break;
            }
            case 3: {
                if (n2 == 0) {
                    n3 = 1;
                    break;
                }
                if (n2 == 1) {
                    n3 = 3;
                    break;
                }
                n3 = 0;
                break;
            }
            case 2: {
                n3 = 5;
                break;
            }
            case 0: {
                n3 = 0;
                break;
            }
            default: {
                n3 = 0;
            }
        }
        return n3;
    }

    protected void emergencyCallConfirmationRequired() {
    }

    protected void emergencyCallConfirmationCloseDialog() {
    }

    @Override
    public void updateCarPlayData(CarPlayService carPlayService, int n) {
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
        MAX_NUMBER_OF_CALLS = 7;
        CAR_PLAY_LISTENER_IDS = new int[]{1126105216};
    }
}

