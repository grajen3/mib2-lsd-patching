/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA1;

public class BCmEConsumerListRangeRA1Serializer {
    public static void putOptionalBCmEConsumerListRangeRA1(ISerializer iSerializer, BCmEConsumerListRangeRA1 bCmEConsumerListRangeRA1) {
        boolean bl = bCmEConsumerListRangeRA1 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bCmEConsumerListRangeRA1.getPos();
            iSerializer.putInt32(n);
            int n2 = bCmEConsumerListRangeRA1.getConsumer();
            iSerializer.putInt32(n2);
            int n3 = bCmEConsumerListRangeRA1.getRangeGainPrimary();
            iSerializer.putInt32(n3);
            int n4 = bCmEConsumerListRangeRA1.getRangeUnit();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalBCmEConsumerListRangeRA1VarArray(ISerializer iSerializer, BCmEConsumerListRangeRA1[] bCmEConsumerListRangeRA1Array) {
        boolean bl = bCmEConsumerListRangeRA1Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCmEConsumerListRangeRA1Array.length);
            for (int i2 = 0; i2 < bCmEConsumerListRangeRA1Array.length; ++i2) {
                BCmEConsumerListRangeRA1Serializer.putOptionalBCmEConsumerListRangeRA1(iSerializer, bCmEConsumerListRangeRA1Array[i2]);
            }
        }
    }

    public static BCmEConsumerListRangeRA1 getOptionalBCmEConsumerListRangeRA1(IDeserializer iDeserializer) {
        BCmEConsumerListRangeRA1 bCmEConsumerListRangeRA1 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            bCmEConsumerListRangeRA1 = new BCmEConsumerListRangeRA1();
            bCmEConsumerListRangeRA1.pos = n4 = iDeserializer.getInt32();
            bCmEConsumerListRangeRA1.consumer = n3 = iDeserializer.getInt32();
            bCmEConsumerListRangeRA1.rangeGainPrimary = n2 = iDeserializer.getInt32();
            bCmEConsumerListRangeRA1.rangeUnit = n = iDeserializer.getInt32();
        }
        return bCmEConsumerListRangeRA1;
    }

    public static BCmEConsumerListRangeRA1[] getOptionalBCmEConsumerListRangeRA1VarArray(IDeserializer iDeserializer) {
        BCmEConsumerListRangeRA1[] bCmEConsumerListRangeRA1Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCmEConsumerListRangeRA1Array = new BCmEConsumerListRangeRA1[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCmEConsumerListRangeRA1Array[i2] = BCmEConsumerListRangeRA1Serializer.getOptionalBCmEConsumerListRangeRA1(iDeserializer);
            }
        }
        return bCmEConsumerListRangeRA1Array;
    }
}

