/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombifastlist.DataCommonList;

public class DataCommonListSerializer {
    public static void putOptionalDataCommonList(ISerializer iSerializer, DataCommonList dataCommonList) {
        boolean bl = dataCommonList == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = dataCommonList.getPos();
            iSerializer.putInt64(l);
            int n = dataCommonList.getSourceType();
            iSerializer.putInt32(n);
            long l2 = dataCommonList.getAttributes();
            iSerializer.putInt64(l2);
            int n2 = dataCommonList.getPresetID();
            iSerializer.putInt32(n2);
            int n3 = dataCommonList.getCategory();
            iSerializer.putInt32(n3);
            String string = dataCommonList.getName();
            iSerializer.putOptionalString(string);
            String string2 = dataCommonList.getFrequency();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalDataCommonListVarArray(ISerializer iSerializer, DataCommonList[] dataCommonListArray) {
        boolean bl = dataCommonListArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dataCommonListArray.length);
            for (int i2 = 0; i2 < dataCommonListArray.length; ++i2) {
                DataCommonListSerializer.putOptionalDataCommonList(iSerializer, dataCommonListArray[i2]);
            }
        }
    }

    public static DataCommonList getOptionalDataCommonList(IDeserializer iDeserializer) {
        DataCommonList dataCommonList = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            int n;
            int n2;
            long l;
            int n3;
            long l2;
            dataCommonList = new DataCommonList();
            dataCommonList.pos = l2 = iDeserializer.getInt64();
            dataCommonList.sourceType = n3 = iDeserializer.getInt32();
            dataCommonList.attributes = l = iDeserializer.getInt64();
            dataCommonList.presetID = n2 = iDeserializer.getInt32();
            dataCommonList.category = n = iDeserializer.getInt32();
            dataCommonList.name = string2 = iDeserializer.getOptionalString();
            dataCommonList.frequency = string = iDeserializer.getOptionalString();
        }
        return dataCommonList;
    }

    public static DataCommonList[] getOptionalDataCommonListVarArray(IDeserializer iDeserializer) {
        DataCommonList[] dataCommonListArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dataCommonListArray = new DataCommonList[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dataCommonListArray[i2] = DataCommonListSerializer.getOptionalDataCommonList(iDeserializer);
            }
        }
        return dataCommonListArray;
    }
}

