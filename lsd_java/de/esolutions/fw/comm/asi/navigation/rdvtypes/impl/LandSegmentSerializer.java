/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvtypes.impl;

import de.esolutions.fw.comm.asi.navigation.rdvtypes.BlankZoneInfo;
import de.esolutions.fw.comm.asi.navigation.rdvtypes.LandSegment;
import de.esolutions.fw.comm.asi.navigation.rdvtypes.RangeZoneInfo;
import de.esolutions.fw.comm.asi.navigation.rdvtypes.impl.BlankZoneInfoSerializer;
import de.esolutions.fw.comm.asi.navigation.rdvtypes.impl.RangeZoneInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class LandSegmentSerializer {
    public static void putOptionalLandSegment(ISerializer iSerializer, LandSegment landSegment) {
        boolean bl = landSegment == null;
        iSerializer.putBool(bl);
        if (!bl) {
            RangeZoneInfo[] rangeZoneInfoArray = landSegment.getRangePolygons();
            RangeZoneInfoSerializer.putOptionalRangeZoneInfoVarArray(iSerializer, rangeZoneInfoArray);
            BlankZoneInfo[] blankZoneInfoArray = landSegment.getBlankPolygons();
            BlankZoneInfoSerializer.putOptionalBlankZoneInfoVarArray(iSerializer, blankZoneInfoArray);
        }
    }

    public static void putOptionalLandSegmentVarArray(ISerializer iSerializer, LandSegment[] landSegmentArray) {
        boolean bl = landSegmentArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(landSegmentArray.length);
            for (int i2 = 0; i2 < landSegmentArray.length; ++i2) {
                LandSegmentSerializer.putOptionalLandSegment(iSerializer, landSegmentArray[i2]);
            }
        }
    }

    public static LandSegment getOptionalLandSegment(IDeserializer iDeserializer) {
        LandSegment landSegment = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            landSegment = new LandSegment();
            RangeZoneInfo[] rangeZoneInfoArray = RangeZoneInfoSerializer.getOptionalRangeZoneInfoVarArray(iDeserializer);
            landSegment.rangePolygons = rangeZoneInfoArray;
            BlankZoneInfo[] blankZoneInfoArray = BlankZoneInfoSerializer.getOptionalBlankZoneInfoVarArray(iDeserializer);
            landSegment.blankPolygons = blankZoneInfoArray;
        }
        return landSegment;
    }

    public static LandSegment[] getOptionalLandSegmentVarArray(IDeserializer iDeserializer) {
        LandSegment[] landSegmentArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            landSegmentArray = new LandSegment[n];
            for (int i2 = 0; i2 < n; ++i2) {
                landSegmentArray[i2] = LandSegmentSerializer.getOptionalLandSegment(iDeserializer);
            }
        }
        return landSegmentArray;
    }
}

