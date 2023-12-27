/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.AWVEmergencyBrake;

public class AWVEmergencyBrakeSerializer {
    public static void putOptionalAWVEmergencyBrake(ISerializer iSerializer, AWVEmergencyBrake aWVEmergencyBrake) {
        boolean bl = aWVEmergencyBrake == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = aWVEmergencyBrake.isTargetBrake();
            iSerializer.putBool(bl2);
            boolean bl3 = aWVEmergencyBrake.isAutoBrake();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalAWVEmergencyBrakeVarArray(ISerializer iSerializer, AWVEmergencyBrake[] aWVEmergencyBrakeArray) {
        boolean bl = aWVEmergencyBrakeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(aWVEmergencyBrakeArray.length);
            for (int i2 = 0; i2 < aWVEmergencyBrakeArray.length; ++i2) {
                AWVEmergencyBrakeSerializer.putOptionalAWVEmergencyBrake(iSerializer, aWVEmergencyBrakeArray[i2]);
            }
        }
    }

    public static AWVEmergencyBrake getOptionalAWVEmergencyBrake(IDeserializer iDeserializer) {
        AWVEmergencyBrake aWVEmergencyBrake = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            aWVEmergencyBrake = new AWVEmergencyBrake();
            aWVEmergencyBrake.targetBrake = bl3 = iDeserializer.getBool();
            aWVEmergencyBrake.autoBrake = bl2 = iDeserializer.getBool();
        }
        return aWVEmergencyBrake;
    }

    public static AWVEmergencyBrake[] getOptionalAWVEmergencyBrakeVarArray(IDeserializer iDeserializer) {
        AWVEmergencyBrake[] aWVEmergencyBrakeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            aWVEmergencyBrakeArray = new AWVEmergencyBrake[n];
            for (int i2 = 0; i2 < n; ++i2) {
                aWVEmergencyBrakeArray[i2] = AWVEmergencyBrakeSerializer.getOptionalAWVEmergencyBrake(iDeserializer);
            }
        }
        return aWVEmergencyBrakeArray;
    }
}

