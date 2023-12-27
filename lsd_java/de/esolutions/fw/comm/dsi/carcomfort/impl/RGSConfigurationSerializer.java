/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.RGSConfiguration;

public class RGSConfigurationSerializer {
    public static void putOptionalRGSConfiguration(ISerializer iSerializer, RGSConfiguration rGSConfiguration) {
        boolean bl = rGSConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = rGSConfiguration.getDriverSide();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalRGSConfigurationVarArray(ISerializer iSerializer, RGSConfiguration[] rGSConfigurationArray) {
        boolean bl = rGSConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rGSConfigurationArray.length);
            for (int i2 = 0; i2 < rGSConfigurationArray.length; ++i2) {
                RGSConfigurationSerializer.putOptionalRGSConfiguration(iSerializer, rGSConfigurationArray[i2]);
            }
        }
    }

    public static RGSConfiguration getOptionalRGSConfiguration(IDeserializer iDeserializer) {
        RGSConfiguration rGSConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            rGSConfiguration = new RGSConfiguration();
            rGSConfiguration.driverSide = n = iDeserializer.getInt32();
        }
        return rGSConfiguration;
    }

    public static RGSConfiguration[] getOptionalRGSConfigurationVarArray(IDeserializer iDeserializer) {
        RGSConfiguration[] rGSConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rGSConfigurationArray = new RGSConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rGSConfigurationArray[i2] = RGSConfigurationSerializer.getOptionalRGSConfiguration(iDeserializer);
            }
        }
        return rGSConfigurationArray;
    }
}

