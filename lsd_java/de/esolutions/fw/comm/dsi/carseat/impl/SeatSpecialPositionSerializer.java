/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.SeatSpecialPosition;

public class SeatSpecialPositionSerializer {
    public static void putOptionalSeatSpecialPosition(ISerializer iSerializer, SeatSpecialPosition seatSpecialPosition) {
        boolean bl = seatSpecialPosition == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = seatSpecialPosition.getPosition();
            iSerializer.putInt32(n);
            boolean bl2 = seatSpecialPosition.isSeat1RL();
            iSerializer.putBool(bl2);
            boolean bl3 = seatSpecialPosition.isSeat1RR();
            iSerializer.putBool(bl3);
            boolean bl4 = seatSpecialPosition.isSeat2RL();
            iSerializer.putBool(bl4);
            boolean bl5 = seatSpecialPosition.isSeat2RR();
            iSerializer.putBool(bl5);
            boolean bl6 = seatSpecialPosition.isSeat3RL();
            iSerializer.putBool(bl6);
            boolean bl7 = seatSpecialPosition.isSeat3RR();
            iSerializer.putBool(bl7);
        }
    }

    public static void putOptionalSeatSpecialPositionVarArray(ISerializer iSerializer, SeatSpecialPosition[] seatSpecialPositionArray) {
        boolean bl = seatSpecialPositionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(seatSpecialPositionArray.length);
            for (int i2 = 0; i2 < seatSpecialPositionArray.length; ++i2) {
                SeatSpecialPositionSerializer.putOptionalSeatSpecialPosition(iSerializer, seatSpecialPositionArray[i2]);
            }
        }
    }

    public static SeatSpecialPosition getOptionalSeatSpecialPosition(IDeserializer iDeserializer) {
        SeatSpecialPosition seatSpecialPosition = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            int n;
            seatSpecialPosition = new SeatSpecialPosition();
            seatSpecialPosition.position = n = iDeserializer.getInt32();
            seatSpecialPosition.seat1RL = bl7 = iDeserializer.getBool();
            seatSpecialPosition.seat1RR = bl6 = iDeserializer.getBool();
            seatSpecialPosition.seat2RL = bl5 = iDeserializer.getBool();
            seatSpecialPosition.seat2RR = bl4 = iDeserializer.getBool();
            seatSpecialPosition.seat3RL = bl3 = iDeserializer.getBool();
            seatSpecialPosition.seat3RR = bl2 = iDeserializer.getBool();
        }
        return seatSpecialPosition;
    }

    public static SeatSpecialPosition[] getOptionalSeatSpecialPositionVarArray(IDeserializer iDeserializer) {
        SeatSpecialPosition[] seatSpecialPositionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            seatSpecialPositionArray = new SeatSpecialPosition[n];
            for (int i2 = 0; i2 < n; ++i2) {
                seatSpecialPositionArray[i2] = SeatSpecialPositionSerializer.getOptionalSeatSpecialPosition(iDeserializer);
            }
        }
        return seatSpecialPositionArray;
    }
}

