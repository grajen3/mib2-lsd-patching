/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.mobilityhorizon;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.mobilityhorizon.ConsumptionInfo;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;
import org.dsi.ifc.mobilityhorizon.ValueUnitPair;

public final class DSIMobilityHorizonTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_CONSUMPTIONINFO;
    private static final int ID_MOBILITYHORIZONLOCATION;
    private static final int ID_VALUEUNITPAIR;
    static /* synthetic */ Class class$org$dsi$ifc$mobilityhorizon$ConsumptionInfo;
    static /* synthetic */ Class class$org$dsi$ifc$mobilityhorizon$MobilityHorizonLocation;
    static /* synthetic */ Class class$org$dsi$ifc$mobilityhorizon$ValueUnitPair;

    public DSIMobilityHorizonTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$mobilityhorizon$ConsumptionInfo == null ? (class$org$dsi$ifc$mobilityhorizon$ConsumptionInfo = DSIMobilityHorizonTracer.class$("org.dsi.ifc.mobilityhorizon.ConsumptionInfo")) : class$org$dsi$ifc$mobilityhorizon$ConsumptionInfo, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$mobilityhorizon$MobilityHorizonLocation == null ? (class$org$dsi$ifc$mobilityhorizon$MobilityHorizonLocation = DSIMobilityHorizonTracer.class$("org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation")) : class$org$dsi$ifc$mobilityhorizon$MobilityHorizonLocation, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$mobilityhorizon$ValueUnitPair == null ? (class$org$dsi$ifc$mobilityhorizon$ValueUnitPair = DSIMobilityHorizonTracer.class$("org.dsi.ifc.mobilityhorizon.ValueUnitPair")) : class$org$dsi$ifc$mobilityhorizon$ValueUnitPair, 3);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceConsumptionInfo(printWriter, (ConsumptionInfo)object);
                break;
            }
            case 2: {
                this.traceMobilityHorizonLocation(printWriter, (MobilityHorizonLocation)object);
                break;
            }
            case 3: {
                this.traceValueUnitPair(printWriter, (ValueUnitPair)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceConsumptionInfo(PrintWriter printWriter, ConsumptionInfo consumptionInfo) {
        if (consumptionInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, consumptionInfo.residualEnergy);
        this.trace(printWriter, consumptionInfo.consumptionMotorway);
        this.trace(printWriter, consumptionInfo.consumptionHighway);
        this.trace(printWriter, consumptionInfo.consumptionCountryRoad);
        this.trace(printWriter, consumptionInfo.consumptionDistrictRoad);
        this.trace(printWriter, consumptionInfo.consumptionLocalRoad);
        this.trace(printWriter, consumptionInfo.consumptionRuralRoad);
        this.trace(printWriter, consumptionInfo.consumptionUnclassifiedRoad);
        if (consumptionInfo.reserved == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = consumptionInfo.reserved.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, consumptionInfo.reserved[i2]);
            }
        }
    }

    private void traceMobilityHorizonLocation(PrintWriter printWriter, MobilityHorizonLocation mobilityHorizonLocation) {
        if (mobilityHorizonLocation == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, mobilityHorizonLocation.location);
        printWriter.print(mobilityHorizonLocation.locationType);
    }

    private void traceValueUnitPair(PrintWriter printWriter, ValueUnitPair valueUnitPair) {
        if (valueUnitPair == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(valueUnitPair.value);
        printWriter.print(valueUnitPair.unit);
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

