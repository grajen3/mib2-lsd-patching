/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA0;

public class BCmEConsumerListConsumptionRA0Serializer {
    public static void putOptionalBCmEConsumerListConsumptionRA0(ISerializer iSerializer, BCmEConsumerListConsumptionRA0 bCmEConsumerListConsumptionRA0) {
        boolean bl = bCmEConsumerListConsumptionRA0 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bCmEConsumerListConsumptionRA0.getPos();
            iSerializer.putInt32(n);
            int n2 = bCmEConsumerListConsumptionRA0.getConsumer();
            iSerializer.putInt32(n2);
            short s = bCmEConsumerListConsumptionRA0.getConsumptionRelative();
            iSerializer.putInt16(s);
        }
    }

    public static void putOptionalBCmEConsumerListConsumptionRA0VarArray(ISerializer iSerializer, BCmEConsumerListConsumptionRA0[] bCmEConsumerListConsumptionRA0Array) {
        boolean bl = bCmEConsumerListConsumptionRA0Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCmEConsumerListConsumptionRA0Array.length);
            for (int i2 = 0; i2 < bCmEConsumerListConsumptionRA0Array.length; ++i2) {
                BCmEConsumerListConsumptionRA0Serializer.putOptionalBCmEConsumerListConsumptionRA0(iSerializer, bCmEConsumerListConsumptionRA0Array[i2]);
            }
        }
    }

    public static BCmEConsumerListConsumptionRA0 getOptionalBCmEConsumerListConsumptionRA0(IDeserializer iDeserializer) {
        BCmEConsumerListConsumptionRA0 bCmEConsumerListConsumptionRA0 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            int n;
            int n2;
            bCmEConsumerListConsumptionRA0 = new BCmEConsumerListConsumptionRA0();
            bCmEConsumerListConsumptionRA0.pos = n2 = iDeserializer.getInt32();
            bCmEConsumerListConsumptionRA0.consumer = n = iDeserializer.getInt32();
            bCmEConsumerListConsumptionRA0.consumptionRelative = s = iDeserializer.getInt16();
        }
        return bCmEConsumerListConsumptionRA0;
    }

    public static BCmEConsumerListConsumptionRA0[] getOptionalBCmEConsumerListConsumptionRA0VarArray(IDeserializer iDeserializer) {
        BCmEConsumerListConsumptionRA0[] bCmEConsumerListConsumptionRA0Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCmEConsumerListConsumptionRA0Array = new BCmEConsumerListConsumptionRA0[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCmEConsumerListConsumptionRA0Array[i2] = BCmEConsumerListConsumptionRA0Serializer.getOptionalBCmEConsumerListConsumptionRA0(iDeserializer);
            }
        }
        return bCmEConsumerListConsumptionRA0Array;
    }
}

