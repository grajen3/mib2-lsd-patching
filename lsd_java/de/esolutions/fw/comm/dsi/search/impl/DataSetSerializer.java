/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.dsi.search.impl.SearchableSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.Searchable;

public class DataSetSerializer {
    public static void putOptionalDataSet(ISerializer iSerializer, DataSet dataSet) {
        boolean bl = dataSet == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = dataSet.getId();
            iSerializer.putInt64(l);
            int n = dataSet.getEntryType();
            iSerializer.putInt32(n);
            int n2 = dataSet.getEntryFlags();
            iSerializer.putInt32(n2);
            Searchable[] searchableArray = dataSet.getData();
            SearchableSerializer.putOptionalSearchableVarArray(iSerializer, searchableArray);
        }
    }

    public static void putOptionalDataSetVarArray(ISerializer iSerializer, DataSet[] dataSetArray) {
        boolean bl = dataSetArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dataSetArray.length);
            for (int i2 = 0; i2 < dataSetArray.length; ++i2) {
                DataSetSerializer.putOptionalDataSet(iSerializer, dataSetArray[i2]);
            }
        }
    }

    public static DataSet getOptionalDataSet(IDeserializer iDeserializer) {
        DataSet dataSet = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            long l;
            dataSet = new DataSet();
            dataSet.id = l = iDeserializer.getInt64();
            dataSet.entryType = n2 = iDeserializer.getInt32();
            dataSet.entryFlags = n = iDeserializer.getInt32();
            Searchable[] searchableArray = SearchableSerializer.getOptionalSearchableVarArray(iDeserializer);
            dataSet.data = searchableArray;
        }
        return dataSet;
    }

    public static DataSet[] getOptionalDataSetVarArray(IDeserializer iDeserializer) {
        DataSet[] dataSetArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dataSetArray = new DataSet[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dataSetArray[i2] = DataSetSerializer.getOptionalDataSet(iDeserializer);
            }
        }
        return dataSetArray;
    }
}

