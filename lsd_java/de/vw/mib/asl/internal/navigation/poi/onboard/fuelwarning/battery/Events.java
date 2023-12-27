/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.poi.onboard.fuelwarning.battery;

import de.vw.mib.genericevents.AbstractTarget;

public final class Events {
    static final int[] OBSERVERS = new int[]{134873152, 151650368, -77384448, 482938944};

    private Events() {
    }

    static void addObservers(AbstractTarget abstractTarget) {
        abstractTarget.addObservers(OBSERVERS);
    }

    static void removeObservers(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(OBSERVERS);
    }
}

