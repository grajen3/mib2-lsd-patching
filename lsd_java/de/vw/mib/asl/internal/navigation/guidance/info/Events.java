/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.guidance.info;

import de.vw.mib.genericevents.AbstractTarget;

public final class Events {
    public static final int[] OBSERVER = new int[]{637665344, -503185344, -419299264, 329072896, 345850112, -509853440, -425967360, 744240384, 693908736, 710685952, 727463168, 861680896, 878458112, 912012544, 777794816, 1063007488};

    private Events() {
    }

    static void addObservers(AbstractTarget abstractTarget) {
        abstractTarget.addObservers(OBSERVER);
    }

    static void removeObservers(AbstractTarget abstractTarget) {
        abstractTarget.removeObservers(OBSERVER);
    }
}

