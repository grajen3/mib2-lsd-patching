/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.carkombi.HUDConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class HUDViewOptions {
    public CarViewOption heightAdjustment;
    public CarViewOption brightness;
    public CarViewOption content;
    public CarViewOption rotationAdjustment;
    public CarViewOption colour;
    public CarViewOption setFactoryDefault;
    public CarViewOption systemOnOff;
    public HUDConfiguration configuration;
    public CarViewOption license;

    public HUDViewOptions() {
        this.heightAdjustment = null;
        this.brightness = null;
        this.content = null;
        this.rotationAdjustment = null;
        this.colour = null;
        this.setFactoryDefault = null;
        this.systemOnOff = null;
        this.configuration = null;
        this.license = null;
    }

    public HUDViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, HUDConfiguration hUDConfiguration) {
        this.heightAdjustment = carViewOption;
        this.brightness = carViewOption2;
        this.content = carViewOption3;
        this.rotationAdjustment = carViewOption4;
        this.colour = carViewOption5;
        this.setFactoryDefault = carViewOption6;
        this.systemOnOff = carViewOption7;
        this.configuration = hUDConfiguration;
        this.license = null;
    }

    public HUDViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, HUDConfiguration hUDConfiguration, CarViewOption carViewOption8) {
        this.heightAdjustment = carViewOption;
        this.brightness = carViewOption2;
        this.content = carViewOption3;
        this.rotationAdjustment = carViewOption4;
        this.colour = carViewOption5;
        this.setFactoryDefault = carViewOption6;
        this.systemOnOff = carViewOption7;
        this.configuration = hUDConfiguration;
        this.license = carViewOption8;
    }

    public CarViewOption getHeightAdjustment() {
        return this.heightAdjustment;
    }

    public CarViewOption getBrightness() {
        return this.brightness;
    }

    public CarViewOption getContent() {
        return this.content;
    }

    public CarViewOption getRotationAdjustment() {
        return this.rotationAdjustment;
    }

    public CarViewOption getColour() {
        return this.colour;
    }

    public CarViewOption getSetFactoryDefault() {
        return this.setFactoryDefault;
    }

    public CarViewOption getSystemOnOff() {
        return this.systemOnOff;
    }

    public HUDConfiguration getConfiguration() {
        return this.configuration;
    }

    public CarViewOption getLicense() {
        return this.license;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(9350);
        stringBuffer.append("HUDViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("heightAdjustment");
        stringBuffer.append('=');
        stringBuffer.append(this.heightAdjustment);
        stringBuffer.append(',');
        stringBuffer.append("brightness");
        stringBuffer.append('=');
        stringBuffer.append(this.brightness);
        stringBuffer.append(',');
        stringBuffer.append("content");
        stringBuffer.append('=');
        stringBuffer.append(this.content);
        stringBuffer.append(',');
        stringBuffer.append("rotationAdjustment");
        stringBuffer.append('=');
        stringBuffer.append(this.rotationAdjustment);
        stringBuffer.append(',');
        stringBuffer.append("colour");
        stringBuffer.append('=');
        stringBuffer.append(this.colour);
        stringBuffer.append(',');
        stringBuffer.append("setFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.setFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("systemOnOff");
        stringBuffer.append('=');
        stringBuffer.append(this.systemOnOff);
        stringBuffer.append(',');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(',');
        stringBuffer.append("license");
        stringBuffer.append('=');
        stringBuffer.append(this.license);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

