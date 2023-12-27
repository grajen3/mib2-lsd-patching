/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.splitscreen;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public interface SplitscreenConfigManager {
    public static final boolean HMI_SPLIT_SCREEN_GUIDANCE_ENABLED = ServiceManager.configManagerDiag.getNaviSplitScreenOptionDefaultBoolean(1);
    public static final boolean HMI_SPLIT_SCREEN_NO_GUIDANCE_ENABLED = ServiceManager.configManagerDiag.getNaviSplitScreenOptionDefaultBoolean(0);
    public static final int HMI_SPLIT_SCREEN_GUIDANCE_CONTENT = ServiceManager.configManagerDiag.getNaviSplitScreenOptionDefaultInteger(1);
    public static final int HMI_SPLIT_SCREEN_NO_GUIDANCE_CONTENT = ServiceManager.configManagerDiag.getNaviSplitScreenOptionDefaultInteger(0);
}

