/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace;

import java.io.PrintWriter;

public abstract class DSITraceService {
    public static final String NULL_DSIOBJECT;
    public static final String EXCEPTION_PREFIX;
    public static final String EXCEPTION_SUFFIX;
    public static final String ERROR_PREFIX;
    public static final String ERROR_SUFFIX;
    public static final String EXCEPTION_NOTEXISTING_DSIMEMBER;
    public static final String ERROR_NOTEXISTING_DSIMEMBER;
    public static final byte FLAG_DSIITEM_INDICATE_OK;
    public static final byte FLAG_DSIITEM_INDICATE_ERROR;
    public static final byte FLAG_DSIITEM_INDICATE_FALLBACKTRACE;
    public static final byte FLAG_OBJECT_INDICATE_NULL;
    public static final byte FLAG_OBJECT_INDICATE_NOTNULL;
    public static final byte FLAG_ARRAY_INDICATE_NULLARRAY;
    public static final int DSITRACESERVICETYPE_DEBUG;
    public static final int DSITRACESERVICETYPE_RELEASE;
    public static final int DSITRACESERVICETYPE_OPTIMIZED;

    public abstract void toTrace(PrintWriter printWriter, Object object) {
    }

    public abstract String getDSITraceServiceInfoString() {
    }

    public abstract int getDSITraceServiceType() {
    }

    public static final void logDebug(String string) {
        if (string != null) {
            System.err.println(string);
        }
    }

    public static final void logWarning(String string) {
        if (string != null) {
            System.out.println(string);
        }
    }

    public static final void logError(String string, Throwable throwable) {
        if (string != null) {
            System.err.println(string);
        }
        if (throwable != null) {
            throwable.printStackTrace(System.err);
        }
    }
}

