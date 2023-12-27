/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

import org.dsi.ifc.cardriverassistance.ACCAvailableDrivingPrograms;

public class ACCConfiguration {
    public ACCAvailableDrivingPrograms drivingPrograms;

    public ACCConfiguration() {
        this.drivingPrograms = null;
    }

    public ACCConfiguration(ACCAvailableDrivingPrograms aCCAvailableDrivingPrograms) {
        this.drivingPrograms = aCCAvailableDrivingPrograms;
    }

    public ACCAvailableDrivingPrograms getDrivingPrograms() {
        return this.drivingPrograms;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1050);
        stringBuffer.append("ACCConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("drivingPrograms");
        stringBuffer.append('=');
        stringBuffer.append(this.drivingPrograms);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

