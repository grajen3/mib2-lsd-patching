/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.organizer.AdbViewSize;

public class AdbViewSizeSerializer {
    public static void putOptionalAdbViewSize(ISerializer iSerializer, AdbViewSize adbViewSize) {
        boolean bl = adbViewSize == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = adbViewSize.getAll();
            iSerializer.putInt32(n);
            int n2 = adbViewSize.getPhone();
            iSerializer.putInt32(n2);
            int n3 = adbViewSize.getNavi();
            iSerializer.putInt32(n3);
            int n4 = adbViewSize.getTopDestinations();
            iSerializer.putInt32(n4);
            int n5 = adbViewSize.getSpeedDials();
            iSerializer.putInt32(n5);
            int n6 = adbViewSize.getVoiceTags();
            iSerializer.putInt32(n6);
            int n7 = adbViewSize.getUsbStick();
            iSerializer.putInt32(n7);
            int n8 = adbViewSize.getSd1();
            iSerializer.putInt32(n8);
            int n9 = adbViewSize.getSd2();
            iSerializer.putInt32(n9);
            int n10 = adbViewSize.getPublicProfileEntries();
            iSerializer.putInt32(n10);
            int n11 = adbViewSize.getPublicTopDestinations();
            iSerializer.putInt32(n11);
            int n12 = adbViewSize.getOnlineDestination();
            iSerializer.putInt32(n12);
        }
    }

    public static void putOptionalAdbViewSizeVarArray(ISerializer iSerializer, AdbViewSize[] adbViewSizeArray) {
        boolean bl = adbViewSizeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(adbViewSizeArray.length);
            for (int i2 = 0; i2 < adbViewSizeArray.length; ++i2) {
                AdbViewSizeSerializer.putOptionalAdbViewSize(iSerializer, adbViewSizeArray[i2]);
            }
        }
    }

    public static AdbViewSize getOptionalAdbViewSize(IDeserializer iDeserializer) {
        AdbViewSize adbViewSize = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            int n12;
            adbViewSize = new AdbViewSize();
            adbViewSize.all = n12 = iDeserializer.getInt32();
            adbViewSize.phone = n11 = iDeserializer.getInt32();
            adbViewSize.navi = n10 = iDeserializer.getInt32();
            adbViewSize.topDestinations = n9 = iDeserializer.getInt32();
            adbViewSize.speedDials = n8 = iDeserializer.getInt32();
            adbViewSize.voiceTags = n7 = iDeserializer.getInt32();
            adbViewSize.usbStick = n6 = iDeserializer.getInt32();
            adbViewSize.sd1 = n5 = iDeserializer.getInt32();
            adbViewSize.sd2 = n4 = iDeserializer.getInt32();
            adbViewSize.publicProfileEntries = n3 = iDeserializer.getInt32();
            adbViewSize.publicTopDestinations = n2 = iDeserializer.getInt32();
            adbViewSize.onlineDestination = n = iDeserializer.getInt32();
        }
        return adbViewSize;
    }

    public static AdbViewSize[] getOptionalAdbViewSizeVarArray(IDeserializer iDeserializer) {
        AdbViewSize[] adbViewSizeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            adbViewSizeArray = new AdbViewSize[n];
            for (int i2 = 0; i2 < n; ++i2) {
                adbViewSizeArray[i2] = AdbViewSizeSerializer.getOptionalAdbViewSize(iDeserializer);
            }
        }
        return adbViewSizeArray;
    }
}

