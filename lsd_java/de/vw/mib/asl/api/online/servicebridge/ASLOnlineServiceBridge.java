/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.online.servicebridge;

import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.ContactContainer;

public interface ASLOnlineServiceBridge {
    default public boolean isHASReady() {
    }

    default public void getGMTOffset() {
    }

    default public void getDrivingState() {
    }

    default public void getDayNightState() {
    }

    default public void getSkinInfo() {
    }

    default public void getLanguageInfo() {
    }

    default public void getCurrentLocation() {
    }

    default public void getDestinationLocation() {
    }

    default public void getGuidanceState() {
    }

    default public void getVehicleIdentificationNumber() {
    }

    default public void getSoftwareRevision() {
    }

    default public void getOriginalEquipmentManufacturer() {
    }

    default public void getMainDisplayDimension() {
    }

    default public void getUnitDistance() {
    }

    default public void getUnitVelocity() {
    }

    default public void getUnitTemperature() {
    }

    default public void getUnitPressure() {
    }

    default public void getUnitFuelConsumption() {
    }

    default public void getFormatTime() {
    }

    default public void getFormatDate() {
    }

    default public void getHeading() {
    }

    default public void registerProperty(int n) {
    }

    default public void unregisterProperty(int n, boolean bl) {
    }

    default public void saveDestination(AddressContainer addressContainer) {
    }

    default public void startGuidance(AddressContainer addressContainer) {
    }

    default public void addStopOver(AddressContainer addressContainer) {
    }

    default public void callContact(ContactContainer contactContainer) {
    }
}

