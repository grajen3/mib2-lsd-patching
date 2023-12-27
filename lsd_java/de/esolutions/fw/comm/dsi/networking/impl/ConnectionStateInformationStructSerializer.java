/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.networking.ConnectionStateInformationStruct;

public class ConnectionStateInformationStructSerializer {
    public static void putOptionalConnectionStateInformationStruct(ISerializer iSerializer, ConnectionStateInformationStruct connectionStateInformationStruct) {
        boolean bl = connectionStateInformationStruct == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = connectionStateInformationStruct.getConnectionState();
            iSerializer.putInt32(n);
            int n2 = connectionStateInformationStruct.getApplicationID();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalConnectionStateInformationStructVarArray(ISerializer iSerializer, ConnectionStateInformationStruct[] connectionStateInformationStructArray) {
        boolean bl = connectionStateInformationStructArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(connectionStateInformationStructArray.length);
            for (int i2 = 0; i2 < connectionStateInformationStructArray.length; ++i2) {
                ConnectionStateInformationStructSerializer.putOptionalConnectionStateInformationStruct(iSerializer, connectionStateInformationStructArray[i2]);
            }
        }
    }

    public static ConnectionStateInformationStruct getOptionalConnectionStateInformationStruct(IDeserializer iDeserializer) {
        ConnectionStateInformationStruct connectionStateInformationStruct = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            connectionStateInformationStruct = new ConnectionStateInformationStruct();
            connectionStateInformationStruct.connectionState = n2 = iDeserializer.getInt32();
            connectionStateInformationStruct.applicationID = n = iDeserializer.getInt32();
        }
        return connectionStateInformationStruct;
    }

    public static ConnectionStateInformationStruct[] getOptionalConnectionStateInformationStructVarArray(IDeserializer iDeserializer) {
        ConnectionStateInformationStruct[] connectionStateInformationStructArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            connectionStateInformationStructArray = new ConnectionStateInformationStruct[n];
            for (int i2 = 0; i2 < n; ++i2) {
                connectionStateInformationStructArray[i2] = ConnectionStateInformationStructSerializer.getOptionalConnectionStateInformationStruct(iDeserializer);
            }
        }
        return connectionStateInformationStructArray;
    }
}

