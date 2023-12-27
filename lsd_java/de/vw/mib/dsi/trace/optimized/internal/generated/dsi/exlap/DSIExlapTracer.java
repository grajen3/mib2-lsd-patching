/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.exlap;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.exlap.Service;

public final class DSIExlapTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_SERVICE;
    static /* synthetic */ Class class$org$dsi$ifc$exlap$Service;

    public DSIExlapTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$exlap$Service == null ? (class$org$dsi$ifc$exlap$Service = DSIExlapTracer.class$("org.dsi.ifc.exlap.Service")) : class$org$dsi$ifc$exlap$Service, 1);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceService(printWriter, (Service)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceService(PrintWriter printWriter, Service service) {
        if (service == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(service.id);
        printWriter.print(service.status);
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

