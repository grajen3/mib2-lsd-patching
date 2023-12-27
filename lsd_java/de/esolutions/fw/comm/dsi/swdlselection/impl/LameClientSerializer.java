/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swdlselection.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.swdlselection.LameClient;

public class LameClientSerializer {
    public static void putOptionalLameClient(ISerializer iSerializer, LameClient lameClient) {
        boolean bl = lameClient == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = lameClient.getDeviceId();
            iSerializer.putOptionalString(string);
            int n = lameClient.getMostId();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalLameClientVarArray(ISerializer iSerializer, LameClient[] lameClientArray) {
        boolean bl = lameClientArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(lameClientArray.length);
            for (int i2 = 0; i2 < lameClientArray.length; ++i2) {
                LameClientSerializer.putOptionalLameClient(iSerializer, lameClientArray[i2]);
            }
        }
    }

    public static LameClient getOptionalLameClient(IDeserializer iDeserializer) {
        LameClient lameClient = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            lameClient = new LameClient();
            lameClient.deviceId = string = iDeserializer.getOptionalString();
            lameClient.mostId = n = iDeserializer.getInt32();
        }
        return lameClient;
    }

    public static LameClient[] getOptionalLameClientVarArray(IDeserializer iDeserializer) {
        LameClient[] lameClientArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            lameClientArray = new LameClient[n];
            for (int i2 = 0; i2 < n; ++i2) {
                lameClientArray[i2] = LameClientSerializer.getOptionalLameClient(iDeserializer);
            }
        }
        return lameClientArray;
    }
}

