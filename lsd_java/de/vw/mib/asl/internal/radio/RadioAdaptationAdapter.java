/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio;

import de.vw.mib.asl.framework.api.diagnosis.config.Adaptation;

public final class RadioAdaptationAdapter {
    public static Adaptation mAmFmAdaptationData = null;

    private RadioAdaptationAdapter() {
    }

    public static int getStationLogoDbMode() {
        if (mAmFmAdaptationData == null) {
            return 0;
        }
        if (mAmFmAdaptationData.contains(159)) {
            int n = mAmFmAdaptationData.getValue(159);
            return n;
        }
        return 0;
    }
}

