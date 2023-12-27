/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.format;

import de.esolutions.fw.util.tracing.entity.TraceEntityURI;

public interface ITraceEntityResolver {
    default public String resolveName(TraceEntityURI traceEntityURI) {
    }

    default public String resolvePath(TraceEntityURI traceEntityURI, boolean bl) {
    }

    default public String resolveParentName(TraceEntityURI traceEntityURI, short s) {
    }
}

