/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.core;

import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.timeout.TimeSourceProvider;

public class TraceCoreSignal {
    public static int COMMAND = 1;
    public static int MESSAGE = 2;
    public static int BREAK = 4;
    public static int TIMEOUT = 8;
    private int signalMask;

    public synchronized int waitForSignal() {
        while (this.signalMask == 0) {
            super.wait();
        }
        int n = this.signalMask;
        this.signalMask = 0;
        return n;
    }

    public synchronized int waitForSignalWithTimeout(long l) {
        ITimeSource iTimeSource = TimeSourceProvider.getMonotonicTimeSource();
        long l2 = iTimeSource.getCurrentTime();
        long l3 = l;
        while (this.signalMask == 0) {
            super.wait(l3);
            if (l <= 0L) continue;
            long l4 = iTimeSource.getCurrentTime();
            long l5 = l4 - l2;
            if (l5 >= l) {
                this.signalMask |= TIMEOUT;
                continue;
            }
            l3 = l - l5;
        }
        int n = this.signalMask;
        this.signalMask = 0;
        return n;
    }

    public synchronized void triggerSignal(int n) {
        this.signalMask |= n;
        super.notify();
    }
}

