/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.audiosd.api.stages.GeneralInfoSwitchesStage;
import de.vw.mib.bap.mqbpq.common.api.asl.audio.ASLRadio;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.GeneralInfoSwitches_SetGet;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.GeneralInfoSwitches_Status;

public final class GeneralInfoSwitches
extends GeneralInfoSwitchesStage {
    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        return this.computeGeneralInfoSwitchesStatus();
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public void process(int n) {
        this.getDelegate().getPropertyListener(this).statusProperty(this.computeGeneralInfoSwitchesStatus(), this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        boolean bl = false;
        GeneralInfoSwitches_SetGet generalInfoSwitches_SetGet = (GeneralInfoSwitches_SetGet)bAPEntity;
        if (generalInfoSwitches_SetGet.onOffSwitches.tpTaOn != this.getTpSetupOptionState()) {
            ASLRadio.setTpState(generalInfoSwitches_SetGet.onOffSwitches.tpTaOn);
            bl = true;
        }
        if (generalInfoSwitches_SetGet.onOffSwitches.rdsOn != this.getRdsSetupOptionState()) {
            ASLRadio.setRdsSetupOptionState(generalInfoSwitches_SetGet.onOffSwitches.rdsOn);
            bl = true;
        }
        if (!bl) {
            propertyListener.statusProperty(this.computeGeneralInfoSwitchesStatus(), this);
        }
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
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

    private void setOnOffSwitches(GeneralInfoSwitches_Status generalInfoSwitches_Status) {
        boolean bl;
        generalInfoSwitches_Status.onOffSwitches.rdsOn = bl = this.getRdsSetupOptionState();
        generalInfoSwitches_Status.onOffSwitches.tpTaOn = generalInfoSwitches_Status.onOffSwitches.rdsOn ? this.getTpSetupOptionState() : false;
        generalInfoSwitches_Status.onOffSwitches.tmcOn = bl && this.getNaviDomainAvailable() == 1;
    }

    private GeneralInfoSwitches_Status computeGeneralInfoSwitchesStatus() {
        GeneralInfoSwitches_Status generalInfoSwitches_Status = this.dequeueBAPEntity();
        this.setOnOffSwitches(generalInfoSwitches_Status);
        return generalInfoSwitches_Status;
    }
}

