/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cartimeunitslanguage.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cartimeunitslanguage.UTCOffset;

public class UTCOffsetSerializer {
    public static void putOptionalUTCOffset(ISerializer iSerializer, UTCOffset uTCOffset) {
        boolean bl = uTCOffset == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = uTCOffset.getOffset();
            iSerializer.putInt32(n);
            boolean bl2 = uTCOffset.isAlgebraicSign();
            iSerializer.putBool(bl2);
            byte by = uTCOffset.getState();
            iSerializer.putInt8(by);
        }
    }

    public static void putOptionalUTCOffsetVarArray(ISerializer iSerializer, UTCOffset[] uTCOffsetArray) {
        boolean bl = uTCOffsetArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(uTCOffsetArray.length);
            for (int i2 = 0; i2 < uTCOffsetArray.length; ++i2) {
                UTCOffsetSerializer.putOptionalUTCOffset(iSerializer, uTCOffsetArray[i2]);
            }
        }
    }

    public static UTCOffset getOptionalUTCOffset(IDeserializer iDeserializer) {
        UTCOffset uTCOffset = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            byte by;
            boolean bl2;
            int n;
            uTCOffset = new UTCOffset();
            uTCOffset.offset = n = iDeserializer.getInt32();
            uTCOffset.algebraicSign = bl2 = iDeserializer.getBool();
            uTCOffset.state = by = iDeserializer.getInt8();
        }
        return uTCOffset;
    }

    public static UTCOffset[] getOptionalUTCOffsetVarArray(IDeserializer iDeserializer) {
        UTCOffset[] uTCOffsetArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            uTCOffsetArray = new UTCOffset[n];
            for (int i2 = 0; i2 < n; ++i2) {
                uTCOffsetArray[i2] = UTCOffsetSerializer.getOptionalUTCOffset(iDeserializer);
            }
        }
        return uTCOffsetArray;
    }
}

