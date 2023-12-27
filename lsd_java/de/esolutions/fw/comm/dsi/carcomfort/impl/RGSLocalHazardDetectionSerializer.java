/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.RGSLocalHazardDetection;

public class RGSLocalHazardDetectionSerializer {
    public static void putOptionalRGSLocalHazardDetection(ISerializer iSerializer, RGSLocalHazardDetection rGSLocalHazardDetection) {
        boolean bl = rGSLocalHazardDetection == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = rGSLocalHazardDetection.getEventClass();
            iSerializer.putInt16(s);
            int n = rGSLocalHazardDetection.getEventTransaction();
            iSerializer.putInt32(n);
            int n2 = rGSLocalHazardDetection.getEventQuality();
            iSerializer.putInt32(n2);
            int n3 = rGSLocalHazardDetection.getEventCourse();
            iSerializer.putInt32(n3);
            float f2 = rGSLocalHazardDetection.getEventPositionLatitude();
            iSerializer.putFloat(f2);
            float f3 = rGSLocalHazardDetection.getEventPositionLongitude();
            iSerializer.putFloat(f3);
        }
    }

    public static void putOptionalRGSLocalHazardDetectionVarArray(ISerializer iSerializer, RGSLocalHazardDetection[] rGSLocalHazardDetectionArray) {
        boolean bl = rGSLocalHazardDetectionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rGSLocalHazardDetectionArray.length);
            for (int i2 = 0; i2 < rGSLocalHazardDetectionArray.length; ++i2) {
                RGSLocalHazardDetectionSerializer.putOptionalRGSLocalHazardDetection(iSerializer, rGSLocalHazardDetectionArray[i2]);
            }
        }
    }

    public static RGSLocalHazardDetection getOptionalRGSLocalHazardDetection(IDeserializer iDeserializer) {
        RGSLocalHazardDetection rGSLocalHazardDetection = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            float f2;
            float f3;
            int n;
            int n2;
            int n3;
            short s;
            rGSLocalHazardDetection = new RGSLocalHazardDetection();
            rGSLocalHazardDetection.eventClass = s = iDeserializer.getInt16();
            rGSLocalHazardDetection.eventTransaction = n3 = iDeserializer.getInt32();
            rGSLocalHazardDetection.eventQuality = n2 = iDeserializer.getInt32();
            rGSLocalHazardDetection.eventCourse = n = iDeserializer.getInt32();
            rGSLocalHazardDetection.eventPositionLatitude = f3 = iDeserializer.getFloat();
            rGSLocalHazardDetection.eventPositionLongitude = f2 = iDeserializer.getFloat();
        }
        return rGSLocalHazardDetection;
    }

    public static RGSLocalHazardDetection[] getOptionalRGSLocalHazardDetectionVarArray(IDeserializer iDeserializer) {
        RGSLocalHazardDetection[] rGSLocalHazardDetectionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rGSLocalHazardDetectionArray = new RGSLocalHazardDetection[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rGSLocalHazardDetectionArray[i2] = RGSLocalHazardDetectionSerializer.getOptionalRGSLocalHazardDetection(iDeserializer);
            }
        }
        return rGSLocalHazardDetectionArray;
    }
}

