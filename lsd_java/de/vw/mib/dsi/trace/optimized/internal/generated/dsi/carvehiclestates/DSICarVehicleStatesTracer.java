/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.carvehiclestates;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.carvehiclestates.DrvSchoolSpeedData;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoSCR;
import org.dsi.ifc.carvehiclestates.KeyData;
import org.dsi.ifc.carvehiclestates.OilLevelData;
import org.dsi.ifc.carvehiclestates.OilLevelRefillVolume;
import org.dsi.ifc.carvehiclestates.SemiStaticDataViewOptions;
import org.dsi.ifc.carvehiclestates.SemiStaticVehicleData;
import org.dsi.ifc.carvehiclestates.VehicleInfoViewOptions;

public final class DSICarVehicleStatesTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_DRVSCHOOLSPEEDDATA;
    private static final int ID_DYNAMICVEHICLEINFOHIGHFREQUENT;
    private static final int ID_DYNAMICVEHICLEINFOHIGHFREQUENTVIEWOPTIONS;
    private static final int ID_DYNAMICVEHICLEINFOMIDFREQUENT;
    private static final int ID_DYNAMICVEHICLEINFOMIDFREQUENTVIEWOPTIONS;
    private static final int ID_DYNAMICVEHICLEINFOSCR;
    private static final int ID_KEYDATA;
    private static final int ID_OILLEVELDATA;
    private static final int ID_OILLEVELREFILLVOLUME;
    private static final int ID_SEMISTATICDATAVIEWOPTIONS;
    private static final int ID_SEMISTATICVEHICLEDATA;
    private static final int ID_VEHICLEINFOVIEWOPTIONS;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DrvSchoolSpeedData;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DynamicVehicleInfoHighFrequent;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DynamicVehicleInfoHighFrequentViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DynamicVehicleInfoMidFrequent;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DynamicVehicleInfoMidFrequentViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DynamicVehicleInfoSCR;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$KeyData;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$OilLevelData;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$OilLevelRefillVolume;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$SemiStaticDataViewOptions;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$SemiStaticVehicleData;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$VehicleInfoViewOptions;

    public DSICarVehicleStatesTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carvehiclestates$DrvSchoolSpeedData == null ? (class$org$dsi$ifc$carvehiclestates$DrvSchoolSpeedData = DSICarVehicleStatesTracer.class$("org.dsi.ifc.carvehiclestates.DrvSchoolSpeedData")) : class$org$dsi$ifc$carvehiclestates$DrvSchoolSpeedData, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carvehiclestates$DynamicVehicleInfoHighFrequent == null ? (class$org$dsi$ifc$carvehiclestates$DynamicVehicleInfoHighFrequent = DSICarVehicleStatesTracer.class$("org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent")) : class$org$dsi$ifc$carvehiclestates$DynamicVehicleInfoHighFrequent, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carvehiclestates$DynamicVehicleInfoHighFrequentViewOptions == null ? (class$org$dsi$ifc$carvehiclestates$DynamicVehicleInfoHighFrequentViewOptions = DSICarVehicleStatesTracer.class$("org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions")) : class$org$dsi$ifc$carvehiclestates$DynamicVehicleInfoHighFrequentViewOptions, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carvehiclestates$DynamicVehicleInfoMidFrequent == null ? (class$org$dsi$ifc$carvehiclestates$DynamicVehicleInfoMidFrequent = DSICarVehicleStatesTracer.class$("org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequent")) : class$org$dsi$ifc$carvehiclestates$DynamicVehicleInfoMidFrequent, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carvehiclestates$DynamicVehicleInfoMidFrequentViewOptions == null ? (class$org$dsi$ifc$carvehiclestates$DynamicVehicleInfoMidFrequentViewOptions = DSICarVehicleStatesTracer.class$("org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequentViewOptions")) : class$org$dsi$ifc$carvehiclestates$DynamicVehicleInfoMidFrequentViewOptions, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carvehiclestates$DynamicVehicleInfoSCR == null ? (class$org$dsi$ifc$carvehiclestates$DynamicVehicleInfoSCR = DSICarVehicleStatesTracer.class$("org.dsi.ifc.carvehiclestates.DynamicVehicleInfoSCR")) : class$org$dsi$ifc$carvehiclestates$DynamicVehicleInfoSCR, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carvehiclestates$KeyData == null ? (class$org$dsi$ifc$carvehiclestates$KeyData = DSICarVehicleStatesTracer.class$("org.dsi.ifc.carvehiclestates.KeyData")) : class$org$dsi$ifc$carvehiclestates$KeyData, 7);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carvehiclestates$OilLevelData == null ? (class$org$dsi$ifc$carvehiclestates$OilLevelData = DSICarVehicleStatesTracer.class$("org.dsi.ifc.carvehiclestates.OilLevelData")) : class$org$dsi$ifc$carvehiclestates$OilLevelData, 8);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carvehiclestates$OilLevelRefillVolume == null ? (class$org$dsi$ifc$carvehiclestates$OilLevelRefillVolume = DSICarVehicleStatesTracer.class$("org.dsi.ifc.carvehiclestates.OilLevelRefillVolume")) : class$org$dsi$ifc$carvehiclestates$OilLevelRefillVolume, 9);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carvehiclestates$SemiStaticDataViewOptions == null ? (class$org$dsi$ifc$carvehiclestates$SemiStaticDataViewOptions = DSICarVehicleStatesTracer.class$("org.dsi.ifc.carvehiclestates.SemiStaticDataViewOptions")) : class$org$dsi$ifc$carvehiclestates$SemiStaticDataViewOptions, 10);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carvehiclestates$SemiStaticVehicleData == null ? (class$org$dsi$ifc$carvehiclestates$SemiStaticVehicleData = DSICarVehicleStatesTracer.class$("org.dsi.ifc.carvehiclestates.SemiStaticVehicleData")) : class$org$dsi$ifc$carvehiclestates$SemiStaticVehicleData, 11);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$carvehiclestates$VehicleInfoViewOptions == null ? (class$org$dsi$ifc$carvehiclestates$VehicleInfoViewOptions = DSICarVehicleStatesTracer.class$("org.dsi.ifc.carvehiclestates.VehicleInfoViewOptions")) : class$org$dsi$ifc$carvehiclestates$VehicleInfoViewOptions, 12);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceDrvSchoolSpeedData(printWriter, (DrvSchoolSpeedData)object);
                break;
            }
            case 2: {
                this.traceDynamicVehicleInfoHighFrequent(printWriter, (DynamicVehicleInfoHighFrequent)object);
                break;
            }
            case 3: {
                this.traceDynamicVehicleInfoHighFrequentViewOptions(printWriter, (DynamicVehicleInfoHighFrequentViewOptions)object);
                break;
            }
            case 4: {
                this.traceDynamicVehicleInfoMidFrequent(printWriter, (DynamicVehicleInfoMidFrequent)object);
                break;
            }
            case 5: {
                this.traceDynamicVehicleInfoMidFrequentViewOptions(printWriter, (DynamicVehicleInfoMidFrequentViewOptions)object);
                break;
            }
            case 6: {
                this.traceDynamicVehicleInfoSCR(printWriter, (DynamicVehicleInfoSCR)object);
                break;
            }
            case 7: {
                this.traceKeyData(printWriter, (KeyData)object);
                break;
            }
            case 8: {
                this.traceOilLevelData(printWriter, (OilLevelData)object);
                break;
            }
            case 9: {
                this.traceOilLevelRefillVolume(printWriter, (OilLevelRefillVolume)object);
                break;
            }
            case 10: {
                this.traceSemiStaticDataViewOptions(printWriter, (SemiStaticDataViewOptions)object);
                break;
            }
            case 11: {
                this.traceSemiStaticVehicleData(printWriter, (SemiStaticVehicleData)object);
                break;
            }
            case 12: {
                this.traceVehicleInfoViewOptions(printWriter, (VehicleInfoViewOptions)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceDrvSchoolSpeedData(PrintWriter printWriter, DrvSchoolSpeedData drvSchoolSpeedData) {
        if (drvSchoolSpeedData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(drvSchoolSpeedData.speed);
        printWriter.print(drvSchoolSpeedData.unit);
    }

    private void traceDynamicVehicleInfoHighFrequent(PrintWriter printWriter, DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent) {
        if (dynamicVehicleInfoHighFrequent == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dynamicVehicleInfoHighFrequent.longitudinalAcceleration);
        printWriter.print(dynamicVehicleInfoHighFrequent.engineSpeed);
        printWriter.print(dynamicVehicleInfoHighFrequent.powermeter);
        printWriter.print(dynamicVehicleInfoHighFrequent.lateralAcceleration);
        printWriter.print(dynamicVehicleInfoHighFrequent.relChargingAirPressure);
        printWriter.print(dynamicVehicleInfoHighFrequent.absChargingAirPressure);
        printWriter.print(dynamicVehicleInfoHighFrequent.currentOutputPower);
        printWriter.print(dynamicVehicleInfoHighFrequent.yawRate);
        printWriter.print(dynamicVehicleInfoHighFrequent.brakePressure);
        printWriter.print(dynamicVehicleInfoHighFrequent.wheelAngle);
        printWriter.print(dynamicVehicleInfoHighFrequent.acceleratorPosition);
        this.trace(printWriter, dynamicVehicleInfoHighFrequent.vehicleSpeed);
        printWriter.print(dynamicVehicleInfoHighFrequent.currentTorque);
        printWriter.print(dynamicVehicleInfoHighFrequent.systemCycleDistance);
        printWriter.print(dynamicVehicleInfoHighFrequent.torqueDistributionFrontLeft);
        printWriter.print(dynamicVehicleInfoHighFrequent.torqueDistributionFrontRight);
        printWriter.print(dynamicVehicleInfoHighFrequent.torqueDistributionRearLeft);
        printWriter.print(dynamicVehicleInfoHighFrequent.torqueDistributionRearRight);
        this.trace(printWriter, dynamicVehicleInfoHighFrequent.realVehicleSpeed);
        printWriter.print(dynamicVehicleInfoHighFrequent.shiftLight);
        printWriter.print(dynamicVehicleInfoHighFrequent.allWheelDriveTorque);
        printWriter.print(dynamicVehicleInfoHighFrequent.espOversteering);
        printWriter.print(dynamicVehicleInfoHighFrequent.espUndersteering);
        printWriter.print(dynamicVehicleInfoHighFrequent.espWheelVelocityFrontLeft);
        printWriter.print(dynamicVehicleInfoHighFrequent.espWheelVelocityFrontRight);
        printWriter.print(dynamicVehicleInfoHighFrequent.espWheelVelocityRearLeft);
        printWriter.print(dynamicVehicleInfoHighFrequent.espWheelVelocityRearRight);
    }

    private void traceDynamicVehicleInfoHighFrequentViewOptions(PrintWriter printWriter, DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions) {
        if (dynamicVehicleInfoHighFrequentViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.longitudinalAcceleration);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.engineSpeed);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.powermeter);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.lateralAcceleration);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.relChargingAirPressure);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.absChargingAirPressure);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.currentOutputPower);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.currentTorque);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.yawRate);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.brakePressure);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.wheelAngle);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.acceleratorPosition);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.vehicleSpeed);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.systemCycleDistance);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.torqueDistributionFrontLeft);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.torqueDistributionFrontRight);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.torqueDistributionRearLeft);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.torqueDistributionRearRight);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.realVehicleSpeed);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.shiftLight);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.allWheelDriveTorque);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.espOversteering);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.espUndersteering);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.espWheelVelocityFrontLeft);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.espWheelVelocityFrontRight);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.espWheelVelocityRearLeft);
        this.trace(printWriter, dynamicVehicleInfoHighFrequentViewOptions.espWheelVelocityRearRight);
    }

    private void traceDynamicVehicleInfoMidFrequent(PrintWriter printWriter, DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent) {
        if (dynamicVehicleInfoMidFrequent == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dynamicVehicleInfoMidFrequent.coastingIsActive);
        printWriter.print(dynamicVehicleInfoMidFrequent.gearboxOilTemperature);
        printWriter.print(dynamicVehicleInfoMidFrequent.blinkingState);
        printWriter.print(dynamicVehicleInfoMidFrequent.currentGear);
        printWriter.print(dynamicVehicleInfoMidFrequent.recommendedGear);
        printWriter.print(dynamicVehicleInfoMidFrequent.clutch);
        printWriter.print(dynamicVehicleInfoMidFrequent.acceleratorKickDown);
        printWriter.print(dynamicVehicleInfoMidFrequent.driverIsBraking);
        printWriter.print(dynamicVehicleInfoMidFrequent.aCCIsActive);
        printWriter.print(dynamicVehicleInfoMidFrequent.automaticGearShiftTransMode);
        printWriter.print(dynamicVehicleInfoMidFrequent.recuperationLevel);
        printWriter.print(dynamicVehicleInfoMidFrequent.hdcColor);
        printWriter.print(dynamicVehicleInfoMidFrequent.hdcSpeed);
        printWriter.print(dynamicVehicleInfoMidFrequent.edsDisplay);
        printWriter.print(dynamicVehicleInfoMidFrequent.valetParkingState);
        printWriter.print(dynamicVehicleInfoMidFrequent.highwayBlinkingState);
        printWriter.print(dynamicVehicleInfoMidFrequent.batteryVoltage);
        printWriter.print(dynamicVehicleInfoMidFrequent.lowBeamHeadlightIsActive);
        printWriter.print(dynamicVehicleInfoMidFrequent.highBeamHeadlightIsActive);
        printWriter.print(dynamicVehicleInfoMidFrequent.fogLightFrontIsActive);
        printWriter.print(dynamicVehicleInfoMidFrequent.fogLightRearIsActive);
        printWriter.print(dynamicVehicleInfoMidFrequent.daytimeRunningLightIsActive);
        printWriter.print(dynamicVehicleInfoMidFrequent.espLight);
        printWriter.print(dynamicVehicleInfoMidFrequent.espPassiveSensing);
        printWriter.print(dynamicVehicleInfoMidFrequent.tirePressureFrontLeft);
        printWriter.print(dynamicVehicleInfoMidFrequent.tirePressureFrontRight);
        printWriter.print(dynamicVehicleInfoMidFrequent.tirePressureRearLeft);
        printWriter.print(dynamicVehicleInfoMidFrequent.tirePressureRearRight);
    }

    private void traceDynamicVehicleInfoMidFrequentViewOptions(PrintWriter printWriter, DynamicVehicleInfoMidFrequentViewOptions dynamicVehicleInfoMidFrequentViewOptions) {
        if (dynamicVehicleInfoMidFrequentViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.currentGear);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.recommendedGear);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.clutch);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.acceleratorKickDown);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.driverIsBraking);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.coastingIsActive);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.gearboxOilTemperature);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.blinkingState);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.aCCIsActive);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.automaticGearShiftTransMode);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.recuperationLevel);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.hdcColor);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.hdcSpeed);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.edsDisplay);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.valetParkingState);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.batteryVoltage);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.lowBeamHeadlightIsActive);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.highBeamHeadlightIsActive);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.fogLightFrontIsActive);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.fogLightRearIsActive);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.daytimeRunningLightIsActive);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.espLight);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.espPassiveSensing);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.tirePressureFrontLeft);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.tirePressureFrontRight);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.tirePressureRearLeft);
        this.trace(printWriter, dynamicVehicleInfoMidFrequentViewOptions.tirePressureRearRight);
    }

    private void traceDynamicVehicleInfoSCR(PrintWriter printWriter, DynamicVehicleInfoSCR dynamicVehicleInfoSCR) {
        if (dynamicVehicleInfoSCR == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(dynamicVehicleInfoSCR.range);
        printWriter.print(dynamicVehicleInfoSCR.rangeUnit);
        printWriter.print(dynamicVehicleInfoSCR.level);
        printWriter.print(dynamicVehicleInfoSCR.refillLevelMin);
        printWriter.print(dynamicVehicleInfoSCR.refillLevelMax);
        printWriter.print(dynamicVehicleInfoSCR.tankVolume);
        printWriter.print(dynamicVehicleInfoSCR.volumeUnit);
        printWriter.print(dynamicVehicleInfoSCR.status);
    }

    private void traceKeyData(PrintWriter printWriter, KeyData keyData) {
        if (keyData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(keyData.targetValue);
        printWriter.print(keyData.actualValue);
        printWriter.print(keyData.activeKey);
    }

    private void traceOilLevelData(PrintWriter printWriter, OilLevelData oilLevelData) {
        if (oilLevelData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(oilLevelData.level);
        this.trace(printWriter, oilLevelData.refillVolume);
        printWriter.print(oilLevelData.warnings);
        printWriter.print(oilLevelData.oilsystem);
        printWriter.print(oilLevelData.bargraph);
    }

    private void traceOilLevelRefillVolume(PrintWriter printWriter, OilLevelRefillVolume oilLevelRefillVolume) {
        if (oilLevelRefillVolume == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(oilLevelRefillVolume.value);
        printWriter.print(oilLevelRefillVolume.unit);
    }

    private void traceSemiStaticDataViewOptions(PrintWriter printWriter, SemiStaticDataViewOptions semiStaticDataViewOptions) {
        if (semiStaticDataViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, semiStaticDataViewOptions.maxChargingAirPressure);
        this.trace(printWriter, semiStaticDataViewOptions.maxOutputPower);
        this.trace(printWriter, semiStaticDataViewOptions.maxTorque);
        this.trace(printWriter, semiStaticDataViewOptions.engineDisplacement);
        this.trace(printWriter, semiStaticDataViewOptions.typeOfInjectionSystem);
    }

    private void traceSemiStaticVehicleData(PrintWriter printWriter, SemiStaticVehicleData semiStaticVehicleData) {
        if (semiStaticVehicleData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(semiStaticVehicleData.maxChargingAirPressure);
        printWriter.print(semiStaticVehicleData.maxOutputPower);
        printWriter.print(semiStaticVehicleData.maxTorque);
        printWriter.print(semiStaticVehicleData.engineDisplacement);
        printWriter.print(semiStaticVehicleData.typeOfInjectionSystem);
    }

    private void traceVehicleInfoViewOptions(PrintWriter printWriter, VehicleInfoViewOptions vehicleInfoViewOptions) {
        if (vehicleInfoViewOptions == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, vehicleInfoViewOptions.drvSchoolSystem);
        this.trace(printWriter, vehicleInfoViewOptions.scrInfo);
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

