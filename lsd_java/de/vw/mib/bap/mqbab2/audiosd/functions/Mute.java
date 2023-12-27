/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioServiceListener;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundService;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.bap.mqbab2.common.api.tvtuner.TvTunerService;
import de.vw.mib.bap.mqbab2.common.api.tvtuner.TvTunerServiceListener;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.Mute_SetGet;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.Mute_Status;

public class Mute
extends Function
implements Property,
ASLAudioSDConstants,
PhoneServiceListener,
SoundServiceListener,
RadioServiceListener,
SystemServiceListener,
TvTunerServiceListener {
    protected static final int[] PHONE_LISTENER_IDS = new int[]{1148};
    protected static final int[] SOUND_LISTENER_IDS = new int[]{1509, 1470};
    protected static final int[] RADIO_LISTENER_IDS = new int[]{533079040, 516301824, 1339, 1356, 1324, 1291, 1456};
    protected static final int[] SYSTEM_LISTENER_IDS = new int[]{1652};
    protected static final int[] TV_TUNER_LISTENER_IDS = new int[]{2573};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$Mute_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        this.getSoundService().addSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getRadioService().addRadioServiceListener(this, RADIO_LISTENER_IDS);
        this.getSystemService().addSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getTvTunerService().addTvTunerServiceListener(this, TV_TUNER_LISTENER_IDS);
        return this.computeMuteStatus();
    }

    protected Mute_Status dequeueBAPEntity() {
        return (Mute_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$Mute_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$Mute_Status = Mute.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.Mute_Status")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$Mute_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    protected void setMuteMsgWasSend(Boolean bl) {
        int[] nArray = new int[]{18};
        this.context.updateStages(this, nArray, bl);
    }

    @Override
    public int getFunctionId() {
        return 19;
    }

    private void setGetMuteProperty(Mute_SetGet mute_SetGet, PropertyListener propertyListener) {
        Mute_Status mute_Status = this.computeMuteStatus();
        if (mute_Status.muteState.mutingDueToActivePhoneCall == mute_SetGet.muteState.mutingDueToActivePhoneCall || this.getSystemService().isComponentProtectionActive() == 1 || this.getSoundService().getCurrentAmplifierState() == 1) {
            propertyListener.statusProperty(mute_Status, this);
        } else {
            boolean bl;
            boolean bl2;
            SoundService soundService = this.getSoundService();
            boolean bl3 = bl2 = soundService.getMuteActive() == 1;
            if (bl2 != mute_SetGet.muteState.mutingDueToActivePhoneCall) {
                soundService.setMuteState();
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
        this.setMuteMsgWasSend(Boolean.TRUE);
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
        this.getPhoneService().removePhoneServiceListener(this, PHONE_LISTENER_IDS);
        this.getSoundService().removeSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getRadioService().removeRadioServiceListener(this, RADIO_LISTENER_IDS);
        this.getSystemService().removeSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getTvTunerService().removeTvTunerServiceListener(this, TV_TUNER_LISTENER_IDS);
    }

    @Override
    public void process(int n) {
        this.sendMuteStatus(this.computeMuteStatus());
    }

    protected void setIbocState(Mute_Status mute_Status) {
        mute_Status.muteState.ibocIsNotInSyncDigitalSignalCannotBeDecoded = false;
        mute_Status.muteState.ibocMutingLowSignal = false;
    }

    protected void setSdarsMuting(Mute_Status mute_Status) {
        mute_Status.muteState.sdarsMutingLowSignal = false;
    }

    private Mute_Status computeMuteStatus() {
        Mute_Status mute_Status = this.dequeueBAPEntity();
        SoundService soundService = this.getSoundService();
        mute_Status.muteState.mutingDueToActivePhoneCall = soundService.getMuteActive() == 1;
        int n = soundService.getCurrentAudioComponent();
        if (n == 1) {
            RadioService radioService = this.getRadioService();
            int n2 = radioService.getCurrentStationBand();
            if (n2 == 2) {
                mute_Status.muteState.dabMutingLowSignal = radioService.getDABEnsembleState() == 1 || radioService.getDABServiceState() == 1;
            } else if (n2 == 1 || n2 == 0) {
                this.setIbocState(mute_Status);
            } else {
                this.setSdarsMuting(mute_Status);
            }
        } else if (n == 5) {
            switch (this.getTvTunerService().getCurrentTvMuteState()) {
                case 2: 
                case 3: {
                    mute_Status.muteState.dvbTvMutingLowSignal = true;
                    break;
                }
                default: {
                    mute_Status.muteState.dvbTvMutingLowSignal = false;
                }
            }
        }
        mute_Status.muteState.mutingDueToActivePhoneCall = this.getPhoneService().getCurrentPhoneCallCount() > 0;
        return mute_Status;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateTvTunerData(TvTunerService tvTunerService, int n) {
        this.process(-1);
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
    public void updateSoundData(SoundService soundService, int n) {
        this.process(-1);
    }

    @Override
    public void updatePhoneData(PhoneService phoneService, int n) {
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
}

