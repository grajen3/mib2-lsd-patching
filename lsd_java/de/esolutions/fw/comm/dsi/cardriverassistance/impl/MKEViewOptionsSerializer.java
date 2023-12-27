/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardriverassistance.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarViewOptionSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardriverassistance.MKEViewOptions;
import org.dsi.ifc.global.CarViewOption;

public class MKEViewOptionsSerializer {
    public static void putOptionalMKEViewOptions(ISerializer iSerializer, MKEViewOptions mKEViewOptions) {
        boolean bl = mKEViewOptions == null;
        iSerializer.putBool(bl);
        if (!bl) {
            CarViewOption carViewOption = mKEViewOptions.getSystemOnOff();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption);
            CarViewOption carViewOption2 = mKEViewOptions.getMkeSetFactoryDefault();
            CarViewOptionSerializer.putOptionalCarViewOption(iSerializer, carViewOption2);
        }
    }

    public static void putOptionalMKEViewOptionsVarArray(ISerializer iSerializer, MKEViewOptions[] mKEViewOptionsArray) {
        boolean bl = mKEViewOptionsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mKEViewOptionsArray.length);
            for (int i2 = 0; i2 < mKEViewOptionsArray.length; ++i2) {
                MKEViewOptionsSerializer.putOptionalMKEViewOptions(iSerializer, mKEViewOptionsArray[i2]);
            }
        }
    }

    public static MKEViewOptions getOptionalMKEViewOptions(IDeserializer iDeserializer) {
        MKEViewOptions mKEViewOptions = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarViewOption carViewOption;
            CarViewOption carViewOption2;
            mKEViewOptions = new MKEViewOptions();
            mKEViewOptions.systemOnOff = carViewOption2 = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
            mKEViewOptions.mkeSetFactoryDefault = carViewOption = CarViewOptionSerializer.getOptionalCarViewOption(iDeserializer);
        }
        return mKEViewOptions;
    }

    public static MKEViewOptions[] getOptionalMKEViewOptionsVarArray(IDeserializer iDeserializer) {
        MKEViewOptions[] mKEViewOptionsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mKEViewOptionsArray = new MKEViewOptions[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mKEViewOptionsArray[i2] = MKEViewOptionsSerializer.getOptionalMKEViewOptions(iDeserializer);
            }
        }
        return mKEViewOptionsArray;
    }
}

