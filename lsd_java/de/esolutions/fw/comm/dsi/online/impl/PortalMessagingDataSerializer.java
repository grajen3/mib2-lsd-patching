/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.PortalMessagingData;

public class PortalMessagingDataSerializer {
    public static void putOptionalPortalMessagingData(ISerializer iSerializer, PortalMessagingData portalMessagingData) {
        boolean bl = portalMessagingData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = portalMessagingData.getMessageType();
            iSerializer.putInt64(l);
            String string = portalMessagingData.getEmail();
            iSerializer.putOptionalString(string);
            String string2 = portalMessagingData.getUrl();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalPortalMessagingDataVarArray(ISerializer iSerializer, PortalMessagingData[] portalMessagingDataArray) {
        boolean bl = portalMessagingDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(portalMessagingDataArray.length);
            for (int i2 = 0; i2 < portalMessagingDataArray.length; ++i2) {
                PortalMessagingDataSerializer.putOptionalPortalMessagingData(iSerializer, portalMessagingDataArray[i2]);
            }
        }
    }

    public static PortalMessagingData getOptionalPortalMessagingData(IDeserializer iDeserializer) {
        PortalMessagingData portalMessagingData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            long l;
            portalMessagingData = new PortalMessagingData();
            portalMessagingData.messageType = l = iDeserializer.getInt64();
            portalMessagingData.email = string2 = iDeserializer.getOptionalString();
            portalMessagingData.url = string = iDeserializer.getOptionalString();
        }
        return portalMessagingData;
    }

    public static PortalMessagingData[] getOptionalPortalMessagingDataVarArray(IDeserializer iDeserializer) {
        PortalMessagingData[] portalMessagingDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            portalMessagingDataArray = new PortalMessagingData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                portalMessagingDataArray[i2] = PortalMessagingDataSerializer.getOptionalPortalMessagingData(iDeserializer);
            }
        }
        return portalMessagingDataArray;
    }
}

