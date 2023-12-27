/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.audiosd.api.stages.FSGSetupStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.FSG_Setup_Status;

public final class FSGSetup
extends FSGSetupStage {
    private void sendFsgSetupStatus(FSG_Setup_Status fSG_Setup_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(fSG_Setup_Status, this);
    }

    private void setFsgSetupStatusData(FSG_Setup_Status fSG_Setup_Status) {
        fSG_Setup_Status.maxVolume = this.getVolumeEntertainmentMax();
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        return this.computeFSGSetupStatus();
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
        this.sendFsgSetupStatus(this.computeFSGSetupStatus());
    }

    private FSG_Setup_Status computeFSGSetupStatus() {
        FSG_Setup_Status fSG_Setup_Status = this.dequeueBAPEntity();
        this.setFsgSetupStatusData(fSG_Setup_Status);
        return fSG_Setup_Status;
    }
}

