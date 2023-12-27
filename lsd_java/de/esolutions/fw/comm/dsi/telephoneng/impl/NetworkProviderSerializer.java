/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephoneng.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.telephoneng.NetworkProvider;

public class NetworkProviderSerializer {
    public static void putOptionalNetworkProvider(ISerializer iSerializer, NetworkProvider networkProvider) {
        boolean bl = networkProvider == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = networkProvider.getTelLongProviderName();
            iSerializer.putOptionalString(string);
            String string2 = networkProvider.getTelNumProviderName();
            iSerializer.putOptionalString(string2);
            int n = networkProvider.getTelProviderState();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalNetworkProviderVarArray(ISerializer iSerializer, NetworkProvider[] networkProviderArray) {
        boolean bl = networkProviderArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(networkProviderArray.length);
            for (int i2 = 0; i2 < networkProviderArray.length; ++i2) {
                NetworkProviderSerializer.putOptionalNetworkProvider(iSerializer, networkProviderArray[i2]);
            }
        }
    }

    public static NetworkProvider getOptionalNetworkProvider(IDeserializer iDeserializer) {
        NetworkProvider networkProvider = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            String string2;
            networkProvider = new NetworkProvider();
            networkProvider.telLongProviderName = string2 = iDeserializer.getOptionalString();
            networkProvider.telNumProviderName = string = iDeserializer.getOptionalString();
            networkProvider.telProviderState = n = iDeserializer.getInt32();
        }
        return networkProvider;
    }

    public static NetworkProvider[] getOptionalNetworkProviderVarArray(IDeserializer iDeserializer) {
        NetworkProvider[] networkProviderArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            networkProviderArray = new NetworkProvider[n];
            for (int i2 = 0; i2 < n; ++i2) {
                networkProviderArray[i2] = NetworkProviderSerializer.getOptionalNetworkProvider(iDeserializer);
            }
        }
        return networkProviderArray;
    }
}

