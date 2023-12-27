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
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.AcceptCall_Result;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import java.util.Iterator;

public final class AcceptCall
extends Function
implements TimerNotifier,
Method,
ASLTelephoneConstants,
PhoneServiceListener {
    private boolean isAcceptCallStarted;
    private int callIDToAccept = -1;
    private static final int NO_CALL_ID_FOUND;
    private static final int CALL_ID_DUMMY;
    private static final int CALL_ID_ONE;
    private static final int CALL_ID_TWO;
    private static final int CALL_ID_THREE;
    private static final int CALL_ID_FOUR;
    private static final int CALL_ID_FIVE;
    private static final int CALL_ID_SIX;
    private static final int CALL_ID_SEVEN;
    private Timer timer;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_TIME_OUT_ACTION_FAILED;
    protected static final int[] PHONE_LISTENER_HMI_EVENT_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$AcceptCall_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
        this.timer = this.getTimerService().createTimer(this, 20000);
        return null;
    }

    protected AcceptCall_Result dequeueBAPEntity() {
        return (AcceptCall_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$AcceptCall_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$AcceptCall_Result = AcceptCall.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.AcceptCall_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$AcceptCall_Result);
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
        return 30;
    }

    private int getBAPCallStateForCallID(CallState_Status callState_Status) {
        int n;
        switch (this.callIDToAccept) {
            case 1: {
                n = callState_Status.callState0;
                break;
            }
            case 2: {
                n = callState_Status.callState1;
                break;
            }
            case 3: {
                n = callState_Status.callState2;
                break;
            }
            case 4: {
                n = callState_Status.callState3;
                break;
            }
            case 5: {
                n = callState_Status.callState4;
                break;
            }
            case 6: {
                n = callState_Status.callState5;
                break;
            }
            case 7: {
                n = callState_Status.callState6;
                break;
            }
            default: {
                n = callState_Status.callState0;
            }
        }
        return n;
    }

    private int checkAcceptCallPreconditions(MethodListener methodListener) {
        int n = 151;
        int n2 = -1;
        Iterator iterator = this.getPhoneService().getCallInformations();
        while (iterator.hasNext()) {
            PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
            int n3 = phoneCallInformationElement.getCallState();
            int n4 = phoneCallInformationElement.getCallID();
            if (n3 == 5 || n3 == 2) {
                n = 144;
                n2 = -1;
                break;
            }
            if (n3 != 3) continue;
            if (n2 == -1) {
                n = 0;
                n2 = n4;
                continue;
            }
            n2 = -1;
            this.sendAcceptCallResult(methodListener, 1);
            break;
        }
        if (n != 0) {
            methodListener.requestError(n, this);
        }
        return n2;
    }

    private void acceptCallStartResult(MethodListener methodListener) {
        this.callIDToAccept = this.checkAcceptCallPreconditions(methodListener);
        if (this.callIDToAccept != -1) {
            this.isAcceptCallStarted = true;
            this.getPhoneService().acceptCall(this.callIDToAccept);
            this.timer.retrigger(new Integer(0));
        }
    }

    private void sendAcceptCallResult(int n) {
        AcceptCall_Result acceptCall_Result = this.dequeueBAPEntity();
        acceptCall_Result.acceptCall_Result = n;
        this.getDelegate().getMethodListener(this).result(acceptCall_Result, this);
    }

    private void sendAcceptCallResult(MethodListener methodListener, int n) {
        AcceptCall_Result acceptCall_Result = this.dequeueBAPEntity();
        acceptCall_Result.acceptCall_Result = n;
        methodListener.result(acceptCall_Result, this);
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.isAcceptCallStarted) {
            this.isAcceptCallStarted = false;
            this.sendAcceptCallResult(methodListener, 2);
        } else {
            methodListener.requestError(80, this);
        }
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        this.acceptCallStartResult(methodListener);
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
        this.isAcceptCallStarted = false;
        this.callIDToAccept = -1;
    }

    @Override
    public void uninitialize() {
        this.timer.stop();
        this.getPhoneService().removeHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
    }

    public void setCurrentCallState(CallState_Status callState_Status) {
        if (this.isAcceptCallStarted) {
            int n = this.getBAPCallStateForCallID(callState_Status);
            if (n == 2) {
                this.isAcceptCallStarted = false;
                this.sendAcceptCallResult(0);
            } else if (n == 0 || n == 4) {
                this.isAcceptCallStarted = false;
                this.sendAcceptCallResult(1);
            }
        }
    }

    @Override
    public void process(int n) {
    }

    @Override
    public void timerFired(Timer timer) {
        this.callAcceptFailed();
    }

    protected void callAcceptFailed() {
        if (this.isAcceptCallStarted) {
            this.isAcceptCallStarted = false;
            this.sendAcceptCallResult(1);
        }
    }

    @Override
    public void processHMIEvent(int n) {
        switch (n) {
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
        PHONE_LISTENER_HMI_EVENT_IDS = new int[]{467};
    }
}

