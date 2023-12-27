/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.internal.system.AslTargetSystemDate;
import de.vw.mib.asl.internal.system.AslTargetSystemFeaturesAndCoding;
import de.vw.mib.asl.internal.system.AslTargetSystemGeneral;
import de.vw.mib.asl.internal.system.AslTargetSystemKeyPanelHandling;
import de.vw.mib.asl.internal.system.AslTargetSystemPowerManagementHandling;
import de.vw.mib.asl.internal.system.AslTargetSystemProximity;
import de.vw.mib.asl.internal.system.AslTargetSystemUnits;
import de.vw.mib.asl.internal.system.AslTargetSystemVehicleStates;

public final class SystemAccessor {
    private static AslTargetSystemGeneral generalTarget;
    private static AslTargetSystemFeaturesAndCoding featuresAndCodingTarget;
    private static AslTargetSystemDate dateTarget;
    private static AslTargetSystemKeyPanelHandling keyPanelTarget;
    private static AslTargetSystemPowerManagementHandling powerManagementTarget;
    private static AslTargetSystemProximity proximityTarget;
    private static AslTargetSystemUnits unitsTarget;
    private static AslTargetSystemVehicleStates vehicleStatesTarget;

    private SystemAccessor() {
    }

    public static AslTargetSystemGeneral getGeneralTarget() {
        return generalTarget;
    }

    public static AslTargetSystemFeaturesAndCoding getFeaturesAndCodingTarget() {
        return featuresAndCodingTarget;
    }

    public static AslTargetSystemDate getDateTarget() {
        return dateTarget;
    }

    public static AslTargetSystemPowerManagementHandling getPowerManagementTarget() {
        return powerManagementTarget;
    }

    public static AslTargetSystemUnits getUnitsTarget() {
        return unitsTarget;
    }

    public static AslTargetSystemVehicleStates getVehicleStatesTarget() {
        return vehicleStatesTarget;
    }

    static void setGeneralTarget(AslTargetSystemGeneral aslTargetSystemGeneral) {
        generalTarget = aslTargetSystemGeneral;
    }

    static void setFeaturesAndCodingTarget(AslTargetSystemFeaturesAndCoding aslTargetSystemFeaturesAndCoding) {
        featuresAndCodingTarget = aslTargetSystemFeaturesAndCoding;
    }

    static void setDateTarget(AslTargetSystemDate aslTargetSystemDate) {
        dateTarget = aslTargetSystemDate;
    }

    static void setPowerManagementTarget(AslTargetSystemPowerManagementHandling aslTargetSystemPowerManagementHandling) {
        powerManagementTarget = aslTargetSystemPowerManagementHandling;
    }

    public static AslTargetSystemProximity getProximityTarget() {
        return proximityTarget;
    }

    static void setProximityTarget(AslTargetSystemProximity aslTargetSystemProximity) {
        proximityTarget = aslTargetSystemProximity;
    }

    static void setUnitsTarget(AslTargetSystemUnits aslTargetSystemUnits) {
        unitsTarget = aslTargetSystemUnits;
    }

    static AslTargetSystemKeyPanelHandling getKeyPanelTarget() {
        return keyPanelTarget;
    }

    static void setKeyPanelTarget(AslTargetSystemKeyPanelHandling aslTargetSystemKeyPanelHandling) {
        keyPanelTarget = aslTargetSystemKeyPanelHandling;
    }

    static void setVehicleStatesTarget(AslTargetSystemVehicleStates aslTargetSystemVehicleStates) {
        vehicleStatesTarget = aslTargetSystemVehicleStates;
    }
}

