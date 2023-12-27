/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.main;

import de.vw.mib.genericevents.AbstractTarget;

public final class Events {
    public static final int EV_ASL_INT_UPDATECLAMP15;
    public static final int EV_ASL_INT_VELOCITY_OVER_5KMH;
    public static final int EV_ASL_INT_TRIGGER_ROUTE_RECALCULATION;
    public static final int EV_ASL_INT_GUIDANCE_START_FROM_EXTERN;
    public static final int EV_ASL_INT_GUIDANCE_START_DEMO_FROM_EXTERN;
    public static final int EV_ASL_INT_PREDICTIVE_GUIDANCE_ACTIVE;
    public static final int EV_ASL_INT_PREDICTIVE_GUIDANCE_ACTIVE__P0_NAVSEGMENTID;
    public static final int EV_ASL_INT_GUIDANCE_START_RECALCULATION_FROM_EXTERN;
    public static final int EV_ASL_INT_GUIDANCE_START_DEMO_RECALCULATION_FROM_EXTERN;
    public static final int EV_ASL_INT_GUIDANCE_TRIGGER_EVENT_AUDIO_MESSAGE_FROM_EXTERN;
    public static final int EV_ASL_INT_GUIDANCE_TRIGGER_EVENT_AUDIO_MESSAGE_FROM_EXTERN__P0_SOUNDID;
    private static final int[] OBSERVERS;
    private static final int[] ASL_SERVICES;

    private Events() {
    }

    static void addObservers(AbstractTarget abstractTarget) {
        abstractTarget.addObservers(OBSERVERS);
    }

    static void removeObservers(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(OBSERVERS);
    }

    static void registerASLServices(AbstractTarget abstractTarget) {
        abstractTarget.registerServices(ASL_SERVICES, false);
    }

    static {
        OBSERVERS = new int[]{486670400, 503447616, 0x20020040, 0x24020040, 285343808, 520224832, 100794432, 1376256064, 0x22020040, 553779264, 1963393088, 587333696, 0x74070040, -569835456, 446513408, 178077952, -459521792, -493076224, 693908736, 744240384, 710685952, 986255424, 1003032640, 1036587072, 1019809856, 861680896, 878458112, 1590235200, 1892225088, 345850112, 1959333952};
        ASL_SERVICES = new int[]{777794816, 794572032, 761017600, 811349248};
    }
}

