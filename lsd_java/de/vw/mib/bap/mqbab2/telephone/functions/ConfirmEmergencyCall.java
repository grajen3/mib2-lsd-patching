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
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.ConfirmEmergencyCall_Result;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.ConfirmEmergencyCall_StartResult;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class ConfirmEmergencyCall
extends Function
implements TimerNotifier,
Method,
ASLTelephoneConstants,
PhoneServiceListener {
    private boolean methodRunning = false;
    private boolean eCallConfirmationPending = false;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_TIME_OUT_ACTION_FAILED;
    protected static final int[] PHONE_LISTENER_HMI_EVENT_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$ConfirmEmergencyCall_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
        this.timer = this.getTimerService().createTimer(this, 20000);
        return null;
    }

    protected ConfirmEmergencyCall_Result dequeueBAPEntity() {
        return (ConfirmEmergencyCall_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$ConfirmEmergencyCall_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$ConfirmEmergencyCall_Result = ConfirmEmergencyCall.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.ConfirmEmergencyCall_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$ConfirmEmergencyCall_Result);
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
        return 28;
    }

    @Override
    public void process(int n) {
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.methodRunning) {
            this.methodRunning = false;
            this.sendResult(methodListener, 2);
        } else {
            methodListener.requestError(80, this);
        }
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        ConfirmEmergencyCall_StartResult confirmEmergencyCall_StartResult = (ConfirmEmergencyCall_StartResult)bAPEntity;
        if (confirmEmergencyCall_StartResult.control != 0 && confirmEmergencyCall_StartResult.control != 1) {
            methodListener.requestError(65, this);
        } else if (!this.methodRunning) {
            if (this.eCallConfirmationPending) {
                PhoneService phoneService = this.getPhoneService();
                if (confirmEmergencyCall_StartResult.control == 0) {
                    phoneService.startEmergencyCall();
                    this.methodRunning = true;
                } else if (confirmEmergencyCall_StartResult.control == 1) {
                    phoneService.abortEmergencyCall();
                    this.methodRunning = true;
                } else {
                    methodListener.requestError(65, this);
                }
                if (this.methodRunning) {
                    this.timer.retrigger(new Integer(0));
                }
            } else {
                this.sendResult(4);
            }
        } else {
            this.sendResult(1);
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
        this.eCallConfirmationPending = false;
        this.methodRunning = false;
    }

    @Override
    public void uninitialize() {
        this.timer.stop();
        this.getPhoneService().removeHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
    }

    protected void emergencyCallConfirmationCloseDialog() {
        this.eCallConfirmationPending = false;
    }

    protected void emergencyCallConfirmationRequired() {
        this.eCallConfirmationPending = true;
    }

    protected void setCurrentCallState(CallState_Status callState_Status) {
        this.eCallConfirmationPending = callState_Status.callOutgoingDiverted_eCallConfirmationPending.eCallConfirmationPending;
        if (this.methodRunning && !this.eCallConfirmationPending) {
            this.sendResult(0);
            this.methodRunning = false;
        }
    }

    private void sendResult(int n) {
        ConfirmEmergencyCall_Result confirmEmergencyCall_Result = this.dequeueBAPEntity();
        confirmEmergencyCall_Result.confirmErmergencyCall_Result = n;
        this.getDelegate().getMethodListener(this).result(confirmEmergencyCall_Result, this);
    }

    private void sendResult(MethodListener methodListener, int n) {
        ConfirmEmergencyCall_Result confirmEmergencyCall_Result = this.dequeueBAPEntity();
        confirmEmergencyCall_Result.confirmErmergencyCall_Result = n;
        methodListener.result(confirmEmergencyCall_Result, this);
    }

    @Override
    public void timerFired(Timer timer) {
        this.confirmEmergencyCallFailed();
    }

    private void confirmEmergencyCallFailed() {
        if (this.methodRunning) {
            this.methodRunning = false;
            this.sendResult(1);
        }
    }

    protected void callHangUpFailed() {
        this.confirmEmergencyCallFailed();
    }

    protected void callDialingFailed() {
        this.confirmEmergencyCallFailed();
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
            case 464: {
                this.callHangUpFailed();
                break;
            }
            case 163: {
                this.callDialingFailed();
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
        PHONE_LISTENER_HMI_EVENT_IDS = new int[]{164, 165, 464, 163};
    }
}

