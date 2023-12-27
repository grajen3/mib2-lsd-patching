/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.NVObjectDetection;

public class NVObjectDetectionSerializer {
    public static void putOptionalNVObjectDetection(ISerializer iSerializer, NVObjectDetection nVObjectDetection) {
        boolean bl = nVObjectDetection == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = nVObjectDetection.isAnimalDetection();
            iSerializer.putBool(bl2);
            boolean bl3 = nVObjectDetection.isPedestrianDetection();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalNVObjectDetectionVarArray(ISerializer iSerializer, NVObjectDetection[] nVObjectDetectionArray) {
        boolean bl = nVObjectDetectionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(nVObjectDetectionArray.length);
            for (int i2 = 0; i2 < nVObjectDetectionArray.length; ++i2) {
                NVObjectDetectionSerializer.putOptionalNVObjectDetection(iSerializer, nVObjectDetectionArray[i2]);
            }
        }
    }

    public static NVObjectDetection getOptionalNVObjectDetection(IDeserializer iDeserializer) {
        NVObjectDetection nVObjectDetection = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            nVObjectDetection = new NVObjectDetection();
            nVObjectDetection.animalDetection = bl3 = iDeserializer.getBool();
            nVObjectDetection.pedestrianDetection = bl2 = iDeserializer.getBool();
        }
        return nVObjectDetection;
    }

    public static NVObjectDetection[] getOptionalNVObjectDetectionVarArray(IDeserializer iDeserializer) {
        NVObjectDetection[] nVObjectDetectionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            nVObjectDetectionArray = new NVObjectDetection[n];
            for (int i2 = 0; i2 < n; ++i2) {
                nVObjectDetectionArray[i2] = NVObjectDetectionSerializer.getOptionalNVObjectDetection(iDeserializer);
            }
        }
        return nVObjectDetectionArray;
    }
}

