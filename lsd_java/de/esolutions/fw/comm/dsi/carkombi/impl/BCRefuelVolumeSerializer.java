/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCRefuelVolume;

public class BCRefuelVolumeSerializer {
    public static void putOptionalBCRefuelVolume(ISerializer iSerializer, BCRefuelVolume bCRefuelVolume) {
        boolean bl = bCRefuelVolume == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bCRefuelVolume.getState();
            iSerializer.putInt32(n);
            int n2 = bCRefuelVolume.getRefuelVolumeValue();
            iSerializer.putInt32(n2);
            int n3 = bCRefuelVolume.getRefuelVolumeUnit();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalBCRefuelVolumeVarArray(ISerializer iSerializer, BCRefuelVolume[] bCRefuelVolumeArray) {
        boolean bl = bCRefuelVolumeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCRefuelVolumeArray.length);
            for (int i2 = 0; i2 < bCRefuelVolumeArray.length; ++i2) {
                BCRefuelVolumeSerializer.putOptionalBCRefuelVolume(iSerializer, bCRefuelVolumeArray[i2]);
            }
        }
    }

    public static BCRefuelVolume getOptionalBCRefuelVolume(IDeserializer iDeserializer) {
        BCRefuelVolume bCRefuelVolume = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            bCRefuelVolume = new BCRefuelVolume();
            bCRefuelVolume.state = n3 = iDeserializer.getInt32();
            bCRefuelVolume.refuelVolumeValue = n2 = iDeserializer.getInt32();
            bCRefuelVolume.refuelVolumeUnit = n = iDeserializer.getInt32();
        }
        return bCRefuelVolume;
    }

    public static BCRefuelVolume[] getOptionalBCRefuelVolumeVarArray(IDeserializer iDeserializer) {
        BCRefuelVolume[] bCRefuelVolumeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCRefuelVolumeArray = new BCRefuelVolume[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCRefuelVolumeArray[i2] = BCRefuelVolumeSerializer.getOptionalBCRefuelVolume(iDeserializer);
            }
        }
        return bCRefuelVolumeArray;
    }
}

