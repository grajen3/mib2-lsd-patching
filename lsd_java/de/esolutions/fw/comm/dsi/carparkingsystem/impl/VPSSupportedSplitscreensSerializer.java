/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.VPSSupportedSplitscreens;

public class VPSSupportedSplitscreensSerializer {
    public static void putOptionalVPSSupportedSplitscreens(ISerializer iSerializer, VPSSupportedSplitscreens vPSSupportedSplitscreens) {
        boolean bl = vPSSupportedSplitscreens == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = vPSSupportedSplitscreens.isParkbox();
            iSerializer.putBool(bl2);
            boolean bl3 = vPSSupportedSplitscreens.isParallelToRoad();
            iSerializer.putBool(bl3);
            boolean bl4 = vPSSupportedSplitscreens.isOffroad();
            iSerializer.putBool(bl4);
            boolean bl5 = vPSSupportedSplitscreens.isCrossing();
            iSerializer.putBool(bl5);
            boolean bl6 = vPSSupportedSplitscreens.isTrailerAssist();
            iSerializer.putBool(bl6);
            boolean bl7 = vPSSupportedSplitscreens.isSideview();
            iSerializer.putBool(bl7);
        }
    }

    public static void putOptionalVPSSupportedSplitscreensVarArray(ISerializer iSerializer, VPSSupportedSplitscreens[] vPSSupportedSplitscreensArray) {
        boolean bl = vPSSupportedSplitscreensArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vPSSupportedSplitscreensArray.length);
            for (int i2 = 0; i2 < vPSSupportedSplitscreensArray.length; ++i2) {
                VPSSupportedSplitscreensSerializer.putOptionalVPSSupportedSplitscreens(iSerializer, vPSSupportedSplitscreensArray[i2]);
            }
        }
    }

    public static VPSSupportedSplitscreens getOptionalVPSSupportedSplitscreens(IDeserializer iDeserializer) {
        VPSSupportedSplitscreens vPSSupportedSplitscreens = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            vPSSupportedSplitscreens = new VPSSupportedSplitscreens();
            vPSSupportedSplitscreens.parkbox = bl7 = iDeserializer.getBool();
            vPSSupportedSplitscreens.parallelToRoad = bl6 = iDeserializer.getBool();
            vPSSupportedSplitscreens.offroad = bl5 = iDeserializer.getBool();
            vPSSupportedSplitscreens.crossing = bl4 = iDeserializer.getBool();
            vPSSupportedSplitscreens.trailerAssist = bl3 = iDeserializer.getBool();
            vPSSupportedSplitscreens.sideview = bl2 = iDeserializer.getBool();
        }
        return vPSSupportedSplitscreens;
    }

    public static VPSSupportedSplitscreens[] getOptionalVPSSupportedSplitscreensVarArray(IDeserializer iDeserializer) {
        VPSSupportedSplitscreens[] vPSSupportedSplitscreensArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vPSSupportedSplitscreensArray = new VPSSupportedSplitscreens[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vPSSupportedSplitscreensArray[i2] = VPSSupportedSplitscreensSerializer.getOptionalVPSSupportedSplitscreens(iDeserializer);
            }
        }
        return vPSSupportedSplitscreensArray;
    }
}

