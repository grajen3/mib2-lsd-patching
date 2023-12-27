/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking.impl;

import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.networking.CPacketCounter;

public class CPacketCounterSerializer {
    public static void putOptionalCPacketCounter(ISerializer iSerializer, CPacketCounter cPacketCounter) {
        boolean bl = cPacketCounter == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = cPacketCounter.getConnectionDuration();
            iSerializer.putInt32(n);
            long l = cPacketCounter.getRxBytes();
            iSerializer.putInt64(l);
            long l2 = cPacketCounter.getRxBytesSinceReset();
            iSerializer.putInt64(l2);
            long l3 = cPacketCounter.getTxBytes();
            iSerializer.putInt64(l3);
            long l4 = cPacketCounter.getTxBytesSinceReset();
            iSerializer.putInt64(l4);
            DateTime dateTime = cPacketCounter.getLastResetDate();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime);
        }
    }

    public static void putOptionalCPacketCounterVarArray(ISerializer iSerializer, CPacketCounter[] cPacketCounterArray) {
        boolean bl = cPacketCounterArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(cPacketCounterArray.length);
            for (int i2 = 0; i2 < cPacketCounterArray.length; ++i2) {
                CPacketCounterSerializer.putOptionalCPacketCounter(iSerializer, cPacketCounterArray[i2]);
            }
        }
    }

    public static CPacketCounter getOptionalCPacketCounter(IDeserializer iDeserializer) {
        CPacketCounter cPacketCounter = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            DateTime dateTime;
            long l;
            long l2;
            long l3;
            long l4;
            int n;
            cPacketCounter = new CPacketCounter();
            cPacketCounter.connectionDuration = n = iDeserializer.getInt32();
            cPacketCounter.rxBytes = l4 = iDeserializer.getInt64();
            cPacketCounter.rxBytesSinceReset = l3 = iDeserializer.getInt64();
            cPacketCounter.txBytes = l2 = iDeserializer.getInt64();
            cPacketCounter.txBytesSinceReset = l = iDeserializer.getInt64();
            cPacketCounter.lastResetDate = dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
        }
        return cPacketCounter;
    }

    public static CPacketCounter[] getOptionalCPacketCounterVarArray(IDeserializer iDeserializer) {
        CPacketCounter[] cPacketCounterArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            cPacketCounterArray = new CPacketCounter[n];
            for (int i2 = 0; i2 < n; ++i2) {
                cPacketCounterArray[i2] = CPacketCounterSerializer.getOptionalCPacketCounter(iDeserializer);
            }
        }
        return cPacketCounterArray;
    }
}

