/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.NavPhoneData;

public class NavPhoneDataSerializer {
    public static void putOptionalNavPhoneData(ISerializer iSerializer, NavPhoneData navPhoneData) {
        boolean bl = navPhoneData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = navPhoneData.getNumber();
            iSerializer.putOptionalString(string);
            int n = navPhoneData.getNumberType();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalNavPhoneDataVarArray(ISerializer iSerializer, NavPhoneData[] navPhoneDataArray) {
        boolean bl = navPhoneDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navPhoneDataArray.length);
            for (int i2 = 0; i2 < navPhoneDataArray.length; ++i2) {
                NavPhoneDataSerializer.putOptionalNavPhoneData(iSerializer, navPhoneDataArray[i2]);
            }
        }
    }

    public static NavPhoneData getOptionalNavPhoneData(IDeserializer iDeserializer) {
        NavPhoneData navPhoneData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            navPhoneData = new NavPhoneData();
            navPhoneData.number = string = iDeserializer.getOptionalString();
            navPhoneData.numberType = n = iDeserializer.getInt32();
        }
        return navPhoneData;
    }

    public static NavPhoneData[] getOptionalNavPhoneDataVarArray(IDeserializer iDeserializer) {
        NavPhoneData[] navPhoneDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navPhoneDataArray = new NavPhoneData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navPhoneDataArray[i2] = NavPhoneDataSerializer.getOptionalNavPhoneData(iDeserializer);
            }
        }
        return navPhoneDataArray;
    }
}

