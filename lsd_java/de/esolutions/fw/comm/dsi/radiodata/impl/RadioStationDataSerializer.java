/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radiodata.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radiodata.RadioStationData;

public class RadioStationDataSerializer {
    public static void putOptionalRadioStationData(ISerializer iSerializer, RadioStationData radioStationData) {
        boolean bl = radioStationData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = radioStationData.getStationId();
            iSerializer.putInt32(n);
            int n2 = radioStationData.getCountry();
            iSerializer.putInt32(n2);
            int n3 = radioStationData.getExtendedCountryCode();
            iSerializer.putInt32(n3);
            int n4 = radioStationData.getPiSid();
            iSerializer.putInt32(n4);
            int n5 = radioStationData.getLinkedPiSid();
            iSerializer.putInt32(n5);
            int n6 = radioStationData.getEnsembleId();
            iSerializer.putInt32(n6);
            int n7 = radioStationData.getScidi();
            iSerializer.putInt32(n7);
            String string = radioStationData.getLongName();
            iSerializer.putOptionalString(string);
            String string2 = radioStationData.getShortName();
            iSerializer.putOptionalString(string2);
            long l = radioStationData.getFrequency();
            iSerializer.putInt64(l);
            int n8 = radioStationData.getSubChannelId();
            iSerializer.putInt32(n8);
            String string3 = radioStationData.getStationType();
            iSerializer.putOptionalString(string3);
            long l2 = radioStationData.getRadioSdsId();
            iSerializer.putInt64(l2);
            int n9 = radioStationData.getLogoId();
            iSerializer.putInt32(n9);
        }
    }

    public static void putOptionalRadioStationDataVarArray(ISerializer iSerializer, RadioStationData[] radioStationDataArray) {
        boolean bl = radioStationDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(radioStationDataArray.length);
            for (int i2 = 0; i2 < radioStationDataArray.length; ++i2) {
                RadioStationDataSerializer.putOptionalRadioStationData(iSerializer, radioStationDataArray[i2]);
            }
        }
    }

    public static RadioStationData getOptionalRadioStationData(IDeserializer iDeserializer) {
        RadioStationData radioStationData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            long l;
            String string;
            int n2;
            long l2;
            String string2;
            String string3;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            int n9;
            radioStationData = new RadioStationData();
            radioStationData.stationId = n9 = iDeserializer.getInt32();
            radioStationData.country = n8 = iDeserializer.getInt32();
            radioStationData.extendedCountryCode = n7 = iDeserializer.getInt32();
            radioStationData.piSid = n6 = iDeserializer.getInt32();
            radioStationData.linkedPiSid = n5 = iDeserializer.getInt32();
            radioStationData.ensembleId = n4 = iDeserializer.getInt32();
            radioStationData.scidi = n3 = iDeserializer.getInt32();
            radioStationData.longName = string3 = iDeserializer.getOptionalString();
            radioStationData.shortName = string2 = iDeserializer.getOptionalString();
            radioStationData.frequency = l2 = iDeserializer.getInt64();
            radioStationData.subChannelId = n2 = iDeserializer.getInt32();
            radioStationData.stationType = string = iDeserializer.getOptionalString();
            radioStationData.radioSdsId = l = iDeserializer.getInt64();
            radioStationData.logoId = n = iDeserializer.getInt32();
        }
        return radioStationData;
    }

    public static RadioStationData[] getOptionalRadioStationDataVarArray(IDeserializer iDeserializer) {
        RadioStationData[] radioStationDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            radioStationDataArray = new RadioStationData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                radioStationDataArray[i2] = RadioStationDataSerializer.getOptionalRadioStationData(iDeserializer);
            }
        }
        return radioStationDataArray;
    }
}

