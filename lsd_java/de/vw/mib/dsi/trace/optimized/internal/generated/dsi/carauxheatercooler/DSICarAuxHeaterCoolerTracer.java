/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.carauxheatercooler;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerConfiguration;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerErrorReason;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerMode;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerViewOptions;

public final class DSICarAuxHeaterCoolerTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_AUXHEATERCOOLERCONFIGURATION;
    private static final int ID_AUXHEATERCOOLERERRORREASON;
    private static final int ID_AUXHEATERCOOLEREXTENDEDCONDITIONING;
    private static final int ID_AUXHEATERCOOLERMODE;
    private static final int ID_AUXHEATERCOOLERTIMER;
    private static final int ID_AUXHEATERCOOLERVIEWOPTIONS;
    static /* synthetic */ Class class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerErrorReason;
    static /* synthetic */ Class class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerExtendedConditioning;
    static /* synthetic */ Class class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerMode;
    static /* synthetic */ Class class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerTimer;
    static /* synthetic */ Class class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerViewOptions;

    public DSICarAuxHeaterCoolerTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerConfiguration == null ? (class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerConfiguration = DSICarAuxHeaterCoolerTracer.class$("org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerConfiguration")) : class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerConfiguration, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerErrorReason == null ? (class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerErrorReason = DSICarAuxHeaterCoolerTracer.class$("org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerErrorReason")) : class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerErrorReason, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerExtendedConditioning == null ? (class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerExtendedConditioning = DSICarAuxHeaterCoolerTracer.class$("org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning")) : class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerExtendedConditioning, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerMode == null ? (class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerMode = DSICarAuxHeaterCoolerTracer.class$("org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerMode")) : class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerMode, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerTimer == null ? (class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerTimer = DSICarAuxHeaterCoolerTracer.class$("org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer")) : class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerTimer, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerViewOptions == null ? (class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerViewOptions = DSICarAuxHeaterCoolerTracer.class$("org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerViewOptions")) : class$org$dsi$ifc$carauxheatercooler$AuxHeaterCoolerViewOptions, 6);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceAuxHeaterCoolerConfiguration(printWriter, (AuxHeaterCoolerConfiguration)object);
                break;
            }
            case 2: {
                this.traceAuxHeaterCoolerErrorReason(printWriter, (AuxHeaterCoolerErrorReason)object);
                break;
            }
            case 3: {
                this.traceAuxHeaterCoolerExtendedConditioning(printWriter, (AuxHeaterCoolerExtendedConditioning)object);
                break;
            }
            case 4: {
                this.traceAuxHeaterCoolerMode(printWriter, (AuxHeaterCoolerMode)object);
                break;
            }
            case 5: {
                this.traceAuxHeaterCoolerTimer(printWriter, (AuxHeaterCoolerTimer)object);
                break;
            }
            case 6: {
                this.traceAuxHeaterCoolerViewOptions(printWriter, (AuxHeaterCoolerViewOptions)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceAuxHeaterCoolerConfiguration(PrintWriter printWriter, AuxHeaterCoolerConfiguration auxHeaterCoolerConfiguration) {
        if (auxHeaterCoolerConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(auxHeaterCoolerConfiguration.heating);
        printWriter.print(auxHeaterCoolerConfiguration.ventilation);
        this.trace(printWriter, auxHeaterCoolerConfiguration.extendedConditioning);
    }

    private void traceAuxHeaterCoolerErrorReason(PrintWriter printWriter, AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
        if (auxHeaterCoolerErrorReason == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(auxHeaterCoolerErrorReason.batteryLow);
        printWriter.print(auxHeaterCoolerErrorReason.fuelLow);
        printWriter.print(auxHeaterCoolerErrorReason.heaterDefect);
        printWriter.print(auxHeaterCoolerErrorReason.maxOperationTime);
    }

    private void traceAuxHeaterCoolerExtendedConditioning(PrintWriter printWriter, AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning) {
        if (auxHeaterCoolerExtendedConditioning == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(auxHeaterCoolerExtendedConditioning.z1rl);
        printWriter.print(auxHeaterCoolerExtendedConditioning.z1rr);
        printWriter.print(auxHeaterCoolerExtendedConditioning.z2rl);
        printWriter.print(auxHeaterCoolerExtendedConditioning.z2rr);
    }

    private void traceAuxHeaterCoolerMode(PrintWriter printWriter, AuxHeaterCoolerMode auxHeaterCoolerMode) {
        if (auxHeaterCoolerMode == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(auxHeaterCoolerMode.mode);
        printWriter.print(auxHeaterCoolerMode.state);
        printWriter.print(auxHeaterCoolerMode.reason);
    }

    private void traceAuxHeaterCoolerTimer(PrintWriter printWriter, AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        if (auxHeaterCoolerTimer == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(auxHeaterCoolerTimer.hour);
        printWriter.print(auxHeaterCoolerTimer.minute);
        printWriter.print(auxHeaterCoolerTimer.second);
        printWriter.print(auxHeaterCoolerTimer.year);
        printWriter.print(auxHeaterCoolerTimer.month);
        printWriter.print(auxHeaterCoolerTimer.day);
        printWriter.print(auxHeaterCoolerTimer.dateMode);
    }

    private void traceAuxHeaterCoolerViewOptions(PrintWriter printWriter, AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions) {
        if (auxHeaterCoolerViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, auxHeaterCoolerViewOptions.auxHeaterCoolerState);
        this.trace(printWriter, auxHeaterCoolerViewOptions.auxHeaterCoolerOnOff);
        this.trace(printWriter, auxHeaterCoolerViewOptions.auxHeaterCoolerRemainingTime);
        this.trace(printWriter, auxHeaterCoolerViewOptions.auxHeaterCoolerRunningTime);
        this.trace(printWriter, auxHeaterCoolerViewOptions.auxHeaterCoolerMode);
        this.trace(printWriter, auxHeaterCoolerViewOptions.auxHeaterCoolerDefaultStartMode);
        this.trace(printWriter, auxHeaterCoolerViewOptions.auxHeaterCoolerEngineHeater);
        this.trace(printWriter, auxHeaterCoolerViewOptions.auxHeaterCoolerTimerStatus);
        this.trace(printWriter, auxHeaterCoolerViewOptions.auxHeaterCoolerTimer1);
        this.trace(printWriter, auxHeaterCoolerViewOptions.auxHeaterCoolerTimer2);
        this.trace(printWriter, auxHeaterCoolerViewOptions.auxHeaterCoolerTimer3);
        this.trace(printWriter, auxHeaterCoolerViewOptions.auxHeaterSetFactoryDefault);
        this.trace(printWriter, auxHeaterCoolerViewOptions.auxHeaterCoolerErrorReason);
        this.trace(printWriter, auxHeaterCoolerViewOptions.auxHeaterCoolerCurrentHeaterState);
        printWriter.print(auxHeaterCoolerViewOptions.auxHeaterCoolerTimerMode);
        this.trace(printWriter, auxHeaterCoolerViewOptions.auxHeaterCoolerPopup);
        this.trace(printWriter, auxHeaterCoolerViewOptions.auxHeaterCoolerExtendedConditioning);
        this.trace(printWriter, auxHeaterCoolerViewOptions.auxHeaterCoolerWindowHeating);
        this.trace(printWriter, auxHeaterCoolerViewOptions.auxHeaterCoolerUnlockClimating);
        this.trace(printWriter, auxHeaterCoolerViewOptions.auxHeaterCoolerTargetTemperature);
        this.trace(printWriter, auxHeaterCoolerViewOptions.auxHeaterCoolerAirQuality);
        this.trace(printWriter, auxHeaterCoolerViewOptions.configuration);
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

