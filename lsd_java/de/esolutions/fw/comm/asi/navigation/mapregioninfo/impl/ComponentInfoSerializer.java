/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl;

import de.esolutions.fw.comm.asi.navigation.mapregioninfo.ComponentInfo;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class ComponentInfoSerializer {
    public static void putOptionalComponentInfo(ISerializer iSerializer, ComponentInfo componentInfo) {
        boolean bl = componentInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = componentInfo.getComponentName();
            iSerializer.putOptionalString(string);
            byte[] byArray = componentInfo.getVersionInfo();
            iSerializer.putOptionalInt8VarArray(byArray);
        }
    }

    public static void putOptionalComponentInfoVarArray(ISerializer iSerializer, ComponentInfo[] componentInfoArray) {
        boolean bl = componentInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(componentInfoArray.length);
            for (int i2 = 0; i2 < componentInfoArray.length; ++i2) {
                ComponentInfoSerializer.putOptionalComponentInfo(iSerializer, componentInfoArray[i2]);
            }
        }
    }

    public static ComponentInfo getOptionalComponentInfo(IDeserializer iDeserializer) {
        ComponentInfo componentInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            componentInfo = new ComponentInfo();
            componentInfo.componentName = string = iDeserializer.getOptionalString();
            byte[] byArray = iDeserializer.getOptionalInt8VarArray();
            componentInfo.versionInfo = byArray;
        }
        return componentInfo;
    }

    public static ComponentInfo[] getOptionalComponentInfoVarArray(IDeserializer iDeserializer) {
        ComponentInfo[] componentInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            componentInfoArray = new ComponentInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                componentInfoArray[i2] = ComponentInfoSerializer.getOptionalComponentInfo(iDeserializer);
            }
        }
        return componentInfoArray;
    }
}

