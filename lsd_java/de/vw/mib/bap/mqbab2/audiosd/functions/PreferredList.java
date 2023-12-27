/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

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
import de.vw.mib.bap.mqbab2.common.api.tvtuner.TvTunerService;
import de.vw.mib.bap.mqbab2.common.api.tvtuner.TvTunerServiceListener;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.PreferredList_Status;

public class PreferredList
extends Function
implements Property,
ASLAudioSDConstants,
RadioServiceListener,
TvTunerServiceListener,
SoundServiceListener {
    protected static final int[] RADIO_LISTENER_IDS = new int[]{1412};
    protected static final int[] TV_TUNER_LISTENER_IDS = new int[]{2662};
    protected static final int[] SOUND_LISTENER_IDS = new int[]{1470};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$PreferredList_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getRadioService().addRadioServiceListener(this, RADIO_LISTENER_IDS);
        this.getTvTunerService().addTvTunerServiceListener(this, TV_TUNER_LISTENER_IDS);
        this.getSoundService().addSoundServiceListener(this, SOUND_LISTENER_IDS);
        PreferredList_Status preferredList_Status = this.computePreferredListStatus();
        this.informPreferredModeStatus(preferredList_Status);
        return preferredList_Status;
    }

    protected PreferredList_Status dequeueBAPEntity() {
        return (PreferredList_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$PreferredList_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$PreferredList_Status = PreferredList.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.PreferredList_Status")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$PreferredList_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 40;
    }

    private void informPreferredModeStatus(PreferredList_Status preferredList_Status) {
        int[] nArray = new int[]{24, 36};
        this.context.updateStages(this, nArray, preferredList_Status.list == 2 ? Boolean.TRUE : Boolean.FALSE);
    }

    public void sendPreferredListStatus(PreferredList_Status preferredList_Status) {
        if (this.getDelegate().getPropertyListener(this).statusProperty(preferredList_Status, this)) {
            this.informPreferredModeStatus(preferredList_Status);
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
    }

    @Override
    public void uninitialize() {
        this.getRadioService().removeRadioServiceListener(this, RADIO_LISTENER_IDS);
        this.getTvTunerService().removeTvTunerServiceListener(this, TV_TUNER_LISTENER_IDS);
        this.getSoundService().removeSoundServiceListener(this, SOUND_LISTENER_IDS);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.statusProperty(this.computePreferredListStatus(), this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    protected void setPreferredMode(PreferredList_Status preferredList_Status) {
        preferredList_Status.list = 0;
    }

    @Override
    public void process(int n) {
        this.sendPreferredListStatus(this.computePreferredListStatus());
    }

    private PreferredList_Status computePreferredListStatus() {
        PreferredList_Status preferredList_Status = this.dequeueBAPEntity();
        this.setPreferredMode(preferredList_Status);
        return preferredList_Status;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateSoundData(SoundService soundService, int n) {
        this.process(-1);
    }

    @Override
    public void updateTvTunerData(TvTunerService tvTunerService, int n) {
        this.process(-1);
    }

    @Override
    public void updateRadioData(RadioService radioService, int n) {
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

