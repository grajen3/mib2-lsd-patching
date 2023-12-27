/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.online;

import de.vw.mib.genericevents.AbstractTarget;

public final class OnlinePoiEvents {
    private static final int[] ASL_OBSERVER = new int[]{-2012610496, -1962278848, -1257635776, 1170804800, -37220288, 113840192, -2029387712, -2130051008, -2096496576, -2113273792, -2079719360, -1559625664, -1576402880, 1997144128, 2013921344, 2030698560, 1862926400, 1239495424, 54413568, 37303552, 1523126336};

    private OnlinePoiEvents() {
    }

    static void addObservers(AbstractTarget abstractTarget) {
        abstractTarget.addObservers(ASL_OBSERVER);
    }

    static void removeObservers(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(ASL_OBSERVER);
    }
}

