/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.entity;

import de.esolutions.fw.util.tracing.entity.TraceEntityURI;

public interface IExternalTraceEntity {
    default public String getName() {
    }

    default public TraceEntityURI getURI() {
    }

    default public TraceEntityURI getParentURI() {
    }

    default public short getFilterLevel() {
    }
}

