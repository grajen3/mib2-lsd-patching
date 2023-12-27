/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.core;

import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.timeout.TimeSourceProvider;

public class TraceCoreReplySignal {
    private int value = -1;

    public synchronized void waitForSignal(int n) {
        while (this.value < n) {
            super.wait();
        }
    }

    public synchronized boolean waitForSignalWithTimeout(int n, long l) {
        ITimeSource iTimeSource = TimeSourceProvider.getMonotonicTimeSource();
        long l2 = iTimeSource.getCurrentTime();
        long l3 = l;
        while (this.value < n) {
            super.wait(l3);
            if (l <= 0L) continue;
            long l4 = iTimeSource.getCurrentTime();
            long l5 = l4 - l2;
            if (l5 >= l) {
                return false;
            }
            l3 = l - l5;
        }
        return true;
    }

    public synchronized void triggerSignal(int n) {
        this.value = n;
        super.notify();
    }
}

