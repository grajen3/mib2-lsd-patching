/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.SeatmemoryConfig;

public class SeatmemoryConfigSerializer {
    public static void putOptionalSeatmemoryConfig(ISerializer iSerializer, SeatmemoryConfig seatmemoryConfig) {
        boolean bl = seatmemoryConfig == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = seatmemoryConfig.isSeatmemory1RL();
            iSerializer.putBool(bl2);
            boolean bl3 = seatmemoryConfig.isSeatmemory1RR();
            iSerializer.putBool(bl3);
            boolean bl4 = seatmemoryConfig.isSeatmemory2RL();
            iSerializer.putBool(bl4);
            boolean bl5 = seatmemoryConfig.isSeatmemory2RR();
            iSerializer.putBool(bl5);
            boolean bl6 = seatmemoryConfig.isDriversideLeft();
            iSerializer.putBool(bl6);
            boolean bl7 = seatmemoryConfig.isComfortview();
            iSerializer.putBool(bl7);
            boolean bl8 = seatmemoryConfig.isNormalPosition();
            iSerializer.putBool(bl8);
            boolean bl9 = seatmemoryConfig.isSeatsymmetry();
            iSerializer.putBool(bl9);
            boolean bl10 = seatmemoryConfig.isRelaxPosition();
            iSerializer.putBool(bl10);
            boolean bl11 = seatmemoryConfig.isBusinessPosition();
            iSerializer.putBool(bl11);
            boolean bl12 = seatmemoryConfig.isMultiFunctionSwitcher();
            iSerializer.putBool(bl12);
        }
    }

    public static void putOptionalSeatmemoryConfigVarArray(ISerializer iSerializer, SeatmemoryConfig[] seatmemoryConfigArray) {
        boolean bl = seatmemoryConfigArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(seatmemoryConfigArray.length);
            for (int i2 = 0; i2 < seatmemoryConfigArray.length; ++i2) {
                SeatmemoryConfigSerializer.putOptionalSeatmemoryConfig(iSerializer, seatmemoryConfigArray[i2]);
            }
        }
    }

    public static SeatmemoryConfig getOptionalSeatmemoryConfig(IDeserializer iDeserializer) {
        SeatmemoryConfig seatmemoryConfig = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            boolean bl9;
            boolean bl10;
            boolean bl11;
            boolean bl12;
            seatmemoryConfig = new SeatmemoryConfig();
            seatmemoryConfig.seatmemory1RL = bl12 = iDeserializer.getBool();
            seatmemoryConfig.seatmemory1RR = bl11 = iDeserializer.getBool();
            seatmemoryConfig.seatmemory2RL = bl10 = iDeserializer.getBool();
            seatmemoryConfig.seatmemory2RR = bl9 = iDeserializer.getBool();
            seatmemoryConfig.driversideLeft = bl8 = iDeserializer.getBool();
            seatmemoryConfig.comfortview = bl7 = iDeserializer.getBool();
            seatmemoryConfig.normalPosition = bl6 = iDeserializer.getBool();
            seatmemoryConfig.seatsymmetry = bl5 = iDeserializer.getBool();
            seatmemoryConfig.relaxPosition = bl4 = iDeserializer.getBool();
            seatmemoryConfig.businessPosition = bl3 = iDeserializer.getBool();
            seatmemoryConfig.multiFunctionSwitcher = bl2 = iDeserializer.getBool();
        }
        return seatmemoryConfig;
    }

    public static SeatmemoryConfig[] getOptionalSeatmemoryConfigVarArray(IDeserializer iDeserializer) {
        SeatmemoryConfig[] seatmemoryConfigArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            seatmemoryConfigArray = new SeatmemoryConfig[n];
            for (int i2 = 0; i2 < n; ++i2) {
                seatmemoryConfigArray[i2] = SeatmemoryConfigSerializer.getOptionalSeatmemoryConfig(iDeserializer);
            }
        }
        return seatmemoryConfigArray;
    }
}

