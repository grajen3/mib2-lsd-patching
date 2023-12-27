/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.asiatrafficinfomenu;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.asiatrafficinfomenu.Interrupt;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformationDetails;
import org.dsi.ifc.asiatrafficinfomenu.TrafficMessage;
import org.dsi.ifc.asiatrafficinfomenu.TunerData;

public final class DSIAsiaTrafficInfoMenuTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_INTERRUPT;
    private static final int ID_RESOURCEINFORMATION;
    private static final int ID_TRAFFICINFORMATION;
    private static final int ID_TRAFFICINFORMATIONDETAILS;
    private static final int ID_TRAFFICMESSAGE;
    private static final int ID_TUNERDATA;
    static /* synthetic */ Class class$org$dsi$ifc$asiatrafficinfomenu$Interrupt;
    static /* synthetic */ Class class$org$dsi$ifc$asiatrafficinfomenu$ResourceInformation;
    static /* synthetic */ Class class$org$dsi$ifc$asiatrafficinfomenu$TrafficInformation;
    static /* synthetic */ Class class$org$dsi$ifc$asiatrafficinfomenu$TrafficInformationDetails;
    static /* synthetic */ Class class$org$dsi$ifc$asiatrafficinfomenu$TrafficMessage;
    static /* synthetic */ Class class$org$dsi$ifc$asiatrafficinfomenu$TunerData;

    public DSIAsiaTrafficInfoMenuTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$asiatrafficinfomenu$Interrupt == null ? (class$org$dsi$ifc$asiatrafficinfomenu$Interrupt = DSIAsiaTrafficInfoMenuTracer.class$("org.dsi.ifc.asiatrafficinfomenu.Interrupt")) : class$org$dsi$ifc$asiatrafficinfomenu$Interrupt, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$asiatrafficinfomenu$ResourceInformation == null ? (class$org$dsi$ifc$asiatrafficinfomenu$ResourceInformation = DSIAsiaTrafficInfoMenuTracer.class$("org.dsi.ifc.asiatrafficinfomenu.ResourceInformation")) : class$org$dsi$ifc$asiatrafficinfomenu$ResourceInformation, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$asiatrafficinfomenu$TrafficInformation == null ? (class$org$dsi$ifc$asiatrafficinfomenu$TrafficInformation = DSIAsiaTrafficInfoMenuTracer.class$("org.dsi.ifc.asiatrafficinfomenu.TrafficInformation")) : class$org$dsi$ifc$asiatrafficinfomenu$TrafficInformation, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$asiatrafficinfomenu$TrafficInformationDetails == null ? (class$org$dsi$ifc$asiatrafficinfomenu$TrafficInformationDetails = DSIAsiaTrafficInfoMenuTracer.class$("org.dsi.ifc.asiatrafficinfomenu.TrafficInformationDetails")) : class$org$dsi$ifc$asiatrafficinfomenu$TrafficInformationDetails, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$asiatrafficinfomenu$TrafficMessage == null ? (class$org$dsi$ifc$asiatrafficinfomenu$TrafficMessage = DSIAsiaTrafficInfoMenuTracer.class$("org.dsi.ifc.asiatrafficinfomenu.TrafficMessage")) : class$org$dsi$ifc$asiatrafficinfomenu$TrafficMessage, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$asiatrafficinfomenu$TunerData == null ? (class$org$dsi$ifc$asiatrafficinfomenu$TunerData = DSIAsiaTrafficInfoMenuTracer.class$("org.dsi.ifc.asiatrafficinfomenu.TunerData")) : class$org$dsi$ifc$asiatrafficinfomenu$TunerData, 6);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceInterrupt(printWriter, (Interrupt)object);
                break;
            }
            case 2: {
                this.traceResourceInformation(printWriter, (ResourceInformation)object);
                break;
            }
            case 3: {
                this.traceTrafficInformation(printWriter, (TrafficInformation)object);
                break;
            }
            case 4: {
                this.traceTrafficInformationDetails(printWriter, (TrafficInformationDetails)object);
                break;
            }
            case 5: {
                this.traceTrafficMessage(printWriter, (TrafficMessage)object);
                break;
            }
            case 6: {
                this.traceTunerData(printWriter, (TunerData)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceInterrupt(PrintWriter printWriter, Interrupt interrupt) {
        if (interrupt == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(interrupt.interruptId);
        printWriter.print(interrupt.interruptType);
        if (interrupt.contentID == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = interrupt.contentID.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(interrupt.contentID[i2]);
            }
        }
    }

    private void traceResourceInformation(PrintWriter printWriter, ResourceInformation resourceInformation) {
        if (resourceInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, resourceInformation.resourceLocator);
        printWriter.print(resourceInformation.phoneticString);
    }

    private void traceTrafficInformation(PrintWriter printWriter, TrafficInformation trafficInformation) {
        if (trafficInformation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(trafficInformation.trafficType);
        if (trafficInformation.trafficMessages == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = trafficInformation.trafficMessages.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, trafficInformation.trafficMessages[i2]);
            }
        }
    }

    private void traceTrafficInformationDetails(PrintWriter printWriter, TrafficInformationDetails trafficInformationDetails) {
        if (trafficInformationDetails == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(trafficInformationDetails.trafficType);
        printWriter.print(trafficInformationDetails.contentID);
    }

    private void traceTrafficMessage(PrintWriter printWriter, TrafficMessage trafficMessage) {
        if (trafficMessage == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(trafficMessage.trafficMessageID);
        printWriter.print(trafficMessage.isValid);
        if (trafficMessage.detailContentIDs == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = trafficMessage.detailContentIDs.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(trafficMessage.detailContentIDs[i2]);
            }
        }
        printWriter.print(trafficMessage.value);
        this.trace(printWriter, trafficMessage.date);
        printWriter.print(trafficMessage.contentID);
    }

    private void traceTunerData(PrintWriter printWriter, TunerData tunerData) {
        if (tunerData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tunerData.stationName);
        printWriter.print(tunerData.frequency);
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

