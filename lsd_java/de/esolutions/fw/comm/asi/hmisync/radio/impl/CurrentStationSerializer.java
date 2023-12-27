/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio.impl;

import de.esolutions.fw.comm.asi.hmisync.radio.CurrentStation;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class CurrentStationSerializer {
    public static void putOptionalCurrentStation(ISerializer iSerializer, CurrentStation currentStation) {
        boolean bl = currentStation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = currentStation.getId();
            iSerializer.putInt64(l);
            String string = currentStation.getName();
            iSerializer.putOptionalString(string);
            String string2 = currentStation.getFullName();
            iSerializer.putOptionalString(string2);
            String string3 = currentStation.getArtist();
            iSerializer.putOptionalString(string3);
            int n = currentStation.getArtistType();
            iSerializer.putInt32(n);
            String string4 = currentStation.getTitle();
            iSerializer.putOptionalString(string4);
            int n2 = currentStation.getTitleType();
            iSerializer.putInt32(n2);
            String string5 = currentStation.getImage();
            iSerializer.putOptionalString(string5);
            int n3 = currentStation.getAudioStatus();
            iSerializer.putInt32(n3);
            int n4 = currentStation.getLayer();
            iSerializer.putInt32(n4);
            String string6 = currentStation.getAlbum();
            iSerializer.putOptionalString(string6);
            String string7 = currentStation.getRadioText();
            iSerializer.putOptionalString(string7);
            String string8 = currentStation.getExtension();
            iSerializer.putOptionalString(string8);
        }
    }

    public static void putOptionalCurrentStationVarArray(ISerializer iSerializer, CurrentStation[] currentStationArray) {
        boolean bl = currentStationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(currentStationArray.length);
            for (int i2 = 0; i2 < currentStationArray.length; ++i2) {
                CurrentStationSerializer.putOptionalCurrentStation(iSerializer, currentStationArray[i2]);
            }
        }
    }

    public static CurrentStation getOptionalCurrentStation(IDeserializer iDeserializer) {
        CurrentStation currentStation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            int n;
            int n2;
            String string4;
            int n3;
            String string5;
            int n4;
            String string6;
            String string7;
            String string8;
            long l;
            currentStation = new CurrentStation();
            currentStation.id = l = iDeserializer.getInt64();
            currentStation.name = string8 = iDeserializer.getOptionalString();
            currentStation.fullName = string7 = iDeserializer.getOptionalString();
            currentStation.artist = string6 = iDeserializer.getOptionalString();
            currentStation.artistType = n4 = iDeserializer.getInt32();
            currentStation.title = string5 = iDeserializer.getOptionalString();
            currentStation.titleType = n3 = iDeserializer.getInt32();
            currentStation.image = string4 = iDeserializer.getOptionalString();
            currentStation.audioStatus = n2 = iDeserializer.getInt32();
            currentStation.layer = n = iDeserializer.getInt32();
            currentStation.album = string3 = iDeserializer.getOptionalString();
            currentStation.radioText = string2 = iDeserializer.getOptionalString();
            currentStation.extension = string = iDeserializer.getOptionalString();
        }
        return currentStation;
    }

    public static CurrentStation[] getOptionalCurrentStationVarArray(IDeserializer iDeserializer) {
        CurrentStation[] currentStationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            currentStationArray = new CurrentStation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                currentStationArray[i2] = CurrentStationSerializer.getOptionalCurrentStation(iDeserializer);
            }
        }
        return currentStationArray;
    }
}

