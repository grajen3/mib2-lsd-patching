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
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.DialService_Result;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.DialService_StartResult;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import java.util.Iterator;

public final class DialService
extends Function
implements TimerNotifier,
Method,
ASLTelephoneConstants,
PhoneServiceListener {
    private static final int NOT_FOUND_CALL_IDENTIFIER;
    private static final int NO_ENTRYID;
    private boolean dialServiceRunning = false;
    private boolean eCallConfirmationPending = false;
    private String lastDialedServiceNumber = null;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_TIME_OUT_ACTION_FAILED;
    protected static final int[] PHONE_LISTENER_HMI_EVENT_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DialService_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
        this.timer = this.getTimerService().createTimer(this, 20000);
        return null;
    }

    protected DialService_Result dequeueBAPEntity() {
        return (DialService_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DialService_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DialService_Result = DialService.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.DialService_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DialService_Result);
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
        return 27;
    }

    @Override
    public void process(int n) {
    }

    private void sendResult(int n) {
        DialService_Result dialService_Result = this.dequeueBAPEntity();
        dialService_Result.dialService_Result = n;
        this.getDelegate().getMethodListener(this).result(dialService_Result, this);
    }

    private void sendResult(MethodListener methodListener, int n) {
        DialService_Result dialService_Result = this.dequeueBAPEntity();
        dialService_Result.dialService_Result = n;
        methodListener.result(dialService_Result, this);
    }

    private boolean isDialServicePossible(MethodListener methodListener) {
        boolean bl;
        PhoneService phoneService = this.getPhoneService();
        if (!this.dialServiceRunning) {
            if (phoneService.getCurrentPhoneProfile() == 0) {
                this.sendResult(5);
                bl = false;
            } else if (phoneService.getNetworkState() == 5) {
                methodListener.requestError(139, this);
                bl = false;
            } else if (this.eCallConfirmationPending) {
                this.sendResult(10);
                bl = false;
            } else if (phoneService.isPhoneLineFree()) {
                bl = true;
            } else {
                methodListener.requestError(144, this);
                bl = false;
            }
        } else {
            methodListener.requestError(144, this);
            bl = false;
        }
        return bl;
    }

    private void performDialingService(MethodListener methodListener, String string, boolean bl) {
        if (this.isDialServicePossible(methodListener)) {
            this.lastDialedServiceNumber = string;
            this.dialServiceRunning = true;
            PhoneService phoneService = this.getPhoneService();
            if (bl) {
                phoneService.startEmergencyCall();
            } else {
                phoneService.startCall(0L, string);
            }
            this.timer.retrigger(new Integer(0));
        }
    }

    private int findCallIdentifierForTelephoneNumber(String string) {
        int n = -1;
        if (string != null) {
            Iterator iterator = this.getPhoneService().getCallInformations();
            int n2 = 0;
            while (iterator.hasNext()) {
                PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
                if (phoneCallInformationElement.getCallNumber().compareTo(string) == 0) {
                    n = n2;
                    break;
                }
                ++n2;
            }
        }
        return n;
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (!this.dialServiceRunning) {
            methodListener.requestError(80, this);
        } else {
            int n;
            int n2 = this.findCallIdentifierForTelephoneNumber(this.lastDialedServiceNumber);
            if (n2 != -1) {
                n = 3;
            } else {
                this.getPhoneService().hangUpCall(n2);
                n = 2;
            }
            this.dialServiceRunning = false;
            this.sendResult(methodListener, n);
        }
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        String string;
        DialService_StartResult dialService_StartResult = (DialService_StartResult)bAPEntity;
        boolean bl = false;
        PhoneService phoneService = this.getPhoneService();
        switch (dialService_StartResult.serviceType) {
            case 3: {
                string = phoneService.getEmergencyCallNumber();
                bl = true;
                break;
            }
            case 1: {
                string = phoneService.getInfoCallNumber();
                break;
            }
            case 2: {
                string = phoneService.getServiceCallNumber();
                break;
            }
            case 0: {
                string = phoneService.getMailboxCallNumber();
                break;
            }
            default: {
                string = null;
            }
        }
        if (string != null && string.length() != 0) {
            this.performDialingService(methodListener, string, bl);
        } else {
            methodListener.requestError(65, this);
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
        this.dialServiceRunning = false;
        this.eCallConfirmationPending = false;
    }

    @Override
    public void uninitialize() {
        this.timer.stop();
        this.getPhoneService().removeHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
    }

    protected void setCurrentCallState(CallState_Status callState_Status) {
        if (this.dialServiceRunning) {
            if (callState_Status.callOutgoingDiverted_eCallConfirmationPending.eCallConfirmationPending) {
                this.dialServiceRunning = false;
                this.sendResult(10);
            } else {
                int n = this.findCallIdentifierForTelephoneNumber(this.lastDialedServiceNumber);
                if (n != -1) {
                    this.dialServiceRunning = false;
                    this.sendResult(0);
                } else {
                    this.dialServiceRunning = false;
                    this.sendResult(1);
                }
            }
        }
        this.eCallConfirmationPending = callState_Status.callOutgoingDiverted_eCallConfirmationPending.eCallConfirmationPending;
    }

    @Override
    public void timerFired(Timer timer) {
        this.callDialingFailed();
    }

    protected void callDialingFailed() {
        if (this.dialServiceRunning) {
            this.dialServiceRunning = false;
            this.sendResult(1);
        }
    }

    @Override
    public void processHMIEvent(int n) {
        switch (n) {
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
        PHONE_LISTENER_HMI_EVENT_IDS = new int[]{163};
    }
}

