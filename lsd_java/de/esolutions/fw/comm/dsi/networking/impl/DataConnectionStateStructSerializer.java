/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.networking.DataConnectionStateStruct;

public class DataConnectionStateStructSerializer {
    public static void putOptionalDataConnectionStateStruct(ISerializer iSerializer, DataConnectionStateStruct dataConnectionStateStruct) {
        boolean bl = dataConnectionStateStruct == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = dataConnectionStateStruct.getContextState();
            iSerializer.putInt32(n);
            int n2 = dataConnectionStateStruct.getOperationMode();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalDataConnectionStateStructVarArray(ISerializer iSerializer, DataConnectionStateStruct[] dataConnectionStateStructArray) {
        boolean bl = dataConnectionStateStructArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dataConnectionStateStructArray.length);
            for (int i2 = 0; i2 < dataConnectionStateStructArray.length; ++i2) {
                DataConnectionStateStructSerializer.putOptionalDataConnectionStateStruct(iSerializer, dataConnectionStateStructArray[i2]);
            }
        }
    }

    public static DataConnectionStateStruct getOptionalDataConnectionStateStruct(IDeserializer iDeserializer) {
        DataConnectionStateStruct dataConnectionStateStruct = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            dataConnectionStateStruct = new DataConnectionStateStruct();
            dataConnectionStateStruct.contextState = n2 = iDeserializer.getInt32();
            dataConnectionStateStruct.operationMode = n = iDeserializer.getInt32();
        }
        return dataConnectionStateStruct;
    }

    public static DataConnectionStateStruct[] getOptionalDataConnectionStateStructVarArray(IDeserializer iDeserializer) {
        DataConnectionStateStruct[] dataConnectionStateStructArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dataConnectionStateStructArray = new DataConnectionStateStruct[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dataConnectionStateStructArray[i2] = DataConnectionStateStructSerializer.getOptionalDataConnectionStateStruct(iDeserializer);
            }
        }
        return dataConnectionStateStructArray;
    }
}

