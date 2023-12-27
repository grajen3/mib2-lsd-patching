/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.StatisticInterceptor;
import java.io.PrintStream;

public class StatisticData {
    final int length;
    final int dueJobs;
    final int jobRate;
    final int load;
    final int currentDelay;

    public StatisticData(DispatcherBase dispatcherBase) {
        this.length = dispatcherBase.getQueue().length();
        this.dueJobs = dispatcherBase.getQueue().getDueJobs();
        StatisticInterceptor statisticInterceptor = dispatcherBase.getStatisticInterceptor();
        if (statisticInterceptor != null) {
            this.jobRate = (int)statisticInterceptor.getCurrentJobRate();
            this.load = (int)statisticInterceptor.getCurrentJobLoad();
            this.currentDelay = (int)statisticInterceptor.getCurrentDelay();
        } else {
            this.jobRate = 0;
            this.load = 0;
            this.currentDelay = 0;
        }
    }

    public String toString() {
        Buffer buffer = new Buffer(128);
        buffer.append("Delay: ").append(this.currentDelay);
        buffer.append(" Jobs: ").append(this.length);
        buffer.append(" DueJobs: ").append(this.dueJobs);
        buffer.append(" JobRate: ").append(this.jobRate).append("/s");
        buffer.append(" Load: ").append(this.load).append('%');
        return buffer.toString();
    }

    public final void dump(PrintStream printStream, String string) {
        printStream.print(string);
        printStream.print("Delay: ");
        printStream.print(this.currentDelay);
        printStream.print(" Jobs: ");
        printStream.print(this.length);
        printStream.print(" DueJobs: ");
        printStream.print(this.dueJobs);
        printStream.print(" jobRate: ");
        printStream.print(this.jobRate);
        printStream.print("/s");
        printStream.print(" Load: ");
        printStream.print(this.load);
        printStream.println('%');
    }
}

