/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.jpn;

import de.vw.mib.genericevents.AbstractTarget;

public final class PoiJpnEvents {
    private static final int[] POI_JPN_EVENTS = new int[]{1623789632, 1657344064, 1640566848};

    private PoiJpnEvents() {
    }

    static void addObservers(AbstractTarget abstractTarget) {
        abstractTarget.addObservers(POI_JPN_EVENTS);
    }

    static void removeObservers(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(POI_JPN_EVENTS);
    }
}

