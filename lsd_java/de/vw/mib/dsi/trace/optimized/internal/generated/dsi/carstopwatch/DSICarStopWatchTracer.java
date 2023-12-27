/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.carstopwatch;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.carstopwatch.StopWatchTime;
import org.dsi.ifc.carstopwatch.StopWatchViewOptions;

public final class DSICarStopWatchTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_STOPWATCHTIME;
    private static final int ID_STOPWATCHVIEWOPTIONS;
    static /* synthetic */ Class class$org$dsi$ifc$carstopwatch$StopWatchTime;
    static /* synthetic */ Class class$org$dsi$ifc$carstopwatch$StopWatchViewOptions;

    public DSICarStopWatchTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carstopwatch$StopWatchTime == null ? (class$org$dsi$ifc$carstopwatch$StopWatchTime = DSICarStopWatchTracer.class$("org.dsi.ifc.carstopwatch.StopWatchTime")) : class$org$dsi$ifc$carstopwatch$StopWatchTime, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carstopwatch$StopWatchViewOptions == null ? (class$org$dsi$ifc$carstopwatch$StopWatchViewOptions = DSICarStopWatchTracer.class$("org.dsi.ifc.carstopwatch.StopWatchViewOptions")) : class$org$dsi$ifc$carstopwatch$StopWatchViewOptions, 2);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceStopWatchTime(printWriter, (StopWatchTime)object);
                break;
            }
            case 2: {
                this.traceStopWatchViewOptions(printWriter, (StopWatchViewOptions)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceStopWatchTime(PrintWriter printWriter, StopWatchTime stopWatchTime) {
        if (stopWatchTime == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(stopWatchTime.hours);
        printWriter.print(stopWatchTime.minutes);
        printWriter.print(stopWatchTime.seconds);
        printWriter.print(stopWatchTime.hundredthSeconds);
    }

    private void traceStopWatchViewOptions(PrintWriter printWriter, StopWatchViewOptions stopWatchViewOptions) {
        if (stopWatchViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, stopWatchViewOptions.state);
        this.trace(printWriter, stopWatchViewOptions.control);
        this.trace(printWriter, stopWatchViewOptions.currentLapNumber);
        this.trace(printWriter, stopWatchViewOptions.totalTime);
        this.trace(printWriter, stopWatchViewOptions.lastSplitTime);
        this.trace(printWriter, stopWatchViewOptions.currentLapTime);
        this.trace(printWriter, stopWatchViewOptions.lastLapTime);
        this.trace(printWriter, stopWatchViewOptions.fastestLapTime);
        this.trace(printWriter, stopWatchViewOptions.lapRating);
        this.trace(printWriter, stopWatchViewOptions.lapProgress);
        this.trace(printWriter, stopWatchViewOptions.lapGPSTrigger);
        this.trace(printWriter, stopWatchViewOptions.slowestLapTime);
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

