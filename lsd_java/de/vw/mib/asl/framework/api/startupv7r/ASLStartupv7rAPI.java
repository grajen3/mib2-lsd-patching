/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.startupv7r;

import de.vw.mib.asl.framework.api.persistence.IPersistableEarlyData;
import de.vw.mib.asl.framework.api.startupv7r.dynamic.DynamicWorkUnitStarter;
import de.vw.mib.asl.framework.api.startupv7r.startupstate.StartupStateService;

public interface ASLStartupv7rAPI {
    public static final int EV_DSI_BOOT_REGISTERED;
    public static final int EV_ASL_TARGET_STARTED;
    public static final int EV_DSI_TIMEOUT;
    public static final int EV_SPLASH_SCREEN_TIMEOUT;
    public static final int EV_NAV_IS_COMPLETELY_READY;
    public static final int EV_ULTIMATE_STARTUP_TIMEOUT;

    default public IPersistableEarlyData getPersistableEarlyData() {
    }

    default public int getSupplier() {
    }

    default public boolean isSwdlPowerstateDetected() {
    }

    default public void startTargetByNamedId(int n) {
    }

    default public void setOnlineServiceCodingStateForStartup(boolean bl) {
    }

    default public boolean isHighActivatorStarted() {
    }

    default public boolean isNonCustomerSwdlIsInProgress() {
    }

    default public void setNonCustomerSwdlIsInProgress(boolean bl) {
    }

    default public StartupStateService getStartupStateService() {
    }

    default public String[] getVariantDsiNames() {
    }

    default public int[] getVariantPersistenceNamespaceIds() {
    }

    default public DynamicWorkUnitStarter getDynamicWorkUnitStarter() {
    }
}

