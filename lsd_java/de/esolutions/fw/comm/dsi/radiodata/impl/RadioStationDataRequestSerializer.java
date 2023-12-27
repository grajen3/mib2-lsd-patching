/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radiodata.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radiodata.RadioStationDataRequest;

public class RadioStationDataRequestSerializer {
    public static void putOptionalRadioStationDataRequest(ISerializer iSerializer, RadioStationDataRequest radioStationDataRequest) {
        boolean bl = radioStationDataRequest == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = radioStationDataRequest.getMaxItemCount();
            iSerializer.putInt32(n);
            int n2 = radioStationDataRequest.getStationId();
            iSerializer.putInt32(n2);
            boolean bl2 = radioStationDataRequest.isUseStationId();
            iSerializer.putBool(bl2);
            int n3 = radioStationDataRequest.getCountry();
            iSerializer.putInt32(n3);
            boolean bl3 = radioStationDataRequest.isUseCountry();
            iSerializer.putBool(bl3);
            int n4 = radioStationDataRequest.getExtendedCountryCode();
            iSerializer.putInt32(n4);
            boolean bl4 = radioStationDataRequest.isUseExtendedCountryCode();
            iSerializer.putBool(bl4);
            int n5 = radioStationDataRequest.getPiSid();
            iSerializer.putInt32(n5);
            boolean bl5 = radioStationDataRequest.isUsePiSid();
            iSerializer.putBool(bl5);
            int n6 = radioStationDataRequest.getLinkedPiSid();
            iSerializer.putInt32(n6);
            boolean bl6 = radioStationDataRequest.isUseLinkedPiSid();
            iSerializer.putBool(bl6);
            int n7 = radioStationDataRequest.getEnsembleId();
            iSerializer.putInt32(n7);
            boolean bl7 = radioStationDataRequest.isUseEnsembleId();
            iSerializer.putBool(bl7);
            int n8 = radioStationDataRequest.getScidi();
            iSerializer.putInt32(n8);
            boolean bl8 = radioStationDataRequest.isUseScidi();
            iSerializer.putBool(bl8);
            String string = radioStationDataRequest.getLongName();
            iSerializer.putOptionalString(string);
            boolean bl9 = radioStationDataRequest.isUseLongName();
            iSerializer.putBool(bl9);
            String string2 = radioStationDataRequest.getShortName();
            iSerializer.putOptionalString(string2);
            boolean bl10 = radioStationDataRequest.isUseShortName();
            iSerializer.putBool(bl10);
            long l = radioStationDataRequest.getFrequency();
            iSerializer.putInt64(l);
            boolean bl11 = radioStationDataRequest.isUseFrequency();
            iSerializer.putBool(bl11);
            int n9 = radioStationDataRequest.getSubChannelId();
            iSerializer.putInt32(n9);
            boolean bl12 = radioStationDataRequest.isUseSubChannelId();
            iSerializer.putBool(bl12);
            String string3 = radioStationDataRequest.getStationType();
            iSerializer.putOptionalString(string3);
            boolean bl13 = radioStationDataRequest.isUseStationType();
            iSerializer.putBool(bl13);
            int n10 = radioStationDataRequest.getLogoId();
            iSerializer.putInt32(n10);
            boolean bl14 = radioStationDataRequest.isUseLogoId();
            iSerializer.putBool(bl14);
        }
    }

    public static void putOptionalRadioStationDataRequestVarArray(ISerializer iSerializer, RadioStationDataRequest[] radioStationDataRequestArray) {
        boolean bl = radioStationDataRequestArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(radioStationDataRequestArray.length);
            for (int i2 = 0; i2 < radioStationDataRequestArray.length; ++i2) {
                RadioStationDataRequestSerializer.putOptionalRadioStationDataRequest(iSerializer, radioStationDataRequestArray[i2]);
            }
        }
    }

    public static RadioStationDataRequest getOptionalRadioStationDataRequest(IDeserializer iDeserializer) {
        RadioStationDataRequest radioStationDataRequest = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            int n;
            boolean bl3;
            String string;
            boolean bl4;
            int n2;
            boolean bl5;
            long l;
            boolean bl6;
            String string2;
            boolean bl7;
            String string3;
            boolean bl8;
            int n3;
            boolean bl9;
            int n4;
            boolean bl10;
            int n5;
            boolean bl11;
            int n6;
            boolean bl12;
            int n7;
            boolean bl13;
            int n8;
            boolean bl14;
            int n9;
            int n10;
            radioStationDataRequest = new RadioStationDataRequest();
            radioStationDataRequest.maxItemCount = n10 = iDeserializer.getInt32();
            radioStationDataRequest.stationId = n9 = iDeserializer.getInt32();
            radioStationDataRequest.useStationId = bl14 = iDeserializer.getBool();
            radioStationDataRequest.country = n8 = iDeserializer.getInt32();
            radioStationDataRequest.useCountry = bl13 = iDeserializer.getBool();
            radioStationDataRequest.extendedCountryCode = n7 = iDeserializer.getInt32();
            radioStationDataRequest.useExtendedCountryCode = bl12 = iDeserializer.getBool();
            radioStationDataRequest.piSid = n6 = iDeserializer.getInt32();
            radioStationDataRequest.usePiSid = bl11 = iDeserializer.getBool();
            radioStationDataRequest.linkedPiSid = n5 = iDeserializer.getInt32();
            radioStationDataRequest.useLinkedPiSid = bl10 = iDeserializer.getBool();
            radioStationDataRequest.ensembleId = n4 = iDeserializer.getInt32();
            radioStationDataRequest.useEnsembleId = bl9 = iDeserializer.getBool();
            radioStationDataRequest.scidi = n3 = iDeserializer.getInt32();
            radioStationDataRequest.useScidi = bl8 = iDeserializer.getBool();
            radioStationDataRequest.longName = string3 = iDeserializer.getOptionalString();
            radioStationDataRequest.useLongName = bl7 = iDeserializer.getBool();
            radioStationDataRequest.shortName = string2 = iDeserializer.getOptionalString();
            radioStationDataRequest.useShortName = bl6 = iDeserializer.getBool();
            radioStationDataRequest.frequency = l = iDeserializer.getInt64();
            radioStationDataRequest.useFrequency = bl5 = iDeserializer.getBool();
            radioStationDataRequest.subChannelId = n2 = iDeserializer.getInt32();
            radioStationDataRequest.useSubChannelId = bl4 = iDeserializer.getBool();
            radioStationDataRequest.stationType = string = iDeserializer.getOptionalString();
            radioStationDataRequest.useStationType = bl3 = iDeserializer.getBool();
            radioStationDataRequest.logoId = n = iDeserializer.getInt32();
            radioStationDataRequest.useLogoId = bl2 = iDeserializer.getBool();
        }
        return radioStationDataRequest;
    }

    public static RadioStationDataRequest[] getOptionalRadioStationDataRequestVarArray(IDeserializer iDeserializer) {
        RadioStationDataRequest[] radioStationDataRequestArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            radioStationDataRequestArray = new RadioStationDataRequest[n];
            for (int i2 = 0; i2 < n; ++i2) {
                radioStationDataRequestArray[i2] = RadioStationDataRequestSerializer.getOptionalRadioStationDataRequest(iDeserializer);
            }
        }
        return radioStationDataRequestArray;
    }
}

