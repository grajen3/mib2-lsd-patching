/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.tv;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;

public class TuningHandler {
    private boolean isNonStopSeekingActive = false;
    private int lastNonStopSeekingDirection = 0;
    private int arrowButtonMode = 1;
    private int tuneUpDownState = 0;

    public void setArrowButtonMode(int n, boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TuningHandler#setArrowButtonMode called - arrowButtonMode = ").append(n).toString());
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(2662, n);
        this.arrowButtonMode = n;
        if (!bl) {
            TVTunerObjectAccessor.getTvTunerDB().getTvPersistable().persistButtonMode(n);
        }
    }

    public void tuneToNextStation(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TuningHandler#tuneToNextStation called - direction = ").append(n).toString());
        }
        switch (this.arrowButtonMode) {
            case 0: {
                if (TVTunerHelper.isTraceEnabled()) {
                    TVTunerHelper.trace("TuningHandler#tuneToNextStation - skip in presetlist");
                }
                TVTunerObjectAccessor.getPresetListHandler().selectNextPresetService(n);
                break;
            }
            case 1: {
                if (TVTunerHelper.isTraceEnabled()) {
                    TVTunerHelper.trace("TuningHandler#tuneToNextStation - skip in stationlist");
                }
                TVTunerObjectAccessor.getStationListHandler().selectNextStationService(n);
                break;
            }
        }
    }

    public void seekNextChannel(int n, int n2) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TuningHandler#seekNextChannel called - direction = ").append(n).append(" - manualSeekMode = ").append(n2).toString());
        }
        if (n2 == 1) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace("TuningHandler#seekNextChannel - set isNonStopSeekingActive to true");
            }
            this.isNonStopSeekingActive = true;
            this.lastNonStopSeekingDirection = n;
        }
        if (TVTunerObjectAccessor.getTuningHandler().getTuneUpDownState() == 1) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace("TuningHandler#seekNextChannel - seek is already running, abort seek");
            }
            TVTunerObjectAccessor.getTargetTVTunerDSI().getDSITVTuner().abortSeek();
        } else {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace("TuningHandler#seekNextChannel - no seek running, start new seek");
            }
            TVTunerObjectAccessor.getTargetTVTunerDSI().getDSITVTuner().selectNextService(n, 2);
        }
    }

    public void stopNonStopChannelSeeking() {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TuningHandler#stopNonStopChannelSeeking - set isNonStopSeekingActive to false");
        }
        this.isNonStopSeekingActive = false;
    }

    public void repeatNonStopSeeking() {
        if (this.isNonStopSeekingActive) {
            if (TVTunerHelper.isTraceEnabled()) {
                TVTunerHelper.trace("TuningHandler#repeatNonStopSeeking - repeat channel seeking with MANUAL_SEEKMODE_ONCE");
            }
            this.seekNextChannel(this.lastNonStopSeekingDirection, 0);
        } else if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TuningHandler#repeatNonStopSeeking - isNonStopSeekingActive = false - do not perform channel seeking");
        }
    }

    public int getTuneUpDownState() {
        return this.tuneUpDownState;
    }

    public void setTuneUpDownState(int n) {
        this.tuneUpDownState = n;
    }

    public int getButtonMode() {
        return this.arrowButtonMode;
    }
}

