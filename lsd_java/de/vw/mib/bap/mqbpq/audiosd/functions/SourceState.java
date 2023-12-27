/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.audiosd.api.stages.SourceStateStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.SourceState_Status;

public final class SourceState
extends SourceStateStage {
    private void setStateInfoForVideo(SourceState_Status sourceState_Status) {
        sourceState_Status.stateInfo = 0;
    }

    private void setStateInfoForMedia(SourceState_Status sourceState_Status) {
        switch (this.getCurrentAudioSource()) {
            case 3: 
            case 9: {
                sourceState_Status.stateInfo = 0;
                break;
            }
            default: {
                sourceState_Status.stateInfo = this.getMixActive() && !this.getRepeatActive() ? 2 : (this.getRepeatActive() && !this.getMixActive() ? 3 : (this.getRepeatActive() && this.getMixActive() ? 4 : 0));
            }
        }
    }

    private boolean isDvdVideo() {
        int n = this.getCDContentType();
        int n2 = this.getCurrentAudioSource();
        return !(n2 != 1 && n2 != 4 || n != 3 && n != 4);
    }

    private void setStateInfo(SourceState_Status sourceState_Status) {
        switch (this.getCurrentAudioComponent()) {
            case 2: {
                if (this.isDvdVideo()) {
                    this.setStateInfoForVideo(sourceState_Status);
                    break;
                }
                this.setStateInfoForMedia(sourceState_Status);
                break;
            }
            case 1: {
                if (this.getRadioScanning()) {
                    sourceState_Status.stateInfo = 1;
                    break;
                }
                sourceState_Status.stateInfo = 0;
                break;
            }
            default: {
                sourceState_Status.stateInfo = 0;
            }
        }
    }

    private void sendSourceStateStatus(SourceState_Status sourceState_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(sourceState_Status, this);
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        return this.computeSourceStateStatus();
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
    public void process(int n) {
        SourceState_Status sourceState_Status = this.computeSourceStateStatus();
        this.sendSourceStateStatus(sourceState_Status);
    }

    private SourceState_Status computeSourceStateStatus() {
        SourceState_Status sourceState_Status = this.dequeueBAPEntity();
        this.setStateInfo(sourceState_Status);
        return sourceState_Status;
    }
}

