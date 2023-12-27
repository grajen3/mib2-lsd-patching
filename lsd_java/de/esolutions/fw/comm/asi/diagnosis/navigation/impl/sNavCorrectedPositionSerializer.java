/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation.impl;

import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCorrectedPosition;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sNavCorrectedPositionSerializer {
    public static void putOptionalsNavCorrectedPosition(ISerializer iSerializer, sNavCorrectedPosition sNavCorrectedPosition2) {
        boolean bl = sNavCorrectedPosition2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sNavCorrectedPosition2.getMsg_id();
            iSerializer.putUInt32(l);
            boolean bl2 = sNavCorrectedPosition2.isValuesOK();
            iSerializer.putBool(bl2);
            double d2 = sNavCorrectedPosition2.getLongitude();
            iSerializer.putDouble(d2);
            double d3 = sNavCorrectedPosition2.getLatitude();
            iSerializer.putDouble(d3);
        }
    }

    public static void putOptionalsNavCorrectedPositionVarArray(ISerializer iSerializer, sNavCorrectedPosition[] sNavCorrectedPositionArray) {
        boolean bl = sNavCorrectedPositionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sNavCorrectedPositionArray.length);
            for (int i2 = 0; i2 < sNavCorrectedPositionArray.length; ++i2) {
                sNavCorrectedPositionSerializer.putOptionalsNavCorrectedPosition(iSerializer, sNavCorrectedPositionArray[i2]);
            }
        }
    }

    public static sNavCorrectedPosition getOptionalsNavCorrectedPosition(IDeserializer iDeserializer) {
        sNavCorrectedPosition sNavCorrectedPosition2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            double d2;
            double d3;
            boolean bl2;
            long l;
            sNavCorrectedPosition2 = new sNavCorrectedPosition();
            sNavCorrectedPosition2.msg_id = l = iDeserializer.getUInt32();
            sNavCorrectedPosition2.valuesOK = bl2 = iDeserializer.getBool();
            sNavCorrectedPosition2.longitude = d3 = iDeserializer.getDouble();
            sNavCorrectedPosition2.latitude = d2 = iDeserializer.getDouble();
        }
        return sNavCorrectedPosition2;
    }

    public static sNavCorrectedPosition[] getOptionalsNavCorrectedPositionVarArray(IDeserializer iDeserializer) {
        sNavCorrectedPosition[] sNavCorrectedPositionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sNavCorrectedPositionArray = new sNavCorrectedPosition[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sNavCorrectedPositionArray[i2] = sNavCorrectedPositionSerializer.getOptionalsNavCorrectedPosition(iDeserializer);
            }
        }
        return sNavCorrectedPositionArray;
    }
}

