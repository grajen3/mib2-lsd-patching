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
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioServiceListener;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundService;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SourceState_SetGet;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SourceState_Status;

public final class SourceState
extends Function
implements Property,
ASLAudioSDConstants,
SoundServiceListener,
MediaServiceListener,
RadioServiceListener {
    private SourceState_Status lastSourceStateStatus = null;
    private static final int MANUAL_TUNE_STATE_IDLE;
    private static final int MANUAL_TUNE_STATE_ENTER;
    private static final int MANUAL_TUNE_STATE_ACTIVE;
    private static final int MANUAL_TUNE_STATE_LEAVE_PENDING;
    private static final int MANUAL_TUNE_STATE_LEAVE;
    private int manualTuneState = 0;
    private boolean manualModeActive = false;
    protected static final int[] SOUND_LISTENER_IDS;
    protected static final int[] MEDIA_LISTENER_IDS;
    protected static final int[] RADIO_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$SourceState_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getSoundService().addSoundServiceListener(this, SOUND_LISTENER_IDS);
        this.getMediaService().addMediaServiceListener(this, MEDIA_LISTENER_IDS);
        this.getRadioService().addRadioServiceListener(this, RADIO_LISTENER_IDS);
        return this.computeSourceStateStatus();
    }

    protected SourceState_Status dequeueBAPEntity() {
        return (SourceState_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$SourceState_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$SourceState_Status = SourceState.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SourceState_Status")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$SourceState_Status);
    }

    protected void setCurrentSourceState(SourceState_Status sourceState_Status) {
        int[] nArray = new int[]{24};
        this.context.updateStages(this, nArray, sourceState_Status);
    }

    protected void setManaulTuning(Boolean bl) {
        int[] nArray = new int[]{21};
        this.context.updateStages(this, nArray, bl);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 21: {
                this.setCurrentStationInfoSend((Boolean)object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 20;
    }

    private boolean performClearOfCurrentMediaState() {
        MediaService mediaService = this.getMediaService();
        boolean bl = true;
        if (mediaService.isMixActive() && !mediaService.isRepeatActive()) {
            mediaService.setMixMode(0);
        } else if (mediaService.isRepeatActive() && !mediaService.isMixActive()) {
            mediaService.setRepeatMode(0);
        } else if (mediaService.isRepeatActive() && mediaService.isMixActive()) {
            mediaService.setMixMode(0);
            mediaService.setRepeatMode(0);
        } else if (mediaService.isPlayMoreLikeThisActive()) {
            mediaService.setPlayMoreLikeThisState(false);
        } else {
            int n = mediaService.getPlayerState();
            if (n == 6) {
                mediaService.stopFastForward();
            } else if (n == 7) {
                mediaService.stopFastRewind();
            } else {
                bl = false;
            }
            bl = false;
        }
        return bl;
    }

    private boolean performRepeat(SourceState_SetGet sourceState_SetGet) {
        MediaService mediaService = this.getMediaService();
        boolean bl = true;
        switch (sourceState_SetGet.stateInfo_Scope) {
            case 0: 
            case 1: 
            case 4: {
                mediaService.setRepeatMode(2);
                break;
            }
            case 5: {
                mediaService.setRepeatMode(1);
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    private boolean setGetSourceStateForMedia(SourceState_SetGet sourceState_SetGet, PropertyListener propertyListener) {
        MediaService mediaService = this.getMediaService();
        boolean bl = true;
        switch (sourceState_SetGet.stateInfo) {
            case 0: {
                bl = this.performClearOfCurrentMediaState();
                break;
            }
            case 1: {
                bl = false;
                break;
            }
            case 2: {
                if (mediaService.isMixSupported()) {
                    mediaService.setMixMode(1);
                    break;
                }
                bl = false;
                break;
            }
            case 3: {
                if (mediaService.isRepeatSupported()) {
                    bl = this.performRepeat(sourceState_SetGet);
                    break;
                }
                bl = false;
                break;
            }
            case 4: {
                if (mediaService.isRepeatSupported() && mediaService.isMixSupported()) {
                    if (sourceState_SetGet.stateInfo_Scope == 4) {
                        mediaService.setRepeatMode(2);
                        mediaService.setMixMode(1);
                        break;
                    }
                    if (sourceState_SetGet.stateInfo_Scope == 5) {
                        mediaService.setRepeatMode(1);
                        mediaService.setMixMode(1);
                        break;
                    }
                    bl = false;
                    break;
                }
                bl = false;
                break;
            }
            case 7: {
                if (!mediaService.isPlayMoreLikeThisActive()) {
                    mediaService.setPlayMoreLikeThisState(true);
                    break;
                }
                bl = false;
                break;
            }
            case 6: {
                if (mediaService.getPlayerState() != 6) {
                    mediaService.startFastForward();
                    break;
                }
                bl = false;
                break;
            }
            default: {
                bl = false;
            }
        }
        if (bl) {
            if (sourceState_SetGet.stateInfo_Scope == 4 && mediaService.areSubfoldersIncluded()) {
                mediaService.toggleSubfolderInclusionState();
            } else if (sourceState_SetGet.stateInfo_Scope == 5 && !mediaService.areSubfoldersIncluded()) {
                mediaService.toggleSubfolderInclusionState();
            }
        }
        return bl;
    }

    private boolean setGetSourceStateForRadio(SourceState_SetGet sourceState_SetGet, PropertyListener propertyListener) {
        RadioService radioService = this.getRadioService();
        boolean bl = true;
        if (sourceState_SetGet.stateInfo_Scope == 0) {
            switch (sourceState_SetGet.stateInfo) {
                case 0: {
                    if (radioService.isRadioSeekActive()) {
                        radioService.stopSeek();
                        break;
                    }
                    if (radioService.isRadioScanningActive()) {
                        radioService.stopScan();
                        break;
                    }
                    if (radioService.isManualModeActive()) {
                        radioService.setManualMode(false);
                        break;
                    }
                    bl = false;
                    break;
                }
                case 1: {
                    radioService.startScan();
                    break;
                }
                case 5: {
                    if (!radioService.isManualModeActive()) {
                        radioService.setManualMode(true);
                        break;
                    }
                    bl = false;
                    break;
                }
                case 6: {
                    radioService.startSeek(1);
                    break;
                }
                default: {
                    bl = false;
                    break;
                }
            }
        } else {
            bl = false;
        }
        return bl;
    }

    private void setGetSourceState(SourceState_SetGet sourceState_SetGet, PropertyListener propertyListener) {
        SourceState_Status sourceState_Status = this.computeSourceStateStatus();
        if (sourceState_Status != null && sourceState_Status.stateInfo == sourceState_SetGet.stateInfo && sourceState_Status.stateInfo_Scope == sourceState_SetGet.stateInfo_Scope) {
            propertyListener.statusProperty(sourceState_Status, this);
        } else {
            boolean bl;
            block0 : switch (this.getSoundService().getCurrentAudioComponent()) {
                case 2: {
                    if (this.isDvdVideo()) {
                        bl = false;
                        break;
                    }
                    switch (this.getMediaService().getCurrentAudioSource()) {
                        case 3: 
                        case 9: {
                            bl = false;
                            break block0;
                        }
                    }
                    bl = this.setGetSourceStateForMedia(sourceState_SetGet, propertyListener);
                    break;
                }
                case 1: {
                    bl = this.setGetSourceStateForRadio(sourceState_SetGet, propertyListener);
                    break;
                }
                default: {
                    bl = false;
                }
            }
            if (!bl) {
                propertyListener.statusProperty(sourceState_Status, this);
            }
        }
    }

    private void setStateInfoForVideo(SourceState_Status sourceState_Status) {
        int n = this.getMediaService().getPlayerState();
        sourceState_Status.stateInfo = n == 6 || n == 7 ? 6 : 0;
    }

    private void setStateInfoForMedia(SourceState_Status sourceState_Status) {
        MediaService mediaService = this.getMediaService();
        switch (mediaService.getCurrentAudioSource()) {
            case 3: 
            case 9: {
                sourceState_Status.stateInfo = 0;
                break;
            }
            default: {
                int n;
                sourceState_Status.stateInfo = mediaService.isMixActive() && !mediaService.isRepeatActive() ? 2 : (mediaService.isRepeatActive() && !mediaService.isMixActive() ? 3 : (mediaService.isRepeatActive() && mediaService.isMixActive() ? 4 : (mediaService.isPlayMoreLikeThisActive() ? 7 : ((n = mediaService.getPlayerState()) == 6 || n == 7 ? 6 : 0))));
            }
        }
    }

    private void setStateInfo(SourceState_Status sourceState_Status) {
        RadioService radioService = this.getRadioService();
        switch (this.getSoundService().getCurrentAudioComponent()) {
            case 2: {
                if (this.isDvdVideo()) {
                    this.setStateInfoForVideo(sourceState_Status);
                    break;
                }
                this.setStateInfoForMedia(sourceState_Status);
                break;
            }
            case 1: {
                if (radioService.isManualModeActive()) {
                    sourceState_Status.stateInfo = 5;
                    break;
                }
                if (radioService.isRadioSeekActive()) {
                    sourceState_Status.stateInfo = 6;
                    break;
                }
                if (radioService.isRadioScanningActive()) {
                    sourceState_Status.stateInfo = 1;
                    break;
                }
                sourceState_Status.stateInfo = 0;
                break;
            }
            default: {
                sourceState_Status.stateInfo = 0;
            }
        }
    }

    private void setStateInfoScopeForMedia(SourceState_Status sourceState_Status) {
        MediaService mediaService = this.getMediaService();
        switch (sourceState_Status.stateInfo) {
            case 1: 
            case 2: {
                if (mediaService.areSubfoldersIncluded()) {
                    sourceState_Status.stateInfo_Scope = 5;
                    break;
                }
                sourceState_Status.stateInfo_Scope = 4;
                break;
            }
            case 3: 
            case 4: {
                int n = mediaService.getRepeatMode();
                if (n == 2) {
                    sourceState_Status.stateInfo_Scope = 1;
                    break;
                }
                if (n == 1) {
                    if (mediaService.areSubfoldersIncluded()) {
                        sourceState_Status.stateInfo_Scope = 5;
                        break;
                    }
                    sourceState_Status.stateInfo_Scope = 4;
                    break;
                }
                sourceState_Status.stateInfo_Scope = 0;
                break;
            }
            default: {
                sourceState_Status.stateInfo_Scope = 0;
            }
        }
    }

    private boolean isDvdVideo() {
        MediaService mediaService = this.getMediaService();
        int n = mediaService.getCDContentType();
        int n2 = mediaService.getCurrentAudioSource();
        return !(n2 != 1 && n2 != 4 || n != 3 && n != 4);
    }

    private void setStateInfoScope(SourceState_Status sourceState_Status) {
        switch (this.getSoundService().getCurrentAudioComponent()) {
            case 1: {
                sourceState_Status.stateInfo_Scope = 0;
                break;
            }
            case 2: {
                if (this.isDvdVideo()) {
                    sourceState_Status.stateInfo_Scope = 0;
                    break;
                }
                this.setStateInfoScopeForMedia(sourceState_Status);
                break;
            }
            default: {
                sourceState_Status.stateInfo_Scope = 0;
            }
        }
    }

    private void sendSourceStateStatus(SourceState_Status sourceState_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(sourceState_Status, this);
        this.lastSourceStateStatus = sourceState_Status;
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        SourceState_SetGet sourceState_SetGet = (SourceState_SetGet)bAPEntity;
        if (SourceState.setGetParametersValid(sourceState_SetGet)) {
            this.setGetSourceState(sourceState_SetGet, propertyListener);
        } else {
            propertyListener.requestError(65, this);
        }
    }

    @Override
    public void requestAcknowledge() {
        this.setCurrentSourceState(this.lastSourceStateStatus);
        this.setManualTuneStateAfterMTMAcknowledge();
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
        this.getRadioService().removeRadioServiceListener(this, RADIO_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void process(int n) {
        SourceState_Status sourceState_Status = this.computeSourceStateStatus();
        boolean bl = sourceState_Status.stateInfo == 5;
        this.setManualTuneStateForCurrentHMIManualTuneModeState(bl);
        if (bl || sourceState_Status.stateInfo == 0) {
            sourceState_Status.stateInfo = this.isManualTuneActive() ? 5 : 0;
        }
        this.sendSourceStateStatus(sourceState_Status);
    }

    private static boolean setGetParametersValid(SourceState_SetGet sourceState_SetGet) {
        boolean bl;
        boolean bl2;
        switch (sourceState_SetGet.stateInfo) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: {
                bl2 = true;
                break;
            }
            default: {
                bl2 = false;
            }
        }
        switch (sourceState_SetGet.stateInfo_Scope) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl2 && bl;
    }

    private SourceState_Status computeSourceStateStatus() {
        SourceState_Status sourceState_Status = this.dequeueBAPEntity();
        this.setStateInfo(sourceState_Status);
        this.setStateInfoScope(sourceState_Status);
        return sourceState_Status;
    }

    private int getManualTuneState() {
        return this.manualTuneState;
    }

    private void setManualTuneState(int n) {
        this.manualTuneState = n;
    }

    private boolean isManualTuneActive() {
        return this.manualModeActive;
    }

    private void setManualTuneStateForCurrentHMIManualTuneModeState(boolean bl) {
        switch (this.getManualTuneState()) {
            case 1: {
                if (bl) break;
                this.setManaulTuning(Boolean.FALSE);
                this.setManualTuneState(0);
                this.manualModeActive = false;
                break;
            }
            case 2: {
                if (bl) break;
                this.setManualTuneState(3);
                this.manualModeActive = false;
                break;
            }
            case 3: 
            case 4: {
                if (!bl) break;
                this.setManualTuneState(2);
                this.manualModeActive = true;
                break;
            }
            default: {
                if (!bl) break;
                this.setManaulTuning(Boolean.TRUE);
                this.setManualTuneState(1);
                this.manualModeActive = false;
            }
        }
    }

    private void setManualTuneStateAfterMTMAcknowledge() {
        switch (this.getManualTuneState()) {
            case 1: {
                if (!this.manualModeActive) break;
                this.setManualTuneState(2);
                this.manualModeActive = true;
                break;
            }
            case 3: {
                this.setManualTuneState(4);
                this.setManaulTuning(Boolean.FALSE);
                this.manualModeActive = false;
                break;
            }
        }
    }

    private void setManualTuneStateAfterCIAcknowledge() {
        switch (this.getManualTuneState()) {
            case 1: {
                this.manualModeActive = true;
                this.sendSourceStateStatus(this.computeSourceStateStatus());
                break;
            }
            case 4: {
                this.setManualTuneState(0);
                this.manualModeActive = false;
                break;
            }
        }
    }

    protected void setCurrentStationInfoSend(Boolean bl) {
        this.setManualTuneStateAfterCIAcknowledge();
    }

    @Override
    public void processHMIEvent(int n) {
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
        MEDIA_LISTENER_IDS = new int[]{8, 3520, 44, 85, 85, 41, 46, 29};
        RADIO_LISTENER_IDS = new int[]{1438, 1446, 1445};
    }
}

