/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

import org.dsi.ifc.careco.BCmEConfiguration;
import org.dsi.ifc.global.CarViewOption;

public class BCmEViewOptions {
    public CarViewOption consumerList;
    public CarViewOption consumption;
    public CarViewOption liveTip;
    public CarViewOption energyFlowComfort;
    public CarViewOption rangeGainTotal;
    public CarViewOption consumerListConsumption;
    public CarViewOption consumerListRange;
    public CarViewOption currentRange;
    public CarViewOption bcmeSetFactoryDefault;
    public BCmEConfiguration configuration;
    public CarViewOption currentRangeSOC;
    public CarViewOption catalogueRange;

    public BCmEViewOptions() {
        this.consumerList = null;
        this.consumption = null;
        this.liveTip = null;
        this.energyFlowComfort = null;
        this.rangeGainTotal = null;
        this.consumerListConsumption = null;
        this.consumerListRange = null;
        this.currentRange = null;
        this.bcmeSetFactoryDefault = null;
        this.configuration = null;
        this.currentRangeSOC = null;
        this.catalogueRange = null;
    }

    public BCmEViewOptions(CarViewOption carViewOption, CarViewOption carViewOption2, CarViewOption carViewOption3, CarViewOption carViewOption4, CarViewOption carViewOption5, CarViewOption carViewOption6, CarViewOption carViewOption7, CarViewOption carViewOption8, CarViewOption carViewOption9, BCmEConfiguration bCmEConfiguration, CarViewOption carViewOption10, CarViewOption carViewOption11) {
        this.consumerList = carViewOption;
        this.consumption = carViewOption2;
        this.liveTip = carViewOption3;
        this.energyFlowComfort = carViewOption4;
        this.rangeGainTotal = carViewOption5;
        this.consumerListConsumption = carViewOption6;
        this.consumerListRange = carViewOption7;
        this.currentRange = carViewOption8;
        this.bcmeSetFactoryDefault = carViewOption9;
        this.configuration = bCmEConfiguration;
        this.currentRangeSOC = carViewOption10;
        this.catalogueRange = carViewOption11;
    }

    public CarViewOption getConsumerList() {
        return this.consumerList;
    }

    public CarViewOption getConsumption() {
        return this.consumption;
    }

    public CarViewOption getLiveTip() {
        return this.liveTip;
    }

    public CarViewOption getEnergyFlowComfort() {
        return this.energyFlowComfort;
    }

    public CarViewOption getRangeGainTotal() {
        return this.rangeGainTotal;
    }

    public CarViewOption getConsumerListConsumption() {
        return this.consumerListConsumption;
    }

    public CarViewOption getCurrentRange() {
        return this.currentRange;
    }

    public CarViewOption getConsumerListRange() {
        return this.consumerListRange;
    }

    public CarViewOption getBcmeSetFactoryDefault() {
        return this.bcmeSetFactoryDefault;
    }

    public CarViewOption getCurrentRangeSOC() {
        return this.currentRangeSOC;
    }

    public CarViewOption getCatalogueRange() {
        return this.catalogueRange;
    }

    public BCmEConfiguration getConfiguration() {
        return this.configuration;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(12500);
        stringBuffer.append("BCmEViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("consumerList");
        stringBuffer.append('=');
        stringBuffer.append(this.consumerList);
        stringBuffer.append(',');
        stringBuffer.append("consumption");
        stringBuffer.append('=');
        stringBuffer.append(this.consumption);
        stringBuffer.append(',');
        stringBuffer.append("liveTip");
        stringBuffer.append('=');
        stringBuffer.append(this.liveTip);
        stringBuffer.append(',');
        stringBuffer.append("energyFlowComfort");
        stringBuffer.append('=');
        stringBuffer.append(this.energyFlowComfort);
        stringBuffer.append(',');
        stringBuffer.append("rangeGainTotal");
        stringBuffer.append('=');
        stringBuffer.append(this.rangeGainTotal);
        stringBuffer.append(',');
        stringBuffer.append("consumerListConsumption");
        stringBuffer.append('=');
        stringBuffer.append(this.consumerListConsumption);
        stringBuffer.append(',');
        stringBuffer.append("consumerListRange");
        stringBuffer.append('=');
        stringBuffer.append(this.consumerListRange);
        stringBuffer.append(',');
        stringBuffer.append("currentRange");
        stringBuffer.append('=');
        stringBuffer.append(this.currentRange);
        stringBuffer.append(',');
        stringBuffer.append("bcmeSetFactoryDefault");
        stringBuffer.append('=');
        stringBuffer.append(this.bcmeSetFactoryDefault);
        stringBuffer.append(',');
        stringBuffer.append("configuration");
        stringBuffer.append('=');
        stringBuffer.append(this.configuration);
        stringBuffer.append(',');
        stringBuffer.append("currentRangeSOC");
        stringBuffer.append('=');
        stringBuffer.append(this.currentRangeSOC);
        stringBuffer.append(',');
        stringBuffer.append("catalogueRange");
        stringBuffer.append('=');
        stringBuffer.append(this.catalogueRange);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

