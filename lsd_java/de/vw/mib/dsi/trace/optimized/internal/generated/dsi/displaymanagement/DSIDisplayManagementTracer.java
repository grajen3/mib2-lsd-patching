/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.displaymanagement;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.displaymanagement.DisplayContext;

public final class DSIDisplayManagementTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_DISPLAYCONTEXT;
    static /* synthetic */ Class class$org$dsi$ifc$displaymanagement$DisplayContext;

    public DSIDisplayManagementTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$displaymanagement$DisplayContext == null ? (class$org$dsi$ifc$displaymanagement$DisplayContext = DSIDisplayManagementTracer.class$("org.dsi.ifc.displaymanagement.DisplayContext")) : class$org$dsi$ifc$displaymanagement$DisplayContext, 1);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceDisplayContext(printWriter, (DisplayContext)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceDisplayContext(PrintWriter printWriter, DisplayContext displayContext) {
        if (displayContext == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(displayContext.id);
        if (displayContext.displayableList == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = displayContext.displayableList.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(displayContext.displayableList[i2]);
            }
        }
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

