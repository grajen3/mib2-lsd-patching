/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombifastlist.DataReceptionList;

public class DataReceptionListSerializer {
    public static void putOptionalDataReceptionList(ISerializer iSerializer, DataReceptionList dataReceptionList) {
        boolean bl = dataReceptionList == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = dataReceptionList.getPos();
            iSerializer.putInt64(l);
            int n = dataReceptionList.getElementType();
            iSerializer.putInt32(n);
            int n2 = dataReceptionList.getType();
            iSerializer.putInt32(n2);
            long l2 = dataReceptionList.getAttributes();
            iSerializer.putInt64(l2);
            int n3 = dataReceptionList.getPresetID();
            iSerializer.putInt32(n3);
            int n4 = dataReceptionList.getFmREGCode();
            iSerializer.putInt32(n4);
            int n5 = dataReceptionList.getCategory();
            iSerializer.putInt32(n5);
            String string = dataReceptionList.getNameReceptionList();
            iSerializer.putOptionalString(string);
            String string2 = dataReceptionList.getFrequency();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalDataReceptionListVarArray(ISerializer iSerializer, DataReceptionList[] dataReceptionListArray) {
        boolean bl = dataReceptionListArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dataReceptionListArray.length);
            for (int i2 = 0; i2 < dataReceptionListArray.length; ++i2) {
                DataReceptionListSerializer.putOptionalDataReceptionList(iSerializer, dataReceptionListArray[i2]);
            }
        }
    }

    public static DataReceptionList getOptionalDataReceptionList(IDeserializer iDeserializer) {
        DataReceptionList dataReceptionList = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            int n;
            int n2;
            int n3;
            long l;
            int n4;
            int n5;
            long l2;
            dataReceptionList = new DataReceptionList();
            dataReceptionList.pos = l2 = iDeserializer.getInt64();
            dataReceptionList.elementType = n5 = iDeserializer.getInt32();
            dataReceptionList.type = n4 = iDeserializer.getInt32();
            dataReceptionList.attributes = l = iDeserializer.getInt64();
            dataReceptionList.presetID = n3 = iDeserializer.getInt32();
            dataReceptionList.fmREGCode = n2 = iDeserializer.getInt32();
            dataReceptionList.category = n = iDeserializer.getInt32();
            dataReceptionList.nameReceptionList = string2 = iDeserializer.getOptionalString();
            dataReceptionList.frequency = string = iDeserializer.getOptionalString();
        }
        return dataReceptionList;
    }

    public static DataReceptionList[] getOptionalDataReceptionListVarArray(IDeserializer iDeserializer) {
        DataReceptionList[] dataReceptionListArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dataReceptionListArray = new DataReceptionList[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dataReceptionListArray[i2] = DataReceptionListSerializer.getOptionalDataReceptionList(iDeserializer);
            }
        }
        return dataReceptionListArray;
    }
}

