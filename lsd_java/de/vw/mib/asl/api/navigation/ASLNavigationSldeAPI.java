/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

import de.vw.mib.asl.api.navigation.IASLNavigationInternalServiceFirst;
import de.vw.mib.properties.values.SpellerData;
import org.dsi.ifc.global.NavLocation;

public interface ASLNavigationSldeAPI
extends IASLNavigationInternalServiceFirst {
    public static final int EV_ASL_NAVIGATION_INTERNAL_SLDE_EXTERNAL_RESULT_RESOLVED;
    public static final int EV_ASL_NAVIGATION_INTERNAL_SLDE_EXTERNAL_RESULT_RESOLVED_P0;
    public static final int EV_ASL_NAVIGATION_INTERNAL_SLDE_EXTERNAL_RESULT_RESOLVED_P1;

    default public SpellerData getSldeSpellerData() {
    }

    default public void sldeSpellerHandlerInitXt9(NavLocation navLocation) {
    }
}

