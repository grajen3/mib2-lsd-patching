/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.ComponentInfo;

public class ComponentInfoSerializer {
    public static void putOptionalComponentInfo(ISerializer iSerializer, ComponentInfo componentInfo) {
        boolean bl = componentInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = componentInfo.getEnsID();
            iSerializer.putInt32(n);
            int n2 = componentInfo.getEnsECC();
            iSerializer.putInt32(n2);
            long l = componentInfo.getSID();
            iSerializer.putInt64(l);
            int n3 = componentInfo.getSCIDI();
            iSerializer.putInt32(n3);
            String string = componentInfo.getShortName();
            iSerializer.putOptionalString(string);
            String string2 = componentInfo.getFullName();
            iSerializer.putOptionalString(string2);
            boolean bl2 = componentInfo.isPrimaryService();
            iSerializer.putBool(bl2);
            boolean bl3 = componentInfo.isRadiotext();
            iSerializer.putBool(bl3);
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
            boolean bl2;
            boolean bl3;
            String string;
            String string2;
            int n;
            long l;
            int n2;
            int n3;
            componentInfo = new ComponentInfo();
            componentInfo.ensID = n3 = iDeserializer.getInt32();
            componentInfo.ensECC = n2 = iDeserializer.getInt32();
            componentInfo.sID = l = iDeserializer.getInt64();
            componentInfo.sCIDI = n = iDeserializer.getInt32();
            componentInfo.shortName = string2 = iDeserializer.getOptionalString();
            componentInfo.fullName = string = iDeserializer.getOptionalString();
            componentInfo.primaryService = bl3 = iDeserializer.getBool();
            componentInfo.radiotext = bl2 = iDeserializer.getBool();
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

