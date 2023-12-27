/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.framework.assembly;

public interface ScreenAreaData {
    public static final String SCREENAREA_TYPE_MAIN;
    public static final String SCREENAREA_TYPE_POPUP;

    default public ScreenAreaData getCoveredScreenArea() {
    }

    default public int getEventPrioRank() {
    }

    default public String getName() {
    }

    default public String[] getPopupGroups() {
    }

    default public String getType() {
    }

    default public boolean isDriverDistractionPreventionRelevant() {
    }

    default public boolean isPopupScreenArea() {
    }
}

