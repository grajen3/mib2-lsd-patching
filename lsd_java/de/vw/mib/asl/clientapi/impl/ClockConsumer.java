/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.asl.clientapi.impl.Clock;

interface ClockConsumer {
    default public void onClock(Clock clock) {
    }
}

