/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.ppoi.util;

import de.vw.mib.genericevents.AbstractTarget;

public class PPoiEvents {
    public static final int EV_TRANSITION;
    private static final int[] ASL_OBSERVER;

    private PPoiEvents() {
    }

    public static void addObserver(AbstractTarget abstractTarget) {
        abstractTarget.addObservers(ASL_OBSERVER);
    }

    public static void removeObserver(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(ASL_OBSERVER);
    }

    static {
        ASL_OBSERVER = new int[]{1976111168, 1992888384, 2009665600, -1358823360};
    }
}

