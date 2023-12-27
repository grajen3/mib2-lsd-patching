/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.TSDConfiguration;

public class TSDConfigurationSerializer {
    public static void putOptionalTSDConfiguration(ISerializer iSerializer, TSDConfiguration tSDConfiguration) {
        boolean bl = tSDConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = tSDConfiguration.getType();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalTSDConfigurationVarArray(ISerializer iSerializer, TSDConfiguration[] tSDConfigurationArray) {
        boolean bl = tSDConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tSDConfigurationArray.length);
            for (int i2 = 0; i2 < tSDConfigurationArray.length; ++i2) {
                TSDConfigurationSerializer.putOptionalTSDConfiguration(iSerializer, tSDConfigurationArray[i2]);
            }
        }
    }

    public static TSDConfiguration getOptionalTSDConfiguration(IDeserializer iDeserializer) {
        TSDConfiguration tSDConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            tSDConfiguration = new TSDConfiguration();
            tSDConfiguration.type = n = iDeserializer.getInt32();
        }
        return tSDConfiguration;
    }

    public static TSDConfiguration[] getOptionalTSDConfigurationVarArray(IDeserializer iDeserializer) {
        TSDConfiguration[] tSDConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tSDConfigurationArray = new TSDConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tSDConfigurationArray[i2] = TSDConfigurationSerializer.getOptionalTSDConfiguration(iDeserializer);
            }
        }
        return tSDConfigurationArray;
    }
}

