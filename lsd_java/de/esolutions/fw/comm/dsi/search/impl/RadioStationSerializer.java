/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.search.RadioStation;

public class RadioStationSerializer {
    public static void putOptionalRadioStation(ISerializer iSerializer, RadioStation radioStation) {
        boolean bl = radioStation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = radioStation.getId();
            iSerializer.putInt64(l);
            String string = radioStation.getData1();
            iSerializer.putOptionalString(string);
            String string2 = radioStation.getData2();
            iSerializer.putOptionalString(string2);
            String string3 = radioStation.getData3();
            iSerializer.putOptionalString(string3);
        }
    }

    public static void putOptionalRadioStationVarArray(ISerializer iSerializer, RadioStation[] radioStationArray) {
        boolean bl = radioStationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(radioStationArray.length);
            for (int i2 = 0; i2 < radioStationArray.length; ++i2) {
                RadioStationSerializer.putOptionalRadioStation(iSerializer, radioStationArray[i2]);
            }
        }
    }

    public static RadioStation getOptionalRadioStation(IDeserializer iDeserializer) {
        RadioStation radioStation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            long l;
            radioStation = new RadioStation();
            radioStation.id = l = iDeserializer.getInt64();
            radioStation.data1 = string3 = iDeserializer.getOptionalString();
            radioStation.data2 = string2 = iDeserializer.getOptionalString();
            radioStation.data3 = string = iDeserializer.getOptionalString();
        }
        return radioStation;
    }

    public static RadioStation[] getOptionalRadioStationVarArray(IDeserializer iDeserializer) {
        RadioStation[] radioStationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            radioStationArray = new RadioStation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                radioStationArray[i2] = RadioStationSerializer.getOptionalRadioStation(iDeserializer);
            }
        }
        return radioStationArray;
    }
}

