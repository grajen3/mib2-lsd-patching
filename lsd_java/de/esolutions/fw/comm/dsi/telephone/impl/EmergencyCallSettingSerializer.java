/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephone.EmergencyCallSetting;

public class EmergencyCallSettingSerializer {
    public static void putOptionalEmergencyCallSetting(ISerializer iSerializer, EmergencyCallSetting emergencyCallSetting) {
        boolean bl = emergencyCallSetting == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = emergencyCallSetting.isValue();
            iSerializer.putBool(bl2);
            boolean bl3 = emergencyCallSetting.isChangeable();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalEmergencyCallSettingVarArray(ISerializer iSerializer, EmergencyCallSetting[] emergencyCallSettingArray) {
        boolean bl = emergencyCallSettingArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(emergencyCallSettingArray.length);
            for (int i2 = 0; i2 < emergencyCallSettingArray.length; ++i2) {
                EmergencyCallSettingSerializer.putOptionalEmergencyCallSetting(iSerializer, emergencyCallSettingArray[i2]);
            }
        }
    }

    public static EmergencyCallSetting getOptionalEmergencyCallSetting(IDeserializer iDeserializer) {
        EmergencyCallSetting emergencyCallSetting = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            emergencyCallSetting = new EmergencyCallSetting();
            emergencyCallSetting.value = bl3 = iDeserializer.getBool();
            emergencyCallSetting.changeable = bl2 = iDeserializer.getBool();
        }
        return emergencyCallSetting;
    }

    public static EmergencyCallSetting[] getOptionalEmergencyCallSettingVarArray(IDeserializer iDeserializer) {
        EmergencyCallSetting[] emergencyCallSettingArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            emergencyCallSettingArray = new EmergencyCallSetting[n];
            for (int i2 = 0; i2 < n; ++i2) {
                emergencyCallSettingArray[i2] = EmergencyCallSettingSerializer.getOptionalEmergencyCallSetting(iDeserializer);
            }
        }
        return emergencyCallSettingArray;
    }
}

