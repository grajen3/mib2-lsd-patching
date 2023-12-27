/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

import org.dsi.ifc.carhybrid.HybridConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class HybridViewOptions {
    public CarViewOption hybridEnergyFlowState;
    public CarViewOption hybridCharge;
    public CarViewOption hybridRecoveredEnergy;
    public CarViewOption hybridEnergyFlow;
    public HybridConfiguration hybridConfiguration;
    public CarViewOption hybridTargetRange;
    public CarViewOption hybridEnergyAssistControl;
    public CarViewOption hybridEnergyAssistState;
    public CarViewOption hybridActivePedal;
    public CarViewOption hybridInhibitReason;

    public HybridViewOptions() {
        this.hybridEnergyFlowState = null;
        this.hybridCharge = null;
        this.hybridRecoveredEnergy = null;
        this.hybridEnergyFlow = null;
        this.hybridConfiguration = null;
        this.hybridTargetRange = null;
        this.hybridEnergyAssistControl = null;
        this.hybridEnergyAssistState = null;
        this.hybridActivePedal = null;
        this.hybridInhibitReason = null;
    }

    public HybridViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, HybridConfiguration hybridConfiguration, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7) {
        this.hybridEnergyFlowState = carViewOption;
        this.hybridCharge = carViewOption2;
        this.hybridRecoveredEnergy = carViewOption3;
        this.hybridEnergyFlow = carViewOption4;
        this.hybridConfiguration = hybridConfiguration;
        this.hybridTargetRange = carViewOption5;
        this.hybridEnergyAssistControl = carViewOption6;
        this.hybridEnergyAssistState = carViewOption7;
        this.hybridActivePedal = null;
        this.hybridInhibitReason = null;
    }

    public HybridViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, HybridConfiguration hybridConfiguration, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9) {
        this.hybridEnergyFlowState = carViewOption;
        this.hybridCharge = carViewOption2;
        this.hybridRecoveredEnergy = carViewOption3;
        this.hybridEnergyFlow = carViewOption4;
        this.hybridConfiguration = hybridConfiguration;
        this.hybridTargetRange = carViewOption5;
        this.hybridEnergyAssistControl = carViewOption6;
        this.hybridEnergyAssistState = carViewOption7;
        this.hybridActivePedal = carViewOption8;
        this.hybridInhibitReason = carViewOption9;
    }

    public CarViewOption getHybridEnergyFlowState() {
        return this.hybridEnergyFlowState;
    }

    public CarViewOption getHybridCharge() {
        return this.hybridCharge;
    }

    public CarViewOption getHybridRecoveredEnergy() {
        return this.hybridRecoveredEnergy;
    }

    public CarViewOption getHybridEnergyFlow() {
        return this.hybridEnergyFlow;
    }

    public HybridConfiguration getHybridConfiguration() {
        return this.hybridConfiguration;
    }

    public CarViewOption getHybridTargetRange() {
        return this.hybridTargetRange;
    }

    public CarViewOption getHybridEnergyAssistControl() {
        return this.hybridEnergyAssistControl;
    }

    public CarViewOption getHybridEnergyAssistState() {
        return this.hybridEnergyAssistState;
    }

    public CarViewOption getHybridActivePedal() {
        return this.hybridActivePedal;
    }

    public CarViewOption getHybridInhibitReason() {
        return this.hybridInhibitReason;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(10500);
        stringBuffer.append("HybridViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("hybridEnergyFlowState");
        stringBuffer.append('=');
        stringBuffer.append(this.hybridEnergyFlowState);
        stringBuffer.append(',');
        stringBuffer.append("hybridCharge");
        stringBuffer.append('=');
        stringBuffer.append(this.hybridCharge);
        stringBuffer.append(',');
        stringBuffer.append("hybridRecoveredEnergy");
        stringBuffer.append('=');
        stringBuffer.append(this.hybridRecoveredEnergy);
        stringBuffer.append(',');
        stringBuffer.append("hybridEnergyFlow");
        stringBuffer.append('=');
        stringBuffer.append(this.hybridEnergyFlow);
        stringBuffer.append(',');
        stringBuffer.append("hybridConfiguration");
        stringBuffer.append('=');
        stringBuffer.append(this.hybridConfiguration);
        stringBuffer.append(',');
        stringBuffer.append("hybridTargetRange");
        stringBuffer.append('=');
        stringBuffer.append(this.hybridTargetRange);
        stringBuffer.append(',');
        stringBuffer.append("hybridEnergyAssistControl");
        stringBuffer.append('=');
        stringBuffer.append(this.hybridEnergyAssistControl);
        stringBuffer.append(',');
        stringBuffer.append("hybridEnergyAssistState");
        stringBuffer.append('=');
        stringBuffer.append(this.hybridEnergyAssistState);
        stringBuffer.append(',');
        stringBuffer.append("hybridActivePedal");
        stringBuffer.append('=');
        stringBuffer.append(this.hybridActivePedal);
        stringBuffer.append(',');
        stringBuffer.append("hybridInhibitReason");
        stringBuffer.append('=');
        stringBuffer.append(this.hybridInhibitReason);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

