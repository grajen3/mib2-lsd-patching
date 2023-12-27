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
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CCJoin_Result;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallState_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import java.util.Iterator;

public final class CCJoin
extends Function
implements TimerNotifier,
Method,
ASLTelephoneConstants,
PhoneServiceListener {
    private boolean isExecuting = false;
    private int[] callIdsToProcess = null;
    private static final int INVALID_INDEX;
    private static final int INDEX_FIRST_CALLID;
    private static final int INDEX_SECOND_CALLID;
    private static final int INDEX_FIRST_CALL_INDEX;
    private static final int INDEX_SECOND_CALL_INDEX;
    private static final int INDEX_COUNT;
    private static final int CALL_ID_CONFERENCE;
    private static final int MAXIMUM_NUMBER_OF_CONFERENCE_CALLS;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_TIME_OUT_ACTION_FAILED;
    protected static final int[] PHONE_LISTENER_HMI_EVENT_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CCJoin_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
        this.timer = this.getTimerService().createTimer(this, 20000);
        return null;
    }

    protected CCJoin_Result dequeueBAPEntity() {
        return (CCJoin_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CCJoin_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CCJoin_Result = CCJoin.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.CCJoin_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CCJoin_Result);
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
        return 40;
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
            PhoneService phoneService = this.getPhoneService();
            int[] nArray = this.findCallIDsForStates(5, 7);
            Iterator iterator = phoneService.getConferenceCallInformations();
            int n = 0;
            while (iterator.hasNext()) {
                iterator.next();
                ++n;
            }
            if (n >= 6) {
                this.sendResult(7);
            } else if (nArray[0] == -1) {
                methodListener.requestError(149, this);
            } else if (nArray[1] == -1) {
                methodListener.requestError(150, this);
            } else {
                phoneService.joinCallToConference(nArray[3]);
                this.callIdsToProcess = nArray;
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
        Iterator iterator;
        PhoneService phoneService = this.getPhoneService();
        int[] nArray = new int[4];
        nArray[0] = -1;
        nArray[1] = -1;
        Iterator iterator2 = phoneService.getCallInformations();
        int n3 = 0;
        while (iterator2.hasNext()) {
            PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator2.next();
            int n4 = phoneCallInformationElement.getCallState();
            int n5 = phoneCallInformationElement.getCallID();
            if (n4 == n) {
                nArray[0] = n5;
                nArray[2] = n3;
            } else if (n4 == n2) {
                nArray[1] = n5;
                nArray[3] = n3;
            }
            ++n3;
        }
        int n6 = -1;
        if (nArray[0] == 254) {
            n6 = 0;
        } else if (nArray[1] == 254) {
            n6 = 1;
        }
        if (n6 != -1 && (iterator = phoneService.getConferenceCallInformations()).hasNext()) {
            nArray[n6] = ((PhoneConferenceCallInformationsElement)iterator.next()).getConferenceCallId();
        }
        return nArray;
    }

    private boolean findExistenceOfConferenceCallIDs(int n, int n2) {
        int[] nArray = new int[4];
        nArray[0] = -1;
        nArray[1] = -1;
        Iterator iterator = this.getPhoneService().getConferenceCallInformations();
        while (iterator.hasNext()) {
            PhoneConferenceCallInformationsElement phoneConferenceCallInformationsElement = (PhoneConferenceCallInformationsElement)iterator.next();
            int n3 = phoneConferenceCallInformationsElement.getConferenceCallId();
            if (n3 == n) {
                nArray[0] = 5;
                continue;
            }
            if (n3 != n2) continue;
            nArray[1] = 5;
        }
        return nArray[0] != -1 && nArray[1] != -1;
    }

    private void sendResult(int n) {
        CCJoin_Result cCJoin_Result = this.dequeueBAPEntity();
        cCJoin_Result.ccjoin_Result = n;
        this.getDelegate().getMethodListener(this).result(cCJoin_Result, this);
    }

    private void sendResult(MethodListener methodListener, int n) {
        CCJoin_Result cCJoin_Result = this.dequeueBAPEntity();
        cCJoin_Result.ccjoin_Result = n;
        methodListener.result(cCJoin_Result, this);
    }

    protected void setCurrentCallState(CallState_Status callState_Status) {
        if (this.isExecuting) {
            if (this.findExistenceOfConferenceCallIDs(this.callIdsToProcess[0], this.callIdsToProcess[1])) {
                this.sendResult(0);
                this.isExecuting = false;
            } else {
                this.sendResult(1);
                this.isExecuting = false;
            }
        }
    }

    @Override
    public void timerFired(Timer timer) {
        this.callJoinFailed();
    }

    protected void callJoinFailed() {
        if (this.isExecuting) {
            this.isExecuting = false;
            this.sendResult(1);
        }
    }

    @Override
    public void processHMIEvent(int n) {
        switch (n) {
            case 468: {
                this.callJoinFailed();
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
        PHONE_LISTENER_HMI_EVENT_IDS = new int[]{468};
    }
}

