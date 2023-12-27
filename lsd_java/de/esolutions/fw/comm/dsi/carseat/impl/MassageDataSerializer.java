/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carseat.MassageData;

public class MassageDataSerializer {
    public static void putOptionalMassageData(ISerializer iSerializer, MassageData massageData) {
        boolean bl = massageData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = massageData.getProgram();
            iSerializer.putInt32(n);
            int n2 = massageData.getIntensity();
            iSerializer.putInt32(n2);
            int n3 = massageData.getSpeed();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalMassageDataVarArray(ISerializer iSerializer, MassageData[] massageDataArray) {
        boolean bl = massageDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(massageDataArray.length);
            for (int i2 = 0; i2 < massageDataArray.length; ++i2) {
                MassageDataSerializer.putOptionalMassageData(iSerializer, massageDataArray[i2]);
            }
        }
    }

    public static MassageData getOptionalMassageData(IDeserializer iDeserializer) {
        MassageData massageData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            massageData = new MassageData();
            massageData.program = n3 = iDeserializer.getInt32();
            massageData.intensity = n2 = iDeserializer.getInt32();
            massageData.speed = n = iDeserializer.getInt32();
        }
        return massageData;
    }

    public static MassageData[] getOptionalMassageDataVarArray(IDeserializer iDeserializer) {
        MassageData[] massageDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            massageDataArray = new MassageData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                massageDataArray[i2] = MassageDataSerializer.getOptionalMassageData(iDeserializer);
            }
        }
        return massageDataArray;
    }
}

