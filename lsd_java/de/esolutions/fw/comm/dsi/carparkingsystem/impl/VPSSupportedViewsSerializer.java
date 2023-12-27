/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.VPSSupportedViews;

public class VPSSupportedViewsSerializer {
    public static void putOptionalVPSSupportedViews(ISerializer iSerializer, VPSSupportedViews vPSSupportedViews) {
        boolean bl = vPSSupportedViews == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = vPSSupportedViews.isRearview();
            iSerializer.putBool(bl2);
            boolean bl3 = vPSSupportedViews.isFrontview();
            iSerializer.putBool(bl3);
            boolean bl4 = vPSSupportedViews.isLeftsideview();
            iSerializer.putBool(bl4);
            boolean bl5 = vPSSupportedViews.isRightsideview();
            iSerializer.putBool(bl5);
            boolean bl6 = vPSSupportedViews.isBirdview();
            iSerializer.putBool(bl6);
            boolean bl7 = vPSSupportedViews.isExtCam();
            iSerializer.putBool(bl7);
        }
    }

    public static void putOptionalVPSSupportedViewsVarArray(ISerializer iSerializer, VPSSupportedViews[] vPSSupportedViewsArray) {
        boolean bl = vPSSupportedViewsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vPSSupportedViewsArray.length);
            for (int i2 = 0; i2 < vPSSupportedViewsArray.length; ++i2) {
                VPSSupportedViewsSerializer.putOptionalVPSSupportedViews(iSerializer, vPSSupportedViewsArray[i2]);
            }
        }
    }

    public static VPSSupportedViews getOptionalVPSSupportedViews(IDeserializer iDeserializer) {
        VPSSupportedViews vPSSupportedViews = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            boolean bl7;
            vPSSupportedViews = new VPSSupportedViews();
            vPSSupportedViews.rearview = bl7 = iDeserializer.getBool();
            vPSSupportedViews.frontview = bl6 = iDeserializer.getBool();
            vPSSupportedViews.leftsideview = bl5 = iDeserializer.getBool();
            vPSSupportedViews.rightsideview = bl4 = iDeserializer.getBool();
            vPSSupportedViews.birdview = bl3 = iDeserializer.getBool();
            vPSSupportedViews.extCam = bl2 = iDeserializer.getBool();
        }
        return vPSSupportedViews;
    }

    public static VPSSupportedViews[] getOptionalVPSSupportedViewsVarArray(IDeserializer iDeserializer) {
        VPSSupportedViews[] vPSSupportedViewsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vPSSupportedViewsArray = new VPSSupportedViews[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vPSSupportedViewsArray[i2] = VPSSupportedViewsSerializer.getOptionalVPSSupportedViews(iDeserializer);
            }
        }
        return vPSSupportedViewsArray;
    }
}

