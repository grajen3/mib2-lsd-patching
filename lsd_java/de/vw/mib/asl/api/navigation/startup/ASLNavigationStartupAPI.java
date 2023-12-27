/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.startup;

import de.vw.mib.asl.api.navigation.IASLNavigationInternalServiceFirst;
import de.vw.mib.asl.api.navigation.startup.ASLNavigationContainer;
import de.vw.mib.asl.api.navigation.startup.NavStartupStatusListener;
import de.vw.mib.genericevents.Target;
import java.util.List;

public interface ASLNavigationStartupAPI
extends IASLNavigationInternalServiceFirst {
    public static final int EV_NAVI_STATUS_CHANGE;
    public static final int EV_NAVI_STATUS_CHANGE__P0_BOOLEAN;
    public static final int STARTUP_GROUP_FRAMEWORK;
    public static final int STARTUP_GROUP_PERSISTENCE;
    public static final int STARTUP_GROUP_POI;
    public static final int STARTUP_GROUP_MAP;
    public static final int STARTUP_GROUP_REMAINING;
    public static final int NAVI_STARTUP_SUBCLASSIFIER;

    default public void registerContainer(ASLNavigationContainer aSLNavigationContainer) {
    }

    default public void addTarget(int n, Target target) {
    }

    default public void addTargets(int n, List list) {
    }

    default public void sendEvNaviStatusChange(boolean bl) {
    }

    default public boolean isNaviRunning() {
    }

    default public void registerNavStartupStatusListener(NavStartupStatusListener navStartupStatusListener) {
    }

    default public void unregisterNavStartupStatusListener(NavStartupStatusListener navStartupStatusListener) {
    }
}

