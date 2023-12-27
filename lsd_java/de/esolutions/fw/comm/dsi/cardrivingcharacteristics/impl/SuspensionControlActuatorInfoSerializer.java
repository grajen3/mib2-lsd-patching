/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlActuatorInfo;

public class SuspensionControlActuatorInfoSerializer {
    public static void putOptionalSuspensionControlActuatorInfo(ISerializer iSerializer, SuspensionControlActuatorInfo suspensionControlActuatorInfo) {
        boolean bl = suspensionControlActuatorInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = suspensionControlActuatorInfo.getFrontLeft();
            iSerializer.putInt32(n);
            int n2 = suspensionControlActuatorInfo.getFrontRight();
            iSerializer.putInt32(n2);
            int n3 = suspensionControlActuatorInfo.getRearLeft();
            iSerializer.putInt32(n3);
            int n4 = suspensionControlActuatorInfo.getRearRight();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalSuspensionControlActuatorInfoVarArray(ISerializer iSerializer, SuspensionControlActuatorInfo[] suspensionControlActuatorInfoArray) {
        boolean bl = suspensionControlActuatorInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(suspensionControlActuatorInfoArray.length);
            for (int i2 = 0; i2 < suspensionControlActuatorInfoArray.length; ++i2) {
                SuspensionControlActuatorInfoSerializer.putOptionalSuspensionControlActuatorInfo(iSerializer, suspensionControlActuatorInfoArray[i2]);
            }
        }
    }

    public static SuspensionControlActuatorInfo getOptionalSuspensionControlActuatorInfo(IDeserializer iDeserializer) {
        SuspensionControlActuatorInfo suspensionControlActuatorInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            suspensionControlActuatorInfo = new SuspensionControlActuatorInfo();
            suspensionControlActuatorInfo.frontLeft = n4 = iDeserializer.getInt32();
            suspensionControlActuatorInfo.frontRight = n3 = iDeserializer.getInt32();
            suspensionControlActuatorInfo.rearLeft = n2 = iDeserializer.getInt32();
            suspensionControlActuatorInfo.rearRight = n = iDeserializer.getInt32();
        }
        return suspensionControlActuatorInfo;
    }

    public static SuspensionControlActuatorInfo[] getOptionalSuspensionControlActuatorInfoVarArray(IDeserializer iDeserializer) {
        SuspensionControlActuatorInfo[] suspensionControlActuatorInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            suspensionControlActuatorInfoArray = new SuspensionControlActuatorInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                suspensionControlActuatorInfoArray[i2] = SuspensionControlActuatorInfoSerializer.getOptionalSuspensionControlActuatorInfo(iDeserializer);
            }
        }
        return suspensionControlActuatorInfoArray;
    }
}

