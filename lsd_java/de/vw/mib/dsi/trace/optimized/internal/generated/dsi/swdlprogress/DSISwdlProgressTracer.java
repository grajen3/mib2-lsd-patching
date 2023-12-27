/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.swdlprogress;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.swdlprogress.DeviceOverviewProgress;
import org.dsi.ifc.swdlprogress.GeneralProgress;

public final class DSISwdlProgressTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_DEVICEOVERVIEWPROGRESS;
    private static final int ID_GENERALPROGRESS;
    static /* synthetic */ Class class$org$dsi$ifc$swdlprogress$DeviceOverviewProgress;
    static /* synthetic */ Class class$org$dsi$ifc$swdlprogress$GeneralProgress;

    public DSISwdlProgressTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$swdlprogress$DeviceOverviewProgress == null ? (class$org$dsi$ifc$swdlprogress$DeviceOverviewProgress = DSISwdlProgressTracer.class$("org.dsi.ifc.swdlprogress.DeviceOverviewProgress")) : class$org$dsi$ifc$swdlprogress$DeviceOverviewProgress, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$swdlprogress$GeneralProgress == null ? (class$org$dsi$ifc$swdlprogress$GeneralProgress = DSISwdlProgressTracer.class$("org.dsi.ifc.swdlprogress.GeneralProgress")) : class$org$dsi$ifc$swdlprogress$GeneralProgress, 2);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceDeviceOverviewProgress(printWriter, (DeviceOverviewProgress)object);
                break;
            }
            case 2: {
                this.traceGeneralProgress(printWriter, (GeneralProgress)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceDeviceOverviewProgress(PrintWriter printWriter, DeviceOverviewProgress deviceOverviewProgress) {
        if (deviceOverviewProgress == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(deviceOverviewProgress.fileName);
        printWriter.print(deviceOverviewProgress.value);
        printWriter.print(deviceOverviewProgress.type);
    }

    private void traceGeneralProgress(PrintWriter printWriter, GeneralProgress generalProgress) {
        if (generalProgress == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(generalProgress.currentStage);
        printWriter.print(generalProgress.maxStage);
        printWriter.print(generalProgress.finishedDevicesWithoutError);
        printWriter.print(generalProgress.updatingDevices);
        printWriter.print(generalProgress.unavailableDevices);
        printWriter.print(generalProgress.finishedDevicesWithError);
        printWriter.print(generalProgress.activeDevices);
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

