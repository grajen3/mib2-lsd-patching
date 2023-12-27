/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.entity;

import de.esolutions.fw.util.tracing.entity.TraceEntityType;

public class TraceEntityURI {
    private final short type;
    private final int id;

    public TraceEntityURI(short s, int n) {
        this.type = s;
        this.id = n;
    }

    public short getType() {
        return this.type;
    }

    public int getId() {
        return this.id;
    }

    public String toString() {
        return new StringBuffer().append("[").append(this.id).append(",").append(TraceEntityType.names[this.type]).append("]").toString();
    }

    public boolean equals(Object object) {
        if (!(object instanceof TraceEntityURI)) {
            return false;
        }
        TraceEntityURI traceEntityURI = (TraceEntityURI)object;
        return traceEntityURI.getId() == this.getId() && traceEntityURI.getType() == this.getType();
    }

    public int hashCode() {
        int n = 1;
        n += 11 * this.type;
        return n += 53 * this.id;
    }
}

