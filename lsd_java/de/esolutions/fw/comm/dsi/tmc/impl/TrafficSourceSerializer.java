/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tmc.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tmc.TrafficSource;

public class TrafficSourceSerializer {
    public static void putOptionalTrafficSource(ISerializer iSerializer, TrafficSource trafficSource) {
        boolean bl = trafficSource == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = trafficSource.getTrafficSourceType();
            iSerializer.putInt32(n);
            String string = trafficSource.getTrafficSourceName();
            iSerializer.putOptionalString(string);
            int n2 = trafficSource.getTrafficSourceState();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalTrafficSourceVarArray(ISerializer iSerializer, TrafficSource[] trafficSourceArray) {
        boolean bl = trafficSourceArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(trafficSourceArray.length);
            for (int i2 = 0; i2 < trafficSourceArray.length; ++i2) {
                TrafficSourceSerializer.putOptionalTrafficSource(iSerializer, trafficSourceArray[i2]);
            }
        }
    }

    public static TrafficSource getOptionalTrafficSource(IDeserializer iDeserializer) {
        TrafficSource trafficSource = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            String string;
            int n2;
            trafficSource = new TrafficSource();
            trafficSource.trafficSourceType = n2 = iDeserializer.getInt32();
            trafficSource.trafficSourceName = string = iDeserializer.getOptionalString();
            trafficSource.trafficSourceState = n = iDeserializer.getInt32();
        }
        return trafficSource;
    }

    public static TrafficSource[] getOptionalTrafficSourceVarArray(IDeserializer iDeserializer) {
        TrafficSource[] trafficSourceArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            trafficSourceArray = new TrafficSource[n];
            for (int i2 = 0; i2 < n; ++i2) {
                trafficSourceArray[i2] = TrafficSourceSerializer.getOptionalTrafficSource(iDeserializer);
            }
        }
        return trafficSourceArray;
    }
}

