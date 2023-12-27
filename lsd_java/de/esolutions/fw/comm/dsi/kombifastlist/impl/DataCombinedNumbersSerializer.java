/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombifastlist.DataCombinedNumbers;

public class DataCombinedNumbersSerializer {
    public static void putOptionalDataCombinedNumbers(ISerializer iSerializer, DataCombinedNumbers dataCombinedNumbers) {
        boolean bl = dataCombinedNumbers == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = dataCombinedNumbers.getPos();
            iSerializer.putInt32(n);
            String string = dataCombinedNumbers.getPbName();
            iSerializer.putOptionalString(string);
            int n2 = dataCombinedNumbers.getNumberType();
            iSerializer.putInt32(n2);
            int n3 = dataCombinedNumbers.getCallMode();
            iSerializer.putInt32(n3);
            String string2 = dataCombinedNumbers.getTelNumber();
            iSerializer.putOptionalString(string2);
            int n4 = dataCombinedNumbers.getDay();
            iSerializer.putInt32(n4);
            int n5 = dataCombinedNumbers.getMonth();
            iSerializer.putInt32(n5);
            int n6 = dataCombinedNumbers.getYear();
            iSerializer.putInt32(n6);
            int n7 = dataCombinedNumbers.getHour();
            iSerializer.putInt32(n7);
            int n8 = dataCombinedNumbers.getMinute();
            iSerializer.putInt32(n8);
            int n9 = dataCombinedNumbers.getSecond();
            iSerializer.putInt32(n9);
        }
    }

    public static void putOptionalDataCombinedNumbersVarArray(ISerializer iSerializer, DataCombinedNumbers[] dataCombinedNumbersArray) {
        boolean bl = dataCombinedNumbersArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dataCombinedNumbersArray.length);
            for (int i2 = 0; i2 < dataCombinedNumbersArray.length; ++i2) {
                DataCombinedNumbersSerializer.putOptionalDataCombinedNumbers(iSerializer, dataCombinedNumbersArray[i2]);
            }
        }
    }

    public static DataCombinedNumbers getOptionalDataCombinedNumbers(IDeserializer iDeserializer) {
        DataCombinedNumbers dataCombinedNumbers = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            String string;
            int n7;
            int n8;
            String string2;
            int n9;
            dataCombinedNumbers = new DataCombinedNumbers();
            dataCombinedNumbers.pos = n9 = iDeserializer.getInt32();
            dataCombinedNumbers.pbName = string2 = iDeserializer.getOptionalString();
            dataCombinedNumbers.numberType = n8 = iDeserializer.getInt32();
            dataCombinedNumbers.callMode = n7 = iDeserializer.getInt32();
            dataCombinedNumbers.telNumber = string = iDeserializer.getOptionalString();
            dataCombinedNumbers.day = n6 = iDeserializer.getInt32();
            dataCombinedNumbers.month = n5 = iDeserializer.getInt32();
            dataCombinedNumbers.year = n4 = iDeserializer.getInt32();
            dataCombinedNumbers.hour = n3 = iDeserializer.getInt32();
            dataCombinedNumbers.minute = n2 = iDeserializer.getInt32();
            dataCombinedNumbers.second = n = iDeserializer.getInt32();
        }
        return dataCombinedNumbers;
    }

    public static DataCombinedNumbers[] getOptionalDataCombinedNumbersVarArray(IDeserializer iDeserializer) {
        DataCombinedNumbers[] dataCombinedNumbersArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dataCombinedNumbersArray = new DataCombinedNumbers[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dataCombinedNumbersArray[i2] = DataCombinedNumbersSerializer.getOptionalDataCombinedNumbers(iDeserializer);
            }
        }
        return dataCombinedNumbersArray;
    }
}

