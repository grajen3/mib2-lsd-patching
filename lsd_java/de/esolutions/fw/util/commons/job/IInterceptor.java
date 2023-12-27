/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.Job;
import java.io.PrintStream;

public interface IInterceptor {
    default public IInterceptor getNext() {
    }

    default public void setNext(IInterceptor iInterceptor) {
    }

    default public void execute(Job job) {
    }

    default public void dump(PrintStream printStream) {
    }
}

