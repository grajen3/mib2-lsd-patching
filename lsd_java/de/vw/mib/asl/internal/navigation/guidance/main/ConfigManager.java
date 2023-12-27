/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public final class ConfigManager {
    public static final boolean FEAT_IS_JPN = ServiceManager.configManagerDiag.isFeatureFlagSet(75);
    public static final boolean FEAT_IS_NAV_5_ROUTE_CALCULATION = ServiceManager.configManagerDiag.isFeatureFlagSet(107);
}

