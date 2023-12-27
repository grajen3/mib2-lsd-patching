/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.functions.RequestContext;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.audiosd.functions.AudioSDCommon;
import de.vw.mib.bap.mqbab2.audiosd.functions.MediaBrowser;
import de.vw.mib.bap.mqbab2.common.api.media.MediaService;
import de.vw.mib.bap.mqbab2.common.api.media.MediaServiceListener;
import de.vw.mib.bap.mqbab2.common.api.media.datatypes.MediaActiveTrackInfo;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioServiceListener;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.elements.RadioReceptionListElement;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundService;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.tvtuner.TvTunerService;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListWindowed;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayObjectId;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.CurrentStation_Handle_Status;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.DedicatedAudioControl_Result;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.DedicatedAudioControl_StartResult;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ReceptionList_Data;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SourceState_Status;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.TpMemoInfo_Status;
import de.vw.mib.bap.stream.BitStream;
import java.util.Iterator;

public final class DedicatedAudioControl
extends Function
implements TimerNotifier,
Method,
ASLAudioSDConstants,
MediaServiceListener,
RadioServiceListener {
    private static final int INVALID_INDEX;
    private static final int INVALID_HANDLE_REF;
    private static final int INVAVLID_PRESET_REF;
    private static final int DAC_ACTION_NO_ACTION;
    private static final int DAC_ACTION_NEW_TP_MEMO_ENTRY;
    private static final int DAC_ACTION_PRESET_LIST_NEW_ENTRY;
    private static final int DAC_ACTION_RECEPTION_LIST_NEW_ENTRY;
    private static final int DAC_ACTION_RADIO_TUNE_TO_STATION;
    private static final int DAC_ACTION_MEDIA_NEW_ENTRY;
    private static final int DAC_ACTION_STOP_SCAN_OR_SEEK;
    private static final int DAC_ACTION_PLAY_MEDIA_BROWSER_FILE;
    private static final int DAC_ACTION_CONTINOUS_ACTION_TILL_ABORT_RADIO;
    private static final int DAC_ACTION_CONTINOUS_ACTION_TILL_ABORT_MEDIA;
    private static final int DAC_ACTION_CONTINOUS_ACTION_TILL_ABORT_VIDEO;
    private int currentDACAction = 0;
    private boolean currentStationHandleRequested = false;
    private static final int DAC_ACTION_INVALID_HANDLE;
    private int dacActionFromHandle = -1;
    private int dacActionToHandle = -1;
    private DedicatedAudioControl_StartResult lastDedicatedAudioControlStartResult = null;
    private static final int MINIMUM_SKIP_COUNTER;
    private static final int TP_MEMO_SECONDS_TO_SKIP;
    private static final int MIN_NUMBER_OF_ELEMENTS_FOR_PREV_NEXT;
    private static final int DIRECTION_FORWARD;
    private static final int DIRECTION_BACKWARD;
    private FsgArrayListComplete fullReceptionList = null;
    private FsgArrayListComplete fullTPMemoList = null;
    private FsgArrayListWindowed currentMediaBrowserArrayList = null;
    private boolean _mediaBrowserActiveComponent;
    private boolean _radioPresetListUsed;
    private FsgArrayListComplete fullRadioTvPresetList = null;
    private int currentStationHandleFsgHandle = -1;
    private int currentStationHandlePresetRef = 0;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_TIME_OUT_ACTION_FAILED;
    protected static final int[] MEDIA_LISTENER_HMI_EVENT_IDS;
    protected static final int[] RADIO_LISTENER_HMI_EVENT_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$DedicatedAudioControl_Result;
    static /* synthetic */ Class class$java$lang$Integer;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$CurrentStation_Handle_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getMediaService().addHMIEventListener(this, MEDIA_LISTENER_HMI_EVENT_IDS);
        this.getRadioService().addHMIEventListener(this, RADIO_LISTENER_HMI_EVENT_IDS);
        this.timer = this.getTimerService().createTimer(this, 1625948160);
        return null;
    }

    protected DedicatedAudioControl_Result dequeueBAPEntity() {
        return (DedicatedAudioControl_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$DedicatedAudioControl_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$DedicatedAudioControl_Result = DedicatedAudioControl.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.DedicatedAudioControl_Result")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$DedicatedAudioControl_Result);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 33: {
                this.setFullRadioTvPresetList((FsgArrayListComplete)object);
                break;
            }
            case 22: {
                if (object.getClass() == (class$java$lang$Integer == null ? (class$java$lang$Integer = DedicatedAudioControl.class$("java.lang.Integer")) : class$java$lang$Integer)) {
                    this.setCurrentStationHandleSend((Integer)object);
                    break;
                }
                if (object.getClass() != (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$CurrentStation_Handle_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$CurrentStation_Handle_Status = DedicatedAudioControl.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.CurrentStation_Handle_Status")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$CurrentStation_Handle_Status)) break;
                this.setCurrentStationHandleOutput((CurrentStation_Handle_Status)object);
                break;
            }
            case 20: {
                this.setCurrentSourceState((SourceState_Status)object);
                break;
            }
            case 21: {
                this.setCurrentStationInfoSend((Boolean)object);
                break;
            }
            case 26: {
                this.setCurrentTPMemoInfoSend((TpMemoInfo_Status)object);
                break;
            }
            case 23: {
                this.setFullReceptionList((FsgArrayListComplete)object);
                break;
            }
            case 27: {
                this.setFullTPMemoList((FsgArrayListComplete)object);
                break;
            }
            case 36: {
                this.setCurrentMediaBrowserArrayList((FsgArrayListWindowed)object);
                break;
            }
            case 38: {
                this.setMediaBrowserActiveComponent((Boolean)object);
                break;
            }
            case 40: {
                this.setPresetListUsed((Boolean)object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 24;
    }

    @Override
    public void process(int n) {
    }

    private static boolean startResultParametersValid(DedicatedAudioControl_StartResult dedicatedAudioControl_StartResult) {
        boolean bl;
        boolean bl2;
        switch (dedicatedAudioControl_StartResult.controlType) {
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
        switch (dedicatedAudioControl_StartResult.listType) {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl2 && bl;
    }

    private void sendResult(int n) {
        DedicatedAudioControl_Result dedicatedAudioControl_Result = this.dequeueBAPEntity();
        dedicatedAudioControl_Result.dedicatedAudioControlResult = n;
        this.getDelegate().getMethodListener(this).result(dedicatedAudioControl_Result, this);
    }

    private int findPresetListIndex(int n) {
        int n2;
        int n3;
        if (this.fullRadioTvPresetList == null || this.fullRadioTvPresetList.getSize() == 0) {
            return -1;
        }
        int n4 = this.currentStationHandlePresetRef == 0 ? this.fullRadioTvPresetList.firstBAPPosID() : this.currentStationHandlePresetRef;
        int n5 = this.fullRadioTvPresetList.getIndexOfBapPosId(n4);
        int n6 = n3 = this.currentStationHandlePresetRef == 0 && Math.abs(n) <= 1 ? n5 : n5 + n;
        if (n3 < 0) {
            n2 = (int)this.fullRadioTvPresetList.getInternalUserId(this.fullRadioTvPresetList.firstBAPPosID());
        } else if (n3 >= this.fullRadioTvPresetList.getSize()) {
            n2 = (int)this.fullRadioTvPresetList.getInternalUserId(this.fullRadioTvPresetList.lastBAPPosID());
        } else {
            int n7 = n3 - n5;
            n2 = (int)this.fullRadioTvPresetList.getInternalUserId(this.fullRadioTvPresetList.nextBapPosID(n4, n7));
        }
        return n2;
    }

    private int findReceptionHandle(int n) {
        int n2;
        if (this.fullReceptionList == null || this.fullReceptionList.getSize() == 0) {
            return 0;
        }
        int n3 = this.currentStationHandleFsgHandle == -1 ? this.fullReceptionList.firstBAPPosID() : this.currentStationHandleFsgHandle;
        int n4 = this.fullReceptionList.getIndexOfBapPosId(n3);
        int n5 = n4 + n;
        if (n5 < 0) {
            n2 = this.fullReceptionList.firstBAPPosID();
        } else if (n5 >= this.fullReceptionList.getSize()) {
            n2 = this.fullReceptionList.lastBAPPosID();
        } else {
            int n6 = n5 - n4;
            n2 = this.fullReceptionList.nextBapPosID(n3, n6);
        }
        return n2;
    }

    private int findNextReceptionListHandle() {
        if (this.fullReceptionList == null || this.fullReceptionList.getSize() == 0) {
            return 0;
        }
        int n = this.fullReceptionList.nextBapPosID(this.currentStationHandleFsgHandle);
        if (n == 0) {
            n = this.fullReceptionList.firstBAPPosID();
        }
        return n;
    }

    private int findPreviousReceptionListHandle() {
        if (this.fullReceptionList == null || this.fullReceptionList.getSize() == 0) {
            return 0;
        }
        int n = this.fullReceptionList.previousBapPosID(this.currentStationHandleFsgHandle);
        if (n == 0) {
            n = this.fullReceptionList.lastBAPPosID();
        }
        return n;
    }

    private void ensureCurrentAudioComponentForRadio() {
        RadioService radioService = this.getRadioService();
        block0 : switch (this.getSoundService().getCurrentAudioComponent()) {
            case 1: {
                break;
            }
            default: {
                switch (radioService.getCurrentStationBand()) {
                    case 0: {
                        radioService.activateBand(0);
                        break block0;
                    }
                    case 1: {
                        radioService.activateBand(1);
                        break block0;
                    }
                    case 2: {
                        radioService.activateBand(2);
                        break block0;
                    }
                    case 3: {
                        radioService.activateBand(3);
                        break block0;
                    }
                }
            }
        }
    }

    private void ensureCorrectSourceStateForRadioSelectListEntry() {
        RadioService radioService = this.getRadioService();
        if (radioService.isRadioScanningActive()) {
            if (radioService.getCurrentStationBand() != 2) {
                radioService.stopScan();
            }
        } else if (radioService.isRadioSeekActive()) {
            radioService.stopSeek();
        } else if (radioService.isManualModeActive()) {
            radioService.setManualMode(false);
        }
    }

    private void ensureCorrectSourceStateForTvTuner() {
    }

    private void ensureCurrentAudioComponentForTvTuner() {
    }

    private void ensureCorrectSourceStateForMediaFastForwardBackward() {
    }

    private void ensureCorrectSourceStateForMediaPreviousNext() {
        MediaService mediaService = this.getMediaService();
        this.ensureCorrectSourceStateForMediaFastForwardBackward();
        if (mediaService.isRepeatActive() && mediaService.getRepeatMode() == 2) {
            mediaService.setRepeatMode(0);
        }
    }

    private int dedicatedAudioControlNextRadio(int n, int n2) {
        int n3;
        RadioService radioService = this.getRadioService();
        switch (n2) {
            case 2: {
                int n4 = this.findPresetListIndex(n == 0 ? 1 : n);
                if (n4 != -1 && n4 == radioService.getCurrentStationIndices().getCurrentStationIndicesActivePresetIndex()) {
                    n3 = 0;
                    this.sendResult(n3);
                    break;
                }
                if (n4 != -1) {
                    this.ensureCorrectSourceStateForRadioSelectListEntry();
                    if (radioService.getCurrentStationBand() == 3) {
                        radioService.activateSatChannelPreset(n4);
                    } else {
                        radioService.activateStationPreset(n4);
                    }
                    this.currentDACAction = 2;
                    n3 = 0;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1: {
                this.ensureCorrectSourceStateForRadioSelectListEntry();
                if (!DedicatedAudioControl.enoughElementsInListForNextPrev(this.fullReceptionList)) {
                    if (radioService.getCurrentStationBand() == 3) {
                        radioService.activateNextSatChannel();
                    } else {
                        radioService.activateNextStation();
                    }
                    n3 = 0;
                    this.sendResult(n3);
                    break;
                }
                if (n > 1) {
                    n3 = this.selectListEntryForRadioReceptionList(this.findReceptionHandle(n));
                    break;
                }
                if (radioService.getCurrentStationBand() == 3) {
                    radioService.activateNextListSatChannel();
                    this.currentDACAction = 3;
                    n3 = 0;
                    break;
                }
                n3 = this.selectListEntryForRadioReceptionList(this.findNextReceptionListHandle());
                break;
            }
            case 0: {
                this.ensureCorrectSourceStateForRadioSelectListEntry();
                if (radioService.getCurrentStationBand() == 3) {
                    radioService.activateNextSatChannel();
                } else {
                    radioService.activateNextStation();
                }
                n3 = 0;
                boolean bl = this.enoughElementsInScopeOfArrowKeysList();
                if (bl) {
                    this.currentDACAction = 4;
                    break;
                }
                this.currentDACAction = 0;
                this.sendResult(n3);
                break;
            }
            default: {
                n3 = 1;
            }
        }
        return n3;
    }

    private int dedicatedAudioControlNextPreviousTpMemo(int n, int n2) {
        int n3;
        RadioService radioService = this.getRadioService();
        Iterator iterator = radioService.getTrafficMessages();
        int n4 = 0;
        while (iterator.hasNext()) {
            ++n4;
            iterator.next();
        }
        if (radioService.isTrafficMessageRecording() || n < 0 || n >= n4 || n4 == 0) {
            n3 = 1;
        } else {
            int n5 = n > 1 ? n * n2 : n2;
            this.currentDACAction = 1;
            this.dacActionFromHandle = radioService.getTpMemoListSelectedIndex();
            this.dacActionToHandle = (this.dacActionFromHandle + n5) % n4;
            if (this.dacActionToHandle < 0) {
                this.dacActionToHandle += n4;
            }
            n3 = 0;
            radioService.activateTrafficMessage(this.dacActionToHandle);
        }
        return n3;
    }

    private int dedicatedAudioControlNextForVideo() {
        MediaService mediaService = this.getMediaService();
        int n = mediaService.getDvdChapterCount();
        if (n <= 1) {
            mediaService.activateSelectedDVDMenuItem();
        } else {
            mediaService.activateNextDVDChapter();
        }
        int n2 = 0;
        this.sendResult(n2);
        return n2;
    }

    private int dedicatedAudioControlNextForTvTuner(int n, int n2) {
        int n3;
        TvTunerService tvTunerService = this.getTvTunerService();
        RadioService radioService = this.getRadioService();
        switch (n2) {
            case 2: {
                int n4 = this.findPresetListIndex(n == 0 ? 1 : n);
                if (n4 != -1 && n4 == radioService.getCurrentStationIndices().getCurrentStationIndicesActivePresetIndex()) {
                    n3 = 0;
                    this.sendResult(n3);
                    break;
                }
                if (n4 != -1) {
                    this.ensureCorrectSourceStateForTvTuner();
                    tvTunerService.activateTvTunerPreset(n4);
                    this.currentDACAction = 2;
                    n3 = 0;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1: {
                this.ensureCorrectSourceStateForTvTuner();
                if (!DedicatedAudioControl.enoughElementsInListForNextPrev(this.fullReceptionList)) {
                    tvTunerService.activateNextTvTunerStation();
                    n3 = 0;
                    this.sendResult(n3);
                    break;
                }
                if (n > 1) {
                    n3 = this.selectListEntryForTvTunerReceptionList(this.findReceptionHandle(n));
                    break;
                }
                n3 = this.selectListEntryForTvTunerReceptionList(this.findNextReceptionListHandle());
                break;
            }
            case 0: {
                this.ensureCorrectSourceStateForTvTuner();
                tvTunerService.activateNextTvTunerStation();
                n3 = 0;
                boolean bl = this.enoughElementsInScopeOfArrowKeysList();
                if (bl) {
                    this.currentDACAction = 4;
                    break;
                }
                this.currentDACAction = 0;
                this.sendResult(n3);
                break;
            }
            default: {
                n3 = 1;
            }
        }
        return n3;
    }

    private boolean isDvdVideo() {
        MediaService mediaService = this.getMediaService();
        int n = mediaService.getCDContentType();
        int n2 = mediaService.getCurrentAudioSource();
        return !(n2 != 1 && n2 != 4 || n != 3 && n != 4);
    }

    private int dedicatedAudioControlNext(int n, int n2) {
        int n3;
        switch (this.getSoundService().getCurrentAudioComponent()) {
            case 2: {
                if (this.isDvdVideo()) {
                    n3 = this.dedicatedAudioControlNextForVideo();
                    break;
                }
                MediaService mediaService = this.getMediaService();
                if (mediaService.isSkipForwardSupported() && mediaService.getCurrentAudioSource() != 0) {
                    this.ensureCorrectSourceStateForMediaPreviousNext();
                    if (n > 1) {
                        mediaService.skipForwardWithCounter(n);
                    } else {
                        mediaService.skipForwardWithCounter(1);
                    }
                    n3 = 0;
                    this.sendResult(n3);
                    break;
                }
                n3 = 1;
                break;
            }
            case 1: {
                if (this.getSystemService().getCurrentMainContext() == 10) {
                    n3 = this.dedicatedAudioControlNextPreviousTpMemo(n, 1);
                    break;
                }
                n3 = this.dedicatedAudioControlNextRadio(n, n2);
                break;
            }
            case 3: {
                n3 = this.dedicatedAudioControlNextForVideo();
                break;
            }
            case 5: {
                n3 = this.dedicatedAudioControlNextForTvTuner(n, n2);
                break;
            }
            default: {
                n3 = this.getSystemService().getCurrentMainContext() == 10 ? this.dedicatedAudioControlNextPreviousTpMemo(n, 1) : 1;
            }
        }
        return n3;
    }

    private int dedicatedAudioControlPreviousRadio(int n, int n2) {
        int n3;
        RadioService radioService = this.getRadioService();
        switch (n2) {
            case 2: {
                int n4 = this.findPresetListIndex(n == 0 ? -1 : -n);
                if (n4 != -1 && n4 == radioService.getCurrentStationIndices().getCurrentStationIndicesActivePresetIndex()) {
                    n3 = 0;
                    this.sendResult(n3);
                    break;
                }
                if (n4 != -1) {
                    this.ensureCorrectSourceStateForRadioSelectListEntry();
                    if (radioService.getCurrentStationBand() == 3) {
                        radioService.activateSatChannelPreset(n4);
                    } else {
                        radioService.activateStationPreset(n4);
                    }
                    this.currentDACAction = 2;
                    n3 = 0;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1: {
                this.ensureCorrectSourceStateForRadioSelectListEntry();
                if (!DedicatedAudioControl.enoughElementsInListForNextPrev(this.fullReceptionList)) {
                    if (radioService.getCurrentStationBand() == 3) {
                        radioService.activatePreviousSatChannel();
                    } else {
                        radioService.activatePreviousStation();
                    }
                    n3 = 0;
                    this.sendResult(n3);
                    break;
                }
                if (n > 1) {
                    n3 = this.selectListEntryForRadioReceptionList(this.findReceptionHandle(-n));
                    break;
                }
                if (radioService.getCurrentStationBand() == 3) {
                    radioService.activatePreviousListSatChannel();
                    this.currentDACAction = 3;
                    n3 = 0;
                    break;
                }
                n3 = this.selectListEntryForRadioReceptionList(this.findPreviousReceptionListHandle());
                break;
            }
            case 0: {
                this.ensureCorrectSourceStateForRadioSelectListEntry();
                if (radioService.getCurrentStationBand() == 3) {
                    radioService.activatePreviousSatChannel();
                } else {
                    radioService.activatePreviousStation();
                }
                n3 = 0;
                boolean bl = this.enoughElementsInScopeOfArrowKeysList();
                if (bl) {
                    this.currentDACAction = 4;
                    break;
                }
                this.currentDACAction = 0;
                this.sendResult(n3);
                break;
            }
            default: {
                n3 = 1;
            }
        }
        return n3;
    }

    private int dedicatedAudioControlPreviousForVideo() {
        this.getMediaService().activatePreviousDVDChapter();
        int n = 0;
        this.sendResult(n);
        return n;
    }

    private int dedicatedAudioControlPreviousForTvTuner(int n, int n2) {
        int n3;
        RadioService radioService = this.getRadioService();
        TvTunerService tvTunerService = this.getTvTunerService();
        switch (n2) {
            case 2: {
                int n4 = this.findPresetListIndex(n == 0 ? -1 : -n);
                if (n4 != -1 && n4 == radioService.getCurrentStationIndices().getCurrentStationIndicesActivePresetIndex()) {
                    n3 = 0;
                    this.sendResult(n3);
                    break;
                }
                if (n4 != -1) {
                    this.ensureCorrectSourceStateForTvTuner();
                    tvTunerService.activateTvTunerPreset(n4);
                    this.currentDACAction = 2;
                    n3 = 0;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1: {
                this.ensureCorrectSourceStateForTvTuner();
                if (!DedicatedAudioControl.enoughElementsInListForNextPrev(this.fullReceptionList)) {
                    tvTunerService.activatePreviousTvTunerStation();
                    n3 = 0;
                    this.sendResult(n3);
                    break;
                }
                if (n > 1) {
                    n3 = this.selectListEntryForTvTunerReceptionList(this.findReceptionHandle(-n));
                    break;
                }
                n3 = this.selectListEntryForTvTunerReceptionList(this.findPreviousReceptionListHandle());
                break;
            }
            case 0: {
                this.ensureCorrectSourceStateForTvTuner();
                tvTunerService.activatePreviousTvTunerStation();
                n3 = 0;
                boolean bl = this.enoughElementsInScopeOfArrowKeysList();
                if (bl) {
                    this.currentDACAction = 4;
                    break;
                }
                this.currentDACAction = 0;
                this.sendResult(n3);
                break;
            }
            default: {
                n3 = 1;
            }
        }
        return n3;
    }

    private int dedicatedAudioControlPrevious(int n, int n2) {
        int n3;
        switch (this.getSoundService().getCurrentAudioComponent()) {
            case 2: {
                if (this.isDvdVideo()) {
                    n3 = this.dedicatedAudioControlPreviousForVideo();
                    break;
                }
                MediaService mediaService = this.getMediaService();
                if (mediaService.isSkipBackwardSupported() && mediaService.getCurrentAudioSource() != 0) {
                    this.ensureCorrectSourceStateForMediaPreviousNext();
                    if (n > 1) {
                        mediaService.skipBackwardWithCounter(n);
                    } else {
                        mediaService.skipBackwardWithCounter(1);
                    }
                    n3 = 0;
                    this.sendResult(n3);
                    break;
                }
                n3 = 1;
                break;
            }
            case 5: {
                n3 = this.dedicatedAudioControlPreviousForTvTuner(n, n2);
                break;
            }
            case 1: {
                if (this.getSystemService().getCurrentMainContext() == 10) {
                    n3 = this.dedicatedAudioControlNextPreviousTpMemo(n, -1);
                    break;
                }
                n3 = this.dedicatedAudioControlPreviousRadio(n, n2);
                break;
            }
            case 3: {
                n3 = this.dedicatedAudioControlPreviousForVideo();
                break;
            }
            default: {
                n3 = this.getSystemService().getCurrentMainContext() == 10 ? this.dedicatedAudioControlNextPreviousTpMemo(n, -1) : 1;
            }
        }
        return n3;
    }

    private int dedicatedAudioControlFastForwardForVideo() {
        int n;
        MediaService mediaService = this.getMediaService();
        if (mediaService.getCurrentAudioSource() != 0) {
            mediaService.startFastForward();
            this.currentDACAction = 10;
            n = 0;
        } else {
            n = 1;
        }
        return n;
    }

    private int dedicatedAudioControlFastForward() {
        int n;
        RadioService radioService = this.getRadioService();
        MediaService mediaService = this.getMediaService();
        switch (this.getSoundService().getCurrentAudioComponent()) {
            case 2: {
                if (this.isDvdVideo()) {
                    n = this.dedicatedAudioControlFastForwardForVideo();
                    break;
                }
                if (mediaService.getCurrentAudioSource() != 0) {
                    this.ensureCorrectSourceStateForMediaFastForwardBackward();
                    mediaService.startFastForward();
                    this.currentDACAction = 9;
                    n = 0;
                    break;
                }
                n = 1;
                break;
            }
            case 1: {
                if (radioService.getCurrentStationBand() == 0) {
                    radioService.startTargetSeek(1);
                    this.currentDACAction = 8;
                    n = 0;
                    break;
                }
                n = 1;
                break;
            }
            case 3: {
                n = this.dedicatedAudioControlFastForwardForVideo();
                break;
            }
            default: {
                if (this.getSystemService().getCurrentMainContext() == 10) {
                    radioService.startFastForwardTrafficMessage(10);
                    this.sendResult(0);
                    n = 0;
                    break;
                }
                n = 1;
            }
        }
        return n;
    }

    private int abortDedicatedAudioControlFastForwardForVideo() {
        int n;
        MediaService mediaService = this.getMediaService();
        if (mediaService.getCurrentAudioSource() != 0) {
            mediaService.stopFastForward();
            n = 2;
        } else {
            n = 1;
        }
        return n;
    }

    private int abortDedicatedAudioControlFastForward() {
        int n;
        switch (this.getSoundService().getCurrentAudioComponent()) {
            case 2: {
                if (this.isDvdVideo()) {
                    n = this.abortDedicatedAudioControlFastForwardForVideo();
                    break;
                }
                MediaService mediaService = this.getMediaService();
                if (mediaService.getCurrentAudioSource() != 0) {
                    mediaService.stopFastForward();
                    n = 2;
                    break;
                }
                n = 1;
                break;
            }
            case 1: {
                RadioService radioService = this.getRadioService();
                if (radioService.getCurrentStationBand() == 0) {
                    radioService.stopChangingFrequency();
                }
                n = 2;
                break;
            }
            default: {
                n = 3;
            }
        }
        return n;
    }

    private int dedicatedAudioControlFastBackwardForVideo() {
        int n;
        MediaService mediaService = this.getMediaService();
        if (mediaService.getCurrentAudioSource() != 0) {
            mediaService.startFastRewind();
            this.currentDACAction = 10;
            n = 0;
        } else {
            n = 1;
        }
        return n;
    }

    private int dedicatedAudioControlFastBackward() {
        int n;
        RadioService radioService = this.getRadioService();
        switch (this.getSoundService().getCurrentAudioComponent()) {
            case 2: {
                if (this.isDvdVideo()) {
                    n = this.dedicatedAudioControlFastBackwardForVideo();
                    break;
                }
                MediaService mediaService = this.getMediaService();
                if (mediaService.getCurrentAudioSource() != 0) {
                    this.ensureCorrectSourceStateForMediaFastForwardBackward();
                    mediaService.startFastRewind();
                    this.currentDACAction = 9;
                    n = 0;
                    break;
                }
                n = 1;
                break;
            }
            case 1: {
                if (radioService.getCurrentStationBand() == 0) {
                    radioService.startTargetSeek(0);
                    this.currentDACAction = 8;
                    n = 0;
                    break;
                }
                n = 1;
                break;
            }
            case 3: {
                n = this.dedicatedAudioControlFastBackwardForVideo();
                break;
            }
            default: {
                if (this.getSystemService().getCurrentMainContext() == 10) {
                    radioService.startRewindTrafficMessage(10);
                    this.sendResult(0);
                    n = 0;
                    break;
                }
                n = 1;
            }
        }
        return n;
    }

    private int abortDedicatedAudioControlFastBackwardForVideo() {
        int n;
        MediaService mediaService = this.getMediaService();
        if (mediaService.getCurrentAudioSource() != 0) {
            mediaService.stopFastRewind();
            n = 2;
        } else {
            n = 1;
        }
        return n;
    }

    private int abortDedicatedAudioControlFastBackward() {
        int n;
        switch (this.getSoundService().getCurrentAudioComponent()) {
            case 2: {
                if (this.isDvdVideo()) {
                    n = this.abortDedicatedAudioControlFastBackwardForVideo();
                    break;
                }
                MediaService mediaService = this.getMediaService();
                if (mediaService.getCurrentAudioSource() != 0) {
                    mediaService.stopFastRewind();
                    n = 2;
                    break;
                }
                n = 1;
                break;
            }
            case 1: {
                RadioService radioService = this.getRadioService();
                if (radioService.getCurrentStationBand() == 0) {
                    radioService.stopChangingFrequency();
                }
                n = 2;
                break;
            }
            default: {
                n = 3;
            }
        }
        return n;
    }

    private RadioReceptionListElement getReceptionListElementAtPosition(int n) {
        Iterator iterator = this.getRadioService().getReceptionList();
        int n2 = 0;
        while (iterator.hasNext()) {
            RadioReceptionListElement radioReceptionListElement = (RadioReceptionListElement)iterator.next();
            if (n2 == n) {
                return radioReceptionListElement;
            }
            ++n2;
        }
        return null;
    }

    private int getNumberOfElementsInReceptionList() {
        Iterator iterator = this.getRadioService().getReceptionList();
        int n = 0;
        while (iterator.hasNext()) {
            iterator.next();
            ++n;
        }
        return n;
    }

    private int selectListEntryForTvTunerReceptionList(int n) {
        int n2;
        long l;
        long l2 = l = this.fullReceptionList != null ? this.fullReceptionList.getInternalUserId(n) : -1L;
        if (l == -1L) {
            n2 = 0;
            this.sendResult(n2);
        } else {
            RadioService radioService = this.getRadioService();
            long l3 = radioService.getCurrentStationIndices().getCurrentStationIndicesStationListActiveID();
            if (l3 == l) {
                this.ensureCurrentAudioComponentForTvTuner();
                n2 = 0;
                this.sendResult(n2);
            } else {
                int n3;
                int n4 = n3 = this.fullReceptionList != null ? this.fullReceptionList.getIndexOfBapPosId(n) : -1;
                if (n3 == -1 || n3 >= this.getNumberOfElementsInReceptionList()) {
                    n2 = 0;
                    this.sendResult(n2);
                } else {
                    RadioReceptionListElement radioReceptionListElement = this.getReceptionListElementAtPosition(n3);
                    this.ensureCurrentAudioComponentForTvTuner();
                    radioService.activateStationByID(radioReceptionListElement.getReceptionListElementUniqueId(), radioReceptionListElement.getReceptionListElementFrequency());
                    this.currentDACAction = 3;
                    n2 = 0;
                }
            }
        }
        return n2;
    }

    private int selectListEntryForRadioReceptionList(int n) {
        int n2;
        RadioService radioService = this.getRadioService();
        int n3 = radioService.getCurrentStationBand();
        if (n3 == 2) {
            ReceptionList_Data receptionList_Data;
            int n4 = this.fullReceptionList != null ? (int)this.fullReceptionList.getInternalUserId(n) : -1;
            ReceptionList_Data receptionList_Data2 = receptionList_Data = this.fullReceptionList != null ? (ReceptionList_Data)this.fullReceptionList.getElement(n) : null;
            if (n4 == -1 || n4 >= this.getNumberOfElementsInReceptionList() || receptionList_Data == null) {
                n2 = 0;
                this.sendResult(n2);
            } else {
                RadioReceptionListElement radioReceptionListElement = this.getReceptionListElementAtPosition(n4);
                long l = radioReceptionListElement.getReceptionListElementUniqueId();
                if (radioService.getCurrentStationIndices().getCurrentStationIndicesStationListActiveID() == l) {
                    this.ensureCurrentAudioComponentForRadio();
                    n2 = 0;
                    this.sendResult(n2);
                } else {
                    switch (receptionList_Data.type) {
                        case 3: {
                            this.currentDACAction = 3;
                            this.ensureCurrentAudioComponentForRadio();
                            radioService.activateDABServiceByID(l);
                            n2 = 0;
                            break;
                        }
                        case 4: {
                            this.currentDACAction = 3;
                            this.ensureCurrentAudioComponentForRadio();
                            radioService.activateDABSecondaryServiceByID(l);
                            n2 = 0;
                            break;
                        }
                        default: {
                            n2 = 1;
                        }
                    }
                }
            }
        } else {
            long l;
            long l2 = l = this.fullReceptionList != null ? this.fullReceptionList.getInternalUserId(n) : -1L;
            if (l == -1L) {
                n2 = 0;
                this.sendResult(n2);
            } else {
                long l3 = radioService.getCurrentStationIndices().getCurrentStationIndicesStationListActiveID();
                long l4 = AudioSDCommon.filterOutPIFromUniqueID(l);
                if (l3 == l || l3 == l4) {
                    this.ensureCurrentAudioComponentForRadio();
                    n2 = 0;
                    this.sendResult(n2);
                } else if (n3 == 3) {
                    radioService.activateSatChannelByID(l);
                    this.currentDACAction = 3;
                    n2 = 0;
                } else {
                    int n5 = this.fullReceptionList != null ? this.fullReceptionList.getIndexOfBapPosId(n) : -1;
                    this.ensureCurrentAudioComponentForRadio();
                    radioService.activateStationByID(l, n5);
                    this.currentDACAction = 3;
                    n2 = 0;
                }
            }
        }
        return n2;
    }

    private int selectListEntryForRadioPresetList(int n) {
        int n2;
        if (this.fullRadioTvPresetList != null) {
            int n3 = (int)this.fullRadioTvPresetList.getInternalUserId(n);
            RadioService radioService = this.getRadioService();
            if (n3 == -1) {
                n2 = 0;
                this.sendResult(n2);
            } else if (radioService.getCurrentStationIndices().getCurrentStationIndicesActivePresetIndex() == n3) {
                this.ensureCurrentAudioComponentForRadio();
                n2 = 0;
                this.sendResult(n2);
            } else {
                this.ensureCurrentAudioComponentForRadio();
                if (radioService.getCurrentStationBand() == 3) {
                    radioService.activateSatChannelPreset(n3);
                } else {
                    radioService.activateStationPreset(n3);
                }
                this.currentDACAction = 2;
                n2 = 0;
            }
        } else {
            n2 = 1;
        }
        return n2;
    }

    private int selectListEntryForTvTunerPresetList(int n) {
        int n2;
        if (this.fullRadioTvPresetList != null) {
            int n3 = (int)this.fullRadioTvPresetList.getInternalUserId(n);
            RadioService radioService = this.getRadioService();
            TvTunerService tvTunerService = this.getTvTunerService();
            if (n3 == -1) {
                n2 = 0;
                this.sendResult(n2);
            } else if (radioService.getCurrentStationIndices().getCurrentStationIndicesActivePresetIndex() == n3) {
                this.ensureCurrentAudioComponentForTvTuner();
                n2 = 0;
                this.sendResult(n2);
            } else {
                this.ensureCurrentAudioComponentForTvTuner();
                tvTunerService.activateTvTunerPreset(n3);
                this.currentDACAction = 2;
                n2 = 0;
            }
        } else {
            n2 = 1;
        }
        return n2;
    }

    private int selectListEntryTPMemo(int n) {
        int n2;
        RadioService radioService = this.getRadioService();
        int n3 = radioService.getTpMemoListSelectedIndex();
        int n4 = (int)this.fullTPMemoList.getInternalUserId(n);
        if (n4 == -1) {
            n2 = 1;
        } else if (n3 == n4) {
            n2 = 0;
            this.sendResult(n2);
        } else {
            this.currentDACAction = 1;
            this.dacActionFromHandle = n3;
            this.dacActionToHandle = n4;
            n2 = 0;
            radioService.activateTrafficMessage(this.dacActionToHandle);
        }
        return n2;
    }

    private int selectListEntryForReceptionList(int n) {
        int n2;
        switch (this.getSoundService().getCurrentAudioComponent()) {
            case 1: {
                this.ensureCorrectSourceStateForRadioSelectListEntry();
                n2 = this.selectListEntryForRadioReceptionList(n);
                break;
            }
            case 5: {
                this.ensureCorrectSourceStateForTvTuner();
                n2 = this.selectListEntryForTvTunerReceptionList(n);
                break;
            }
            default: {
                n2 = 1;
            }
        }
        return n2;
    }

    private int selectListEntryForPresetList(int n) {
        int n2;
        switch (this.getSoundService().getCurrentAudioComponent()) {
            case 1: {
                this.ensureCorrectSourceStateForRadioSelectListEntry();
                n2 = this.selectListEntryForRadioPresetList(n);
                break;
            }
            case 5: {
                this.ensureCorrectSourceStateForTvTuner();
                n2 = this.selectListEntryForTvTunerPresetList(n);
                break;
            }
            default: {
                n2 = 1;
            }
        }
        return n2;
    }

    private int selectListEntryForMediaBrowser(int n) {
        int n2;
        if (this.currentMediaBrowserArrayList != null) {
            FsgArrayObjectId fsgArrayObjectId = this.currentMediaBrowserArrayList.getObjectId(n);
            if (fsgArrayObjectId != FsgArrayListWindowed.INVALID_OBJECT_ID) {
                n2 = 0;
                MediaService mediaService = this.getMediaService();
                MediaActiveTrackInfo mediaActiveTrackInfo = mediaService.getActiveTrackInfo();
                FsgArrayObjectId fsgArrayObjectId2 = MediaBrowser.createObjectID(mediaActiveTrackInfo.getActiveTrackEntryId(), mediaActiveTrackInfo.getActiveTrackContentType());
                if (this.getSoundService().getMuteActive() == 1 || !fsgArrayObjectId.equals(fsgArrayObjectId2) || mediaActiveTrackInfo.getActiveTrackAbsolutePosition() == -1) {
                    mediaService.playFileEntry(fsgArrayObjectId.getEntryId(), mediaService.getPlayEntryContentTypeForFileBrowserContentType(fsgArrayObjectId.getInternalUserId()));
                    this.currentDACAction = 7;
                } else {
                    mediaService.setPlayerPaused();
                    this.sendResult(n2);
                }
            } else {
                n2 = 1;
            }
        } else {
            n2 = 1;
        }
        return n2;
    }

    private int startDedicatedAudioControl(DedicatedAudioControl_StartResult dedicatedAudioControl_StartResult) {
        int n;
        SoundService soundService = this.getSoundService();
        RadioService radioService = this.getRadioService();
        block0 : switch (dedicatedAudioControl_StartResult.controlType) {
            case 0: {
                switch (dedicatedAudioControl_StartResult.listType) {
                    case 1: {
                        n = this.selectListEntryForReceptionList(dedicatedAudioControl_StartResult.additionalControlInformation);
                        break block0;
                    }
                    case 2: {
                        n = this.selectListEntryForPresetList(dedicatedAudioControl_StartResult.additionalControlInformation);
                        break block0;
                    }
                    case 3: {
                        int n2 = soundService.getCurrentAudioComponent();
                        if (!(this.getMediaBrowserActiveComponent() || n2 != 1 && n2 != 5)) {
                            if (this.getPresetListUsed()) {
                                n = this.selectListEntryForPresetList(dedicatedAudioControl_StartResult.additionalControlInformation);
                                break block0;
                            }
                            n = this.selectListEntryForReceptionList(dedicatedAudioControl_StartResult.additionalControlInformation);
                            break block0;
                        }
                        n = this.selectListEntryForMediaBrowser(dedicatedAudioControl_StartResult.additionalControlInformation);
                        break block0;
                    }
                    case 4: {
                        this.ensureCorrectSourceStateForRadioSelectListEntry();
                        n = this.selectListEntryTPMemo(dedicatedAudioControl_StartResult.additionalControlInformation);
                        break block0;
                    }
                }
                n = 1;
                break;
            }
            case 1: {
                int n3 = dedicatedAudioControl_StartResult.additionalControlInformation;
                n = this.dedicatedAudioControlNext(n3, dedicatedAudioControl_StartResult.listType);
                break;
            }
            case 2: {
                int n4 = dedicatedAudioControl_StartResult.additionalControlInformation;
                n = this.dedicatedAudioControlPrevious(n4, dedicatedAudioControl_StartResult.listType);
                break;
            }
            case 3: {
                if (dedicatedAudioControl_StartResult.listType == 0) {
                    n = this.dedicatedAudioControlFastForward();
                    break;
                }
                n = 1;
                break;
            }
            case 4: {
                if (dedicatedAudioControl_StartResult.listType == 0) {
                    n = this.dedicatedAudioControlFastBackward();
                    break;
                }
                n = 1;
                break;
            }
            case 5: {
                if (soundService.getCurrentAudioComponent() == 1) {
                    radioService.startUpdateStationList();
                    n = 0;
                    this.sendResult(n);
                    break;
                }
                n = 1;
                break;
            }
            case 6: {
                if (soundService.getCurrentAudioComponent() == 1) {
                    radioService.cancelUpdateStationList();
                    n = 0;
                    this.sendResult(n);
                    break;
                }
                n = 1;
                break;
            }
            case 7: {
                if (soundService.getCurrentAudioComponent() == 1) {
                    if (radioService.isRadioScanningActive()) {
                        radioService.stopScan();
                        this.currentDACAction = 6;
                        n = 0;
                        break;
                    }
                    if (radioService.isRadioSeekActive()) {
                        radioService.stopSeek();
                        this.currentDACAction = 6;
                        n = 0;
                        break;
                    }
                    n = 1;
                    break;
                }
                n = 1;
                break;
            }
            default: {
                n = 1;
            }
        }
        return n;
    }

    private int abortDedicatedAudioControlAction(DedicatedAudioControl_StartResult dedicatedAudioControl_StartResult) {
        int n;
        switch (dedicatedAudioControl_StartResult.controlType) {
            case 0: 
            case 1: 
            case 2: 
            case 6: 
            case 7: {
                n = 3;
                break;
            }
            case 3: {
                n = this.abortDedicatedAudioControlFastForward();
                break;
            }
            case 4: {
                n = this.abortDedicatedAudioControlFastBackward();
                break;
            }
            case 5: {
                if (this.getSoundService().getCurrentAudioComponent() == 1) {
                    this.getRadioService().cancelUpdateStationList();
                    n = 2;
                    break;
                }
                n = 3;
                break;
            }
            default: {
                n = 3;
            }
        }
        return n;
    }

    private void checkExpectedValuesAndSendResult(int n) {
        if (this.dacActionFromHandle != n) {
            if (n == this.dacActionToHandle) {
                this.sendResult(0);
            } else {
                this.sendResult(1);
            }
            this.currentDACAction = 0;
            this.dacActionFromHandle = -1;
            this.dacActionToHandle = -1;
            this.lastDedicatedAudioControlStartResult = null;
        }
    }

    private static boolean enoughElementsInListForNextPrev(FsgArrayListComplete fsgArrayListComplete) {
        return fsgArrayListComplete != null && fsgArrayListComplete.getSize() >= 2;
    }

    private boolean enoughElementsInScopeOfArrowKeysList() {
        boolean bl = this.getPresetListUsed() ? DedicatedAudioControl.enoughElementsInListForNextPrev(this.fullRadioTvPresetList) : DedicatedAudioControl.enoughElementsInListForNextPrev(this.fullReceptionList);
        return bl;
    }

    public void abortResult(BitStream bitStream, RequestContext requestContext) {
        this.abortResult(null, (MethodListener)((Object)requestContext));
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.currentDACAction != 0) {
            int n = this.abortDedicatedAudioControlAction(this.lastDedicatedAudioControlStartResult);
            this.sendResult(n);
            this.lastDedicatedAudioControlStartResult = null;
            this.currentDACAction = 0;
        } else {
            methodListener.requestError(80, this);
        }
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        DedicatedAudioControl_StartResult dedicatedAudioControl_StartResult = (DedicatedAudioControl_StartResult)bAPEntity;
        if (!DedicatedAudioControl.startResultParametersValid(dedicatedAudioControl_StartResult)) {
            methodListener.requestError(65, this);
        } else {
            int n;
            SystemService systemService = this.getSystemService();
            if (systemService.getSystemOnOffState() == 0 || systemService.getSystemOnOffState() == 1) {
                n = 1;
            } else if (this.currentDACAction == 0) {
                this.lastDedicatedAudioControlStartResult = dedicatedAudioControl_StartResult;
                this.currentStationHandleRequested = false;
                n = this.startDedicatedAudioControl(this.lastDedicatedAudioControlStartResult);
            } else {
                n = 1;
            }
            if (n != 0) {
                this.sendResult(n);
            } else {
                this.timer.retrigger(new Integer(0));
            }
        }
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
    public void initialize(boolean bl) {
        this.currentDACAction = 0;
        this.lastDedicatedAudioControlStartResult = null;
        this.currentStationHandleRequested = false;
    }

    @Override
    public void uninitialize() {
        this.timer.stop();
        this.getMediaService().removeHMIEventListener(this, MEDIA_LISTENER_HMI_EVENT_IDS);
        this.getRadioService().removeHMIEventListener(this, RADIO_LISTENER_HMI_EVENT_IDS);
    }

    protected void setCurrentStationHandleSend(Integer n) {
        this.currentStationHandleRequested = true;
    }

    protected void setCurrentStationHandleOutput(CurrentStation_Handle_Status currentStation_Handle_Status) {
        switch (this.currentDACAction) {
            case 2: 
            case 3: 
            case 4: 
            case 7: {
                if (!this.currentStationHandleRequested) break;
                this.currentDACAction = 0;
                this.lastDedicatedAudioControlStartResult = null;
                this.currentStationHandleRequested = false;
                this.sendResult(0);
                break;
            }
        }
        this.currentStationHandleFsgHandle = currentStation_Handle_Status.fsgHandle;
        this.currentStationHandlePresetRef = currentStation_Handle_Status.presetList_Ref;
    }

    protected void setCurrentSourceState(SourceState_Status sourceState_Status) {
        switch (this.currentDACAction) {
            case 6: {
                if (sourceState_Status.stateInfo == 1 || sourceState_Status.stateInfo == 6) break;
                this.currentDACAction = 0;
                this.lastDedicatedAudioControlStartResult = null;
                this.sendResult(0);
                break;
            }
            case 9: 
            case 10: {
                if (sourceState_Status.stateInfo == 6) break;
                this.currentDACAction = 0;
                this.lastDedicatedAudioControlStartResult = null;
                this.sendResult(2);
                break;
            }
            case 8: {
                if (sourceState_Status.stateInfo == 6) break;
                this.currentDACAction = 0;
                this.lastDedicatedAudioControlStartResult = null;
                this.sendResult(2);
                break;
            }
        }
    }

    protected void setFullRadioTvPresetList(FsgArrayListComplete fsgArrayListComplete) {
        this.fullRadioTvPresetList = fsgArrayListComplete;
    }

    protected void setFullReceptionList(FsgArrayListComplete fsgArrayListComplete) {
        this.fullReceptionList = fsgArrayListComplete;
    }

    protected void setFullTPMemoList(FsgArrayListComplete fsgArrayListComplete) {
        this.fullTPMemoList = fsgArrayListComplete;
    }

    protected void setCurrentMediaBrowserArrayList(FsgArrayListWindowed fsgArrayListWindowed) {
        this.currentMediaBrowserArrayList = fsgArrayListWindowed;
    }

    protected void setMediaBrowserActiveComponent(Boolean bl) {
        boolean bl2 = bl;
        if (this._mediaBrowserActiveComponent != bl2) {
            this._mediaBrowserActiveComponent = bl2;
        }
    }

    private void setPresetListUsed(Boolean bl) {
        this._radioPresetListUsed = bl;
    }

    private boolean getPresetListUsed() {
        return this._radioPresetListUsed;
    }

    private boolean getMediaBrowserActiveComponent() {
        return this._mediaBrowserActiveComponent;
    }

    protected void setCurrentStationInfoSend(Boolean bl) {
        switch (this.currentDACAction) {
            case 5: {
                int n = this.getMediaService().getCurrentTrackInfo().getCurrentTrackNumber();
                this.checkExpectedValuesAndSendResult(n);
                break;
            }
            case 8: {
                if (this.getRadioService().getCurrentStationBand() == 0 && this.getSoundService().getCurrentAudioComponent() == 1) break;
                this.currentDACAction = 0;
                this.lastDedicatedAudioControlStartResult = null;
                this.sendResult(2);
                break;
            }
        }
    }

    protected void setCurrentTPMemoInfoSend(TpMemoInfo_Status tpMemoInfo_Status) {
        switch (this.currentDACAction) {
            case 1: {
                int n = this.getRadioService().getTpMemoListSelectedIndex();
                this.checkExpectedValuesAndSendResult(n);
                break;
            }
        }
    }

    protected void videoDvdUserActionBlocked() {
        switch (this.currentDACAction) {
            case 10: {
                this.currentDACAction = 0;
                this.lastDedicatedAudioControlStartResult = null;
                this.sendResult(2);
                break;
            }
        }
    }

    protected void tunerInitialAutoStoreStarted() {
        switch (this.currentDACAction) {
            case 2: 
            case 3: 
            case 4: {
                this.lastDedicatedAudioControlStartResult = null;
                this.sendResult(2);
                break;
            }
        }
    }

    protected void mediaBrowserActionWasPerformed() {
        if (this.currentDACAction == 7) {
            this.currentDACAction = 0;
            this.lastDedicatedAudioControlStartResult = null;
            this.sendResult(0);
        }
    }

    @Override
    public void timerFired(Timer timer) {
        if (this.currentDACAction != 0) {
            this.currentDACAction = 0;
            this.dacActionFromHandle = -1;
            this.dacActionToHandle = -1;
            this.lastDedicatedAudioControlStartResult = null;
            this.sendResult(1);
        }
    }

    @Override
    public void processHMIEvent(int n) {
        switch (n) {
            case 430: {
                this.videoDvdUserActionBlocked();
                break;
            }
            case 201: {
                this.tunerInitialAutoStoreStarted();
                break;
            }
            case 556: {
                this.mediaBrowserActionWasPerformed();
                break;
            }
        }
    }

    @Override
    public void updateRadioData(RadioService radioService, int n) {
        this.process(-1);
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
        MEDIA_LISTENER_HMI_EVENT_IDS = new int[]{430, 556};
        RADIO_LISTENER_HMI_EVENT_IDS = new int[]{201};
    }
}

