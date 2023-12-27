/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.internetbrowser.hasServiceBridge;

import de.vw.mib.asl.internal.internetbrowser.hasServiceBridge.BrowserServiceBridge;
import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.ContactContainer;

public class ASLBrowserServiceBridgeImpl {
    public boolean isHASReady() {
        return BrowserServiceBridge.getBrowserServiceBridgeController().isHmiReady();
    }

    public void getGMTOffset() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(2);
    }

    public void getDrivingState() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(3);
    }

    public void getDayNightState() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(4);
    }

    public void getSkinInfo() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(5);
    }

    public void getLanguageInfo() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(6);
    }

    public void getCurrentLocation() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(1);
    }

    public void getDestinationLocation() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(8);
    }

    public void getGuidanceState() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(7);
    }

    public void getVehicleIdentificationNumber() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(9);
    }

    public void getSoftwareRevision() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(10);
    }

    public void getOriginalEquipmentManufacturer() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(11);
    }

    public void getMainDisplayDimension() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(12);
    }

    public void getUnitDistance() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(13);
    }

    public void getUnitVelocity() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(14);
    }

    public void getUnitTemperature() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(15);
    }

    public void getUnitPressure() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(16);
    }

    public void getUnitFuelConsumption() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(17);
    }

    public void getFormatTime() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(18);
    }

    public void getFormatDate() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(19);
    }

    public void getHeading() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(20);
    }

    public void getAmbientColor() {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestProperty(59);
    }

    public static void registerProperty(int n) {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestSubscribe(n, 0);
    }

    public void unregisterProperty(int n, boolean bl) {
        BrowserServiceBridge.getBrowserServiceBridgeController().requestUnsubscribe(false, n);
    }

    public void saveDestination(AddressContainer addressContainer) {
    }

    public void startGuidance(AddressContainer addressContainer) {
    }

    public void addStopOver(AddressContainer addressContainer) {
    }

    public void callContact(ContactContainer contactContainer) {
    }
}

