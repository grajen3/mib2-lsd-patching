/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system.daynight;

import de.vw.mib.asl.api.system.daynight.DayNightListener;

public interface DayNightService {
    public static final int MODE_DAY;
    public static final int MODE_NIGHT;

    default public int getDayNightModeSensorValue() {
    }

    default public void addListener(DayNightListener dayNightListener) {
    }

    default public void removeListener(DayNightListener dayNightListener) {
    }
}

