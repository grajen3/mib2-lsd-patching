/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCZeroEmissionRelative;

public class BCZeroEmissionRelativeSerializer {
    public static void putOptionalBCZeroEmissionRelative(ISerializer iSerializer, BCZeroEmissionRelative bCZeroEmissionRelative) {
        boolean bl = bCZeroEmissionRelative == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bCZeroEmissionRelative.getState();
            iSerializer.putInt32(n);
            int n2 = bCZeroEmissionRelative.getValue();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalBCZeroEmissionRelativeVarArray(ISerializer iSerializer, BCZeroEmissionRelative[] bCZeroEmissionRelativeArray) {
        boolean bl = bCZeroEmissionRelativeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCZeroEmissionRelativeArray.length);
            for (int i2 = 0; i2 < bCZeroEmissionRelativeArray.length; ++i2) {
                BCZeroEmissionRelativeSerializer.putOptionalBCZeroEmissionRelative(iSerializer, bCZeroEmissionRelativeArray[i2]);
            }
        }
    }

    public static BCZeroEmissionRelative getOptionalBCZeroEmissionRelative(IDeserializer iDeserializer) {
        BCZeroEmissionRelative bCZeroEmissionRelative = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            bCZeroEmissionRelative = new BCZeroEmissionRelative();
            bCZeroEmissionRelative.state = n2 = iDeserializer.getInt32();
            bCZeroEmissionRelative.value = n = iDeserializer.getInt32();
        }
        return bCZeroEmissionRelative;
    }

    public static BCZeroEmissionRelative[] getOptionalBCZeroEmissionRelativeVarArray(IDeserializer iDeserializer) {
        BCZeroEmissionRelative[] bCZeroEmissionRelativeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCZeroEmissionRelativeArray = new BCZeroEmissionRelative[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCZeroEmissionRelativeArray[i2] = BCZeroEmissionRelativeSerializer.getOptionalBCZeroEmissionRelative(iDeserializer);
            }
        }
        return bCZeroEmissionRelativeArray;
    }
}

