/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.VPSVideoInfo;

public class VPSVideoInfoSerializer {
    public static void putOptionalVPSVideoInfo(ISerializer iSerializer, VPSVideoInfo vPSVideoInfo) {
        boolean bl = vPSVideoInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = vPSVideoInfo.isTrailerHitched();
            iSerializer.putBool(bl2);
            boolean bl3 = vPSVideoInfo.isTrunkOpen();
            iSerializer.putBool(bl3);
            boolean bl4 = vPSVideoInfo.isSpeedToHigh();
            iSerializer.putBool(bl4);
            boolean bl5 = vPSVideoInfo.isCalibration();
            iSerializer.putBool(bl5);
            boolean bl6 = vPSVideoInfo.isGuidelinesLeftSide();
            iSerializer.putBool(bl6);
            boolean bl7 = vPSVideoInfo.isGuidelinesRightSide();
            iSerializer.putBool(bl7);
            boolean bl8 = vPSVideoInfo.isExtMirrorFolded();
            iSerializer.putBool(bl8);
        }
    }

    public static void putOptionalVPSVideoInfoVarArray(ISerializer iSerializer, VPSVideoInfo[] vPSVideoInfoArray) {
        boolean bl = vPSVideoInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vPSVideoInfoArray.length);
            for (int i2 = 0; i2 < vPSVideoInfoArray.length; ++i2) {
                VPSVideoInfoSerializer.putOptionalVPSVideoInfo(iSerializer, vPSVideoInfoArray[i2]);
            }
        }
    }

    public static VPSVideoInfo getOptionalVPSVideoInfo(IDeserializer iDeserializer) {
        VPSVideoInfo vPSVideoInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            vPSVideoInfo = new VPSVideoInfo();
            vPSVideoInfo.trailerHitched = bl8 = iDeserializer.getBool();
            vPSVideoInfo.trunkOpen = bl7 = iDeserializer.getBool();
            vPSVideoInfo.speedToHigh = bl6 = iDeserializer.getBool();
            vPSVideoInfo.calibration = bl5 = iDeserializer.getBool();
            vPSVideoInfo.guidelinesLeftSide = bl4 = iDeserializer.getBool();
            vPSVideoInfo.guidelinesRightSide = bl3 = iDeserializer.getBool();
            vPSVideoInfo.extMirrorFolded = bl2 = iDeserializer.getBool();
        }
        return vPSVideoInfo;
    }

    public static VPSVideoInfo[] getOptionalVPSVideoInfoVarArray(IDeserializer iDeserializer) {
        VPSVideoInfo[] vPSVideoInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vPSVideoInfoArray = new VPSVideoInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vPSVideoInfoArray[i2] = VPSVideoInfoSerializer.getOptionalVPSVideoInfo(iDeserializer);
            }
        }
        return vPSVideoInfoArray;
    }
}

