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
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ReceptionListType_Status;

public final class ReceptionListType
extends Function
implements Property,
ASLAudioSDConstants,
RadioServiceListener,
SoundServiceListener {
    protected static final int[] RADIO_LISTENER_IDS = new int[]{1324};
    protected static final int[] SOUND_LISTENER_IDS = new int[]{1470};
    private int lastReceptionListType = 0;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$ReceptionListType_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getRadioService().addRadioServiceListener(this, RADIO_LISTENER_IDS);
        this.getSoundService().addSoundServiceListener(this, SOUND_LISTENER_IDS);
        return this.computeReceptionListTypeStatus();
    }

    protected ReceptionListType_Status dequeueBAPEntity() {
        return (ReceptionListType_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$ReceptionListType_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$ReceptionListType_Status = ReceptionListType.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ReceptionListType_Status")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$ReceptionListType_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 31;
    }

    private void setReceptionListTypeStatusData(ReceptionListType_Status receptionListType_Status) {
        int n = this.getSoundService().getCurrentAudioComponent();
        if (n == 1) {
            switch (this.getRadioService().getCurrentStationBand()) {
                case 1: {
                    receptionListType_Status.type = 1;
                    break;
                }
                case 0: {
                    receptionListType_Status.type = 2;
                    break;
                }
                case 2: {
                    receptionListType_Status.type = 3;
                    break;
                }
                case 3: {
                    receptionListType_Status.type = 4;
                    break;
                }
                default: {
                    receptionListType_Status.type = 0;
                    break;
                }
            }
        } else {
            receptionListType_Status.type = n == 5 ? 6 : this.lastReceptionListType;
        }
    }

    private void sendReceptionListStatus(ReceptionListType_Status receptionListType_Status) {
        if (this.lastReceptionListType != receptionListType_Status.type) {
            this.getDelegate().getPropertyListener(this).statusProperty(receptionListType_Status, this);
            this.lastReceptionListType = receptionListType_Status.type;
        }
    }

    private ReceptionListType_Status computeReceptionListTypeStatus() {
        ReceptionListType_Status receptionListType_Status = this.dequeueBAPEntity();
        this.setReceptionListTypeStatusData(receptionListType_Status);
        return receptionListType_Status;
    }

    @Override
    public void process(int n) {
        this.sendReceptionListStatus(this.computeReceptionListTypeStatus());
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
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
        this.getRadioService().removeRadioServiceListener(this, RADIO_LISTENER_IDS);
        this.getSoundService().removeSoundServiceListener(this, SOUND_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
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
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateSoundData(SoundService soundService, int n) {
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

