/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

import org.dsi.ifc.cardrivingcharacteristics.TADConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class TADViewOptions {
    public CarViewOption maxMinAnglesReset;
    public TADConfiguration configuration;
    public CarViewOption angleDisplay;

    public TADViewOptions() {
        this.maxMinAnglesReset = null;
        this.configuration = null;
        this.angleDisplay = null;
    }

    public TADViewOptions(CarViewOption carViewOption, TADConfiguration tADConfiguration, CarViewOption carViewOption2) {
        this.maxMinAnglesReset = carViewOption;
        this.configuration = tADConfiguration;
        this.angleDisplay = carViewOption2;
    }

    public CarViewOption getMaxMinAnglesReset() {
        return this.maxMinAnglesReset;
    }

    public CarViewOption getAngleDisplay() {
        return this.angleDisplay;
    }

    public TADConfiguration getConfiguration() {
        return this.configuration;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3150);
        stringBuffer.append("TADViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("maxMinAnglesReset");
        stringBuffer.append('=');
        stringBuffer.append(this.maxMinAnglesReset);
        stringBuffer.append(',');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(',');
        stringBuffer.append("angleDisplay");
        stringBuffer.append('=');
        stringBuffer.append(this.angleDisplay);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

