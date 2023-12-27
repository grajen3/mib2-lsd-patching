/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.common.api.exbox.ExboxService;
import de.vw.mib.bap.mqbab2.common.api.exbox.ExboxServiceListener;
import de.vw.mib.bap.mqbab2.common.api.media.MediaService;
import de.vw.mib.bap.mqbab2.common.api.media.MediaServiceListener;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundService;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ActiveSourceName_Status;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SourceList_Data;

public class ActiveSourceName
extends Function
implements Property,
ASLAudioSDConstants,
SoundServiceListener,
MediaServiceListener,
ExboxServiceListener {
    private FsgArrayListComplete fullSourceList = null;
    private int activeSourceListReference = 0;
    private static final int INVALID_SOURCELIST_REFERENCE;
    protected static final int[] SOUND_LISTENER_IDS;
    protected static final int[] MEDIA_LISTENER_IDS;
    protected static final int[] EXBOX_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$ActiveSourceName_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getSoundService().addSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getMediaService().addMediaServiceListener(this, MEDIA_LISTENER_IDS);
        this.getExboxService().addExboxServiceListener(this, EXBOX_LISTENER_IDS);
        return this.computeActiveSourceNameStatus();
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 16: {
                this.setReportedSourceListReference((Integer)object);
                break;
            }
            case 32: {
                this.setFullSourceList((FsgArrayListComplete)object);
                break;
            }
        }
    }

    protected final ActiveSourceName_Status dequeueBAPEntity() {
        return (ActiveSourceName_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$ActiveSourceName_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$ActiveSourceName_Status = ActiveSourceName.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ActiveSourceName_Status")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$ActiveSourceName_Status);
    }

    @Override
    public int getFunctionId() {
        return 17;
    }

    private String getAvdcActiveSourceName() {
        SourceList_Data sourceList_Data = this.activeSourceListReference == 0 || this.fullSourceList == null ? null : (SourceList_Data)this.fullSourceList.getElement(this.activeSourceListReference);
        String string = sourceList_Data != null ? sourceList_Data.name.toString() : "";
        return string;
    }

    private String retrieveActiveSourceName() {
        String string;
        block0 : switch (this.getSoundService().getCurrentAudioComponent()) {
            case 2: 
            case 3: {
                switch (this.getMediaService().getCurrentAudioSource()) {
                    case 0: 
                    case 1: 
                    case 3: 
                    case 4: 
                    case 9: {
                        string = "";
                        break block0;
                    }
                    case 7: 
                    case 14: {
                        string = "ipod";
                        break block0;
                    }
                }
                string = this.getAvdcActiveSourceName();
                break;
            }
            case 4: {
                switch (this.getExboxService().getExboxActiveSource()) {
                    case 40: {
                        string = "DMB";
                        break block0;
                    }
                    case 22: {
                        string = "BT-Audio";
                        break block0;
                    }
                    case 21: {
                        string = "BT-Audio";
                        break block0;
                    }
                }
                string = "";
                break;
            }
            default: {
                string = "";
            }
        }
        return string;
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
        this.getSoundService().removeSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getMediaService().removeMediaServiceListener(this, MEDIA_LISTENER_IDS);
        this.getExboxService().removeExboxServiceListener(this, EXBOX_LISTENER_IDS);
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
        ActiveSourceName_Status activeSourceName_Status = this.computeActiveSourceNameStatus();
        this.getDelegate().getPropertyListener(this).statusProperty(activeSourceName_Status, this);
    }

    private ActiveSourceName_Status computeActiveSourceNameStatus() {
        ActiveSourceName_Status activeSourceName_Status = this.dequeueBAPEntity();
        activeSourceName_Status.sourceName.setContent(this.retrieveActiveSourceName());
        return activeSourceName_Status;
    }

    protected void setReportedSourceListReference(Integer n) {
        this.activeSourceListReference = n;
        this.process(-1);
    }

    protected void setFullSourceList(FsgArrayListComplete fsgArrayListComplete) {
        boolean bl = this.fullSourceList != null;
        this.fullSourceList = fsgArrayListComplete;
        if (bl) {
            this.process(-1);
        }
    }

    @Override
    public void processHMIEvent(int n) {
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
    public void updateExboxData(ExboxService exboxService, int n) {
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
        SOUND_LISTENER_IDS = new int[]{1470};
        MEDIA_LISTENER_IDS = new int[]{8};
        EXBOX_LISTENER_IDS = new int[]{-2012020608};
    }
}

