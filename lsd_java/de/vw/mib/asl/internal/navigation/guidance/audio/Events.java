/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.audio;

import de.vw.mib.genericevents.AbstractTarget;

public final class Events {
    public static final int EV_ASL_INT_ALTERNATIVE_RC_SELECTROUTE_ANNOUNCEMENT_ON;
    public static final int EV_ASL_INT_ALTERNATIVE_RC_SELECTROUTE_ANNOUNCEMENT_OFF;
    public static final int EV_ASL_INT_SOUND_SET_CONNECTION_RESULT;
    static final int[] OBSERVERS;

    private Events() {
    }

    static void addObservers(AbstractTarget abstractTarget) {
        abstractTarget.addObservers(OBSERVERS);
    }

    static void removeObservers(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(OBSERVERS);
    }

    static {
        OBSERVERS = new int[]{33882176, 268566592, -1090453440, 620888128, -1073676224, 252263680, 319372544, 520699136, 352926976, 0x24020040};
    }
}

