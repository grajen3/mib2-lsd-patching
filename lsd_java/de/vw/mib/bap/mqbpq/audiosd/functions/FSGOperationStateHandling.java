/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.FSGOperationState;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.AudioSdLogger;
import de.vw.mib.bap.mqbpq.IntStringMap;
import de.vw.mib.bap.mqbpq.PqServices;
import de.vw.mib.bap.mqbpq.PqServicesProvider;
import de.vw.mib.bap.mqbpq.audiosd.api.stages.FSGOperationStateStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.FSG_OperationState_Status;

public final class FSGOperationStateHandling
extends FSGOperationStateStage
implements FSGOperationState {
    private boolean isOperationStateSystemOnOffStateDependent;
    private boolean isCurrentOperationStateInitializing;
    private int currentOperationState;
    private AudioSdLogger logger;
    private static final int[] OPERATION_STATES = new int[]{0, 1, 2, 15};
    private static final String[] OPERATION_STATE_NAMES = new String[]{"NORMAL_OPERATION", "OFF", "KL15_FOLLOW_UP", "DEFECT"};
    private static final IntStringMap OPERATION_STATE_TO_NAME_MAP = new IntStringMap("Unknown", OPERATION_STATES, OPERATION_STATE_NAMES);
    private static final int[] SYSTEM_STATES = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
    private static final String[] SYSTEM_STATE_NAMES = new String[]{"HMI_OFF", "HMI_OFF_CLOCK", "HMI_ON", "HMI_DIAGNOSE", "HMI_SWDL", "HMI_NOT_INIT", "HMI_LIMITED_PHONE_MODE", "HMI_ON_RESTRICTED", "HMI_ON_ERROR"};
    private static final IntStringMap SYSTEM_STATE_TO_NAME_MAP = new IntStringMap("Unknown", SYSTEM_STATES, SYSTEM_STATE_NAMES);

    public FSGOperationStateHandling() {
        PqServices pqServices = PqServicesProvider.getPqServices();
        this.logger = new AudioSdLogger(pqServices.getLogger(), super.getClass());
        this.isOperationStateSystemOnOffStateDependent = false;
        this.currentOperationState = 0;
    }

    private void setOperationStateStatus(FSG_OperationState_Status fSG_OperationState_Status) {
        this.logger.trace(new Object[]{"setOperationStateStatus called! Current operation state: ", new Integer(fSG_OperationState_Status.opState), " (", OPERATION_STATE_TO_NAME_MAP.get(fSG_OperationState_Status.opState), ")."});
        if (this.isOperationStateSystemOnOffStateDependent) {
            this.logger.trace("isOperationStateSystemOnOffStateDependent = true!");
            int n = this.getSystemOnOffState();
            this.logger.trace(new Object[]{"systemOnOffState = ", new Integer(n), " (", SYSTEM_STATE_TO_NAME_MAP.get(n), ")"});
            switch (n) {
                case 0: 
                case 1: {
                    fSG_OperationState_Status.opState = 1;
                    break;
                }
                case 2: {
                    fSG_OperationState_Status.opState = 0;
                    break;
                }
                default: {
                    fSG_OperationState_Status.opState = 3;
                }
            }
            this.logger.trace(new Object[]{"New operation state: ", new Integer(fSG_OperationState_Status.opState), " (", OPERATION_STATE_TO_NAME_MAP.get(fSG_OperationState_Status.opState), ")."});
        } else {
            this.logger.trace("operationStateSystemDependent = false!");
            fSG_OperationState_Status.opState = this.currentOperationState;
        }
        this.logger.trace(new Object[]{"End of setOperationStateStatus. Operation state is now: ", new Integer(fSG_OperationState_Status.opState)});
    }

    private void sendOperationStateStatus(FSG_OperationState_Status fSG_OperationState_Status) {
        this.currentOperationState = fSG_OperationState_Status.opState;
        boolean bl = fSG_OperationState_Status.opState == 3;
        this.setInitializing(bl);
        if (bl) {
            fSG_OperationState_Status.opState = 0;
        }
        this.logger.trace(new Object[]{"sendOperationStateStatus called. Operation state is: ", new Integer(fSG_OperationState_Status.opState), " (", OPERATION_STATE_TO_NAME_MAP.get(fSG_OperationState_Status.opState), ")"});
        this.getDelegate().getPropertyListener(this).statusProperty(fSG_OperationState_Status, this);
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        return this.computeFSGOperationStateStatus();
    }

    private void setInitializing(boolean bl) {
        if (this.isCurrentOperationStateInitializing != bl) {
            this.isCurrentOperationStateInitializing = bl;
            this.setIsInitializing(bl);
        }
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
        this.logger.trace("process called!");
        this.sendOperationStateStatus(this.computeFSGOperationStateStatus());
    }

    private FSG_OperationState_Status computeFSGOperationStateStatus() {
        this.logger.trace("computeFSGOperationStateStatus called!");
        FSG_OperationState_Status fSG_OperationState_Status = this.dequeueBAPEntity();
        this.setOperationStateStatus(fSG_OperationState_Status);
        return fSG_OperationState_Status;
    }

    @Override
    public void setHMISystemDependent(boolean bl) {
        if (this.isOperationStateSystemOnOffStateDependent != bl) {
            this.isOperationStateSystemOnOffStateDependent = bl;
            this.process(-1);
        }
    }

    @Override
    public boolean isSystemDependent() {
        return this.isOperationStateSystemOnOffStateDependent;
    }

    @Override
    public void setState(int n) {
        this.logger.trace(new Object[]{"setState called. state = ", new Integer(n), " (", OPERATION_STATE_TO_NAME_MAP.get(n), ")"});
        FSG_OperationState_Status fSG_OperationState_Status = this.dequeueBAPEntity();
        fSG_OperationState_Status.opState = n;
        this.sendOperationStateStatus(fSG_OperationState_Status);
    }

    @Override
    public int getState() {
        return this.currentOperationState;
    }
}

