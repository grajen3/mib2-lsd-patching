/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng;

public interface SkinChanger {
    public static final long SKIN_CHANGE_TIMEOUT_PER_SKIN = Long.getLong("de.vw.mib.lsc.skinchangetimeout4skin", 0);
    public static final long SKIN_CHANGE_TIMEOUT_TOTAL = Long.getLong("de.vw.mib.lsc.skinchangetimeouttotal", 0);

    default public void setChangeResult(int n, boolean bl, int n2) {
    }
}

