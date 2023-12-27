/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.PortalLocation;

public class PortalLocationSerializer {
    public static void putOptionalPortalLocation(ISerializer iSerializer, PortalLocation portalLocation) {
        boolean bl = portalLocation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = portalLocation.getLongitude();
            iSerializer.putInt32(n);
            int n2 = portalLocation.getLatitude();
            iSerializer.putInt32(n2);
            String string = portalLocation.getUnstructured();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalPortalLocationVarArray(ISerializer iSerializer, PortalLocation[] portalLocationArray) {
        boolean bl = portalLocationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(portalLocationArray.length);
            for (int i2 = 0; i2 < portalLocationArray.length; ++i2) {
                PortalLocationSerializer.putOptionalPortalLocation(iSerializer, portalLocationArray[i2]);
            }
        }
    }

    public static PortalLocation getOptionalPortalLocation(IDeserializer iDeserializer) {
        PortalLocation portalLocation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            int n;
            int n2;
            portalLocation = new PortalLocation();
            portalLocation.longitude = n2 = iDeserializer.getInt32();
            portalLocation.latitude = n = iDeserializer.getInt32();
            portalLocation.unstructured = string = iDeserializer.getOptionalString();
        }
        return portalLocation;
    }

    public static PortalLocation[] getOptionalPortalLocationVarArray(IDeserializer iDeserializer) {
        PortalLocation[] portalLocationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            portalLocationArray = new PortalLocation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                portalLocationArray[i2] = PortalLocationSerializer.getOptionalPortalLocation(iDeserializer);
            }
        }
        return portalLocationArray;
    }
}

