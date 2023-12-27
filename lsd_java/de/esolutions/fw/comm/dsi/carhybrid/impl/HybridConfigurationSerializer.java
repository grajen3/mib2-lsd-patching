/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.HybridConfiguration;

public class HybridConfigurationSerializer {
    public static void putOptionalHybridConfiguration(ISerializer iSerializer, HybridConfiguration hybridConfiguration) {
        boolean bl = hybridConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = hybridConfiguration.isIce();
            iSerializer.putBool(bl2);
            boolean bl3 = hybridConfiguration.isEe1();
            iSerializer.putBool(bl3);
            boolean bl4 = hybridConfiguration.isEe2();
            iSerializer.putBool(bl4);
        }
    }

    public static void putOptionalHybridConfigurationVarArray(ISerializer iSerializer, HybridConfiguration[] hybridConfigurationArray) {
        boolean bl = hybridConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(hybridConfigurationArray.length);
            for (int i2 = 0; i2 < hybridConfigurationArray.length; ++i2) {
                HybridConfigurationSerializer.putOptionalHybridConfiguration(iSerializer, hybridConfigurationArray[i2]);
            }
        }
    }

    public static HybridConfiguration getOptionalHybridConfiguration(IDeserializer iDeserializer) {
        HybridConfiguration hybridConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            hybridConfiguration = new HybridConfiguration();
            hybridConfiguration.ice = bl4 = iDeserializer.getBool();
            hybridConfiguration.ee1 = bl3 = iDeserializer.getBool();
            hybridConfiguration.ee2 = bl2 = iDeserializer.getBool();
        }
        return hybridConfiguration;
    }

    public static HybridConfiguration[] getOptionalHybridConfigurationVarArray(IDeserializer iDeserializer) {
        HybridConfiguration[] hybridConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            hybridConfigurationArray = new HybridConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                hybridConfigurationArray[i2] = HybridConfigurationSerializer.getOptionalHybridConfiguration(iDeserializer);
            }
        }
        return hybridConfigurationArray;
    }
}

