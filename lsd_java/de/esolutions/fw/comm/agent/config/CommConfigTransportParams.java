/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.config;

public class CommConfigTransportParams {
    public static boolean DEFAULT_ASYNC = false;
    public static int DEFAULT_PRIORITY = 5;
    public static int DEFAULT_QUEUE_LIMIT_JOBS = 0;
    public static int DEFAULT_QUEUE_LIMIT_BYTES = 0;
    private boolean async;
    private int priority;
    private int queueLimitBytes;
    private int queueLimitJobs;

    public CommConfigTransportParams() {
        this.async = DEFAULT_ASYNC;
        this.priority = DEFAULT_PRIORITY;
        this.queueLimitJobs = DEFAULT_QUEUE_LIMIT_JOBS;
        this.queueLimitBytes = DEFAULT_QUEUE_LIMIT_BYTES;
    }

    public CommConfigTransportParams(CommConfigTransportParams commConfigTransportParams) {
        this.async = commConfigTransportParams.getAsync();
        this.priority = commConfigTransportParams.getPriority();
        this.queueLimitJobs = commConfigTransportParams.getQueueLimitJobs();
        this.queueLimitBytes = commConfigTransportParams.getQueueLimitBytes();
    }

    public CommConfigTransportParams(boolean bl, int n, int n2, int n3) {
        this.async = bl;
        this.priority = n;
        this.queueLimitJobs = n2;
        this.queueLimitBytes = n3;
    }

    public boolean getAsync() {
        return this.async;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getQueueLimitBytes() {
        return this.queueLimitBytes;
    }

    public int getQueueLimitJobs() {
        return this.queueLimitJobs;
    }

    public String toString() {
        return new StringBuffer().append("[async=").append(this.async).append(",priority=").append(this.priority).append(",queueLimitBytes=").append(this.queueLimitBytes).append(",queueLimitJobs=").append(this.queueLimitJobs).append("]").toString();
    }
}

