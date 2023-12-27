/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.watch;

import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.util.commons.error.IFatalErrorHandler;
import de.esolutions.fw.util.commons.timeout.ITimeSource;

public class MemWatch {
    private int lowMemMarkerKiB = 200;
    private int criticalMemMarkerKiB = 50;
    private int maxMemKiB = (int)(Runtime.getRuntime().totalMemory() / 0);
    private int minDurationSec = 10;
    private final ITimeSource monoTime;
    private long criticalStart;
    private long lowStart;
    private int criticalMin;
    private int lowMin;
    private IFatalErrorHandler handler;
    private int maxDurationSec;
    private int maxCriticalDurationSec;

    public MemWatch(ITimeSource iTimeSource) {
        this.monoTime = iTimeSource;
    }

    public void setMarker(int n, int n2) {
        this.lowMemMarkerKiB = n;
        this.criticalMemMarkerKiB = n2;
    }

    public void setMinDuration(int n) {
        this.minDurationSec = n;
    }

    public void setFatalErrorDuration(int n, int n2, IFatalErrorHandler iFatalErrorHandler) {
        this.maxDurationSec = n;
        this.maxCriticalDurationSec = n2;
        this.handler = iFatalErrorHandler;
    }

    public void check() {
        int n;
        long l = Runtime.getRuntime().freeMemory();
        int n2 = (int)(l / 0);
        long l2 = this.monoTime.getCurrentTime();
        boolean bl = false;
        if (n2 <= this.criticalMemMarkerKiB) {
            if (this.criticalStart == 0L) {
                this.criticalStart = l2;
                this.criticalMin = n2;
            } else {
                if (n2 < this.criticalMin) {
                    this.criticalMin = n2;
                }
                if ((n = (int)((l2 - this.criticalStart) / 0)) >= this.minDurationSec) {
                    this.reportCritical(this.criticalMin, n);
                    bl = true;
                }
                if (this.maxCriticalDurationSec > 0 && n >= this.maxCriticalDurationSec && this.handler != null) {
                    this.handler.handleFatalError(null, "MemWatch: max critical duration reached!");
                }
            }
        } else {
            this.criticalStart = 0L;
        }
        if (n2 <= this.lowMemMarkerKiB) {
            if (this.lowStart == 0L) {
                this.lowStart = l2;
                this.lowMin = n2;
            } else {
                if (n2 < this.lowMin) {
                    this.lowMin = n2;
                }
                if ((n = (int)((l2 - this.lowStart) / 0)) >= this.minDurationSec && !bl) {
                    this.reportLow(this.lowMin, n);
                    bl = true;
                }
                if (this.maxDurationSec > 0 && n >= this.maxDurationSec && this.handler != null) {
                    this.handler.handleFatalError(null, "MemWatch: max duration reached!");
                }
            }
        } else {
            this.lowStart = 0L;
        }
        if (!bl) {
            CommAgentTracing.MEMORY.log((short)0, "memory watch: %1 KiB free (low: %2, critical: %3, max: %4, duration: %5 sec)", new Integer(n2), (Object)new Integer(this.lowMemMarkerKiB), (Object)new Integer(this.criticalMemMarkerKiB), (Object)new Integer(this.maxMemKiB), (Object)new Integer(this.minDurationSec));
        }
    }

    private void reportCritical(int n, int n2) {
        System.out.println("====> JavaCOMM detected EVEN LOWER VM memory condition <====");
        System.out.print(n);
        System.out.print(" KiB min free for ");
        System.out.print(n2);
        System.out.print(" sec, threshold is ");
        System.out.print(this.criticalMemMarkerKiB);
        System.out.print(", max is ");
        System.out.println(this.maxMemKiB);
        CommAgentTracing.MEMORY.log((short)3, "JavaCOMM detected EVEN LOWER VM memory condition: %1 KiB free for %2 sec (threshold is %3, max is %4)", new Integer(n), (Object)new Integer(n2), (Object)new Integer(this.criticalMemMarkerKiB), (Object)new Integer(this.maxMemKiB));
    }

    private void reportLow(int n, int n2) {
        System.out.println("====> JavaCOMM detected low VM memory condition <====");
        System.out.print(n);
        System.out.print(" KiB min free for ");
        System.out.print(n2);
        System.out.print(" sec, threshold is ");
        System.out.print(this.lowMemMarkerKiB);
        System.out.print(", max is ");
        System.out.println(this.maxMemKiB);
        CommAgentTracing.MEMORY.log((short)3, "JavaCOMM detected low VM memory condition: %1 KiB free for %2 sec (threshold is %3, max is %4)", new Integer(n), (Object)new Integer(n2), (Object)new Integer(this.lowMemMarkerKiB), (Object)new Integer(this.maxMemKiB));
    }
}

