/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.asiatrafficinfomenu.impl;

import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.asiatrafficinfomenu.TrafficMessage;
import org.dsi.ifc.global.DateTime;

public class TrafficMessageSerializer {
    public static void putOptionalTrafficMessage(ISerializer iSerializer, TrafficMessage trafficMessage) {
        boolean bl = trafficMessage == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = trafficMessage.getTrafficMessageID();
            iSerializer.putInt32(n);
            boolean bl2 = trafficMessage.isIsValid();
            iSerializer.putBool(bl2);
            int[] nArray = trafficMessage.getDetailContentIDs();
            iSerializer.putOptionalInt32VarArray(nArray);
            String string = trafficMessage.getValue();
            iSerializer.putOptionalString(string);
            DateTime dateTime = trafficMessage.getDate();
            DateTimeSerializer.putOptionalDateTime(iSerializer, dateTime);
            int n2 = trafficMessage.getContentID();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalTrafficMessageVarArray(ISerializer iSerializer, TrafficMessage[] trafficMessageArray) {
        boolean bl = trafficMessageArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(trafficMessageArray.length);
            for (int i2 = 0; i2 < trafficMessageArray.length; ++i2) {
                TrafficMessageSerializer.putOptionalTrafficMessage(iSerializer, trafficMessageArray[i2]);
            }
        }
    }

    public static TrafficMessage getOptionalTrafficMessage(IDeserializer iDeserializer) {
        TrafficMessage trafficMessage = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            DateTime dateTime;
            String string;
            boolean bl2;
            int n2;
            trafficMessage = new TrafficMessage();
            trafficMessage.trafficMessageID = n2 = iDeserializer.getInt32();
            trafficMessage.isValid = bl2 = iDeserializer.getBool();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            trafficMessage.detailContentIDs = nArray;
            trafficMessage.value = string = iDeserializer.getOptionalString();
            trafficMessage.date = dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            trafficMessage.contentID = n = iDeserializer.getInt32();
        }
        return trafficMessage;
    }

    public static TrafficMessage[] getOptionalTrafficMessageVarArray(IDeserializer iDeserializer) {
        TrafficMessage[] trafficMessageArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            trafficMessageArray = new TrafficMessage[n];
            for (int i2 = 0; i2 < n; ++i2) {
                trafficMessageArray[i2] = TrafficMessageSerializer.getOptionalTrafficMessage(iDeserializer);
            }
        }
        return trafficMessageArray;
    }
}

