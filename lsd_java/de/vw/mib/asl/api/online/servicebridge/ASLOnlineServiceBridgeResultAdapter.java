/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.online.servicebridge;

import de.vw.mib.asl.api.online.servicebridge.ASLOnlineServiceBridgeResult;
import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.DisplayDimensionContainer;

public class ASLOnlineServiceBridgeResultAdapter
implements ASLOnlineServiceBridgeResult {
    @Override
    public void updateGMTOffset(int n, int n2) {
    }

    @Override
    public void updateDrivingState(boolean bl, int n) {
    }

    @Override
    public void updateDayNightState(int n, int n2) {
    }

    @Override
    public void updateSkinInfo(String string, int n) {
    }

    @Override
    public void updateLanguageInfo(String string, int n) {
    }

    @Override
    public void updateGuidanceState(int n, int n2) {
    }

    @Override
    public void updateCurrentLocation(AddressContainer addressContainer, int n) {
    }

    @Override
    public void updateDestinationLocation(AddressContainer addressContainer, int n) {
    }

    @Override
    public void saveDestinationResult(int n) {
    }

    @Override
    public void startGuidanceResult(int n) {
    }

    @Override
    public void addStopOverResult(int n) {
    }

    @Override
    public void callContactResult(int n) {
    }

    @Override
    public void subscriptionResult(int n) {
    }

    @Override
    public void updateVehicleIdentificationNumber(String string, int n) {
    }

    @Override
    public void updateSoftwareRevision(String string, int n) {
    }

    @Override
    public void updateOriginalEquipmentManufacturer(String string, int n) {
    }

    @Override
    public void updateMainDisplayDimension(DisplayDimensionContainer displayDimensionContainer, int n) {
    }

    @Override
    public void updateUnitDistance(String string, int n) {
    }

    @Override
    public void updateUnitVelocity(String string, int n) {
    }

    @Override
    public void updateUnitTemperature(String string, int n) {
    }

    @Override
    public void updateUnitPressure(String string, int n) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateUnitFuelConsumption(String string, int n) {
    }

    @Override
    public void updateFormatTime(int n, int n2) {
    }

    @Override
    public void updateFormatDate(String string, int n) {
    }

    @Override
    public void updateHeading(int n, int n2) {
    }

    @Override
    public void updateHASState(boolean bl) {
    }
}

