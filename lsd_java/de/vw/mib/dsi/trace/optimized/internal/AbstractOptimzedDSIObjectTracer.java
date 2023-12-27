/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal;

import de.vw.mib.dsi.trace.internal.AbstractDSIObjectTracer;
import de.vw.mib.dsi.trace.optimized.internal.DSITraceServiceOptimizedFactory;
import java.io.PrintWriter;

public abstract class AbstractOptimzedDSIObjectTracer
extends AbstractDSIObjectTracer {
    public static final byte FLAG_OBJECT_INDICATE_NULL;
    public static final byte FLAG_OBJECT_INDICATE_NOTNULL;
    public static final byte FLAG_ARRAY_INDICATE_NULLARRAY;
    public static final byte FLAG_DSIITEM_INDICATE_OK;
    public static final byte FLAG_DSIITEM_INDICATE_ERROR;

    @Override
    protected void trace(PrintWriter printWriter, Object object) {
        DSITraceServiceOptimizedFactory.get().toTrace(printWriter, object);
    }

    protected void traceJavaString(PrintWriter printWriter, String string) {
        if (string == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(string);
    }

    protected void traceJavaPrimitive(PrintWriter printWriter, boolean bl) {
        printWriter.print(0);
        printWriter.print(bl);
    }

    protected void traceJavaPrimitive(PrintWriter printWriter, byte by) {
        printWriter.print(0);
        printWriter.print(by);
    }

    protected void traceJavaPrimitive(PrintWriter printWriter, char c2) {
        printWriter.print(0);
        printWriter.print(c2);
    }

    protected void traceJavaPrimitive(PrintWriter printWriter, short s) {
        printWriter.print(0);
        printWriter.print(s);
    }

    protected void traceJavaPrimitive(PrintWriter printWriter, int n) {
        printWriter.print(0);
        printWriter.print(n);
    }

    protected void traceJavaPrimitive(PrintWriter printWriter, long l) {
        printWriter.print(0);
        printWriter.print(l);
    }

    protected void traceJavaPrimitive(PrintWriter printWriter, float f2) {
        printWriter.print(0);
        printWriter.print(f2);
    }

    protected void traceJavaPrimitive(PrintWriter printWriter, double d2) {
        printWriter.print(0);
        printWriter.print(d2);
    }
}

