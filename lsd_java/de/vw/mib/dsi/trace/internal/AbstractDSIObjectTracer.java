/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.internal;

import de.vw.mib.dsi.trace.internal.DSIObjectTracer;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Map;

public abstract class AbstractDSIObjectTracer
implements DSIObjectTracer {
    protected static final String EMPTYSTRING;
    protected static final int ID_DSIOBJECT_UNRESOLVED;
    protected static final String EXCEPTION_PREFIX;
    protected static final String EXCEPTION_SUFFIX;
    protected static final String ERROR_PREFIX;
    protected static final String ERROR_SUFFIX;
    protected static final String NULL_DSIOBJECT;
    protected static final String EXCEPTION_NOTEXISTING_DSIMEMBER;
    protected static final String ERROR_NOTEXISTING_DSIMEMBER;
    protected static final String EXCEPTIONMESSAGE_INVALID_DSI_DATATYPE;
    private final Map mapDatacontainerIDs = new Hashtable();

    protected final void registerDSIDatacontainerID(Class clazz, int n) {
        this.mapDatacontainerIDs.put(clazz, new Integer(n));
    }

    protected final int resolveID(Object object) {
        Integer n = (Integer)this.mapDatacontainerIDs.get(object.getClass());
        return n != null ? n : 0;
    }

    protected final void handleException(PrintWriter printWriter, Exception exception) {
        if (exception instanceof NoSuchFieldException) {
            printWriter.print("<exception:no_such_field>");
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<exception:");
            stringBuffer.append(super.getClass().getName());
            stringBuffer.append(">");
            printWriter.print(stringBuffer.toString());
        }
    }

    protected final void handleError(PrintWriter printWriter, Error error) {
        if (error instanceof NoSuchFieldError) {
            printWriter.print("<error:no_such_field>");
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<error:");
            stringBuffer.append(super.getClass().getName());
            stringBuffer.append(">");
            printWriter.print(stringBuffer.toString());
        }
    }

    protected abstract void trace(PrintWriter printWriter, Object object) {
    }
}

