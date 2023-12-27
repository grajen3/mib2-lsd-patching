/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.BCmEConsumerList;

public class BCmEConsumerListSerializer {
    public static void putOptionalBCmEConsumerList(ISerializer iSerializer, BCmEConsumerList bCmEConsumerList) {
        boolean bl = bCmEConsumerList == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bCmEConsumerList.getListPosition();
            iSerializer.putInt32(n);
            int n2 = bCmEConsumerList.getConsumer();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalBCmEConsumerListVarArray(ISerializer iSerializer, BCmEConsumerList[] bCmEConsumerListArray) {
        boolean bl = bCmEConsumerListArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCmEConsumerListArray.length);
            for (int i2 = 0; i2 < bCmEConsumerListArray.length; ++i2) {
                BCmEConsumerListSerializer.putOptionalBCmEConsumerList(iSerializer, bCmEConsumerListArray[i2]);
            }
        }
    }

    public static BCmEConsumerList getOptionalBCmEConsumerList(IDeserializer iDeserializer) {
        BCmEConsumerList bCmEConsumerList = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            bCmEConsumerList = new BCmEConsumerList();
            bCmEConsumerList.listPosition = n2 = iDeserializer.getInt32();
            bCmEConsumerList.consumer = n = iDeserializer.getInt32();
        }
        return bCmEConsumerList;
    }

    public static BCmEConsumerList[] getOptionalBCmEConsumerListVarArray(IDeserializer iDeserializer) {
        BCmEConsumerList[] bCmEConsumerListArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCmEConsumerListArray = new BCmEConsumerList[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCmEConsumerListArray[i2] = BCmEConsumerListSerializer.getOptionalBCmEConsumerList(iDeserializer);
            }
        }
        return bCmEConsumerListArray;
    }
}

