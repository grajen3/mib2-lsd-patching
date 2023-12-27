/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephone.NetworkProviderName;

public class NetworkProviderNameSerializer {
    public static void putOptionalNetworkProviderName(ISerializer iSerializer, NetworkProviderName networkProviderName) {
        boolean bl = networkProviderName == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = networkProviderName.getTelLongProviderName();
            iSerializer.putOptionalString(string);
            String string2 = networkProviderName.getTelNumProviderName();
            iSerializer.putOptionalString(string2);
            int n = networkProviderName.getTelRegMode();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalNetworkProviderNameVarArray(ISerializer iSerializer, NetworkProviderName[] networkProviderNameArray) {
        boolean bl = networkProviderNameArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(networkProviderNameArray.length);
            for (int i2 = 0; i2 < networkProviderNameArray.length; ++i2) {
                NetworkProviderNameSerializer.putOptionalNetworkProviderName(iSerializer, networkProviderNameArray[i2]);
            }
        }
    }

    public static NetworkProviderName getOptionalNetworkProviderName(IDeserializer iDeserializer) {
        NetworkProviderName networkProviderName = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            String string2;
            networkProviderName = new NetworkProviderName();
            networkProviderName.telLongProviderName = string2 = iDeserializer.getOptionalString();
            networkProviderName.telNumProviderName = string = iDeserializer.getOptionalString();
            networkProviderName.telRegMode = n = iDeserializer.getInt32();
        }
        return networkProviderName;
    }

    public static NetworkProviderName[] getOptionalNetworkProviderNameVarArray(IDeserializer iDeserializer) {
        NetworkProviderName[] networkProviderNameArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            networkProviderNameArray = new NetworkProviderName[n];
            for (int i2 = 0; i2 < n; ++i2) {
                networkProviderNameArray[i2] = NetworkProviderNameSerializer.getOptionalNetworkProviderName(iDeserializer);
            }
        }
        return networkProviderNameArray;
    }
}

