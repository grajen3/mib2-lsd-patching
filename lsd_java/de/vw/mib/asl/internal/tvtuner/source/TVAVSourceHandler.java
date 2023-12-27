/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.source;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;

public class TVAVSourceHandler {
    private int activeSource = -1;

    public void setSource(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVAVSourceHandler#setSource entered");
        }
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVAVSourceHandler#setSource - activate source ").append(n).toString());
        }
        TVTunerObjectAccessor.getTargetTVTunerDSI().getDSITVTuner().switchSource(n);
    }

    public void updateSource(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVAVSourceHandler#updateSource entered - active source = ").append(n).toString());
        }
        this.activeSource = n;
        ServiceManager.aslPropertyManager.valueChangedInteger(2687, n);
        TVTunerObjectAccessor.getTvTunerDB().getTvPersistable().persistActiveSource(n);
        if (n == 1) {
            TVTunerObjectAccessor.getTvTunerAVSettings().updateAspectRatio();
            TVTunerObjectAccessor.getTvTunerAudio().setVolumeLockNeeded(false);
            TVTunerObjectAccessor.getTvTunerAudio().checkVolumeLock();
        }
        TVTunerObjectAccessor.getTvBAP().updateBAPStationList();
        TVTunerObjectAccessor.getTvBAP().updateBAPIndices();
        TVTunerObjectAccessor.getTileService().updateActiveSource(n);
    }

    public int getActiveSource() {
        return this.activeSource;
    }

    public void wakeUpTuner(boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVAVSourceHandler#wakeUpTuner entered ");
        }
        if (TVTunerObjectAccessor.getTargetTVTuner().isTVTunerAvailable() && TVTunerObjectAccessor.getTargetTVTunerDSI().getTunerWaitState() == 0 && (bl || TVTunerObjectAccessor.getTvAvSourceHandler().getActiveSource() != -1)) {
            if (TVTunerObjectAccessor.getTvAvSourceHandler().getActiveSource() != -1) {
                if (TVTunerHelper.isTraceEnabled()) {
                    TVTunerHelper.trace("TVAVSourceHandler#wakeUpTuner - wake up tuner ");
                }
                TVTunerObjectAccessor.getTvAvSourceHandler().setSource(TVTunerObjectAccessor.getTvAvSourceHandler().getActiveSource());
            } else {
                if (TVTunerHelper.isTraceEnabled()) {
                    TVTunerHelper.trace("TVAVSourceHandler#wakeUpTuner - wake up tuner (forced) ");
                }
                TVTunerObjectAccessor.getTvAvSourceHandler().setSource(0);
            }
        } else if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVAVSourceHandler#wakeUpTuner - cant wake up tuner right now ");
        }
    }
}

