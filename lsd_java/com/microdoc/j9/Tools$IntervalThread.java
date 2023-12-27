/*
 * Decompiled with CFR 0.152.
 */
package com.microdoc.j9;

class Tools$IntervalThread
extends Thread {
    long fInterval;
    long fInitialDelay;

    public Tools$IntervalThread(long l, long l2) {
        this.fInterval = l;
        this.fInitialDelay = l2;
    }
}

