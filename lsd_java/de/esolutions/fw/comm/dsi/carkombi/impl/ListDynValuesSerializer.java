/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.ListDynValues;

public class ListDynValuesSerializer {
    public static void putOptionalListDynValues(ISerializer iSerializer, ListDynValues listDynValues) {
        boolean bl = listDynValues == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = listDynValues.getPos();
            iSerializer.putInt32(n);
            String string = listDynValues.getDynValue();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalListDynValuesVarArray(ISerializer iSerializer, ListDynValues[] listDynValuesArray) {
        boolean bl = listDynValuesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(listDynValuesArray.length);
            for (int i2 = 0; i2 < listDynValuesArray.length; ++i2) {
                ListDynValuesSerializer.putOptionalListDynValues(iSerializer, listDynValuesArray[i2]);
            }
        }
    }

    public static ListDynValues getOptionalListDynValues(IDeserializer iDeserializer) {
        ListDynValues listDynValues = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            listDynValues = new ListDynValues();
            listDynValues.pos = n = iDeserializer.getInt32();
            listDynValues.dynValue = string = iDeserializer.getOptionalString();
        }
        return listDynValues;
    }

    public static ListDynValues[] getOptionalListDynValuesVarArray(IDeserializer iDeserializer) {
        ListDynValues[] listDynValuesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            listDynValuesArray = new ListDynValues[n];
            for (int i2 = 0; i2 < n; ++i2) {
                listDynValuesArray[i2] = ListDynValuesSerializer.getOptionalListDynValues(iDeserializer);
            }
        }
        return listDynValuesArray;
    }
}

