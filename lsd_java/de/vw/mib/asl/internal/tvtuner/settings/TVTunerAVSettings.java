/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.settings;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.tvtuner.accessor.TVTunerObjectAccessor;
import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;
import de.vw.mib.asl.internal.tvtuner.settings.TVTunerAbstractSettings;

public class TVTunerAVSettings
extends TVTunerAbstractSettings {
    private int aspectRatioMode = 0;

    public void setAVNorm(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerAVSettings#setAVNorm called - avNorm = ").append(n).toString());
        }
        TVTunerObjectAccessor.getTargetTVTunerDSI().getDSITVTuner().setAVNorm(n);
    }

    public void updateAVNorm(int n) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerAVSettings#updateAVNorm called - avNorm = ").append(n).toString());
        }
        ServiceManager.aslPropertyManager.valueChangedInteger(2869, n);
        TVTunerObjectAccessor.getTvTunerDB().getTvPersistable().persistAVNorm(n);
    }

    public void setAspectRatioMode(int n, boolean bl) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append("TVTunerAVSettings#setAspectRatioMode called - aspectRatioMode = ").append(n).toString());
        }
        this.aspectRatioMode = n;
        ServiceManager.aslPropertyManager.valueChangedInteger(2868, n);
        this.updateAspectRatio();
        if (!bl) {
            TVTunerObjectAccessor.getTvTunerDB().getTvPersistable().persistAVAspectRatio(n);
        }
    }

    public void updateAspectRatio() {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace("TVTunerAVSettings#updateAspectRatio called");
        }
        switch (this.aspectRatioMode) {
            case 1: {
                if (TVTunerHelper.isTraceEnabled()) {
                    TVTunerHelper.trace("TVTunerAVSettings#updateAspectRatio - set video format 16:9");
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(-1102305792, 0);
                TVTunerObjectAccessor.getTileService().updateAVVideoFormat(0);
                break;
            }
            case 2: {
                if (TVTunerHelper.isTraceEnabled()) {
                    TVTunerHelper.trace("TVTunerAVSettings#updateAspectRatio - set video format 4:3");
                }
                ServiceManager.aslPropertyManager.valueChangedInteger(-1102305792, 1);
                TVTunerObjectAccessor.getTileService().updateAVVideoFormat(1);
                break;
            }
            default: {
                if (!TVTunerHelper.isTraceEnabled()) break;
                TVTunerHelper.trace(new StringBuffer().append("TVTunerAVSettings#updateAspectRatio - unsupported video format: ").append(this.aspectRatioMode).toString());
            }
        }
    }
}

