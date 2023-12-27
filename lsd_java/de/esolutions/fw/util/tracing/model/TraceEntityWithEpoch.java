/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.model;

import de.esolutions.fw.util.tracing.model.TraceEntity;

public class TraceEntityWithEpoch {
    private TraceEntity entity;
    private int epoch;

    public TraceEntityWithEpoch(TraceEntity traceEntity, int n) {
        this.entity = traceEntity;
        this.epoch = n;
    }

    public TraceEntity getEntity() {
        return this.entity;
    }

    public int getEpoch() {
        return this.epoch;
    }
}

