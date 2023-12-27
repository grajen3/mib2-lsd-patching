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
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioServiceListener;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundService;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.CurrentVolume_Status;

public final class CurrentVolume
extends Function
implements TimerNotifier,
Property,
ASLAudioSDConstants,
SoundServiceListener,
RadioServiceListener {
    private CurrentVolume_Status lastCurrentVolumeStatus;
    private Timer timer;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_CLOSE_VOLUME_POPUP;
    protected static final int[] SOUND_LISTENER_IDS;
    protected static final int[] SOUND_LISTENER_HMI_EVENT_IDS;
    protected static final int[] RADIO_LISTENER_IDS;
    private boolean volumeWasChangedRequestedByMFL;
    private boolean volumeChangeConfirmedByAudioMngmt;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$CurrentVolume_Status;

    private static int validateMinVolume(int n, int n2, int n3) {
        int n4 = n < 0 ? 0 : n;
        return (int)((float)n4 / (float)n2 * (float)n3);
    }

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getSoundService().addSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getSoundService().addHMIEventListener(this, SOUND_LISTENER_HMI_EVENT_IDS);
        this.getRadioService().addRadioServiceListener(this, RADIO_LISTENER_IDS);
        this.timer = this.getTimerService().createTimer(this, 350);
        this.lastCurrentVolumeStatus = this.computeCurrentVolumeStatus();
        return this.lastCurrentVolumeStatus;
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 19: {
                this.setMuteMsgWasSend((Boolean)object);
                break;
            }
        }
    }

    protected CurrentVolume_Status dequeueBAPEntity() {
        return (CurrentVolume_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$CurrentVolume_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$CurrentVolume_Status = CurrentVolume.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.CurrentVolume_Status")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$CurrentVolume_Status);
    }

    @Override
    public int getFunctionId() {
        return 18;
    }

    private void setVolumes(CurrentVolume_Status currentVolume_Status) {
        SoundService soundService = this.getSoundService();
        int n = soundService.getVolumeEntertainmentMax();
        currentVolume_Status.entertainmentVolume = soundService.getVolumeEntertainment();
        currentVolume_Status.navigationVolume = CurrentVolume.validateMinVolume(soundService.getVolumeNavi() - soundService.getVolumeNaviMinPopup(), soundService.getVolumeNaviMaxPopup(), n);
        currentVolume_Status.taVolume = CurrentVolume.validateMinVolume(soundService.getVolumeTA() - soundService.getVolumeTAMin(), soundService.getVolumeTAMax(), n);
        currentVolume_Status.phoneVolume = CurrentVolume.validateMinVolume(soundService.getVolumePhone() - soundService.getVolumePhoneMin(), soundService.getVolumePhoneMax(), n);
        currentVolume_Status.sdsVolume = CurrentVolume.validateMinVolume(soundService.getVolumeSDS() - soundService.getVolumeSDSMin(), soundService.getVolumeSDSMax(), n);
    }

    private static int getBapVolumeFromDdsFocus(int n, CurrentVolume_Status currentVolume_Status) {
        int n2;
        if (currentVolume_Status == null) {
            n2 = 0;
        } else {
            switch (n) {
                case 0: {
                    n2 = currentVolume_Status.entertainmentVolume;
                    break;
                }
                case 1: {
                    n2 = currentVolume_Status.navigationVolume;
                    break;
                }
                case 2: {
                    n2 = currentVolume_Status.phoneVolume;
                    break;
                }
                case 3: {
                    n2 = currentVolume_Status.taVolume;
                    break;
                }
                case 4: {
                    n2 = currentVolume_Status.sdsVolume;
                    break;
                }
                default: {
                    n2 = 0;
                }
            }
        }
        return n2;
    }

    private static int getBapChangingVolumeTypeFromDdsFocus(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 1;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            case 2: {
                n2 = 8;
                break;
            }
            case 3: {
                n2 = 4;
                break;
            }
            case 4: {
                n2 = 16;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private void setChangingValueType(CurrentVolume_Status currentVolume_Status) {
        if (this.lastCurrentVolumeStatus == null || !this.volumeWasChangedRequestedByMFL) {
            currentVolume_Status.changingVolumeType = 0;
        } else {
            int n = this.getSoundService().getCurrentDdsVolumeFocus();
            if (this.volumeWasChangedRequestedByMFL || CurrentVolume.getBapVolumeFromDdsFocus(n, this.lastCurrentVolumeStatus) != CurrentVolume.getBapVolumeFromDdsFocus(n, currentVolume_Status)) {
                currentVolume_Status.changingVolumeType = CurrentVolume.getBapChangingVolumeTypeFromDdsFocus(n);
            }
            if (currentVolume_Status.changingVolumeType == 0 && n != 5) {
                currentVolume_Status.changingVolumeType = this.lastCurrentVolumeStatus.changingVolumeType;
            }
        }
    }

    private void sendCurrentVolumeStatus(CurrentVolume_Status currentVolume_Status) {
        if (this.getDelegate().getPropertyListener(this).statusProperty(currentVolume_Status, this)) {
            this.lastCurrentVolumeStatus = currentVolume_Status;
            this.volumeChangeConfirmedByAudioMngmt = true;
        }
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
        this.volumeChangeConfirmedByAudioMngmt = false;
        this.volumeChangeConfirmedByAudioMngmt = false;
    }

    @Override
    public void uninitialize() {
        this.timer.stop();
        this.getSoundService().removeSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getSoundService().removeHMIEventListener(this, SOUND_LISTENER_HMI_EVENT_IDS);
        this.getRadioService().removeRadioServiceListener(this, RADIO_LISTENER_IDS);
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

    protected void mflVolumeChange() {
        this.volumeWasChangedRequestedByMFL = true;
        this.volumeChangeConfirmedByAudioMngmt = false;
        this.timer.retrigger(new Integer(1));
    }

    @Override
    public void timerFired(Timer timer) {
        int n = (Integer)timer.getUserInfo();
        switch (n) {
            case 1: {
                if (!this.volumeChangeConfirmedByAudioMngmt) {
                    this.volumeChangeConfirmedByAudioMngmt = true;
                    this.process(-1);
                    timer.retrigger(new Integer(1));
                    break;
                }
                if (!this.volumeWasChangedRequestedByMFL) break;
                this.volumeWasChangedRequestedByMFL = false;
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

    @Override
    public void processHMIEvent(int n) {
        if (n == 232) {
            this.mflVolumeChange();
        }
    }

    @Override
    public void updateRadioData(RadioService radioService, int n) {
        this.process(-1);
    }

    @Override
    public void updateSoundData(SoundService soundService, int n) {
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
        SOUND_LISTENER_IDS = new int[]{1493, 1496, 1503, 1500, 1502, 1472, 1522, 1525, 1533, 1528, 1531};
        SOUND_LISTENER_HMI_EVENT_IDS = new int[]{232};
        RADIO_LISTENER_IDS = new int[]{1339};
    }
}

