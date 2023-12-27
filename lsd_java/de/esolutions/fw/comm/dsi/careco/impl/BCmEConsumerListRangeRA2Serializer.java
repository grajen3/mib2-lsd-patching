/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.BCmEConsumerListRangeRA2;

public class BCmEConsumerListRangeRA2Serializer {
    public static void putOptionalBCmEConsumerListRangeRA2(ISerializer iSerializer, BCmEConsumerListRangeRA2 bCmEConsumerListRangeRA2) {
        boolean bl = bCmEConsumerListRangeRA2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bCmEConsumerListRangeRA2.getPos();
            iSerializer.putInt32(n);
            int n2 = bCmEConsumerListRangeRA2.getConsumer();
            iSerializer.putInt32(n2);
            int n3 = bCmEConsumerListRangeRA2.getRangeGainSecondary();
            iSerializer.putInt32(n3);
            int n4 = bCmEConsumerListRangeRA2.getRangeUnit();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalBCmEConsumerListRangeRA2VarArray(ISerializer iSerializer, BCmEConsumerListRangeRA2[] bCmEConsumerListRangeRA2Array) {
        boolean bl = bCmEConsumerListRangeRA2Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCmEConsumerListRangeRA2Array.length);
            for (int i2 = 0; i2 < bCmEConsumerListRangeRA2Array.length; ++i2) {
                BCmEConsumerListRangeRA2Serializer.putOptionalBCmEConsumerListRangeRA2(iSerializer, bCmEConsumerListRangeRA2Array[i2]);
            }
        }
    }

    public static BCmEConsumerListRangeRA2 getOptionalBCmEConsumerListRangeRA2(IDeserializer iDeserializer) {
        BCmEConsumerListRangeRA2 bCmEConsumerListRangeRA2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            bCmEConsumerListRangeRA2 = new BCmEConsumerListRangeRA2();
            bCmEConsumerListRangeRA2.pos = n4 = iDeserializer.getInt32();
            bCmEConsumerListRangeRA2.consumer = n3 = iDeserializer.getInt32();
            bCmEConsumerListRangeRA2.rangeGainSecondary = n2 = iDeserializer.getInt32();
            bCmEConsumerListRangeRA2.rangeUnit = n = iDeserializer.getInt32();
        }
        return bCmEConsumerListRangeRA2;
    }

    public static BCmEConsumerListRangeRA2[] getOptionalBCmEConsumerListRangeRA2VarArray(IDeserializer iDeserializer) {
        BCmEConsumerListRangeRA2[] bCmEConsumerListRangeRA2Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCmEConsumerListRangeRA2Array = new BCmEConsumerListRangeRA2[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCmEConsumerListRangeRA2Array[i2] = BCmEConsumerListRangeRA2Serializer.getOptionalBCmEConsumerListRangeRA2(iDeserializer);
            }
        }
        return bCmEConsumerListRangeRA2Array;
    }
}

