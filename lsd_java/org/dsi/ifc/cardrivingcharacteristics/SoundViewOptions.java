/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

import org.dsi.ifc.cardrivingcharacteristics.SoundConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class SoundViewOptions {
    public SoundConfiguration configuration;
    public CarViewOption setFactoryDefault;
    public CarViewOption systemOnOff;
    public CarViewOption soundOnOff;
    public CarViewOption style;

    public SoundViewOptions() {
        this.configuration = null;
        this.setFactoryDefault = null;
        this.systemOnOff = null;
        this.soundOnOff = null;
        this.style = null;
    }

    public SoundViewOptions(SoundConfiguration soundConfiguration, CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4) {
        this.configuration = soundConfiguration;
        this.setFactoryDefault = carViewOption;
        this.systemOnOff = carViewOption2;
        this.soundOnOff = carViewOption3;
        this.style = carViewOption4;
    }

    public SoundConfiguration getConfiguration() {
        return this.configuration;
    }

    public CarViewOption getSetFactoryDefault() {
        return this.setFactoryDefault;
    }

    public CarViewOption getSystemOnOff() {
        return this.systemOnOff;
    }

    public CarViewOption getSoundOnOff() {
        return this.soundOnOff;
    }

    public CarViewOption getStyle() {
        return this.style;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(5200);
        stringBuffer.append("SoundViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(',');
        stringBuffer.append("setFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.setFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("systemOnOff");
        stringBuffer.append('=');
        stringBuffer.append(this.systemOnOff);
        stringBuffer.append(',');
        stringBuffer.append("soundOnOff");
        stringBuffer.append('=');
        stringBuffer.append(this.soundOnOff);
        stringBuffer.append(',');
        stringBuffer.append("style");
        stringBuffer.append('=');
        stringBuffer.append(this.style);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

