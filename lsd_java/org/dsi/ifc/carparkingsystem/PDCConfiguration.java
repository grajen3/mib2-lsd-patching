/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

import org.dsi.ifc.carparkingsystem.PDCContinueDrivingAssist;
import org.dsi.ifc.carparkingsystem.PDCManeuverAssist;
import org.dsi.ifc.carparkingsystem.PDCSupportedFunctions;

public class PDCConfiguration {
    public byte numberFrontSectors;
    public byte numberRearSectors;
    public byte numberRightSectors;
    public byte numberLeftSectors;
    public int wheelbase;
    public boolean crashWarning;
    public boolean steeringInformation;
    public PDCSupportedFunctions supportedFunctions;
    public PDCManeuverAssist maneuverAssist;
    public PDCContinueDrivingAssist continueDrivingAssist;

    public PDCConfiguration() {
        this.numberFrontSectors = 0;
        this.numberRearSectors = 0;
        this.numberRightSectors = 0;
        this.numberLeftSectors = 0;
        this.wheelbase = 0;
        this.crashWarning = false;
        this.steeringInformation = false;
        this.supportedFunctions = null;
        this.maneuverAssist = null;
        this.continueDrivingAssist = null;
    }

    public PDCConfiguration(byte by, byte by2, byte by3, byte by4, int n, boolean bl, boolean bl2) {
        this.numberFrontSectors = by;
        this.numberRearSectors = by2;
        this.numberRightSectors = by3;
        this.numberLeftSectors = by4;
        this.wheelbase = n;
        this.crashWarning = bl;
        this.steeringInformation = bl2;
        this.supportedFunctions = null;
        this.maneuverAssist = null;
        this.continueDrivingAssist = null;
    }

    public PDCConfiguration(byte by, byte by2, byte by3, byte by4, int n, boolean bl, boolean bl2, PDCSupportedFunctions pDCSupportedFunctions, PDCManeuverAssist pDCManeuverAssist, PDCContinueDrivingAssist pDCContinueDrivingAssist) {
        this.numberFrontSectors = by;
        this.numberRearSectors = by2;
        this.numberRightSectors = by3;
        this.numberLeftSectors = by4;
        this.wheelbase = n;
        this.crashWarning = bl;
        this.steeringInformation = bl2;
        this.supportedFunctions = pDCSupportedFunctions;
        this.maneuverAssist = pDCManeuverAssist;
        this.continueDrivingAssist = pDCContinueDrivingAssist;
    }

    public byte getNumberFrontSectors() {
        return this.numberFrontSectors;
    }

    public byte getNumberRearSectors() {
        return this.numberRearSectors;
    }

    public byte getNumberRightSectors() {
        return this.numberRightSectors;
    }

    public byte getNumberLeftSectors() {
        return this.numberLeftSectors;
    }

    public int getWheelbase() {
        return this.wheelbase;
    }

    public boolean isCrashWarning() {
        return this.crashWarning;
    }

    public boolean isSteeringInformation() {
        return this.steeringInformation;
    }

    public PDCSupportedFunctions getSupportedFunctions() {
        return this.supportedFunctions;
    }

    public PDCManeuverAssist getManeuverAssist() {
        return this.maneuverAssist;
    }

    public PDCContinueDrivingAssist getContinueDrivingAssist() {
        return this.continueDrivingAssist;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3550);
        stringBuffer.append("PDCConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("numberFrontSectors");
        stringBuffer.append('=');
        stringBuffer.append(this.numberFrontSectors);
        stringBuffer.append(',');
        stringBuffer.append("numberRearSectors");
        stringBuffer.append('=');
        stringBuffer.append(this.numberRearSectors);
        stringBuffer.append(',');
        stringBuffer.append("numberRightSectors");
        stringBuffer.append('=');
        stringBuffer.append(this.numberRightSectors);
        stringBuffer.append(',');
        stringBuffer.append("numberLeftSectors");
        stringBuffer.append('=');
        stringBuffer.append(this.numberLeftSectors);
        stringBuffer.append(',');
        stringBuffer.append("wheelbase");
        stringBuffer.append('=');
        stringBuffer.append(this.wheelbase);
        stringBuffer.append(',');
        stringBuffer.append("crashWarning");
        stringBuffer.append('=');
        stringBuffer.append(this.crashWarning);
        stringBuffer.append(',');
        stringBuffer.append("steeringInformation");
        stringBuffer.append('=');
        stringBuffer.append(this.steeringInformation);
        stringBuffer.append(',');
        stringBuffer.append("supportedFunctions");
        stringBuffer.append('=');
        stringBuffer.append(this.supportedFunctions);
        stringBuffer.append(',');
        stringBuffer.append("maneuverAssist");
        stringBuffer.append('=');
        stringBuffer.append(this.maneuverAssist);
        stringBuffer.append(',');
        stringBuffer.append("continueDrivingAssist");
        stringBuffer.append('=');
        stringBuffer.append(this.continueDrivingAssist);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

