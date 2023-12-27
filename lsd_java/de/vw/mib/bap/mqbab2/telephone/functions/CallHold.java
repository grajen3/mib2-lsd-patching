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
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallHold_Result;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import java.util.Iterator;

public final class CallHold
extends Function
implements TimerNotifier,
Method,
ASLTelephoneConstants,
PhoneServiceListener {
    private boolean holdRunning = false;
    private int callIDToHold = -1;
    private static final int CALL_ID_INVALID;
    private static final int INDEX_FIRST_CALLID;
    private static final int INDEX_FIRST_CALL_INDEX;
    private static final int INDEX_FIRST_CALL_STATE;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_TIME_OUT_ACTION_FAILED;
    protected static final int[] PHONE_LISTENER_HMI_EVENT_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallHold_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
        this.timer = this.getTimerService().createTimer(this, 20000);
        return null;
    }

    protected CallHold_Result dequeueBAPEntity() {
        return (CallHold_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallHold_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallHold_Result = CallHold.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallHold_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallHold_Result);
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
        return 31;
    }

    @Override
    public void process(int n) {
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.holdRunning) {
            this.holdRunning = false;
            this.sendResultCode(methodListener, 2);
        } else {
            methodListener.requestError(80, this);
        }
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (!this.holdRunning) {
            int[] nArray = this.checkCallHoldPreconditions(methodListener);
            if (nArray[0] != -1) {
                this.callIDToHold = nArray[0];
                this.holdRunning = true;
                if (nArray[2] == 3) {
                    this.getPhoneService().setCallStateToResponseAndHold(nArray[1]);
                } else {
                    this.getPhoneService().setCallStateToHold(nArray[1]);
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
        this.holdRunning = false;
        this.callIDToHold = -1;
    }

    @Override
    public void uninitialize() {
        this.timer.stop();
        this.getPhoneService().removeHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
    }

    protected void setCurrentCallState(CallState_Status callState_Status) {
        if (this.holdRunning) {
            Iterator iterator = this.getPhoneService().getCallInformations();
            while (iterator.hasNext()) {
                PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
                int n = phoneCallInformationElement.getCallID();
                int n2 = phoneCallInformationElement.getCallState();
                if (this.callIDToHold != n) continue;
                switch (n2) {
                    case 5: {
                        break;
                    }
                    case 4: 
                    case 7: {
                        this.sendResultCode(0);
                        this.callIDToHold = -1;
                        this.holdRunning = false;
                        break;
                    }
                    case 1: 
                    case 2: 
                    case 3: 
                    case 6: {
                        this.sendResultCode(1);
                        this.callIDToHold = -1;
                        this.holdRunning = false;
                        break;
                    }
                    case 0: {
                        this.sendResultCode(1);
                        this.callIDToHold = -1;
                        this.holdRunning = false;
                        break;
                    }
                }
                break;
            }
        }
    }

    private void sendResultCode(int n) {
        CallHold_Result callHold_Result = this.dequeueBAPEntity();
        callHold_Result.callHold_Result = n;
        this.getDelegate().getMethodListener(this).result(callHold_Result, this);
    }

    private void sendResultCode(MethodListener methodListener, int n) {
        CallHold_Result callHold_Result = this.dequeueBAPEntity();
        callHold_Result.callHold_Result = n;
        methodListener.result(callHold_Result, this);
    }

    private int[] checkCallHoldPreconditions(MethodListener methodListener) {
        PhoneService phoneService = this.getPhoneService();
        int[] nArray = new int[]{-1, -1, -1};
        Iterator iterator = phoneService.getCallInformations();
        int n = phoneService.getTelephoneFeatures();
        boolean bl = (n & 4) == 4;
        boolean bl2 = false;
        int n2 = -1;
        while (iterator.hasNext()) {
            PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
            int n3 = phoneCallInformationElement.getCallID();
            int n4 = phoneCallInformationElement.getCallState();
            ++n2;
            switch (n4) {
                case 5: {
                    nArray[0] = n3;
                    nArray[1] = n2;
                    nArray[2] = n4;
                    break;
                }
                case 4: 
                case 7: {
                    methodListener.requestError(145, this);
                    nArray = new int[]{-1, -1, -1};
                    bl2 = true;
                    break;
                }
                case 3: {
                    if (!bl) break;
                    nArray[0] = n3;
                    nArray[1] = n2;
                    nArray[2] = n4;
                    bl2 = true;
                    break;
                }
            }
            if (!bl2) continue;
            break;
        }
        if (nArray[0] == -1 && !bl2) {
            methodListener.requestError(149, this);
        }
        return nArray;
    }

    @Override
    public void timerFired(Timer timer) {
        this.callHoldFailed();
    }

    protected void callHoldFailed() {
        if (this.holdRunning) {
            this.holdRunning = false;
            this.callIDToHold = -1;
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

