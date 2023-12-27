/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.clientapi.impl;

import de.vw.mib.asl.clientapi.impl.Clock;
import de.vw.mib.asl.clientapi.impl.ClockConsumer;
import de.vw.mib.collections.copyonwrite.CowArray;

class ClockImpl
implements Clock,
Runnable {
    private final int interval;
    private final CowArray consumers = new CowArray();

    ClockImpl(int n) {
        this.interval = n;
    }

    @Override
    public int getInterval() {
        return this.interval;
    }

    @Override
    public void addConsumer(ClockConsumer clockConsumer) {
        this.consumers.addIfNotAlreadyIn(clockConsumer);
    }

    @Override
    public void removeClockConsumer(ClockConsumer clockConsumer) {
        this.consumers.remove(clockConsumer);
    }

    @Override
    public void run() {
        this.onTimer();
    }

    void onTimer() {
        Object[] objectArray = this.consumers.getArray();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            ((ClockConsumer)objectArray[i2]).onClock(this);
        }
    }
}

