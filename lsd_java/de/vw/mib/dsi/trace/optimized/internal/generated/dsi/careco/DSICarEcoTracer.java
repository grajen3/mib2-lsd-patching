/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.careco;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.careco.BCmEConfiguration;
import org.dsi.ifc.careco.BCmEConsumerList;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA0;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA1;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA0;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA1;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA2;
import org.dsi.ifc.careco.BCmECurrentRange;
import org.dsi.ifc.careco.BCmEEnergyFlowComfort;
import org.dsi.ifc.careco.BCmEListUpdateInfo;
import org.dsi.ifc.careco.BCmERangeGainTotal;
import org.dsi.ifc.careco.BCmETransmittableElements;
import org.dsi.ifc.careco.BCmEViewOptions;
import org.dsi.ifc.careco.EAViewOptions;
import org.dsi.ifc.careco.RangeDataConfiguration;
import org.dsi.ifc.careco.RangeDataResidualEnergy;
import org.dsi.ifc.careco.RangeDataViewOptions;
import org.dsi.ifc.careco.StartStopListUpdateInfo;
import org.dsi.ifc.careco.StartStopProhibitList;
import org.dsi.ifc.careco.StartStopRestartList;
import org.dsi.ifc.careco.StartStopRestartProhibitList;
import org.dsi.ifc.careco.StartStopViewOptions;

