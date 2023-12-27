/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carvehiclestates;

public class SemiStaticVehicleData {
    public float maxChargingAirPressure;
    public int maxOutputPower;
    public int maxTorque;
    public float engineDisplacement;
    public int typeOfInjectionSystem;

    public SemiStaticVehicleData() {
        this.maxChargingAirPressure = 0.0f;
        this.maxOutputPower = 0;
        this.maxTorque = 0;
        this.engineDisplacement = 0.0f;
        this.typeOfInjectionSystem = 0;
    }

    public SemiStaticVehicleData(float f2, int n) {
        this.maxChargingAirPressure = f2;
        this.maxOutputPower = n;
        this.maxTorque = 0;
        this.engineDisplacement = 0.0f;
        this.typeOfInjectionSystem = 0;
    }

    public SemiStaticVehicleData(float f2, int n, int n2) {
        this.maxChargingAirPressure = f2;
        this.maxOutputPower = n;
        this.maxTorque = n2;
        this.engineDisplacement = 0.0f;
        this.typeOfInjectionSystem = 0;
    }

    public SemiStaticVehicleData(float f2, int n, int n2, float f3, int n3) {
        this.maxChargingAirPressure = f2;
        this.maxOutputPower = n;
        this.maxTorque = n2;
        this.engineDisplacement = f3;
        this.typeOfInjectionSystem = n3;
    }

    public float getMaxChargingAirPressure() {
        return this.maxChargingAirPressure;
    }

    public int getMaxOutputPower() {
        return this.maxOutputPower;
    }

    public int getMaxTorque() {
        return this.maxTorque;
    }

    public float getEngineDisplacement() {
        return this.engineDisplacement;
    }

    public int getTypeOfInjectionSystem() {
        return this.typeOfInjectionSystem;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(350);
        stringBuffer.append("SemiStaticVehicleData");
        stringBuffer.append('(');
        stringBuffer.append("maxChargingAirPressure");
        stringBuffer.append('=');
        stringBuffer.append(this.maxChargingAirPressure);
        stringBuffer.append(',');
        stringBuffer.append("maxOutputPower");
        stringBuffer.append('=');
        stringBuffer.append(this.maxOutputPower);
        stringBuffer.append(',');
        stringBuffer.append("maxTorque");
        stringBuffer.append('=');
        stringBuffer.append(this.maxTorque);
        stringBuffer.append(',');
        stringBuffer.append("engineDisplacement");
        stringBuffer.append('=');
        stringBuffer.append(this.engineDisplacement);
        stringBuffer.append(',');
        stringBuffer.append("typeOfInjectionSystem");
        stringBuffer.append('=');
        stringBuffer.append(this.typeOfInjectionSystem);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

