/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.networking.DiscoveredNetwork;

public class DiscoveredNetworkSerializer {
    public static void putOptionalDiscoveredNetwork(ISerializer iSerializer, DiscoveredNetwork discoveredNetwork) {
        boolean bl = discoveredNetwork == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = discoveredNetwork.getNetworkName();
            iSerializer.putOptionalString(string);
            String string2 = discoveredNetwork.getBssidAddress();
            iSerializer.putOptionalString(string2);
            int n = discoveredNetwork.getSignalStrength();
            iSerializer.putInt32(n);
            int n2 = discoveredNetwork.getEncryptionType();
            iSerializer.putInt32(n2);
            boolean bl2 = discoveredNetwork.isWpsAvailable();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalDiscoveredNetworkVarArray(ISerializer iSerializer, DiscoveredNetwork[] discoveredNetworkArray) {
        boolean bl = discoveredNetworkArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(discoveredNetworkArray.length);
            for (int i2 = 0; i2 < discoveredNetworkArray.length; ++i2) {
                DiscoveredNetworkSerializer.putOptionalDiscoveredNetwork(iSerializer, discoveredNetworkArray[i2]);
            }
        }
    }

    public static DiscoveredNetwork getOptionalDiscoveredNetwork(IDeserializer iDeserializer) {
        DiscoveredNetwork discoveredNetwork = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            int n;
            int n2;
            String string;
            String string2;
            discoveredNetwork = new DiscoveredNetwork();
            discoveredNetwork.networkName = string2 = iDeserializer.getOptionalString();
            discoveredNetwork.bssidAddress = string = iDeserializer.getOptionalString();
            discoveredNetwork.signalStrength = n2 = iDeserializer.getInt32();
            discoveredNetwork.encryptionType = n = iDeserializer.getInt32();
            discoveredNetwork.wpsAvailable = bl2 = iDeserializer.getBool();
        }
        return discoveredNetwork;
    }

    public static DiscoveredNetwork[] getOptionalDiscoveredNetworkVarArray(IDeserializer iDeserializer) {
        DiscoveredNetwork[] discoveredNetworkArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            discoveredNetworkArray = new DiscoveredNetwork[n];
            for (int i2 = 0; i2 < n; ++i2) {
                discoveredNetworkArray[i2] = DiscoveredNetworkSerializer.getOptionalDiscoveredNetwork(iDeserializer);
            }
        }
        return discoveredNetworkArray;
    }
}

