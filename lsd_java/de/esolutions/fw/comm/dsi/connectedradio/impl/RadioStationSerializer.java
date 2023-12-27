/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.connectedradio.impl;

import de.esolutions.fw.comm.dsi.connectedradio.impl.RadioStationLogoSerializer;
import de.esolutions.fw.comm.dsi.connectedradio.impl.RadioStationStreamSerializer;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.connectedradio.RadioStation;
import org.dsi.ifc.connectedradio.RadioStationLogo;
import org.dsi.ifc.connectedradio.RadioStationStream;
import org.dsi.ifc.global.ResourceLocator;

public class RadioStationSerializer {
    public static void putOptionalRadioStation(ISerializer iSerializer, RadioStation radioStation) {
        boolean bl = radioStation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = radioStation.getId();
            iSerializer.putInt32(n);
            String string = radioStation.getShortName();
            iSerializer.putOptionalString(string);
            String string2 = radioStation.getMediumName();
            iSerializer.putOptionalString(string2);
            String string3 = radioStation.getLongName();
            iSerializer.putOptionalString(string3);
            String string4 = radioStation.getTitle();
            iSerializer.putOptionalString(string4);
            String string5 = radioStation.getDescription();
            iSerializer.putOptionalString(string5);
            String[] stringArray = radioStation.getGenres();
            iSerializer.putOptionalStringVarArray(stringArray);
            int n2 = radioStation.getPi();
            iSerializer.putInt32(n2);
            int n3 = radioStation.getFrequency();
            iSerializer.putInt32(n3);
            int n4 = radioStation.getEid();
            iSerializer.putInt32(n4);
            int n5 = radioStation.getSid();
            iSerializer.putInt32(n5);
            int n6 = radioStation.getScids();
            iSerializer.putInt32(n6);
            String string6 = radioStation.getIsoCountryCode();
            iSerializer.putOptionalString(string6);
            int n7 = radioStation.getEcc();
            iSerializer.putInt32(n7);
            String string7 = radioStation.getGcc();
            iSerializer.putOptionalString(string7);
            String string8 = radioStation.getCountry();
            iSerializer.putOptionalString(string8);
            String string9 = radioStation.getBroadcastCountryCode();
            iSerializer.putOptionalString(string9);
            int n8 = radioStation.getRadioVISPort();
            iSerializer.putInt32(n8);
            String string10 = radioStation.getRadioVISUrl();
            iSerializer.putOptionalString(string10);
            String string11 = radioStation.getRadioVISText();
            iSerializer.putOptionalString(string11);
            ResourceLocator resourceLocator = radioStation.getRadioVISCurrentImage();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            RadioStationStream[] radioStationStreamArray = radioStation.getStreams();
            RadioStationStreamSerializer.putOptionalRadioStationStreamVarArray(iSerializer, radioStationStreamArray);
            RadioStationLogo[] radioStationLogoArray = radioStation.getLogos();
            RadioStationLogoSerializer.putOptionalRadioStationLogoVarArray(iSerializer, radioStationLogoArray);
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
            ResourceLocator resourceLocator;
            String string;
            String string2;
            int n;
            String string3;
            String string4;
            String string5;
            int n2;
            String string6;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            String string7;
            String string8;
            String string9;
            String string10;
            String string11;
            int n8;
            radioStation = new RadioStation();
            radioStation.id = n8 = iDeserializer.getInt32();
            radioStation.shortName = string11 = iDeserializer.getOptionalString();
            radioStation.mediumName = string10 = iDeserializer.getOptionalString();
            radioStation.longName = string9 = iDeserializer.getOptionalString();
            radioStation.title = string8 = iDeserializer.getOptionalString();
            radioStation.description = string7 = iDeserializer.getOptionalString();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            radioStation.genres = stringArray;
            radioStation.pi = n7 = iDeserializer.getInt32();
            radioStation.frequency = n6 = iDeserializer.getInt32();
            radioStation.eid = n5 = iDeserializer.getInt32();
            radioStation.sid = n4 = iDeserializer.getInt32();
            radioStation.scids = n3 = iDeserializer.getInt32();
            radioStation.isoCountryCode = string6 = iDeserializer.getOptionalString();
            radioStation.ecc = n2 = iDeserializer.getInt32();
            radioStation.gcc = string5 = iDeserializer.getOptionalString();
            radioStation.country = string4 = iDeserializer.getOptionalString();
            radioStation.broadcastCountryCode = string3 = iDeserializer.getOptionalString();
            radioStation.radioVISPort = n = iDeserializer.getInt32();
            radioStation.radioVISUrl = string2 = iDeserializer.getOptionalString();
            radioStation.radioVISText = string = iDeserializer.getOptionalString();
            radioStation.radioVISCurrentImage = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
            RadioStationStream[] radioStationStreamArray = RadioStationStreamSerializer.getOptionalRadioStationStreamVarArray(iDeserializer);
            radioStation.streams = radioStationStreamArray;
            RadioStationLogo[] radioStationLogoArray = RadioStationLogoSerializer.getOptionalRadioStationLogoVarArray(iDeserializer);
            radioStation.logos = radioStationLogoArray;
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

