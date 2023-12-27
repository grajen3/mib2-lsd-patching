/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navinfotile.pnav;

import de.vw.mib.genericevents.AbstractTarget;

public final class Events {
    static final int[] OBSERVERS = new int[]{-486122944, -469345728};

    private Events() {
    }

    static void addObservers(AbstractTarget abstractTarget) {
        abstractTarget.addObservers(OBSERVERS);
    }

    static void removeObservers(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(OBSERVERS);
    }
}

