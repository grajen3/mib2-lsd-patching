/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.audiosd.api.stages.FunctionListStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.FunctionList_Status;

public final class FunctionList
extends FunctionListStage {
    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        return this.usedFunctionList();
    }

    private FunctionList_Status usedFunctionList() {
        FunctionList_Status functionList_Status = this.dequeueBAPEntity();
        functionList_Status.fctGetAllAvailable = false;
        functionList_Status.fctBapConfigAvailable = true;
        functionList_Status.fctFunctionListAvailable = true;
        functionList_Status.fctHeartbeatAvailable = true;
        functionList_Status.fctFsgSetupAvailable = true;
        functionList_Status.fctFsgOperationStateAvailable = true;
        functionList_Status.fctActiveSourceAvailable = true;
        functionList_Status.fctActiveSourceNameAvailable = true;
        functionList_Status.fctCurrentVolumeAvailable = true;
        functionList_Status.fctMuteAvailable = true;
        functionList_Status.fctSourceStateAvailable = true;
        functionList_Status.fctCurrentStationInfoAvailable = true;
        functionList_Status.fctInfoListAvailable = true;
        functionList_Status.fctDedicatedAudioControlAvailable = true;
        functionList_Status.fctGeneralInfoSwitchesAvailable = true;
        functionList_Status.fctTpInfoAvailable = false;
        functionList_Status.fctTaInfoAvailable = true;
        functionList_Status.fctTaEscapeAvailable = true;
        functionList_Status.fctInfoStatesAvailable = true;
        functionList_Status.fctInfoListTypeAvailable = true;
        functionList_Status.fctChangeInfoListTypeAvailable = true;
        functionList_Status.fctSaveStationAvailable = false;
        functionList_Status.fctChangeTunerVariantAvailable = false;
        return functionList_Status;
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
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
    public void process(int n) {
    }
}

