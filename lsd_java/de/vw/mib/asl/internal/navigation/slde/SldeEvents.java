/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.slde;

import de.vw.mib.genericevents.AbstractTarget;

public final class SldeEvents {
    private static final int[] SPELLER_EVENTS = new int[]{1221136448};
    private static final int[] SLDE_PROXY_EVENTS = new int[]{1630090496};
    private static final int[] SHIELD_EVENTS = new int[]{617156672, 1523126336, 1187582016, 1439240256, 1422463040, 1539903552, 1808339008};
    private static final int[] ONLINE_EVENTS = new int[]{-2012610496, -1962278848, -1257635776, 1170804800, -37220288, 113840192, -2029387712, -2130051008, -2096496576, -2113273792, -2079719360, -1559625664, -1576402880, 1997144128, 2013921344, 2030698560, 1862926400, 1239495424, 54413568};
    private static final int[] ALONGTHEROUTE_EVENTS = new int[]{-1224605632, -1509818304, -1493041088, -1476263872, -1543372736, -137883584, -121106368, -104329152, -87551936, -1627258816, -1358823360, 319422528, -1106771904, 1762263104, 29954112, 734597184, 1155609344, 1122054912};
    private static final int[] CODING_EVENTS = new int[]{20526336};

    private SldeEvents() {
    }

    static void addObservers(AbstractTarget abstractTarget) {
        abstractTarget.addObservers(SPELLER_EVENTS);
        abstractTarget.addObservers(SHIELD_EVENTS);
        abstractTarget.addObservers(ONLINE_EVENTS);
        abstractTarget.addObservers(ALONGTHEROUTE_EVENTS);
        abstractTarget.addObservers(CODING_EVENTS);
        abstractTarget.addObservers(SLDE_PROXY_EVENTS);
    }

    static void removeObservers(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(SPELLER_EVENTS);
        abstractTarget.removeObservers(SHIELD_EVENTS);
        abstractTarget.removeObservers(ONLINE_EVENTS);
        abstractTarget.removeObservers(ALONGTHEROUTE_EVENTS);
        abstractTarget.removeObservers(CODING_EVENTS);
        abstractTarget.removeObservers(SLDE_PROXY_EVENTS);
    }
}

