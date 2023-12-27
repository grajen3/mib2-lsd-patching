/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

import org.dsi.ifc.carhybrid.BatteryControlClimateOperationModeInstallation;
import org.dsi.ifc.carhybrid.BatteryControlEngineInstallation;
import org.dsi.ifc.carhybrid.BatteryControlProfileInstallation;
import org.dsi.ifc.carhybrid.BatteryControlSeatheaterInstallation;
import org.dsi.ifc.carhybrid.BatteryControlTransmittableElements;
import org.dsi.ifc.carhybrid.BatteryControlWindowheaterInstallation;

public class BatteryControlConfiguration {
    public BatteryControlEngineInstallation engineInstallation;
    public BatteryControlProfileInstallation profileInstallation;
    public BatteryControlSeatheaterInstallation seatheaterInstallation;
    public BatteryControlWindowheaterInstallation windowheaterInstallation;
    public BatteryControlTransmittableElements profilesTransmittableElements;
    public BatteryControlTransmittableElements powerProviderTransmittableElements;
    public boolean parkheaterInstallation;
    public BatteryControlClimateOperationModeInstallation climateOperationModeInstallation;

    public BatteryControlConfiguration() {
        this.engineInstallation = null;
        this.profileInstallation = null;
        this.seatheaterInstallation = null;
        this.windowheaterInstallation = null;
        this.profilesTransmittableElements = null;
        this.powerProviderTransmittableElements = null;
        this.parkheaterInstallation = false;
        this.climateOperationModeInstallation = null;
    }

    public BatteryControlConfiguration(BatteryControlEngineInstallation batteryControlEngineInstallation, BatteryControlProfileInstallation batteryControlProfileInstallation, BatteryControlSeatheaterInstallation batteryControlSeatheaterInstallation, BatteryControlWindowheaterInstallation batteryControlWindowheaterInstallation, BatteryControlTransmittableElements batteryControlTransmittableElements, BatteryControlTransmittableElements batteryControlTransmittableElements2, boolean bl, BatteryControlClimateOperationModeInstallation batteryControlClimateOperationModeInstallation) {
        this.engineInstallation = batteryControlEngineInstallation;
        this.profileInstallation = batteryControlProfileInstallation;
        this.seatheaterInstallation = batteryControlSeatheaterInstallation;
        this.windowheaterInstallation = batteryControlWindowheaterInstallation;
        this.profilesTransmittableElements = batteryControlTransmittableElements;
        this.powerProviderTransmittableElements = batteryControlTransmittableElements2;
        this.parkheaterInstallation = bl;
        this.climateOperationModeInstallation = batteryControlClimateOperationModeInstallation;
    }

    public BatteryControlEngineInstallation getEngineInstallation() {
        return this.engineInstallation;
    }

    public BatteryControlProfileInstallation getProfileInstallation() {
        return this.profileInstallation;
    }

    public BatteryControlSeatheaterInstallation getSeatheaterInstallation() {
        return this.seatheaterInstallation;
    }

    public BatteryControlWindowheaterInstallation getWindowheaterInstallation() {
        return this.windowheaterInstallation;
    }

    public BatteryControlTransmittableElements getProfilesTransmittableElements() {
        return this.profilesTransmittableElements;
    }

    public BatteryControlTransmittableElements getPowerProviderTransmittableElements() {
        return this.powerProviderTransmittableElements;
    }

    public boolean isParkheaterInstallation() {
        return this.parkheaterInstallation;
    }

    public BatteryControlClimateOperationModeInstallation getClimateOperationModeInstallation() {
        return this.climateOperationModeInstallation;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(7500);
        stringBuffer.append("BatteryControlConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("engineInstallation");
        stringBuffer.append('=');
        stringBuffer.append(this.engineInstallation);
        stringBuffer.append(',');
        stringBuffer.append("profileInstallation");
        stringBuffer.append('=');
        stringBuffer.append(this.profileInstallation);
        stringBuffer.append(',');
        stringBuffer.append("seatheaterInstallation");
        stringBuffer.append('=');
        stringBuffer.append(this.seatheaterInstallation);
        stringBuffer.append(',');
        stringBuffer.append("windowheaterInstallation");
        stringBuffer.append('=');
        stringBuffer.append(this.windowheaterInstallation);
        stringBuffer.append(',');
        stringBuffer.append("profilesTransmittableElements");
        stringBuffer.append('=');
        stringBuffer.append(this.profilesTransmittableElements);
        stringBuffer.append(',');
        stringBuffer.append("powerProviderTransmittableElements");
        stringBuffer.append('=');
        stringBuffer.append(this.powerProviderTransmittableElements);
        stringBuffer.append(',');
        stringBuffer.append("parkheaterInstallation");
        stringBuffer.append('=');
        stringBuffer.append(this.parkheaterInstallation);
        stringBuffer.append(',');
        stringBuffer.append("climateOperationModeInstallation");
        stringBuffer.append('=');
        stringBuffer.append(this.climateOperationModeInstallation);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

