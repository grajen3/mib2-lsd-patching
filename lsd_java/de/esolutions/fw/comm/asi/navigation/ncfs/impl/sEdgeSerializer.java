/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs.impl;

import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sBoundingBoxSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sLineLocationReferenceContainerSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.sBoundingBox;
import de.esolutions.fw.comm.asi.navigation.ncfs.sEdge;
import de.esolutions.fw.comm.asi.navigation.ncfs.sLineLocationReferenceContainer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sEdgeSerializer {
    public static void putOptionalsEdge(ISerializer iSerializer, sEdge sEdge2) {
        boolean bl = sEdge2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sEdge2.getId();
            iSerializer.putInt64(l);
            sLineLocationReferenceContainer sLineLocationReferenceContainer2 = sEdge2.getLocation();
            sLineLocationReferenceContainerSerializer.putOptionalsLineLocationReferenceContainer(iSerializer, sLineLocationReferenceContainer2);
            sBoundingBox sBoundingBox2 = sEdge2.getBoundaries();
            sBoundingBoxSerializer.putOptionalsBoundingBox(iSerializer, sBoundingBox2);
            int[] nArray = sEdge2.getTileIds();
            iSerializer.putOptionalInt32VarArray(nArray);
            int n = sEdge2.getRoadClass();
            iSerializer.putEnum(n);
        }
    }

    public static void putOptionalsEdgeVarArray(ISerializer iSerializer, sEdge[] sEdgeArray) {
        boolean bl = sEdgeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sEdgeArray.length);
            for (int i2 = 0; i2 < sEdgeArray.length; ++i2) {
                sEdgeSerializer.putOptionalsEdge(iSerializer, sEdgeArray[i2]);
            }
        }
    }

    public static sEdge getOptionalsEdge(IDeserializer iDeserializer) {
        sEdge sEdge2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            sBoundingBox sBoundingBox2;
            sLineLocationReferenceContainer sLineLocationReferenceContainer2;
            long l;
            sEdge2 = new sEdge();
            sEdge2.id = l = iDeserializer.getInt64();
            sEdge2.location = sLineLocationReferenceContainer2 = sLineLocationReferenceContainerSerializer.getOptionalsLineLocationReferenceContainer(iDeserializer);
            sEdge2.boundaries = sBoundingBox2 = sBoundingBoxSerializer.getOptionalsBoundingBox(iDeserializer);
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            sEdge2.tileIds = nArray;
            sEdge2.roadClass = n = iDeserializer.getEnum();
        }
        return sEdge2;
    }

    public static sEdge[] getOptionalsEdgeVarArray(IDeserializer iDeserializer) {
        sEdge[] sEdgeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sEdgeArray = new sEdge[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sEdgeArray[i2] = sEdgeSerializer.getOptionalsEdge(iDeserializer);
            }
        }
        return sEdgeArray;
    }
}

