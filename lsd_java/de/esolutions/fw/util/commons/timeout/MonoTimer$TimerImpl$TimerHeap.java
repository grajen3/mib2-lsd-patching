/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.timeout;

import de.esolutions.fw.util.commons.timeout.MonoTimer$1;
import de.esolutions.fw.util.commons.timeout.MonoTimerTask;

final class MonoTimer$TimerImpl$TimerHeap {
    private int DEFAULT_HEAP_SIZE = 256;
    private MonoTimerTask[] timers = new MonoTimerTask[this.DEFAULT_HEAP_SIZE];
    private int size = 0;
    private int deletedCancelledNumber = 0;

    private MonoTimer$TimerImpl$TimerHeap() {
    }

    public MonoTimerTask minimum() {
        return this.timers[0];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void insert(MonoTimerTask monoTimerTask) {
        if (this.timers.length == this.size) {
            MonoTimerTask[] monoTimerTaskArray = new MonoTimerTask[this.size * 2];
            System.arraycopy((Object)this.timers, 0, (Object)monoTimerTaskArray, 0, this.size);
            this.timers = monoTimerTaskArray;
        }
        this.timers[this.size++] = monoTimerTask;
        this.upHeap();
    }

    public void delete(int n) {
        if (n >= 0 && n < this.size) {
            this.timers[n] = this.timers[--this.size];
            this.timers[this.size] = null;
            this.downHeap(n);
        }
    }

    private void upHeap() {
        int n = this.size - 1;
        int n2 = (n - 1) / 2;
        while (this.timers[n].when < this.timers[n2].when) {
            MonoTimerTask monoTimerTask = this.timers[n];
            this.timers[n] = this.timers[n2];
            this.timers[n2] = monoTimerTask;
            n = n2;
            n2 = (n - 1) / 2;
        }
    }

    private void downHeap(int n) {
        int n2 = n;
        int n3 = 2 * n2 + 1;
        while (n3 < this.size && this.size > 0) {
            if (n3 + 1 < this.size && this.timers[n3 + 1].when < this.timers[n3].when) {
                ++n3;
            }
            if (this.timers[n2].when < this.timers[n3].when) break;
            MonoTimerTask monoTimerTask = this.timers[n2];
            this.timers[n2] = this.timers[n3];
            this.timers[n3] = monoTimerTask;
            n2 = n3;
            n3 = 2 * n2 + 1;
        }
    }

    public void reset() {
        this.timers = new MonoTimerTask[this.DEFAULT_HEAP_SIZE];
        this.size = 0;
    }

    public void deleteIfCancelled() {
        for (int i2 = 0; i2 < this.size; ++i2) {
            if (!this.timers[i2].cancelled) continue;
            ++this.deletedCancelledNumber;
            this.delete(i2);
            --i2;
        }
    }

    private int getTask(MonoTimerTask monoTimerTask) {
        for (int i2 = 0; i2 < this.timers.length; ++i2) {
            if (this.timers[i2] != monoTimerTask) continue;
            return i2;
        }
        return -1;
    }

    /* synthetic */ MonoTimer$TimerImpl$TimerHeap(MonoTimer$1 monoTimer$1) {
        this();
    }

    static /* synthetic */ int access$100(MonoTimer$TimerImpl$TimerHeap monoTimer$TimerImpl$TimerHeap, MonoTimerTask monoTimerTask) {
        return monoTimer$TimerImpl$TimerHeap.getTask(monoTimerTask);
    }

    static /* synthetic */ int access$202(MonoTimer$TimerImpl$TimerHeap monoTimer$TimerImpl$TimerHeap, int n) {
        monoTimer$TimerImpl$TimerHeap.deletedCancelledNumber = n;
        return monoTimer$TimerImpl$TimerHeap.deletedCancelledNumber;
    }

    static /* synthetic */ int access$200(MonoTimer$TimerImpl$TimerHeap monoTimer$TimerImpl$TimerHeap) {
        return monoTimer$TimerImpl$TimerHeap.deletedCancelledNumber;
    }
}

