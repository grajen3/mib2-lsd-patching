/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.VPSCameraCleaning;

public class VPSCameraCleaningSerializer {
    public static void putOptionalVPSCameraCleaning(ISerializer iSerializer, VPSCameraCleaning vPSCameraCleaning) {
        boolean bl = vPSCameraCleaning == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = vPSCameraCleaning.isRearCamera();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalVPSCameraCleaningVarArray(ISerializer iSerializer, VPSCameraCleaning[] vPSCameraCleaningArray) {
        boolean bl = vPSCameraCleaningArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vPSCameraCleaningArray.length);
            for (int i2 = 0; i2 < vPSCameraCleaningArray.length; ++i2) {
                VPSCameraCleaningSerializer.putOptionalVPSCameraCleaning(iSerializer, vPSCameraCleaningArray[i2]);
            }
        }
    }

    public static VPSCameraCleaning getOptionalVPSCameraCleaning(IDeserializer iDeserializer) {
        VPSCameraCleaning vPSCameraCleaning = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            vPSCameraCleaning = new VPSCameraCleaning();
            vPSCameraCleaning.rearCamera = bl2 = iDeserializer.getBool();
        }
        return vPSCameraCleaning;
    }

    public static VPSCameraCleaning[] getOptionalVPSCameraCleaningVarArray(IDeserializer iDeserializer) {
        VPSCameraCleaning[] vPSCameraCleaningArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vPSCameraCleaningArray = new VPSCameraCleaning[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vPSCameraCleaningArray[i2] = VPSCameraCleaningSerializer.getOptionalVPSCameraCleaning(iDeserializer);
            }
        }
        return vPSCameraCleaningArray;
    }
}

