/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.internal;

import de.vw.mib.dsi.trace.DSITraceService;
import de.vw.mib.dsi.trace.internal.AbstractDSITraceServiceImplementation$TracerLoadInfo;
import de.vw.mib.dsi.trace.internal.DSIObjectTracer;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDSITraceServiceImplementation
extends DSITraceService {
    static final String EMPTYSTRING;
    static final String EXCEPTIONMESSAGE_INVALID_DSI_DATATYPE;
    private final Map mapWithDSIObjectTracers = this.initMapWithDSIObjectTracers();

    public AbstractDSITraceServiceImplementation() {
        this.registerAllDSIObjectTracerImplementations();
    }

    protected Map initMapWithDSIObjectTracers() {
        return new HashMap(1200);
    }

    @Override
    public final void toTrace(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            throw new NullPointerException("PrintWriter for DSI tracing is null.");
        }
        if (object == null) {
            printWriter.print("null");
            return;
        }
        if (!this.isValidDSITraceObject(object)) {
            throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
        }
        DSIObjectTracer dSIObjectTracer = this.resolveDSIObjectTracer(object);
        if (dSIObjectTracer != null) {
            dSIObjectTracer.traceDSIObject(printWriter, object);
        } else {
            this.traceWithFallback(printWriter, object);
        }
    }

    @Override
    public String getDSITraceServiceInfoString() {
        return "";
    }

    protected void traceWithFallback(PrintWriter printWriter, Object object) {
        printWriter.print(object.toString());
    }

    protected final void registerDSIObjectTracer(Class clazz, DSIObjectTracer dSIObjectTracer) {
        this.mapWithDSIObjectTracers.put(clazz, dSIObjectTracer);
    }

    protected final DSIObjectTracer resolveDSIObjectTracer(Object object) {
        return (DSIObjectTracer)this.mapWithDSIObjectTracers.get(object.getClass());
    }

    protected boolean isValidDSITraceObject(Object object) {
        return true;
    }

    protected abstract void registerAllDSIObjectTracerImplementations() {
    }

    protected static final DSIObjectTracer createDSIObjectTracer(String string) {
        try {
            Class clazz = Class.forName(string);
            Object object = clazz.newInstance();
            return (DSIObjectTracer)object;
        }
        catch (Exception exception) {
            AbstractDSITraceServiceImplementation.logError(new StringBuffer().append("Failed to create DSIObjectTracer for class: ").append(string).toString(), exception);
            return null;
        }
    }

    private static TracerLoadInfo getTracerLoadInfoFromResourceStream(InputStream inputStream) {
        return null;
    }

    private static void writeTraceLoadInfoToResourceStream(OutputStream outputStream) {
    }
}

