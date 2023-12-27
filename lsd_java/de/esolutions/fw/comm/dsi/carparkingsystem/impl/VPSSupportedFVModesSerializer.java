/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.VPSSupportedFVModes;

public class VPSSupportedFVModesSerializer {
    public static void putOptionalVPSSupportedFVModes(ISerializer iSerializer, VPSSupportedFVModes vPSSupportedFVModes) {
        boolean bl = vPSSupportedFVModes == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = vPSSupportedFVModes.isParkbox();
            iSerializer.putBool(bl2);
            boolean bl3 = vPSSupportedFVModes.isOffroad();
            iSerializer.putBool(bl3);
            boolean bl4 = vPSSupportedFVModes.isCrossing();
            iSerializer.putBool(bl4);
            boolean bl5 = vPSSupportedFVModes.isOffroadKOG();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalVPSSupportedFVModesVarArray(ISerializer iSerializer, VPSSupportedFVModes[] vPSSupportedFVModesArray) {
        boolean bl = vPSSupportedFVModesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vPSSupportedFVModesArray.length);
            for (int i2 = 0; i2 < vPSSupportedFVModesArray.length; ++i2) {
                VPSSupportedFVModesSerializer.putOptionalVPSSupportedFVModes(iSerializer, vPSSupportedFVModesArray[i2]);
            }
        }
    }

    public static VPSSupportedFVModes getOptionalVPSSupportedFVModes(IDeserializer iDeserializer) {
        VPSSupportedFVModes vPSSupportedFVModes = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            vPSSupportedFVModes = new VPSSupportedFVModes();
            vPSSupportedFVModes.parkbox = bl5 = iDeserializer.getBool();
            vPSSupportedFVModes.offroad = bl4 = iDeserializer.getBool();
            vPSSupportedFVModes.crossing = bl3 = iDeserializer.getBool();
            vPSSupportedFVModes.offroadKOG = bl2 = iDeserializer.getBool();
        }
        return vPSSupportedFVModes;
    }

    public static VPSSupportedFVModes[] getOptionalVPSSupportedFVModesVarArray(IDeserializer iDeserializer) {
        VPSSupportedFVModes[] vPSSupportedFVModesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vPSSupportedFVModesArray = new VPSSupportedFVModes[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vPSSupportedFVModesArray[i2] = VPSSupportedFVModesSerializer.getOptionalVPSSupportedFVModes(iDeserializer);
            }
        }
        return vPSSupportedFVModesArray;
    }
}

