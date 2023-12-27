/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.elements.PhoneCallInformationElement;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.MPRelActiveCallAcceptWC_Result;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import de.vw.mib.collections.ints.IntArrayList;
import de.vw.mib.collections.ints.IntIterator;
import java.util.Iterator;

public final class MPReleaseAllCallsAcceptWaitingCall
extends Function
implements TimerNotifier,
Method,
ASLTelephoneConstants,
PhoneServiceListener {
    private static final int STATE_IDLE;
    private static final int STATE_WAIT_FOR_HANGUP;
    private static final int STATE_WAIT_FOR_ACCEPT;
    private int currentState = 0;
    private int callIdToProcess = -1;
    private int expectedCallState = -1;
    private static final int INVALID_INDEX;
    private static final int INDEX_FIRST_CALLID;
    private static final int INDEX_SECOND_CALL_INDEX;
    private static final int INDEX_COUNT;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_TIME_OUT_ACTION_FAILED;
    protected static final int[] PHONE_LISTENER_HMI_EVENT_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPRelActiveCallAcceptWC_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
        this.timer = this.getTimerService().createTimer(this, 20000);
        return null;
    }

    protected MPRelActiveCallAcceptWC_Result dequeueBAPEntity() {
        return (MPRelActiveCallAcceptWC_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPRelActiveCallAcceptWC_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPRelActiveCallAcceptWC_Result = MPReleaseAllCallsAcceptWaitingCall.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.MPRelActiveCallAcceptWC_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPRelActiveCallAcceptWC_Result);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 22: {
                this.setCurrentCallState((CallState_Status)object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 38;
    }

    @Override
    public void process(int n) {
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.currentState != 0) {
            this.currentState = 0;
            this.sendResult(methodListener, 2);
        } else {
            methodListener.requestError(80, this);
        }
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.currentState == 0) {
            int[] nArray = this.findCallIDForCallState(3);
            if (nArray[0] == -1) {
                methodListener.requestError(151, this);
            } else {
                IntArrayList intArrayList = this.findAllCallIndecesForStates(5, 7, 4);
                PhoneService phoneService = this.getPhoneService();
                if (intArrayList.size() > 0) {
                    IntIterator intIterator = intArrayList.iterator();
                    while (intIterator.hasNext()) {
                        phoneService.hangUpCall(intIterator.next());
                    }
                    this.currentState = 1;
                } else {
                    phoneService.acceptCall(nArray[1]);
                    this.currentState = 2;
                }
                this.callIdToProcess = nArray[0];
                this.expectedCallState = 5;
                this.timer.retrigger(new Integer(0));
            }
        } else {
            methodListener.requestError(66, this);
        }
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
        this.currentState = 0;
    }

    @Override
    public void uninitialize() {
        this.timer.stop();
        this.getPhoneService().removeHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
    }

    private IntArrayList findAllCallIndecesForStates(int n, int n2, int n3) {
        IntArrayList intArrayList = new IntArrayList();
        Iterator iterator = this.getPhoneService().getCallInformations();
        int n4 = 0;
        while (iterator.hasNext()) {
            PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
            int n5 = phoneCallInformationElement.getCallState();
            if (n5 == n || n5 == n2 || n5 == n3) {
                intArrayList.add(n4);
            }
            ++n4;
        }
        return intArrayList;
    }

    private int[] findCallIDForCallState(int n) {
        int[] nArray = new int[]{-1, -1};
        Iterator iterator = this.getPhoneService().getCallInformations();
        int n2 = 0;
        while (iterator.hasNext()) {
            PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
            if (phoneCallInformationElement.getCallState() == n) {
                nArray[0] = phoneCallInformationElement.getCallID();
                nArray[1] = n2;
                break;
            }
            ++n2;
        }
        return nArray;
    }

    private int findCallStateForCallID(int n) {
        int n2 = -1;
        Iterator iterator = this.getPhoneService().getCallInformations();
        while (iterator.hasNext()) {
            PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
            if (phoneCallInformationElement.getCallID() != n) continue;
            n2 = phoneCallInformationElement.getCallState();
        }
        return n2;
    }

    private void sendResult(int n) {
        MPRelActiveCallAcceptWC_Result mPRelActiveCallAcceptWC_Result = this.dequeueBAPEntity();
        mPRelActiveCallAcceptWC_Result.mpracawc_Result = n;
        this.getDelegate().getMethodListener(this).result(mPRelActiveCallAcceptWC_Result, this);
    }

    private void sendResult(MethodListener methodListener, int n) {
        MPRelActiveCallAcceptWC_Result mPRelActiveCallAcceptWC_Result = this.dequeueBAPEntity();
        mPRelActiveCallAcceptWC_Result.mpracawc_Result = n;
        methodListener.result(mPRelActiveCallAcceptWC_Result, this);
    }

    protected void setCurrentCallState(CallState_Status callState_Status) {
        if (this.currentState != 0) {
            if (this.currentState == 1) {
                IntArrayList intArrayList = this.findAllCallIndecesForStates(5, 7, 4);
                if (intArrayList.size() == 0) {
                    this.getPhoneService().acceptCall(this.callIdToProcess);
                    this.currentState = 2;
                }
            } else {
                int n = this.findCallStateForCallID(this.callIdToProcess);
                if (n == this.expectedCallState) {
                    this.releaseAllCallsAcceptWaitingCallSucceeded();
                } else if (n == -1) {
                    this.releaseAllCallsAcceptWaitingCallFailed();
                }
            }
        }
    }

    private void releaseAllCallsAcceptWaitingCallSucceeded() {
        this.sendResult(0);
        this.currentState = 0;
    }

    private void releaseAllCallsAcceptWaitingCallFailed() {
        this.sendResult(1);
        this.currentState = 0;
    }

    @Override
    public void timerFired(Timer timer) {
        this.callAcceptFailed();
    }

    protected void callAcceptFailed() {
        if (this.currentState == 1) {
            this.releaseAllCallsAcceptWaitingCallFailed();
        }
    }

    protected void callHangUpFailed() {
        if (this.currentState == 1) {
            this.releaseAllCallsAcceptWaitingCallFailed();
        }
    }

    @Override
    public void processHMIEvent(int n) {
        switch (n) {
            case 464: {
                this.callHangUpFailed();
                break;
            }
            case 467: {
                this.callAcceptFailed();
                break;
            }
        }
    }

    @Override
    public void updatePhoneData(PhoneService phoneService, int n) {
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
        PHONE_LISTENER_HMI_EVENT_IDS = new int[]{464, 467};
    }
}

