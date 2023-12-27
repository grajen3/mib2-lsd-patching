/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.SWAConfiguration;

public class SWAConfigurationSerializer {
    public static void putOptionalSWAConfiguration(ISerializer iSerializer, SWAConfiguration sWAConfiguration) {
        boolean bl = sWAConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = sWAConfiguration.getSystem();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalSWAConfigurationVarArray(ISerializer iSerializer, SWAConfiguration[] sWAConfigurationArray) {
        boolean bl = sWAConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sWAConfigurationArray.length);
            for (int i2 = 0; i2 < sWAConfigurationArray.length; ++i2) {
                SWAConfigurationSerializer.putOptionalSWAConfiguration(iSerializer, sWAConfigurationArray[i2]);
            }
        }
    }

    public static SWAConfiguration getOptionalSWAConfiguration(IDeserializer iDeserializer) {
        SWAConfiguration sWAConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            sWAConfiguration = new SWAConfiguration();
            sWAConfiguration.system = n = iDeserializer.getInt32();
        }
        return sWAConfiguration;
    }

    public static SWAConfiguration[] getOptionalSWAConfigurationVarArray(IDeserializer iDeserializer) {
        SWAConfiguration[] sWAConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sWAConfigurationArray = new SWAConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sWAConfigurationArray[i2] = SWAConfigurationSerializer.getOptionalSWAConfiguration(iDeserializer);
            }
        }
        return sWAConfigurationArray;
    }
}

