/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.global.CarBCConsumption;

public class BCComfortPowerConsumption {
    public CarBCConsumption comfortConsumptionST;
    public CarBCConsumption comfortConsumptionLT;
    public CarBCConsumption comfortConsumptionCY;

    public BCComfortPowerConsumption() {
        this.comfortConsumptionST = null;
        this.comfortConsumptionLT = null;
        this.comfortConsumptionCY = null;
    }

    public BCComfortPowerConsumption(CarBCConsumption carBCConsumption, CarBCConsumption carBCConsumption2, CarBCConsumption carBCConsumption3) {
        this.comfortConsumptionST = carBCConsumption;
        this.comfortConsumptionLT = carBCConsumption2;
        this.comfortConsumptionCY = carBCConsumption3;
    }

    public CarBCConsumption getComfortConsumptionST() {
        return this.comfortConsumptionST;
    }

    public CarBCConsumption getComfortConsumptionLT() {
        return this.comfortConsumptionLT;
    }

    public CarBCConsumption getComfortConsumptionCY() {
        return this.comfortConsumptionCY;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3200);
        stringBuffer.append("BCComfortPowerConsumption");
        stringBuffer.append('(');
        stringBuffer.append("comfortConsumptionST");
        stringBuffer.append('=');
        stringBuffer.append(this.comfortConsumptionST);
        stringBuffer.append(',');
        stringBuffer.append("comfortConsumptionLT");
        stringBuffer.append('=');
        stringBuffer.append(this.comfortConsumptionLT);
        stringBuffer.append(',');
        stringBuffer.append("comfortConsumptionCY");
        stringBuffer.append('=');
        stringBuffer.append(this.comfortConsumptionCY);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

