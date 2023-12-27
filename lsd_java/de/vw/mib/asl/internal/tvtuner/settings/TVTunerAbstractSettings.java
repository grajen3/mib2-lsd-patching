/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.tvtuner.settings;

import de.vw.mib.asl.internal.tvtuner.common.TVTunerHelper;

public abstract class TVTunerAbstractSettings {
    protected void setVideoFormatToDisplayManagement(int n, int n2) {
        if (TVTunerHelper.isTraceEnabled()) {
            TVTunerHelper.trace(new StringBuffer().append(super.getClass().getName()).append("#setVideoFormatToDisplayManagement entered").toString());
        }
    }
}

