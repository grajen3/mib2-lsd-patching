/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs.impl;

import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sBoundingBoxSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sLocationContainerSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.sBoundingBox;
import de.esolutions.fw.comm.asi.navigation.ncfs.sLGIEvent;
import de.esolutions.fw.comm.asi.navigation.ncfs.sLocationContainer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sLGIEventSerializer {
    public static void putOptionalsLGIEvent(ISerializer iSerializer, sLGIEvent sLGIEvent2) {
        boolean bl = sLGIEvent2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sLGIEvent2.getId();
            iSerializer.putInt64(l);
            short s = sLGIEvent2.getVersion();
            iSerializer.putInt16(s);
            sBoundingBox sBoundingBox2 = sLGIEvent2.getBoundaries();
            sBoundingBoxSerializer.putOptionalsBoundingBox(iSerializer, sBoundingBox2);
            sLocationContainer sLocationContainer2 = sLGIEvent2.getLocation();
            sLocationContainerSerializer.putOptionalsLocationContainer(iSerializer, sLocationContainer2);
            int n = sLGIEvent2.getStartAt();
            iSerializer.putInt32(n);
            int n2 = sLGIEvent2.getEndAt();
            iSerializer.putInt32(n2);
            int n3 = sLGIEvent2.getEventType();
            iSerializer.putEnum(n3);
            int n4 = sLGIEvent2.getEventQuality();
            iSerializer.putEnum(n4);
            int[] nArray = sLGIEvent2.getTileIds();
            iSerializer.putOptionalInt32VarArray(nArray);
            byte by = sLGIEvent2.getMinRoadclass();
            iSerializer.putInt8(by);
        }
    }

    public static void putOptionalsLGIEventVarArray(ISerializer iSerializer, sLGIEvent[] sLGIEventArray) {
        boolean bl = sLGIEventArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sLGIEventArray.length);
            for (int i2 = 0; i2 < sLGIEventArray.length; ++i2) {
                sLGIEventSerializer.putOptionalsLGIEvent(iSerializer, sLGIEventArray[i2]);
            }
        }
    }

    public static sLGIEvent getOptionalsLGIEvent(IDeserializer iDeserializer) {
        sLGIEvent sLGIEvent2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            byte by;
            int n;
            int n2;
            int n3;
            int n4;
            sLocationContainer sLocationContainer2;
            sBoundingBox sBoundingBox2;
            short s;
            long l;
            sLGIEvent2 = new sLGIEvent();
            sLGIEvent2.id = l = iDeserializer.getInt64();
            sLGIEvent2.version = s = iDeserializer.getInt16();
            sLGIEvent2.boundaries = sBoundingBox2 = sBoundingBoxSerializer.getOptionalsBoundingBox(iDeserializer);
            sLGIEvent2.location = sLocationContainer2 = sLocationContainerSerializer.getOptionalsLocationContainer(iDeserializer);
            sLGIEvent2.startAt = n4 = iDeserializer.getInt32();
            sLGIEvent2.endAt = n3 = iDeserializer.getInt32();
            sLGIEvent2.eventType = n2 = iDeserializer.getEnum();
            sLGIEvent2.eventQuality = n = iDeserializer.getEnum();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            sLGIEvent2.tileIds = nArray;
            sLGIEvent2.minRoadclass = by = iDeserializer.getInt8();
        }
        return sLGIEvent2;
    }

    public static sLGIEvent[] getOptionalsLGIEventVarArray(IDeserializer iDeserializer) {
        sLGIEvent[] sLGIEventArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sLGIEventArray = new sLGIEvent[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sLGIEventArray[i2] = sLGIEventSerializer.getOptionalsLGIEvent(iDeserializer);
            }
        }
        return sLGIEventArray;
    }
}

