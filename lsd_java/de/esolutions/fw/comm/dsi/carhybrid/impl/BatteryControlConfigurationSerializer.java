/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlClimateOperationModeInstallationSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlEngineInstallationSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileInstallationSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlSeatheaterInstallationSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlTransmittableElementsSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlWindowheaterInstallationSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlClimateOperationModeInstallation;
import org.dsi.ifc.carhybrid.BatteryControlConfiguration;
import org.dsi.ifc.carhybrid.BatteryControlEngineInstallation;
import org.dsi.ifc.carhybrid.BatteryControlProfileInstallation;
import org.dsi.ifc.carhybrid.BatteryControlSeatheaterInstallation;
import org.dsi.ifc.carhybrid.BatteryControlTransmittableElements;
import org.dsi.ifc.carhybrid.BatteryControlWindowheaterInstallation;

public class BatteryControlConfigurationSerializer {
    public static void putOptionalBatteryControlConfiguration(ISerializer iSerializer, BatteryControlConfiguration batteryControlConfiguration) {
        boolean bl = batteryControlConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            BatteryControlEngineInstallation batteryControlEngineInstallation = batteryControlConfiguration.getEngineInstallation();
            BatteryControlEngineInstallationSerializer.putOptionalBatteryControlEngineInstallation(iSerializer, batteryControlEngineInstallation);
            BatteryControlProfileInstallation batteryControlProfileInstallation = batteryControlConfiguration.getProfileInstallation();
            BatteryControlProfileInstallationSerializer.putOptionalBatteryControlProfileInstallation(iSerializer, batteryControlProfileInstallation);
            BatteryControlSeatheaterInstallation batteryControlSeatheaterInstallation = batteryControlConfiguration.getSeatheaterInstallation();
            BatteryControlSeatheaterInstallationSerializer.putOptionalBatteryControlSeatheaterInstallation(iSerializer, batteryControlSeatheaterInstallation);
            BatteryControlWindowheaterInstallation batteryControlWindowheaterInstallation = batteryControlConfiguration.getWindowheaterInstallation();
            BatteryControlWindowheaterInstallationSerializer.putOptionalBatteryControlWindowheaterInstallation(iSerializer, batteryControlWindowheaterInstallation);
            BatteryControlTransmittableElements batteryControlTransmittableElements = batteryControlConfiguration.getProfilesTransmittableElements();
            BatteryControlTransmittableElementsSerializer.putOptionalBatteryControlTransmittableElements(iSerializer, batteryControlTransmittableElements);
            BatteryControlTransmittableElements batteryControlTransmittableElements2 = batteryControlConfiguration.getPowerProviderTransmittableElements();
            BatteryControlTransmittableElementsSerializer.putOptionalBatteryControlTransmittableElements(iSerializer, batteryControlTransmittableElements2);
            boolean bl2 = batteryControlConfiguration.isParkheaterInstallation();
            iSerializer.putBool(bl2);
            BatteryControlClimateOperationModeInstallation batteryControlClimateOperationModeInstallation = batteryControlConfiguration.getClimateOperationModeInstallation();
            BatteryControlClimateOperationModeInstallationSerializer.putOptionalBatteryControlClimateOperationModeInstallation(iSerializer, batteryControlClimateOperationModeInstallation);
        }
    }

    public static void putOptionalBatteryControlConfigurationVarArray(ISerializer iSerializer, BatteryControlConfiguration[] batteryControlConfigurationArray) {
        boolean bl = batteryControlConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlConfigurationArray.length);
            for (int i2 = 0; i2 < batteryControlConfigurationArray.length; ++i2) {
                BatteryControlConfigurationSerializer.putOptionalBatteryControlConfiguration(iSerializer, batteryControlConfigurationArray[i2]);
            }
        }
    }

    public static BatteryControlConfiguration getOptionalBatteryControlConfiguration(IDeserializer iDeserializer) {
        BatteryControlConfiguration batteryControlConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            BatteryControlClimateOperationModeInstallation batteryControlClimateOperationModeInstallation;
            boolean bl2;
            BatteryControlTransmittableElements batteryControlTransmittableElements;
            BatteryControlTransmittableElements batteryControlTransmittableElements2;
            BatteryControlWindowheaterInstallation batteryControlWindowheaterInstallation;
            BatteryControlSeatheaterInstallation batteryControlSeatheaterInstallation;
            BatteryControlProfileInstallation batteryControlProfileInstallation;
            BatteryControlEngineInstallation batteryControlEngineInstallation;
            batteryControlConfiguration = new BatteryControlConfiguration();
            batteryControlConfiguration.engineInstallation = batteryControlEngineInstallation = BatteryControlEngineInstallationSerializer.getOptionalBatteryControlEngineInstallation(iDeserializer);
            batteryControlConfiguration.profileInstallation = batteryControlProfileInstallation = BatteryControlProfileInstallationSerializer.getOptionalBatteryControlProfileInstallation(iDeserializer);
            batteryControlConfiguration.seatheaterInstallation = batteryControlSeatheaterInstallation = BatteryControlSeatheaterInstallationSerializer.getOptionalBatteryControlSeatheaterInstallation(iDeserializer);
            batteryControlConfiguration.windowheaterInstallation = batteryControlWindowheaterInstallation = BatteryControlWindowheaterInstallationSerializer.getOptionalBatteryControlWindowheaterInstallation(iDeserializer);
            batteryControlConfiguration.profilesTransmittableElements = batteryControlTransmittableElements2 = BatteryControlTransmittableElementsSerializer.getOptionalBatteryControlTransmittableElements(iDeserializer);
            batteryControlConfiguration.powerProviderTransmittableElements = batteryControlTransmittableElements = BatteryControlTransmittableElementsSerializer.getOptionalBatteryControlTransmittableElements(iDeserializer);
            batteryControlConfiguration.parkheaterInstallation = bl2 = iDeserializer.getBool();
            batteryControlConfiguration.climateOperationModeInstallation = batteryControlClimateOperationModeInstallation = BatteryControlClimateOperationModeInstallationSerializer.getOptionalBatteryControlClimateOperationModeInstallation(iDeserializer);
        }
        return batteryControlConfiguration;
    }

    public static BatteryControlConfiguration[] getOptionalBatteryControlConfigurationVarArray(IDeserializer iDeserializer) {
        BatteryControlConfiguration[] batteryControlConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlConfigurationArray = new BatteryControlConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlConfigurationArray[i2] = BatteryControlConfigurationSerializer.getOptionalBatteryControlConfiguration(iDeserializer);
            }
        }
        return batteryControlConfigurationArray;
    }
}

