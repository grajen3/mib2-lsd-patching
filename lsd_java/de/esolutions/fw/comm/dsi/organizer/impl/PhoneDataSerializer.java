/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.organizer.PhoneData;

public class PhoneDataSerializer {
    public static void putOptionalPhoneData(ISerializer iSerializer, PhoneData phoneData) {
        boolean bl = phoneData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = phoneData.getNumber();
            iSerializer.putOptionalString(string);
            int n = phoneData.getNumberType();
            iSerializer.putInt32(n);
            int n2 = phoneData.getSpeedDialKey();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalPhoneDataVarArray(ISerializer iSerializer, PhoneData[] phoneDataArray) {
        boolean bl = phoneDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(phoneDataArray.length);
            for (int i2 = 0; i2 < phoneDataArray.length; ++i2) {
                PhoneDataSerializer.putOptionalPhoneData(iSerializer, phoneDataArray[i2]);
            }
        }
    }

    public static PhoneData getOptionalPhoneData(IDeserializer iDeserializer) {
        PhoneData phoneData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            String string;
            phoneData = new PhoneData();
            phoneData.number = string = iDeserializer.getOptionalString();
            phoneData.numberType = n2 = iDeserializer.getInt32();
            phoneData.speedDialKey = n = iDeserializer.getInt32();
        }
        return phoneData;
    }

    public static PhoneData[] getOptionalPhoneDataVarArray(IDeserializer iDeserializer) {
        PhoneData[] phoneDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            phoneDataArray = new PhoneData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                phoneDataArray[i2] = PhoneDataSerializer.getOptionalPhoneData(iDeserializer);
            }
        }
        return phoneDataArray;
    }
}

