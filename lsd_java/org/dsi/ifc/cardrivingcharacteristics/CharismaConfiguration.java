/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardrivingcharacteristics;

import org.dsi.ifc.cardrivingcharacteristics.CharismaOperationMode;
import org.dsi.ifc.cardrivingcharacteristics.CharismaProfiles;
import org.dsi.ifc.cardrivingcharacteristics.CharismaScreens;
import org.dsi.ifc.cardrivingcharacteristics.CharismaTransmittableElements;

public class CharismaConfiguration {
    public CharismaProfiles profilesAvailable;
    public CharismaTransmittableElements charismaListTransmittableElements;
    public int systemType;
    public CharismaScreens screensAvailable;
    public CharismaOperationMode operationModesAvailable;

    public CharismaConfiguration() {
        this.profilesAvailable = null;
        this.charismaListTransmittableElements = null;
        this.systemType = 0;
        this.screensAvailable = null;
        this.operationModesAvailable = null;
    }

    public CharismaConfiguration(CharismaProfiles charismaProfiles, CharismaTransmittableElements charismaTransmittableElements, int n, CharismaScreens charismaScreens, CharismaOperationMode charismaOperationMode) {
        this.profilesAvailable = charismaProfiles;
        this.charismaListTransmittableElements = charismaTransmittableElements;
        this.systemType = n;
        this.screensAvailable = charismaScreens;
        this.operationModesAvailable = charismaOperationMode;
    }

    public CharismaProfiles getProfilesAvailable() {
        return this.profilesAvailable;
    }

    public CharismaTransmittableElements getCharismaListTransmittableElements() {
        return this.charismaListTransmittableElements;
    }

    public int getSystemType() {
        return this.systemType;
    }

    public CharismaScreens getScreensAvailable() {
        return this.screensAvailable;
    }

    public CharismaOperationMode getOperationModesAvailable() {
        return this.operationModesAvailable;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(4300);
        stringBuffer.append("CharismaConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("profilesAvailable");
        stringBuffer.append('=');
        stringBuffer.append(this.profilesAvailable);
        stringBuffer.append(',');
        stringBuffer.append("charismaListTransmittableElements");
        stringBuffer.append('=');
        stringBuffer.append(this.charismaListTransmittableElements);
        stringBuffer.append(',');
        stringBuffer.append("systemType");
        stringBuffer.append('=');
        stringBuffer.append(this.systemType);
        stringBuffer.append(',');
        stringBuffer.append("screensAvailable");
        stringBuffer.append('=');
        stringBuffer.append(this.screensAvailable);
        stringBuffer.append(',');
        stringBuffer.append("operationModesAvailable");
        stringBuffer.append('=');
        stringBuffer.append(this.operationModesAvailable);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

