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
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.DialNumber_Result;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.DialNumber_StartResult;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import java.util.Iterator;

public final class DialNumber
extends Function
implements TimerNotifier,
Method,
ASLTelephoneConstants,
PhoneServiceListener {
    private static final int NOT_FOUND_INDEX;
    private static final int NO_ENTRYID;
    private boolean dialingStarted = false;
    private boolean selectNumberInProgress = false;
    private boolean eCallConfirmationPending = false;
    private boolean dialNumberOrName = false;
    private String dialedNumberOrName = "";
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_TIME_OUT_ACTION_FAILED;
    protected static final int[] PHONE_LISTENER_IDS;
    protected static final int[] PHONE_LISTENER_HMI_EVENT_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DialNumber_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        this.getPhoneService().addHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
        this.timer = this.getTimerService().createTimer(this, 20000);
        return null;
    }

    protected DialNumber_Result dequeueBAPEntity() {
        return (DialNumber_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DialNumber_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DialNumber_Result = DialNumber.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.DialNumber_Result")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DialNumber_Result);
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
        return 26;
    }

    private void abortDialNumber(MethodListener methodListener) {
        if (this.dialingStarted) {
            int n;
            int n2 = this.getIndex();
            if (n2 != -1) {
                this.getPhoneService().hangUpCall(n2);
                n = 2;
            } else {
                n = 2;
            }
            this.dialingStarted = false;
            this.sendDialNumberResult(methodListener, n);
        } else {
            this.sendDialNumberResult(methodListener, 2);
        }
    }

    private boolean isDialingPossible(MethodListener methodListener) {
        boolean bl;
        if (!this.dialingStarted) {
            PhoneService phoneService = this.getPhoneService();
            if (phoneService.getNetworkState() == 5) {
                methodListener.requestError(139, this);
                bl = false;
            } else if (this.eCallConfirmationPending) {
                this.sendDialNumberResult(10);
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

    private void dialNumberStartResult(DialNumber_StartResult dialNumber_StartResult, MethodListener methodListener) {
        if (this.isDialingPossible(methodListener)) {
            String string;
            if (dialNumber_StartResult.telNumber.isNullString()) {
                this.dialedNumberOrName = this.getPhoneService().getLastDialedNumber();
                if (this.dialedNumberOrName != null && this.dialedNumberOrName.length() != 0) {
                    string = this.dialedNumberOrName;
                } else {
                    string = null;
                    methodListener.requestError(143, this);
                }
            } else if (dialNumber_StartResult.telNumber.isEmptyString()) {
                string = null;
                methodListener.requestError(131, this);
            } else {
                this.dialedNumberOrName = string = dialNumber_StartResult.telNumber.toString();
            }
            this.dialNumberOrName = false;
            if (string != null) {
                String string2 = this.getPhoneService().getEmergencyCallNumber();
                if (string2.length() != 0 && string2.compareTo(string) == 0) {
                    this.getPhoneService().startEmergencyCallInternal();
                } else {
                    this.selectNumberInProgress = true;
                    this.getPhoneService().setNumberForDailing(string);
                }
                this.dialingStarted = true;
                this.timer.retrigger(new Integer(0));
            }
        }
    }

    private void sendDialNumberResult(int n) {
        DialNumber_Result dialNumber_Result = this.dequeueBAPEntity();
        dialNumber_Result.dialNumber_Result = n;
        this.getDelegate().getMethodListener(this).result(dialNumber_Result, this);
    }

    private void sendDialNumberResult(MethodListener methodListener, int n) {
        DialNumber_Result dialNumber_Result = this.dequeueBAPEntity();
        dialNumber_Result.dialNumber_Result = n;
        methodListener.result(dialNumber_Result, this);
    }

    private int getCallStateIndex(int n, int n2) {
        int n3 = -1;
        Iterator iterator = this.getPhoneService().getCallInformations();
        int n4 = 0;
        while (iterator.hasNext()) {
            PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
            if (phoneCallInformationElement.getCallState() == n || phoneCallInformationElement.getCallState() == n2) {
                n3 = n4;
                break;
            }
            ++n4;
        }
        return n3;
    }

    private int getNameIndex(String string) {
        int n = -1;
        Iterator iterator = this.getPhoneService().getCallInformations();
        int n2 = 0;
        while (iterator.hasNext()) {
            PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
            if (phoneCallInformationElement.getCallerName().compareTo(string) == 0) {
                n = n2;
            }
            ++n2;
        }
        return n;
    }

    private int getIndex() {
        int n = !this.dialingStarted ? -1 : (!this.dialNumberOrName ? this.getCallStateIndex(1, 2) : this.getNameIndex(this.dialedNumberOrName));
        return n;
    }

    private void checkDialStatus() {
        int n = this.getCallStateIndex(1, 2);
        if (n != -1) {
            this.sendDialNumberResult(0);
            this.dialingStarted = false;
        }
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        this.abortDialNumber(methodListener);
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        this.dialNumberStartResult((DialNumber_StartResult)bAPEntity, methodListener);
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
        this.dialingStarted = false;
        this.selectNumberInProgress = false;
        this.eCallConfirmationPending = false;
        this.dialNumberOrName = false;
    }

    @Override
    public void uninitialize() {
        this.timer.stop();
        this.getPhoneService().removePhoneServiceListener(this, PHONE_LISTENER_IDS);
        this.getPhoneService().removeHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
    }

    public void setCurrentCallState(CallState_Status callState_Status) {
        if (this.dialingStarted) {
            if (callState_Status.callOutgoingDiverted_eCallConfirmationPending.eCallConfirmationPending) {
                this.dialingStarted = false;
                this.sendDialNumberResult(10);
            } else {
                this.checkDialStatus();
            }
        }
        this.eCallConfirmationPending = callState_Status.callOutgoingDiverted_eCallConfirmationPending.eCallConfirmationPending;
    }

    @Override
    public void process(int n) {
        if (this.selectNumberInProgress && this.dialingStarted) {
            this.selectNumberInProgress = false;
            switch (this.getPhoneService().getSelectedNumberType()) {
                case 0: {
                    this.dialingStarted = false;
                    this.getDelegate().getMethodListener(this).requestError(131, this);
                    break;
                }
                case 2: {
                    this.getPhoneService().startEmergencyCall();
                    break;
                }
                default: {
                    this.getPhoneService().startCall(0L, this.dialedNumberOrName);
                }
            }
        }
    }

    @Override
    public void timerFired(Timer timer) {
        if (this.dialingStarted) {
            this.dialingStarted = false;
            this.sendDialNumberResult(1);
        }
    }

    protected void phoneDialingFailed() {
        if (this.dialingStarted) {
            int n;
            this.dialingStarted = false;
            switch (this.getPhoneService().getDialingFailedReason()) {
                case 1: 
                case 2: {
                    n = 5;
                    break;
                }
                case 3: {
                    n = 4;
                    break;
                }
                default: {
                    n = 1;
                }
            }
            this.sendDialNumberResult(n);
        }
    }

    @Override
    public void processHMIEvent(int n) {
        switch (n) {
            case 163: {
                this.phoneDialingFailed();
                break;
            }
        }
    }

    @Override
    public void updatePhoneData(PhoneService phoneService, int n) {
        this.process(-1);
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
        PHONE_LISTENER_IDS = new int[]{1152};
        PHONE_LISTENER_HMI_EVENT_IDS = new int[]{163};
    }
}

