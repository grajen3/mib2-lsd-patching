/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.ListWarningIDsDynValues;

public class ListWarningIDsDynValuesSerializer {
    public static void putOptionalListWarningIDsDynValues(ISerializer iSerializer, ListWarningIDsDynValues listWarningIDsDynValues) {
        boolean bl = listWarningIDsDynValues == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = listWarningIDsDynValues.getPos();
            iSerializer.putInt32(n);
            int n2 = listWarningIDsDynValues.getWarningID();
            iSerializer.putInt32(n2);
            String string = listWarningIDsDynValues.getDynValue();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalListWarningIDsDynValuesVarArray(ISerializer iSerializer, ListWarningIDsDynValues[] listWarningIDsDynValuesArray) {
        boolean bl = listWarningIDsDynValuesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(listWarningIDsDynValuesArray.length);
            for (int i2 = 0; i2 < listWarningIDsDynValuesArray.length; ++i2) {
                ListWarningIDsDynValuesSerializer.putOptionalListWarningIDsDynValues(iSerializer, listWarningIDsDynValuesArray[i2]);
            }
        }
    }

    public static ListWarningIDsDynValues getOptionalListWarningIDsDynValues(IDeserializer iDeserializer) {
        ListWarningIDsDynValues listWarningIDsDynValues = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            int n2;
            listWarningIDsDynValues = new ListWarningIDsDynValues();
            listWarningIDsDynValues.pos = n2 = iDeserializer.getInt32();
            listWarningIDsDynValues.warningID = n = iDeserializer.getInt32();
            listWarningIDsDynValues.dynValue = string = iDeserializer.getOptionalString();
        }
        return listWarningIDsDynValues;
    }

    public static ListWarningIDsDynValues[] getOptionalListWarningIDsDynValuesVarArray(IDeserializer iDeserializer) {
        ListWarningIDsDynValues[] listWarningIDsDynValuesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            listWarningIDsDynValuesArray = new ListWarningIDsDynValues[n];
            for (int i2 = 0; i2 < n; ++i2) {
                listWarningIDsDynValuesArray[i2] = ListWarningIDsDynValuesSerializer.getOptionalListWarningIDsDynValues(iDeserializer);
            }
        }
        return listWarningIDsDynValuesArray;
    }
}

