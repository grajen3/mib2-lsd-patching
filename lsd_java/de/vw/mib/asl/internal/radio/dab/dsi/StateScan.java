/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.dsi;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioServiceManager;
import de.vw.mib.asl.internal.radio.dab.DabTunerState;
import de.vw.mib.asl.internal.radio.dab.EnsembleInfoHash;
import de.vw.mib.asl.internal.radio.dab.dsi.AbstractState;
import de.vw.mib.asl.internal.radio.dab.dsi.HsmDabDsi;
import de.vw.mib.asl.internal.radio.dab.main.DabMainApi;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.HsmState;
import java.util.HashSet;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class StateScan
extends AbstractState {
    private static final long TIMEOUT;
    private final HsmDabDsi mDsiHsm;
    private boolean mSeekTriggeredFirstTime = false;
    private boolean mSeekRunning = false;
    private boolean ignoreSyncStatus = false;
    private FrequencyInfo mStartFrequency;
    private ServiceInfo mStartService;
    private EnsembleInfo mStartEnsemble;
    private ServiceInfo[] mCurrentServiceList = null;
    private int mCurrentServiceIndex = -1;
    private EnsembleInfo mFoundEnsemble = null;
    private EnsembleInfo endEnsemble = null;
    private FrequencyInfo mCurrentTunedFrequency = null;
    private boolean mSeekReceivedStartFrequency = false;
    private HashSet mTunedEnsembles = new HashSet();
    private int servIndexAfterReceivedStartFreq = -1;
    private int frequencySteps = 0;

    public StateScan(HsmDabDsi hsmDabDsi, String string, HsmState hsmState) {
        super(hsmDabDsi, string, hsmState);
        this.mDsiHsm = hsmDabDsi;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateScan is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("StateScan - Entry").log();
                }
                this.mCurrentTunedFrequency = this.mStartFrequency = RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo();
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("Starting Freq is : ").append(this.mStartFrequency).log();
                }
                this.mStartService = RadioData.getDabDatabase().mTunerState.getCurrentService();
                this.mFoundEnsemble = this.mStartEnsemble = RadioData.getDabDatabase().mTunerState.getCurrentEnsemble();
                this.endEnsemble = null;
                this.mSeekTriggeredFirstTime = false;
                this.mCurrentServiceIndex = -1;
                this.mCurrentServiceList = null;
                this.mSeekReceivedStartFrequency = false;
                this.frequencySteps = 0;
                this.mTarget.mCurrentEvent.setBlocked(true);
                break;
            }
            case 3: {
                GuiApiDab.setUpdateStationInfoBlocked(true);
                this.mTunedEnsembles.clear();
                if (this.mFoundEnsemble != null) {
                    this.mTunedEnsembles.add(new EnsembleInfoHash(this.mFoundEnsemble));
                }
                if ((this.mTarget.mSyncStatus == 4 || this.mTarget.mSyncStatus == 3) && this.mStartService != null) {
                    this.mCurrentServiceList = RadioData.getDabDatabase().mTunerState.getServicesByEnsemble(this.mFoundEnsemble);
                    this.mCurrentServiceIndex = this.mCurrentServiceList.length;
                    for (int i2 = 0; i2 < this.mCurrentServiceList.length; ++i2) {
                        if (!DabTunerState.compare(this.mStartService, this.mCurrentServiceList[i2])) continue;
                        this.mCurrentServiceIndex = i2;
                        break;
                    }
                    if (this.mCurrentServiceIndex == this.mCurrentServiceList.length - 1) {
                        this.startSeek();
                    } else {
                        this.tuneNextService();
                    }
                } else {
                    this.startSeek();
                }
                this.servIndexAfterReceivedStartFreq = -1;
                break;
            }
            case 100011: 
            case 100104: {
                if (this.mTarget.mNextEvent != null && this.mTarget.mNextEvent.getReceiverEventId() == -1434058496) {
                    this.mTarget.sendResult(this.mTarget.mNextEvent, 1);
                    this.mTarget.mNextEvent = null;
                }
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("StateScan - scan stopped by cancel event").log();
                }
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 100002: 
            case 100003: 
            case 100004: 
            case 100006: 
            case 100009: 
            case 100010: 
            case 100012: 
            case 100016: 
            case 100021: 
            case 100106: 
            case 100113: {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("StateScan - scan stopped by other events").log();
                }
                this.trans(this.mTarget.stateIdle);
                return this.myParent;
            }
            case 100114: {
                if (this.isScanFinished()) {
                    this.tuneStartEnsemble();
                    break;
                }
                this.tuneNextService();
                break;
            }
            case 4: {
                if (this.mSeekRunning) {
                    if (ServiceManager.logger.isTraceEnabled(256)) {
                        ServiceManager.logger.trace(256).append("StateScan - abortSeek").log();
                    }
                    this.mDsiHsm.mDsiDabTuner.seekService(4);
                    this.tuneLsm();
                }
                DabMainApi.notifySearchingState(false);
                this.mTarget.stopTimer(310837504);
                if (this.mTarget.mNextEvent == null) {
                    this.mTarget.startTimer(-1920532224, (long)0, false);
                } else {
                    GuiApiDab.setUpdateStationInfoBlocked(false);
                    GuiApiDab.updateCurrentStationInfo();
                }
                hsmState = super.handle(eventGeneric);
                break;
            }
            default: {
                hsmState = super.handle(eventGeneric);
            }
        }
        return hsmState;
    }

    private void startSeek() {
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("StateScan - startSeek").log();
        }
        if (this.isScanFinished()) {
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append("StateScan - startSeek - Seek done and same freq reached").log();
            }
            RadioData.getDabDatabase().mAudioManager.setVolumeLock(false);
            this.mTarget.sendResult(this.mTarget.mCurrentEvent, 0);
            this.trans(this.mTarget.stateIdle);
        } else {
            DabMainApi.notifySearchingState(true);
            this.mCurrentServiceIndex = -1;
            this.mCurrentServiceList = null;
            this.mFoundEnsemble = null;
            this.mTarget.mDsiDabTuner.seekService(10);
            RadioData.getDabDatabase().mAudioManager.setVolumeLock(true);
        }
    }

    private void tuneNextService() {
        if (this.mTarget.mNextEvent != null) {
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append("StateScan - tuneNextService - scan stopped by nextevent : ").append(this.mTarget.mNextEvent).log();
            }
            this.mTarget.sendResult(this.mTarget.mCurrentEvent, 11);
            this.trans(this.mTarget.stateIdle);
            return;
        }
        if (this.mCurrentServiceList == null) {
            if (this.isScanFinished()) {
                this.tuneLsm();
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("StateScan - tuneNextService - scan stopped by servicelist empty").log();
                }
                this.mTarget.sendResult(this.mTarget.mCurrentEvent, 0);
                this.trans(this.mTarget.stateIdle);
            } else {
                this.startSeek();
            }
            return;
        }
        if (!(this.mTarget.mSyncStatus != 2 && this.mTarget.mSyncStatus != 1 || this.ignoreSyncStatus)) {
            if (this.isScanFinished()) {
                this.tuneLsm();
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("StateScan - tuneNextService - scan stopped by mute status").log();
                }
                this.mTarget.sendResult(this.mTarget.mCurrentEvent, 0);
                this.trans(this.mTarget.stateIdle);
            } else {
                this.startSeek();
            }
            return;
        }
        ++this.mCurrentServiceIndex;
        if (this.mCurrentServiceIndex > -1 && this.mCurrentServiceList.length > this.mCurrentServiceIndex && null != this.mCurrentServiceList[this.mCurrentServiceIndex]) {
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append("StateScan - tuneNextService -:").append(this.mCurrentServiceList[this.mCurrentServiceIndex]).log();
            }
            this.tuneService(this.mCurrentServiceList[this.mCurrentServiceIndex], this.mCurrentTunedFrequency);
            if (this.mSeekTriggeredFirstTime && DabTunerState.compare(this.mCurrentServiceList[this.mCurrentServiceIndex], this.mStartService) && (long)this.mFoundEnsemble.frequencyValue == this.mStartFrequency.getFrequency()) {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("StateScan - tuneNextService - scan stopped by same service reached").log();
                }
                this.mTarget.sendResult(this.mTarget.mCurrentEvent, 0);
                this.trans(this.mTarget.stateIdle);
                return;
            }
            this.startTimer();
        } else if (this.isScanFinished()) {
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append("StateScan - tuneNextService - scan stopped by isScanFinished").log();
            }
            this.mTarget.sendResult(this.mTarget.mCurrentEvent, 0);
            this.trans(this.mTarget.stateIdle);
        } else {
            this.startSeek();
        }
    }

    private void startTimer() {
        this.mTarget.startTimer(310837504, (long)0, false);
    }

    private void tuneService(ServiceInfo serviceInfo, FrequencyInfo frequencyInfo) {
        if (null != serviceInfo && null != frequencyInfo) {
            GuiApiDab.setUpdateStationInfoBlocked(false);
            RadioData.getDabDatabase().mTunerState.resetReceptionState(true);
            RadioData.getDabDatabase().mAudioManager.setVolumeLock(true);
            this.mTarget.setCurrentService(serviceInfo, false);
            this.mTarget.tuneServiceByFrequency(serviceInfo, frequencyInfo);
            GuiApiDab.setUpdateStationInfoBlocked(true);
        }
    }

    private void abortSeek() {
        this.debugOut('>', "abort");
        this.startAbortTimeout();
        this.mDsiHsm.mDsiDabTuner.seekService(4);
    }

    public void dsiDABTunerUpdateSelectedFrequency(FrequencyInfo frequencyInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkFrequencyAndName(frequencyInfo)) {
            return;
        }
        if (this.mSeekTriggeredFirstTime) {
            ++this.frequencySteps;
        }
        if (this.isScanFinished() && frequencyInfo.getFrequency() != this.mStartFrequency.getFrequency()) {
            this.mDsiHsm.mDsiDabTuner.seekService(4);
        }
        if (!this.mSeekReceivedStartFrequency) {
            this.mCurrentTunedFrequency = frequencyInfo;
            if (this.mSeekTriggeredFirstTime && this.mCurrentTunedFrequency.getFrequency() == this.mStartFrequency.getFrequency()) {
                this.mSeekReceivedStartFrequency = true;
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("StateScan - seek aborted because same freq reached").log();
                }
            }
        }
        this.retriggerTimeout();
    }

    public void dsiDABTunerUpdateSelectedEnsemble(EnsembleInfo ensembleInfo, int n) {
        if (!RadioServiceManager.getServiceManager().getDabEnsembleServiceComponentFrequecyChecker().checkEnsembleAndName(ensembleInfo)) {
            return;
        }
        if (1 == n) {
            if (this.mSeekTriggeredFirstTime && ensembleInfo.ensID > 0 && (long)ensembleInfo.frequencyValue == this.mStartFrequency.getFrequency()) {
                this.endEnsemble = ensembleInfo;
            }
            if (ensembleInfo.ensID > 0) {
                this.mFoundEnsemble = ensembleInfo;
                DabTunerState.correctEmptyLabels(this.mFoundEnsemble);
            } else {
                this.mFoundEnsemble = null;
            }
        }
    }

    public void dsiDABTunerUpdateSelectedService(ServiceInfo serviceInfo, int n) {
    }

    public void dsiDABTunerSeekServiceStatus(int n) {
        this.mSeekRunning = false;
        this.ignoreSyncStatus = false;
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("StateScan - dsiDABTunerSeekServiceStatus : ").append(n).log();
        }
        switch (n) {
            case 1: {
                this.mSeekTriggeredFirstTime = true;
                this.mSeekRunning = true;
                break;
            }
            case 0: 
            case 2: 
            case 4: {
                DabMainApi.notifySearchingState(false);
                this.logFailure();
                if (this.mTarget.mNextEvent == null) {
                    if (this.servIndexAfterReceivedStartFreq != -1) break;
                    this.tuneStartEnsemble();
                    break;
                }
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("StateScan - dsiDABTunerSeekServiceStatus - Not Finished - scan stopped by nextevent : ").append(this.mTarget.mNextEvent).log();
                }
                this.mTarget.sendResult(this.mTarget.mCurrentEvent, 12);
                this.trans(this.mTarget.stateIdle);
                break;
            }
            case 3: {
                this.ignoreSyncStatus = true;
                if (this.mSeekReceivedStartFrequency) {
                    if (this.servIndexAfterReceivedStartFreq == -1) {
                        DabMainApi.notifySearchingState(false);
                        this.tuneStartEnsemble();
                    }
                } else if (this.mFoundEnsemble != null) {
                    if (this.mTunedEnsembles.contains(new EnsembleInfoHash(this.mFoundEnsemble))) {
                        if (ServiceManager.logger.isTraceEnabled(256)) {
                            ServiceManager.logger.trace(256).append("StateScan - dsiDABTunerSeekServiceStatus - Finished - FoundEnsemble true startSeek").append(this.mTarget.mNextEvent).log();
                        }
                        this.startSeek();
                    } else {
                        this.mTunedEnsembles.add(new EnsembleInfoHash(this.mFoundEnsemble));
                        this.mCurrentServiceList = RadioData.getDabDatabase().mTunerState.getServicesByEnsemble(this.mFoundEnsemble);
                        this.tuneNextService();
                        DabMainApi.notifySearchingState(false);
                    }
                } else {
                    if (this.mTarget.mNextEvent != null) {
                        this.tuneLsm();
                        if (ServiceManager.logger.isTraceEnabled(256)) {
                            ServiceManager.logger.trace(256).append("StateScan - dsiDABTunerSeekServiceStatus - scan stopped by nextevent : ").append(this.mTarget.mNextEvent).log();
                        }
                        this.mTarget.sendResult(this.mTarget.mCurrentEvent, 0);
                        this.trans(this.mTarget.stateIdle);
                        return;
                    }
                    if (this.mFoundEnsemble == null) {
                        if (ServiceManager.logger.isTraceEnabled(256)) {
                            ServiceManager.logger.trace(256).append("StateScan - dsiDABTunerSeekServiceStatus - Finished - FoundEnsemble false startSeek").append(this.mTarget.mNextEvent).log();
                        }
                        this.startSeek();
                    } else {
                        DabMainApi.notifySearchingState(false);
                    }
                }
                this.ignoreSyncStatus = false;
                break;
            }
        }
    }

    public void dsiDABTunerUpdateSyncStatus(int n, int n2) {
        if (4 == n) {
            RadioData.getDabDatabase().mAudioManager.setMuted(false);
        } else {
            RadioData.getDabDatabase().mAudioManager.setMuted(true);
        }
        this.mTarget.mSyncStatus = n;
        this.mTarget.notifyFriendsAboutSyncStatus(n);
    }

    public void dsiDABTunerSelectServiceStatus(int n) {
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("StateScan - dsiDABTunerSelectServiceStatus : ").append(n).log();
        }
        this.retriggerTimeout();
        switch (n) {
            case 3: {
                RadioData.getDabDatabase().mAudioManager.setVolumeLock(false);
                this.retriggerTimeout();
                break;
            }
            case 1: {
                this.retriggerTimeout();
                break;
            }
            default: {
                this.logFailure(RadioDabTraceUtil.selectServiceStatusToString(n));
                if (!ServiceManager.logger.isTraceEnabled(256)) break;
                ServiceManager.logger.trace(256).append("StateScan - dsiDABTunerSelectServiceStatus - failure").log();
            }
        }
    }

    @Override
    protected String dsiRequestToString() {
        return "Scan";
    }

    @Override
    protected String dsiAbortRequestToString() {
        return "Scan";
    }

    @Override
    protected boolean abort() {
        this.abortSeek();
        return true;
    }

    @Override
    long getTimeout() {
        return 0;
    }

    private void tuneStartEnsemble() {
        if (ServiceManager.logger.isTraceEnabled(256)) {
            ServiceManager.logger.trace(256).append("StateScan - tuneStartEnsemble").log();
        }
        if (this.servIndexAfterReceivedStartFreq == -1 && null != this.endEnsemble && (long)this.endEnsemble.frequencyValue == this.mStartFrequency.getFrequency()) {
            this.mStartEnsemble = this.endEnsemble;
        }
        if (this.mTarget.mNextEvent != null) {
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append("StateScan - tuneStartEnsemble - scan stopped by nextevent : ").append(this.mTarget.mNextEvent).log();
            }
            this.mTarget.sendResult(this.mTarget.mCurrentEvent, 11);
            this.trans(this.mTarget.stateIdle);
            return;
        }
        if (null == this.mStartEnsemble || null == this.mStartFrequency || null == this.mStartService) {
            this.tuneLsm();
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append("StateScan - tuneStartEnsemble - scan stopped by null service").log();
            }
            this.mTarget.sendResult(this.mTarget.mCurrentEvent, 0);
            this.trans(this.mTarget.stateIdle);
            return;
        }
        if (!(this.mTarget.mSyncStatus != 1 && this.mTarget.mSyncStatus != 2 || this.ignoreSyncStatus)) {
            this.tuneLsm();
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append("StateScan - tuneStartEnsemble - scan stopped by mute state").log();
            }
            this.mTarget.sendResult(this.mTarget.mCurrentEvent, 0);
            this.trans(this.mTarget.stateIdle);
            return;
        }
        if (null == this.endEnsemble && this.isScanFinished()) {
            this.tuneLsm();
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append("StateScan - tuneStartEnsemble - scan stopped because the starting ensemble not available any more").log();
            }
            this.mTarget.sendResult(this.mTarget.mCurrentEvent, 0);
            this.trans(this.mTarget.stateIdle);
            return;
        }
        ++this.servIndexAfterReceivedStartFreq;
        ServiceInfo[] serviceInfoArray = RadioData.getDabDatabase().mTunerState.getServicesByEnsemble(this.mStartEnsemble);
        if (this.servIndexAfterReceivedStartFreq > -1 && null != serviceInfoArray && serviceInfoArray.length > this.servIndexAfterReceivedStartFreq && serviceInfoArray[this.servIndexAfterReceivedStartFreq] != null) {
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append("StateScan - tuneStartEnsemble - service : ").append(serviceInfoArray[this.servIndexAfterReceivedStartFreq]).log();
            }
            this.tuneService(serviceInfoArray[this.servIndexAfterReceivedStartFreq], this.mStartFrequency);
            if (DabTunerState.compare(this.mStartService, serviceInfoArray[this.servIndexAfterReceivedStartFreq]) || this.servIndexAfterReceivedStartFreq == serviceInfoArray.length - 1) {
                if (ServiceManager.logger.isTraceEnabled(256)) {
                    ServiceManager.logger.trace(256).append("StateScan - tuneStartEnsemble - scan stopped by same service reached").log();
                }
                this.mTarget.sendResult(this.mTarget.mCurrentEvent, 0);
                this.trans(this.mTarget.stateIdle);
            } else {
                this.startTimer();
            }
        } else {
            if (ServiceManager.logger.isTraceEnabled(256)) {
                ServiceManager.logger.trace(256).append("StateScan - tuneStartEnsemble - scan stopped by else condition").log();
            }
            this.tuneLsm();
            this.mTarget.sendResult(this.mTarget.mCurrentEvent, 11);
            this.trans(this.mTarget.stateIdle);
        }
    }

    private void tuneLsm() {
        GuiApiDab.setUpdateStationInfoBlocked(false);
        this.mTarget.tuneLsm();
        GuiApiDab.setUpdateStationInfoBlocked(true);
    }

    private boolean isScanFinished() {
        return this.mSeekTriggeredFirstTime && this.mSeekReceivedStartFrequency && this.frequencySteps > 5;
    }
}

