/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.services.tracing;

import de.esolutions.fw.util.commons.tracing.ITraceChannel;
import de.esolutions.fw.util.tracing.TraceClient;

public class FwServicesTracing {
    public static final ITraceChannel GARBAGE_COLLECTOR = TraceClient.createTraceChannel("fw.services.gc");
}

