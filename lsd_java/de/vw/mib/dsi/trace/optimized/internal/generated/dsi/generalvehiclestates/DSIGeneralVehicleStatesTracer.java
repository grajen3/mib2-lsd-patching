/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.generalvehiclestates;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.generalvehiclestates.AirbagData;
import org.dsi.ifc.generalvehiclestates.ESPData;
import org.dsi.ifc.generalvehiclestates.TLOInfoElement;
import org.dsi.ifc.generalvehiclestates.TLOViewOptions;
import org.dsi.ifc.generalvehiclestates.TankInfo;

public final class DSIGeneralVehicleStatesTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_AIRBAGDATA;
    private static final int ID_ESPDATA;
    private static final int ID_TLOINFOELEMENT;
    private static final int ID_TLOVIEWOPTIONS;
    private static final int ID_TANKINFO;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$AirbagData;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$ESPData;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$TLOInfoElement;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$TLOViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$generalvehiclestates$TankInfo;

    public DSIGeneralVehicleStatesTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$generalvehiclestates$AirbagData == null ? (class$org$dsi$ifc$generalvehiclestates$AirbagData = DSIGeneralVehicleStatesTracer.class$("org.dsi.ifc.generalvehiclestates.AirbagData")) : class$org$dsi$ifc$generalvehiclestates$AirbagData, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$generalvehiclestates$ESPData == null ? (class$org$dsi$ifc$generalvehiclestates$ESPData = DSIGeneralVehicleStatesTracer.class$("org.dsi.ifc.generalvehiclestates.ESPData")) : class$org$dsi$ifc$generalvehiclestates$ESPData, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$generalvehiclestates$TLOInfoElement == null ? (class$org$dsi$ifc$generalvehiclestates$TLOInfoElement = DSIGeneralVehicleStatesTracer.class$("org.dsi.ifc.generalvehiclestates.TLOInfoElement")) : class$org$dsi$ifc$generalvehiclestates$TLOInfoElement, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$generalvehiclestates$TLOViewOptions == null ? (class$org$dsi$ifc$generalvehiclestates$TLOViewOptions = DSIGeneralVehicleStatesTracer.class$("org.dsi.ifc.generalvehiclestates.TLOViewOptions")) : class$org$dsi$ifc$generalvehiclestates$TLOViewOptions, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$generalvehiclestates$TankInfo == null ? (class$org$dsi$ifc$generalvehiclestates$TankInfo = DSIGeneralVehicleStatesTracer.class$("org.dsi.ifc.generalvehiclestates.TankInfo")) : class$org$dsi$ifc$generalvehiclestates$TankInfo, 5);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceAirbagData(printWriter, (AirbagData)object);
                break;
            }
            case 2: {
                this.traceESPData(printWriter, (ESPData)object);
                break;
            }
            case 3: {
                this.traceTLOInfoElement(printWriter, (TLOInfoElement)object);
                break;
            }
            case 4: {
                this.traceTLOViewOptions(printWriter, (TLOViewOptions)object);
                break;
            }
            case 5: {
                this.traceTankInfo(printWriter, (TankInfo)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceAirbagData(PrintWriter printWriter, AirbagData airbagData) {
        if (airbagData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(airbagData.crashIntensity);
        printWriter.print(airbagData.diagnosis);
        printWriter.print(airbagData.actuatorTest);
    }

    private void traceESPData(PrintWriter printWriter, ESPData eSPData) {
        if (eSPData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(eSPData.velocity);
        printWriter.print(eSPData.standstill);
    }

    private void traceTLOInfoElement(PrintWriter printWriter, TLOInfoElement tLOInfoElement) {
        if (tLOInfoElement == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tLOInfoElement.counter);
        printWriter.print(tLOInfoElement.time1CF);
        printWriter.print(tLOInfoElement.time1Pred);
        printWriter.print(tLOInfoElement.time1State);
        printWriter.print(tLOInfoElement.time2CF);
        printWriter.print(tLOInfoElement.time2Pred);
        printWriter.print(tLOInfoElement.time2State);
        printWriter.print(tLOInfoElement.psdSegId);
        printWriter.print(tLOInfoElement.psdSegOffset);
    }

    private void traceTLOViewOptions(PrintWriter printWriter, TLOViewOptions tLOViewOptions) {
        if (tLOViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, tLOViewOptions.hmiState);
        this.trace(printWriter, tLOViewOptions.startStopInfo);
        this.trace(printWriter, tLOViewOptions.infoList);
    }

    private void traceTankInfo(PrintWriter printWriter, TankInfo tankInfo) {
        if (tankInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(tankInfo.fuelWarning);
        printWriter.print(tankInfo.fuelLevelState);
        printWriter.print(tankInfo.fuelWarningSecondary);
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

