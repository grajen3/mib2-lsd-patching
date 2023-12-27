/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.asl.api.bap.timer.Timer;
import de.vw.mib.asl.api.bap.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.ServiceManager;
import de.vw.mib.bap.mqbpq.audiosd.api.stages.ActiveSourceStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.ActiveSource_Status;

public class ActiveSource
extends ActiveSourceStage
implements TimerNotifier {
    private int currentSourceListReference = 0;
    private int currentPresetIndex;
    private BAPArrayList _receptionList;
    private static final int TYPE_OF_NUMBER_OFFSET;
    private static final int PRESET_INDEX_INVALID;
    private static final int TIMER_UPDATE_SUPPRESSION_TIME;
    private static final int TIMER_UPDATE_SUPPRESSION_INSTANCE_ID;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_STOP_IGNORE_ENTERTAINMENT_SUPRESSION;
    private static final int PQ_MAX_CHANNEL_NUMBER;
    private Timer _suppressionTimer;
    private BAPStageInitializer _stageInitializer;

    private BAPStageInitializer getStageInitializer() {
        return this._stageInitializer;
    }

    private void setStageInitializer(BAPStageInitializer bAPStageInitializer) {
        this._stageInitializer = bAPStageInitializer;
    }

    private Timer getSuppressionTimer() {
        if (this._suppressionTimer == null) {
            this._suppressionTimer = this.getStageInitializer().createTimer(this, this, 0, 1);
        }
        return this._suppressionTimer;
    }

    private void setBapActiveAudioSourceForRadio(ActiveSource_Status activeSource_Status) {
        switch (this.getCurrentStationInfoBand()) {
            case 1: {
                activeSource_Status.audioSource = 1;
                activeSource_Status.number = this.currentPresetIndex + 1;
                break;
            }
            case 0: {
                activeSource_Status.audioSource = 2;
                activeSource_Status.number = this.currentPresetIndex + 1;
                break;
            }
            case 2: {
                activeSource_Status.audioSource = 3;
                activeSource_Status.number = this.currentPresetIndex + 1;
                break;
            }
            case 3: {
                activeSource_Status.audioSource = 5;
                activeSource_Status.number = this.currentPresetIndex + 1;
                activeSource_Status.channelId = Math.min(this.getCurrentSatChannelNumber(), 255);
                break;
            }
            default: {
                activeSource_Status.audioSource = 255;
            }
        }
    }

    private void setBapActiveAudioSourceForMedia(ActiveSource_Status activeSource_Status) {
        switch (this.getCurrentAudioSource()) {
            case 1: {
                activeSource_Status.audioSource = 6;
                break;
            }
            case 2: {
                activeSource_Status.audioSource = 11;
                activeSource_Status.number = ServiceManager.serviceManager.configurationManager.getNumberOfSDSlots() <= 1 ? 0 : 1;
                break;
            }
            case 3: 
            case 9: {
                activeSource_Status.audioSource = 14;
                break;
            }
            case 4: {
                activeSource_Status.audioSource = 7;
                break;
            }
            case 5: {
                activeSource_Status.audioSource = 10;
                break;
            }
            case 6: {
                activeSource_Status.audioSource = 255;
                break;
            }
            case 7: {
                activeSource_Status.audioSource = 16;
                break;
            }
            case 8: {
                activeSource_Status.audioSource = 16;
                break;
            }
            case 10: {
                activeSource_Status.audioSource = 11;
                activeSource_Status.number = 2;
                break;
            }
            case 11: {
                activeSource_Status.audioSource = 16;
                break;
            }
            case 13: {
                activeSource_Status.audioSource = 16;
                activeSource_Status.number = 2;
                break;
            }
            case 14: {
                activeSource_Status.audioSource = 16;
                activeSource_Status.number = 2;
                break;
            }
            default: {
                activeSource_Status.audioSource = 255;
            }
        }
    }

    private void setBapActiveAudioSource(ActiveSource_Status activeSource_Status) {
        activeSource_Status.number = 0;
        activeSource_Status.listAvailable.listAvailable = false;
        switch (this.getCurrentAudioComponent()) {
            case 1: {
                this.setBapActiveAudioSourceForRadio(activeSource_Status);
                break;
            }
            case 2: {
                this.setBapActiveAudioSourceForMedia(activeSource_Status);
                break;
            }
            case 3: {
                activeSource_Status.audioSource = 8;
                break;
            }
            case 5: {
                activeSource_Status.audioSource = 9;
                break;
            }
            case 4: {
                activeSource_Status.audioSource = 255;
                break;
            }
            case 6: {
                activeSource_Status.audioSource = 16;
                break;
            }
            default: {
                if (this.currentSourceListReference != 0) {
                    activeSource_Status.audioSource = this.currentSourceListReference;
                    if (this.getSuppressionTimer().isRunning()) break;
                    this.getSuppressionTimer().retrigger(1);
                    break;
                }
                activeSource_Status.audioSource = 0;
            }
        }
    }

    private void setListAvailable(ActiveSource_Status activeSource_Status) {
        BAPArrayList bAPArrayList = this.getReceptionList();
        activeSource_Status.listAvailable.listAvailable = bAPArrayList != null && bAPArrayList.size() > 0 && this.getCurrentAudioComponent() == 1;
    }

    private void sendActiveSourceStatus(ActiveSource_Status activeSource_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(activeSource_Status, this);
        if (this.currentSourceListReference != activeSource_Status.audioSource) {
            this.currentSourceListReference = activeSource_Status.audioSource;
        }
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        this.setStageInitializer(bAPStageInitializer);
        ActiveSource_Status activeSource_Status = this.computeActiveSourceStatus(this.dequeueBAPEntity());
        return activeSource_Status;
    }

    public BAPEntity lastReportedData() {
        return null;
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
        this.getSuppressionTimer().stop();
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
        ActiveSource_Status activeSource_Status = this.computeActiveSourceStatus(this.dequeueBAPEntity());
        if (n == 0) {
            this.currentPresetIndex = this.getPresetBankActiveIndex();
            this.computeActiveSourceStatus(activeSource_Status);
        } else if (activeSource_Status.audioSource != this.currentSourceListReference) {
            this.currentPresetIndex = -1;
            this.computeActiveSourceStatus(activeSource_Status);
        }
        this.sendActiveSourceStatus(activeSource_Status);
    }

    private ActiveSource_Status computeActiveSourceStatus(ActiveSource_Status activeSource_Status) {
        this.setBapActiveAudioSource(activeSource_Status);
        this.setListAvailable(activeSource_Status);
        return activeSource_Status;
    }

    @Override
    protected void setReceptionList(BAPArrayList bAPArrayList) {
        this._receptionList = bAPArrayList;
        this.process(-1);
    }

    private BAPArrayList getReceptionList() {
        return this._receptionList;
    }

    @Override
    public void timerFired(int n) {
        switch (n) {
            case 1: {
                if (this.currentSourceListReference == 0 || this.getCurrentAudioComponent() != 0) break;
                this.currentSourceListReference = 0;
                this.process(-1);
                break;
            }
        }
    }
}

