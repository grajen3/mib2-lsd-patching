/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.persistence;

public interface PersistenceService {
    public static final int DISPLAY_SIZE_CLASS_SMALL_DISPLAY;
    public static final int DISPLAY_SIZE_CLASS_MEDIUM_DISPLAY;
    public static final int DISPLAY_SIZE_CLASS_LARGE_DISPLAY;

    default public boolean isDABLongLabelsActive() {
    }

    default public boolean isSDARSLongLabelsActive() {
    }

    default public int getInstrumentClusterDisplaySize() {
    }

    default public void setDABLongLabelsActive(boolean bl) {
    }

    default public void setSDARSLangLabelsActive(boolean bl) {
    }

    default public void setInstrumentClusterDisplaySize(int n) {
    }
}

