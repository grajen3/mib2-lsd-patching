/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.carkombi.BCAverageRecoveredEnergy;
import org.dsi.ifc.carkombi.BCCounter;

public class BCStatisticsRE {
    public BCCounter tripCounter;
    public BCCounter valueCounter;
    public BCAverageRecoveredEnergy averageRecoveredEnergy;

    public BCStatisticsRE() {
        this.tripCounter = null;
        this.valueCounter = null;
        this.averageRecoveredEnergy = null;
    }

    public BCStatisticsRE(BCCounter bCCounter, BCCounter bCCounter2, BCAverageRecoveredEnergy bCAverageRecoveredEnergy) {
        this.tripCounter = bCCounter;
        this.valueCounter = bCCounter2;
        this.averageRecoveredEnergy = bCAverageRecoveredEnergy;
    }

    public BCCounter getTripCounter() {
        return this.tripCounter;
    }

    public BCCounter getValueCounter() {
        return this.valueCounter;
    }

    public BCAverageRecoveredEnergy getAverageRecoveredEnergy() {
        return this.averageRecoveredEnergy;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3150);
        stringBuffer.append("BCStatisticsRE");
        stringBuffer.append('(');
        stringBuffer.append("tripCounter");
        stringBuffer.append('=');
        stringBuffer.append(this.tripCounter);
        stringBuffer.append(',');
        stringBuffer.append("valueCounter");
        stringBuffer.append('=');
        stringBuffer.append(this.valueCounter);
        stringBuffer.append(',');
        stringBuffer.append("averageRecoveredEnergy");
        stringBuffer.append('=');
        stringBuffer.append(this.averageRecoveredEnergy);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

