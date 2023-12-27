/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.carseat;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.carseat.MassageConfig;
import org.dsi.ifc.carseat.MassageData;
import org.dsi.ifc.carseat.MassageProgs;
import org.dsi.ifc.carseat.RestSeatStatus;
import org.dsi.ifc.carseat.SeatAdjustment;
import org.dsi.ifc.carseat.SeatContent;
import org.dsi.ifc.carseat.SeatPneumaticConfig;
import org.dsi.ifc.carseat.SeatPneumaticContent;
import org.dsi.ifc.carseat.SeatPneumaticViewOptions;
import org.dsi.ifc.carseat.SeatSpecialPosition;
import org.dsi.ifc.carseat.SeatViewOptions;
import org.dsi.ifc.carseat.SeatZoneViewOptions;
import org.dsi.ifc.carseat.SeatmemoryConfig;
import org.dsi.ifc.carseat.SwitcherDataBackForward;
import org.dsi.ifc.carseat.SwitcherDataUpDown;
import org.dsi.ifc.carseat.VisualizationConfig;

public final class DSICarSeatTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_MASSAGECONFIG;
    private static final int ID_MASSAGEDATA;
    private static final int ID_MASSAGEPROGS;
    private static final int ID_RESTSEATSTATUS;
    private static final int ID_SEATADJUSTMENT;
    private static final int ID_SEATCONTENT;
    private static final int ID_SEATPNEUMATICCONFIG;
    private static final int ID_SEATPNEUMATICCONTENT;
    private static final int ID_SEATPNEUMATICVIEWOPTIONS;
    private static final int ID_SEATSPECIALPOSITION;
    private static final int ID_SEATVIEWOPTIONS;
    private static final int ID_SEATZONEVIEWOPTIONS;
    private static final int ID_SEATMEMORYCONFIG;
    private static final int ID_SWITCHERDATABACKFORWARD;
    private static final int ID_SWITCHERDATAUPDOWN;
    private static final int ID_VISUALIZATIONCONFIG;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$MassageConfig;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$MassageData;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$MassageProgs;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$RestSeatStatus;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$SeatAdjustment;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$SeatContent;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$SeatPneumaticConfig;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$SeatPneumaticContent;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$SeatPneumaticViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$SeatSpecialPosition;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$SeatViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$SeatZoneViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$SeatmemoryConfig;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$SwitcherDataBackForward;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$SwitcherDataUpDown;
    static /* synthetic */ Class class$org$dsi$ifc$carseat$VisualizationConfig;

    public DSICarSeatTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carseat$MassageConfig == null ? (class$org$dsi$ifc$carseat$MassageConfig = DSICarSeatTracer.class$("org.dsi.ifc.carseat.MassageConfig")) : class$org$dsi$ifc$carseat$MassageConfig, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carseat$MassageData == null ? (class$org$dsi$ifc$carseat$MassageData = DSICarSeatTracer.class$("org.dsi.ifc.carseat.MassageData")) : class$org$dsi$ifc$carseat$MassageData, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carseat$MassageProgs == null ? (class$org$dsi$ifc$carseat$MassageProgs = DSICarSeatTracer.class$("org.dsi.ifc.carseat.MassageProgs")) : class$org$dsi$ifc$carseat$MassageProgs, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carseat$RestSeatStatus == null ? (class$org$dsi$ifc$carseat$RestSeatStatus = DSICarSeatTracer.class$("org.dsi.ifc.carseat.RestSeatStatus")) : class$org$dsi$ifc$carseat$RestSeatStatus, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carseat$SeatAdjustment == null ? (class$org$dsi$ifc$carseat$SeatAdjustment = DSICarSeatTracer.class$("org.dsi.ifc.carseat.SeatAdjustment")) : class$org$dsi$ifc$carseat$SeatAdjustment, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carseat$SeatContent == null ? (class$org$dsi$ifc$carseat$SeatContent = DSICarSeatTracer.class$("org.dsi.ifc.carseat.SeatContent")) : class$org$dsi$ifc$carseat$SeatContent, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carseat$SeatPneumaticConfig == null ? (class$org$dsi$ifc$carseat$SeatPneumaticConfig = DSICarSeatTracer.class$("org.dsi.ifc.carseat.SeatPneumaticConfig")) : class$org$dsi$ifc$carseat$SeatPneumaticConfig, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carseat$SeatPneumaticContent == null ? (class$org$dsi$ifc$carseat$SeatPneumaticContent = DSICarSeatTracer.class$("org.dsi.ifc.carseat.SeatPneumaticContent")) : class$org$dsi$ifc$carseat$SeatPneumaticContent, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carseat$SeatPneumaticViewOptions == null ? (class$org$dsi$ifc$carseat$SeatPneumaticViewOptions = DSICarSeatTracer.class$("org.dsi.ifc.carseat.SeatPneumaticViewOptions")) : class$org$dsi$ifc$carseat$SeatPneumaticViewOptions, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carseat$SeatSpecialPosition == null ? (class$org$dsi$ifc$carseat$SeatSpecialPosition = DSICarSeatTracer.class$("org.dsi.ifc.carseat.SeatSpecialPosition")) : class$org$dsi$ifc$carseat$SeatSpecialPosition, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carseat$SeatViewOptions == null ? (class$org$dsi$ifc$carseat$SeatViewOptions = DSICarSeatTracer.class$("org.dsi.ifc.carseat.SeatViewOptions")) : class$org$dsi$ifc$carseat$SeatViewOptions, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carseat$SeatZoneViewOptions == null ? (class$org$dsi$ifc$carseat$SeatZoneViewOptions = DSICarSeatTracer.class$("org.dsi.ifc.carseat.SeatZoneViewOptions")) : class$org$dsi$ifc$carseat$SeatZoneViewOptions, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carseat$SeatmemoryConfig == null ? (class$org$dsi$ifc$carseat$SeatmemoryConfig = DSICarSeatTracer.class$("org.dsi.ifc.carseat.SeatmemoryConfig")) : class$org$dsi$ifc$carseat$SeatmemoryConfig, 13);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carseat$SwitcherDataBackForward == null ? (class$org$dsi$ifc$carseat$SwitcherDataBackForward = DSICarSeatTracer.class$("org.dsi.ifc.carseat.SwitcherDataBackForward")) : class$org$dsi$ifc$carseat$SwitcherDataBackForward, 14);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carseat$SwitcherDataUpDown == null ? (class$org$dsi$ifc$carseat$SwitcherDataUpDown = DSICarSeatTracer.class$("org.dsi.ifc.carseat.SwitcherDataUpDown")) : class$org$dsi$ifc$carseat$SwitcherDataUpDown, 15);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carseat$VisualizationConfig == null ? (class$org$dsi$ifc$carseat$VisualizationConfig = DSICarSeatTracer.class$("org.dsi.ifc.carseat.VisualizationConfig")) : class$org$dsi$ifc$carseat$VisualizationConfig, 16);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceMassageConfig(printWriter, (MassageConfig)object);
                break;
            }
            case 2: {
                this.traceMassageData(printWriter, (MassageData)object);
                break;
            }
            case 3: {
                this.traceMassageProgs(printWriter, (MassageProgs)object);
                break;
            }
            case 4: {
                this.traceRestSeatStatus(printWriter, (RestSeatStatus)object);
                break;
            }
            case 5: {
                this.traceSeatAdjustment(printWriter, (SeatAdjustment)object);
                break;
            }
            case 6: {
                this.traceSeatContent(printWriter, (SeatContent)object);
                break;
            }
            case 7: {
                this.traceSeatPneumaticConfig(printWriter, (SeatPneumaticConfig)object);
                break;
            }
            case 8: {
                this.traceSeatPneumaticContent(printWriter, (SeatPneumaticContent)object);
                break;
            }
            case 9: {
                this.traceSeatPneumaticViewOptions(printWriter, (SeatPneumaticViewOptions)object);
                break;
            }
            case 10: {
                this.traceSeatSpecialPosition(printWriter, (SeatSpecialPosition)object);
                break;
            }
            case 11: {
                this.traceSeatViewOptions(printWriter, (SeatViewOptions)object);
                break;
            }
            case 12: {
                this.traceSeatZoneViewOptions(printWriter, (SeatZoneViewOptions)object);
                break;
            }
            case 13: {
                this.traceSeatmemoryConfig(printWriter, (SeatmemoryConfig)object);
                break;
            }
            case 14: {
                this.traceSwitcherDataBackForward(printWriter, (SwitcherDataBackForward)object);
                break;
            }
            case 15: {
                this.traceSwitcherDataUpDown(printWriter, (SwitcherDataUpDown)object);
                break;
            }
            case 16: {
                this.traceVisualizationConfig(printWriter, (VisualizationConfig)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceMassageConfig(PrintWriter printWriter, MassageConfig massageConfig) {
        if (massageConfig == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, massageConfig.programs);
        printWriter.print(massageConfig.intensityRange);
        printWriter.print(massageConfig.speedRange);
    }

    private void traceMassageData(PrintWriter printWriter, MassageData massageData) {
        if (massageData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(massageData.program);
        printWriter.print(massageData.intensity);
        printWriter.print(massageData.speed);
    }

    private void traceMassageProgs(PrintWriter printWriter, MassageProgs massageProgs) {
        if (massageProgs == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(massageProgs.program1Exist);
        printWriter.print(massageProgs.program2Exist);
        printWriter.print(massageProgs.program3Exist);
        printWriter.print(massageProgs.program4Exist);
        printWriter.print(massageProgs.program5Exist);
        printWriter.print(massageProgs.program6Exist);
        printWriter.print(massageProgs.program7Exist);
        printWriter.print(massageProgs.program8Exist);
    }

    private void traceRestSeatStatus(PrintWriter printWriter, RestSeatStatus restSeatStatus) {
        if (restSeatStatus == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(restSeatStatus.displayDown);
        printWriter.print(restSeatStatus.displayRestSeatMoving);
        printWriter.print(restSeatStatus.restSeatPosition);
    }

    private void traceSeatAdjustment(PrintWriter printWriter, SeatAdjustment seatAdjustment) {
        if (seatAdjustment == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(seatAdjustment.position);
        printWriter.print(seatAdjustment.sitzhoehe);
        printWriter.print(seatAdjustment.sitzlaenge);
        printWriter.print(seatAdjustment.lehnenneigung);
        printWriter.print(seatAdjustment.sitzflaechenneigung);
        printWriter.print(seatAdjustment.kopfstuetze);
    }

    private void traceSeatContent(PrintWriter printWriter, SeatContent seatContent) {
        if (seatContent == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(seatContent.content1RL);
        printWriter.print(seatContent.memoryDetail1RL);
        printWriter.print(seatContent.content1RR);
        printWriter.print(seatContent.memoryDetail1RR);
        printWriter.print(seatContent.content2RL);
        printWriter.print(seatContent.memoryDetail2RL);
        printWriter.print(seatContent.content2RR);
        printWriter.print(seatContent.memoryDetail2RR);
    }

    private void traceSeatPneumaticConfig(PrintWriter printWriter, SeatPneumaticConfig seatPneumaticConfig) {
        if (seatPneumaticConfig == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(seatPneumaticConfig.driversideLeft);
        this.trace(printWriter, seatPneumaticConfig.massageConfig1RL);
        this.trace(printWriter, seatPneumaticConfig.massageConfig1RR);
        this.trace(printWriter, seatPneumaticConfig.visualizationConfig1RL);
        this.trace(printWriter, seatPneumaticConfig.visualizationConfig1RR);
    }

    private void traceSeatPneumaticContent(PrintWriter printWriter, SeatPneumaticContent seatPneumaticContent) {
        if (seatPneumaticContent == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(seatPneumaticContent.content1RL);
        printWriter.print(seatPneumaticContent.content1RR);
    }

    private void traceSeatPneumaticViewOptions(PrintWriter printWriter, SeatPneumaticViewOptions seatPneumaticViewOptions) {
        if (seatPneumaticViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, seatPneumaticViewOptions.seatPneumaticCoDriverSettingsFromDriver);
        this.trace(printWriter, seatPneumaticViewOptions.seatPneumaticSetFactoryDefault);
        this.trace(printWriter, seatPneumaticViewOptions.seatPneumaticConfig);
    }

    private void traceSeatSpecialPosition(PrintWriter printWriter, SeatSpecialPosition seatSpecialPosition) {
        if (seatSpecialPosition == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(seatSpecialPosition.position);
        printWriter.print(seatSpecialPosition.seat1RL);
        printWriter.print(seatSpecialPosition.seat1RR);
        printWriter.print(seatSpecialPosition.seat2RL);
        printWriter.print(seatSpecialPosition.seat2RR);
        printWriter.print(seatSpecialPosition.seat3RL);
        printWriter.print(seatSpecialPosition.seat3RR);
    }

    private void traceSeatViewOptions(PrintWriter printWriter, SeatViewOptions seatViewOptions) {
        if (seatViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, seatViewOptions.seatRadioKeyAutomatic);
        this.trace(printWriter, seatViewOptions.seatCoDriverSettingsFromDriver);
        this.trace(printWriter, seatViewOptions.seatCoDriverSettingsFromRear);
        this.trace(printWriter, seatViewOptions.seatEasyEntryFrontLeft);
        this.trace(printWriter, seatViewOptions.seatEasyEntryFrontRight);
        this.trace(printWriter, seatViewOptions.seatEasyEntryRearLeft);
        this.trace(printWriter, seatViewOptions.seatEasyEntryRearRight);
        this.trace(printWriter, seatViewOptions.seatSpecialPosition);
        this.trace(printWriter, seatViewOptions.seatSetFactoryDefault);
        this.trace(printWriter, seatViewOptions.seatmemoryConfig);
        this.trace(printWriter, seatViewOptions.massageConfig1RL);
        this.trace(printWriter, seatViewOptions.massageConfig1RR);
        this.trace(printWriter, seatViewOptions.visualizationConfig1RL);
        this.trace(printWriter, seatViewOptions.visualizationConfig1RR);
        this.trace(printWriter, seatViewOptions.visualizationConfig2RL);
        this.trace(printWriter, seatViewOptions.visualizationConfig2RR);
        this.trace(printWriter, seatViewOptions.massageConfig2RL);
        this.trace(printWriter, seatViewOptions.massageConfig2RR);
        this.trace(printWriter, seatViewOptions.seatSpecialPositionRearCoDriver);
        this.trace(printWriter, seatViewOptions.seatDeleteSpecialPosition);
        this.trace(printWriter, seatViewOptions.seatCoDriverSettingsFromRearActivation);
        this.trace(printWriter, seatViewOptions.seatRestSeatStatus);
        this.trace(printWriter, seatViewOptions.seatMoveRearSeatDisplay);
        this.trace(printWriter, seatViewOptions.seatFoldHeadRestRearDriver);
        this.trace(printWriter, seatViewOptions.seatFoldHeadRestRearCoDriver);
        this.trace(printWriter, seatViewOptions.seatSettings1RL);
        this.trace(printWriter, seatViewOptions.seatSettings1RR);
        this.trace(printWriter, seatViewOptions.seatSettings2RL);
        this.trace(printWriter, seatViewOptions.seatSettings2RR);
        this.trace(printWriter, seatViewOptions.premiumMassageConfig1RL);
        this.trace(printWriter, seatViewOptions.premiumMassageConfig1RR);
        this.trace(printWriter, seatViewOptions.premiumMassageConfig2RL);
        this.trace(printWriter, seatViewOptions.premiumMassageConfig2RR);
    }

    private void traceSeatZoneViewOptions(PrintWriter printWriter, SeatZoneViewOptions seatZoneViewOptions) {
        if (seatZoneViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, seatZoneViewOptions.seatSwitcherUp);
        this.trace(printWriter, seatZoneViewOptions.seatSwitcherDown);
        this.trace(printWriter, seatZoneViewOptions.seatSwitcherBackward);
        this.trace(printWriter, seatZoneViewOptions.seatSwitcherForward);
        this.trace(printWriter, seatZoneViewOptions.seatAdjustment);
        this.trace(printWriter, seatZoneViewOptions.seatStopButton);
        this.trace(printWriter, seatZoneViewOptions.seatMassage);
        this.trace(printWriter, seatZoneViewOptions.seatMassageSwitcher);
        this.trace(printWriter, seatZoneViewOptions.seatPremiumMassage);
        this.trace(printWriter, seatZoneViewOptions.seatPremiumMassageSwitcher);
    }

    private void traceSeatmemoryConfig(PrintWriter printWriter, SeatmemoryConfig seatmemoryConfig) {
        if (seatmemoryConfig == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(seatmemoryConfig.seatmemory1RL);
        printWriter.print(seatmemoryConfig.seatmemory1RR);
        printWriter.print(seatmemoryConfig.seatmemory2RL);
        printWriter.print(seatmemoryConfig.seatmemory2RR);
        printWriter.print(seatmemoryConfig.driversideLeft);
        printWriter.print(seatmemoryConfig.comfortview);
        printWriter.print(seatmemoryConfig.normalPosition);
        printWriter.print(seatmemoryConfig.seatsymmetry);
        printWriter.print(seatmemoryConfig.relaxPosition);
        printWriter.print(seatmemoryConfig.businessPosition);
        printWriter.print(seatmemoryConfig.multiFunctionSwitcher);
    }

    private void traceSwitcherDataBackForward(PrintWriter printWriter, SwitcherDataBackForward switcherDataBackForward) {
        if (switcherDataBackForward == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(switcherDataBackForward.sitzlaenge);
        printWriter.print(switcherDataBackForward.lehnenneigung);
        printWriter.print(switcherDataBackForward.lordosenweite);
        printWriter.print(switcherDataBackForward.sitztiefe);
        printWriter.print(switcherDataBackForward.lehnenkopf);
        printWriter.print(switcherDataBackForward.lehnenwangen);
        printWriter.print(switcherDataBackForward.kopfstuetzenlaenge);
        printWriter.print(switcherDataBackForward.rseAufnahmetiefe);
    }

    private void traceSwitcherDataUpDown(PrintWriter printWriter, SwitcherDataUpDown switcherDataUpDown) {
        if (switcherDataUpDown == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(switcherDataUpDown.sitzhoehe);
        printWriter.print(switcherDataUpDown.kopfstuetzenhoehe);
        printWriter.print(switcherDataUpDown.lordosenhoehe);
        printWriter.print(switcherDataUpDown.gurthoehe);
        printWriter.print(switcherDataUpDown.sitzflaechenwangen);
        printWriter.print(switcherDataUpDown.sitzneigung);
        printWriter.print(switcherDataUpDown.fussstuetzenhoehe);
        printWriter.print(switcherDataUpDown.rseAufnahmehoehe);
        printWriter.print(switcherDataUpDown.fussmattenhoehe);
        printWriter.print(switcherDataUpDown.rseDisplay);
    }

    private void traceVisualizationConfig(PrintWriter printWriter, VisualizationConfig visualizationConfig) {
        if (visualizationConfig == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(visualizationConfig.sitzlaengsverstellung);
        printWriter.print(visualizationConfig.sitzhoehenverstellung);
        printWriter.print(visualizationConfig.sitzneigungsverstellung);
        printWriter.print(visualizationConfig.lehnenneigungsverstellung);
        printWriter.print(visualizationConfig.kopfstuetzenhoehenverstellung);
        printWriter.print(visualizationConfig.lordosenweitenverstellung);
        printWriter.print(visualizationConfig.lordosenhoehenverstellung);
        printWriter.print(visualizationConfig.sitztiefenverstellung);
        printWriter.print(visualizationConfig.lehnenkopfverstellung);
        printWriter.print(visualizationConfig.gurthoehenverstellung);
        printWriter.print(visualizationConfig.lehnenwangenverstellung);
        printWriter.print(visualizationConfig.sitzflaechenwangenverstellung);
        printWriter.print(visualizationConfig.kopfstuetzenlaengsverstellung);
        printWriter.print(visualizationConfig.fussstuetzenhoehe);
        printWriter.print(visualizationConfig.rseAufnahmehoehe);
        printWriter.print(visualizationConfig.rseAufnahmetiefe);
        printWriter.print(visualizationConfig.fussmattenhoehe);
        printWriter.print(visualizationConfig.rseDisplay);
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

