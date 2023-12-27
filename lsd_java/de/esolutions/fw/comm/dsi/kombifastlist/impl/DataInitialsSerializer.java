/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombifastlist.DataInitials;

public class DataInitialsSerializer {
    public static void putOptionalDataInitials(ISerializer iSerializer, DataInitials dataInitials) {
        boolean bl = dataInitials == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = dataInitials.getInitial();
            iSerializer.putOptionalString(string);
            int n = dataInitials.getOccuranceCounter();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalDataInitialsVarArray(ISerializer iSerializer, DataInitials[] dataInitialsArray) {
        boolean bl = dataInitialsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dataInitialsArray.length);
            for (int i2 = 0; i2 < dataInitialsArray.length; ++i2) {
                DataInitialsSerializer.putOptionalDataInitials(iSerializer, dataInitialsArray[i2]);
            }
        }
    }

    public static DataInitials getOptionalDataInitials(IDeserializer iDeserializer) {
        DataInitials dataInitials = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            dataInitials = new DataInitials();
            dataInitials.initial = string = iDeserializer.getOptionalString();
            dataInitials.occuranceCounter = n = iDeserializer.getInt32();
        }
        return dataInitials;
    }

    public static DataInitials[] getOptionalDataInitialsVarArray(IDeserializer iDeserializer) {
        DataInitials[] dataInitialsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dataInitialsArray = new DataInitials[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dataInitialsArray[i2] = DataInitialsSerializer.getOptionalDataInitials(iDeserializer);
            }
        }
        return dataInitialsArray;
    }
}

