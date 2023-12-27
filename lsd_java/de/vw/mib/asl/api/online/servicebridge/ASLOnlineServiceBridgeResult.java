/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.online.servicebridge;

import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.DisplayDimensionContainer;

public interface ASLOnlineServiceBridgeResult {
    default public void updateHASState(boolean bl) {
    }

    default public void updateGMTOffset(int n, int n2) {
    }

    default public void updateDrivingState(boolean bl, int n) {
    }

    default public void updateDayNightState(int n, int n2) {
    }

    default public void updateSkinInfo(String string, int n) {
    }

    default public void updateLanguageInfo(String string, int n) {
    }

    default public void updateGuidanceState(int n, int n2) {
    }

    default public void updateCurrentLocation(AddressContainer addressContainer, int n) {
    }

    default public void updateDestinationLocation(AddressContainer addressContainer, int n) {
    }

    default public void updateVehicleIdentificationNumber(String string, int n) {
    }

    default public void updateSoftwareRevision(String string, int n) {
    }

    default public void updateOriginalEquipmentManufacturer(String string, int n) {
    }

    default public void updateMainDisplayDimension(DisplayDimensionContainer displayDimensionContainer, int n) {
    }

    default public void updateUnitDistance(String string, int n) {
    }

    default public void updateUnitVelocity(String string, int n) {
    }

    default public void updateUnitTemperature(String string, int n) {
    }

    default public void updateUnitPressure(String string, int n) {
    }

    default public void updateUnitFuelConsumption(String string, int n) {
    }

    default public void updateFormatTime(int n, int n2) {
    }

    default public void updateFormatDate(String string, int n) {
    }

    default public void updateHeading(int n, int n2) {
    }

    default public void subscriptionResult(int n) {
    }

    default public void saveDestinationResult(int n) {
    }

    default public void startGuidanceResult(int n) {
    }

    default public void addStopOverResult(int n) {
    }

    default public void callContactResult(int n) {
    }
}

