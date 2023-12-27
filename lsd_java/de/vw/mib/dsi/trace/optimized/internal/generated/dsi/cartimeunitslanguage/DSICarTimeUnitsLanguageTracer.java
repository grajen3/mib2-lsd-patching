/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.cartimeunitslanguage;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.cartimeunitslanguage.ClockConfig;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockDayLightSavingData;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSources;
import org.dsi.ifc.cartimeunitslanguage.ClockSummerTimeData;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.cartimeunitslanguage.UTCOffset;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterConfiguration;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterSupportedConsumptionUnits;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterSupportedSkins;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;

public final class DSICarTimeUnitsLanguageTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_CLOCKCONFIG;
    private static final int ID_CLOCKDATE;
    private static final int ID_CLOCKDAYLIGHTSAVINGDATA;
    private static final int ID_CLOCKGPSSYNCDATA;
    private static final int ID_CLOCKSOURCES;
    private static final int ID_CLOCKSUMMERTIMEDATA;
    private static final int ID_CLOCKTIME;
    private static final int ID_CLOCKVIEWOPTIONS;
    private static final int ID_UTCOFFSET;
    private static final int ID_UNITMASTERCONFIGURATION;
    private static final int ID_UNITMASTERSUPPORTEDCONSUMPTIONUNITS;
    private static final int ID_UNITMASTERSUPPORTEDSKINS;
    private static final int ID_UNITMASTERVIEWOPTIONS;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$ClockConfig;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$ClockDate;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$ClockDayLightSavingData;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$ClockGPSSyncData;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$ClockSources;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$ClockSummerTimeData;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$ClockTime;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$ClockViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$UTCOffset;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$UnitmasterConfiguration;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$UnitmasterSupportedConsumptionUnits;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$UnitmasterSupportedSkins;
    static /* synthetic */ Class class$org$dsi$ifc$cartimeunitslanguage$UnitmasterViewOptions;

    public DSICarTimeUnitsLanguageTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cartimeunitslanguage$ClockConfig == null ? (class$org$dsi$ifc$cartimeunitslanguage$ClockConfig = DSICarTimeUnitsLanguageTracer.class$("org.dsi.ifc.cartimeunitslanguage.ClockConfig")) : class$org$dsi$ifc$cartimeunitslanguage$ClockConfig, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cartimeunitslanguage$ClockDate == null ? (class$org$dsi$ifc$cartimeunitslanguage$ClockDate = DSICarTimeUnitsLanguageTracer.class$("org.dsi.ifc.cartimeunitslanguage.ClockDate")) : class$org$dsi$ifc$cartimeunitslanguage$ClockDate, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cartimeunitslanguage$ClockDayLightSavingData == null ? (class$org$dsi$ifc$cartimeunitslanguage$ClockDayLightSavingData = DSICarTimeUnitsLanguageTracer.class$("org.dsi.ifc.cartimeunitslanguage.ClockDayLightSavingData")) : class$org$dsi$ifc$cartimeunitslanguage$ClockDayLightSavingData, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cartimeunitslanguage$ClockGPSSyncData == null ? (class$org$dsi$ifc$cartimeunitslanguage$ClockGPSSyncData = DSICarTimeUnitsLanguageTracer.class$("org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData")) : class$org$dsi$ifc$cartimeunitslanguage$ClockGPSSyncData, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cartimeunitslanguage$ClockSources == null ? (class$org$dsi$ifc$cartimeunitslanguage$ClockSources = DSICarTimeUnitsLanguageTracer.class$("org.dsi.ifc.cartimeunitslanguage.ClockSources")) : class$org$dsi$ifc$cartimeunitslanguage$ClockSources, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cartimeunitslanguage$ClockSummerTimeData == null ? (class$org$dsi$ifc$cartimeunitslanguage$ClockSummerTimeData = DSICarTimeUnitsLanguageTracer.class$("org.dsi.ifc.cartimeunitslanguage.ClockSummerTimeData")) : class$org$dsi$ifc$cartimeunitslanguage$ClockSummerTimeData, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cartimeunitslanguage$ClockTime == null ? (class$org$dsi$ifc$cartimeunitslanguage$ClockTime = DSICarTimeUnitsLanguageTracer.class$("org.dsi.ifc.cartimeunitslanguage.ClockTime")) : class$org$dsi$ifc$cartimeunitslanguage$ClockTime, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cartimeunitslanguage$ClockViewOptions == null ? (class$org$dsi$ifc$cartimeunitslanguage$ClockViewOptions = DSICarTimeUnitsLanguageTracer.class$("org.dsi.ifc.cartimeunitslanguage.ClockViewOptions")) : class$org$dsi$ifc$cartimeunitslanguage$ClockViewOptions, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cartimeunitslanguage$UTCOffset == null ? (class$org$dsi$ifc$cartimeunitslanguage$UTCOffset = DSICarTimeUnitsLanguageTracer.class$("org.dsi.ifc.cartimeunitslanguage.UTCOffset")) : class$org$dsi$ifc$cartimeunitslanguage$UTCOffset, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cartimeunitslanguage$UnitmasterConfiguration == null ? (class$org$dsi$ifc$cartimeunitslanguage$UnitmasterConfiguration = DSICarTimeUnitsLanguageTracer.class$("org.dsi.ifc.cartimeunitslanguage.UnitmasterConfiguration")) : class$org$dsi$ifc$cartimeunitslanguage$UnitmasterConfiguration, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cartimeunitslanguage$UnitmasterSupportedConsumptionUnits == null ? (class$org$dsi$ifc$cartimeunitslanguage$UnitmasterSupportedConsumptionUnits = DSICarTimeUnitsLanguageTracer.class$("org.dsi.ifc.cartimeunitslanguage.UnitmasterSupportedConsumptionUnits")) : class$org$dsi$ifc$cartimeunitslanguage$UnitmasterSupportedConsumptionUnits, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cartimeunitslanguage$UnitmasterSupportedSkins == null ? (class$org$dsi$ifc$cartimeunitslanguage$UnitmasterSupportedSkins = DSICarTimeUnitsLanguageTracer.class$("org.dsi.ifc.cartimeunitslanguage.UnitmasterSupportedSkins")) : class$org$dsi$ifc$cartimeunitslanguage$UnitmasterSupportedSkins, 12);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$cartimeunitslanguage$UnitmasterViewOptions == null ? (class$org$dsi$ifc$cartimeunitslanguage$UnitmasterViewOptions = DSICarTimeUnitsLanguageTracer.class$("org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions")) : class$org$dsi$ifc$cartimeunitslanguage$UnitmasterViewOptions, 13);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceClockConfig(printWriter, (ClockConfig)object);
                break;
            }
            case 2: {
                this.traceClockDate(printWriter, (ClockDate)object);
                break;
            }
            case 3: {
                this.traceClockDayLightSavingData(printWriter, (ClockDayLightSavingData)object);
                break;
            }
            case 4: {
                this.traceClockGPSSyncData(printWriter, (ClockGPSSyncData)object);
                break;
            }
            case 5: {
                this.traceClockSources(printWriter, (ClockSources)object);
                break;
            }
            case 6: {
                this.traceClockSummerTimeData(printWriter, (ClockSummerTimeData)object);
                break;
            }
            case 7: {
                this.traceClockTime(printWriter, (ClockTime)object);
                break;
            }
            case 8: {
                this.traceClockViewOptions(printWriter, (ClockViewOptions)object);
                break;
            }
            case 9: {
                this.traceUTCOffset(printWriter, (UTCOffset)object);
                break;
            }
            case 10: {
                this.traceUnitmasterConfiguration(printWriter, (UnitmasterConfiguration)object);
                break;
            }
            case 11: {
                this.traceUnitmasterSupportedConsumptionUnits(printWriter, (UnitmasterSupportedConsumptionUnits)object);
                break;
            }
            case 12: {
                this.traceUnitmasterSupportedSkins(printWriter, (UnitmasterSupportedSkins)object);
                break;
            }
            case 13: {
                this.traceUnitmasterViewOptions(printWriter, (UnitmasterViewOptions)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceClockConfig(PrintWriter printWriter, ClockConfig clockConfig) {
        if (clockConfig == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(clockConfig.dayLightSavingMode);
        this.trace(printWriter, clockConfig.timeSourcesInstallation);
    }

    private void traceClockDate(PrintWriter printWriter, ClockDate clockDate) {
        if (clockDate == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(clockDate.year);
        printWriter.print(clockDate.month);
        printWriter.print(clockDate.day);
    }

    private void traceClockDayLightSavingData(PrintWriter printWriter, ClockDayLightSavingData clockDayLightSavingData) {
        if (clockDayLightSavingData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(clockDayLightSavingData.state);
        printWriter.print(clockDayLightSavingData.month);
        printWriter.print(clockDayLightSavingData.day);
        printWriter.print(clockDayLightSavingData.hour);
        printWriter.print(clockDayLightSavingData.minute);
        printWriter.print(clockDayLightSavingData.second);
    }

    private void traceClockGPSSyncData(PrintWriter printWriter, ClockGPSSyncData clockGPSSyncData) {
        if (clockGPSSyncData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, clockGPSSyncData.time);
        this.trace(printWriter, clockGPSSyncData.date);
    }

    private void traceClockSources(PrintWriter printWriter, ClockSources clockSources) {
        if (clockSources == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(clockSources.quartz);
        printWriter.print(clockSources.dcf77);
        printWriter.print(clockSources.gps);
    }

    private void traceClockSummerTimeData(PrintWriter printWriter, ClockSummerTimeData clockSummerTimeData) {
        if (clockSummerTimeData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(clockSummerTimeData.validity);
        printWriter.print(clockSummerTimeData.yearFrom);
        printWriter.print(clockSummerTimeData.monthFrom);
        printWriter.print(clockSummerTimeData.dayFrom);
        printWriter.print(clockSummerTimeData.hourFrom);
        printWriter.print(clockSummerTimeData.yearTo);
        printWriter.print(clockSummerTimeData.monthTo);
        printWriter.print(clockSummerTimeData.dayTo);
        printWriter.print(clockSummerTimeData.hourTo);
    }

    private void traceClockTime(PrintWriter printWriter, ClockTime clockTime) {
        if (clockTime == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(clockTime.hours);
        printWriter.print(clockTime.minutes);
        printWriter.print(clockTime.seconds);
        printWriter.print(clockTime.timeZone);
        printWriter.print(clockTime.summerTime);
    }

    private void traceClockViewOptions(PrintWriter printWriter, ClockViewOptions clockViewOptions) {
        if (clockViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, clockViewOptions.time);
        this.trace(printWriter, clockViewOptions.date);
        this.trace(printWriter, clockViewOptions.timeZone);
        this.trace(printWriter, clockViewOptions.dayLightSaving);
        this.trace(printWriter, clockViewOptions.dayLightSavingData);
        this.trace(printWriter, clockViewOptions.clockSource);
        this.trace(printWriter, clockViewOptions.gpsSyncData);
        this.trace(printWriter, clockViewOptions.clockConfig);
    }

    private void traceUTCOffset(PrintWriter printWriter, UTCOffset uTCOffset) {
        if (uTCOffset == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(uTCOffset.offset);
        printWriter.print(uTCOffset.algebraicSign);
        printWriter.print(uTCOffset.state);
    }

    private void traceUnitmasterConfiguration(PrintWriter printWriter, UnitmasterConfiguration unitmasterConfiguration) {
        if (unitmasterConfiguration == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, unitmasterConfiguration.supportedConsumptionUnits);
        this.trace(printWriter, unitmasterConfiguration.supportedSkins);
    }

    private void traceUnitmasterSupportedConsumptionUnits(PrintWriter printWriter, UnitmasterSupportedConsumptionUnits unitmasterSupportedConsumptionUnits) {
        if (unitmasterSupportedConsumptionUnits == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(unitmasterSupportedConsumptionUnits.kWhPerMiles);
        printWriter.print(unitmasterSupportedConsumptionUnits.milesPerKg);
        printWriter.print(unitmasterSupportedConsumptionUnits.milesPerM3);
        printWriter.print(unitmasterSupportedConsumptionUnits.mpgeUS);
    }

    private void traceUnitmasterSupportedSkins(PrintWriter printWriter, UnitmasterSupportedSkins unitmasterSupportedSkins) {
        if (unitmasterSupportedSkins == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(unitmasterSupportedSkins.skin1);
        printWriter.print(unitmasterSupportedSkins.skin2);
        printWriter.print(unitmasterSupportedSkins.skin3);
    }

    private void traceUnitmasterViewOptions(PrintWriter printWriter, UnitmasterViewOptions unitmasterViewOptions) {
        if (unitmasterViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, unitmasterViewOptions.dateFormat);
        this.trace(printWriter, unitmasterViewOptions.clockFormat);
        this.trace(printWriter, unitmasterViewOptions.language);
        this.trace(printWriter, unitmasterViewOptions.temperatureUnit);
        this.trace(printWriter, unitmasterViewOptions.distanceUnit);
        this.trace(printWriter, unitmasterViewOptions.speedUnit);
        this.trace(printWriter, unitmasterViewOptions.pressureUnit);
        this.trace(printWriter, unitmasterViewOptions.volumeUnit);
        this.trace(printWriter, unitmasterViewOptions.consumptionPetrolUnit);
        this.trace(printWriter, unitmasterViewOptions.consumptionGasUnit);
        this.trace(printWriter, unitmasterViewOptions.umSetFactoryDefault);
        this.trace(printWriter, unitmasterViewOptions.consumptionElectricUnit);
        this.trace(printWriter, unitmasterViewOptions.skin);
        this.trace(printWriter, unitmasterViewOptions.weightUnit);
        this.trace(printWriter, unitmasterViewOptions.umConfiguration);
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

