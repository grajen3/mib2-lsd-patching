/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has;

import de.vw.mib.has.HASClockConsumer;

public interface HASClock {
    default public int getInterval() {
    }

    default public void addConsumer(HASClockConsumer hASClockConsumer) {
    }

    default public void removeConsumer(HASClockConsumer hASClockConsumer) {
    }
}

