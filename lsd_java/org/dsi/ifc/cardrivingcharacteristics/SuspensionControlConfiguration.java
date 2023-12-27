/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlAdditionalFunctions;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlAirProfiles;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlDRCProfiles;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlLevels;

public class SuspensionControlConfiguration {
    public int deviceType;
    public int modelType;
    public SuspensionControlAirProfiles airProfileAvailability;
    public SuspensionControlDRCProfiles drcProfileAvailability;
    public SuspensionControlAdditionalFunctions additionalFunctionsAvailability;
    public SuspensionControlLevels levelsAvailability;

    public SuspensionControlConfiguration() {
        this.deviceType = 0;
        this.modelType = 0;
        this.airProfileAvailability = null;
        this.drcProfileAvailability = null;
        this.additionalFunctionsAvailability = null;
        this.levelsAvailability = null;
    }

    public SuspensionControlConfiguration(int n, int n2, SuspensionControlAirProfiles suspensionControlAirProfiles, SuspensionControlDRCProfiles suspensionControlDRCProfiles, SuspensionControlAdditionalFunctions suspensionControlAdditionalFunctions, SuspensionControlLevels suspensionControlLevels) {
        this.deviceType = n;
        this.modelType = n2;
        this.airProfileAvailability = suspensionControlAirProfiles;
        this.drcProfileAvailability = suspensionControlDRCProfiles;
        this.additionalFunctionsAvailability = suspensionControlAdditionalFunctions;
        this.levelsAvailability = suspensionControlLevels;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public int getModelType() {
        return this.modelType;
    }

    public SuspensionControlAirProfiles getAirProfileAvailability() {
        return this.airProfileAvailability;
    }

    public SuspensionControlDRCProfiles getDrcProfileAvailability() {
        return this.drcProfileAvailability;
    }

    public SuspensionControlAdditionalFunctions getAdditionalFunctionsAvailability() {
        return this.additionalFunctionsAvailability;
    }

    public SuspensionControlLevels getLevelsAvailability() {
        return this.levelsAvailability;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(4350);
        stringBuffer.append("SuspensionControlConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("deviceType");
        stringBuffer.append('=');
        stringBuffer.append(this.deviceType);
        stringBuffer.append(',');
        stringBuffer.append("modelType");
        stringBuffer.append('=');
        stringBuffer.append(this.modelType);
        stringBuffer.append(',');
        stringBuffer.append("airProfileAvailability");
        stringBuffer.append('=');
        stringBuffer.append(this.airProfileAvailability);
        stringBuffer.append(',');
        stringBuffer.append("drcProfileAvailability");
        stringBuffer.append('=');
        stringBuffer.append(this.drcProfileAvailability);
        stringBuffer.append(',');
        stringBuffer.append("additionalFunctionsAvailability");
        stringBuffer.append('=');
        stringBuffer.append(this.additionalFunctionsAvailability);
        stringBuffer.append(',');
        stringBuffer.append("levelsAvailability");
        stringBuffer.append('=');
        stringBuffer.append(this.levelsAvailability);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

