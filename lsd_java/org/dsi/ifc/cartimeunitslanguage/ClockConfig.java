/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cartimeunitslanguage;

import org.dsi.ifc.cartimeunitslanguage.ClockSources;

public class ClockConfig {
    public int dayLightSavingMode;
    public ClockSources timeSourcesInstallation;

    public ClockConfig() {
        this.dayLightSavingMode = 0;
        this.timeSourcesInstallation = null;
    }

    public ClockConfig(int n, ClockSources clockSources) {
        this.dayLightSavingMode = n;
        this.timeSourcesInstallation = clockSources;
    }

    public int getDayLightSavingMode() {
        return this.dayLightSavingMode;
    }

    public ClockSources getTimeSourcesInstallation() {
        return this.timeSourcesInstallation;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1150);
        stringBuffer.append("ClockConfig");
        stringBuffer.append('(');
        stringBuffer.append("dayLightSavingMode");
        stringBuffer.append('=');
        stringBuffer.append(this.dayLightSavingMode);
        stringBuffer.append(',');
        stringBuffer.append("timeSourcesInstallation");
        stringBuffer.append('=');
        stringBuffer.append(this.timeSourcesInstallation);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

