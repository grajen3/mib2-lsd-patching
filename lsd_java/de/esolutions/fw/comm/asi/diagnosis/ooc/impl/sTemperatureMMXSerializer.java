/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.ooc.impl;

import de.esolutions.fw.comm.asi.diagnosis.ooc.sTemperatureMMX;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sTemperatureMMXSerializer {
    public static void putOptionalsTemperatureMMX(ISerializer iSerializer, sTemperatureMMX sTemperatureMMX2) {
        boolean bl = sTemperatureMMX2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sTemperatureMMX2.getMsg_id();
            iSerializer.putUInt32(l);
            short s = sTemperatureMMX2.getCurrent();
            iSerializer.putUInt8(s);
            short s2 = sTemperatureMMX2.getMin();
            iSerializer.putUInt8(s2);
            short s3 = sTemperatureMMX2.getMax();
            iSerializer.putUInt8(s3);
        }
    }

    public static void putOptionalsTemperatureMMXVarArray(ISerializer iSerializer, sTemperatureMMX[] sTemperatureMMXArray) {
        boolean bl = sTemperatureMMXArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sTemperatureMMXArray.length);
            for (int i2 = 0; i2 < sTemperatureMMXArray.length; ++i2) {
                sTemperatureMMXSerializer.putOptionalsTemperatureMMX(iSerializer, sTemperatureMMXArray[i2]);
            }
        }
    }

    public static sTemperatureMMX getOptionalsTemperatureMMX(IDeserializer iDeserializer) {
        sTemperatureMMX sTemperatureMMX2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            short s3;
            long l;
            sTemperatureMMX2 = new sTemperatureMMX();
            sTemperatureMMX2.msg_id = l = iDeserializer.getUInt32();
            sTemperatureMMX2.current = s3 = iDeserializer.getUInt8();
            sTemperatureMMX2.min = s2 = iDeserializer.getUInt8();
            sTemperatureMMX2.max = s = iDeserializer.getUInt8();
        }
        return sTemperatureMMX2;
    }

    public static sTemperatureMMX[] getOptionalsTemperatureMMXVarArray(IDeserializer iDeserializer) {
        sTemperatureMMX[] sTemperatureMMXArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sTemperatureMMXArray = new sTemperatureMMX[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sTemperatureMMXArray[i2] = sTemperatureMMXSerializer.getOptionalsTemperatureMMX(iDeserializer);
            }
        }
        return sTemperatureMMXArray;
    }
}

