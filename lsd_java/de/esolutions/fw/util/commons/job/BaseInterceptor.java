/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.IInterceptor;
import de.esolutions.fw.util.commons.job.Job;
import java.io.PrintStream;

public class BaseInterceptor
implements IInterceptor {
    private volatile IInterceptor next = null;

    protected BaseInterceptor() {
        this.setNext(null);
    }

    @Override
    public void execute(Job job) {
        this.next.execute(job);
    }

    @Override
    public final IInterceptor getNext() {
        return this.next;
    }

    @Override
    public final void setNext(IInterceptor iInterceptor) {
        this.next = iInterceptor;
    }

    @Override
    public void dump(PrintStream printStream) {
        if (printStream != null && this.getNext() != null) {
            this.getNext().dump(printStream);
        }
    }
}

