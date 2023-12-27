/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.has.HASClock;
import de.vw.mib.has.HASClockConsumer;

class HASClockImpl
implements HASClock {
    private int interval;
    private final CowArray consumers = new CowArray();

    HASClockImpl() {
    }

    @Override
    public int getInterval() {
        return this.interval;
    }

    void setInterval(int n) {
        this.interval = n;
    }

    @Override
    public void addConsumer(HASClockConsumer hASClockConsumer) {
        this.consumers.addIfNotAlreadyIn(hASClockConsumer);
    }

    @Override
    public void removeConsumer(HASClockConsumer hASClockConsumer) {
        this.consumers.remove(hASClockConsumer);
    }

    void onTimer() {
        Object[] objectArray = this.consumers.getArray();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            ((HASClockConsumer)objectArray[i2]).onClock(this);
        }
    }
}

