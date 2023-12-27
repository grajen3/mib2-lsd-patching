/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.shield.nar;

import de.vw.mib.genericevents.AbstractTarget;

public final class ShieldEvents {
    private static final int[] SHIELD_EVENTS = new int[]{617156672, 1523126336, 1187582016, 1439240256, 1422463040};
    private static final int[] CODING_EVENTS = new int[]{1134297088};

    private ShieldEvents() {
    }

    static void addObservers(AbstractTarget abstractTarget) {
        abstractTarget.addObservers(SHIELD_EVENTS);
        abstractTarget.addObservers(CODING_EVENTS);
    }

    static void removeObservers(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(SHIELD_EVENTS);
        abstractTarget.removeObservers(CODING_EVENTS);
    }
}

