/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.profile;

import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.profile.TraceMsgStats;
import java.io.PrintStream;

public class TraceProfiler {
    private TraceMsgStats msgStats = new TraceMsgStats();
    private TraceMsgStats dropStats = new TraceMsgStats();

    public void reset() {
        this.msgStats.reset();
        this.dropStats.reset();
    }

    public void accountDrop(int n) {
        long l = System.currentTimeMillis();
        this.dropStats.account(l, n);
    }

    public void accountMessage(ITraceMessage iTraceMessage) {
        int n = iTraceMessage.getMessageData().length;
        long l = System.currentTimeMillis();
        this.msgStats.account(l, n);
    }

    public void report(PrintStream printStream) {
        if (this.msgStats.isValid()) {
            printStream.print("logged: ");
            this.msgStats.report(printStream);
            printStream.println();
        }
        if (this.dropStats.isValid()) {
            printStream.print("dropped: ");
            this.dropStats.report(printStream);
            printStream.println();
        }
    }
}

