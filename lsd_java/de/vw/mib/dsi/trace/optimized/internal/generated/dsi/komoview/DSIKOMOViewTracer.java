/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.komoview;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.komoview.ManeuverElement;
import org.dsi.ifc.komoview.RouteInfoElement;
import org.dsi.ifc.komoview.TrafficInfo;

public final class DSIKOMOViewTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_MANEUVERELEMENT;
    private static final int ID_ROUTEINFOELEMENT;
    private static final int ID_TRAFFICINFO;
    static /* synthetic */ Class class$org$dsi$ifc$komoview$ManeuverElement;
    static /* synthetic */ Class class$org$dsi$ifc$komoview$RouteInfoElement;
    static /* synthetic */ Class class$org$dsi$ifc$komoview$TrafficInfo;

    public DSIKOMOViewTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$komoview$ManeuverElement == null ? (class$org$dsi$ifc$komoview$ManeuverElement = DSIKOMOViewTracer.class$("org.dsi.ifc.komoview.ManeuverElement")) : class$org$dsi$ifc$komoview$ManeuverElement, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$komoview$RouteInfoElement == null ? (class$org$dsi$ifc$komoview$RouteInfoElement = DSIKOMOViewTracer.class$("org.dsi.ifc.komoview.RouteInfoElement")) : class$org$dsi$ifc$komoview$RouteInfoElement, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$komoview$TrafficInfo == null ? (class$org$dsi$ifc$komoview$TrafficInfo = DSIKOMOViewTracer.class$("org.dsi.ifc.komoview.TrafficInfo")) : class$org$dsi$ifc$komoview$TrafficInfo, 3);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceManeuverElement(printWriter, (ManeuverElement)object);
                break;
            }
            case 2: {
                this.traceRouteInfoElement(printWriter, (RouteInfoElement)object);
                break;
            }
            case 3: {
                this.traceTrafficInfo(printWriter, (TrafficInfo)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceManeuverElement(PrintWriter printWriter, ManeuverElement maneuverElement) {
        if (maneuverElement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(maneuverElement.element);
        printWriter.print(maneuverElement.direction);
        printWriter.print(maneuverElement.attribute);
    }

    private void traceRouteInfoElement(PrintWriter printWriter, RouteInfoElement routeInfoElement) {
        int n;
        int n2;
        if (routeInfoElement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(routeInfoElement.distanceToElement);
        printWriter.print(routeInfoElement.estimatedTimeToElement);
        printWriter.print(routeInfoElement.routeInfoElementType);
        if (routeInfoElement.elementIconIDs == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = routeInfoElement.elementIconIDs.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(routeInfoElement.elementIconIDs[n]);
            }
        }
        printWriter.print(routeInfoElement.prio1EventText);
        printWriter.print(routeInfoElement.streetIconText);
        printWriter.print(routeInfoElement.streetIconID);
        printWriter.print(routeInfoElement.exitNumber);
        printWriter.print(routeInfoElement.turnToStreet);
        if (routeInfoElement.pOIElementNames == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = routeInfoElement.pOIElementNames.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(routeInfoElement.pOIElementNames[n]);
            }
        }
        if (routeInfoElement.maneuverDescriptor == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = routeInfoElement.maneuverDescriptor.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, routeInfoElement.maneuverDescriptor[n]);
            }
        }
        this.trace(printWriter, routeInfoElement.trafficInfo);
        printWriter.print(routeInfoElement.destinationIndex);
        printWriter.print(routeInfoElement.signPostInfo);
        printWriter.print(routeInfoElement.distanceToManeuver);
        printWriter.print(routeInfoElement.estimatedTimeToManeuver);
        printWriter.print(routeInfoElement.streetCardinalDirection);
        printWriter.print(routeInfoElement.exitIconId);
    }

    private void traceTrafficInfo(PrintWriter printWriter, TrafficInfo trafficInfo) {
        if (trafficInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(trafficInfo.trafficOffset);
        printWriter.print(trafficInfo.trafficOffsetAffix);
        printWriter.print(trafficInfo.affixPlacementBefore);
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

