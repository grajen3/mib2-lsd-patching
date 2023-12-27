/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.diag;

import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.diag.GenericEventTracer$1;

public interface GenericEventTracer {
    public static final byte ENQUEUE;
    public static final byte DEQUEUE;
    public static final byte TRIGGER_SERVICE;
    public static final byte NOT_OBSERVED_SERVICE_TRIGGERED;
    public static final byte UNKNOWN_TASK;
    public static final byte UNSPECIFIED_TASK;
    public static final byte HSM_TASK;
    public static final byte DEBUG_TASK;
    public static final GenericEventTracer EMPTY_TRACER;

    default public void trace(byte by, byte by2, int n, EventGeneric eventGeneric) {
    }

    static {
        EMPTY_TRACER = new GenericEventTracer$1();
    }
}

