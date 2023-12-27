/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombifastlist.DataFavoriteList;

public class DataFavoriteListSerializer {
    public static void putOptionalDataFavoriteList(ISerializer iSerializer, DataFavoriteList dataFavoriteList) {
        boolean bl = dataFavoriteList == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = dataFavoriteList.getPos();
            iSerializer.putInt32(n);
            String string = dataFavoriteList.getPbName();
            iSerializer.putOptionalString(string);
            int n2 = dataFavoriteList.getNumberType();
            iSerializer.putInt32(n2);
            String string2 = dataFavoriteList.getTelNumber();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalDataFavoriteListVarArray(ISerializer iSerializer, DataFavoriteList[] dataFavoriteListArray) {
        boolean bl = dataFavoriteListArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dataFavoriteListArray.length);
            for (int i2 = 0; i2 < dataFavoriteListArray.length; ++i2) {
                DataFavoriteListSerializer.putOptionalDataFavoriteList(iSerializer, dataFavoriteListArray[i2]);
            }
        }
    }

    public static DataFavoriteList getOptionalDataFavoriteList(IDeserializer iDeserializer) {
        DataFavoriteList dataFavoriteList = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            String string2;
            int n2;
            dataFavoriteList = new DataFavoriteList();
            dataFavoriteList.pos = n2 = iDeserializer.getInt32();
            dataFavoriteList.pbName = string2 = iDeserializer.getOptionalString();
            dataFavoriteList.numberType = n = iDeserializer.getInt32();
            dataFavoriteList.telNumber = string = iDeserializer.getOptionalString();
        }
        return dataFavoriteList;
    }

    public static DataFavoriteList[] getOptionalDataFavoriteListVarArray(IDeserializer iDeserializer) {
        DataFavoriteList[] dataFavoriteListArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dataFavoriteListArray = new DataFavoriteList[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dataFavoriteListArray[i2] = DataFavoriteListSerializer.getOptionalDataFavoriteList(iDeserializer);
            }
        }
        return dataFavoriteListArray;
    }
}

