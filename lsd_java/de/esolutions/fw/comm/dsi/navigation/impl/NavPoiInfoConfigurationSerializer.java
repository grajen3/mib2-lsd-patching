/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.NavPoiInfoConfiguration;

public class NavPoiInfoConfigurationSerializer {
    public static void putOptionalNavPoiInfoConfiguration(ISerializer iSerializer, NavPoiInfoConfiguration navPoiInfoConfiguration) {
        boolean bl = navPoiInfoConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int[] nArray = navPoiInfoConfiguration.getExcludedTypes();
            iSerializer.putOptionalInt32VarArray(nArray);
        }
    }

    public static void putOptionalNavPoiInfoConfigurationVarArray(ISerializer iSerializer, NavPoiInfoConfiguration[] navPoiInfoConfigurationArray) {
        boolean bl = navPoiInfoConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navPoiInfoConfigurationArray.length);
            for (int i2 = 0; i2 < navPoiInfoConfigurationArray.length; ++i2) {
                NavPoiInfoConfigurationSerializer.putOptionalNavPoiInfoConfiguration(iSerializer, navPoiInfoConfigurationArray[i2]);
            }
        }
    }

    public static NavPoiInfoConfiguration getOptionalNavPoiInfoConfiguration(IDeserializer iDeserializer) {
        NavPoiInfoConfiguration navPoiInfoConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            navPoiInfoConfiguration = new NavPoiInfoConfiguration();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            navPoiInfoConfiguration.excludedTypes = nArray;
        }
        return navPoiInfoConfiguration;
    }

    public static NavPoiInfoConfiguration[] getOptionalNavPoiInfoConfigurationVarArray(IDeserializer iDeserializer) {
        NavPoiInfoConfiguration[] navPoiInfoConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navPoiInfoConfigurationArray = new NavPoiInfoConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navPoiInfoConfigurationArray[i2] = NavPoiInfoConfigurationSerializer.getOptionalNavPoiInfoConfiguration(iDeserializer);
            }
        }
        return navPoiInfoConfigurationArray;
    }
}

