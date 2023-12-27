/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.FSGOperationState;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.mqbpq.navsd.api.stages.FSGOperationStateStage;

public final class FSGOperationStateHandling
extends FSGOperationStateStage
implements FSGOperationState {
    private boolean operationStateSystemDependent = false;
    private int currentOpState = 0;

    private int getContextSpecificOperationState() {
        int n;
        block0 : switch (this.getNaviDomainAvailable()) {
            case 1: {
                if (this.getNavOperationState() == 1) {
                    switch (this.getNavigationStatus()) {
                        case 2: {
                            n = 15;
                            break block0;
                        }
                        case 1: {
                            n = 3;
                            break block0;
                        }
                    }
                    n = 0;
                    break;
                }
                n = 3;
                break;
            }
            case 2: {
                n = 15;
                break;
            }
            default: {
                n = 3;
            }
        }
        return n;
    }

    private void setOperationStateStatusData(FSG_OperationState_Status fSG_OperationState_Status) {
        if (this.operationStateSystemDependent) {
            switch (this.getSystemOnOffState()) {
                case 0: 
                case 1: {
                    fSG_OperationState_Status.opState = 1;
                    break;
                }
                case 2: {
                    fSG_OperationState_Status.opState = this.getContextSpecificOperationState();
                    break;
                }
                default: {
                    fSG_OperationState_Status.opState = 3;
                    break;
                }
            }
        } else {
            fSG_OperationState_Status.opState = this.currentOpState;
        }
    }

    private void sendOperationStateStatus(FSG_OperationState_Status fSG_OperationState_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(fSG_OperationState_Status, this);
        this.currentOpState = fSG_OperationState_Status.opState;
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        return this.computeFSGOperationStateStatus();
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
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
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
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
        this.setOperationStateStatusData(fSG_OperationState_Status);
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
        fSG_OperationState_Status.opState = n;
        this.sendOperationStateStatus(fSG_OperationState_Status);
    }

    @Override
    public int getState() {
        return this.currentOpState;
    }
}

