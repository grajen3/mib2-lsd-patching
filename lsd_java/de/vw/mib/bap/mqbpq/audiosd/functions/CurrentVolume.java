/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.asl.api.bap.timer.Timer;
import de.vw.mib.asl.api.bap.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.audiosd.api.stages.CurrentVolumeStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.CurrentVolume_Status;

public final class CurrentVolume
extends CurrentVolumeStage
implements TimerNotifier {
    private CurrentVolume_Status lastCurrentVolumeStatus = null;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_CLOSE_VOLUME_POPUP;
    private boolean volumeWasChangedByMFL = false;

    private void setVolumes(CurrentVolume_Status currentVolume_Status) {
        currentVolume_Status.volume = this.getVolumeEntertainment();
    }

    private void setChangingValueType(CurrentVolume_Status currentVolume_Status) {
        int n = this.getCurrentDdsVolumeFocus();
        switch (n) {
            case 0: {
                currentVolume_Status.changingVolume = this.volumeWasChangedByMFL ? 1 : 0;
                break;
            }
            case 1: {
                currentVolume_Status.changingVolume = this.volumeWasChangedByMFL ? 1 : 0;
                currentVolume_Status.volume = this.getVolumeNavi();
                break;
            }
            case 2: {
                currentVolume_Status.changingVolume = this.volumeWasChangedByMFL ? 1 : 0;
                currentVolume_Status.volume = this.getVolumePhone();
                break;
            }
            case 3: {
                currentVolume_Status.changingVolume = this.volumeWasChangedByMFL ? 1 : 0;
                currentVolume_Status.volume = this.getVolumeTA();
                break;
            }
            case 4: {
                currentVolume_Status.changingVolume = this.volumeWasChangedByMFL ? 1 : 0;
                currentVolume_Status.volume = this.getVolumeSDS();
                break;
            }
            default: {
                currentVolume_Status.changingVolume = 0;
            }
        }
    }

    private void sendCurrentVolumeStatus(CurrentVolume_Status currentVolume_Status) {
        if (this.getDelegate().getPropertyListener(this).statusProperty(currentVolume_Status, this)) {
            this.lastCurrentVolumeStatus = currentVolume_Status;
        }
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        this.timer = bAPStageInitializer.createTimer(this, this, 0, 0);
        this.lastCurrentVolumeStatus = this.computeCurrentVolumeStatus();
        return this.lastCurrentVolumeStatus;
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
        this.timer.stop();
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
        this.sendCurrentVolumeStatus(this.computeCurrentVolumeStatus());
    }

    protected void setMuteMsgWasSend(Boolean bl) {
        this.getDelegate().getPropertyListener(this).statusProperty(this.lastCurrentVolumeStatus, this);
    }

    @Override
    protected void mflVolumeChange() {
        this.volumeWasChangedByMFL = true;
        this.process(-1);
        this.timer.retrigger(1);
    }

    @Override
    public void timerFired(int n) {
        switch (n) {
            case 1: {
                this.volumeWasChangedByMFL = false;
                this.process(-1);
                break;
            }
        }
    }

    private CurrentVolume_Status computeCurrentVolumeStatus() {
        CurrentVolume_Status currentVolume_Status = this.dequeueBAPEntity();
        this.setVolumes(currentVolume_Status);
        this.setChangingValueType(currentVolume_Status);
        return currentVolume_Status;
    }
}

