/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized;

import de.vw.mib.dsi.trace.DSITraceService;
import de.vw.mib.dsi.trace.internal.AbstractDSITraceServiceActivator;
import de.vw.mib.dsi.trace.optimized.internal.DSITraceServiceOptimizedFactory;

public class DSITraceServiceActivator
extends AbstractDSITraceServiceActivator {
    @Override
    protected boolean initDSITraceService() {
        DSITraceService dSITraceService = DSITraceServiceOptimizedFactory.get();
        this.setDSITraceServiceForOSGiRegistration(dSITraceService);
        return true;
    }
}

