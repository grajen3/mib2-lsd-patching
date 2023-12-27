/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.widgets.RunnerWidget;
import de.vw.mib.widgets.internal.ServiceManager;

final class RunnerWidget$ValueChanger
implements Runnable {
    private RunnerWidget runner;
    private long internalTimeAtTimerStart;
    private long startTime;
    private final /* synthetic */ RunnerWidget this$0;

    public RunnerWidget$ValueChanger(RunnerWidget runnerWidget, RunnerWidget runnerWidget2, long l) {
        this.this$0 = runnerWidget;
        this.runner = runnerWidget2;
        this.internalTimeAtTimerStart = l;
        this.startTime = ServiceManager.timerManager.getSystemTimeMillis();
    }

    @Override
    public void run() {
        long l = ServiceManager.timerManager.getSystemTimeMillis() - this.startTime;
        long l2 = this.internalTimeAtTimerStart + l;
        if (!this.runner.doUpdate()) {
            return;
        }
        this.runner.setInternalTime(l2);
        int n = this.this$0.calculateValueFromTime(l2);
        if ((this.runner.is_unbounded() || n >= this.this$0.get_valueMin() && n <= this.this$0.get_valueMax()) && this.runner.getPropagateValueChange()) {
            this.this$0.set_value(n);
        }
    }
}

