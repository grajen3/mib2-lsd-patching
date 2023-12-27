/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.asl.clientapi.impl.ClockConsumer;

interface Clock {
    default public int getInterval() {
    }

    default public void addConsumer(ClockConsumer clockConsumer) {
    }

    default public void removeClockConsumer(ClockConsumer clockConsumer) {
    }
}

