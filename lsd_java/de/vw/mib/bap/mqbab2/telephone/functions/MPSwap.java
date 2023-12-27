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
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.MPSwap_Result;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import java.util.Iterator;

public final class MPSwap
extends Function
implements TimerNotifier,
Method,
ASLTelephoneConstants,
PhoneServiceListener {
    private boolean isExecuting = false;
    private int[] callIdsToProcess = null;
    private int[] expectedCallState = null;
    private static final int INVALID_INDEX;
    private static final int INDEX_FIRST_CALLID;
    private static final int INDEX_SECOND_CALLID;
    private static final int INDEX_FIRST_CALL_INDEX;
    private static final int INDEX_SECOND_CALL_INDEX;
    private static final int INDEX_COUNT;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_TIME_OUT_ACTION_FAILED;
    protected static final int[] PHONE_LISTENER_HMI_EVENT_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPSwap_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
        this.timer = this.getTimerService().createTimer(this, 20000);
        return null;
    }

    protected MPSwap_Result dequeueBAPEntity() {
        return (MPSwap_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPSwap_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPSwap_Result = MPSwap.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.MPSwap_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$MPSwap_Result);
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
        return 36;
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
            int[] nArray = this.findCallIDsForStates(5, 7);
            if (nArray[0] == -1) {
                methodListener.requestError(149, this);
            } else if (nArray[1] == -1) {
                methodListener.requestError(150, this);
            } else {
                this.getPhoneService().setCallStateToHold(nArray[2]);
                this.callIdsToProcess = nArray;
                this.expectedCallState = new int[4];
                this.expectedCallState[0] = 7;
                this.expectedCallState[1] = 5;
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

    private int[] findCallIDsForStates(int n, int n2) {
        int[] nArray = new int[4];
        nArray[0] = -1;
        nArray[1] = -1;
        Iterator iterator = this.getPhoneService().getCallInformations();
        int n3 = 0;
        while (iterator.hasNext()) {
            PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
            if (phoneCallInformationElement.getCallState() == n) {
                nArray[0] = phoneCallInformationElement.getCallID();
                nArray[2] = n3;
            } else if (phoneCallInformationElement.getCallState() == n2) {
                nArray[1] = phoneCallInformationElement.getCallID();
                nArray[3] = n3;
            }
            ++n3;
        }
        return nArray;
    }

    private int[] findStatesForCallIDs(int n, int n2) {
        int[] nArray = new int[4];
        nArray[0] = -1;
        nArray[1] = -1;
        Iterator iterator = this.getPhoneService().getCallInformations();
        while (iterator.hasNext()) {
            PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
            if (phoneCallInformationElement.getCallID() == n) {
                nArray[0] = phoneCallInformationElement.getCallState();
                continue;
            }
            if (phoneCallInformationElement.getCallID() != n2) continue;
            nArray[1] = phoneCallInformationElement.getCallState();
        }
        return nArray;
    }

    private void sendResult(int n) {
        MPSwap_Result mPSwap_Result = this.dequeueBAPEntity();
        mPSwap_Result.mpswap_Result = n;
        this.getDelegate().getMethodListener(this).result(mPSwap_Result, this);
    }

    private void sendResult(MethodListener methodListener, int n) {
        MPSwap_Result mPSwap_Result = this.dequeueBAPEntity();
        mPSwap_Result.mpswap_Result = n;
        methodListener.result(mPSwap_Result, this);
    }

    protected void setCurrentCallState(CallState_Status callState_Status) {
        if (this.isExecuting) {
            int[] nArray = this.findStatesForCallIDs(this.callIdsToProcess[0], this.callIdsToProcess[1]);
            if (nArray[0] == this.expectedCallState[0] && nArray[1] == this.expectedCallState[1]) {
                this.sendResult(0);
                this.isExecuting = false;
            } else if (nArray[0] == -1 || nArray[1] == -1 || nArray[0] == 0 || nArray[1] == 0) {
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

