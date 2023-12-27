/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;

public class BatteryControlProfilesAHSerializer {
    public static void putOptionalBatteryControlProfilesAH(ISerializer iSerializer, BatteryControlProfilesAH batteryControlProfilesAH) {
        boolean bl = batteryControlProfilesAH == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = batteryControlProfilesAH.getArrayContent();
            iSerializer.putInt32(n);
            int n2 = batteryControlProfilesAH.getRecordContent();
            iSerializer.putInt32(n2);
            int n3 = batteryControlProfilesAH.getStartElement();
            iSerializer.putInt32(n3);
            int n4 = batteryControlProfilesAH.getNumOfElements();
            iSerializer.putInt32(n4);
            int n5 = batteryControlProfilesAH.getTransactionID();
            iSerializer.putInt32(n5);
            int n6 = batteryControlProfilesAH.getAsgID();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalBatteryControlProfilesAHVarArray(ISerializer iSerializer, BatteryControlProfilesAH[] batteryControlProfilesAHArray) {
        boolean bl = batteryControlProfilesAHArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(batteryControlProfilesAHArray.length);
            for (int i2 = 0; i2 < batteryControlProfilesAHArray.length; ++i2) {
                BatteryControlProfilesAHSerializer.putOptionalBatteryControlProfilesAH(iSerializer, batteryControlProfilesAHArray[i2]);
            }
        }
    }

    public static BatteryControlProfilesAH getOptionalBatteryControlProfilesAH(IDeserializer iDeserializer) {
        BatteryControlProfilesAH batteryControlProfilesAH = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            batteryControlProfilesAH = new BatteryControlProfilesAH();
            batteryControlProfilesAH.arrayContent = n6 = iDeserializer.getInt32();
            batteryControlProfilesAH.recordContent = n5 = iDeserializer.getInt32();
            batteryControlProfilesAH.startElement = n4 = iDeserializer.getInt32();
            batteryControlProfilesAH.numOfElements = n3 = iDeserializer.getInt32();
            batteryControlProfilesAH.transactionID = n2 = iDeserializer.getInt32();
            batteryControlProfilesAH.asgID = n = iDeserializer.getInt32();
        }
        return batteryControlProfilesAH;
    }

    public static BatteryControlProfilesAH[] getOptionalBatteryControlProfilesAHVarArray(IDeserializer iDeserializer) {
        BatteryControlProfilesAH[] batteryControlProfilesAHArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            batteryControlProfilesAHArray = new BatteryControlProfilesAH[n];
            for (int i2 = 0; i2 < n; ++i2) {
                batteryControlProfilesAHArray[i2] = BatteryControlProfilesAHSerializer.getOptionalBatteryControlProfilesAH(iDeserializer);
            }
        }
        return batteryControlProfilesAHArray;
    }
}

