/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.threads;

public final class MIBThreadDescription {
    private final int id;
    private final String name;
    private final int priority;
    private final boolean terminateOnError;
    private final boolean useWatchdog;
    private final int watchdogRetries;
    private final long watchdogStartTime;
    private final long watchdogTimeout;

    public static MIBThreadDescription defineMIBThread(int n, String string, int n2) {
        return new MIBThreadDescription(n, string, n2, true, false, -1L, -1, -1L);
    }

    public static MIBThreadDescription defineMIBThreadWithWatchdog(int n, String string, int n2, boolean bl, long l, int n3, long l2) {
        return new MIBThreadDescription(n, string, n2, bl, true, l, n3, l2);
    }

    private MIBThreadDescription(int n, String string, int n2, boolean bl, boolean bl2, long l, int n3, long l2) {
        this.id = n;
        this.name = string;
        this.priority = n2;
        this.terminateOnError = bl;
        this.useWatchdog = bl2;
        this.watchdogTimeout = l;
        this.watchdogRetries = n3;
        this.watchdogStartTime = l2;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getWatchdogRetries() {
        return this.watchdogRetries;
    }

    public long getWatchdogStartTime() {
        return this.watchdogStartTime;
    }

    public long getWatchdogTimeout() {
        return this.watchdogTimeout;
    }

    public boolean isTerminateOnError() {
        return this.terminateOnError;
    }

    public boolean isUseWatchdog() {
        return this.useWatchdog;
    }
}

