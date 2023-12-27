/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

import org.dsi.ifc.carparkingsystem.WCConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class WCViewOptions {
    public CarViewOption systemOnOff;
    public CarViewOption setFactoryDefault;
    public CarViewOption autoActivation;
    public CarViewOption vehiclePanelInfo;
    public CarViewOption pinPukState;
    public CarViewOption panelList;
    public CarViewOption enterPinPuk;
    public CarViewOption startScanning;
    public CarViewOption startPairing;
    public CarViewOption startSoftwareUpdate;
    public CarViewOption changePin;
    public CarViewOption changePanelName;
    public WCConfiguration configuration;

    public WCViewOptions() {
        this.systemOnOff = null;
        this.setFactoryDefault = null;
        this.autoActivation = null;
        this.vehiclePanelInfo = null;
        this.pinPukState = null;
        this.panelList = null;
        this.enterPinPuk = null;
        this.startScanning = null;
        this.startPairing = null;
        this.startSoftwareUpdate = null;
        this.changePin = null;
        this.changePanelName = null;
        this.configuration = null;
    }

    public WCViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, WCConfiguration wCConfiguration) {
        this.systemOnOff = carViewOption;
        this.setFactoryDefault = carViewOption2;
        this.autoActivation = carViewOption3;
        this.configuration = wCConfiguration;
        this.vehiclePanelInfo = null;
        this.pinPukState = null;
        this.panelList = null;
        this.enterPinPuk = null;
        this.startScanning = null;
        this.startPairing = null;
        this.startSoftwareUpdate = null;
        this.changePin = null;
        this.changePanelName = null;
    }

    public WCViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, CarViewOption carViewOption10, CarViewOption carViewOption11, CarViewOption carViewOption12, WCConfiguration wCConfiguration) {
        this.systemOnOff = carViewOption;
        this.setFactoryDefault = carViewOption2;
        this.autoActivation = carViewOption3;
        this.vehiclePanelInfo = carViewOption4;
        this.pinPukState = carViewOption5;
        this.panelList = carViewOption6;
        this.enterPinPuk = carViewOption7;
        this.startScanning = carViewOption8;
        this.startPairing = carViewOption9;
        this.startSoftwareUpdate = carViewOption10;
        this.changePin = carViewOption11;
        this.changePanelName = carViewOption12;
        this.configuration = wCConfiguration;
    }

    public CarViewOption getSystemOnOff() {
        return this.systemOnOff;
    }

    public CarViewOption getSetFactoryDefault() {
        return this.setFactoryDefault;
    }

    public CarViewOption getAutoActivation() {
        return this.autoActivation;
    }

    public CarViewOption getVehiclePanelInfo() {
        return this.vehiclePanelInfo;
    }

    public CarViewOption getPinPukState() {
        return this.pinPukState;
    }

    public CarViewOption getPanelList() {
        return this.panelList;
    }

    public CarViewOption getEnterPinPuk() {
        return this.enterPinPuk;
    }

    public CarViewOption getStartScanning() {
        return this.startScanning;
    }

    public CarViewOption getStartPairing() {
        return this.startPairing;
    }

    public CarViewOption getStartSoftwareUpdate() {
        return this.startSoftwareUpdate;
    }

    public CarViewOption getChangePin() {
        return this.changePin;
    }

    public CarViewOption getChangePanelName() {
        return this.changePanelName;
    }

    public WCConfiguration getConfiguration() {
        return this.configuration;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(13500);
        stringBuffer.append("WCViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("systemOnOff");
        stringBuffer.append('=');
        stringBuffer.append(this.systemOnOff);
        stringBuffer.append(',');
        stringBuffer.append("setFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.setFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("autoActivation");
        stringBuffer.append('=');
        stringBuffer.append(this.autoActivation);
        stringBuffer.append(',');
        stringBuffer.append("vehiclePanelInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.vehiclePanelInfo);
        stringBuffer.append(',');
        stringBuffer.append("pinPukState");
        stringBuffer.append('=');
        stringBuffer.append(this.pinPukState);
        stringBuffer.append(',');
        stringBuffer.append("panelList");
        stringBuffer.append('=');
        stringBuffer.append(this.panelList);
        stringBuffer.append(',');
        stringBuffer.append("enterPinPuk");
        stringBuffer.append('=');
        stringBuffer.append(this.enterPinPuk);
        stringBuffer.append(',');
        stringBuffer.append("startScanning");
        stringBuffer.append('=');
        stringBuffer.append(this.startScanning);
        stringBuffer.append(',');
        stringBuffer.append("startPairing");
        stringBuffer.append('=');
        stringBuffer.append(this.startPairing);
        stringBuffer.append(',');
        stringBuffer.append("startSoftwareUpdate");
        stringBuffer.append('=');
        stringBuffer.append(this.startSoftwareUpdate);
        stringBuffer.append(',');
        stringBuffer.append("changePin");
        stringBuffer.append('=');
        stringBuffer.append(this.changePin);
        stringBuffer.append(',');
        stringBuffer.append("changePanelName");
        stringBuffer.append('=');
        stringBuffer.append(this.changePanelName);
        stringBuffer.append(',');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

