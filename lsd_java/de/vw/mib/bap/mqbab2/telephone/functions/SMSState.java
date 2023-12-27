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
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.SMSState_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class SMSState
extends Function
implements Property,
ASLTelephoneConstants,
PhoneServiceListener {
    private int currentStorageFullState = 1;
    protected static final int[] PHONE_LISTENER_IDS = new int[]{-991818496, 456, 449};
    protected static final int[] PHONE_LISTENER_HMI_EVENT_IDS = new int[]{63};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$SMSState_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        this.getPhoneService().addHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
        return null;
    }

    protected SMSState_Status dequeueBAPEntity() {
        return (SMSState_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$SMSState_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$SMSState_Status = SMSState.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.SMSState_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$SMSState_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 55;
    }

    @Override
    public void process(int n) {
        this.sendSMSState(this.computeSMSState());
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
        this.getPhoneService().removeHMIEventListener(this, PHONE_LISTENER_HMI_EVENT_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        SMSState_Status sMSState_Status = this.computeSMSState();
        if (sMSState_Status.simready == 0 || sMSState_Status.numberOfNewSms == 0) {
            propertyListener.statusProperty(sMSState_Status, this);
        } else {
            this.getPhoneService().clearNewMessageCounter();
        }
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    private void sendSMSState(SMSState_Status sMSState_Status) {
        if (this.getDelegate().getPropertyListener(this).statusProperty(sMSState_Status, this)) {
            this.currentStorageFullState = sMSState_Status.storageState;
        }
    }

    private SMSState_Status computeSMSState() {
        PhoneService phoneService = this.getPhoneService();
        SMSState_Status sMSState_Status = this.dequeueBAPEntity();
        sMSState_Status.simready = phoneService.isMessagingAvailable() ? 1 : 0;
        sMSState_Status.storageState = phoneService.isMessageStorageFull() ? this.currentStorageFullState : 0;
        sMSState_Status.numberOfNewSms = phoneService.getNumberOfNewMessages();
        return sMSState_Status;
    }

    protected void messageMemoryFull() {
        switch (this.currentStorageFullState) {
            case 1: {
                this.currentStorageFullState = 2;
                break;
            }
            case 2: {
                this.currentStorageFullState = 3;
                break;
            }
            case 3: {
                this.currentStorageFullState = 2;
                break;
            }
            default: {
                this.currentStorageFullState = 1;
            }
        }
        this.process(-1);
    }

    @Override
    public void processHMIEvent(int n) {
        switch (n) {
            case 63: {
                this.messageMemoryFull();
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
}

