/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng;

public interface SkinmodeChanger {
    public static final long SKINMODE_CHANGE_TIMEOUT_PER_SKINMODE = Long.getLong("de.vw.mib.lsc.skinmodechangetimeout4skinmode", 0);
    public static final long SKINMODE_CHANGE_TIMEOUT_TOTAL = Long.getLong("de.vw.mib.lsc.skinmodechangetimeouttotal", 0);

    default public void setChangeResult(int n, boolean bl, int n2) {
    }
}

