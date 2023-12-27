/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.carcomfort.UGDOConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class UGDOViewOptions {
    public CarViewOption learningData;
    public CarViewOption deleteButton;
    public CarViewOption versionData;
    public CarViewOption setFactoryDefault;
    public CarViewOption destinationReached;
    public CarViewOption learning;
    public CarViewOption synchronisation;
    public CarViewOption openDoor;
    public CarViewOption buttonList;
    public UGDOConfiguration configuration;

    public UGDOViewOptions() {
        this.learningData = null;
        this.deleteButton = null;
        this.versionData = null;
        this.setFactoryDefault = null;
        this.destinationReached = null;
        this.learning = null;
        this.synchronisation = null;
        this.openDoor = null;
        this.buttonList = null;
        this.configuration = null;
    }

    public UGDOViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, UGDOConfiguration uGDOConfiguration) {
        this.learningData = carViewOption;
        this.deleteButton = carViewOption2;
        this.versionData = carViewOption3;
        this.setFactoryDefault = carViewOption4;
        this.destinationReached = carViewOption5;
        this.learning = carViewOption6;
        this.synchronisation = carViewOption7;
        this.openDoor = carViewOption8;
        this.buttonList = carViewOption9;
        this.configuration = uGDOConfiguration;
    }

    public CarViewOption getLearningData() {
        return this.learningData;
    }

    public CarViewOption getDeleteButton() {
        return this.deleteButton;
    }

    public CarViewOption getVersionData() {
        return this.versionData;
    }

    public UGDOConfiguration getConfiguration() {
        return this.configuration;
    }

    public CarViewOption getSetFactoryDefault() {
        return this.setFactoryDefault;
    }

    public CarViewOption getDestinationReached() {
        return this.destinationReached;
    }

    public CarViewOption getLearning() {
        return this.learning;
    }

    public CarViewOption getSynchronisation() {
        return this.synchronisation;
    }

    public CarViewOption getOpenDoor() {
        return this.openDoor;
    }

    public CarViewOption getButtonList() {
        return this.buttonList;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(10350);
        stringBuffer.append("UGDOViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("learningData");
        stringBuffer.append('=');
        stringBuffer.append(this.learningData);
        stringBuffer.append(',');
        stringBuffer.append("deleteButton");
        stringBuffer.append('=');
        stringBuffer.append(this.deleteButton);
        stringBuffer.append(',');
        stringBuffer.append("versionData");
        stringBuffer.append('=');
        stringBuffer.append(this.versionData);
        stringBuffer.append(',');
        stringBuffer.append("setFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.setFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("destinationReached");
        stringBuffer.append('=');
        stringBuffer.append(this.destinationReached);
        stringBuffer.append(',');
        stringBuffer.append("learning");
        stringBuffer.append('=');
        stringBuffer.append(this.learning);
        stringBuffer.append(',');
        stringBuffer.append("synchronisation");
        stringBuffer.append('=');
        stringBuffer.append(this.synchronisation);
        stringBuffer.append(',');
        stringBuffer.append("openDoor");
        stringBuffer.append('=');
        stringBuffer.append(this.openDoor);
        stringBuffer.append(',');
        stringBuffer.append("buttonList");
        stringBuffer.append('=');
        stringBuffer.append(this.buttonList);
        stringBuffer.append(',');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

