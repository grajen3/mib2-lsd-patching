/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.congestion;

import de.vw.mib.genericevents.AbstractTarget;

public final class Events {
    private static final int[] OBSERVER = new int[]{151126080, -536346560, 184680512};

    private Events() {
    }

    static void addObservers(AbstractTarget abstractTarget) {
        abstractTarget.addObservers(OBSERVER);
    }

    static void removeObservers(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(OBSERVER);
    }
}

