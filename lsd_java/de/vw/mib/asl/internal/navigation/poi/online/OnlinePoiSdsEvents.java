/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.online;

import de.vw.mib.genericevents.AbstractTarget;

public final class OnlinePoiSdsEvents {
    private static final int[] ASL_OBSERVER = new int[]{-1589103360, -1572326144, -1555548928, -1538771712, -1257635776};

    static void addObservers(AbstractTarget abstractTarget) {
        abstractTarget.addObservers(ASL_OBSERVER);
    }

    static void removeObservers(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(ASL_OBSERVER);
    }
}

