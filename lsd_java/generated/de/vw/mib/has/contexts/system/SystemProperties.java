/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.system;

import de.vw.mib.has.HASContextProperties;
import generated.de.vw.mib.has.containers.AmbientLightContainer;
import generated.de.vw.mib.has.containers.DisplayDimensionContainer;
import generated.de.vw.mib.has.containers.EncodedVehicleTypeContainer;

public interface SystemProperties
extends HASContextProperties {
    default public void updateGMTOffset(int n) {
    }

    default public void updateDrivingState(boolean bl) {
    }

    default public void updateDayNightState(int n) {
    }

    default public void updateSkinInfo(String string) {
    }

    default public void updateLanguageInfo(String string) {
    }

    default public void updateVehicleIdentificationNumber(String string) {
    }

    default public void updateSoftwareRevision(String string) {
    }

    default public void updateOriginalEquipmentManufacturer(String string) {
    }

    default public void updateMainDisplayDimension(DisplayDimensionContainer displayDimensionContainer) {
    }

    default public void updateUnitDistance(String string) {
    }

    default public void updateUnitVelocity(String string) {
    }

    default public void updateUnitTemperature(String string) {
    }

    default public void updateUnitPressure(String string) {
    }

    default public void updateUnitFuelConsumption(String string) {
    }

    default public void updateFormatTime(int n) {
    }

    default public void updateFormatDate(String string) {
    }

    default public void updateMainDisplayApproximity(boolean bl) {
    }

    default public void updateEncodedVehicleType(EncodedVehicleTypeContainer encodedVehicleTypeContainer) {
    }

    default public void updateAmbientLight(AmbientLightContainer ambientLightContainer) {
    }
}

