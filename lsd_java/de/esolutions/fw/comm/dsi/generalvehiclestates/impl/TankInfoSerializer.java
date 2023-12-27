/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.generalvehiclestates.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.generalvehiclestates.TankInfo;

public class TankInfoSerializer {
    public static void putOptionalTankInfo(ISerializer iSerializer, TankInfo tankInfo) {
        boolean bl = tankInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = tankInfo.isFuelWarning();
            iSerializer.putBool(bl2);
            boolean bl3 = tankInfo.isFuelLevelState();
            iSerializer.putBool(bl3);
            boolean bl4 = tankInfo.isFuelWarningSecondary();
            iSerializer.putBool(bl4);
        }
    }

    public static void putOptionalTankInfoVarArray(ISerializer iSerializer, TankInfo[] tankInfoArray) {
        boolean bl = tankInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tankInfoArray.length);
            for (int i2 = 0; i2 < tankInfoArray.length; ++i2) {
                TankInfoSerializer.putOptionalTankInfo(iSerializer, tankInfoArray[i2]);
            }
        }
    }

    public static TankInfo getOptionalTankInfo(IDeserializer iDeserializer) {
        TankInfo tankInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            tankInfo = new TankInfo();
            tankInfo.fuelWarning = bl4 = iDeserializer.getBool();
            tankInfo.fuelLevelState = bl3 = iDeserializer.getBool();
            tankInfo.fuelWarningSecondary = bl2 = iDeserializer.getBool();
        }
        return tankInfo;
    }

    public static TankInfo[] getOptionalTankInfoVarArray(IDeserializer iDeserializer) {
        TankInfo[] tankInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tankInfoArray = new TankInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tankInfoArray[i2] = TankInfoSerializer.getOptionalTankInfo(iDeserializer);
            }
        }
        return tankInfoArray;
    }
}

