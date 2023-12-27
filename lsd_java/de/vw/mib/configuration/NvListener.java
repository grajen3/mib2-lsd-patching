/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration;

public interface NvListener {
    public static final int NV_DYNAMIC_TM_DEBUG_PROBES_CFG;
    public static final int NV_CURRENT_SKINMODE;
    public static final int NV_CURRENT_GUI_LANGUAGE;
    public static final int NV_CURRENT_SKIN;
    public static final int NV_INSTRUMENTCLUSTERSIZE;
    public static final int NV_OFFCLOCK_LAYOUT;
    public static final int NV_SPACE_GESTURE_AVAILABILITY;

    default public void notifyNvListener(int n) {
    }
}

