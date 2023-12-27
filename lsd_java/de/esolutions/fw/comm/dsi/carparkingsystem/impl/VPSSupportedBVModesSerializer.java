/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.VPSSupportedBVModes;

public class VPSSupportedBVModesSerializer {
    public static void putOptionalVPSSupportedBVModes(ISerializer iSerializer, VPSSupportedBVModes vPSSupportedBVModes) {
        boolean bl = vPSSupportedBVModes == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = vPSSupportedBVModes.isParkbox();
            iSerializer.putBool(bl2);
            boolean bl3 = vPSSupportedBVModes.isOffroad();
            iSerializer.putBool(bl3);
            boolean bl4 = vPSSupportedBVModes.isMainMode();
            iSerializer.putBool(bl4);
            boolean bl5 = vPSSupportedBVModes.isOffroadKOG();
            iSerializer.putBool(bl5);
            boolean bl6 = vPSSupportedBVModes.isBirdview3D();
            iSerializer.putBool(bl6);
        }
    }

    public static void putOptionalVPSSupportedBVModesVarArray(ISerializer iSerializer, VPSSupportedBVModes[] vPSSupportedBVModesArray) {
        boolean bl = vPSSupportedBVModesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vPSSupportedBVModesArray.length);
            for (int i2 = 0; i2 < vPSSupportedBVModesArray.length; ++i2) {
                VPSSupportedBVModesSerializer.putOptionalVPSSupportedBVModes(iSerializer, vPSSupportedBVModesArray[i2]);
            }
        }
    }

    public static VPSSupportedBVModes getOptionalVPSSupportedBVModes(IDeserializer iDeserializer) {
        VPSSupportedBVModes vPSSupportedBVModes = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            vPSSupportedBVModes = new VPSSupportedBVModes();
            vPSSupportedBVModes.parkbox = bl6 = iDeserializer.getBool();
            vPSSupportedBVModes.offroad = bl5 = iDeserializer.getBool();
            vPSSupportedBVModes.mainMode = bl4 = iDeserializer.getBool();
            vPSSupportedBVModes.offroadKOG = bl3 = iDeserializer.getBool();
            vPSSupportedBVModes.birdview3D = bl2 = iDeserializer.getBool();
        }
        return vPSSupportedBVModes;
    }

    public static VPSSupportedBVModes[] getOptionalVPSSupportedBVModesVarArray(IDeserializer iDeserializer) {
        VPSSupportedBVModes[] vPSSupportedBVModesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vPSSupportedBVModesArray = new VPSSupportedBVModes[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vPSSupportedBVModesArray[i2] = VPSSupportedBVModesSerializer.getOptionalVPSSupportedBVModes(iDeserializer);
            }
        }
        return vPSSupportedBVModesArray;
    }
}

