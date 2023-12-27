/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal;

import de.vw.mib.dsi.trace.DSITraceService;
import de.vw.mib.dsi.trace.optimized.internal.generated.dsi.DSITraceServiceOptimizedImplementation;

public final class DSITraceServiceOptimizedFactory {
    private static DSITraceService INSTANCE;

    public static synchronized DSITraceService get() {
        if (INSTANCE == null) {
            INSTANCE = new DSITraceServiceOptimizedImplementation();
        }
        return INSTANCE;
    }

    private DSITraceServiceOptimizedFactory() {
    }
}

