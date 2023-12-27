/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.sdars.TrafficWxEntry;

public class TrafficWxEntrySerializer {
    public static void putOptionalTrafficWxEntry(ISerializer iSerializer, TrafficWxEntry trafficWxEntry) {
        boolean bl = trafficWxEntry == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = trafficWxEntry.getSeekID();
            iSerializer.putInt32(n);
            int n2 = trafficWxEntry.getContentLink();
            iSerializer.putInt32(n2);
            String string = trafficWxEntry.getMarketName();
            iSerializer.putOptionalString(string);
            String string2 = trafficWxEntry.getMarketNameAbbrevation();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalTrafficWxEntryVarArray(ISerializer iSerializer, TrafficWxEntry[] trafficWxEntryArray) {
        boolean bl = trafficWxEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(trafficWxEntryArray.length);
            for (int i2 = 0; i2 < trafficWxEntryArray.length; ++i2) {
                TrafficWxEntrySerializer.putOptionalTrafficWxEntry(iSerializer, trafficWxEntryArray[i2]);
            }
        }
    }

    public static TrafficWxEntry getOptionalTrafficWxEntry(IDeserializer iDeserializer) {
        TrafficWxEntry trafficWxEntry = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            int n;
            int n2;
            trafficWxEntry = new TrafficWxEntry();
            trafficWxEntry.seekID = n2 = iDeserializer.getInt32();
            trafficWxEntry.contentLink = n = iDeserializer.getInt32();
            trafficWxEntry.marketName = string2 = iDeserializer.getOptionalString();
            trafficWxEntry.marketNameAbbrevation = string = iDeserializer.getOptionalString();
        }
        return trafficWxEntry;
    }

    public static TrafficWxEntry[] getOptionalTrafficWxEntryVarArray(IDeserializer iDeserializer) {
        TrafficWxEntry[] trafficWxEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            trafficWxEntryArray = new TrafficWxEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                trafficWxEntryArray[i2] = TrafficWxEntrySerializer.getOptionalTrafficWxEntry(iDeserializer);
            }
        }
        return trafficWxEntryArray;
    }
}

