/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.predictivenavigation;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.predictivenavigation.LikelyDestination;

public final class DSIPredictiveNavigationTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_LIKELYDESTINATION;
    static /* synthetic */ Class class$org$dsi$ifc$predictivenavigation$LikelyDestination;

    public DSIPredictiveNavigationTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$predictivenavigation$LikelyDestination == null ? (class$org$dsi$ifc$predictivenavigation$LikelyDestination = DSIPredictiveNavigationTracer.class$("org.dsi.ifc.predictivenavigation.LikelyDestination")) : class$org$dsi$ifc$predictivenavigation$LikelyDestination, 1);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceLikelyDestination(printWriter, (LikelyDestination)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceLikelyDestination(PrintWriter printWriter, LikelyDestination likelyDestination) {
        if (likelyDestination == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(likelyDestination.calculationState);
        printWriter.print(likelyDestination.calculationProgress);
        printWriter.print(likelyDestination.likelihood);
        printWriter.print(likelyDestination.distance);
        printWriter.print(likelyDestination.remainingTravelTime);
        printWriter.print(likelyDestination.timeDelay);
        printWriter.print(likelyDestination.routeColor);
        printWriter.print(likelyDestination.routeColorIconId);
        this.trace(printWriter, likelyDestination.destination);
        this.trace(printWriter, likelyDestination.segmentId);
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

