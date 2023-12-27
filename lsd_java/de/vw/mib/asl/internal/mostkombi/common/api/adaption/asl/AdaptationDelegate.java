/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.common.api.adaption.asl;

import de.vw.mib.asl.internal.mostkombi.common.api.adaption.asl.AdaptationService;

public interface AdaptationDelegate {
    public static final int ADAPTATION_MOST_CAPABILITY_MAP;
    public static final int ADAPTATION_MOST_CAPABILITY_KDK;
    public static final int[] ADAPTATION_PROPERTIES;

    default public void updateAdaptation(AdaptationService adaptationService, int n) {
    }

    static {
        ADAPTATION_PROPERTIES = new int[]{1043472384, 1060249600};
    }
}

