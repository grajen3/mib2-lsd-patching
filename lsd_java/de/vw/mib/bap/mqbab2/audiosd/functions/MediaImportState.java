/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.common.api.media.MediaService;
import de.vw.mib.bap.mqbab2.common.api.media.MediaServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaImportState_Status;

public final class MediaImportState
extends Function
implements Property,
ASLAudioSDConstants,
MediaServiceListener {
    private static final int BAP_IMPORT_STATE_UNKNOWN_PROGRESS;
    protected static final int[] MEDIA_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaImportState_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getMediaService().addMediaServiceListener(this, MEDIA_LISTENER_IDS);
        return this.computeMediaImportStateStatus();
    }

    protected MediaImportState_Status dequeueBAPEntity() {
        return (MediaImportState_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaImportState_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaImportState_Status = MediaImportState.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaImportState_Status")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$MediaImportState_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 46;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getMediaService().removeMediaServiceListener(this, MEDIA_LISTENER_IDS);
    }

    @Override
    public void process(int n) {
        this.getDelegate().getPropertyListener(this).statusProperty(this.computeMediaImportStateStatus(), this);
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

    private MediaImportState_Status computeMediaImportStateStatus() {
        MediaImportState_Status mediaImportState_Status = this.dequeueBAPEntity();
        mediaImportState_Status.sourceType = this.getBapMediaImportSourceType();
        mediaImportState_Status.state = this.getBapMediaImportState();
        mediaImportState_Status.progress = this.getBapMediaImportProgress();
        return mediaImportState_Status;
    }

    private boolean isMediaImportRunning() {
        MediaService mediaService = this.getMediaService();
        return mediaService.getCurrentImportSource() != 0 && mediaService.getCurrentImportState() == 3;
    }

    private int getBapMediaImportState() {
        int n = !this.isMediaImportRunning() ? 0 : 1;
        return n;
    }

    private int getBapMediaImportProgress() {
        int n = this.isMediaImportRunning() ? this.getMediaService().getCurrentImportProgress() : 255;
        return n;
    }

    private int getBapMediaImportSourceType() {
        int n;
        if (this.isMediaImportRunning()) {
            switch (this.getMediaService().getCurrentImportSource()) {
                case 1: {
                    n = 6;
                    break;
                }
                case 2: {
                    n = 11;
                    break;
                }
                case 3: {
                    n = 19;
                    break;
                }
                case 4: {
                    n = 27;
                    break;
                }
                case 5: {
                    n = 11;
                    break;
                }
                case 6: {
                    n = 19;
                    break;
                }
                case 7: {
                    n = 15;
                    break;
                }
                default: {
                    n = 255;
                    break;
                }
            }
        } else {
            n = 255;
        }
        return n;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateMediaData(MediaService mediaService, int n) {
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
        MEDIA_LISTENER_IDS = new int[]{11, 17, 2735};
    }
}

