/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;

public class BatteryControlPowerProviderAHSerializer {
    public static void putOptionalBatteryControlPowerProviderAH(ISerializer iSerializer, BatteryControlPowerProviderAH batteryControlPowerProviderAH) {
        boolean bl = batteryControlPowerProviderAH == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = batteryControlPowerProviderAH.getArrayContent();
            iSerializer.putInt32(n);
            int n2 = batteryControlPowerProviderAH.getTransactionID();
            iSerializer.putInt32(n2);
            int n3 = batteryControlPowerProviderAH.getRecordContent();
            iSerializer.putInt32(n3);
            int n4 = batteryControlPowerProviderAH.getStartElement();
            iSerializer.putInt32(n4);
            int n5 = batteryControlPowerProviderAH.getNumOfElements();
            iSerializer.putInt32(n5);
            int n6 = batteryControlPowerProviderAH.getAsgID();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalBatteryControlPowerProviderAHVarArray(ISerializer iSerializer, BatteryControlPowerProviderAH[] batteryControlPowerProviderAHArray) {
        boolean bl = batteryControlPowerProviderAHArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlPowerProviderAHArray.length);
            for (int i2 = 0; i2 < batteryControlPowerProviderAHArray.length; ++i2) {
                BatteryControlPowerProviderAHSerializer.putOptionalBatteryControlPowerProviderAH(iSerializer, batteryControlPowerProviderAHArray[i2]);
            }
        }
    }

    public static BatteryControlPowerProviderAH getOptionalBatteryControlPowerProviderAH(IDeserializer iDeserializer) {
        BatteryControlPowerProviderAH batteryControlPowerProviderAH = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            batteryControlPowerProviderAH = new BatteryControlPowerProviderAH();
            batteryControlPowerProviderAH.arrayContent = n6 = iDeserializer.getInt32();
            batteryControlPowerProviderAH.transactionID = n5 = iDeserializer.getInt32();
            batteryControlPowerProviderAH.recordContent = n4 = iDeserializer.getInt32();
            batteryControlPowerProviderAH.startElement = n3 = iDeserializer.getInt32();
            batteryControlPowerProviderAH.numOfElements = n2 = iDeserializer.getInt32();
            batteryControlPowerProviderAH.asgID = n = iDeserializer.getInt32();
        }
        return batteryControlPowerProviderAH;
    }

    public static BatteryControlPowerProviderAH[] getOptionalBatteryControlPowerProviderAHVarArray(IDeserializer iDeserializer) {
        BatteryControlPowerProviderAH[] batteryControlPowerProviderAHArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlPowerProviderAHArray = new BatteryControlPowerProviderAH[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlPowerProviderAHArray[i2] = BatteryControlPowerProviderAHSerializer.getOptionalBatteryControlPowerProviderAH(iDeserializer);
            }
        }
        return batteryControlPowerProviderAHArray;
    }
}

