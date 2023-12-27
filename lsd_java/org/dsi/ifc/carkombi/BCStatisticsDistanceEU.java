/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.carkombi.BCCounter;
import org.dsi.ifc.global.CarBCDistance;

public class BCStatisticsDistanceEU {
    public BCCounter valueCounter = null;
    public CarBCDistance distancePrimary = null;
    public CarBCDistance distanceSecondary = null;
    public CarBCDistance distanceEfficiency = null;

    public BCStatisticsDistanceEU() {
    }

    public BCStatisticsDistanceEU(BCCounter bCCounter, CarBCDistance carBCDistance, CarBCDistance carBCDistance2, CarBCDistance carBCDistance3) {
    }

    public BCCounter getValueCounter() {
        return this.valueCounter;
    }

    public CarBCDistance getDistancePrimary() {
        return this.distancePrimary;
    }

    public CarBCDistance getDistanceSecondary() {
        return this.distanceSecondary;
    }

    public CarBCDistance getDistanceEfficiency() {
        return this.distanceEfficiency;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(4200);
        stringBuffer.append("BCStatisticsDistanceEU");
        stringBuffer.append('(');
        stringBuffer.append("valueCounter");
        stringBuffer.append('=');
        stringBuffer.append(this.valueCounter);
        stringBuffer.append(',');
        stringBuffer.append("distancePrimary");
        stringBuffer.append('=');
        stringBuffer.append(this.distancePrimary);
        stringBuffer.append(',');
        stringBuffer.append("distanceSecondary");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceSecondary);
        stringBuffer.append(',');
        stringBuffer.append("distanceEfficiency");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceEfficiency);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

