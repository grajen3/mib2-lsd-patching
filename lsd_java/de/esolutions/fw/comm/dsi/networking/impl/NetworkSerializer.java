/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.networking.Network;

public class NetworkSerializer {
    public static void putOptionalNetwork(ISerializer iSerializer, Network network) {
        boolean bl = network == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = network.getMacAccessPoint();
            iSerializer.putOptionalString(string);
            int n = network.getChannel();
            iSerializer.putInt32(n);
            String string2 = network.getSSID();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalNetworkVarArray(ISerializer iSerializer, Network[] networkArray) {
        boolean bl = networkArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(networkArray.length);
            for (int i2 = 0; i2 < networkArray.length; ++i2) {
                NetworkSerializer.putOptionalNetwork(iSerializer, networkArray[i2]);
            }
        }
    }

    public static Network getOptionalNetwork(IDeserializer iDeserializer) {
        Network network = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            String string2;
            network = new Network();
            network.macAccessPoint = string2 = iDeserializer.getOptionalString();
            network.channel = n = iDeserializer.getInt32();
            network.sSID = string = iDeserializer.getOptionalString();
        }
        return network;
    }

    public static Network[] getOptionalNetworkVarArray(IDeserializer iDeserializer) {
        Network[] networkArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            networkArray = new Network[n];
            for (int i2 = 0; i2 < n; ++i2) {
                networkArray[i2] = NetworkSerializer.getOptionalNetwork(iDeserializer);
            }
        }
        return networkArray;
    }
}

