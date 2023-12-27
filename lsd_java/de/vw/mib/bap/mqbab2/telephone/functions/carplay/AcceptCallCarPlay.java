/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions.carplay;

import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayService;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayServiceListener;
import de.vw.mib.bap.mqbab2.common.api.carplay.datatypes.iterator.elements.CarPlayCall;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.AcceptCall_Result;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status;
import java.util.Iterator;

class AcceptCallCarPlay
extends Function
implements TimerNotifier,
Method,
CarPlayServiceListener {
    private boolean isAcceptCallStarted;
    private int callIDToAccept;
    private static final int NO_CALL_ID_FOUND;
    private static final int CALL_ID_DUMMY;
    private static final int CALL_ID_ONE;
    private static final int CALL_ID_TWO;
    private static final int CALL_ID_THREE;
    private static final int CALL_ID_FOUR;
    private static final int CALL_ID_FIVE;
    private static final int CALL_ID_SIX;
    private static final int CALL_ID_SEVEN;
    protected static final int[] CAR_PLAY_LISTENER_HMI_EVENT_IDS;
    private Timer timer;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_TIME_OUT_ACTION_FAILED;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$AcceptCall_Result;

    AcceptCallCarPlay() {
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getCarPlayService().addCarPlayServiceListener(this, CAR_PLAY_LISTENER_HMI_EVENT_IDS);
        return null;
    }

    private Timer getTimer() {
        if (this.timer == null) {
            this.timer = this.getTimerService().createTimer(this, 20000);
        }
        return this.timer;
    }

    @Override
    public void process(int n) {
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

    @Override
    public void initialize(boolean bl) {
        this.isAcceptCallStarted = false;
        this.callIDToAccept = -1;
    }

    @Override
    public void uninitialize() {
        if (this.isAcceptCallStarted) {
            this.sendAcceptCallResult(1);
        }
        this.getTimer().stop();
        this.getCarPlayService().removeCarPlayServiceListener(this, CAR_PLAY_LISTENER_HMI_EVENT_IDS);
    }

    private void setCurrentCallState(CallState_Status callState_Status) {
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

    private void sendAcceptCallResult(int n) {
        AcceptCall_Result acceptCall_Result = this.dequeueBAPEntity();
        acceptCall_Result.acceptCall_Result = n;
        this.getDelegate().getMethodListener(this).result(acceptCall_Result, this);
    }

    protected AcceptCall_Result dequeueBAPEntity() {
        return (AcceptCall_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$AcceptCall_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$AcceptCall_Result = AcceptCallCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.AcceptCall_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$AcceptCall_Result);
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
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        this.acceptCallStartResult(methodListener);
    }

    private void acceptCallStartResult(MethodListener methodListener) {
        this.callIDToAccept = this.checkAcceptCallPreconditions(methodListener);
        if (this.callIDToAccept != -1) {
            this.isAcceptCallStarted = true;
            this.getCarPlayService().acceptCall(this.callIDToAccept);
            this.getTimer().retrigger(new Integer(0));
        }
        if (this.getLogger().isTraceEnabled(32)) {
            this.getLogger().trace(32).append("CarPlay AcceptCall: Call ID to accept is ").append(this.callIDToAccept).log();
        }
    }

    private int checkAcceptCallPreconditions(MethodListener methodListener) {
        int n = 151;
        int n2 = -1;
        Iterator iterator = this.getCarPlayService().getCarPlayCalls();
        while (iterator.hasNext()) {
            CarPlayCall carPlayCall = (CarPlayCall)iterator.next();
            int n3 = carPlayCall.getStatus();
            int n4 = carPlayCall.getDirection();
            int n5 = carPlayCall.getMappedCallID();
            if (n3 != 3 || n4 != 0) continue;
            if (n2 == -1) {
                n = 0;
                n2 = n5;
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

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.isAcceptCallStarted) {
            this.isAcceptCallStarted = false;
            this.sendAcceptCallResult(methodListener, 2);
        } else {
            methodListener.requestError(80, this);
        }
    }

    private void sendAcceptCallResult(MethodListener methodListener, int n) {
        AcceptCall_Result acceptCall_Result = this.dequeueBAPEntity();
        acceptCall_Result.acceptCall_Result = n;
        methodListener.result(acceptCall_Result, this);
    }

    @Override
    public void updateCarPlayData(CarPlayService carPlayService, int n) {
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

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        CAR_PLAY_LISTENER_HMI_EVENT_IDS = new int[0];
    }
}

