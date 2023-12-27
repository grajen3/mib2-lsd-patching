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
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.MPSetWaitingCallOnHold_Result;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import java.util.Iterator;

public final class MPSetWaitingCallOnHold
extends Function
implements TimerNotifier,
Method,
ASLTelephoneConstants,
PhoneServiceListener {
    private boolean isExecuting = false;
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
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPSetWaitingCallOnHold_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
        this.timer = this.getTimerService().createTimer(this, 20000);
        return null;
    }

    protected MPSetWaitingCallOnHold_Result dequeueBAPEntity() {
        return (MPSetWaitingCallOnHold_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPSetWaitingCallOnHold_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPSetWaitingCallOnHold_Result = MPSetWaitingCallOnHold.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.MPSetWaitingCallOnHold_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPSetWaitingCallOnHold_Result);
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
        return 39;
    }

    @Override
    public void process(int n) {
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.isExecuting) {
            this.isExecuting = false;
            this.sendResult(methodListener, 2);
        } else {
            methodListener.requestError(80, this);
        }
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (!this.isExecuting) {
            int n = this.getPhoneService().getTelephoneFeatures();
            boolean bl = (n & 4) == 4;
            int[] nArray = this.findCallIDForCallState(3);
            if (nArray[0] == -1) {
                methodListener.requestError(151, this);
            } else if (this.findCallIDForCallState(7)[0] != -1) {
                methodListener.requestError(145, this);
            } else if (this.findCallIDForCallState(4)[0] != -1) {
                methodListener.requestError(145, this);
            } else if (this.findCallIDForCallState(5)[0] != -1 || this.findCallIDForCallState(1)[0] != -1) {
                methodListener.requestError(144, this);
            } else if (!bl) {
                methodListener.requestError(138, this);
            } else {
                this.callIdToProcess = nArray[0];
                this.expectedCallState = 4;
                this.getPhoneService().setCallStateToResponseAndHold(nArray[1]);
                this.isExecuting = true;
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
        this.isExecuting = false;
    }

    @Override
    public void uninitialize() {
        this.timer.stop();
        this.getPhoneService().removeHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
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
        MPSetWaitingCallOnHold_Result mPSetWaitingCallOnHold_Result = this.dequeueBAPEntity();
        mPSetWaitingCallOnHold_Result.mpswcoh_Result = n;
        this.getDelegate().getMethodListener(this).result(mPSetWaitingCallOnHold_Result, this);
    }

    private void sendResult(MethodListener methodListener, int n) {
        MPSetWaitingCallOnHold_Result mPSetWaitingCallOnHold_Result = this.dequeueBAPEntity();
        mPSetWaitingCallOnHold_Result.mpswcoh_Result = n;
        methodListener.result(mPSetWaitingCallOnHold_Result, this);
    }

    protected void setCurrentCallState(CallState_Status callState_Status) {
        if (this.isExecuting) {
            int n = this.findCallStateForCallID(this.callIdToProcess);
            if (n == this.expectedCallState) {
                this.sendResult(0);
                this.isExecuting = false;
            } else if (n == -1) {
                this.sendResult(1);
                this.isExecuting = false;
            }
        }
    }

    @Override
    public void timerFired(Timer timer) {
        this.callHoldFailed();
    }

    protected void callHoldFailed() {
        if (this.isExecuting) {
            this.isExecuting = false;
            this.sendResult(1);
        }
    }

    @Override
    public void processHMIEvent(int n) {
        switch (n) {
            case 483: {
                this.callHoldFailed();
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
        PHONE_LISTENER_HMI_EVENT_IDS = new int[]{483};
    }
}

