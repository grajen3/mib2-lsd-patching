/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.trafficregulation;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;
import org.dsi.ifc.trafficregulation.SpeedLimitInfo;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;
import org.dsi.ifc.trafficregulation.TrafficSignInformationOnRoute;

public final class DSITrafficRegulationTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_ROADCLASSSPEEDINFO;
    private static final int ID_SPEEDLIMITINFO;
    private static final int ID_TRAFFICSIGNINFORMATION;
    private static final int ID_TRAFFICSIGNINFORMATIONONROUTE;
    static /* synthetic */ Class class$org$dsi$ifc$trafficregulation$RoadClassSpeedInfo;
    static /* synthetic */ Class class$org$dsi$ifc$trafficregulation$SpeedLimitInfo;
    static /* synthetic */ Class class$org$dsi$ifc$trafficregulation$TrafficSignInformation;
    static /* synthetic */ Class class$org$dsi$ifc$trafficregulation$TrafficSignInformationOnRoute;

    public DSITrafficRegulationTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$trafficregulation$RoadClassSpeedInfo == null ? (class$org$dsi$ifc$trafficregulation$RoadClassSpeedInfo = DSITrafficRegulationTracer.class$("org.dsi.ifc.trafficregulation.RoadClassSpeedInfo")) : class$org$dsi$ifc$trafficregulation$RoadClassSpeedInfo, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$trafficregulation$SpeedLimitInfo == null ? (class$org$dsi$ifc$trafficregulation$SpeedLimitInfo = DSITrafficRegulationTracer.class$("org.dsi.ifc.trafficregulation.SpeedLimitInfo")) : class$org$dsi$ifc$trafficregulation$SpeedLimitInfo, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$trafficregulation$TrafficSignInformation == null ? (class$org$dsi$ifc$trafficregulation$TrafficSignInformation = DSITrafficRegulationTracer.class$("org.dsi.ifc.trafficregulation.TrafficSignInformation")) : class$org$dsi$ifc$trafficregulation$TrafficSignInformation, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$trafficregulation$TrafficSignInformationOnRoute == null ? (class$org$dsi$ifc$trafficregulation$TrafficSignInformationOnRoute = DSITrafficRegulationTracer.class$("org.dsi.ifc.trafficregulation.TrafficSignInformationOnRoute")) : class$org$dsi$ifc$trafficregulation$TrafficSignInformationOnRoute, 4);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceRoadClassSpeedInfo(printWriter, (RoadClassSpeedInfo)object);
                break;
            }
            case 2: {
                this.traceSpeedLimitInfo(printWriter, (SpeedLimitInfo)object);
                break;
            }
            case 3: {
                this.traceTrafficSignInformation(printWriter, (TrafficSignInformation)object);
                break;
            }
            case 4: {
                this.traceTrafficSignInformationOnRoute(printWriter, (TrafficSignInformationOnRoute)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceRoadClassSpeedInfo(PrintWriter printWriter, RoadClassSpeedInfo roadClassSpeedInfo) {
        if (roadClassSpeedInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(roadClassSpeedInfo.countryAbbreviation);
        printWriter.print(roadClassSpeedInfo.roadClassIconReference);
        printWriter.print(roadClassSpeedInfo.roadClassType);
        printWriter.print(roadClassSpeedInfo.roadSignIconReference);
        printWriter.print(roadClassSpeedInfo.speedLimit);
        printWriter.print(roadClassSpeedInfo.speedUnit);
        printWriter.print(roadClassSpeedInfo.variant);
    }

    private void traceSpeedLimitInfo(PrintWriter printWriter, SpeedLimitInfo speedLimitInfo) {
        if (speedLimitInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(speedLimitInfo.speedLimit);
        printWriter.print(speedLimitInfo.speedLimitType);
        printWriter.print(speedLimitInfo.speedUnit);
    }

    private void traceTrafficSignInformation(PrintWriter printWriter, TrafficSignInformation trafficSignInformation) {
        if (trafficSignInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(trafficSignInformation.highestPrioritySign);
        printWriter.print(trafficSignInformation.secondHighestPrioritySign);
        printWriter.print(trafficSignInformation.informationText);
        printWriter.print(trafficSignInformation.trafficSignOne);
        printWriter.print(trafficSignInformation.trafficSignTwo);
        printWriter.print(trafficSignInformation.trafficSignThree);
        printWriter.print(trafficSignInformation.warningSignOne);
        printWriter.print(trafficSignInformation.warningSignTwo);
        printWriter.print(trafficSignInformation.warningSignThree);
        printWriter.print(trafficSignInformation.additionalSignOne);
        printWriter.print(trafficSignInformation.additionalSignTwo);
        printWriter.print(trafficSignInformation.additionalSignThree);
        printWriter.print(trafficSignInformation.variant);
        this.trace(printWriter, trafficSignInformation.highestPrioritySpeedLimit);
        printWriter.print(trafficSignInformation.trafficSignOneSource);
        printWriter.print(trafficSignInformation.trafficSignTwoSource);
        printWriter.print(trafficSignInformation.trafficSignThreeSource);
    }

    private void traceTrafficSignInformationOnRoute(PrintWriter printWriter, TrafficSignInformationOnRoute trafficSignInformationOnRoute) {
        if (trafficSignInformationOnRoute == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, trafficSignInformationOnRoute.info);
        printWriter.print(trafficSignInformationOnRoute.distance);
        printWriter.print(trafficSignInformationOnRoute.remainingTime);
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

