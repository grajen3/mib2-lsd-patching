/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.TIMStatus;

public class TIMStatusSerializer {
    public static void putOptionalTIMStatus(ISerializer iSerializer, TIMStatus tIMStatus) {
        boolean bl = tIMStatus == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = tIMStatus.getStatus();
            iSerializer.putInt32(n);
            int n2 = tIMStatus.getTimePosition();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalTIMStatusVarArray(ISerializer iSerializer, TIMStatus[] tIMStatusArray) {
        boolean bl = tIMStatusArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tIMStatusArray.length);
            for (int i2 = 0; i2 < tIMStatusArray.length; ++i2) {
                TIMStatusSerializer.putOptionalTIMStatus(iSerializer, tIMStatusArray[i2]);
            }
        }
    }

    public static TIMStatus getOptionalTIMStatus(IDeserializer iDeserializer) {
        TIMStatus tIMStatus = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            tIMStatus = new TIMStatus();
            tIMStatus.status = n2 = iDeserializer.getInt32();
            tIMStatus.timePosition = n = iDeserializer.getInt32();
        }
        return tIMStatus;
    }

    public static TIMStatus[] getOptionalTIMStatusVarArray(IDeserializer iDeserializer) {
        TIMStatus[] tIMStatusArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tIMStatusArray = new TIMStatus[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tIMStatusArray[i2] = TIMStatusSerializer.getOptionalTIMStatus(iDeserializer);
            }
        }
        return tIMStatusArray;
    }
}

