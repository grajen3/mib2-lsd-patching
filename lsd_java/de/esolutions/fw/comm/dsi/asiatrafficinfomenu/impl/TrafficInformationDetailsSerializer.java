/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.asiatrafficinfomenu.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformationDetails;

public class TrafficInformationDetailsSerializer {
    public static void putOptionalTrafficInformationDetails(ISerializer iSerializer, TrafficInformationDetails trafficInformationDetails) {
        boolean bl = trafficInformationDetails == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = trafficInformationDetails.getTrafficType();
            iSerializer.putInt32(n);
            int n2 = trafficInformationDetails.getContentID();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalTrafficInformationDetailsVarArray(ISerializer iSerializer, TrafficInformationDetails[] trafficInformationDetailsArray) {
        boolean bl = trafficInformationDetailsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(trafficInformationDetailsArray.length);
            for (int i2 = 0; i2 < trafficInformationDetailsArray.length; ++i2) {
                TrafficInformationDetailsSerializer.putOptionalTrafficInformationDetails(iSerializer, trafficInformationDetailsArray[i2]);
            }
        }
    }

    public static TrafficInformationDetails getOptionalTrafficInformationDetails(IDeserializer iDeserializer) {
        TrafficInformationDetails trafficInformationDetails = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            trafficInformationDetails = new TrafficInformationDetails();
            trafficInformationDetails.trafficType = n2 = iDeserializer.getInt32();
            trafficInformationDetails.contentID = n = iDeserializer.getInt32();
        }
        return trafficInformationDetails;
    }

    public static TrafficInformationDetails[] getOptionalTrafficInformationDetailsVarArray(IDeserializer iDeserializer) {
        TrafficInformationDetails[] trafficInformationDetailsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            trafficInformationDetailsArray = new TrafficInformationDetails[n];
            for (int i2 = 0; i2 < n; ++i2) {
                trafficInformationDetailsArray[i2] = TrafficInformationDetailsSerializer.getOptionalTrafficInformationDetails(iDeserializer);
            }
        }
        return trafficInformationDetailsArray;
    }
}

