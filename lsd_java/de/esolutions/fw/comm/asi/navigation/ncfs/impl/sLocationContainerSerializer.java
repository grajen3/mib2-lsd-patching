/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs.impl;

import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sEdgeSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sRectangleSetReferenceSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.sEdge;
import de.esolutions.fw.comm.asi.navigation.ncfs.sLocationContainer;
import de.esolutions.fw.comm.asi.navigation.ncfs.sRectangleSetReference;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sLocationContainerSerializer {
    public static void putOptionalsLocationContainer(ISerializer iSerializer, sLocationContainer sLocationContainer2) {
        boolean bl = sLocationContainer2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = sLocationContainer2.getValidLocationType();
            iSerializer.putEnum(n);
            sEdge sEdge2 = sLocationContainer2.getEdgeLocation();
            sEdgeSerializer.putOptionalsEdge(iSerializer, sEdge2);
            sRectangleSetReference sRectangleSetReference2 = sLocationContainer2.getRectangleSetLocation();
            sRectangleSetReferenceSerializer.putOptionalsRectangleSetReference(iSerializer, sRectangleSetReference2);
        }
    }

    public static void putOptionalsLocationContainerVarArray(ISerializer iSerializer, sLocationContainer[] sLocationContainerArray) {
        boolean bl = sLocationContainerArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sLocationContainerArray.length);
            for (int i2 = 0; i2 < sLocationContainerArray.length; ++i2) {
                sLocationContainerSerializer.putOptionalsLocationContainer(iSerializer, sLocationContainerArray[i2]);
            }
        }
    }

    public static sLocationContainer getOptionalsLocationContainer(IDeserializer iDeserializer) {
        sLocationContainer sLocationContainer2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            sRectangleSetReference sRectangleSetReference2;
            sEdge sEdge2;
            int n;
            sLocationContainer2 = new sLocationContainer();
            sLocationContainer2.validLocationType = n = iDeserializer.getEnum();
            sLocationContainer2.edgeLocation = sEdge2 = sEdgeSerializer.getOptionalsEdge(iDeserializer);
            sLocationContainer2.rectangleSetLocation = sRectangleSetReference2 = sRectangleSetReferenceSerializer.getOptionalsRectangleSetReference(iDeserializer);
        }
        return sLocationContainer2;
    }

    public static sLocationContainer[] getOptionalsLocationContainerVarArray(IDeserializer iDeserializer) {
        sLocationContainer[] sLocationContainerArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sLocationContainerArray = new sLocationContainer[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sLocationContainerArray[i2] = sLocationContainerSerializer.getOptionalsLocationContainer(iDeserializer);
            }
        }
        return sLocationContainerArray;
    }
}

