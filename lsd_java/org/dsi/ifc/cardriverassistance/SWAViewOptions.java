/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

import org.dsi.ifc.cardriverassistance.SWAConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class SWAViewOptions {
    public CarViewOption brightness;
    public CarViewOption warningTime;
    public CarViewOption frequence;
    public CarViewOption system;
    public CarViewOption gongState;
    public CarViewOption gongVolume;
    public CarViewOption rcta;
    public CarViewOption exitAssist;
    public SWAConfiguration configuration;

    public SWAViewOptions() {
        this.brightness = null;
        this.warningTime = null;
        this.frequence = null;
        this.system = null;
        this.gongState = null;
        this.gongVolume = null;
        this.rcta = null;
        this.exitAssist = null;
        this.configuration = null;
    }

    public SWAViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, SWAConfiguration sWAConfiguration) {
        this.brightness = carViewOption;
        this.warningTime = carViewOption2;
        this.frequence = carViewOption3;
        this.system = carViewOption4;
        this.gongState = carViewOption5;
        this.gongVolume = carViewOption6;
        this.rcta = carViewOption7;
        this.exitAssist = carViewOption8;
        this.configuration = sWAConfiguration;
    }

    public CarViewOption getBrightness() {
        return this.brightness;
    }

    public CarViewOption getWarningTime() {
        return this.warningTime;
    }

    public CarViewOption getFrequence() {
        return this.frequence;
    }

    public CarViewOption getSystem() {
        return this.system;
    }

    public CarViewOption getGongState() {
        return this.gongState;
    }

    public CarViewOption getGongVolume() {
        return this.gongVolume;
    }

    public CarViewOption getRcta() {
        return this.rcta;
    }

    public CarViewOption getExitAssist() {
        return this.exitAssist;
    }

    public SWAConfiguration getConfiguration() {
        return this.configuration;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(9300);
        stringBuffer.append("SWAViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("brightness");
        stringBuffer.append('=');
        stringBuffer.append(this.brightness);
        stringBuffer.append(',');
        stringBuffer.append("warningTime");
        stringBuffer.append('=');
        stringBuffer.append(this.warningTime);
        stringBuffer.append(',');
        stringBuffer.append("frequence");
        stringBuffer.append('=');
        stringBuffer.append(this.frequence);
        stringBuffer.append(',');
        stringBuffer.append("system");
        stringBuffer.append('=');
        stringBuffer.append(this.system);
        stringBuffer.append(',');
        stringBuffer.append("gongState");
        stringBuffer.append('=');
        stringBuffer.append(this.gongState);
        stringBuffer.append(',');
        stringBuffer.append("gongVolume");
        stringBuffer.append('=');
        stringBuffer.append(this.gongVolume);
        stringBuffer.append(',');
        stringBuffer.append("rcta");
        stringBuffer.append('=');
        stringBuffer.append(this.rcta);
        stringBuffer.append(',');
        stringBuffer.append("exitAssist");
        stringBuffer.append('=');
        stringBuffer.append(this.exitAssist);
        stringBuffer.append(',');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

