/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.GuiApiDab;
import de.vw.mib.asl.internal.radio.GuiApiTunerCommon;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.dsi.DabDsiApi;
import de.vw.mib.asl.internal.radio.dab.main.HsmTarget;
import de.vw.mib.asl.internal.radio.dab.stationList.HmiDabListViewApi;
import de.vw.mib.asl.internal.radio.util.RadioSystemEventsUtil;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

public final class StateDabActiveScanMode
extends AbstractHsmState {
    private final HsmTarget mTarget;
    private int mLinkingOption;

    public StateDabActiveScanMode(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabActiveScanMode is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.mTarget.trace("--- enter stateScanMode");
                GuiApiTunerCommon.setDabRadioTextLoadingStateToNotAvailable();
                GuiApiTunerCommon.updateScanActive(true);
                RadioData.getDabDatabase().scanActive = true;
                this.notifyTimTuner(true);
                break;
            }
            case 3: {
                this.mLinkingOption = RadioData.getDabDatabase().mOptionLinking.getOption();
                RadioData.getDabDatabase().mOptionLinking.setDabFollowing(false);
                RadioData.getDabDatabase().mOptionLinking.setFmLinking(false);
                int n = RadioData.getDabDatabase().mOptionLinking.getOption();
                this.mTarget.mDsiDabTuner.switchLinking(n);
                DabDsiApi.scan(5, 1854341376);
                break;
            }
            case 1073743043: {
                RadioData.getDabDatabase().mManualMode = true;
                this.trans(this.mTarget.stateDabActiveIdle);
                break;
            }
            case 1073743017: {
                this.trans(this.mTarget.stateDabActiveIdle);
                break;
            }
            case 1073743064: {
                this.trans(this.mTarget.stateDabActiveIdle);
                break;
            }
            case 101029: {
                EnsembleInfo ensembleInfo = (EnsembleInfo)eventGeneric.getObject(0);
                ServiceInfo serviceInfo = (ServiceInfo)eventGeneric.getObject(1);
                ComponentInfo componentInfo = (ComponentInfo)eventGeneric.getObject(2);
                this.mTarget.newStationSelected(ensembleInfo, serviceInfo, componentInfo);
                break;
            }
            case 0x40000494: {
                int n = eventGeneric.getInt(0);
                this.mTarget.activatePreset(n);
                this.trans(this.mTarget.stateDabActiveIdle);
                break;
            }
            case 0x40000484: 
            case 1073742982: {
                long l = eventGeneric.getLong(0);
                boolean bl = this.mTarget.activateStationById(l);
                RadioSystemEventsUtil.sendSelectStationFinished(bl);
                HmiDabListViewApi.notifyCurrentStationInfo();
                this.trans(this.mTarget.stateDabActiveIdle);
                break;
            }
            case 100234: {
                RadioData.getDabDatabase().mTunerState.tuneComponent((ComponentInfo)eventGeneric.getObject(0), (ServiceInfo)eventGeneric.getObject(1), (EnsembleInfo)eventGeneric.getObject(2));
                this.mTarget.updateCurrentStationInfo(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), RadioData.getDabDatabase().mTunerState.getCurrentEnsemble(), RadioData.getDabDatabase().mTunerState.getCurrentService(), RadioData.getDabDatabase().mTunerState.getCurrentComponent());
                RadioSystemEventsUtil.sendSelectStationFinished(true);
                HmiDabListViewApi.notifyCurrentStationInfo();
                this.trans(this.mTarget.stateDabActiveIdle);
                break;
            }
            case 100235: {
                RadioData.getDabDatabase().mTunerState.tuneService((ServiceInfo)eventGeneric.getObject(0), (EnsembleInfo)eventGeneric.getObject(1));
                this.mTarget.updateCurrentStationInfo(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), RadioData.getDabDatabase().mTunerState.getCurrentEnsemble(), RadioData.getDabDatabase().mTunerState.getCurrentService(), RadioData.getDabDatabase().mTunerState.getCurrentComponent());
                RadioSystemEventsUtil.sendSelectStationFinished(true);
                HmiDabListViewApi.notifyCurrentStationInfo();
                this.trans(this.mTarget.stateDabActiveIdle);
                break;
            }
            case 226: {
                boolean bl = eventGeneric.getBoolean(0);
                GuiApiDab.updateDabSearching(bl);
                if (!bl) break;
                RadioData.getDabDatabase().mTunerState.setCurrentService(null, null);
                this.mTarget.updateCurrentStationInfo(RadioData.getDabDatabase().mTunerState.getCurrentFrequencyInfo(), null);
                break;
            }
            case 100240: {
                this.trans(this.mTarget.stateDabActiveIdle);
                GuiApiDab.updateDabSearching(false);
                return this.myParent;
            }
            case 1073743071: {
                this.trans(this.mTarget.stateDabActiveIdle);
                return this.myParent;
            }
            case 100206: {
                this.trans(this.mTarget.stateDabActiveIdle);
                break;
            }
            case 4: {
                DabDsiApi.cancelScan();
                RadioData.getDabDatabase().mOptionLinking.set(this.mLinkingOption);
                this.mTarget.mDsiDabTuner.switchLinking(this.mLinkingOption);
                GuiApiTunerCommon.updateScanActive(false);
                RadioData.getDabDatabase().scanActive = false;
                this.mTarget.trace("--- leave stateScanMode");
                this.notifyTimTuner(false);
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void notifyTimTuner(boolean bl) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent();
        eventGeneric.setBoolean(0, bl);
        ServiceManager.eventMain.getServiceRegister().triggerObserver(-929169408, eventGeneric);
    }
}

