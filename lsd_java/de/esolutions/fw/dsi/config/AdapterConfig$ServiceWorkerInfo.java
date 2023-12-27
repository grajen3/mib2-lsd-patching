/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.config;

public class AdapterConfig$ServiceWorkerInfo {
    private String name;
    private int minThreadCount;
    private int maxThreadCount;
    private int queueSize;
    private int threadPrio;

    public AdapterConfig$ServiceWorkerInfo(String string, int n, int n2, int n3, int n4) {
        this.name = string;
        this.minThreadCount = n;
        this.maxThreadCount = n2;
        this.queueSize = n3;
        this.threadPrio = n4;
    }

    public String getName() {
        return this.name;
    }

    public int getMinThreadCount() {
        return this.minThreadCount;
    }

    public int getMaxThreadCount() {
        return this.maxThreadCount;
    }

    public int getQueueSize() {
        return this.queueSize;
    }

    public int getThreadPrio() {
        return this.threadPrio;
    }
}

