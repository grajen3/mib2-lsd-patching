/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCResetTimeStamp;

public class BCResetTimeStampSerializer {
    public static void putOptionalBCResetTimeStamp(ISerializer iSerializer, BCResetTimeStamp bCResetTimeStamp) {
        boolean bl = bCResetTimeStamp == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = bCResetTimeStamp.getYear();
            iSerializer.putInt16(s);
            byte by = bCResetTimeStamp.getMonth();
            iSerializer.putInt8(by);
            byte by2 = bCResetTimeStamp.getDay();
            iSerializer.putInt8(by2);
            byte by3 = bCResetTimeStamp.getHours();
            iSerializer.putInt8(by3);
            byte by4 = bCResetTimeStamp.getMinutes();
            iSerializer.putInt8(by4);
        }
    }

    public static void putOptionalBCResetTimeStampVarArray(ISerializer iSerializer, BCResetTimeStamp[] bCResetTimeStampArray) {
        boolean bl = bCResetTimeStampArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCResetTimeStampArray.length);
            for (int i2 = 0; i2 < bCResetTimeStampArray.length; ++i2) {
                BCResetTimeStampSerializer.putOptionalBCResetTimeStamp(iSerializer, bCResetTimeStampArray[i2]);
            }
        }
    }

    public static BCResetTimeStamp getOptionalBCResetTimeStamp(IDeserializer iDeserializer) {
        BCResetTimeStamp bCResetTimeStamp = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            byte by;
            byte by2;
            byte by3;
            byte by4;
            short s;
            bCResetTimeStamp = new BCResetTimeStamp();
            bCResetTimeStamp.year = s = iDeserializer.getInt16();
            bCResetTimeStamp.month = by4 = iDeserializer.getInt8();
            bCResetTimeStamp.day = by3 = iDeserializer.getInt8();
            bCResetTimeStamp.hours = by2 = iDeserializer.getInt8();
            bCResetTimeStamp.minutes = by = iDeserializer.getInt8();
        }
        return bCResetTimeStamp;
    }

    public static BCResetTimeStamp[] getOptionalBCResetTimeStampVarArray(IDeserializer iDeserializer) {
        BCResetTimeStamp[] bCResetTimeStampArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCResetTimeStampArray = new BCResetTimeStamp[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCResetTimeStampArray[i2] = BCResetTimeStampSerializer.getOptionalBCResetTimeStamp(iDeserializer);
            }
        }
        return bCResetTimeStampArray;
    }
}

