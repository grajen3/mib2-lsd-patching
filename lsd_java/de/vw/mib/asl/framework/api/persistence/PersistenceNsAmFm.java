/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence;

public interface PersistenceNsAmFm {
    public static final int AMFM_SETTINGS;
    public static final int FM_PRESETS;
    public static final int AM_PRESETS;
    public static final int FIXED_STATION_LIST;
    public static final int[][] NS;

    static {
        NS = new int[][]{{3, 300}, {3, 320}, {3, 321}, {3, 330}};
    }
}

