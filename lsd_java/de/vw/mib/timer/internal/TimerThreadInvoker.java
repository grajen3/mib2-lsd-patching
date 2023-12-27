/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.timer.internal;

import de.vw.mib.timer.Invoker;

public final class TimerThreadInvoker
implements Invoker {
    public static Invoker TIMER_THREAD_INVOKER = new TimerThreadInvoker();

    private TimerThreadInvoker() {
    }

    @Override
    public void invoke(Runnable runnable) {
        runnable.run();
    }
}

