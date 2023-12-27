/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.asl.api.bap.timer.Timer;
import de.vw.mib.asl.api.bap.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.mqbpq.audiosd.api.stages.DedicatedAudioControlStage;
import de.vw.mib.bap.mqbpq.audiosd.functions.AudioSDCommon;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.LongIterator;
import de.vw.mib.bap.mqbpq.common.api.asl.audio.ASLAVDCAudio;
import de.vw.mib.bap.mqbpq.common.api.asl.audio.ASLAVDCAudioBrowser;
import de.vw.mib.bap.mqbpq.common.api.asl.audio.ASLRadio;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.DedicatedAudioControl_Result;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.DedicatedAudioControl_StartResult;

public class DedicatedAudioControl
extends DedicatedAudioControlStage
implements TimerNotifier {
    private BAPStageInitializer _stageInitializer;
    private Timer _monitorTimer;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_TIME_OUT_ACTION_FAILED;
    private static final int DAC_ACTION_NO_ACTION;
    private static final int DAC_ACTION_PRESET_LIST_NEW_ENTRY;
    private static final int DAC_ACTION_RECEPTION_LIST_NEW_ENTRY;
    private static final int DAC_ACTION_RADIO_TUNE_TO_STATION;
    private static final int DAC_ACTION_CONTINOUS_ACTION_TILL_ABORT_RADIO;
    private static final int DAC_ACTION_CONTINOUS_ACTION_TILL_ABORT_MEDIA;
    private static final int DAC_ACTION_CONTINOUS_ACTION_TILL_ABORT_VIDEO;
    private int _currentDACAction;
    private boolean _currentStationHandleRequested;
    private int _lastControlType;
    private int _bapInfoListType;
    private BAPArrayList _infoList;
    private int _currentFsgHandle;
    private int _lastValidFsgHandle;
    private static final int MINIMUM_SKIP_COUNTER;
    private static final int TP_MEMO_SECONDS_TO_SKIP;
    private static final int MIN_NUMBER_OF_ELEMENTS_FOR_PREV_NEXT;
    private static final int DIRECTION_FORWARD;
    private static final int DIRECTION_BACKWARD;
    private static final int INVALID_INDEX;
    private static final int INVALID_HANDLE_REF;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        this.setStageInitializer(bAPStageInitializer);
        return null;
    }

    private BAPStageInitializer getStageInitializer() {
        return this._stageInitializer;
    }

    private void setStageInitializer(BAPStageInitializer bAPStageInitializer) {
        this._stageInitializer = bAPStageInitializer;
    }

    private Timer getMonitorTimer() {
        if (this._monitorTimer == null) {
            this._monitorTimer = this.getStageInitializer().createTimer(this, this, 0, 0);
        }
        return this._monitorTimer;
    }

    private int getCurrentDACAction() {
        return this._currentDACAction;
    }

    private void setCurrentDACAction(int n) {
        this._currentDACAction = n;
    }

    private void setLastRequestedBapControlType(int n) {
        this._lastControlType = n;
    }

    private int getLastRequestedBapControlType() {
        return this._lastControlType;
    }

    private void setCurrentStationHandleRequested(boolean bl) {
        this._currentStationHandleRequested = bl;
    }

    @Override
    protected void setCurrentStationHandleRequested(Boolean bl) {
        this.setCurrentStationHandleRequested(true);
    }

    private boolean isCurrentStationHandleRequested() {
        return this._currentStationHandleRequested;
    }

    private int getBapInfoListType() {
        return this._bapInfoListType;
    }

    private void setBapInfoListType(int n) {
        this._bapInfoListType = n;
    }

    @Override
    protected void setBapInfoListType(Integer n) {
        this.setBapInfoListType((int)n);
    }

    private BAPArrayList getReceptionList() {
        return this._infoList;
    }

    @Override
    protected void setReceptionList(BAPArrayList bAPArrayList) {
        this._infoList = bAPArrayList;
    }

    private BAPArrayList getRadioPresetList() {
        return this.getReceptionList();
    }

    private int getLastValidFsgHandle() {
        return this._lastValidFsgHandle;
    }

    private void setLastValidFsgHandle(int n) {
        this._lastValidFsgHandle = n;
    }

    private int getCurrentFsgHandle() {
        return this._currentFsgHandle;
    }

    private void setCurrentFsgHandle(int n) {
        this._currentFsgHandle = n;
        if (n != 0) {
            this.setLastValidFsgHandle(n);
        }
    }

    @Override
    public void initialize(boolean bl) {
        this.setCurrentDACAction(0);
        this.setCurrentStationHandleRequested(false);
    }

    @Override
    public void uninitialize() {
        this.getMonitorTimer().stop();
    }

    @Override
    public void process(int n) {
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        DedicatedAudioControl_StartResult dedicatedAudioControl_StartResult = (DedicatedAudioControl_StartResult)bAPEntity;
        if (!DedicatedAudioControl.startResultParametersValid(dedicatedAudioControl_StartResult)) {
            methodListener.requestError(65, this);
        } else {
            int n;
            if (this.getCurrentDACAction() == 0) {
                this.setLastRequestedBapControlType(dedicatedAudioControl_StartResult.controlType);
                this.setCurrentStationHandleRequested(false);
                n = this.startDedicatedAudioControl(dedicatedAudioControl_StartResult);
            } else {
                n = 1;
            }
            if (n != 0) {
                this.sendResult(n);
            } else {
                this.getMonitorTimer().retrigger(0);
            }
        }
    }

    private int abortDedicatedAudioControlFastForwardForVideo() {
        int n;
        if (this.getCurrentAudioSource() != 0) {
            ASLAVDCAudio.stopFastForward();
            n = 2;
        } else {
            n = 1;
        }
        return n;
    }

    private int abortDedicatedAudioControlFastForward() {
        int n;
        switch (this.getCurrentAudioComponent()) {
            case 2: {
                if (this.isDvdVideo()) {
                    n = this.abortDedicatedAudioControlFastForwardForVideo();
                    break;
                }
                if (this.getCurrentAudioSource() != 0) {
                    ASLAVDCAudio.stopFastForward();
                    n = 2;
                    break;
                }
                n = 1;
                break;
            }
            case 1: {
                if (this.getCurrentStationInfoBand() == 0) {
                    ASLRadio.stopChangingFrequency();
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

    private int abortDedicatedAudioControlFastBackwardForVideo() {
        int n;
        if (this.getCurrentAudioSource() != 0) {
            ASLAVDCAudio.stopFastRewind();
            n = 2;
        } else {
            n = 1;
        }
        return n;
    }

    private int abortDedicatedAudioControlFastBackward() {
        int n;
        switch (this.getCurrentAudioComponent()) {
            case 2: {
                if (this.isDvdVideo()) {
                    n = this.abortDedicatedAudioControlFastBackwardForVideo();
                    break;
                }
                if (this.getCurrentAudioSource() != 0) {
                    ASLAVDCAudio.stopFastRewind();
                    n = 2;
                    break;
                }
                n = 1;
                break;
            }
            case 1: {
                if (this.getCurrentStationInfoBand() == 0) {
                    ASLRadio.stopChangingFrequency();
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

    private int abortDedicatedAudioControlAction() {
        int n;
        switch (this.getLastRequestedBapControlType()) {
            case 0: 
            case 1: 
            case 2: {
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
            default: {
                n = 3;
            }
        }
        return n;
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.getCurrentDACAction() != 0) {
            int n = this.abortDedicatedAudioControlAction();
            this.sendResult(n);
            this.setCurrentDACAction(0);
        } else {
            methodListener.requestError(80, this);
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
    public void timerFired(int n) {
        if (this.getCurrentDACAction() != 0) {
            this.setCurrentDACAction(0);
            this.sendResult(1);
        }
    }

    @Override
    protected void setCurrentFsgHandle(Integer n) {
        switch (this.getCurrentDACAction()) {
            case 2: 
            case 3: 
            case 4: {
                if (!this.isCurrentStationHandleRequested()) break;
                this.setCurrentDACAction(0);
                this.setCurrentStationHandleRequested(false);
                this.sendResult(0);
                break;
            }
            case 8: {
                if (this.getCurrentStationInfoBand() == 0 && this.getCurrentAudioComponent() == 1) break;
                this.setCurrentDACAction(0);
                this.sendResult(2);
                break;
            }
        }
        this.setCurrentFsgHandle((int)n);
    }

    @Override
    protected void videoDvdUserActionBlocked() {
        switch (this.getCurrentDACAction()) {
            case 10: {
                this.setCurrentDACAction(0);
                this.sendResult(2);
                break;
            }
        }
    }

    @Override
    protected void tunerInitialAutoStoreStarted() {
        switch (this.getCurrentDACAction()) {
            case 2: 
            case 3: 
            case 4: {
                this.sendResult(2);
                break;
            }
        }
    }

    private void ensureCorrectSourceStateForRadioSelectListEntry() {
        if (this.getRadioScanning()) {
            if (this.getCurrentStationInfoBand() != 2) {
                ASLRadio.stopScan();
            }
        } else if (this.getRadioSeekActive()) {
            ASLRadio.stopSeek();
        } else if (this.getManualModeActive()) {
            ASLRadio.setManualMode(false);
        }
    }

    private void ensureCurrentAudioComponentForRadio() {
        block0 : switch (this.getCurrentAudioComponent()) {
            case 1: {
                break;
            }
            default: {
                switch (this.getCurrentStationInfoBand()) {
                    case 0: {
                        ASLRadio.activateBand(0);
                        break block0;
                    }
                    case 1: {
                        ASLRadio.activateBand(1);
                        break block0;
                    }
                    case 2: {
                        ASLRadio.activateBand(2);
                        break block0;
                    }
                    case 3: {
                        ASLRadio.activateBand(3);
                        break block0;
                    }
                }
            }
        }
    }

    private int selectListEntryForRadioReceptionList(int n) {
        int n2;
        BAPArrayList bAPArrayList = this.getReceptionList();
        int n3 = this.getCurrentStationInfoBand();
        if (n3 == 2) {
            int n4;
            LongIterator longIterator = this.getReceptionListUniqueId();
            int n5 = n4 = bAPArrayList != null ? (int)bAPArrayList.getElementAnchorID(n) : -1;
            if (n4 == -1 || n4 > longIterator.size() || bAPArrayList == null) {
                n2 = 0;
                this.sendResult(n2);
            } else {
                long l = longIterator.longAtIndex(n4);
                if (this.getStationListActiveIndex() == l) {
                    this.ensureCurrentAudioComponentForRadio();
                    n2 = 0;
                    this.sendResult(n2);
                } else {
                    this.setCurrentDACAction(3);
                    this.ensureCurrentAudioComponentForRadio();
                    ASLRadio.activateDABServiceByID(l);
                    n2 = 0;
                }
            }
        } else {
            long l;
            long l2 = l = bAPArrayList != null ? bAPArrayList.getElementAnchorID(n) : -1L;
            if (l == -1L) {
                n2 = 0;
                this.sendResult(n2);
            } else {
                long l3 = this.getStationListActiveIndex();
                long l4 = AudioSDCommon.filterOutPIFromUniqueID(l);
                if (l3 == l || l3 == l4) {
                    this.ensureCurrentAudioComponentForRadio();
                    n2 = 0;
                    this.sendResult(n2);
                } else if (n3 == 3) {
                    ASLRadio.satActivateChannelByID(l);
                    this.setCurrentDACAction(3);
                    n2 = 0;
                } else {
                    int n6 = bAPArrayList != null ? bAPArrayList.getAbsPosition(n) : -1;
                    this.ensureCurrentAudioComponentForRadio();
                    ASLRadio.activateStationByID(l, n6);
                    this.setCurrentDACAction(3);
                    n2 = 0;
                }
            }
        }
        return n2;
    }

    private int selectListEntryForReceptionList(int n) {
        int n2;
        switch (this.getCurrentAudioComponent()) {
            case 1: {
                this.ensureCorrectSourceStateForRadioSelectListEntry();
                n2 = this.selectListEntryForRadioReceptionList(n);
                break;
            }
            default: {
                n2 = 1;
            }
        }
        return n2;
    }

    private int selectListEntryForRadioPresetList(int n) {
        int n2;
        BAPArrayList bAPArrayList = this.getRadioPresetList();
        if (bAPArrayList != null) {
            int n3 = (int)bAPArrayList.getElementAnchorID(n);
            if (n3 == -1) {
                n2 = 0;
                this.sendResult(n2);
            } else if (this.getPresetBankActiveIndex() == n3) {
                this.ensureCurrentAudioComponentForRadio();
                n2 = 0;
                this.sendResult(n2);
            } else {
                this.ensureCurrentAudioComponentForRadio();
                if (this.getCurrentStationInfoBand() == 3) {
                    ASLRadio.satActivateChannelPreset(n3);
                } else {
                    ASLRadio.activateStationPreset(n3);
                }
                this.setCurrentDACAction(2);
                n2 = 0;
            }
        } else {
            n2 = 1;
        }
        return n2;
    }

    private int selectListEntryForPresetList(int n) {
        int n2;
        switch (this.getCurrentAudioComponent()) {
            case 1: {
                this.ensureCorrectSourceStateForRadioSelectListEntry();
                n2 = this.selectListEntryForRadioPresetList(n);
                break;
            }
            default: {
                n2 = 1;
            }
        }
        return n2;
    }

    private void ensureCorrectSourceStateForMediaFastForwardBackward() {
    }

    private void ensureCorrectSourceStateForMediaPreviousNext() {
        this.ensureCorrectSourceStateForMediaFastForwardBackward();
        if (this.getAvdcRepeatActive() && this.getAvdcRepeatMode() == 2) {
            ASLAVDCAudioBrowser.setRepeatMode(0);
        }
    }

    private boolean isDvdVideo() {
        int n = this.getCDContentType();
        int n2 = this.getCurrentAudioSource();
        return !(n2 != 1 && n2 != 4 || n != 3 && n != 4);
    }

    private int dedicatedAudioControlNextForVideo() {
        int n = this.getDvdChapterCount();
        if (n <= 1) {
            ASLAVDCAudio.activateSelectedDVDMenuItem();
        } else {
            ASLAVDCAudio.activateNextDVDChapter();
        }
        int n2 = 0;
        this.sendResult(n2);
        return n2;
    }

    private int findPresetListIndex(int n) {
        int n2;
        int n3;
        BAPArrayList bAPArrayList = this.getRadioPresetList();
        if (bAPArrayList == null || bAPArrayList.size() == 0) {
            return -1;
        }
        int n4 = this.getCurrentFsgHandle() == 0 ? bAPArrayList.firstBAPPosID() : this.getCurrentFsgHandle();
        int n5 = bAPArrayList.getAbsPosition(n4);
        int n6 = n3 = this.getCurrentFsgHandle() == 0 && Math.abs(n) <= 1 ? n5 : n5 + n;
        if (n3 < 0) {
            n2 = (int)bAPArrayList.getElementAnchorID(bAPArrayList.firstBAPPosID());
        } else if (n3 >= bAPArrayList.size()) {
            n2 = (int)bAPArrayList.getElementAnchorID(bAPArrayList.lastBAPPosID());
        } else {
            int n7 = n3 - n5;
            n2 = (int)bAPArrayList.getElementAnchorID(bAPArrayList.nextBapPosID(n4, n7));
        }
        return n2;
    }

    private static boolean enoughElementsInListForNextPrev(BAPArrayList bAPArrayList) {
        return bAPArrayList != null && bAPArrayList.size() >= 2;
    }

    private int findReceptionHandle(int n) {
        int n2;
        BAPArrayList bAPArrayList = this.getRadioPresetList();
        if (bAPArrayList == null || bAPArrayList.size() == 0) {
            return 0;
        }
        int n3 = this.getCurrentFsgHandle() == 0 ? bAPArrayList.firstBAPPosID() : this.getCurrentFsgHandle();
        int n4 = bAPArrayList.getAbsPosition(n3);
        int n5 = n4 + n;
        if (n5 < 0) {
            n2 = bAPArrayList.firstBAPPosID();
        } else if (n5 >= bAPArrayList.size()) {
            n2 = bAPArrayList.lastBAPPosID();
        } else {
            int n6 = n5 - n4;
            n2 = bAPArrayList.nextBapPosID(n3, n6);
        }
        return n2;
    }

    private int findNextReceptionListHandle() {
        int n;
        BAPArrayList bAPArrayList = this.getRadioPresetList();
        if (this.getCurrentFsgHandle() == 0 || bAPArrayList == null || bAPArrayList.size() == 0) {
            if (bAPArrayList != null && bAPArrayList.size() != 0) {
                n = bAPArrayList.nextBapPosID(this.getLastValidFsgHandle());
                if (n == 0) {
                    n = bAPArrayList.firstBAPPosID();
                }
            } else {
                n = 0;
            }
        } else {
            n = bAPArrayList.nextBapPosID(this.getCurrentFsgHandle());
            if (n == 0) {
                n = bAPArrayList.firstBAPPosID();
            }
        }
        return n;
    }

    private boolean enoughElementsInScopeOfArrowKeysList() {
        boolean bl;
        switch (this.getArrawKeyScopeMode()) {
            case 0: {
                bl = DedicatedAudioControl.enoughElementsInListForNextPrev(this.getRadioPresetList());
                break;
            }
            default: {
                bl = DedicatedAudioControl.enoughElementsInListForNextPrev(this.getReceptionList());
            }
        }
        return bl;
    }

    private int dedicatedAudioControlNextRadio(int n, int n2) {
        int n3;
        switch (n2) {
            case 2: {
                int n4 = this.findPresetListIndex(n == 0 ? 1 : n);
                if (n4 != -1 && n4 == this.getPresetBankActiveIndex()) {
                    n3 = 0;
                    this.sendResult(n3);
                    break;
                }
                if (n4 != -1) {
                    this.ensureCorrectSourceStateForRadioSelectListEntry();
                    if (this.getCurrentStationInfoBand() == 3) {
                        ASLRadio.satActivateChannelPreset(n4);
                    } else {
                        ASLRadio.activateStationPreset(n4);
                    }
                    this.setCurrentDACAction(2);
                    n3 = 0;
                    break;
                }
                n3 = 1;
                break;
            }
            case 3: {
                this.ensureCorrectSourceStateForRadioSelectListEntry();
                if (!DedicatedAudioControl.enoughElementsInListForNextPrev(this.getReceptionList())) {
                    if (this.getCurrentStationInfoBand() == 3) {
                        ASLRadio.satActivateNextChannel();
                    } else {
                        ASLRadio.activateNextStation();
                    }
                    n3 = 0;
                    this.sendResult(n3);
                    break;
                }
                if (n > 1) {
                    n3 = this.selectListEntryForRadioReceptionList(this.findReceptionHandle(n));
                    break;
                }
                if (this.getCurrentStationInfoBand() == 3) {
                    ASLRadio.satActivateNextChannelList();
                    this.setCurrentDACAction(3);
                    n3 = 0;
                    break;
                }
                n3 = this.selectListEntryForRadioReceptionList(this.findNextReceptionListHandle());
                break;
            }
            case 255: {
                this.ensureCorrectSourceStateForRadioSelectListEntry();
                if (this.getCurrentStationInfoBand() == 3) {
                    ASLRadio.satActivateNextChannel();
                } else {
                    ASLRadio.activateNextStation();
                }
                n3 = 0;
                boolean bl = this.enoughElementsInScopeOfArrowKeysList();
                if (bl) {
                    this.setCurrentDACAction(4);
                    break;
                }
                this.setCurrentDACAction(0);
                this.sendResult(n3);
                break;
            }
            default: {
                n3 = 1;
            }
        }
        return n3;
    }

    private int dedicatedAudioControlNext(int n, int n2) {
        int n3;
        switch (this.getCurrentAudioComponent()) {
            case 2: {
                if (this.isDvdVideo()) {
                    n3 = this.dedicatedAudioControlNextForVideo();
                    break;
                }
                if (this.getSkipForwardSupported() && this.getCurrentAudioSource() != 0) {
                    this.ensureCorrectSourceStateForMediaPreviousNext();
                    if (n > 1) {
                        ASLAVDCAudio.skipForwardWithCounter(n);
                    } else {
                        ASLAVDCAudio.skipForwardWithCounter(1);
                    }
                    n3 = 0;
                    this.sendResult(n3);
                    break;
                }
                n3 = 1;
                break;
            }
            case 1: {
                n3 = this.dedicatedAudioControlNextRadio(n, n2);
                break;
            }
            case 3: {
                n3 = this.dedicatedAudioControlNextForVideo();
                break;
            }
            default: {
                n3 = 1;
            }
        }
        return n3;
    }

    private int findPreviousReceptionListHandle() {
        int n;
        BAPArrayList bAPArrayList = this.getRadioPresetList();
        if (this.getCurrentFsgHandle() == 0 || bAPArrayList == null || bAPArrayList.size() == 0) {
            if (bAPArrayList != null && bAPArrayList.size() != 0) {
                n = bAPArrayList.previousBapPosID(this.getLastValidFsgHandle());
                if (n == 0) {
                    n = bAPArrayList.firstBAPPosID();
                }
            } else {
                n = 0;
            }
        } else {
            n = bAPArrayList.previousBapPosID(this.getCurrentFsgHandle());
            if (n == 0) {
                n = bAPArrayList.lastBAPPosID();
            }
        }
        return n;
    }

    private int dedicatedAudioControlPreviousRadio(int n, int n2) {
        int n3;
        switch (n2) {
            case 2: {
                int n4 = this.findPresetListIndex(n == 0 ? -1 : -n);
                if (n4 != -1 && n4 == this.getPresetBankActiveIndex()) {
                    n3 = 0;
                    this.sendResult(n3);
                    break;
                }
                if (n4 != -1) {
                    this.ensureCorrectSourceStateForRadioSelectListEntry();
                    if (this.getCurrentStationInfoBand() == 3) {
                        ASLRadio.satActivateChannelPreset(n4);
                    } else {
                        ASLRadio.activateStationPreset(n4);
                    }
                    this.setCurrentDACAction(2);
                    n3 = 0;
                    break;
                }
                n3 = 1;
                break;
            }
            case 3: {
                this.ensureCorrectSourceStateForRadioSelectListEntry();
                if (!DedicatedAudioControl.enoughElementsInListForNextPrev(this.getReceptionList())) {
                    if (this.getCurrentStationInfoBand() == 3) {
                        ASLRadio.satActivatePreviousChannel();
                    } else {
                        ASLRadio.activatePreviousStation();
                    }
                    n3 = 0;
                    this.sendResult(n3);
                    break;
                }
                if (n > 1) {
                    n3 = this.selectListEntryForRadioReceptionList(this.findReceptionHandle(-n));
                    break;
                }
                if (this.getCurrentStationInfoBand() == 3) {
                    ASLRadio.satActivatePreviousChannelList();
                    this.setCurrentDACAction(3);
                    n3 = 0;
                    break;
                }
                n3 = this.selectListEntryForRadioReceptionList(this.findPreviousReceptionListHandle());
                break;
            }
            case 255: {
                this.ensureCorrectSourceStateForRadioSelectListEntry();
                if (this.getCurrentStationInfoBand() == 3) {
                    ASLRadio.satActivatePreviousChannel();
                } else {
                    ASLRadio.activatePreviousStation();
                }
                n3 = 0;
                boolean bl = this.enoughElementsInScopeOfArrowKeysList();
                if (bl) {
                    this.setCurrentDACAction(4);
                    break;
                }
                this.setCurrentDACAction(0);
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
        ASLAVDCAudio.activatePreviousDVDChapter();
        int n = 0;
        this.sendResult(n);
        return n;
    }

    private int dedicatedAudioControlPrevious(int n, int n2) {
        int n3;
        switch (this.getCurrentAudioComponent()) {
            case 2: {
                if (this.isDvdVideo()) {
                    n3 = this.dedicatedAudioControlPreviousForVideo();
                    break;
                }
                if (this.getSkipBackwardSupported() && this.getCurrentAudioSource() != 0) {
                    this.ensureCorrectSourceStateForMediaPreviousNext();
                    if (n > 1) {
                        ASLAVDCAudio.skipBackwardWithCounter(n);
                    } else {
                        ASLAVDCAudio.skipBackwardWithCounter(1);
                    }
                    n3 = 0;
                    this.sendResult(n3);
                    break;
                }
                n3 = 1;
                break;
            }
            case 1: {
                n3 = this.dedicatedAudioControlPreviousRadio(n, n2);
                break;
            }
            case 3: {
                n3 = this.dedicatedAudioControlPreviousForVideo();
                break;
            }
            default: {
                n3 = 1;
            }
        }
        return n3;
    }

    private int dedicatedAudioControlFastForwardForVideo() {
        int n;
        if (this.getCurrentAudioSource() != 0) {
            ASLAVDCAudio.startFastForward();
            this.setCurrentDACAction(10);
            n = 0;
        } else {
            n = 1;
        }
        return n;
    }

    private int dedicatedAudioControlFastForward() {
        int n;
        switch (this.getCurrentAudioComponent()) {
            case 2: {
                if (this.isDvdVideo()) {
                    n = this.dedicatedAudioControlFastForwardForVideo();
                    break;
                }
                if (this.getCurrentAudioSource() != 0) {
                    this.ensureCorrectSourceStateForMediaFastForwardBackward();
                    ASLAVDCAudio.startFastForward();
                    this.setCurrentDACAction(9);
                    n = 0;
                    break;
                }
                n = 1;
                break;
            }
            case 1: {
                if (this.getCurrentStationInfoBand() == 0) {
                    ASLRadio.startTargetSeek(1);
                    this.setCurrentDACAction(8);
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
                if (this.getCurrentMainContext() == 10) {
                    ASLRadio.fastForwardTrafficMessage(10);
                    this.sendResult(0);
                    n = 0;
                    break;
                }
                n = 1;
            }
        }
        return n;
    }

    private int dedicatedAudioControlFastBackwardForVideo() {
        int n;
        if (this.getCurrentAudioSource() != 0) {
            ASLAVDCAudio.startFastRewind();
            this.setCurrentDACAction(10);
            n = 0;
        } else {
            n = 1;
        }
        return n;
    }

    private int dedicatedAudioControlFastBackward() {
        int n;
        switch (this.getCurrentAudioComponent()) {
            case 2: {
                if (this.isDvdVideo()) {
                    n = this.dedicatedAudioControlFastBackwardForVideo();
                    break;
                }
                if (this.getCurrentAudioSource() != 0) {
                    this.ensureCorrectSourceStateForMediaFastForwardBackward();
                    ASLAVDCAudio.startFastRewind();
                    this.setCurrentDACAction(9);
                    n = 0;
                    break;
                }
                n = 1;
                break;
            }
            case 1: {
                if (this.getCurrentStationInfoBand() == 0) {
                    ASLRadio.startTargetSeek(0);
                    this.setCurrentDACAction(8);
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
                if (this.getCurrentMainContext() == 10) {
                    ASLRadio.rewindTrafficMessage(10);
                    this.sendResult(0);
                    n = 0;
                    break;
                }
                n = 1;
            }
        }
        return n;
    }

    private int startDedicatedAudioControl(DedicatedAudioControl_StartResult dedicatedAudioControl_StartResult) {
        int n;
        block0 : switch (dedicatedAudioControl_StartResult.controlType) {
            case 0: {
                switch (this.getBapInfoListType()) {
                    case 3: {
                        n = this.selectListEntryForReceptionList(dedicatedAudioControl_StartResult.additionalControlInformation);
                        break block0;
                    }
                    case 2: {
                        n = this.selectListEntryForPresetList(dedicatedAudioControl_StartResult.additionalControlInformation);
                        break block0;
                    }
                }
                n = 1;
                break;
            }
            case 1: {
                int n2 = dedicatedAudioControl_StartResult.additionalControlInformation;
                n = this.dedicatedAudioControlNext(n2, this.getBapInfoListType());
                break;
            }
            case 2: {
                int n3 = dedicatedAudioControl_StartResult.additionalControlInformation;
                n = this.dedicatedAudioControlPrevious(n3, this.getBapInfoListType());
                break;
            }
            case 3: {
                n = this.dedicatedAudioControlFastForward();
                break;
            }
            case 4: {
                n = this.dedicatedAudioControlFastBackward();
                break;
            }
            default: {
                n = 1;
            }
        }
        return n;
    }

    private void sendResult(int n) {
        DedicatedAudioControl_Result dedicatedAudioControl_Result = this.dequeueBAPEntity();
        dedicatedAudioControl_Result.dedicatedAudioControlResult = n;
        this.getDelegate().getMethodListener(this).result(dedicatedAudioControl_Result, this);
    }

    private static boolean startResultParametersValid(DedicatedAudioControl_StartResult dedicatedAudioControl_StartResult) {
        boolean bl;
        switch (dedicatedAudioControl_StartResult.controlType) {
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
        return bl;
    }
}

