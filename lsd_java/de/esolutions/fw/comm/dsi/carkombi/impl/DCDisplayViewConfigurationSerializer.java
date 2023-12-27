/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCDisplayViewConfiguration;

public class DCDisplayViewConfigurationSerializer {
    public static void putOptionalDCDisplayViewConfiguration(ISerializer iSerializer, DCDisplayViewConfiguration dCDisplayViewConfiguration) {
        boolean bl = dCDisplayViewConfiguration == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = dCDisplayViewConfiguration.getActiveDisplayView();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalDCDisplayViewConfigurationVarArray(ISerializer iSerializer, DCDisplayViewConfiguration[] dCDisplayViewConfigurationArray) {
        boolean bl = dCDisplayViewConfigurationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dCDisplayViewConfigurationArray.length);
            for (int i2 = 0; i2 < dCDisplayViewConfigurationArray.length; ++i2) {
                DCDisplayViewConfigurationSerializer.putOptionalDCDisplayViewConfiguration(iSerializer, dCDisplayViewConfigurationArray[i2]);
            }
        }
    }

    public static DCDisplayViewConfiguration getOptionalDCDisplayViewConfiguration(IDeserializer iDeserializer) {
        DCDisplayViewConfiguration dCDisplayViewConfiguration = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            dCDisplayViewConfiguration = new DCDisplayViewConfiguration();
            dCDisplayViewConfiguration.activeDisplayView = n = iDeserializer.getInt32();
        }
        return dCDisplayViewConfiguration;
    }

    public static DCDisplayViewConfiguration[] getOptionalDCDisplayViewConfigurationVarArray(IDeserializer iDeserializer) {
        DCDisplayViewConfiguration[] dCDisplayViewConfigurationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dCDisplayViewConfigurationArray = new DCDisplayViewConfiguration[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dCDisplayViewConfigurationArray[i2] = DCDisplayViewConfigurationSerializer.getOptionalDCDisplayViewConfiguration(iDeserializer);
            }
        }
        return dCDisplayViewConfigurationArray;
    }
}

