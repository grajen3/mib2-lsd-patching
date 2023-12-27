/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swap.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.swap.ConfigInfo;

public class ConfigInfoSerializer {
    public static void putOptionalConfigInfo(ISerializer iSerializer, ConfigInfo configInfo) {
        boolean bl = configInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = configInfo.getComponentName();
            iSerializer.putOptionalString(string);
            String[] stringArray = configInfo.getPackets();
            iSerializer.putOptionalStringVarArray(stringArray);
            String[] stringArray2 = configInfo.getConfigs();
            iSerializer.putOptionalStringVarArray(stringArray2);
        }
    }

    public static void putOptionalConfigInfoVarArray(ISerializer iSerializer, ConfigInfo[] configInfoArray) {
        boolean bl = configInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(configInfoArray.length);
            for (int i2 = 0; i2 < configInfoArray.length; ++i2) {
                ConfigInfoSerializer.putOptionalConfigInfo(iSerializer, configInfoArray[i2]);
            }
        }
    }

    public static ConfigInfo getOptionalConfigInfo(IDeserializer iDeserializer) {
        ConfigInfo configInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            configInfo = new ConfigInfo();
            configInfo.componentName = string = iDeserializer.getOptionalString();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            configInfo.packets = stringArray;
            String[] stringArray2 = iDeserializer.getOptionalStringVarArray();
            configInfo.configs = stringArray2;
        }
        return configInfo;
    }

    public static ConfigInfo[] getOptionalConfigInfoVarArray(IDeserializer iDeserializer) {
        ConfigInfo[] configInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            configInfoArray = new ConfigInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                configInfoArray[i2] = ConfigInfoSerializer.getOptionalConfigInfo(iDeserializer);
            }
        }
        return configInfoArray;
    }
}

