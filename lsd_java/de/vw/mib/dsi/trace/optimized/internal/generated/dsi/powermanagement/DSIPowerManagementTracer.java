/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.powermanagement;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.powermanagement.ClampSignal;

public final class DSIPowerManagementTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_CLAMPSIGNAL;
    static /* synthetic */ Class class$org$dsi$ifc$powermanagement$ClampSignal;

    public DSIPowerManagementTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$powermanagement$ClampSignal == null ? (class$org$dsi$ifc$powermanagement$ClampSignal = DSIPowerManagementTracer.class$("org.dsi.ifc.powermanagement.ClampSignal")) : class$org$dsi$ifc$powermanagement$ClampSignal, 1);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceClampSignal(printWriter, (ClampSignal)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceClampSignal(PrintWriter printWriter, ClampSignal clampSignal) {
        if (clampSignal == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(clampSignal.clampS);
        printWriter.print(clampSignal.clamp15);
        printWriter.print(clampSignal.clampX);
        printWriter.print(clampSignal.clamp50);
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

