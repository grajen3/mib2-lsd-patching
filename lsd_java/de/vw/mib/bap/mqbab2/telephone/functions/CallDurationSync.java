/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.elements.PhoneCallInformationElement;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.elements.PhoneConferenceCallInformationsElement;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallDurationSync_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import java.util.Iterator;

public final class CallDurationSync
extends Function
implements Property,
ASLTelephoneConstants,
PhoneServiceListener {
    private static final int CALL_DURATION_NOT_AVAILABLE;
    private static final int CALL_ID_DUMMY;
    private static final int CALL_ID_ONE;
    private static final int CALL_ID_TWO;
    private static final int CALL_ID_THREE;
    private static final int CALL_ID_FOUR;
    private static final int CALL_ID_FIVE;
    private static final int CALL_ID_SIX;
    private static final int CALL_ID_SEVEN;
    private static final int CALL_ID_CONFERENCE;
    protected static final int[] PHONE_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallDurationSync_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        return this.computeCallDurationSyncStatus();
    }

    protected CallDurationSync_Status dequeueBAPEntity() {
        return (CallDurationSync_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallDurationSync_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallDurationSync_Status = CallDurationSync.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallDurationSync_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallDurationSync_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 24;
    }

    private static int formatTimeStamp(int n) {
        int n2 = n == 0 ? -65536 : n;
        return n2;
    }

    private static int setTimeStamp(CallDurationSync_Status callDurationSync_Status, int n, int n2) {
        int n3 = -65536;
        switch (n) {
            case 1: {
                callDurationSync_Status.timeStampCall0 = n2;
                break;
            }
            case 2: {
                callDurationSync_Status.timeStampCall1 = n2;
                break;
            }
            case 3: {
                callDurationSync_Status.timeStampCall2 = n2;
                break;
            }
            case 4: {
                callDurationSync_Status.timeStampCall3 = n2;
                break;
            }
            case 5: {
                callDurationSync_Status.timeStampCall4 = n2;
                break;
            }
            case 6: {
                callDurationSync_Status.timeStampCall5 = n2;
                break;
            }
            case 7: {
                callDurationSync_Status.timeStampCall6 = n2;
                break;
            }
            case 254: {
                n3 = n2;
                break;
            }
        }
        return n3;
    }

    private int setTimeStamps(CallDurationSync_Status callDurationSync_Status) {
        int n = -65536;
        int n2 = -65536;
        Iterator iterator = this.getPhoneService().getCallInformations();
        while (iterator.hasNext()) {
            int n3;
            PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
            int n4 = phoneCallInformationElement.getCallID();
            n2 = CallDurationSync.setTimeStamp(callDurationSync_Status, n4, n3 = CallDurationSync.formatTimeStamp(phoneCallInformationElement.getCallTimeStamp()));
            if (n2 == -65536) continue;
            n = n2;
        }
        return n;
    }

    void setTimeStampsForConference(CallDurationSync_Status callDurationSync_Status, int n) {
        if (n != -65536) {
            Iterator iterator = this.getPhoneService().getConferenceCallInformations();
            while (iterator.hasNext()) {
                PhoneConferenceCallInformationsElement phoneConferenceCallInformationsElement = (PhoneConferenceCallInformationsElement)iterator.next();
                CallDurationSync.setTimeStamp(callDurationSync_Status, phoneConferenceCallInformationsElement.getConferenceCallId(), n);
            }
        }
    }

    private void sendCallDurationSync(CallDurationSync_Status callDurationSync_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(callDurationSync_Status, this);
    }

    @Override
    public void process(int n) {
        this.sendCallDurationSync(this.computeCallDurationSyncStatus());
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(69, this);
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getPhoneService().removePhoneServiceListener(this, PHONE_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(69, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    private CallDurationSync_Status computeCallDurationSyncStatus() {
        CallDurationSync_Status callDurationSync_Status = this.dequeueBAPEntity();
        callDurationSync_Status.timeStampCall0 = -65536;
        callDurationSync_Status.timeStampCall1 = -65536;
        callDurationSync_Status.timeStampCall2 = -65536;
        callDurationSync_Status.timeStampCall3 = -65536;
        callDurationSync_Status.timeStampCall4 = -65536;
        callDurationSync_Status.timeStampCall5 = -65536;
        callDurationSync_Status.timeStampCall6 = -65536;
        int n = this.setTimeStamps(callDurationSync_Status);
        this.setTimeStampsForConference(callDurationSync_Status, n);
        return callDurationSync_Status;
    }

    @Override
    public void processHMIEvent(int n) {
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
        PHONE_LISTENER_IDS = new int[]{1158, 1160};
    }
}

