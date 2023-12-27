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
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.HangupCall_Result;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.HangupCall_StartResult;
import java.util.Iterator;

public class HangupCallCarPlay
extends Function
implements TimerNotifier,
Method,
CarPlayServiceListener {
    private boolean hangUpStarted = false;
    private int hangUpCallID = -1;
    private static final int INVALID_INDEX;
    protected static final int[] CAR_PLAY_LISTENER_HMI_EVENT_IDS;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_TIME_OUT_ACTION_FAILED;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$HangupCall_Result;

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
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getCarPlayService().addCarPlayServiceListener(this, CAR_PLAY_LISTENER_HMI_EVENT_IDS);
        this.timer = this.getTimerService().createTimer(this, 20000);
        return null;
    }

    @Override
    public void process(int n) {
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 22: {
                this.setCurrentCallState();
                break;
            }
        }
    }

    @Override
    public void initialize(boolean bl) {
        this.hangUpStarted = false;
        this.hangUpCallID = -1;
    }

    @Override
    public void uninitialize() {
        if (this.hangUpStarted) {
            this.sendHangupCallResult(1);
        }
        this.timer.stop();
        this.getCarPlayService().removeCarPlayServiceListener(this, CAR_PLAY_LISTENER_HMI_EVENT_IDS);
    }

    @Override
    public int getFunctionId() {
        return 29;
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.getLogger().isTraceEnabled(32)) {
            this.getLogger().trace(32).append("CarPlay HangupCall: StartResult ").append(((Object)bAPEntity).toString()).log();
        }
        CarPlayService carPlayService = this.getCarPlayService();
        boolean bl = false;
        int n = -1;
        HangupCall_StartResult hangupCall_StartResult = (HangupCall_StartResult)bAPEntity;
        switch (hangupCall_StartResult.callId) {
            case 252: 
            case 253: 
            case 254: 
            case 255: {
                Iterator iterator = carPlayService.getCarPlayCalls();
                while (iterator.hasNext()) {
                    CarPlayCall carPlayCall = (CarPlayCall)iterator.next();
                    int n2 = carPlayCall.getStatus();
                    if (n2 != 1) continue;
                    bl = true;
                    n = carPlayCall.getMappedCallID();
                    carPlayService.hangUpCall(carPlayCall);
                }
                if (bl) break;
                this.sendHangupCallResult(1);
                break;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                int n3 = hangupCall_StartResult.callId;
                Iterator iterator = carPlayService.getCarPlayCalls();
                while (iterator.hasNext()) {
                    CarPlayCall carPlayCall = (CarPlayCall)iterator.next();
                    if (carPlayCall.getMappedCallID() != n3) continue;
                    int n4 = carPlayCall.getStatus();
                    if (n4 != 1 && n4 != 3) break;
                    bl = true;
                    n = carPlayCall.getMappedCallID();
                    carPlayService.hangUpCall(carPlayCall);
                    break;
                }
                if (bl) break;
                this.sendHangupCallResult(1);
                break;
            }
            default: {
                methodListener.requestError(65, this);
            }
        }
        if (bl) {
            if (this.getLogger().isTraceEnabled(32)) {
                this.getLogger().trace(32).append("CarPlay HangupCall: Timer started fo Hangup CallID is ").append(n).log();
            }
            this.hangUpStarted = true;
            this.hangUpCallID = n;
            this.timer.retrigger(new Integer(0));
        }
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.hangUpStarted) {
            this.hangUpStarted = false;
            this.sendHangupCallResult(2);
        }
    }

    @Override
    public void updateCarPlayData(CarPlayService carPlayService, int n) {
    }

    private void setCurrentCallState() {
        if (this.hangUpStarted) {
            Iterator iterator = this.getCarPlayService().getCarPlayCalls();
            int n = -1;
            while (iterator.hasNext()) {
                CarPlayCall carPlayCall = (CarPlayCall)iterator.next();
                if (this.hangUpCallID != carPlayCall.getMappedCallID()) continue;
                n = carPlayCall.getStatus();
            }
            if (n == -1 || n == 0) {
                this.hangUpStarted = false;
                this.sendHangupCallResult(0);
            }
        }
    }

    private void sendHangupCallResult(int n) {
        this.hangUpStarted = false;
        this.timer.stop();
        HangupCall_Result hangupCall_Result = this.dequeueBAPEntity();
        hangupCall_Result.hangupCall_Result = n;
        this.getDelegate().getMethodListener(this).result(hangupCall_Result, this);
        if (this.getLogger().isTraceEnabled(32)) {
            this.getLogger().trace(32).append("CarPlay HangupCall: resultcode is  ").append(n).log();
        }
    }

    protected HangupCall_Result dequeueBAPEntity() {
        return (HangupCall_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$HangupCall_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$HangupCall_Result = HangupCallCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.HangupCall_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$HangupCall_Result);
    }

    @Override
    public void timerFired(Timer timer) {
        this.callHangUpFailed();
    }

    protected void callHangUpFailed() {
        if (this.hangUpStarted) {
            this.hangUpStarted = false;
            this.sendHangupCallResult(1);
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

