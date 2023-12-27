/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.CarBCVolume;

public class CarBCVolumeSerializer {
    public static void putOptionalCarBCVolume(ISerializer iSerializer, CarBCVolume carBCVolume) {
        boolean bl = carBCVolume == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = carBCVolume.getState();
            iSerializer.putInt32(n);
            int n2 = carBCVolume.getVolumeValue();
            iSerializer.putInt32(n2);
            int n3 = carBCVolume.getVolumeUnit();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalCarBCVolumeVarArray(ISerializer iSerializer, CarBCVolume[] carBCVolumeArray) {
        boolean bl = carBCVolumeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(carBCVolumeArray.length);
            for (int i2 = 0; i2 < carBCVolumeArray.length; ++i2) {
                CarBCVolumeSerializer.putOptionalCarBCVolume(iSerializer, carBCVolumeArray[i2]);
            }
        }
    }

    public static CarBCVolume getOptionalCarBCVolume(IDeserializer iDeserializer) {
        CarBCVolume carBCVolume = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            carBCVolume = new CarBCVolume();
            carBCVolume.state = n3 = iDeserializer.getInt32();
            carBCVolume.volumeValue = n2 = iDeserializer.getInt32();
            carBCVolume.volumeUnit = n = iDeserializer.getInt32();
        }
        return carBCVolume;
    }

    public static CarBCVolume[] getOptionalCarBCVolumeVarArray(IDeserializer iDeserializer) {
        CarBCVolume[] carBCVolumeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            carBCVolumeArray = new CarBCVolume[n];
            for (int i2 = 0; i2 < n; ++i2) {
                carBCVolumeArray[i2] = CarBCVolumeSerializer.getOptionalCarBCVolume(iDeserializer);
            }
        }
        return carBCVolumeArray;
    }
}

