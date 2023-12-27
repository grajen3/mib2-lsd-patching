/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.dsi.online.impl.PortalLocationSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.PortalLocation;
import org.dsi.ifc.online.PortalNavigationData;

public class PortalNavigationDataSerializer {
    public static void putOptionalPortalNavigationData(ISerializer iSerializer, PortalNavigationData portalNavigationData) {
        boolean bl = portalNavigationData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = portalNavigationData.getNaviType();
            iSerializer.putInt64(l);
            boolean bl2 = portalNavigationData.isTopDestination();
            iSerializer.putBool(bl2);
            PortalLocation portalLocation = portalNavigationData.getNaviLocation();
            PortalLocationSerializer.putOptionalPortalLocation(iSerializer, portalLocation);
            long l2 = portalNavigationData.getVersion();
            iSerializer.putInt64(l2);
            String string = portalNavigationData.getGeoPosition();
            iSerializer.putOptionalString(string);
            String string2 = portalNavigationData.getStreet();
            iSerializer.putOptionalString(string2);
            String string3 = portalNavigationData.getLocality();
            iSerializer.putOptionalString(string3);
        }
    }

    public static void putOptionalPortalNavigationDataVarArray(ISerializer iSerializer, PortalNavigationData[] portalNavigationDataArray) {
        boolean bl = portalNavigationDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(portalNavigationDataArray.length);
            for (int i2 = 0; i2 < portalNavigationDataArray.length; ++i2) {
                PortalNavigationDataSerializer.putOptionalPortalNavigationData(iSerializer, portalNavigationDataArray[i2]);
            }
        }
    }

    public static PortalNavigationData getOptionalPortalNavigationData(IDeserializer iDeserializer) {
        PortalNavigationData portalNavigationData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            long l;
            PortalLocation portalLocation;
            boolean bl2;
            long l2;
            portalNavigationData = new PortalNavigationData();
            portalNavigationData.naviType = l2 = iDeserializer.getInt64();
            portalNavigationData.topDestination = bl2 = iDeserializer.getBool();
            portalNavigationData.naviLocation = portalLocation = PortalLocationSerializer.getOptionalPortalLocation(iDeserializer);
            portalNavigationData.version = l = iDeserializer.getInt64();
            portalNavigationData.geoPosition = string3 = iDeserializer.getOptionalString();
            portalNavigationData.street = string2 = iDeserializer.getOptionalString();
            portalNavigationData.locality = string = iDeserializer.getOptionalString();
        }
        return portalNavigationData;
    }

    public static PortalNavigationData[] getOptionalPortalNavigationDataVarArray(IDeserializer iDeserializer) {
        PortalNavigationData[] portalNavigationDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            portalNavigationDataArray = new PortalNavigationData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                portalNavigationDataArray[i2] = PortalNavigationDataSerializer.getOptionalPortalNavigationData(iDeserializer);
            }
        }
        return portalNavigationDataArray;
    }
}

