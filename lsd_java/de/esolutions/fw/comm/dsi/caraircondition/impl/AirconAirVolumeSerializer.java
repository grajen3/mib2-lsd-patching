/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.caraircondition.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.caraircondition.AirconAirVolume;

public class AirconAirVolumeSerializer {
    public static void putOptionalAirconAirVolume(ISerializer iSerializer, AirconAirVolume airconAirVolume) {
        boolean bl = airconAirVolume == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = airconAirVolume.getAirVolume();
            iSerializer.putInt32(n);
            int n2 = airconAirVolume.getAirVolumeRegulated();
            iSerializer.putInt32(n2);
            int n3 = airconAirVolume.getAirVolumeAuto();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalAirconAirVolumeVarArray(ISerializer iSerializer, AirconAirVolume[] airconAirVolumeArray) {
        boolean bl = airconAirVolumeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airconAirVolumeArray.length);
            for (int i2 = 0; i2 < airconAirVolumeArray.length; ++i2) {
                AirconAirVolumeSerializer.putOptionalAirconAirVolume(iSerializer, airconAirVolumeArray[i2]);
            }
        }
    }

    public static AirconAirVolume getOptionalAirconAirVolume(IDeserializer iDeserializer) {
        AirconAirVolume airconAirVolume = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            airconAirVolume = new AirconAirVolume();
            airconAirVolume.airVolume = n3 = iDeserializer.getInt32();
            airconAirVolume.airVolumeRegulated = n2 = iDeserializer.getInt32();
            airconAirVolume.airVolumeAuto = n = iDeserializer.getInt32();
        }
        return airconAirVolume;
    }

    public static AirconAirVolume[] getOptionalAirconAirVolumeVarArray(IDeserializer iDeserializer) {
        AirconAirVolume[] airconAirVolumeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airconAirVolumeArray = new AirconAirVolume[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airconAirVolumeArray[i2] = AirconAirVolumeSerializer.getOptionalAirconAirVolume(iDeserializer);
            }
        }
        return airconAirVolumeArray;
    }
}

