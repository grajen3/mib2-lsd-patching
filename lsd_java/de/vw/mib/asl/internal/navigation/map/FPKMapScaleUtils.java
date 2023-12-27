/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.map;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.internal.navigation.map.FPKMapScaleUtils$ZoomLevelThreshold;

public final class FPKMapScaleUtils {
    private static IExtLogger LOGGER = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(256, "[FPKMapScaleUtils]");

    public static FPKMapScaleUtils$ZoomLevelThreshold getFPKMapScaleThreshold(int n) {
        return FPKMapScaleUtils$ZoomLevelThreshold.getCorrespondingLevel(n);
    }

    static /* synthetic */ IExtLogger access$000() {
        return LOGGER;
    }
}

