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
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.elements.PhoneConferenceCallInformationsElement;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CCSplit_Result;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CCSplit_StartResult;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import java.util.Iterator;

public final class CCSplit
extends Function
implements TimerNotifier,
Method,
ASLTelephoneConstants,
PhoneServiceListener {
    private boolean isExecuting = false;
    private int[] callIdsAndStatesExpected = null;
    private static final int CALL_ID_OFFSET;
    private static final int INVALID_INDEX;
    private static final int INDEX_FIRST_CALLID;
    private static final int INDEX_FIRST_CALL_STATE;
    private static final int INDEX_FIRST_CALL_INDEX;
    private static final int INDEX_SECOND_CALLID;
    private static final int INDEX_THIRD_CALLID;
    private static final int INDEX_COUNT;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_TIME_OUT_ACTION_FAILED;
    protected static final int[] PHONE_LISTENER_HMI_EVENT_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CCSplit_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
        this.timer = this.getTimerService().createTimer(this, 20000);
        return null;
    }

    protected CCSplit_Result dequeueBAPEntity() {
        return (CCSplit_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CCSplit_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CCSplit_Result = CCSplit.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.CCSplit_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CCSplit_Result);
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
        return 41;
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
        CCSplit_StartResult cCSplit_StartResult = (CCSplit_StartResult)bAPEntity;
        if (!CCSplit.inputParametersValid(cCSplit_StartResult)) {
            methodListener.requestError(65, this);
        } else if (!this.isExecuting) {
            int[] nArray = this.findCallIdStateForConferenceCall();
            if (nArray[1] != -1) {
                int[] nArray2 = this.findCallIDsForStates(5, 7, 4, 1, 6);
                int n = cCSplit_StartResult.callId + 1;
                nArray[2] = this.existsCallIdInConferenceList(n);
                if (nArray[2] == -1) {
                    methodListener.requestError(155, this);
                } else if (nArray2[0] != -1 || nArray2[3] != -1) {
                    methodListener.requestError(144, this);
                } else if (nArray2[1] != -1) {
                    methodListener.requestError(145, this);
                } else if (nArray[1] == 5 && nArray2[1] == -1 || nArray[1] == 7 && nArray2[0] == -1) {
                    this.getPhoneService().splitCallFromConference(nArray[2]);
                    this.callIdsAndStatesExpected = new int[4];
                    this.callIdsAndStatesExpected[0] = n;
                    this.callIdsAndStatesExpected[1] = 5;
                    this.isExecuting = true;
                    this.timer.setUserInfo(new Integer(0));
                } else {
                    this.sendResult(1);
                }
            } else {
                methodListener.requestError(154, this);
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

    private static boolean inputParametersValid(CCSplit_StartResult cCSplit_StartResult) {
        boolean bl;
        switch (cCSplit_StartResult.callId) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    private int[] findCallIDsForStates(int n, int n2, int n3, int n4, int n5) {
        int[] nArray = new int[4];
        nArray[0] = -1;
        nArray[1] = -1;
        nArray[3] = -1;
        Iterator iterator = this.getPhoneService().getCallInformations();
        while (iterator.hasNext()) {
            PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
            int n6 = phoneCallInformationElement.getCallState();
            int n7 = phoneCallInformationElement.getCallID();
            int n8 = phoneCallInformationElement.getCallType();
            if (n6 == n && n8 != n5) {
                nArray[0] = n7;
                continue;
            }
            if ((n6 == n2 || n6 == n3) && n8 != n5) {
                nArray[1] = n7;
                continue;
            }
            if (n6 != n4 || n8 == n5) continue;
            nArray[3] = n7;
        }
        return nArray;
    }

    private int[] findCallIdStateForConferenceCall() {
        int[] nArray = new int[4];
        nArray[0] = -1;
        nArray[2] = -1;
        nArray[1] = -1;
        Iterator iterator = this.getPhoneService().getCallInformations();
        int n = 0;
        while (iterator.hasNext()) {
            PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
            if (phoneCallInformationElement.getCallType() == 6) {
                nArray[0] = phoneCallInformationElement.getCallID();
                nArray[2] = n;
                nArray[1] = phoneCallInformationElement.getCallState();
                break;
            }
            ++n;
        }
        return nArray;
    }

    private int existsCallIdInConferenceList(int n) {
        Iterator iterator = this.getPhoneService().getConferenceCallInformations();
        int n2 = 0;
        while (iterator.hasNext()) {
            PhoneConferenceCallInformationsElement phoneConferenceCallInformationsElement = (PhoneConferenceCallInformationsElement)iterator.next();
            if (phoneConferenceCallInformationsElement.getConferenceCallId() == n) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    private void sendResult(int n) {
        CCSplit_Result cCSplit_Result = this.dequeueBAPEntity();
        cCSplit_Result.ccsplit_Result = n;
        this.getDelegate().getMethodListener(this).result(cCSplit_Result, this);
    }

    private void sendResult(MethodListener methodListener, int n) {
        CCSplit_Result cCSplit_Result = this.dequeueBAPEntity();
        cCSplit_Result.ccsplit_Result = n;
        methodListener.result(cCSplit_Result, this);
    }

    private int findCallStateForCallID(int n) {
        int n2 = -1;
        Iterator iterator = this.getPhoneService().getCallInformations();
        while (iterator.hasNext()) {
            PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
            int n3 = phoneCallInformationElement.getCallState();
            int n4 = phoneCallInformationElement.getCallID();
            if (n != n4) continue;
            n2 = n3;
        }
        return n2;
    }

    protected void setCurrentCallState(CallState_Status callState_Status) {
        if (this.isExecuting) {
            int n = this.findCallStateForCallID(this.callIdsAndStatesExpected[0]);
            if (n == 0 || n == 6 || n == -1) {
                this.sendResult(1);
                this.isExecuting = false;
            } else if (n == this.callIdsAndStatesExpected[1]) {
                this.sendResult(0);
            }
        }
    }

    @Override
    public void timerFired(Timer timer) {
        this.callSplitFailed();
    }

    protected void callSplitFailed() {
        if (this.isExecuting) {
            this.isExecuting = false;
            this.sendResult(1);
        }
    }

    @Override
    public void processHMIEvent(int n) {
        switch (n) {
            case 465: {
                this.callSplitFailed();
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
        PHONE_LISTENER_HMI_EVENT_IDS = new int[]{465};
    }
}

