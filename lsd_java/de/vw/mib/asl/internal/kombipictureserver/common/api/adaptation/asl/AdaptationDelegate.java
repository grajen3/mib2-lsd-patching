/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.common.api.adaptation.asl;

import de.vw.mib.asl.internal.kombipictureserver.common.api.adaptation.asl.AdaptationService;

public interface AdaptationDelegate {
    public static final int ADAPTATION_MOST_CAPABILITY_CALL_PICTURE;
    public static final int ADAPTATION_MOST_CAPABILITY_COVER_ART;
    public static final int ADAPTATION_MOST_CAPABILITY_STATION_ART;
    public static final int[] ADAPTATION_PROPERTIES;

    default public void updateAdaptation(AdaptationService adaptationService, int n) {
    }

    static {
        ADAPTATION_PROPERTIES = new int[]{1093804032, 1077026816, 1110581248};
    }
}

