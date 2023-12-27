/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.has;

import de.vw.mib.genericevents.AbstractTarget;

public final class Events {
    public static final int EV_ASL_INT_HAS_START_GUIDANCE;
    public static final int EV_ASL_INT_HAS_START_GUIDANCE__P0_INT;
    public static final int EV_ASL_INT_HAS_START_GUIDANCE__P1_ADDRESSCONTAINER;
    public static final int EV_ASL_INT_HAS_STOP_GUIDANCE;
    public static final int EV_ASL_INT_HAS_STOP_GUIDANCE__P0_INT;
    public static final int EV_ASL_INT_HAS_RESOLVE_ADDRESS;
    public static final int EV_ASL_INT_HAS_RESOLVE_ADDRESS__P0_INT;
    public static final int EV_ASL_INT_HAS_RESOLVE_ADDRESS__P1_ADDRESSCONTAINER;
    public static final int EV_ASL_INT_HAS_RESOLVE_LAST_DESTINATION;
    public static final int EV_ASL_INT_HAS_RESOLVE_LAST_DESTINATION__P0_INT;
    public static final int EV_ASL_INT_HAS_RESOLVE_LAST_DESTINATION__P1_LASTDESTINATIONCONTAINER;
    public static final int EV_ASL_INT_HAS_IMPORT_GPX;
    public static final int EV_ASL_INT_HAS_IMPORT_GPX__P0_INT;
    public static final int EV_ASL_INT_HAS_IMPORT_GPX__P1_IMPORTGPXDATACONTAINER;
    public static final int EV_ASL_INT_IMPORT_GPX_RESULT;
    public static final int EV_ASL_INT_IMPORT_GPX_RESULT__P0_NAVLOCATION;
    private static final int[] OBSERVER;

    private Events() {
    }

    static void addObservers(AbstractTarget abstractTarget) {
        abstractTarget.addObservers(OBSERVER);
    }

    static void removeObservers(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(OBSERVER);
    }

    static {
        OBSERVER = new int[]{761017600, 794572032, 777794816, 1456017472, 1180448000};
    }
}

