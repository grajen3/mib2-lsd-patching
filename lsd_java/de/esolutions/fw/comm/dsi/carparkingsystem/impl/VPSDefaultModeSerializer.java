/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.VPSDefaultMode;

public class VPSDefaultModeSerializer {
    public static void putOptionalVPSDefaultMode(ISerializer iSerializer, VPSDefaultMode vPSDefaultMode) {
        boolean bl = vPSDefaultMode == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = vPSDefaultMode.getVpsScreen();
            iSerializer.putInt32(n);
            int n2 = vPSDefaultMode.getVpsMode();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalVPSDefaultModeVarArray(ISerializer iSerializer, VPSDefaultMode[] vPSDefaultModeArray) {
        boolean bl = vPSDefaultModeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(vPSDefaultModeArray.length);
            for (int i2 = 0; i2 < vPSDefaultModeArray.length; ++i2) {
                VPSDefaultModeSerializer.putOptionalVPSDefaultMode(iSerializer, vPSDefaultModeArray[i2]);
            }
        }
    }

    public static VPSDefaultMode getOptionalVPSDefaultMode(IDeserializer iDeserializer) {
        VPSDefaultMode vPSDefaultMode = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            vPSDefaultMode = new VPSDefaultMode();
            vPSDefaultMode.vpsScreen = n2 = iDeserializer.getInt32();
            vPSDefaultMode.vpsMode = n = iDeserializer.getInt32();
        }
        return vPSDefaultMode;
    }

    public static VPSDefaultMode[] getOptionalVPSDefaultModeVarArray(IDeserializer iDeserializer) {
        VPSDefaultMode[] vPSDefaultModeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            vPSDefaultModeArray = new VPSDefaultMode[n];
            for (int i2 = 0; i2 < n; ++i2) {
                vPSDefaultModeArray[i2] = VPSDefaultModeSerializer.getOptionalVPSDefaultMode(iDeserializer);
            }
        }
        return vPSDefaultModeArray;
    }
}

