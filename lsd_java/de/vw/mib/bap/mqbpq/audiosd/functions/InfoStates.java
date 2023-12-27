/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.asl.api.bap.timer.Timer;
import de.vw.mib.asl.api.bap.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.audiosd.api.stages.InfoStatesStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.InfoStates_Status;

public final class InfoStates
extends InfoStatesStage
implements TimerNotifier {
    private int _currentInfoState;
    private boolean _autoStoreInProgress;
    private boolean _remoteControlModeActive;
    private int _currentLoadingSource;
    private boolean _currentLoadingSourceFromRadio;
    private boolean _opStateInitializing;
    private BAPStageInitializer _stageInitializer;
    private static final int LOADING_NO_SOURCE;
    private static final int LOADING_SOURCE_CD_DVD;
    private static final int LOADING_SOURCE_SD1;
    private static final int LOADING_SOURCE_SD2;
    private static final int LOADING_SOURCE_USB;
    private Timer _shortTimer;
    private Timer _longTimer;
    private Timer _suppressionTimer;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_UPDATE_INSTANCE_ID;
    private static final int TIMER_UPDATE_LONG_TIME;
    private static final int TIMER_UPDATE_LONG_TIME_INSTANCE_ID;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_RECOMPUTE_STATE;
    private static final int TIMER_ACTION_RECOMPUTE_STATE_AFTER_SUPPRESSION;
    private static final int TIMER_UPDATE_SUPPRESSION_TIME;
    private static final int TIMER_UPDATE_SUPPRESSION_INSTANCE_ID;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        this.setStageInitializer(bAPStageInitializer);
        return new InfoStates_Status();
    }

    private int getCurrentInfoState() {
        return this._currentInfoState;
    }

    private void setCurrentInfoState(int n) {
        this._currentInfoState = n;
    }

    private boolean isOpStateInitializing() {
        return this._opStateInitializing;
    }

    private void setOpStateInitializing(boolean bl) {
        this._opStateInitializing = bl;
    }

    private int getCurrentLoadingSource() {
        return this._currentLoadingSource;
    }

    private void setCurrentLoadingSource(int n) {
        this._currentLoadingSource = n;
    }

    private boolean isCurrentLoadingSourceFromRadio() {
        return this._currentLoadingSourceFromRadio;
    }

    private void setCurrentLoadingSourceFromRadio(boolean bl) {
        this._currentLoadingSourceFromRadio = bl;
    }

    private boolean isRemoteControlModeActive() {
        return this._remoteControlModeActive;
    }

    private void setRemoteControlModeActive(boolean bl) {
        this._remoteControlModeActive = bl;
    }

    private boolean isAutoStoreInProgress() {
        return this._autoStoreInProgress;
    }

    private void setAutoStoreInProgress(boolean bl) {
        this._autoStoreInProgress = bl;
    }

    private BAPStageInitializer getStageInitializer() {
        return this._stageInitializer;
    }

    private void setStageInitializer(BAPStageInitializer bAPStageInitializer) {
        this._stageInitializer = bAPStageInitializer;
    }

    private Timer getShortTimer() {
        if (this._shortTimer == null) {
            this._shortTimer = this.getStageInitializer().createTimer(this, this, 0, 0);
        }
        return this._shortTimer;
    }

    private Timer getLongTimer() {
        if (this._longTimer == null) {
            this._longTimer = this.getStageInitializer().createTimer(this, this, 0, 1);
        }
        return this._longTimer;
    }

    private Timer getSuppressionTimer() {
        if (this._suppressionTimer == null) {
            this._suppressionTimer = this.getStageInitializer().createTimer(this, this, 0, 2);
        }
        return this._suppressionTimer;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getShortTimer().stop();
        this.getLongTimer().stop();
        this.getSuppressionTimer().stop();
    }

    @Override
    public void process(int n) {
        if (!this.getShortTimer().isRunning() && !this.getLongTimer().isRunning()) {
            this.sendInfoStatesStatus(this.computeInfoState());
        }
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
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void timerFired(int n) {
        switch (n) {
            case 1: 
            case 2: {
                this.process(-1);
                break;
            }
        }
    }

    @Override
    protected void tunerInitialAutostoreFinished() {
        this.setAutoStoreInProgress(false);
        this.stopAllTimers();
        this.process(-1);
    }

    @Override
    protected void tunerInitialAutoStoreCanceled() {
        this.setAutoStoreInProgress(false);
        this.stopAllTimers();
        this.process(-1);
    }

    @Override
    protected void tunerInitialAutoStoreStarted() {
        this.setAutoStoreInProgress(true);
        this.stopAllTimers();
        this.process(-1);
    }

    @Override
    protected void systemCdDvdLoading() {
        this.sendInfoStatesStatus(15);
        this.startLongTimer(0, 1);
        this.setCurrentLoadingSource(1);
        this.setCurrentLoadingSourceFromRadio(this.getCurrentAudioComponent() == 1);
    }

    @Override
    protected void systemCdDvdLoadingFinished() {
        if (this.getCurrentLoadingSource() == 1) {
            this.stopLongTimerAndProcess();
        }
    }

    @Override
    protected void systemSD1Loading() {
        this.sendInfoStatesStatus(15);
        this.startLongTimer(0, 1);
        this.setCurrentLoadingSource(2);
        this.setCurrentLoadingSourceFromRadio(this.getCurrentAudioComponent() == 1);
    }

    @Override
    protected void systemSD1LoadingFinished() {
        if (this.getCurrentLoadingSource() == 2) {
            this.stopLongTimerAndProcess();
        }
    }

    @Override
    protected void systemSD2Loading() {
        this.sendInfoStatesStatus(15);
        this.startLongTimer(0, 1);
        this.setCurrentLoadingSource(3);
        this.setCurrentLoadingSourceFromRadio(this.getCurrentAudioComponent() == 1);
    }

    @Override
    protected void systemSD2LoadingFinished() {
        if (this.getCurrentLoadingSource() == 3) {
            this.stopLongTimerAndProcess();
        }
    }

    @Override
    protected void systemUsbLoading() {
        this.sendInfoStatesStatus(15);
        this.startLongTimer(0, 1);
        this.setCurrentLoadingSource(4);
        this.setCurrentLoadingSourceFromRadio(this.getCurrentAudioComponent() == 1);
    }

    @Override
    protected void systemUsbLoadingFinished() {
        if (this.getCurrentLoadingSource() == 4) {
            this.stopLongTimerAndProcess();
        }
    }

    @Override
    protected void systemCdDvdDeviceError() {
        this.sendInfoStatesStatus(5);
        this.startShortTimer(1);
    }

    @Override
    protected void systemCdDvdReadError() {
    }

    @Override
    protected void systemCdTemperatureWarning() {
        this.sendInfoStatesStatus(6);
        this.startShortTimer(1);
    }

    @Override
    protected void systemSD1DeviceError() {
        this.sendInfoStatesStatus(5);
        this.startShortTimer(1);
    }

    @Override
    protected void systemSD1ReadError() {
    }

    @Override
    protected void systemSD2DeviceError() {
        this.sendInfoStatesStatus(5);
        this.startShortTimer(1);
    }

    @Override
    protected void systemSD2ReadError() {
    }

    @Override
    protected void systemUSBReadError() {
    }

    @Override
    protected void systemUsbDeviceError() {
        this.sendInfoStatesStatus(5);
        this.startShortTimer(1);
    }

    @Override
    protected void systemCdDvdEjected() {
    }

    @Override
    protected void systemStartDiag() {
        this.setRemoteControlModeActive(true);
        this.process(-1);
    }

    @Override
    protected void systemEndDiag() {
        this.setRemoteControlModeActive(false);
        this.process(-1);
    }

    private int computeInfoState() {
        int n = this.getSystemOnOffState();
        int n2 = this.isOpStateInitializing() ? 22 : (n == 3 || this.isRemoteControlModeActive() ? 27 : (this.isAutoStoreInProgress() && this.getCurrentAudioComponent() == 1 ? 25 : this.computeInfoStateForCurrentAudioComponent()));
        return n2;
    }

    private void sendInfoStatesStatus(int n) {
        this.setCurrentInfoState(n);
        InfoStates_Status infoStates_Status = this.dequeueBAPEntity();
        infoStates_Status.states = n;
        this.getDelegate().getPropertyListener(this).statusProperty(infoStates_Status, this);
    }

    private void stopAllTimers() {
        this.getShortTimer().stop();
        this.getLongTimer().stop();
    }

    private void startShortTimer(int n) {
        this.getLongTimer().stop();
        this.getShortTimer().retrigger(n);
    }

    private void startLongTimer(int n, int n2) {
        this.getLongTimer().retrigger(n2);
        this.getShortTimer().retrigger(n);
    }

    private void stopLongTimerAndProcess() {
        if (!this.getShortTimer().isRunning()) {
            this.setCurrentLoadingSource(0);
            if (this.getCurrentAudioComponent() != 1 || !this.isCurrentLoadingSourceFromRadio()) {
                this.getLongTimer().stop();
                this.process(-1);
            }
        } else {
            this.getLongTimer().stop();
            this.getShortTimer().setUserInfo(1);
        }
    }

    private boolean isImportRunningForCurrentAudioSource() {
        boolean bl;
        int n = this.getCurrentAudioSource();
        switch (this.getCurrentAudioImportSource()) {
            case 1: {
                bl = n == 1;
                break;
            }
            case 2: {
                bl = n == 2;
                break;
            }
            case 5: {
                bl = n == 10;
                break;
            }
            case 3: {
                bl = n == 8 || n == 13;
                break;
            }
            case 4: {
                bl = n == 11;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    private int computeCurrentAudioSourceState() {
        int n;
        if (this.isImportRunningForCurrentAudioSource()) {
            n = 15;
        } else {
            block0 : switch (this.getCurrrentAudioSourceState()) {
                case 1: 
                case 4: {
                    n = 15;
                    break;
                }
                case 2: {
                    n = 5;
                    break;
                }
                case 3: {
                    n = 5;
                    break;
                }
                case 5: {
                    switch (this.getCurrentAudioSource()) {
                        case 2: 
                        case 10: {
                            n = 4;
                            break block0;
                        }
                        case 1: 
                        case 4: {
                            n = 2;
                            break block0;
                        }
                    }
                    n = 0;
                    break;
                }
                default: {
                    n = 0;
                }
            }
        }
        return n;
    }

    private int computeCurrentVideoSourceState() {
        int n;
        if (this.getCurrentAudioSource() == 0) {
            n = 5;
        } else if (this.getIsDVDRegionCodeMismatch()) {
            n = 1;
        } else {
            block0 : switch (this.getCurrrentAudioSourceState()) {
                case 1: {
                    n = 15;
                    break;
                }
                case 2: {
                    n = 5;
                    break;
                }
                case 3: {
                    n = 1;
                    break;
                }
                case 5: {
                    switch (this.getCurrentAudioSource()) {
                        case 1: 
                        case 4: {
                            n = 3;
                            break block0;
                        }
                    }
                    n = 0;
                    break;
                }
                default: {
                    n = 0;
                }
            }
        }
        return n;
    }

    private int computeCurrentBtAudioState() {
        int n;
        switch (this.getPhoneBluetoothState()) {
            case 4: {
                n = 0;
                break;
            }
            case 1: {
                n = 0;
                break;
            }
            case 2: {
                n = 0;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    private int computeRemotePlayerState() {
        int n;
        switch (this.getRemoteControlPlayerState()) {
            case 2: {
                n = 15;
                break;
            }
            case 5: {
                n = 5;
                break;
            }
            case 0: {
                n = 5;
                break;
            }
            case 4: {
                n = 1;
                break;
            }
            case 3: {
                n = 1;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    private int checkRemotePlayerStateForInfoState(int n) {
        int n2 = n == 0 && this.getConnectedMitsumiAdapter() != 0 ? this.computeRemotePlayerState() : n;
        return n2;
    }

    private int computeMediaSourceState() {
        int n;
        switch (this.getCurrentAudioSource()) {
            case 9: {
                n = 13;
                break;
            }
            case 3: {
                n = 12;
                break;
            }
            case 6: {
                n = this.computeCurrentBtAudioState();
                break;
            }
            case 1: 
            case 2: 
            case 4: 
            case 10: 
            case 11: {
                n = this.computeCurrentAudioSourceState();
                break;
            }
            case 5: {
                int n2 = this.getJukeboxDeletionState();
                if (n2 == 1 || n2 == 3) {
                    n = 15;
                    break;
                }
                n = this.computeCurrentAudioSourceState();
                break;
            }
            case 7: 
            case 14: {
                if (this.getConnectedMitsumiAdapter() == 3) {
                    n = this.checkRemotePlayerStateForInfoState(this.computeCurrentAudioSourceState());
                    break;
                }
                n = this.computeCurrentAudioSourceState();
                break;
            }
            case 8: 
            case 13: {
                n = this.computeCurrentAudioSourceState();
                break;
            }
            default: {
                n = 5;
            }
        }
        return n;
    }

    private int computeInfoStateForCurrentAudioComponent() {
        int n;
        block0 : switch (this.getCurrentAudioComponent()) {
            case 1: {
                if (this.getCurrentStationInfoBand() == 3) {
                    switch (this.getSatTunerState()) {
                        case 0: {
                            n = 26;
                            break block0;
                        }
                        case 3: {
                            n = 26;
                            break block0;
                        }
                        case 2: {
                            n = 22;
                            break block0;
                        }
                    }
                    n = 0;
                    break;
                }
                n = 0;
                break;
            }
            case 2: {
                int n2 = this.getCurrentAudioSource();
                int n3 = this.getCDContentType();
                if (!(n2 != 1 && n2 != 4 || n3 != 3 && n3 != 4)) {
                    n = this.computeCurrentVideoSourceState();
                    break;
                }
                n = this.computeMediaSourceState();
                break;
            }
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                n = 0;
                break;
            }
            default: {
                if (this.getSuppressionTimer().isRunning()) {
                    n = this.getCurrentInfoState();
                    break;
                }
                if (this.getCurrentInfoState() != 0) {
                    this.getSuppressionTimer().retrigger(2);
                    n = this.getCurrentInfoState();
                    break;
                }
                n = 0;
            }
        }
        return n;
    }

    @Override
    protected void setIsInitializing(Boolean bl) {
        this.setOpStateInitializing(bl);
        this.process(-1);
    }
}

