/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.has;

import generated.de.vw.mib.has.containers.EncodedVehicleTypeContainer;

public interface SystemHasBridge {
    default public void setPropertyDayNightState(int n) {
    }

    default public void setPropertyDrivingState(boolean bl) {
    }

    default public void setPropertyGMTOffset(int n) {
    }

    default public void setPropertyLanguageInfo(String string) {
    }

    default public void setPropertySkinInfo(String string) {
    }

    default public void setPropertyDateFormat(int n) {
    }

    default public void setPropertyTimeFormat(int n) {
    }

    default public void setPropertyLiquidConsumptionUnit(int n) {
    }

    default public void setPropertyPressureUnit(int n) {
    }

    default public void setPropertyTemperatureUnit(int n) {
    }

    default public void setPropertyDistanceUnit(int n) {
    }

    default public void setPropertySpeedUnit(int n) {
    }

    default public void setPropertyOriginalEquipmentManufacturer(int n) {
    }

    default public void setPropertyXRes(int n) {
    }

    default public void setPropertyYRes(int n) {
    }

    default public void setPropertySoftwareRevision(String string) {
    }

    default public void setPropertyVIN(String string) {
    }

    default public void setPropertyEncodedVehicleType(String string) {
    }

    default public EncodedVehicleTypeContainer getEncodedVehicleTypeContainer() {
    }

    default public void refreshEncodedVehicleTypeContainer() {
    }

    default public void setPropertyMainDisplayApproximity(boolean bl) {
    }

    default public void setPropertyColorSRGB(String string) {
    }

    default public void setPropertyColorHMI(String string) {
    }
}

