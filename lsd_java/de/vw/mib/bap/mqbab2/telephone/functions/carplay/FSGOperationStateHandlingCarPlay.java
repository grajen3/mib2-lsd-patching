/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions.carplay;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.FSGOperationState;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.valetparking.ValetParkingService;
import de.vw.mib.bap.mqbab2.common.api.valetparking.ValetParkingServiceListener;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class FSGOperationStateHandlingCarPlay
extends Function
implements FSGOperationState,
Property,
ASLTelephoneConstants,
ValetParkingServiceListener {
    private boolean operationStateSystemDependent = false;
    private int currentOpState = 0;
    protected static final int[] VALET_PARKING_LISTENER_IDS = new int[]{1};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FSG_OperationState_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getValetParkingService().addValetParkingServiceListener(this, VALET_PARKING_LISTENER_IDS);
        return this.computeFSGOperationStateStatus();
    }

    protected FSG_OperationState_Status dequeueBAPEntity() {
        return (FSG_OperationState_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FSG_OperationState_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FSG_OperationState_Status = FSGOperationStateHandlingCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.FSG_OperationState_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FSG_OperationState_Status);
    }

    protected void setFsgOperationState(FSG_OperationState_Status fSG_OperationState_Status) {
        int[] nArray = new int[]{14};
        this.context.updateStages(this, nArray, fSG_OperationState_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 15;
    }

    private void setTelState(FSG_OperationState_Status fSG_OperationState_Status) {
        fSG_OperationState_Status.tel_State = 7;
    }

    private void setOperationStateStatus(FSG_OperationState_Status fSG_OperationState_Status) {
        fSG_OperationState_Status.op_State = this.operationStateSystemDependent ? (!this.getValetParkingService().isValetParkingActive() ? 0 : 1) : this.currentOpState;
        this.setTelState(fSG_OperationState_Status);
        fSG_OperationState_Status.privacyMode.privacyModeActive = false;
        fSG_OperationState_Status.privacyMode.enhancedPrivacyModeActive = false;
    }

    private void sendOperationStateStatus(FSG_OperationState_Status fSG_OperationState_Status) {
        if (this.getDelegate().getPropertyListener(this).statusProperty(fSG_OperationState_Status, this)) {
            this.currentOpState = fSG_OperationState_Status.op_State;
        }
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(128, this);
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
        this.getValetParkingService().removeValetParkingServiceListener(this, VALET_PARKING_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(128, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void process(int n) {
        this.sendOperationStateStatus(this.computeFSGOperationStateStatus());
    }

    private FSG_OperationState_Status computeFSGOperationStateStatus() {
        FSG_OperationState_Status fSG_OperationState_Status = this.dequeueBAPEntity();
        this.setOperationStateStatus(fSG_OperationState_Status);
        return fSG_OperationState_Status;
    }

    @Override
    public void setHMISystemDependent(boolean bl) {
        if (this.operationStateSystemDependent != bl) {
            this.operationStateSystemDependent = bl;
            this.process(-1);
        }
    }

    @Override
    public boolean isSystemDependent() {
        return this.operationStateSystemDependent;
    }

    @Override
    public void setState(int n) {
        if (this.currentOpState != n) {
            this.currentOpState = n;
            this.process(-1);
        }
    }

    @Override
    public int getState() {
        return this.currentOpState;
    }

    protected void phoneInitUpdate() {
        this.process(-1);
    }

    protected void bluetoothConnectionFailed() {
        this.process(-1);
    }

    protected void bluetoothBondingFailed() {
        this.process(-1);
    }

    @Override
    public void updateValetParkingData(ValetParkingService valetParkingService, int n) {
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

