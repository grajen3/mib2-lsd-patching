/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.threading;

class ThreadPool$JobListElement {
    Runnable job;
    long insertTime;

    ThreadPool$JobListElement(Runnable runnable, long l) {
        this.job = runnable;
        this.insertTime = l;
    }
}

