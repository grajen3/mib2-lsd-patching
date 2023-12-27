/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.carkombi.BCCounter;
import org.dsi.ifc.global.CarBCConsumption;

public class BCStatisticsAC {
    public BCCounter tripCounter;
    public BCCounter valueCounter;
    public CarBCConsumption averageConsumption;

    public BCStatisticsAC() {
        this.tripCounter = null;
        this.valueCounter = null;
        this.averageConsumption = null;
    }

    public BCStatisticsAC(BCCounter bCCounter, BCCounter bCCounter2, CarBCConsumption carBCConsumption) {
        this.tripCounter = bCCounter;
        this.valueCounter = bCCounter2;
        this.averageConsumption = carBCConsumption;
    }

    public BCCounter getTripCounter() {
        return this.tripCounter;
    }

    public BCCounter getValueCounter() {
        return this.valueCounter;
    }

    public CarBCConsumption getAverageConsumption() {
        return this.averageConsumption;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3150);
        stringBuffer.append("BCStatisticsAC");
        stringBuffer.append('(');
        stringBuffer.append("tripCounter");
        stringBuffer.append('=');
        stringBuffer.append(this.tripCounter);
        stringBuffer.append(',');
        stringBuffer.append("valueCounter");
        stringBuffer.append('=');
        stringBuffer.append(this.valueCounter);
        stringBuffer.append(',');
        stringBuffer.append("averageConsumption");
        stringBuffer.append('=');
        stringBuffer.append(this.averageConsumption);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

