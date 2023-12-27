/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.MirrorViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class MirrorViewOptionsSerializer {
    public static void putOptionalMirrorViewOptions(ISerializer iSerializer, MirrorViewOptions mirrorViewOptions) {
        boolean bl = mirrorViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = mirrorViewOptions.getMirrorLowering();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = mirrorViewOptions.getMirrorSyncAdjust();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
            CarViewOption carViewOption3 = mirrorViewOptions.getMirrorFolding();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption3);
            CarViewOption carViewOption4 = mirrorViewOptions.getMirrorDimming();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption4);
            CarViewOption carViewOption5 = mirrorViewOptions.getMirrorHeating();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption5);
            CarViewOption carViewOption6 = mirrorViewOptions.getMirrorSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption6);
        }
    }

    public static void putOptionalMirrorViewOptionsVarArray(ISerializer iSerializer, MirrorViewOptions[] mirrorViewOptionsArray) {
        boolean bl = mirrorViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mirrorViewOptionsArray.length);
            for (int i2 = 0; i2 < mirrorViewOptionsArray.length; ++i2) {
                MirrorViewOptionsSerializer.putOptionalMirrorViewOptions(iSerializer, mirrorViewOptionsArray[i2]);
            }
        }
    }

    public static MirrorViewOptions getOptionalMirrorViewOptions(IDeserializer iDeserializer) {
        MirrorViewOptions mirrorViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            CarViewOption carViewOption3;
            CarViewOption carViewOption4;
            CarViewOption carViewOption5;
            CarViewOption carViewOption6;
            mirrorViewOptions = new MirrorViewOptions();
            mirrorViewOptions.mirrorLowering = carViewOption6 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            mirrorViewOptions.mirrorSyncAdjust = carViewOption5 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            mirrorViewOptions.mirrorFolding = carViewOption4 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            mirrorViewOptions.mirrorDimming = carViewOption3 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            mirrorViewOptions.mirrorHeating = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            mirrorViewOptions.mirrorSetFactoryDefault = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return mirrorViewOptions;
    }

    public static MirrorViewOptions[] getOptionalMirrorViewOptionsVarArray(IDeserializer iDeserializer) {
        MirrorViewOptions[] mirrorViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mirrorViewOptionsArray = new MirrorViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mirrorViewOptionsArray[i2] = MirrorViewOptionsSerializer.getOptionalMirrorViewOptions(iDeserializer);
            }
        }
        return mirrorViewOptionsArray;
    }
}

