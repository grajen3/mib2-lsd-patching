/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.SeatAdjustment;

public class SeatAdjustmentSerializer {
    public static void putOptionalSeatAdjustment(ISerializer iSerializer, SeatAdjustment seatAdjustment) {
        boolean bl = seatAdjustment == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = seatAdjustment.getPosition();
            iSerializer.putInt32(n);
            boolean bl2 = seatAdjustment.isSitzhoehe();
            iSerializer.putBool(bl2);
            boolean bl3 = seatAdjustment.isSitzlaenge();
            iSerializer.putBool(bl3);
            boolean bl4 = seatAdjustment.isLehnenneigung();
            iSerializer.putBool(bl4);
            boolean bl5 = seatAdjustment.isSitzflaechenneigung();
            iSerializer.putBool(bl5);
            boolean bl6 = seatAdjustment.isKopfstuetze();
            iSerializer.putBool(bl6);
        }
    }

    public static void putOptionalSeatAdjustmentVarArray(ISerializer iSerializer, SeatAdjustment[] seatAdjustmentArray) {
        boolean bl = seatAdjustmentArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(seatAdjustmentArray.length);
            for (int i2 = 0; i2 < seatAdjustmentArray.length; ++i2) {
                SeatAdjustmentSerializer.putOptionalSeatAdjustment(iSerializer, seatAdjustmentArray[i2]);
            }
        }
    }

    public static SeatAdjustment getOptionalSeatAdjustment(IDeserializer iDeserializer) {
        SeatAdjustment seatAdjustment = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            int n;
            seatAdjustment = new SeatAdjustment();
            seatAdjustment.position = n = iDeserializer.getInt32();
            seatAdjustment.sitzhoehe = bl6 = iDeserializer.getBool();
            seatAdjustment.sitzlaenge = bl5 = iDeserializer.getBool();
            seatAdjustment.lehnenneigung = bl4 = iDeserializer.getBool();
            seatAdjustment.sitzflaechenneigung = bl3 = iDeserializer.getBool();
            seatAdjustment.kopfstuetze = bl2 = iDeserializer.getBool();
        }
        return seatAdjustment;
    }

    public static SeatAdjustment[] getOptionalSeatAdjustmentVarArray(IDeserializer iDeserializer) {
        SeatAdjustment[] seatAdjustmentArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            seatAdjustmentArray = new SeatAdjustment[n];
            for (int i2 = 0; i2 < n; ++i2) {
                seatAdjustmentArray[i2] = SeatAdjustmentSerializer.getOptionalSeatAdjustment(iDeserializer);
            }
        }
        return seatAdjustmentArray;
    }
}

