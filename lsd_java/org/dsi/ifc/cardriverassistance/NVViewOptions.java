/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

import org.dsi.ifc.cardriverassistance.NVConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class NVViewOptions {
    public CarViewOption activation;
    public CarViewOption contrast;
    public CarViewOption brightness;
    public CarViewOption objectDetection;
    public CarViewOption colorPA;
    public CarViewOption designPA;
    public CarViewOption display;
    public CarViewOption zoomPanning;
    public CarViewOption sound;
    public CarViewOption symbol;
    public NVConfiguration configuration;
    public CarViewOption system;
    public CarViewOption setFactoryDefault;
    public CarViewOption warningTimegap;

    public NVViewOptions() {
        this.activation = null;
        this.contrast = null;
        this.brightness = null;
        this.objectDetection = null;
        this.colorPA = null;
        this.designPA = null;
        this.display = null;
        this.zoomPanning = null;
        this.sound = null;
        this.symbol = null;
        this.configuration = null;
        this.system = null;
        this.setFactoryDefault = null;
        this.warningTimegap = null;
    }

    public NVViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, CarViewOption carViewOption10, NVConfiguration nVConfiguration, CarViewOption carViewOption11, CarViewOption carViewOption12, CarViewOption carViewOption13) {
        this.activation = carViewOption;
        this.contrast = carViewOption2;
        this.brightness = carViewOption3;
        this.objectDetection = carViewOption4;
        this.colorPA = carViewOption5;
        this.designPA = carViewOption6;
        this.display = carViewOption7;
        this.zoomPanning = carViewOption8;
        this.sound = carViewOption9;
        this.symbol = carViewOption10;
        this.configuration = nVConfiguration;
        this.system = carViewOption11;
        this.setFactoryDefault = carViewOption12;
        this.warningTimegap = carViewOption13;
    }

    public CarViewOption getActivation() {
        return this.activation;
    }

    public CarViewOption getContrast() {
        return this.contrast;
    }

    public CarViewOption getBrightness() {
        return this.brightness;
    }

    public CarViewOption getObjectDetection() {
        return this.objectDetection;
    }

    public CarViewOption getColorPA() {
        return this.colorPA;
    }

    public CarViewOption getDesignPA() {
        return this.designPA;
    }

    public CarViewOption getDisplay() {
        return this.display;
    }

    public CarViewOption getZoomPanning() {
        return this.zoomPanning;
    }

    public CarViewOption getSound() {
        return this.sound;
    }

    public CarViewOption getSymbol() {
        return this.symbol;
    }

    public NVConfiguration getConfiguration() {
        return this.configuration;
    }

    public CarViewOption getSystem() {
        return this.system;
    }

    public CarViewOption getSetFactoryDefault() {
        return this.setFactoryDefault;
    }

    public CarViewOption getWarningTimegap() {
        return this.warningTimegap;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(14450);
        stringBuffer.append("NVViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("activation");
        stringBuffer.append('=');
        stringBuffer.append(this.activation);
        stringBuffer.append(',');
        stringBuffer.append("contrast");
        stringBuffer.append('=');
        stringBuffer.append(this.contrast);
        stringBuffer.append(',');
        stringBuffer.append("brightness");
        stringBuffer.append('=');
        stringBuffer.append(this.brightness);
        stringBuffer.append(',');
        stringBuffer.append("objectDetection");
        stringBuffer.append('=');
        stringBuffer.append(this.objectDetection);
        stringBuffer.append(',');
        stringBuffer.append("colorPA");
        stringBuffer.append('=');
        stringBuffer.append(this.colorPA);
        stringBuffer.append(',');
        stringBuffer.append("designPA");
        stringBuffer.append('=');
        stringBuffer.append(this.designPA);
        stringBuffer.append(',');
        stringBuffer.append("display");
        stringBuffer.append('=');
        stringBuffer.append(this.display);
        stringBuffer.append(',');
        stringBuffer.append("zoomPanning");
        stringBuffer.append('=');
        stringBuffer.append(this.zoomPanning);
        stringBuffer.append(',');
        stringBuffer.append("sound");
        stringBuffer.append('=');
        stringBuffer.append(this.sound);
        stringBuffer.append(',');
        stringBuffer.append("symbol");
        stringBuffer.append('=');
        stringBuffer.append(this.symbol);
        stringBuffer.append(',');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(',');
        stringBuffer.append("system");
        stringBuffer.append('=');
        stringBuffer.append(this.system);
        stringBuffer.append(',');
        stringBuffer.append("setFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.setFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("warningTimegap");
        stringBuffer.append('=');
        stringBuffer.append(this.warningTimegap);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

