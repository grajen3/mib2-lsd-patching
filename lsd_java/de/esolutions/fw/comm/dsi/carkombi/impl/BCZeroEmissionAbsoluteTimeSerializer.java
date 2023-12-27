/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCZeroEmissionAbsoluteTime;

public class BCZeroEmissionAbsoluteTimeSerializer {
    public static void putOptionalBCZeroEmissionAbsoluteTime(ISerializer iSerializer, BCZeroEmissionAbsoluteTime bCZeroEmissionAbsoluteTime) {
        boolean bl = bCZeroEmissionAbsoluteTime == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bCZeroEmissionAbsoluteTime.getState();
            iSerializer.putInt32(n);
            int n2 = bCZeroEmissionAbsoluteTime.getValue();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalBCZeroEmissionAbsoluteTimeVarArray(ISerializer iSerializer, BCZeroEmissionAbsoluteTime[] bCZeroEmissionAbsoluteTimeArray) {
        boolean bl = bCZeroEmissionAbsoluteTimeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCZeroEmissionAbsoluteTimeArray.length);
            for (int i2 = 0; i2 < bCZeroEmissionAbsoluteTimeArray.length; ++i2) {
                BCZeroEmissionAbsoluteTimeSerializer.putOptionalBCZeroEmissionAbsoluteTime(iSerializer, bCZeroEmissionAbsoluteTimeArray[i2]);
            }
        }
    }

    public static BCZeroEmissionAbsoluteTime getOptionalBCZeroEmissionAbsoluteTime(IDeserializer iDeserializer) {
        BCZeroEmissionAbsoluteTime bCZeroEmissionAbsoluteTime = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            bCZeroEmissionAbsoluteTime = new BCZeroEmissionAbsoluteTime();
            bCZeroEmissionAbsoluteTime.state = n2 = iDeserializer.getInt32();
            bCZeroEmissionAbsoluteTime.value = n = iDeserializer.getInt32();
        }
        return bCZeroEmissionAbsoluteTime;
    }

    public static BCZeroEmissionAbsoluteTime[] getOptionalBCZeroEmissionAbsoluteTimeVarArray(IDeserializer iDeserializer) {
        BCZeroEmissionAbsoluteTime[] bCZeroEmissionAbsoluteTimeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCZeroEmissionAbsoluteTimeArray = new BCZeroEmissionAbsoluteTime[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCZeroEmissionAbsoluteTimeArray[i2] = BCZeroEmissionAbsoluteTimeSerializer.getOptionalBCZeroEmissionAbsoluteTime(iDeserializer);
            }
        }
        return bCZeroEmissionAbsoluteTimeArray;
    }
}

