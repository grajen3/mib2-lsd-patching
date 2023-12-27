/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.RangeDataConfiguration;

public class RangeDataConfigurationSerializer {
    public static void putOptionalRangeDataConfiguration(ISerializer iSerializer, RangeDataConfiguration rangeDataConfiguration) {
        boolean bl = rangeDataConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = rangeDataConfiguration.getPrimaryEngineType();
            iSerializer.putInt32(n);
            int n2 = rangeDataConfiguration.getSecondaryEngineType();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalRangeDataConfigurationVarArray(ISerializer iSerializer, RangeDataConfiguration[] rangeDataConfigurationArray) {
        boolean bl = rangeDataConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rangeDataConfigurationArray.length);
            for (int i2 = 0; i2 < rangeDataConfigurationArray.length; ++i2) {
                RangeDataConfigurationSerializer.putOptionalRangeDataConfiguration(iSerializer, rangeDataConfigurationArray[i2]);
            }
        }
    }

    public static RangeDataConfiguration getOptionalRangeDataConfiguration(IDeserializer iDeserializer) {
        RangeDataConfiguration rangeDataConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            rangeDataConfiguration = new RangeDataConfiguration();
            rangeDataConfiguration.primaryEngineType = n2 = iDeserializer.getInt32();
            rangeDataConfiguration.secondaryEngineType = n = iDeserializer.getInt32();
        }
        return rangeDataConfiguration;
    }

    public static RangeDataConfiguration[] getOptionalRangeDataConfigurationVarArray(IDeserializer iDeserializer) {
        RangeDataConfiguration[] rangeDataConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rangeDataConfigurationArray = new RangeDataConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rangeDataConfigurationArray[i2] = RangeDataConfigurationSerializer.getOptionalRangeDataConfiguration(iDeserializer);
            }
        }
        return rangeDataConfigurationArray;
    }
}

