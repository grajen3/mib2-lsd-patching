/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.audiosd.api.stages.MuteStage;
import de.vw.mib.bap.mqbpq.common.api.asl.audio.ASLSound;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.Mute_SetGet;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.Mute_Status;

public class Mute
extends MuteStage {
    private void setGetMuteProperty(Mute_SetGet mute_SetGet, PropertyListener propertyListener) {
        Mute_Status mute_Status = this.computeMuteStatus();
        if (mute_Status.muteState.muting == mute_SetGet.muteState.muting || this.getComponentProtectionActive() == 1) {
            propertyListener.statusProperty(mute_Status, this);
        } else {
            boolean bl;
            boolean bl2;
            boolean bl3 = bl2 = this.getMuteActive() == 1;
            if (bl2 != mute_SetGet.muteState.muting) {
                ASLSound.pinMute();
                bl = true;
            } else {
                bl = false;
            }
            if (!bl) {
                propertyListener.statusProperty(mute_Status, this);
            }
        }
    }

    private void sendMuteStatus(Mute_Status mute_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(mute_Status, this);
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        return this.computeMuteStatus();
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        this.setGetMuteProperty((Mute_SetGet)bAPEntity, propertyListener);
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
        this.sendMuteStatus(this.computeMuteStatus());
    }

    protected void setIbocState(Mute_Status mute_Status) {
        mute_Status.muteState.dabDvbSdarsMuting = false;
    }

    protected void setSdarsMuting(Mute_Status mute_Status) {
        mute_Status.muteState.dabDvbSdarsMuting = false;
    }

    private Mute_Status computeMuteStatus() {
        Mute_Status mute_Status = this.dequeueBAPEntity();
        mute_Status.muteState.muting = this.getMuteActive() == 1;
        int n = this.getCurrentAudioComponent();
        if (n == 1) {
            int n2 = this.getCurrentStationInfoBand();
            if (n2 == 2) {
                mute_Status.muteState.dabDvbSdarsMuting = this.getDabEnsembleState() == 1 || this.getDabServiceState() == 1;
            } else if (n2 == 1 || n2 == 0) {
                this.setIbocState(mute_Status);
            } else {
                this.setSdarsMuting(mute_Status);
            }
        }
        return mute_Status;
    }
}

