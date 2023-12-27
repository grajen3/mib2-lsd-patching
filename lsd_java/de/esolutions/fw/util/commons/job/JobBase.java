/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import java.io.PrintStream;

public class JobBase {
    protected static final long DUE_ASAP;
    private long posted;
    private long started;
    private long finished;
    private long due;

    public JobBase(long l) {
        this.posted = 0L;
        this.started = 0L;
        this.finished = 0L;
        this.due = l;
    }

    public JobBase(JobBase jobBase) {
        this.posted = jobBase.posted;
        this.started = jobBase.started;
        this.finished = jobBase.finished;
        this.due = jobBase.due;
    }

    public final void setPosted(long l) {
        this.posted = l;
        if (this.due == 0L) {
            this.due = this.posted;
        }
    }

    public final void setStarted(long l) {
        this.started = l;
    }

    public final void setFinished(long l) {
        this.finished = l;
    }

    public final long getStarted() {
        return this.started;
    }

    public final long getDue() {
        return this.due;
    }

    private final long getFinished() {
        return this.finished;
    }

    public final long getLatency() {
        return this.getStarted() - this.getDue();
    }

    public final long getNeeded() {
        return this.getFinished() - this.getStarted();
    }

    private final void formatLong(PrintStream printStream, long l, int n) {
        String string = Long.toString(l);
        for (int i2 = string.length(); i2 < n; ++i2) {
            printStream.print(" ");
        }
        printStream.print(string);
    }

    public final void dump(PrintStream printStream, String string) {
        printStream.print(string);
        printStream.print("post: ");
        this.formatLong(printStream, this.posted, 6);
        printStream.print(" due: ");
        this.formatLong(printStream, this.due, 6);
        if (this.started > 0L) {
            printStream.print(" strt: ");
            this.formatLong(printStream, this.getStarted(), 6);
            printStream.print(" end: ");
            this.formatLong(printStream, this.getFinished(), 6);
            printStream.print(" wait: ");
            this.formatLong(printStream, this.getLatency(), 6);
            printStream.print(" exec: ");
            this.formatLong(printStream, this.getNeeded(), 6);
        }
        printStream.print(" ");
        printStream.println(this);
    }
}

