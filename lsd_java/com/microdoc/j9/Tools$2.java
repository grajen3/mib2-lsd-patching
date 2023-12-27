/*
 * Decompiled with CFR 0.152.
 */
package com.microdoc.j9;

import com.microdoc.j9.Tools;
import com.microdoc.j9.Tools$IntervalThread;

class Tools$2
extends Tools$IntervalThread {
    private final /* synthetic */ int val$priority;

    Tools$2(long l, long l2, int n) {
        super(l, l2);
        this.val$priority = n;
    }

    @Override
    public void run() {
        this.setName("Thread Dump - Loop");
        this.setPriority(this.val$priority);
        Tools.access$1(this.fInterval, this.fInitialDelay, Integer.getInteger("deadlockDetection", -1));
    }
}

