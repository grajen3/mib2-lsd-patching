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
import de.vw.mib.bap.mqbab2.common.api.sound.SoundService;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.CurrentVolumeExtended_Status;

public final class CurrentVolumeExtended
extends Function
implements TimerNotifier,
Property,
ASLAudioSDConstants,
SoundServiceListener {
    private boolean _volumeChangedByMfl = false;
    private int _lastGenericVolume = 0;
    private Timer _timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_NOTHING;
    private static final int TIMER_ACTION_CLOSE_VOLUME_POPUP;
    protected static final int[] SOUND_LISTENER_IDS;
    protected static final int[] SOUND_LISTENER_HMI_EVENT_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$CurrentVolumeExtended_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getSoundService().addSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getSoundService().addHMIEventListener(this, SOUND_LISTENER_HMI_EVENT_IDS);
        this._timer = this.getTimerService().createTimer(this, 350);
        return this.computeCurrentVolumeExtendedStatus();
    }

    protected CurrentVolumeExtended_Status dequeueBAPEntity() {
        return (CurrentVolumeExtended_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$CurrentVolumeExtended_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$CurrentVolumeExtended_Status = CurrentVolumeExtended.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.CurrentVolumeExtended_Status")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$CurrentVolumeExtended_Status);
    }

    @Override
    public int getFunctionId() {
        return 47;
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this._timer.stop();
        this.getSoundService().removeSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getSoundService().removeHMIEventListener(this, SOUND_LISTENER_HMI_EVENT_IDS);
    }

    @Override
    public void process(int n) {
        this.sendCurrentVolumeExtendedStatus(this.computeCurrentVolumeExtendedStatus());
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.statusProperty(this.computeCurrentVolumeExtendedStatus(), this);
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

    private boolean isVolumeChangedByMfl() {
        return this._volumeChangedByMfl;
    }

    private void setVolumeChangedByMfl(boolean bl) {
        this._volumeChangedByMfl = bl;
    }

    private int getLastGenericVolume() {
        return this._lastGenericVolume;
    }

    private void setLastGenericVolume(int n) {
        this._lastGenericVolume = n;
    }

    private void sendCurrentVolumeExtendedStatus(CurrentVolumeExtended_Status currentVolumeExtended_Status) {
        if (this.getDelegate().getPropertyListener(this).statusProperty(currentVolumeExtended_Status, this)) {
            this.setLastGenericVolume(currentVolumeExtended_Status.genericVolume);
        }
    }

    private CurrentVolumeExtended_Status computeCurrentVolumeExtendedStatus() {
        CurrentVolumeExtended_Status currentVolumeExtended_Status = this.dequeueBAPEntity();
        currentVolumeExtended_Status.genericVolume = this.getBapGenericVolume();
        currentVolumeExtended_Status.changingVolumeType = this.getBapChangingVolumeType();
        return currentVolumeExtended_Status;
    }

    private static int validateMinVolume(int n) {
        return n < 0 ? 0 : n;
    }

    private int getBapGenericVolume() {
        int n;
        SoundService soundService = this.getSoundService();
        switch (soundService.getCurrentDdsVolumeFocus()) {
            case 0: {
                n = soundService.getVolumeEntertainment();
                break;
            }
            case 1: {
                n = CurrentVolumeExtended.validateMinVolume(soundService.getVolumeNavi() - soundService.getVolumeNaviMinPopup());
                break;
            }
            case 2: {
                n = CurrentVolumeExtended.validateMinVolume(soundService.getVolumePhone() - soundService.getVolumePhoneMin());
                break;
            }
            case 3: {
                n = CurrentVolumeExtended.validateMinVolume(soundService.getVolumeTA() - soundService.getVolumeTAMin());
                break;
            }
            case 4: {
                n = CurrentVolumeExtended.validateMinVolume(soundService.getVolumeSDS() - soundService.getVolumeSDSMin());
                break;
            }
            default: {
                n = this.getLastGenericVolume();
            }
        }
        return n;
    }

    private int getBapChangingVolumeType() {
        int n;
        if (this.isVolumeChangedByMfl()) {
            switch (this.getSoundService().getCurrentDdsVolumeFocus()) {
                case 0: {
                    n = 1;
                    break;
                }
                case 1: {
                    n = 2;
                    break;
                }
                case 2: {
                    n = 8;
                    break;
                }
                case 3: {
                    n = 4;
                    break;
                }
                case 4: {
                    n = 16;
                    break;
                }
                default: {
                    n = 0;
                    break;
                }
            }
        } else {
            n = 0;
        }
        return n;
    }

    protected void mflVolumeChange() {
        this.setVolumeChangedByMfl(true);
        this.process(-1);
        this._timer.retrigger(new Integer(1));
    }

    @Override
    public void timerFired(Timer timer) {
        int n = (Integer)timer.getUserInfo();
        switch (n) {
            case 1: {
                this.setVolumeChangedByMfl(false);
                this.process(-1);
                break;
            }
        }
    }

    @Override
    public void processHMIEvent(int n) {
        if (n == 232) {
            this.mflVolumeChange();
        }
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
        SOUND_LISTENER_IDS = new int[]{1493, 1496, 1503, 1500, 1502, 1472, 1525, 1533, 1528, 1531};
        SOUND_LISTENER_HMI_EVENT_IDS = new int[]{232};
    }
}

