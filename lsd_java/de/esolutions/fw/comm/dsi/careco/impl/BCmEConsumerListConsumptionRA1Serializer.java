/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.BCmEConsumerListConsumptionRA1;

public class BCmEConsumerListConsumptionRA1Serializer {
    public static void putOptionalBCmEConsumerListConsumptionRA1(ISerializer iSerializer, BCmEConsumerListConsumptionRA1 bCmEConsumerListConsumptionRA1) {
        boolean bl = bCmEConsumerListConsumptionRA1 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bCmEConsumerListConsumptionRA1.getPos();
            iSerializer.putInt32(n);
            int n2 = bCmEConsumerListConsumptionRA1.getConsumer();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalBCmEConsumerListConsumptionRA1VarArray(ISerializer iSerializer, BCmEConsumerListConsumptionRA1[] bCmEConsumerListConsumptionRA1Array) {
        boolean bl = bCmEConsumerListConsumptionRA1Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCmEConsumerListConsumptionRA1Array.length);
            for (int i2 = 0; i2 < bCmEConsumerListConsumptionRA1Array.length; ++i2) {
                BCmEConsumerListConsumptionRA1Serializer.putOptionalBCmEConsumerListConsumptionRA1(iSerializer, bCmEConsumerListConsumptionRA1Array[i2]);
            }
        }
    }

    public static BCmEConsumerListConsumptionRA1 getOptionalBCmEConsumerListConsumptionRA1(IDeserializer iDeserializer) {
        BCmEConsumerListConsumptionRA1 bCmEConsumerListConsumptionRA1 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            bCmEConsumerListConsumptionRA1 = new BCmEConsumerListConsumptionRA1();
            bCmEConsumerListConsumptionRA1.pos = n2 = iDeserializer.getInt32();
            bCmEConsumerListConsumptionRA1.consumer = n = iDeserializer.getInt32();
        }
        return bCmEConsumerListConsumptionRA1;
    }

    public static BCmEConsumerListConsumptionRA1[] getOptionalBCmEConsumerListConsumptionRA1VarArray(IDeserializer iDeserializer) {
        BCmEConsumerListConsumptionRA1[] bCmEConsumerListConsumptionRA1Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCmEConsumerListConsumptionRA1Array = new BCmEConsumerListConsumptionRA1[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCmEConsumerListConsumptionRA1Array[i2] = BCmEConsumerListConsumptionRA1Serializer.getOptionalBCmEConsumerListConsumptionRA1(iDeserializer);
            }
        }
        return bCmEConsumerListConsumptionRA1Array;
    }
}

