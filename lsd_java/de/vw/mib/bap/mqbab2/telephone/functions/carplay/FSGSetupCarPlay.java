/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions.carplay;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.FSG_Setup_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class FSGSetupCarPlay
extends Function
implements Property,
ASLTelephoneConstants {
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FSG_Setup_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return this.computeFSGSetupStatus();
    }

    protected void setCurrentFsgSetupState(FSG_Setup_Status fSG_Setup_Status) {
        int[] nArray = new int[]{43};
        this.context.updateStages(this, nArray, fSG_Setup_Status);
    }

    protected FSG_Setup_Status dequeueBAPEntity() {
        return (FSG_Setup_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FSG_Setup_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FSG_Setup_Status = FSGSetupCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.FSG_Setup_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$FSG_Setup_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 15: {
                this.setFsgOperationState((FSG_OperationState_Status)object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 14;
    }

    private void setFSGSetupStateMobileConnectionType(FSG_Setup_Status fSG_Setup_Status) {
        fSG_Setup_Status.mobileConnectionType = 2;
    }

    private void setFSGSetupStatePhoneCharacteristics(FSG_Setup_Status fSG_Setup_Status) {
        fSG_Setup_Status.phoneCharacteristics.internalSimcardReader = false;
        fSG_Setup_Status.phoneCharacteristics.hfpConnectionToMobilePossible = false;
        fSG_Setup_Status.phoneCharacteristics.rsapConnectionToMobilePossible = false;
        fSG_Setup_Status.phoneCharacteristics.cableConnectionToMobilePossible = true;
    }

    private void sendFSGSetup(FSG_Setup_Status fSG_Setup_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(fSG_Setup_Status, this);
    }

    protected void setFsgOperationState(FSG_OperationState_Status fSG_OperationState_Status) {
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
        this.sendFSGSetup(this.computeFSGSetupStatus());
    }

    private FSG_Setup_Status computeFSGSetupStatus() {
        FSG_Setup_Status fSG_Setup_Status = this.dequeueBAPEntity();
        this.setFSGSetupStatePhoneCharacteristics(fSG_Setup_Status);
        this.setFSGSetupStateMobileConnectionType(fSG_Setup_Status);
        return fSG_Setup_Status;
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

