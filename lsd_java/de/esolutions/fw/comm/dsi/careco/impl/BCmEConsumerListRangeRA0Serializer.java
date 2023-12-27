/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA0;

public class BCmEConsumerListRangeRA0Serializer {
    public static void putOptionalBCmEConsumerListRangeRA0(ISerializer iSerializer, BCmEConsumerListRangeRA0 bCmEConsumerListRangeRA0) {
        boolean bl = bCmEConsumerListRangeRA0 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bCmEConsumerListRangeRA0.getPos();
            iSerializer.putInt32(n);
            int n2 = bCmEConsumerListRangeRA0.getConsumer();
            iSerializer.putInt32(n2);
            int n3 = bCmEConsumerListRangeRA0.getRangeGainPrimary();
            iSerializer.putInt32(n3);
            int n4 = bCmEConsumerListRangeRA0.getRangeGainSecondary();
            iSerializer.putInt32(n4);
            int n5 = bCmEConsumerListRangeRA0.getRangeUnit();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalBCmEConsumerListRangeRA0VarArray(ISerializer iSerializer, BCmEConsumerListRangeRA0[] bCmEConsumerListRangeRA0Array) {
        boolean bl = bCmEConsumerListRangeRA0Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCmEConsumerListRangeRA0Array.length);
            for (int i2 = 0; i2 < bCmEConsumerListRangeRA0Array.length; ++i2) {
                BCmEConsumerListRangeRA0Serializer.putOptionalBCmEConsumerListRangeRA0(iSerializer, bCmEConsumerListRangeRA0Array[i2]);
            }
        }
    }

    public static BCmEConsumerListRangeRA0 getOptionalBCmEConsumerListRangeRA0(IDeserializer iDeserializer) {
        BCmEConsumerListRangeRA0 bCmEConsumerListRangeRA0 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            bCmEConsumerListRangeRA0 = new BCmEConsumerListRangeRA0();
            bCmEConsumerListRangeRA0.pos = n5 = iDeserializer.getInt32();
            bCmEConsumerListRangeRA0.consumer = n4 = iDeserializer.getInt32();
            bCmEConsumerListRangeRA0.rangeGainPrimary = n3 = iDeserializer.getInt32();
            bCmEConsumerListRangeRA0.rangeGainSecondary = n2 = iDeserializer.getInt32();
            bCmEConsumerListRangeRA0.rangeUnit = n = iDeserializer.getInt32();
        }
        return bCmEConsumerListRangeRA0;
    }

    public static BCmEConsumerListRangeRA0[] getOptionalBCmEConsumerListRangeRA0VarArray(IDeserializer iDeserializer) {
        BCmEConsumerListRangeRA0[] bCmEConsumerListRangeRA0Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCmEConsumerListRangeRA0Array = new BCmEConsumerListRangeRA0[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCmEConsumerListRangeRA0Array[i2] = BCmEConsumerListRangeRA0Serializer.getOptionalBCmEConsumerListRangeRA0(iDeserializer);
            }
        }
        return bCmEConsumerListRangeRA0Array;
    }
}

