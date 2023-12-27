/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.OperatorCallAddressEntry;

public class OperatorCallAddressEntrySerializer {
    public static void putOptionalOperatorCallAddressEntry(ISerializer iSerializer, OperatorCallAddressEntry operatorCallAddressEntry) {
        boolean bl = operatorCallAddressEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = operatorCallAddressEntry.getStreet();
            iSerializer.putOptionalString(string);
            String string2 = operatorCallAddressEntry.getZip();
            iSerializer.putOptionalString(string2);
            String string3 = operatorCallAddressEntry.getCity();
            iSerializer.putOptionalString(string3);
            String string4 = operatorCallAddressEntry.getRegion();
            iSerializer.putOptionalString(string4);
            String string5 = operatorCallAddressEntry.getCountry();
            iSerializer.putOptionalString(string5);
            String string6 = operatorCallAddressEntry.getPhoneNumber();
            iSerializer.putOptionalString(string6);
            String string7 = operatorCallAddressEntry.getUrl();
            iSerializer.putOptionalString(string7);
            String string8 = operatorCallAddressEntry.getStatusURL();
            iSerializer.putOptionalString(string8);
        }
    }

    public static void putOptionalOperatorCallAddressEntryVarArray(ISerializer iSerializer, OperatorCallAddressEntry[] operatorCallAddressEntryArray) {
        boolean bl = operatorCallAddressEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(operatorCallAddressEntryArray.length);
            for (int i2 = 0; i2 < operatorCallAddressEntryArray.length; ++i2) {
                OperatorCallAddressEntrySerializer.putOptionalOperatorCallAddressEntry(iSerializer, operatorCallAddressEntryArray[i2]);
            }
        }
    }

    public static OperatorCallAddressEntry getOptionalOperatorCallAddressEntry(IDeserializer iDeserializer) {
        OperatorCallAddressEntry operatorCallAddressEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            String string8;
            operatorCallAddressEntry = new OperatorCallAddressEntry();
            operatorCallAddressEntry.street = string8 = iDeserializer.getOptionalString();
            operatorCallAddressEntry.zip = string7 = iDeserializer.getOptionalString();
            operatorCallAddressEntry.city = string6 = iDeserializer.getOptionalString();
            operatorCallAddressEntry.region = string5 = iDeserializer.getOptionalString();
            operatorCallAddressEntry.country = string4 = iDeserializer.getOptionalString();
            operatorCallAddressEntry.phoneNumber = string3 = iDeserializer.getOptionalString();
            operatorCallAddressEntry.url = string2 = iDeserializer.getOptionalString();
            operatorCallAddressEntry.statusURL = string = iDeserializer.getOptionalString();
        }
        return operatorCallAddressEntry;
    }

    public static OperatorCallAddressEntry[] getOptionalOperatorCallAddressEntryVarArray(IDeserializer iDeserializer) {
        OperatorCallAddressEntry[] operatorCallAddressEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            operatorCallAddressEntryArray = new OperatorCallAddressEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                operatorCallAddressEntryArray[i2] = OperatorCallAddressEntrySerializer.getOptionalOperatorCallAddressEntry(iDeserializer);
            }
        }
        return operatorCallAddressEntryArray;
    }
}

