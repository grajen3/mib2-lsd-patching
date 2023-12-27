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
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.ResumeCall_Result;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import java.util.Iterator;

public final class ResumeCall
extends Function
implements TimerNotifier,
Method,
ASLTelephoneConstants,
PhoneServiceListener {
    private boolean resumeRunning = false;
    private int callIDToResume = -1;
    private static final int INDEX_FIRST_CALLID;
    private static final int INDEX_FIRST_CALL_INDEX;
    private static final int INDEX_FIRST_CALL_STATE;
    private static final int CALL_ID_INVALID;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_TIME_OUT_ACTION_FAILED;
    protected static final int[] PHONE_LISTENER_HMI_EVENT_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$ResumeCall_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
        this.timer = this.getTimerService().createTimer(this, 20000);
        return null;
    }

    protected ResumeCall_Result dequeueBAPEntity() {
        return (ResumeCall_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$ResumeCall_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$ResumeCall_Result = ResumeCall.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.ResumeCall_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$ResumeCall_Result);
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
        return 32;
    }

    @Override
    public void process(int n) {
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.resumeRunning) {
            this.resumeRunning = false;
            this.sendResultCode(methodListener, 2);
        } else {
            methodListener.requestError(80, this);
        }
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (!this.resumeRunning) {
            int[] nArray = this.checkResumeCallPreconditions(methodListener);
            if (nArray[0] != -1) {
                this.callIDToResume = nArray[0];
                this.resumeRunning = true;
                if (nArray[2] == 4) {
                    this.getPhoneService().acceptResponseAndHoldCall(nArray[1]);
                } else {
                    this.getPhoneService().resumeCall(nArray[1]);
                }
                this.timer.retrigger(new Integer(0));
            }
        } else {
            this.sendResultCode(1);
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
        this.callIDToResume = -1;
        this.resumeRunning = false;
    }

    @Override
    public void uninitialize() {
        this.timer.stop();
        this.getPhoneService().removeHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
    }

    protected void setCurrentCallState(CallState_Status callState_Status) {
        if (this.resumeRunning) {
            Iterator iterator = this.getPhoneService().getCallInformations();
            while (iterator.hasNext()) {
                PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
                int n = phoneCallInformationElement.getCallID();
                int n2 = phoneCallInformationElement.getCallState();
                if (this.callIDToResume != n) continue;
                switch (n2) {
                    case 5: {
                        this.sendResultCode(0);
                        this.callIDToResume = -1;
                        this.resumeRunning = false;
                        break;
                    }
                    case 4: 
                    case 7: {
                        break;
                    }
                    case 1: 
                    case 2: 
                    case 3: 
                    case 6: {
                        this.sendResultCode(1);
                        this.callIDToResume = -1;
                        this.resumeRunning = false;
                        break;
                    }
                    case 0: {
                        this.sendResultCode(1);
                        this.callIDToResume = -1;
                        this.resumeRunning = false;
                        break;
                    }
                }
                break;
            }
        }
    }

    private void sendResultCode(int n) {
        ResumeCall_Result resumeCall_Result = this.dequeueBAPEntity();
        resumeCall_Result.resumeCall_Result = n;
        this.getDelegate().getMethodListener(this).result(resumeCall_Result, this);
    }

    private void sendResultCode(MethodListener methodListener, int n) {
        ResumeCall_Result resumeCall_Result = this.dequeueBAPEntity();
        resumeCall_Result.resumeCall_Result = n;
        methodListener.result(resumeCall_Result, this);
    }

    private int[] checkResumeCallPreconditions(MethodListener methodListener) {
        int[] nArray = new int[]{-1, -1, -1};
        Iterator iterator = this.getPhoneService().getCallInformations();
        boolean bl = false;
        int n = -1;
        while (iterator.hasNext()) {
            PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
            int n2 = phoneCallInformationElement.getCallID();
            int n3 = phoneCallInformationElement.getCallState();
            ++n;
            switch (n3) {
                case 1: 
                case 2: 
                case 5: {
                    methodListener.requestError(144, this);
                    nArray = new int[]{-1, -1, -1};
                    bl = true;
                    break;
                }
                case 4: 
                case 7: {
                    nArray[0] = n2;
                    nArray[1] = n;
                    nArray[2] = n3;
                    break;
                }
            }
            if (!bl) continue;
            break;
        }
        if (nArray[0] == -1 && !bl) {
            methodListener.requestError(150, this);
        }
        return nArray;
    }

    @Override
    public void timerFired(Timer timer) {
        this.callHoldFailed();
    }

    protected void callHoldFailed() {
        if (this.resumeRunning) {
            this.callIDToResume = -1;
            this.resumeRunning = false;
            this.sendResultCode(1);
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

