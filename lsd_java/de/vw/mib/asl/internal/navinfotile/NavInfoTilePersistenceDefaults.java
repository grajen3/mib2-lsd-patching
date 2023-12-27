/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public class NavInfoTilePersistenceDefaults {
    public static int getContentNoGuidanceDefault() {
        return ServiceManager.configManagerDiag.getNaviInfotileDefaultContentNoGuidance();
    }

    public static int getContentGuidanceDefault() {
        return ServiceManager.configManagerDiag.getNaviInfotileDefaultContentGuidance();
    }

    public static int getPageIndexDefault() {
        return 0;
    }
}

