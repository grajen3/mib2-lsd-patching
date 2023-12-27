/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carseat;

import org.dsi.ifc.carseat.MassageConfig;
import org.dsi.ifc.carseat.VisualizationConfig;

public class SeatPneumaticConfig {
    public boolean driversideLeft;
    public MassageConfig massageConfig1RL;
    public MassageConfig massageConfig1RR;
    public VisualizationConfig visualizationConfig1RL;
    public VisualizationConfig visualizationConfig1RR;

    public SeatPneumaticConfig() {
        this.driversideLeft = false;
        this.massageConfig1RL = null;
        this.massageConfig1RR = null;
        this.visualizationConfig1RL = null;
        this.visualizationConfig1RR = null;
    }

    public SeatPneumaticConfig(boolean bl, MassageConfig massageConfig, MassageConfig massageConfig2, VisualizationConfig visualizationConfig, VisualizationConfig visualizationConfig2) {
        this.driversideLeft = bl;
        this.massageConfig1RL = massageConfig;
        this.massageConfig1RR = massageConfig2;
        this.visualizationConfig1RL = visualizationConfig;
        this.visualizationConfig1RR = visualizationConfig2;
    }

    public boolean isDriversideLeft() {
        return this.driversideLeft;
    }

    public MassageConfig getMassageConfig1RL() {
        return this.massageConfig1RL;
    }

    public MassageConfig getMassageConfig1RR() {
        return this.massageConfig1RR;
    }

    public VisualizationConfig getVisualizationConfig1RL() {
        return this.visualizationConfig1RL;
    }

    public VisualizationConfig getVisualizationConfig1RR() {
        return this.visualizationConfig1RR;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(4250);
        stringBuffer.append("SeatPneumaticConfig");
        stringBuffer.append('(');
        stringBuffer.append("driversideLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.driversideLeft);
        stringBuffer.append(',');
        stringBuffer.append("massageConfig1RL");
        stringBuffer.append('=');
        stringBuffer.append(this.massageConfig1RL);
        stringBuffer.append(',');
        stringBuffer.append("massageConfig1RR");
        stringBuffer.append('=');
        stringBuffer.append(this.massageConfig1RR);
        stringBuffer.append(',');
        stringBuffer.append("visualizationConfig1RL");
        stringBuffer.append('=');
        stringBuffer.append(this.visualizationConfig1RL);
        stringBuffer.append(',');
        stringBuffer.append("visualizationConfig1RR");
        stringBuffer.append('=');
        stringBuffer.append(this.visualizationConfig1RR);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

