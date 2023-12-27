/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tmc.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tmc.SpeedAndFlowSegment;

public class SpeedAndFlowSegmentSerializer {
    public static void putOptionalSpeedAndFlowSegment(ISerializer iSerializer, SpeedAndFlowSegment speedAndFlowSegment) {
        boolean bl = speedAndFlowSegment == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = speedAndFlowSegment.getId();
            iSerializer.putInt32(n);
            int n2 = speedAndFlowSegment.getSeverity();
            iSerializer.putInt32(n2);
            long l = speedAndFlowSegment.getDistance();
            iSerializer.putInt64(l);
            int n3 = speedAndFlowSegment.getDestinationIndex();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalSpeedAndFlowSegmentVarArray(ISerializer iSerializer, SpeedAndFlowSegment[] speedAndFlowSegmentArray) {
        boolean bl = speedAndFlowSegmentArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(speedAndFlowSegmentArray.length);
            for (int i2 = 0; i2 < speedAndFlowSegmentArray.length; ++i2) {
                SpeedAndFlowSegmentSerializer.putOptionalSpeedAndFlowSegment(iSerializer, speedAndFlowSegmentArray[i2]);
            }
        }
    }

    public static SpeedAndFlowSegment getOptionalSpeedAndFlowSegment(IDeserializer iDeserializer) {
        SpeedAndFlowSegment speedAndFlowSegment = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            long l;
            int n2;
            int n3;
            speedAndFlowSegment = new SpeedAndFlowSegment();
            speedAndFlowSegment.id = n3 = iDeserializer.getInt32();
            speedAndFlowSegment.severity = n2 = iDeserializer.getInt32();
            speedAndFlowSegment.distance = l = iDeserializer.getInt64();
            speedAndFlowSegment.destinationIndex = n = iDeserializer.getInt32();
        }
        return speedAndFlowSegment;
    }

    public static SpeedAndFlowSegment[] getOptionalSpeedAndFlowSegmentVarArray(IDeserializer iDeserializer) {
        SpeedAndFlowSegment[] speedAndFlowSegmentArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            speedAndFlowSegmentArray = new SpeedAndFlowSegment[n];
            for (int i2 = 0; i2 < n; ++i2) {
                speedAndFlowSegmentArray[i2] = SpeedAndFlowSegmentSerializer.getOptionalSpeedAndFlowSegment(iDeserializer);
            }
        }
        return speedAndFlowSegmentArray;
    }
}

