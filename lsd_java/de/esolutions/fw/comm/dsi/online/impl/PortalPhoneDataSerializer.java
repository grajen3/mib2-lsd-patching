/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.PortalPhoneData;

public class PortalPhoneDataSerializer {
    public static void putOptionalPortalPhoneData(ISerializer iSerializer, PortalPhoneData portalPhoneData) {
        boolean bl = portalPhoneData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = portalPhoneData.getNumber();
            iSerializer.putOptionalString(string);
            long l = portalPhoneData.getType();
            iSerializer.putInt64(l);
        }
    }

    public static void putOptionalPortalPhoneDataVarArray(ISerializer iSerializer, PortalPhoneData[] portalPhoneDataArray) {
        boolean bl = portalPhoneDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(portalPhoneDataArray.length);
            for (int i2 = 0; i2 < portalPhoneDataArray.length; ++i2) {
                PortalPhoneDataSerializer.putOptionalPortalPhoneData(iSerializer, portalPhoneDataArray[i2]);
            }
        }
    }

    public static PortalPhoneData getOptionalPortalPhoneData(IDeserializer iDeserializer) {
        PortalPhoneData portalPhoneData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            String string;
            portalPhoneData = new PortalPhoneData();
            portalPhoneData.number = string = iDeserializer.getOptionalString();
            portalPhoneData.type = l = iDeserializer.getInt64();
        }
        return portalPhoneData;
    }

    public static PortalPhoneData[] getOptionalPortalPhoneDataVarArray(IDeserializer iDeserializer) {
        PortalPhoneData[] portalPhoneDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            portalPhoneDataArray = new PortalPhoneData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                portalPhoneDataArray[i2] = PortalPhoneDataSerializer.getOptionalPortalPhoneData(iDeserializer);
            }
        }
        return portalPhoneDataArray;
    }
}

