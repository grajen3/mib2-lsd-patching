/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.swdlselection;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.swdlselection.LameClient;

public final class DSISwdlSelectionTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_LAMECLIENT;
    static /* synthetic */ Class class$org$dsi$ifc$swdlselection$LameClient;

    public DSISwdlSelectionTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$swdlselection$LameClient == null ? (class$org$dsi$ifc$swdlselection$LameClient = DSISwdlSelectionTracer.class$("org.dsi.ifc.swdlselection.LameClient")) : class$org$dsi$ifc$swdlselection$LameClient, 1);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceLameClient(printWriter, (LameClient)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceLameClient(PrintWriter printWriter, LameClient lameClient) {
        if (lameClient == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(lameClient.deviceId);
        printWriter.print(lameClient.mostId);
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

