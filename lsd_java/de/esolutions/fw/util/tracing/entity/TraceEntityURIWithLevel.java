/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.entity;

import de.esolutions.fw.util.tracing.entity.TraceEntityURI;

public final class TraceEntityURIWithLevel
extends TraceEntityURI {
    private short level;

    public TraceEntityURIWithLevel(TraceEntityURI traceEntityURI, short s) {
        super(traceEntityURI.getType(), traceEntityURI.getId());
        this.level = s;
    }

    public TraceEntityURIWithLevel(short s, int n, short s2) {
        super(s, n);
        this.level = s2;
    }

    public short getLevel() {
        return this.level;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TraceEntityURI)) {
            return false;
        }
        TraceEntityURI traceEntityURI = (TraceEntityURI)object;
        return traceEntityURI.getId() == this.getId() && traceEntityURI.getType() == this.getType();
    }

    @Override
    public int hashCode() {
        int n = 1;
        n += 11 * this.getType();
        return n += 53 * this.getId();
    }
}

