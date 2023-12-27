/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.SeatPneumaticContent;

public class SeatPneumaticContentSerializer {
    public static void putOptionalSeatPneumaticContent(ISerializer iSerializer, SeatPneumaticContent seatPneumaticContent) {
        boolean bl = seatPneumaticContent == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = seatPneumaticContent.getContent1RL();
            iSerializer.putInt32(n);
            int n2 = seatPneumaticContent.getContent1RR();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalSeatPneumaticContentVarArray(ISerializer iSerializer, SeatPneumaticContent[] seatPneumaticContentArray) {
        boolean bl = seatPneumaticContentArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(seatPneumaticContentArray.length);
            for (int i2 = 0; i2 < seatPneumaticContentArray.length; ++i2) {
                SeatPneumaticContentSerializer.putOptionalSeatPneumaticContent(iSerializer, seatPneumaticContentArray[i2]);
            }
        }
    }

    public static SeatPneumaticContent getOptionalSeatPneumaticContent(IDeserializer iDeserializer) {
        SeatPneumaticContent seatPneumaticContent = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            seatPneumaticContent = new SeatPneumaticContent();
            seatPneumaticContent.content1RL = n2 = iDeserializer.getInt32();
            seatPneumaticContent.content1RR = n = iDeserializer.getInt32();
        }
        return seatPneumaticContent;
    }

    public static SeatPneumaticContent[] getOptionalSeatPneumaticContentVarArray(IDeserializer iDeserializer) {
        SeatPneumaticContent[] seatPneumaticContentArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            seatPneumaticContentArray = new SeatPneumaticContent[n];
            for (int i2 = 0; i2 < n; ++i2) {
                seatPneumaticContentArray[i2] = SeatPneumaticContentSerializer.getOptionalSeatPneumaticContent(iDeserializer);
            }
        }
        return seatPneumaticContentArray;
    }
}

