/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.VPSCameraStates;

public class VPSCameraStatesSerializer {
    public static void putOptionalVPSCameraStates(ISerializer iSerializer, VPSCameraStates vPSCameraStates) {
        boolean bl = vPSCameraStates == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = vPSCameraStates.getRearCamera();
            iSerializer.putInt32(n);
            int n2 = vPSCameraStates.getFrontCamera();
            iSerializer.putInt32(n2);
            int n3 = vPSCameraStates.getRightCamera();
            iSerializer.putInt32(n3);
            int n4 = vPSCameraStates.getLeftCamera();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalVPSCameraStatesVarArray(ISerializer iSerializer, VPSCameraStates[] vPSCameraStatesArray) {
        boolean bl = vPSCameraStatesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vPSCameraStatesArray.length);
            for (int i2 = 0; i2 < vPSCameraStatesArray.length; ++i2) {
                VPSCameraStatesSerializer.putOptionalVPSCameraStates(iSerializer, vPSCameraStatesArray[i2]);
            }
        }
    }

    public static VPSCameraStates getOptionalVPSCameraStates(IDeserializer iDeserializer) {
        VPSCameraStates vPSCameraStates = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            vPSCameraStates = new VPSCameraStates();
            vPSCameraStates.rearCamera = n4 = iDeserializer.getInt32();
            vPSCameraStates.frontCamera = n3 = iDeserializer.getInt32();
            vPSCameraStates.rightCamera = n2 = iDeserializer.getInt32();
            vPSCameraStates.leftCamera = n = iDeserializer.getInt32();
        }
        return vPSCameraStates;
    }

    public static VPSCameraStates[] getOptionalVPSCameraStatesVarArray(IDeserializer iDeserializer) {
        VPSCameraStates[] vPSCameraStatesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vPSCameraStatesArray = new VPSCameraStates[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vPSCameraStatesArray[i2] = VPSCameraStatesSerializer.getOptionalVPSCameraStates(iDeserializer);
            }
        }
        return vPSCameraStatesArray;
    }
}