public final class DSICarEcoTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_BCMECONFIGURATION;
    private static final int ID_BCMECONSUMERLIST;
    private static final int ID_BCMECONSUMERLISTCONSUMPTIONRA0;
    private static final int ID_BCMECONSUMERLISTCONSUMPTIONRA1;
    private static final int ID_BCMECONSUMERLISTRANGERA0;
    private static final int ID_BCMECONSUMERLISTRANGERA1;
    private static final int ID_BCMECONSUMERLISTRANGERA2;
    private static final int ID_BCMECURRENTRANGE;
    private static final int ID_BCMEENERGYFLOWCOMFORT;
    private static final int ID_BCMELISTUPDATEINFO;
    private static final int ID_BCMERANGEGAINTOTAL;
    private static final int ID_BCMETRANSMITTABLEELEMENTS;
    private static final int ID_BCMEVIEWOPTIONS;
    private static final int ID_EAVIEWOPTIONS;
    private static final int ID_RANGEDATACONFIGURATION;
    private static final int ID_RANGEDATARESIDUALENERGY;
    private static final int ID_RANGEDATAVIEWOPTIONS;
    private static final int ID_STARTSTOPLISTUPDATEINFO;
    private static final int ID_STARTSTOPPROHIBITLIST;
    private static final int ID_STARTSTOPRESTARTLIST;
    private static final int ID_STARTSTOPRESTARTPROHIBITLIST;
    private static final int ID_STARTSTOPVIEWOPTIONS;
    static /* synthetic */ Class class$org$dsi$ifc$careco$BCmEConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$careco$BCmEConsumerList;
    static /* synthetic */ Class class$org$dsi$ifc$careco$BCmEConsumerListConsumptionRA0;
    static /* synthetic */ Class class$org$dsi$ifc$careco$BCmEConsumerListConsumptionRA1;
    static /* synthetic */ Class class$org$dsi$ifc$careco$BCmEConsumerListRangeRA0;
    static /* synthetic */ Class class$org$dsi$ifc$careco$BCmEConsumerListRangeRA1;
    static /* synthetic */ Class class$org$dsi$ifc$careco$BCmEConsumerListRangeRA2;
    static /* synthetic */ Class class$org$dsi$ifc$careco$BCmECurrentRange;
    static /* synthetic */ Class class$org$dsi$ifc$careco$BCmEEnergyFlowComfort;
    static /* synthetic */ Class class$org$dsi$ifc$careco$BCmEListUpdateInfo;
    static /* synthetic */ Class class$org$dsi$ifc$careco$BCmERangeGainTotal;
    static /* synthetic */ Class class$org$dsi$ifc$careco$BCmETransmittableElements;
    static /* synthetic */ Class class$org$dsi$ifc$careco$BCmEViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$careco$EAViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$careco$RangeDataConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$careco$RangeDataResidualEnergy;
    static /* synthetic */ Class class$org$dsi$ifc$careco$RangeDataViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$careco$StartStopListUpdateInfo;
    static /* synthetic */ Class class$org$dsi$ifc$careco$StartStopProhibitList;
    static /* synthetic */ Class class$org$dsi$ifc$careco$StartStopRestartList;
    static /* synthetic */ Class class$org$dsi$ifc$careco$StartStopRestartProhibitList;
    static /* synthetic */ Class class$org$dsi$ifc$careco$StartStopViewOptions;

    public DSICarEcoTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$BCmEConfiguration == null ? (class$org$dsi$ifc$careco$BCmEConfiguration = DSICarEcoTracer.class$("org.dsi.ifc.careco.BCmEConfiguration")) : class$org$dsi$ifc$careco$BCmEConfiguration, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$BCmEConsumerList == null ? (class$org$dsi$ifc$careco$BCmEConsumerList = DSICarEcoTracer.class$("org.dsi.ifc.careco.BCmEConsumerList")) : class$org$dsi$ifc$careco$BCmEConsumerList, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$BCmEConsumerListConsumptionRA0 == null ? (class$org$dsi$ifc$careco$BCmEConsumerListConsumptionRA0 = DSICarEcoTracer.class$("org.dsi.ifc.careco.BCmEConsumerListConsumptionRA0")) : class$org$dsi$ifc$careco$BCmEConsumerListConsumptionRA0, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$BCmEConsumerListConsumptionRA1 == null ? (class$org$dsi$ifc$careco$BCmEConsumerListConsumptionRA1 = DSICarEcoTracer.class$("org.dsi.ifc.careco.BCmEConsumerListConsumptionRA1")) : class$org$dsi$ifc$careco$BCmEConsumerListConsumptionRA1, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$BCmEConsumerListRangeRA0 == null ? (class$org$dsi$ifc$careco$BCmEConsumerListRangeRA0 = DSICarEcoTracer.class$("org.dsi.ifc.careco.BCmEConsumerListRangeRA0")) : class$org$dsi$ifc$careco$BCmEConsumerListRangeRA0, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$BCmEConsumerListRangeRA1 == null ? (class$org$dsi$ifc$careco$BCmEConsumerListRangeRA1 = DSICarEcoTracer.class$("org.dsi.ifc.careco.BCmEConsumerListRangeRA1")) : class$org$dsi$ifc$careco$BCmEConsumerListRangeRA1, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$BCmEConsumerListRangeRA2 == null ? (class$org$dsi$ifc$careco$BCmEConsumerListRangeRA2 = DSICarEcoTracer.class$("org.dsi.ifc.careco.BCmEConsumerListRangeRA2")) : class$org$dsi$ifc$careco$BCmEConsumerListRangeRA2, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$BCmECurrentRange == null ? (class$org$dsi$ifc$careco$BCmECurrentRange = DSICarEcoTracer.class$("org.dsi.ifc.careco.BCmECurrentRange")) : class$org$dsi$ifc$careco$BCmECurrentRange, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$BCmEEnergyFlowComfort == null ? (class$org$dsi$ifc$careco$BCmEEnergyFlowComfort = DSICarEcoTracer.class$("org.dsi.ifc.careco.BCmEEnergyFlowComfort")) : class$org$dsi$ifc$careco$BCmEEnergyFlowComfort, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$BCmEListUpdateInfo == null ? (class$org$dsi$ifc$careco$BCmEListUpdateInfo = DSICarEcoTracer.class$("org.dsi.ifc.careco.BCmEListUpdateInfo")) : class$org$dsi$ifc$careco$BCmEListUpdateInfo, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$BCmERangeGainTotal == null ? (class$org$dsi$ifc$careco$BCmERangeGainTotal = DSICarEcoTracer.class$("org.dsi.ifc.careco.BCmERangeGainTotal")) : class$org$dsi$ifc$careco$BCmERangeGainTotal, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$BCmETransmittableElements == null ? (class$org$dsi$ifc$careco$BCmETransmittableElements = DSICarEcoTracer.class$("org.dsi.ifc.careco.BCmETransmittableElements")) : class$org$dsi$ifc$careco$BCmETransmittableElements, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$BCmEViewOptions == null ? (class$org$dsi$ifc$careco$BCmEViewOptions = DSICarEcoTracer.class$("org.dsi.ifc.careco.BCmEViewOptions")) : class$org$dsi$ifc$careco$BCmEViewOptions, 13);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$EAViewOptions == null ? (class$org$dsi$ifc$careco$EAViewOptions = DSICarEcoTracer.class$("org.dsi.ifc.careco.EAViewOptions")) : class$org$dsi$ifc$careco$EAViewOptions, 14);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$RangeDataConfiguration == null ? (class$org$dsi$ifc$careco$RangeDataConfiguration = DSICarEcoTracer.class$("org.dsi.ifc.careco.RangeDataConfiguration")) : class$org$dsi$ifc$careco$RangeDataConfiguration, 15);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$RangeDataResidualEnergy == null ? (class$org$dsi$ifc$careco$RangeDataResidualEnergy = DSICarEcoTracer.class$("org.dsi.ifc.careco.RangeDataResidualEnergy")) : class$org$dsi$ifc$careco$RangeDataResidualEnergy, 16);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$RangeDataViewOptions == null ? (class$org$dsi$ifc$careco$RangeDataViewOptions = DSICarEcoTracer.class$("org.dsi.ifc.careco.RangeDataViewOptions")) : class$org$dsi$ifc$careco$RangeDataViewOptions, 17);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$StartStopListUpdateInfo == null ? (class$org$dsi$ifc$careco$StartStopListUpdateInfo = DSICarEcoTracer.class$("org.dsi.ifc.careco.StartStopListUpdateInfo")) : class$org$dsi$ifc$careco$StartStopListUpdateInfo, 18);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$StartStopProhibitList == null ? (class$org$dsi$ifc$careco$StartStopProhibitList = DSICarEcoTracer.class$("org.dsi.ifc.careco.StartStopProhibitList")) : class$org$dsi$ifc$careco$StartStopProhibitList, 19);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$StartStopRestartList == null ? (class$org$dsi$ifc$careco$StartStopRestartList = DSICarEcoTracer.class$("org.dsi.ifc.careco.StartStopRestartList")) : class$org$dsi$ifc$careco$StartStopRestartList, 20);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$StartStopRestartProhibitList == null ? (class$org$dsi$ifc$careco$StartStopRestartProhibitList = DSICarEcoTracer.class$("org.dsi.ifc.careco.StartStopRestartProhibitList")) : class$org$dsi$ifc$careco$StartStopRestartProhibitList, 21);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$careco$StartStopViewOptions == null ? (class$org$dsi$ifc$careco$StartStopViewOptions = DSICarEcoTracer.class$("org.dsi.ifc.careco.StartStopViewOptions")) : class$org$dsi$ifc$careco$StartStopViewOptions, 22);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceBCmEConfiguration(printWriter, (BCmEConfiguration)object);
                break;
            }
            case 2: {
                this.traceBCmEConsumerList(printWriter, (BCmEConsumerList)object);
                break;
            }
            case 3: {
                this.traceBCmEConsumerListConsumptionRA0(printWriter, (BCmEConsumerListConsumptionRA0)object);
                break;
            }
            case 4: {
                this.traceBCmEConsumerListConsumptionRA1(printWriter, (BCmEConsumerListConsumptionRA1)object);
                break;
            }
            case 5: {
                this.traceBCmEConsumerListRangeRA0(printWriter, (BCmEConsumerListRangeRA0)object);
                break;
            }
            case 6: {
                this.traceBCmEConsumerListRangeRA1(printWriter, (BCmEConsumerListRangeRA1)object);
                break;
            }
            case 7: {
                this.traceBCmEConsumerListRangeRA2(printWriter, (BCmEConsumerListRangeRA2)object);
                break;
            }
            case 8: {
                this.traceBCmECurrentRange(printWriter, (BCmECurrentRange)object);
                break;
            }
            case 9: {
                this.traceBCmEEnergyFlowComfort(printWriter, (BCmEEnergyFlowComfort)object);
                break;
            }
            case 10: {
                this.traceBCmEListUpdateInfo(printWriter, (BCmEListUpdateInfo)object);
                break;
            }
            case 11: {
                this.traceBCmERangeGainTotal(printWriter, (BCmERangeGainTotal)object);
                break;
            }
            case 12: {
                this.traceBCmETransmittableElements(printWriter, (BCmETransmittableElements)object);
                break;
            }
            case 13: {
                this.traceBCmEViewOptions(printWriter, (BCmEViewOptions)object);
                break;
            }
            case 14: {
                this.traceEAViewOptions(printWriter, (EAViewOptions)object);
                break;
            }
            case 15: {
                this.traceRangeDataConfiguration(printWriter, (RangeDataConfiguration)object);
                break;
            }
            case 16: {
                this.traceRangeDataResidualEnergy(printWriter, (RangeDataResidualEnergy)object);
                break;
            }
            case 17: {
                this.traceRangeDataViewOptions(printWriter, (RangeDataViewOptions)object);
                break;
            }
            case 18: {
                this.traceStartStopListUpdateInfo(printWriter, (StartStopListUpdateInfo)object);
                break;
            }
            case 19: {
                this.traceStartStopProhibitList(printWriter, (StartStopProhibitList)object);
                break;
            }
            case 20: {
                this.traceStartStopRestartList(printWriter, (StartStopRestartList)object);
                break;
            }
            case 21: {
                this.traceStartStopRestartProhibitList(printWriter, (StartStopRestartProhibitList)object);
                break;
            }
            case 22: {
                this.traceStartStopViewOptions(printWriter, (StartStopViewOptions)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceBCmEConfiguration(PrintWriter printWriter, BCmEConfiguration bCmEConfiguration) {
        if (bCmEConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCmEConfiguration.primaryEngineType);
        printWriter.print(bCmEConfiguration.secondaryEngineType);
        this.trace(printWriter, bCmEConfiguration.consumerListTransmittableElements);
        this.trace(printWriter, bCmEConfiguration.consumerListConsumptionTransmittableElements);
        this.trace(printWriter, bCmEConfiguration.consumerListRangeTransmittableElements);
    }

    private void traceBCmEConsumerList(PrintWriter printWriter, BCmEConsumerList bCmEConsumerList) {
        if (bCmEConsumerList == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCmEConsumerList.listPosition);
        printWriter.print(bCmEConsumerList.consumer);
    }

    private void traceBCmEConsumerListConsumptionRA0(PrintWriter printWriter, BCmEConsumerListConsumptionRA0 bCmEConsumerListConsumptionRA0) {
        if (bCmEConsumerListConsumptionRA0 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCmEConsumerListConsumptionRA0.pos);
        printWriter.print(bCmEConsumerListConsumptionRA0.consumer);
        printWriter.print(bCmEConsumerListConsumptionRA0.consumptionRelative);
    }

    private void traceBCmEConsumerListConsumptionRA1(PrintWriter printWriter, BCmEConsumerListConsumptionRA1 bCmEConsumerListConsumptionRA1) {
        if (bCmEConsumerListConsumptionRA1 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCmEConsumerListConsumptionRA1.pos);
        printWriter.print(bCmEConsumerListConsumptionRA1.consumer);
    }

    private void traceBCmEConsumerListRangeRA0(PrintWriter printWriter, BCmEConsumerListRangeRA0 bCmEConsumerListRangeRA0) {
        if (bCmEConsumerListRangeRA0 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCmEConsumerListRangeRA0.pos);
        printWriter.print(bCmEConsumerListRangeRA0.consumer);
        printWriter.print(bCmEConsumerListRangeRA0.rangeGainPrimary);
        printWriter.print(bCmEConsumerListRangeRA0.rangeGainSecondary);
        printWriter.print(bCmEConsumerListRangeRA0.rangeUnit);
    }

    private void traceBCmEConsumerListRangeRA1(PrintWriter printWriter, BCmEConsumerListRangeRA1 bCmEConsumerListRangeRA1) {
        if (bCmEConsumerListRangeRA1 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCmEConsumerListRangeRA1.pos);
        printWriter.print(bCmEConsumerListRangeRA1.consumer);
        printWriter.print(bCmEConsumerListRangeRA1.rangeGainPrimary);
        printWriter.print(bCmEConsumerListRangeRA1.rangeUnit);
    }

    private void traceBCmEConsumerListRangeRA2(PrintWriter printWriter, BCmEConsumerListRangeRA2 bCmEConsumerListRangeRA2) {
        if (bCmEConsumerListRangeRA2 == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCmEConsumerListRangeRA2.pos);
        printWriter.print(bCmEConsumerListRangeRA2.consumer);
        printWriter.print(bCmEConsumerListRangeRA2.rangeGainSecondary);
        printWriter.print(bCmEConsumerListRangeRA2.rangeUnit);
    }

    private void traceBCmECurrentRange(PrintWriter printWriter, BCmECurrentRange bCmECurrentRange) {
        if (bCmECurrentRange == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCmECurrentRange.rangeGainValuePrimary);
        printWriter.print(bCmECurrentRange.rangeGainValueSecondary);
        printWriter.print(bCmECurrentRange.rangeGainValueTotal);
        printWriter.print(bCmECurrentRange.rangeValuePrimary);
        printWriter.print(bCmECurrentRange.rangeValueSecondary);
        printWriter.print(bCmECurrentRange.rangeValueTotal);
        printWriter.print(bCmECurrentRange.rangeUnit);
    }

    private void traceBCmEEnergyFlowComfort(PrintWriter printWriter, BCmEEnergyFlowComfort bCmEEnergyFlowComfort) {
        if (bCmEEnergyFlowComfort == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCmEEnergyFlowComfort.climateControlUnitHeater);
        printWriter.print(bCmEEnergyFlowComfort.airConditionCompressor);
    }

    private void traceBCmEListUpdateInfo(PrintWriter printWriter, BCmEListUpdateInfo bCmEListUpdateInfo) {
        if (bCmEListUpdateInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCmEListUpdateInfo.arrayContent);
        printWriter.print(bCmEListUpdateInfo.startElement);
        printWriter.print(bCmEListUpdateInfo.numOfElements);
        printWriter.print(bCmEListUpdateInfo.transactionID);
        printWriter.print(bCmEListUpdateInfo.recordContent);
        printWriter.print(bCmEListUpdateInfo.asgID);
    }

    private void traceBCmERangeGainTotal(PrintWriter printWriter, BCmERangeGainTotal bCmERangeGainTotal) {
        if (bCmERangeGainTotal == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCmERangeGainTotal.rangeGainTotalValue);
        printWriter.print(bCmERangeGainTotal.rangeUnit);
    }

    private void traceBCmETransmittableElements(PrintWriter printWriter, BCmETransmittableElements bCmETransmittableElements) {
        if (bCmETransmittableElements == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(bCmETransmittableElements.ra0);
        printWriter.print(bCmETransmittableElements.ra1);
        printWriter.print(bCmETransmittableElements.ra2);
        printWriter.print(bCmETransmittableElements.raF);
    }

    private void traceBCmEViewOptions(PrintWriter printWriter, BCmEViewOptions bCmEViewOptions) {
        if (bCmEViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, bCmEViewOptions.consumerList);
        this.trace(printWriter, bCmEViewOptions.consumption);
        this.trace(printWriter, bCmEViewOptions.liveTip);
        this.trace(printWriter, bCmEViewOptions.energyFlowComfort);
        this.trace(printWriter, bCmEViewOptions.rangeGainTotal);
        this.trace(printWriter, bCmEViewOptions.consumerListConsumption);
        this.trace(printWriter, bCmEViewOptions.consumerListRange);
        this.trace(printWriter, bCmEViewOptions.currentRange);
        this.trace(printWriter, bCmEViewOptions.bcmeSetFactoryDefault);
        this.trace(printWriter, bCmEViewOptions.configuration);
        this.trace(printWriter, bCmEViewOptions.currentRangeSOC);
        this.trace(printWriter, bCmEViewOptions.catalogueRange);
    }

    private void traceEAViewOptions(PrintWriter printWriter, EAViewOptions eAViewOptions) {
        if (eAViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, eAViewOptions.system);
        this.trace(printWriter, eAViewOptions.pedalJerk);
        this.trace(printWriter, eAViewOptions.setFactoryDefault);
        this.trace(printWriter, eAViewOptions.freeWheeling);
        this.trace(printWriter, eAViewOptions.startStop);
    }

    private void traceRangeDataConfiguration(PrintWriter printWriter, RangeDataConfiguration rangeDataConfiguration) {
        if (rangeDataConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rangeDataConfiguration.primaryEngineType);
        printWriter.print(rangeDataConfiguration.secondaryEngineType);
    }

    private void traceRangeDataResidualEnergy(PrintWriter printWriter, RangeDataResidualEnergy rangeDataResidualEnergy) {
        if (rangeDataResidualEnergy == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(rangeDataResidualEnergy.state);
        printWriter.print(rangeDataResidualEnergy.value);
        printWriter.print(rangeDataResidualEnergy.unit);
    }

    private void traceRangeDataViewOptions(PrintWriter printWriter, RangeDataViewOptions rangeDataViewOptions) {
        if (rangeDataViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, rangeDataViewOptions.rdSetFactoryDefault);
        this.trace(printWriter, rangeDataViewOptions.rdConsumptionMotorway1);
        this.trace(printWriter, rangeDataViewOptions.rdConsumptionMotorway2);
        this.trace(printWriter, rangeDataViewOptions.rdConsumptionHighway1);
        this.trace(printWriter, rangeDataViewOptions.rdConsumptionHighway2);
        this.trace(printWriter, rangeDataViewOptions.rdConsumptionCountryRoad1);
        this.trace(printWriter, rangeDataViewOptions.rdConsumptionCountryRoad2);
        this.trace(printWriter, rangeDataViewOptions.rdConsumptionDistrictRoad1);
        this.trace(printWriter, rangeDataViewOptions.rdConsumptionDistrictRoad2);
        this.trace(printWriter, rangeDataViewOptions.rdConsumptionLocalRoad1);
        this.trace(printWriter, rangeDataViewOptions.rdConsumptionLocalRoad2);
        this.trace(printWriter, rangeDataViewOptions.rdConsumptionRuralRoad1);
        this.trace(printWriter, rangeDataViewOptions.rdConsumptionRuralRoad2);
        this.trace(printWriter, rangeDataViewOptions.rdConsumptionUnclassifiedRoad1);
        this.trace(printWriter, rangeDataViewOptions.rdConsumptionUnclassifiedRoad2);
        this.trace(printWriter, rangeDataViewOptions.rdMaxRange1);
        this.trace(printWriter, rangeDataViewOptions.rdMaxRange2);
        this.trace(printWriter, rangeDataViewOptions.rdResidualEnergy1);
        this.trace(printWriter, rangeDataViewOptions.rdResidualEnergy2);
        this.trace(printWriter, rangeDataViewOptions.configuration);
    }

    private void traceStartStopListUpdateInfo(PrintWriter printWriter, StartStopListUpdateInfo startStopListUpdateInfo) {
        if (startStopListUpdateInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(startStopListUpdateInfo.arrayContent);
        printWriter.print(startStopListUpdateInfo.startElement);
        printWriter.print(startStopListUpdateInfo.numOfElements);
        printWriter.print(startStopListUpdateInfo.transactionID);
    }

    private void traceStartStopProhibitList(PrintWriter printWriter, StartStopProhibitList startStopProhibitList) {
        if (startStopProhibitList == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(startStopProhibitList.listPosition);
        printWriter.print(startStopProhibitList.reason);
    }

    private void traceStartStopRestartList(PrintWriter printWriter, StartStopRestartList startStopRestartList) {
        if (startStopRestartList == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(startStopRestartList.listPosition);
        printWriter.print(startStopRestartList.reason);
    }

    private void traceStartStopRestartProhibitList(PrintWriter printWriter, StartStopRestartProhibitList startStopRestartProhibitList) {
        if (startStopRestartProhibitList == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(startStopRestartProhibitList.listPosition);
        printWriter.print(startStopRestartProhibitList.reason);
    }

    private void traceStartStopViewOptions(PrintWriter printWriter, StartStopViewOptions startStopViewOptions) {
        if (startStopViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, startStopViewOptions.state);
        this.trace(printWriter, startStopViewOptions.startStopProhibitReasonList);
        this.trace(printWriter, startStopViewOptions.startStopRestartReasonList);
        this.trace(printWriter, startStopViewOptions.startStopRestartProhibitReasonList);
        this.trace(printWriter, startStopViewOptions.collectedReasons);
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

