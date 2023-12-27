/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.Job;
import java.io.PrintStream;

public interface IJobFilter {
    default public IJobFilter getNext() {
    }

    default public void setNext(IJobFilter iJobFilter) {
    }

    default public void enqueue(Job job, int n) {
    }

    default public void dump(PrintStream printStream) {
    }
}

