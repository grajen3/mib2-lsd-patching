/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import java.util.Timer;
import java.util.Timer$TimerImpl;

final class Timer$1 {
    final /* synthetic */ Timer this$0;

    Timer$1(Timer timer) {
        this.this$0 = timer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void finalize() {
        Timer$TimerImpl timer$TimerImpl = Timer.access$0(this.this$0);
        synchronized (timer$TimerImpl) {
            Timer$TimerImpl.access$0(Timer.access$0(this.this$0), true);
            super.notify();
        }
    }
}

