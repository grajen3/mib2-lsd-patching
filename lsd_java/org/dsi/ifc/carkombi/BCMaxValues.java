/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.global.CarBCAcceleration;
import org.dsi.ifc.global.CarBCSpeed;

public class BCMaxValues {
    public CarBCAcceleration maxLeftLateralAcceleration;
    public CarBCAcceleration maxRightLateralAcceleration;
    public CarBCAcceleration maxPosLongitudinalAcceleration;
    public CarBCAcceleration maxNegLongitudinalAcceleration;
    public CarBCSpeed maxSpeed;

    public BCMaxValues() {
        this.maxLeftLateralAcceleration = null;
        this.maxRightLateralAcceleration = null;
        this.maxPosLongitudinalAcceleration = null;
        this.maxNegLongitudinalAcceleration = null;
        this.maxSpeed = null;
    }

    public BCMaxValues(CarBCAcceleration carBCAcceleration, CarBCAcceleration carBCAcceleration2, CarBCAcceleration carBCAcceleration3, CarBCAcceleration carBCAcceleration4, CarBCSpeed carBCSpeed) {
        this.maxLeftLateralAcceleration = carBCAcceleration;
        this.maxRightLateralAcceleration = carBCAcceleration2;
        this.maxPosLongitudinalAcceleration = carBCAcceleration3;
        this.maxNegLongitudinalAcceleration = carBCAcceleration4;
        this.maxSpeed = carBCSpeed;
    }

    public CarBCAcceleration getMaxLeftLateralAcceleration() {
        return this.maxLeftLateralAcceleration;
    }

    public CarBCAcceleration getMaxRightLateralAcceleration() {
        return this.maxRightLateralAcceleration;
    }

    public CarBCAcceleration getMaxPosLongitudinalAcceleration() {
        return this.maxPosLongitudinalAcceleration;
    }

    public CarBCAcceleration getMaxNegLongitudinalAcceleration() {
        return this.maxNegLongitudinalAcceleration;
    }

    public CarBCSpeed getMaxSpeed() {
        return this.maxSpeed;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(5300);
        stringBuffer.append("BCMaxValues");
        stringBuffer.append('(');
        stringBuffer.append("maxLeftLateralAcceleration");
        stringBuffer.append('=');
        stringBuffer.append(this.maxLeftLateralAcceleration);
        stringBuffer.append(',');
        stringBuffer.append("maxRightLateralAcceleration");
        stringBuffer.append('=');
        stringBuffer.append(this.maxRightLateralAcceleration);
        stringBuffer.append(',');
        stringBuffer.append("maxPosLongitudinalAcceleration");
        stringBuffer.append('=');
        stringBuffer.append(this.maxPosLongitudinalAcceleration);
        stringBuffer.append(',');
        stringBuffer.append("maxNegLongitudinalAcceleration");
        stringBuffer.append('=');
        stringBuffer.append(this.maxNegLongitudinalAcceleration);
        stringBuffer.append(',');
        stringBuffer.append("maxSpeed");
        stringBuffer.append('=');
        stringBuffer.append(this.maxSpeed);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

