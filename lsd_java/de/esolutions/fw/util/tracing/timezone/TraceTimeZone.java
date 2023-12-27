/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.timezone;

import de.esolutions.fw.util.tracing.timezone.TraceTimeTuple;

public class TraceTimeZone {
    private final int id;
    private final int resolution;
    private final String name;
    private final int createEpoch;
    private TraceTimeTuple lastUpdate;

    public TraceTimeZone(int n, int n2, String string, int n3) {
        this.id = n;
        this.resolution = n2;
        this.name = string;
        this.createEpoch = n3;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getResolution() {
        return this.resolution;
    }

    public int getCreateEpoch() {
        return this.createEpoch;
    }

    public synchronized void setLastUpdate(TraceTimeTuple traceTimeTuple) {
        this.lastUpdate = traceTimeTuple;
    }

    public synchronized TraceTimeTuple getLastUpdate() {
        return this.lastUpdate;
    }

    public String toString() {
        return new StringBuffer().append("<").append(this.id).append(",").append(this.name).append(",res=").append(this.resolution).append("@").append(this.createEpoch).append("=").append(this.lastUpdate).append(">").toString();
    }
}

