/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.servicebridge;

import de.vw.mib.asl.api.online.servicebridge.ASLOnlineServiceBridge;
import de.vw.mib.asl.internal.online.servicebridge.OnlineServiceBridge;
import generated.de.vw.mib.has.containers.AddressContainer;
import generated.de.vw.mib.has.containers.ContactContainer;

public class ASLOnlineServiceBridgeImpl
implements ASLOnlineServiceBridge {
    @Override
    public boolean isHASReady() {
        return OnlineServiceBridge.getOnlineServiceBridgeController().isHmiReady();
    }

    @Override
    public void getGMTOffset() {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestProperty(2);
    }

    @Override
    public void getDrivingState() {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestProperty(3);
    }

    @Override
    public void getDayNightState() {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestProperty(4);
    }

    @Override
    public void getSkinInfo() {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestProperty(5);
    }

    @Override
    public void getLanguageInfo() {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestProperty(6);
    }

    @Override
    public void getCurrentLocation() {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestProperty(1);
    }

    @Override
    public void getDestinationLocation() {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestProperty(8);
    }

    @Override
    public void getGuidanceState() {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestProperty(7);
    }

    @Override
    public void getVehicleIdentificationNumber() {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestProperty(9);
    }

    @Override
    public void getSoftwareRevision() {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestProperty(10);
    }

    @Override
    public void getOriginalEquipmentManufacturer() {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestProperty(11);
    }

    @Override
    public void getMainDisplayDimension() {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestProperty(12);
    }

    @Override
    public void getUnitDistance() {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestProperty(13);
    }

    @Override
    public void getUnitVelocity() {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestProperty(14);
    }

    @Override
    public void getUnitTemperature() {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestProperty(15);
    }

    @Override
    public void getUnitPressure() {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestProperty(16);
    }

    @Override
    public void getUnitFuelConsumption() {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestProperty(17);
    }

    @Override
    public void getFormatTime() {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestProperty(18);
    }

    @Override
    public void getFormatDate() {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestProperty(19);
    }

    @Override
    public void getHeading() {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestProperty(20);
    }

    @Override
    public void registerProperty(int n) {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestSubscribe(n, 0);
    }

    @Override
    public void unregisterProperty(int n, boolean bl) {
        OnlineServiceBridge.getOnlineServiceBridgeController().requestUnsubscribe(false, n);
    }

    @Override
    public void saveDestination(AddressContainer addressContainer) {
    }

    @Override
    public void startGuidance(AddressContainer addressContainer) {
    }

    @Override
    public void addStopOver(AddressContainer addressContainer) {
    }

    @Override
    public void callContact(ContactContainer contactContainer) {
    }
}

