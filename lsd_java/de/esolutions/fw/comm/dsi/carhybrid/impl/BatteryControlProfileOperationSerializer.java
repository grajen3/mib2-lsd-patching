/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;

public class BatteryControlProfileOperationSerializer {
    public static void putOptionalBatteryControlProfileOperation(ISerializer iSerializer, BatteryControlProfileOperation batteryControlProfileOperation) {
        boolean bl = batteryControlProfileOperation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = batteryControlProfileOperation.isCharge();
            iSerializer.putBool(bl2);
            boolean bl3 = batteryControlProfileOperation.isClimate();
            iSerializer.putBool(bl3);
            boolean bl4 = batteryControlProfileOperation.isClimateWithoutExternalSupply();
            iSerializer.putBool(bl4);
            boolean bl5 = batteryControlProfileOperation.isAutoDefrost();
            iSerializer.putBool(bl5);
            boolean bl6 = batteryControlProfileOperation.isSeatHeaterFrontLeft();
            iSerializer.putBool(bl6);
            boolean bl7 = batteryControlProfileOperation.isSeatHeaterFrontRight();
            iSerializer.putBool(bl7);
            boolean bl8 = batteryControlProfileOperation.isSeatHeaterRearLeft();
            iSerializer.putBool(bl8);
            boolean bl9 = batteryControlProfileOperation.isSeatHeaterRearRight();
            iSerializer.putBool(bl9);
        }
    }

    public static void putOptionalBatteryControlProfileOperationVarArray(ISerializer iSerializer, BatteryControlProfileOperation[] batteryControlProfileOperationArray) {
        boolean bl = batteryControlProfileOperationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlProfileOperationArray.length);
            for (int i2 = 0; i2 < batteryControlProfileOperationArray.length; ++i2) {
                BatteryControlProfileOperationSerializer.putOptionalBatteryControlProfileOperation(iSerializer, batteryControlProfileOperationArray[i2]);
            }
        }
    }

    public static BatteryControlProfileOperation getOptionalBatteryControlProfileOperation(IDeserializer iDeserializer) {
        BatteryControlProfileOperation batteryControlProfileOperation = null;
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
            batteryControlProfileOperation = new BatteryControlProfileOperation();
            batteryControlProfileOperation.charge = bl9 = iDeserializer.getBool();
            batteryControlProfileOperation.climate = bl8 = iDeserializer.getBool();
            batteryControlProfileOperation.climateWithoutExternalSupply = bl7 = iDeserializer.getBool();
            batteryControlProfileOperation.autoDefrost = bl6 = iDeserializer.getBool();
            batteryControlProfileOperation.seatHeaterFrontLeft = bl5 = iDeserializer.getBool();
            batteryControlProfileOperation.seatHeaterFrontRight = bl4 = iDeserializer.getBool();
            batteryControlProfileOperation.seatHeaterRearLeft = bl3 = iDeserializer.getBool();
            batteryControlProfileOperation.seatHeaterRearRight = bl2 = iDeserializer.getBool();
        }
        return batteryControlProfileOperation;
    }

    public static BatteryControlProfileOperation[] getOptionalBatteryControlProfileOperationVarArray(IDeserializer iDeserializer) {
        BatteryControlProfileOperation[] batteryControlProfileOperationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlProfileOperationArray = new BatteryControlProfileOperation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlProfileOperationArray[i2] = BatteryControlProfileOperationSerializer.getOptionalBatteryControlProfileOperation(iDeserializer);
            }
        }
        return batteryControlProfileOperationArray;
    }
}

