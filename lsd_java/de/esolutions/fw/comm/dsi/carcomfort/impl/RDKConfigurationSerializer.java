/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.carcomfort.impl.RDKSpeedLimitAvailabilitySerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.RDKConfiguration;
import org.dsi.ifc.carcomfort.RDKSpeedLimitAvailability;

public class RDKConfigurationSerializer {
    public static void putOptionalRDKConfiguration(ISerializer iSerializer, RDKConfiguration rDKConfiguration) {
        boolean bl = rDKConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = rDKConfiguration.getSystem();
            iSerializer.putInt32(n);
            RDKSpeedLimitAvailability rDKSpeedLimitAvailability = rDKConfiguration.getSpeedLimitAvailability();
            RDKSpeedLimitAvailabilitySerializer.putOptionalRDKSpeedLimitAvailability(iSerializer, rDKSpeedLimitAvailability);
            boolean bl2 = rDKConfiguration.isPressureLevel2();
            iSerializer.putBool(bl2);
            boolean bl3 = rDKConfiguration.isPressureLevel3();
            iSerializer.putBool(bl3);
            boolean bl4 = rDKConfiguration.isPressureLevel1();
            iSerializer.putBool(bl4);
            boolean bl5 = rDKConfiguration.isPressureLevel4();
            iSerializer.putBool(bl5);
            boolean bl6 = rDKConfiguration.isWheelDetails();
            iSerializer.putBool(bl6);
            boolean bl7 = rDKConfiguration.isCalibrationViaHardkey();
            iSerializer.putBool(bl7);
            int n2 = rDKConfiguration.getSystemType();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalRDKConfigurationVarArray(ISerializer iSerializer, RDKConfiguration[] rDKConfigurationArray) {
        boolean bl = rDKConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rDKConfigurationArray.length);
            for (int i2 = 0; i2 < rDKConfigurationArray.length; ++i2) {
                RDKConfigurationSerializer.putOptionalRDKConfiguration(iSerializer, rDKConfigurationArray[i2]);
            }
        }
    }

    public static RDKConfiguration getOptionalRDKConfiguration(IDeserializer iDeserializer) {
        RDKConfiguration rDKConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            RDKSpeedLimitAvailability rDKSpeedLimitAvailability;
            int n2;
            rDKConfiguration = new RDKConfiguration();
            rDKConfiguration.system = n2 = iDeserializer.getInt32();
            rDKConfiguration.speedLimitAvailability = rDKSpeedLimitAvailability = RDKSpeedLimitAvailabilitySerializer.getOptionalRDKSpeedLimitAvailability(iDeserializer);
            rDKConfiguration.pressureLevel2 = bl7 = iDeserializer.getBool();
            rDKConfiguration.pressureLevel3 = bl6 = iDeserializer.getBool();
            rDKConfiguration.pressureLevel1 = bl5 = iDeserializer.getBool();
            rDKConfiguration.pressureLevel4 = bl4 = iDeserializer.getBool();
            rDKConfiguration.wheelDetails = bl3 = iDeserializer.getBool();
            rDKConfiguration.calibrationViaHardkey = bl2 = iDeserializer.getBool();
            rDKConfiguration.systemType = n = iDeserializer.getInt32();
        }
        return rDKConfiguration;
    }

    public static RDKConfiguration[] getOptionalRDKConfigurationVarArray(IDeserializer iDeserializer) {
        RDKConfiguration[] rDKConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rDKConfigurationArray = new RDKConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rDKConfigurationArray[i2] = RDKConfigurationSerializer.getOptionalRDKConfiguration(iDeserializer);
            }
        }
        return rDKConfigurationArray;
    }
}

