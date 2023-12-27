/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.perf.service.intern;

import de.vw.mib.perf.service.intern.PerfServiceMIBHMI;
import java.util.TimerTask;

class PerfServiceMIBHMI$1
extends TimerTask {
    private final /* synthetic */ PerfServiceMIBHMI this$0;

    PerfServiceMIBHMI$1(PerfServiceMIBHMI perfServiceMIBHMI) {
        this.this$0 = perfServiceMIBHMI;
    }

    @Override
    public void run() {
        this.this$0.writePerformanceDataIntoLog();
        this.this$0.m_oTimer.cancel();
    }
}

