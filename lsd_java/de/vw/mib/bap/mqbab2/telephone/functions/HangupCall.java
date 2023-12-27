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
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.HangupCall_Result;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.HangupCall_StartResult;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import java.util.Iterator;

public final class HangupCall
extends Function
implements TimerNotifier,
Method,
ASLTelephoneConstants,
PhoneServiceListener {
    private boolean hangUpStarted = false;
    private int hangUpCallID = -1;
    private static final int CALL_ID_SEVEN;
    private static final int INVALID_INDEX;
    private static final int CALL_ID_OFFSET;
    private static final int UTILITY_CALL_ID;
    private static final int UTILITY_CALL_INDEX;
    private static final int UTILITY_COUNT;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_TIME_OUT_ACTION_FAILED;
    protected static final int[] PHONE_LISTENER_HMI_EVENT_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$HangupCall_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
        this.timer = this.getTimerService().createTimer(this, 20000);
        return null;
    }

    protected HangupCall_Result dequeueBAPEntity() {
        return (HangupCall_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$HangupCall_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$HangupCall_Result = HangupCall.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.HangupCall_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$HangupCall_Result);
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
        return 29;
    }

    private int[][] isHangUpPossible(MethodListener methodListener, int n) {
        if (!this.hangUpStarted) {
            int n2;
            int[][] nArray = new int[8][2];
            boolean bl = false;
            Iterator iterator = this.getPhoneService().getCallInformations();
            int n3 = -1;
            while (iterator.hasNext()) {
                PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
                n2 = phoneCallInformationElement.getCallState();
                int n4 = phoneCallInformationElement.getCallID();
                ++n3;
                boolean bl2 = false;
                switch (n) {
                    case 252: {
                        if (n2 != 5) break;
                        bl2 = true;
                        break;
                    }
                    case 253: {
                        if (n2 != 7 && n2 != 4) break;
                        bl2 = true;
                        break;
                    }
                    case 254: {
                        if (n2 != 7 && n2 != 4 && n2 != 5) break;
                        bl2 = true;
                        break;
                    }
                    case 255: {
                        if (n2 == 0 || n2 == 6) break;
                        bl2 = true;
                        break;
                    }
                }
                if (bl2) {
                    bl = true;
                    nArray[n3][0] = n4;
                    nArray[n3][1] = n3;
                    continue;
                }
                nArray[n3][0] = -1;
                nArray[n3][1] = -1;
            }
            if (bl) {
                int n5 = nArray.length;
                for (n2 = n3; n2 < n5; ++n2) {
                    nArray[n2][0] = -1;
                    nArray[n2][1] = -1;
                }
                return nArray;
            }
        }
        methodListener.requestError(148, this);
        return null;
    }

    private int isHangUpPossible(int n, MethodListener methodListener) {
        if (!this.hangUpStarted) {
            Iterator iterator = this.getPhoneService().getCallInformations();
            int n2 = -1;
            while (iterator.hasNext()) {
                ++n2;
                PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
                if (phoneCallInformationElement.getCallID() != n) continue;
                int n3 = phoneCallInformationElement.getCallState();
                if (n3 != 0 && n3 != 6) {
                    return n2;
                }
                this.sendHangupCallResult(methodListener, 1);
                return -1;
            }
        }
        methodListener.requestError(148, this);
        return -1;
    }

    private int isHangUpPossibleForConference(int n, MethodListener methodListener) {
        if (!this.hangUpStarted) {
            Iterator iterator = this.getPhoneService().getConferenceCallInformations();
            int n2 = 0;
            while (iterator.hasNext()) {
                PhoneConferenceCallInformationsElement phoneConferenceCallInformationsElement = (PhoneConferenceCallInformationsElement)iterator.next();
                if (phoneConferenceCallInformationsElement.getConferenceCallId() == n) {
                    return n2;
                }
                ++n2;
            }
        }
        return -1;
    }

    private void hangupCallStartResult(HangupCall_StartResult hangupCall_StartResult, MethodListener methodListener) {
        PhoneService phoneService = this.getPhoneService();
        boolean bl = false;
        int n = -1;
        switch (hangupCall_StartResult.callId) {
            case 252: 
            case 253: 
            case 254: 
            case 255: {
                int[][] nArray = this.isHangUpPossible(methodListener, hangupCall_StartResult.callId);
                if (nArray == null) break;
                int n2 = nArray.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    int n3 = nArray[i2][0];
                    if (n3 == -1) continue;
                    int n4 = nArray[i2][1];
                    bl = true;
                    n = n3;
                    phoneService.hangUpCall(n4);
                }
                break;
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                int n5 = hangupCall_StartResult.callId + 1;
                int n6 = this.isHangUpPossibleForConference(n5, methodListener);
                if (n6 != -1) {
                    bl = true;
                    n = n5;
                    phoneService.removeCallFromConference(n6);
                    break;
                }
                n6 = this.isHangUpPossible(n5, methodListener);
                if (n6 == -1) break;
                bl = true;
                n = n5;
                phoneService.hangUpCall(n6);
                break;
            }
            default: {
                methodListener.requestError(65, this);
            }
        }
        if (bl) {
            this.hangUpStarted = true;
            this.hangUpCallID = n;
            this.timer.retrigger(new Integer(0));
        }
    }

    private void sendHangupCallResult(int n) {
        HangupCall_Result hangupCall_Result = this.dequeueBAPEntity();
        hangupCall_Result.hangupCall_Result = n;
        this.getDelegate().getMethodListener(this).result(hangupCall_Result, this);
    }

    private void sendHangupCallResult(MethodListener methodListener, int n) {
        HangupCall_Result hangupCall_Result = this.dequeueBAPEntity();
        hangupCall_Result.hangupCall_Result = n;
        methodListener.result(hangupCall_Result, this);
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.hangUpStarted) {
            this.hangUpStarted = false;
            this.sendHangupCallResult(2);
        } else {
            methodListener.requestError(80, this);
        }
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        this.hangupCallStartResult((HangupCall_StartResult)bAPEntity, methodListener);
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
        this.hangUpStarted = false;
        this.hangUpCallID = -1;
    }

    @Override
    public void uninitialize() {
        this.timer.stop();
        this.getPhoneService().removeHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
    }

    private int findCallStateForCallID(int n) {
        Object object;
        PhoneService phoneService = this.getPhoneService();
        int n2 = -1;
        Iterator iterator = phoneService.getCallInformations();
        while (iterator.hasNext()) {
            object = (PhoneCallInformationElement)iterator.next();
            if (object.getCallID() != n) continue;
            n2 = object.getCallState();
        }
        object = phoneService.getConferenceCallInformations();
        while (object.hasNext()) {
            PhoneConferenceCallInformationsElement phoneConferenceCallInformationsElement = (PhoneConferenceCallInformationsElement)object.next();
            if (phoneConferenceCallInformationsElement.getConferenceCallId() != n) continue;
            n2 = phoneConferenceCallInformationsElement.getConferenceCallState();
        }
        return n2;
    }

    public void setCurrentCallState(CallState_Status callState_Status) {
        if (this.hangUpStarted) {
            int n = this.findCallStateForCallID(this.hangUpCallID);
            if (n == -1) {
                this.hangUpStarted = false;
                this.sendHangupCallResult(1);
            } else if (n == 0 || n == 6) {
                this.hangUpStarted = false;
                this.sendHangupCallResult(0);
            }
        }
    }

    @Override
    public void process(int n) {
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

    @Override
    public void processHMIEvent(int n) {
        switch (n) {
            case 464: {
                this.callHangUpFailed();
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
        PHONE_LISTENER_HMI_EVENT_IDS = new int[]{464};
    }
}

