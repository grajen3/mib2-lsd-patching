/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.common.api.media.MediaService;
import de.vw.mib.bap.mqbab2.common.api.media.MediaServiceListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioServiceListener;
import de.vw.mib.bap.mqbab2.common.api.smartphoneintegration.SmartphoneIntegrationService;
import de.vw.mib.bap.mqbab2.common.api.smartphoneintegration.SmartphoneIntegrationServiceListener;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundService;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.bap.mqbab2.common.api.timer.TimerService;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.InfoStates_Status;

public final class InfoStates
extends Function
implements TimerNotifier,
Property,
ASLAudioSDConstants,
SystemServiceListener,
RadioServiceListener,
MediaServiceListener,
SoundServiceListener,
PhoneServiceListener,
SmartphoneIntegrationServiceListener {
    private int lastInfoStatesStatus = 0;
    private boolean autoStoreInProgress = false;
    private boolean remoteControlModeActive = false;
    private int currentLoadingSource = 0;
    private boolean currentLoadingSourceFromRadio;
    private static final int LOADING_NO_SOURCE;
    private static final int LOADING_SOURCE_CD_DVD;
    private static final int LOADING_SOURCE_SD1;
    private static final int LOADING_SOURCE_SD2;
    private static final int LOADING_SOURCE_USB;
    private Timer shortTimer = null;
    private Timer longTimer = null;
    private Timer suppressionTimer;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_UPDATE_LONG_TIME;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_RECOMPUTE_STATE;
    private static final int TIMER_ACTION_RECOMPUTE_STATE_AFTER_SUPPRESSION;
    private static final int TIMER_UPDATE_SUPPRESSION_TIME;
    protected static final int[] MEDIA_LISTENER_IDS;
    protected static final int[] SYSTEM_LISTENER_IDS;
    protected static final int[] SYSTEM_LISTENER_HMI_EVENT_IDS;
    protected static final int[] RADIO_LISTENER_IDS;
    protected static final int[] RADIO_LISTENER_HMI_EVENT_IDS;
    protected static final int[] SOUND_LISTENER_IDS;
    protected static final int[] PHONE_LISTENER_IDS;
    protected static final int[] SMARTPHONE_INTEGRATION_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$InfoStates_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getMediaService().addMediaServiceListener(this, MEDIA_LISTENER_IDS);
        this.getSystemService().addSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getSystemService().addHMIEventListener(this, SYSTEM_LISTENER_HMI_EVENT_IDS);
        this.getRadioService().addRadioServiceListener(this, RADIO_LISTENER_IDS);
        this.getRadioService().addHMIEventListener(this, RADIO_LISTENER_HMI_EVENT_IDS);
        this.getSoundService().addSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        this.getSmartphoneIntegrationService().addSmartphoneIntegrationServiceListener(this, SMARTPHONE_INTEGRATION_LISTENER_IDS);
        TimerService timerService = this.getTimerService();
        this.shortTimer = timerService.createTimer(this, 3000);
        this.longTimer = timerService.createTimer(this, 6000);
        this.suppressionTimer = timerService.createTimer(this, 2000);
        return new InfoStates_Status();
    }

    protected InfoStates_Status dequeueBAPEntity() {
        return (InfoStates_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$InfoStates_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$InfoStates_Status = InfoStates.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.InfoStates_Status")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$InfoStates_Status);
    }

    protected void setAutostoreRunning(Boolean bl) {
        int[] nArray = new int[]{21, 22};
        this.context.updateStages(this, nArray, bl);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 30;
    }

    private void sendInfoStatesStatus(int n) {
        if (this.lastInfoStatesStatus != n) {
            this.lastInfoStatesStatus = n;
            InfoStates_Status infoStates_Status = this.dequeueBAPEntity();
            infoStates_Status.states = n;
            this.getDelegate().getPropertyListener(this).statusProperty(infoStates_Status, this);
        }
    }

    private boolean isImportRunningForCurrentAudioSource() {
        boolean bl;
        MediaService mediaService = this.getMediaService();
        int n = mediaService.getCurrentAudioSource();
        switch (mediaService.getCurrentImportSource()) {
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
        return bl && mediaService.getCurrentImportState() == 3;
    }

    private int computeGenericCurrentAudioSourceState() {
        int n;
        switch (this.getMediaService().getCurrrentAudioSourceState()) {
            case 4: 
            case 6: {
                n = 9;
                break;
            }
            case 1: {
                if (this.suppressionTimer.isRunning() && this.lastInfoStatesStatus != 255) {
                    n = 0;
                    break;
                }
                if (this.lastInfoStatesStatus != 9 && this.lastInfoStatesStatus != 255) {
                    this.suppressionTimer.retrigger(new Integer(2));
                    n = 0;
                    break;
                }
                n = 9;
                break;
            }
            case 2: {
                n = 34;
                break;
            }
            case 3: {
                n = 8;
                break;
            }
            case 5: {
                this.suppressionTimer.stop();
                n = 6;
                break;
            }
            default: {
                this.suppressionTimer.stop();
                n = 0;
            }
        }
        return n;
    }

    private int computeCurrentAudioSourceState() {
        int n = this.isImportRunningForCurrentAudioSource() ? 46 : this.computeGenericCurrentAudioSourceState();
        return n;
    }

    private int computeCurrentVideoSourceState() {
        MediaService mediaService = this.getMediaService();
        int n = mediaService.getCurrentAudioSource() == 0 ? 6 : (mediaService.isDVDRegionCodeMismatched() ? 35 : this.computeGenericCurrentAudioSourceState());
        return n;
    }

    private int computeRemotePlayerState() {
        int n;
        switch (this.getMediaService().getRemoteControlPlayerState()) {
            case 2: {
                n = 9;
                break;
            }
            case 5: {
                n = 34;
                break;
            }
            case 0: {
                n = 39;
                break;
            }
            case 4: {
                n = 1;
                break;
            }
            case 3: {
                n = 65;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    private int checkRemotePlayerStateForInfoState(int n) {
        int n2 = n == 0 && this.getMediaService().getConnectedMitsumiAdapter() != 0 ? this.computeRemotePlayerState() : n;
        return n2;
    }

    private int computeMediaSourceState() {
        int n;
        MediaService mediaService = this.getMediaService();
        switch (mediaService.getCurrentAudioSource()) {
            case 9: {
                n = 0;
                break;
            }
            case 3: {
                n = 0;
                break;
            }
            case 6: {
                n = this.computeCurrentBtAudioState();
                break;
            }
            case 1: 
            case 2: 
            case 4: 
            case 10: {
                n = this.computeCurrentAudioSourceState();
                break;
            }
            case 11: {
                n = this.computeCurrentWlanAudioState();
                break;
            }
            case 5: {
                int n2 = mediaService.getJukeboxDeletionState();
                if (n2 == 1 || n2 == 3) {
                    n = 59;
                    break;
                }
                n = this.computeCurrentAudioSourceState();
                break;
            }
            case 7: 
            case 14: {
                if (mediaService.getConnectedMitsumiAdapter() == 3) {
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
                n = 6;
            }
        }
        return n;
    }

    private int computeCurrentWlanAudioState() {
        int n = this.getMediaService().getCurrrentAudioSourceState() == 5 ? 51 : (!this.getMediaService().getWlanDeviceConnected() ? 49 : this.computeCurrentAudioSourceState());
        return n;
    }

    private int computeCurrentBtAudioState() {
        int n;
        switch (this.getPhoneService().getBluetoothState()) {
            case 4: {
                n = 42;
                break;
            }
            case 1: {
                n = 41;
                break;
            }
            case 2: {
                n = 40;
                break;
            }
            default: {
                n = this.getMediaService().getCurrrentAudioSourceState() == 5 ? 43 : 0;
            }
        }
        return n;
    }

    private int computeInfoStateForCurrentAudioComponent() {
        int n;
        MediaService mediaService = this.getMediaService();
        RadioService radioService = this.getRadioService();
        block0 : switch (this.getSoundService().getCurrentAudioComponent()) {
            case 1: {
                if (radioService.isTrafficMessageRecording()) {
                    n = 32;
                    break;
                }
                if (radioService.getCurrentStationBand() == 3) {
                    switch (radioService.getSatTunerState()) {
                        case 0: {
                            n = 29;
                            break block0;
                        }
                        case 3: {
                            n = 56;
                            break block0;
                        }
                        case 2: {
                            n = 19;
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
                int n2 = mediaService.getCurrentAudioSource();
                int n3 = mediaService.getCDContentType();
                if (!(n2 != 1 && n2 != 4 || n3 != 3 && n3 != 4)) {
                    n = this.computeCurrentVideoSourceState();
                    break;
                }
                n = this.computeMediaSourceState();
                break;
            }
            case 6: {
                switch (this.getSmartphoneIntegrationService().getSmarphoneIntegrationActiveConnectionType()) {
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: {
                        n = 0;
                        break block0;
                    }
                }
                n = 39;
                break;
            }
            case 3: 
            case 4: 
            case 5: {
                n = 0;
                break;
            }
            default: {
                if (this.suppressionTimer.isRunning()) {
                    n = this.lastInfoStatesStatus;
                    break;
                }
                if (this.lastInfoStatesStatus != 0) {
                    this.suppressionTimer.retrigger(new Integer(2));
                    n = this.lastInfoStatesStatus;
                    break;
                }
                n = 0;
            }
        }
        return n;
    }

    private int computeInfoState() {
        int n = this.getSystemService().getSystemOnOffState();
        int n2 = n == 3 || this.remoteControlModeActive ? 30 : (n == 4 ? 31 : (this.autoStoreInProgress && this.getSoundService().getCurrentAudioComponent() == 1 ? 28 : this.computeInfoStateForCurrentAudioComponent()));
        return n2;
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void requestAcknowledge() {
        this.setAutostoreRunning(this.lastInfoStatesStatus == 28 ? Boolean.TRUE : Boolean.FALSE);
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.shortTimer.stop();
        this.longTimer.stop();
        this.suppressionTimer.stop();
        this.getMediaService().removeMediaServiceListener(this, MEDIA_LISTENER_IDS);
        this.getSystemService().removeSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getSystemService().removeHMIEventListener(this, SYSTEM_LISTENER_HMI_EVENT_IDS);
        this.getRadioService().removeRadioServiceListener(this, RADIO_LISTENER_IDS);
        this.getRadioService().removeHMIEventListener(this, RADIO_LISTENER_HMI_EVENT_IDS);
        this.getSoundService().removeSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getPhoneService().removePhoneServiceListener(this, PHONE_LISTENER_IDS);
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
    public void process(int n) {
        if (!this.shortTimer.isRunning() && !this.longTimer.isRunning()) {
            this.sendInfoStatesStatus(this.computeInfoState());
        }
    }

    protected void tunerInitialAutostoreFinished() {
        this.autoStoreInProgress = false;
        this.stopAllTimers();
        this.process(-1);
    }

    protected void tunerInitialAutoStoreCanceled() {
        this.autoStoreInProgress = false;
        this.stopAllTimers();
        this.process(-1);
    }

    protected void tunerInitialAutoStoreStarted() {
        this.autoStoreInProgress = true;
        this.stopAllTimers();
        this.process(-1);
    }

    protected void systemCdDvdLoading() {
        this.sendInfoStatesStatus(9);
        this.startLongTimer(0, 1);
        this.currentLoadingSource = 1;
        this.currentLoadingSourceFromRadio = this.getSoundService().getCurrentAudioComponent() == 1;
    }

    protected void systemCdDvdLoadingFinished() {
        if (this.currentLoadingSource == 1) {
            this.stopLongTimerAndProcess();
        }
    }

    protected void systemSD1Loading() {
        this.sendInfoStatesStatus(9);
        this.startLongTimer(0, 1);
        this.currentLoadingSource = 2;
        this.currentLoadingSourceFromRadio = this.getSoundService().getCurrentAudioComponent() == 1;
    }

    protected void systemSD1LoadingFinished() {
        if (this.currentLoadingSource == 2) {
            this.stopLongTimerAndProcess();
        }
    }

    protected void systemSD2Loading() {
        this.sendInfoStatesStatus(9);
        this.startLongTimer(0, 1);
        this.currentLoadingSource = 3;
        this.currentLoadingSourceFromRadio = this.getSoundService().getCurrentAudioComponent() == 1;
    }

    protected void systemSD2LoadingFinished() {
        if (this.currentLoadingSource == 3) {
            this.stopLongTimerAndProcess();
        }
    }

    protected void systemUsbLoading() {
        this.sendInfoStatesStatus(9);
        this.startLongTimer(0, 1);
        this.currentLoadingSource = 4;
        this.currentLoadingSourceFromRadio = this.getSoundService().getCurrentAudioComponent() == 1;
    }

    protected void systemUsbLoadingFinished() {
        if (this.currentLoadingSource == 4) {
            this.stopLongTimerAndProcess();
        }
    }

    protected void systemCdDvdDeviceError() {
        this.sendInfoStatesStatus(5);
        this.startShortTimer(1);
    }

    protected void systemCdDvdReadError() {
        this.sendInfoStatesStatus(8);
        this.startShortTimer(1);
    }

    protected void systemCdTemperatureWarning() {
        this.sendInfoStatesStatus(11);
        this.startShortTimer(1);
    }

    protected void systemSD1DeviceError() {
        this.sendInfoStatesStatus(5);
        this.startShortTimer(1);
    }

    protected void systemSD1ReadError() {
        this.sendInfoStatesStatus(8);
        this.startShortTimer(1);
    }

    protected void systemSD2DeviceError() {
        this.sendInfoStatesStatus(5);
        this.startShortTimer(1);
    }

    protected void systemSD2ReadError() {
        this.sendInfoStatesStatus(8);
        this.startShortTimer(1);
    }

    protected void systemUSBReadError() {
        this.sendInfoStatesStatus(8);
        this.startShortTimer(1);
    }

    protected void systemUsbDeviceError() {
        this.sendInfoStatesStatus(5);
        this.startShortTimer(1);
    }

    protected void systemCdDvdEjected() {
        this.sendInfoStatesStatus(10);
        this.startShortTimer(1);
    }

    protected void systemStartDiag() {
        this.remoteControlModeActive = true;
        this.process(-1);
    }

    protected void systemEndDiag() {
        this.remoteControlModeActive = false;
        this.process(-1);
    }

    @Override
    public void timerFired(Timer timer) {
        int n = (Integer)timer.getUserInfo();
        switch (n) {
            case 1: {
                this.process(-1);
                break;
            }
            case 2: {
                this.lastInfoStatesStatus = 255;
                this.process(-1);
                break;
            }
        }
    }

    private void stopAllTimers() {
        this.shortTimer.stop();
        this.longTimer.stop();
    }

    private void startShortTimer(int n) {
        this.longTimer.stop();
        this.shortTimer.retrigger(new Integer(n));
    }

    private void startLongTimer(int n, int n2) {
        this.longTimer.retrigger(new Integer(n2));
        this.shortTimer.retrigger(new Integer(n));
    }

    private void stopLongTimerAndProcess() {
        if (!this.shortTimer.isRunning()) {
            this.currentLoadingSource = 0;
            if (this.getSoundService().getCurrentAudioComponent() != 1 || !this.currentLoadingSourceFromRadio) {
                this.longTimer.stop();
                this.process(-1);
            }
        } else {
            this.longTimer.stop();
            this.shortTimer.setUserInfo(new Integer(1));
        }
    }

    @Override
    public void processHMIEvent(int n) {
        switch (n) {
            case 216: {
                this.tunerInitialAutostoreFinished();
                break;
            }
            case 202: {
                this.tunerInitialAutoStoreCanceled();
                break;
            }
            case 201: {
                this.tunerInitialAutoStoreStarted();
                break;
            }
            case 401: {
                this.systemCdDvdReadError();
                break;
            }
            case 389: {
                this.systemCdTemperatureWarning();
                break;
            }
            case 407: {
                this.systemCdDvdDeviceError();
                break;
            }
            case 404: {
                this.systemCdDvdLoading();
                break;
            }
            case 402: {
                this.systemCdDvdLoadingFinished();
                break;
            }
            case 415: {
                this.systemSD1DeviceError();
                break;
            }
            case 416: {
                this.systemSD1Loading();
                break;
            }
            case 417: {
                this.systemSD1LoadingFinished();
                break;
            }
            case 418: {
                this.systemSD1ReadError();
                break;
            }
            case 366: {
                this.systemSD2DeviceError();
                break;
            }
            case 367: {
                this.systemSD2Loading();
                break;
            }
            case 368: {
                this.systemSD2LoadingFinished();
                break;
            }
            case 369: {
                this.systemSD2ReadError();
                break;
            }
            case 383: {
                this.systemUSBReadError();
                break;
            }
            case 381: {
                this.systemUsbLoading();
                break;
            }
            case 382: {
                this.systemUsbLoadingFinished();
                break;
            }
            case 380: {
                this.systemUsbDeviceError();
                break;
            }
            case 547: {
                this.systemUSBReadError();
                break;
            }
            case 545: {
                this.systemUsbLoading();
                break;
            }
            case 546: {
                this.systemUsbLoadingFinished();
                break;
            }
            case 544: {
                this.systemUsbDeviceError();
                break;
            }
            case 406: {
                this.systemCdDvdEjected();
                break;
            }
            case 376: {
                this.systemStartDiag();
                break;
            }
            case 393: {
                this.systemEndDiag();
                break;
            }
        }
    }

    @Override
    public void updateSystemData(SystemService systemService, int n) {
        this.process(-1);
    }

    @Override
    public void updateRadioData(RadioService radioService, int n) {
        this.process(-1);
    }

    @Override
    public void updateMediaData(MediaService mediaService, int n) {
        this.process(-1);
    }

    @Override
    public void updateSoundData(SoundService soundService, int n) {
        this.process(-1);
    }

    @Override
    public void updatePhoneData(PhoneService phoneService, int n) {
        this.process(-1);
    }

    @Override
    public void updateSmartphoneIntegrationData(SmartphoneIntegrationService smartphoneIntegrationService, int n) {
        this.process(-1);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        MEDIA_LISTENER_IDS = new int[]{29, 30, 7, 9, 8, 11, 2734, 3520, 152, 2735};
        SYSTEM_LISTENER_IDS = new int[]{1632};
        SYSTEM_LISTENER_HMI_EVENT_IDS = new int[]{401, 389, 407, 404, 402, 415, 416, 417, 418, 366, 367, 368, 369, 383, 381, 382, 380, 547, 545, 546, 544, 406, 376, 393};
        RADIO_LISTENER_IDS = new int[]{1449, 1324, 1291};
        RADIO_LISTENER_HMI_EVENT_IDS = new int[]{201, 216, 202};
        SOUND_LISTENER_IDS = new int[]{1470};
        PHONE_LISTENER_IDS = new int[]{2908};
        SMARTPHONE_INTEGRATION_LISTENER_IDS = new int[]{1114057728};
    }
}

