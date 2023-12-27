/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.global.CarBCDistance;
import org.dsi.ifc.global.CarBCSpeed;
import org.dsi.ifc.global.CarBCTime;

public class BCLongTermGeneralData {
    public CarBCDistance distance;
    public CarBCSpeed speed;
    public CarBCTime timeValue;

    public BCLongTermGeneralData() {
        this.distance = null;
        this.speed = null;
        this.timeValue = null;
    }

    public BCLongTermGeneralData(CarBCDistance carBCDistance, CarBCSpeed carBCSpeed, CarBCTime carBCTime) {
        this.distance = carBCDistance;
        this.speed = carBCSpeed;
        this.timeValue = carBCTime;
    }

    public CarBCDistance getDistance() {
        return this.distance;
    }

    public CarBCSpeed getSpeed() {
        return this.speed;
    }

    public CarBCTime getTimeValue() {
        return this.timeValue;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3100);
        stringBuffer.append("BCLongTermGeneralData");
        stringBuffer.append('(');
        stringBuffer.append("distance");
        stringBuffer.append('=');
        stringBuffer.append(this.distance);
        stringBuffer.append(',');
        stringBuffer.append("speed");
        stringBuffer.append('=');
        stringBuffer.append(this.speed);
        stringBuffer.append(',');
        stringBuffer.append("timeValue");
        stringBuffer.append('=');
        stringBuffer.append(this.timeValue);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

