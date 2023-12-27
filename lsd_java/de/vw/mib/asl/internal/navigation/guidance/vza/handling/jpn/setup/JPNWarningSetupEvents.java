/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.vza.handling.jpn.setup;

import de.vw.mib.genericevents.AbstractTarget;

public final class JPNWarningSetupEvents {
    static final int[] OBSERVERS = new int[]{-385744832, 1690898496, 1724452928, 1707675712, 1741230144};

    private JPNWarningSetupEvents() {
    }

    static void addObservers(AbstractTarget abstractTarget) {
        abstractTarget.addObservers(OBSERVERS);
    }

    static void removeObservers(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(OBSERVERS);
    }
}

