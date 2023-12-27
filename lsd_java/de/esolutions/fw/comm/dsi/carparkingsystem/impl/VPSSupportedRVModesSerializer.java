/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.VPSSupportedRVModes;

public class VPSSupportedRVModesSerializer {
    public static void putOptionalVPSSupportedRVModes(ISerializer iSerializer, VPSSupportedRVModes vPSSupportedRVModes) {
        boolean bl = vPSSupportedRVModes == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = vPSSupportedRVModes.isParkbox();
            iSerializer.putBool(bl2);
            boolean bl3 = vPSSupportedRVModes.isParallelToRoad();
            iSerializer.putBool(bl3);
            boolean bl4 = vPSSupportedRVModes.isCrossing();
            iSerializer.putBool(bl4);
            boolean bl5 = vPSSupportedRVModes.isTrailerAssist();
            iSerializer.putBool(bl5);
            boolean bl6 = vPSSupportedRVModes.isOffroadKOG();
            iSerializer.putBool(bl6);
            boolean bl7 = vPSSupportedRVModes.isTrailerAssistARA();
            iSerializer.putBool(bl7);
        }
    }

    public static void putOptionalVPSSupportedRVModesVarArray(ISerializer iSerializer, VPSSupportedRVModes[] vPSSupportedRVModesArray) {
        boolean bl = vPSSupportedRVModesArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vPSSupportedRVModesArray.length);
            for (int i2 = 0; i2 < vPSSupportedRVModesArray.length; ++i2) {
                VPSSupportedRVModesSerializer.putOptionalVPSSupportedRVModes(iSerializer, vPSSupportedRVModesArray[i2]);
            }
        }
    }

    public static VPSSupportedRVModes getOptionalVPSSupportedRVModes(IDeserializer iDeserializer) {
        VPSSupportedRVModes vPSSupportedRVModes = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            vPSSupportedRVModes = new VPSSupportedRVModes();
            vPSSupportedRVModes.parkbox = bl7 = iDeserializer.getBool();
            vPSSupportedRVModes.parallelToRoad = bl6 = iDeserializer.getBool();
            vPSSupportedRVModes.crossing = bl5 = iDeserializer.getBool();
            vPSSupportedRVModes.trailerAssist = bl4 = iDeserializer.getBool();
            vPSSupportedRVModes.offroadKOG = bl3 = iDeserializer.getBool();
            vPSSupportedRVModes.trailerAssistARA = bl2 = iDeserializer.getBool();
        }
        return vPSSupportedRVModes;
    }

    public static VPSSupportedRVModes[] getOptionalVPSSupportedRVModesVarArray(IDeserializer iDeserializer) {
        VPSSupportedRVModes[] vPSSupportedRVModesArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vPSSupportedRVModesArray = new VPSSupportedRVModes[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vPSSupportedRVModesArray[i2] = VPSSupportedRVModesSerializer.getOptionalVPSSupportedRVModes(iDeserializer);
            }
        }
        return vPSSupportedRVModesArray;
    }
}

