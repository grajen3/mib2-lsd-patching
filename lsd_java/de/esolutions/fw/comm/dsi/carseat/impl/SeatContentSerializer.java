/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.SeatContent;

public class SeatContentSerializer {
    public static void putOptionalSeatContent(ISerializer iSerializer, SeatContent seatContent) {
        boolean bl = seatContent == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = seatContent.getContent1RL();
            iSerializer.putInt32(n);
            int n2 = seatContent.getMemoryDetail1RL();
            iSerializer.putInt32(n2);
            int n3 = seatContent.getContent1RR();
            iSerializer.putInt32(n3);
            int n4 = seatContent.getMemoryDetail1RR();
            iSerializer.putInt32(n4);
            int n5 = seatContent.getContent2RL();
            iSerializer.putInt32(n5);
            int n6 = seatContent.getMemoryDetail2RL();
            iSerializer.putInt32(n6);
            int n7 = seatContent.getContent2RR();
            iSerializer.putInt32(n7);
            int n8 = seatContent.getMemoryDetail2RR();
            iSerializer.putInt32(n8);
        }
    }

    public static void putOptionalSeatContentVarArray(ISerializer iSerializer, SeatContent[] seatContentArray) {
        boolean bl = seatContentArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(seatContentArray.length);
            for (int i2 = 0; i2 < seatContentArray.length; ++i2) {
                SeatContentSerializer.putOptionalSeatContent(iSerializer, seatContentArray[i2]);
            }
        }
    }

    public static SeatContent getOptionalSeatContent(IDeserializer iDeserializer) {
        SeatContent seatContent = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            seatContent = new SeatContent();
            seatContent.content1RL = n8 = iDeserializer.getInt32();
            seatContent.memoryDetail1RL = n7 = iDeserializer.getInt32();
            seatContent.content1RR = n6 = iDeserializer.getInt32();
            seatContent.memoryDetail1RR = n5 = iDeserializer.getInt32();
            seatContent.content2RL = n4 = iDeserializer.getInt32();
            seatContent.memoryDetail2RL = n3 = iDeserializer.getInt32();
            seatContent.content2RR = n2 = iDeserializer.getInt32();
            seatContent.memoryDetail2RR = n = iDeserializer.getInt32();
        }
        return seatContent;
    }

    public static SeatContent[] getOptionalSeatContentVarArray(IDeserializer iDeserializer) {
        SeatContent[] seatContentArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            seatContentArray = new SeatContent[n];
            for (int i2 = 0; i2 < n; ++i2) {
                seatContentArray[i2] = SeatContentSerializer.getOptionalSeatContent(iDeserializer);
            }
        }
        return seatContentArray;
    }
}

