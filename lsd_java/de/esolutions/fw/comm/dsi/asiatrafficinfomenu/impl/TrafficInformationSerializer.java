/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.asiatrafficinfomenu.impl;

import de.esolutions.fw.comm.dsi.asiatrafficinfomenu.impl.TrafficMessageSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficMessage;

public class TrafficInformationSerializer {
    public static void putOptionalTrafficInformation(ISerializer iSerializer, TrafficInformation trafficInformation) {
        boolean bl = trafficInformation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = trafficInformation.getTrafficType();
            iSerializer.putInt32(n);
            TrafficMessage[] trafficMessageArray = trafficInformation.getTrafficMessages();
            TrafficMessageSerializer.putOptionalTrafficMessageVarArray(iSerializer, trafficMessageArray);
        }
    }

    public static void putOptionalTrafficInformationVarArray(ISerializer iSerializer, TrafficInformation[] trafficInformationArray) {
        boolean bl = trafficInformationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(trafficInformationArray.length);
            for (int i2 = 0; i2 < trafficInformationArray.length; ++i2) {
                TrafficInformationSerializer.putOptionalTrafficInformation(iSerializer, trafficInformationArray[i2]);
            }
        }
    }

    public static TrafficInformation getOptionalTrafficInformation(IDeserializer iDeserializer) {
        TrafficInformation trafficInformation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            trafficInformation = new TrafficInformation();
            trafficInformation.trafficType = n = iDeserializer.getInt32();
            TrafficMessage[] trafficMessageArray = TrafficMessageSerializer.getOptionalTrafficMessageVarArray(iDeserializer);
            trafficInformation.trafficMessages = trafficMessageArray;
        }
        return trafficInformation;
    }

    public static TrafficInformation[] getOptionalTrafficInformationVarArray(IDeserializer iDeserializer) {
        TrafficInformation[] trafficInformationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            trafficInformationArray = new TrafficInformation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                trafficInformationArray[i2] = TrafficInformationSerializer.getOptionalTrafficInformation(iDeserializer);
            }
        }
        return trafficInformationArray;
    }
}

