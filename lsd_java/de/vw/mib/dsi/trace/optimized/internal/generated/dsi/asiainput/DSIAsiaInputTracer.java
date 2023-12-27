/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.asiainput;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.asiainput.UserDefinedEntry;
import org.dsi.ifc.asiainput.WordDatabase;

public final class DSIAsiaInputTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_USERDEFINEDENTRY;
    private static final int ID_WORDDATABASE;
    static /* synthetic */ Class class$org$dsi$ifc$asiainput$UserDefinedEntry;
    static /* synthetic */ Class class$org$dsi$ifc$asiainput$WordDatabase;

    public DSIAsiaInputTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$asiainput$UserDefinedEntry == null ? (class$org$dsi$ifc$asiainput$UserDefinedEntry = DSIAsiaInputTracer.class$("org.dsi.ifc.asiainput.UserDefinedEntry")) : class$org$dsi$ifc$asiainput$UserDefinedEntry, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$asiainput$WordDatabase == null ? (class$org$dsi$ifc$asiainput$WordDatabase = DSIAsiaInputTracer.class$("org.dsi.ifc.asiainput.WordDatabase")) : class$org$dsi$ifc$asiainput$WordDatabase, 2);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceUserDefinedEntry(printWriter, (UserDefinedEntry)object);
                break;
            }
            case 2: {
                this.traceWordDatabase(printWriter, (WordDatabase)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceUserDefinedEntry(PrintWriter printWriter, UserDefinedEntry userDefinedEntry) {
        if (userDefinedEntry == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(userDefinedEntry.phrase);
        printWriter.print(userDefinedEntry.spelling);
    }

    private void traceWordDatabase(PrintWriter printWriter, WordDatabase wordDatabase) {
        if (wordDatabase == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(wordDatabase.name);
        printWriter.print(wordDatabase.priority);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

