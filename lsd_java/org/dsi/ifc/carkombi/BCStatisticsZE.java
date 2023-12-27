/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.carkombi.BCCounter;
import org.dsi.ifc.carkombi.BCZeroEmissionRelative;

public class BCStatisticsZE {
    public BCCounter tripCounter;
    public BCCounter valueCounter;
    public BCZeroEmissionRelative zeroEmissionRelative;

    public BCStatisticsZE() {
        this.tripCounter = null;
        this.valueCounter = null;
        this.zeroEmissionRelative = null;
    }

    public BCStatisticsZE(BCCounter bCCounter, BCCounter bCCounter2, BCZeroEmissionRelative bCZeroEmissionRelative) {
        this.tripCounter = bCCounter;
        this.valueCounter = bCCounter2;
        this.zeroEmissionRelative = bCZeroEmissionRelative;
    }

    public BCCounter getTripCounter() {
        return this.tripCounter;
    }

    public BCCounter getValueCounter() {
        return this.valueCounter;
    }

    public BCZeroEmissionRelative getZeroEmissionRelative() {
        return this.zeroEmissionRelative;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3150);
        stringBuffer.append("BCStatisticsZE");
        stringBuffer.append('(');
        stringBuffer.append("tripCounter");
        stringBuffer.append('=');
        stringBuffer.append(this.tripCounter);
        stringBuffer.append(',');
        stringBuffer.append("valueCounter");
        stringBuffer.append('=');
        stringBuffer.append(this.valueCounter);
        stringBuffer.append(',');
        stringBuffer.append("zeroEmissionRelative");
        stringBuffer.append('=');
        stringBuffer.append(this.zeroEmissionRelative);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

