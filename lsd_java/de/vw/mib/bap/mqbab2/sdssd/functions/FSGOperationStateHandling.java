/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.sdssd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.FSGOperationState;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.bap.mqbab2.common.api.valetparking.ValetParkingService;
import de.vw.mib.bap.mqbab2.common.api.valetparking.ValetParkingServiceListener;
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.FSG_OperationState_Status;

public final class FSGOperationStateHandling
extends Function
implements FSGOperationState,
Property,
SystemServiceListener,
ValetParkingServiceListener {
    private boolean operationStateSystemDependent = false;
    private int currentOpState = 0;
    protected static final int[] SYSTEM_LISTENER_IDS = new int[]{1632};
    protected static final int[] VALET_PARKING_LISTENER_IDS = new int[]{1};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$FSG_OperationState_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getSystemService().addSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getValetParkingService().addValetParkingServiceListener(this, VALET_PARKING_LISTENER_IDS);
        return this.computeFSGOperationStateStatus();
    }

    protected FSG_OperationState_Status dequeueBAPEntity() {
        return (FSG_OperationState_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$FSG_OperationState_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$FSG_OperationState_Status = FSGOperationStateHandling.class$("de.vw.mib.bap.mqbab2.generated.sdssd.serializer.FSG_OperationState_Status")) : class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$FSG_OperationState_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 15;
    }

    private void setOperationStateStatus(FSG_OperationState_Status fSG_OperationState_Status) {
        if (this.operationStateSystemDependent) {
            if (!this.getValetParkingService().isValetParkingActive()) {
                switch (this.getSystemService().getSystemOnOffState()) {
                    case 0: 
                    case 1: {
                        fSG_OperationState_Status.op_State = 1;
                        break;
                    }
                    case 2: {
                        fSG_OperationState_Status.op_State = 0;
                        break;
                    }
                    default: {
                        fSG_OperationState_Status.op_State = 3;
                        break;
                    }
                }
            } else {
                fSG_OperationState_Status.op_State = 1;
            }
        } else {
            fSG_OperationState_Status.op_State = this.currentOpState;
        }
    }

    private void sendOperationStateStatus(FSG_OperationState_Status fSG_OperationState_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(fSG_OperationState_Status, this);
        this.currentOpState = fSG_OperationState_Status.op_State;
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getSystemService().removeSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getValetParkingService().removeValetParkingServiceListener(this, VALET_PARKING_LISTENER_IDS);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
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
        FSG_OperationState_Status fSG_OperationState_Status = this.dequeueBAPEntity();
        fSG_OperationState_Status.op_State = n;
        this.sendOperationStateStatus(fSG_OperationState_Status);
    }

    @Override
    public int getState() {
        return this.currentOpState;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateSystemData(SystemService systemService, int n) {
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

