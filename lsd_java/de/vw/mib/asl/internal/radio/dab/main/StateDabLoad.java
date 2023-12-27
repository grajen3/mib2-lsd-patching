/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.dab.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioDabTraceUtil;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.dab.DabFrequencyTable;
import de.vw.mib.asl.internal.radio.dab.main.HsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.Hsm;
import de.vw.mib.genericevents.hsm.HsmState;

public final class StateDabLoad
extends AbstractHsmState {
    private final HsmTarget mTarget;

    public StateDabLoad(HsmTarget hsmTarget, Hsm hsm, String string, HsmState hsmState) {
        super(hsm, string, hsmState);
        this.mTarget = hsmTarget;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        HsmState hsmState = null;
        if (ServiceManager.logger2.isTraceEnabled(256)) {
            ServiceManager.logger2.trace(256).append("StateDabLoad is active - Event-ID: ").append(eventGeneric.getReceiverEventId()).log();
        }
        switch (eventGeneric.getReceiverEventId()) {
            case 3: {
                this.mTarget.mNextState = this.mTarget.stateDabPrepareTuning;
                ServiceManager.adaptionApi.requestConfigManagerPersCoding(this.mTarget.getTargetId(), 2005336320);
                break;
            }
            case 100215: {
                this.mTarget.processDiagnosisData(eventGeneric);
                if (!RadioData.getDabDatabase().getDabDeviceFitted()) break;
                this.switchLBand();
                break;
            }
            case 100241: {
                this.mTarget.setCurrentEvent(eventGeneric);
                this.mTarget.mNextState = this.mTarget.stateDabPrepareTuning;
                break;
            }
            case 100240: {
                this.mTarget.setCurrentEvent(eventGeneric);
                this.mTarget.mNextState = this.mTarget.stateDabInactive;
                break;
            }
            case 4: {
                break;
            }
            default: {
                hsmState = this.myParent;
            }
        }
        return hsmState;
    }

    private void switchLBand() {
        if (RadioData.getDabDatabase().mFrequencyTable.getLBandOptionAvailable()) {
            boolean bl = RadioData.getDabDatabase().mFrequencyTable.getLBandOptionState();
            DabFrequencyTable.switchFreqTableRequested = true;
            this.mTarget.switchLBandState(bl);
        } else {
            DabFrequencyTable.switchFreqTableRequested = true;
            this.mTarget.switchLBandState(false);
        }
        if (RadioData.getDabDatabase().getDabDeviceFitted()) {
            this.switchToNextState();
        }
    }

    public void dsiDABTunerUpdateDetectedDevice(int n, int n2) {
        if (n == 3 || n == 4) {
            RadioDabTraceUtil.hsmTraceDAB(this.mTarget, this, "dsiDABTunerUpdateDetectedDevice", "DAB Device available");
            RadioData.getDabDatabase().setDabDeviceFitted(true);
            this.switchLBand();
        } else {
            RadioDabTraceUtil.hsmTraceDAB(this.mTarget, this, "dsiDABTunerUpdateDetectedDevice", "DAB Device not detected");
            RadioData.getDabDatabase().setDabDeviceFitted(false);
        }
    }

    public void dsiDABTunerUpdateFrequencyTableSwitchStatus(int n, int n2) {
        RadioData.getDabDatabase().mFrequencyTable.setFrequencyTable(n);
    }

    private void switchToNextState() {
        this.trans(this.mTarget.mNextState);
        this.mTarget.mNextState = null;
    }
}

