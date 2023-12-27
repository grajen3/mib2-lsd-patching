/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.VPSSupportedSVModes;

public class VPSSupportedSVModesSerializer {
    public static void putOptionalVPSSupportedSVModes(ISerializer iSerializer, VPSSupportedSVModes vPSSupportedSVModes) {
        boolean bl = vPSSupportedSVModes == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = vPSSupportedSVModes.isOffroad();
            iSerializer.putBool(bl2);
            boolean bl3 = vPSSupportedSVModes.isRightSideview();
            iSerializer.putBool(bl3);
            boolean bl4 = vPSSupportedSVModes.isLeftSideview();
            iSerializer.putBool(bl4);
            boolean bl5 = vPSSupportedSVModes.isLeftRightSideview();
            iSerializer.putBool(bl5);
            boolean bl6 = vPSSupportedSVModes.isOnlySideview();
            iSerializer.putBool(bl6);
            boolean bl7 = vPSSupportedSVModes.isOffroadKOG();
            iSerializer.putBool(bl7);
        }
    }

    public static void putOptionalVPSSupportedSVModesVarArray(ISerializer iSerializer, VPSSupportedSVModes[] vPSSupportedSVModesArray) {
        boolean bl = vPSSupportedSVModesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vPSSupportedSVModesArray.length);
            for (int i2 = 0; i2 < vPSSupportedSVModesArray.length; ++i2) {
                VPSSupportedSVModesSerializer.putOptionalVPSSupportedSVModes(iSerializer, vPSSupportedSVModesArray[i2]);
            }
        }
    }

    public static VPSSupportedSVModes getOptionalVPSSupportedSVModes(IDeserializer iDeserializer) {
        VPSSupportedSVModes vPSSupportedSVModes = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            vPSSupportedSVModes = new VPSSupportedSVModes();
            vPSSupportedSVModes.offroad = bl7 = iDeserializer.getBool();
            vPSSupportedSVModes.rightSideview = bl6 = iDeserializer.getBool();
            vPSSupportedSVModes.leftSideview = bl5 = iDeserializer.getBool();
            vPSSupportedSVModes.leftRightSideview = bl4 = iDeserializer.getBool();
            vPSSupportedSVModes.onlySideview = bl3 = iDeserializer.getBool();
            vPSSupportedSVModes.offroadKOG = bl2 = iDeserializer.getBool();
        }
        return vPSSupportedSVModes;
    }

    public static VPSSupportedSVModes[] getOptionalVPSSupportedSVModesVarArray(IDeserializer iDeserializer) {
        VPSSupportedSVModes[] vPSSupportedSVModesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vPSSupportedSVModesArray = new VPSSupportedSVModes[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vPSSupportedSVModesArray[i2] = VPSSupportedSVModesSerializer.getOptionalVPSSupportedSVModes(iDeserializer);
            }
        }
        return vPSSupportedSVModesArray;
    }
}

