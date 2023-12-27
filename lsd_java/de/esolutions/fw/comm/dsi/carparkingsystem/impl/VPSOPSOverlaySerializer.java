/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.VPSOPSOverlay;

public class VPSOPSOverlaySerializer {
    public static void putOptionalVPSOPSOverlay(ISerializer iSerializer, VPSOPSOverlay vPSOPSOverlay) {
        boolean bl = vPSOPSOverlay == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = vPSOPSOverlay.isRearview();
            iSerializer.putBool(bl2);
            boolean bl3 = vPSOPSOverlay.isFrontview();
            iSerializer.putBool(bl3);
            boolean bl4 = vPSOPSOverlay.isSideview();
            iSerializer.putBool(bl4);
            boolean bl5 = vPSOPSOverlay.isBirdview();
            iSerializer.putBool(bl5);
        }
    }

    public static void putOptionalVPSOPSOverlayVarArray(ISerializer iSerializer, VPSOPSOverlay[] vPSOPSOverlayArray) {
        boolean bl = vPSOPSOverlayArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vPSOPSOverlayArray.length);
            for (int i2 = 0; i2 < vPSOPSOverlayArray.length; ++i2) {
                VPSOPSOverlaySerializer.putOptionalVPSOPSOverlay(iSerializer, vPSOPSOverlayArray[i2]);
            }
        }
    }

    public static VPSOPSOverlay getOptionalVPSOPSOverlay(IDeserializer iDeserializer) {
        VPSOPSOverlay vPSOPSOverlay = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            vPSOPSOverlay = new VPSOPSOverlay();
            vPSOPSOverlay.rearview = bl5 = iDeserializer.getBool();
            vPSOPSOverlay.frontview = bl4 = iDeserializer.getBool();
            vPSOPSOverlay.sideview = bl3 = iDeserializer.getBool();
            vPSOPSOverlay.birdview = bl2 = iDeserializer.getBool();
        }
        return vPSOPSOverlay;
    }

    public static VPSOPSOverlay[] getOptionalVPSOPSOverlayVarArray(IDeserializer iDeserializer) {
        VPSOPSOverlay[] vPSOPSOverlayArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vPSOPSOverlayArray = new VPSOPSOverlay[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vPSOPSOverlayArray[i2] = VPSOPSOverlaySerializer.getOptionalVPSOPSOverlay(iDeserializer);
            }
        }
        return vPSOPSOverlayArray;
    }
}

