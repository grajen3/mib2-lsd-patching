/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.IJobFilter;
import de.esolutions.fw.util.commons.job.Job;
import java.io.PrintStream;

public class BaseJobFilter
implements IJobFilter {
    private IJobFilter next;

    @Override
    public void enqueue(Job job, int n) {
        if (this.next != null) {
            this.next.enqueue(job, n);
        }
    }

    @Override
    public IJobFilter getNext() {
        return this.next;
    }

    @Override
    public void setNext(IJobFilter iJobFilter) {
        this.next = iJobFilter;
    }

    @Override
    public void dump(PrintStream printStream) {
        printStream.println(new StringBuffer().append("  ").append(this).toString());
        if (this.next != null) {
            this.next.dump(printStream);
        }
    }
}

