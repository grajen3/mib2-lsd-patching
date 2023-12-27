/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.SuspensionControlHeightInfo;

public class SuspensionControlHeightInfoSerializer {
    public static void putOptionalSuspensionControlHeightInfo(ISerializer iSerializer, SuspensionControlHeightInfo suspensionControlHeightInfo) {
        boolean bl = suspensionControlHeightInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = suspensionControlHeightInfo.getFrontLeft();
            iSerializer.putInt16(s);
            short s2 = suspensionControlHeightInfo.getFrontRight();
            iSerializer.putInt16(s2);
            short s3 = suspensionControlHeightInfo.getRearLeft();
            iSerializer.putInt16(s3);
            short s4 = suspensionControlHeightInfo.getRearRight();
            iSerializer.putInt16(s4);
        }
    }

    public static void putOptionalSuspensionControlHeightInfoVarArray(ISerializer iSerializer, SuspensionControlHeightInfo[] suspensionControlHeightInfoArray) {
        boolean bl = suspensionControlHeightInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(suspensionControlHeightInfoArray.length);
            for (int i2 = 0; i2 < suspensionControlHeightInfoArray.length; ++i2) {
                SuspensionControlHeightInfoSerializer.putOptionalSuspensionControlHeightInfo(iSerializer, suspensionControlHeightInfoArray[i2]);
            }
        }
    }

    public static SuspensionControlHeightInfo getOptionalSuspensionControlHeightInfo(IDeserializer iDeserializer) {
        SuspensionControlHeightInfo suspensionControlHeightInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            short s3;
            short s4;
            suspensionControlHeightInfo = new SuspensionControlHeightInfo();
            suspensionControlHeightInfo.frontLeft = s4 = iDeserializer.getInt16();
            suspensionControlHeightInfo.frontRight = s3 = iDeserializer.getInt16();
            suspensionControlHeightInfo.rearLeft = s2 = iDeserializer.getInt16();
            suspensionControlHeightInfo.rearRight = s = iDeserializer.getInt16();
        }
        return suspensionControlHeightInfo;
    }

    public static SuspensionControlHeightInfo[] getOptionalSuspensionControlHeightInfoVarArray(IDeserializer iDeserializer) {
        SuspensionControlHeightInfo[] suspensionControlHeightInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            suspensionControlHeightInfoArray = new SuspensionControlHeightInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                suspensionControlHeightInfoArray[i2] = SuspensionControlHeightInfoSerializer.getOptionalSuspensionControlHeightInfo(iDeserializer);
            }
        }
        return suspensionControlHeightInfoArray;
    }
}

