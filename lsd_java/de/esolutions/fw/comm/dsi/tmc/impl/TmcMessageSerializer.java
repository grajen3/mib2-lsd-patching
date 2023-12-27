/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tmc.impl;

import de.esolutions.fw.comm.dsi.tmc.impl.TmcPhonemeSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tmc.TmcMessage;
import org.dsi.ifc.tmc.TmcPhoneme;

public class TmcMessageSerializer {
    public static void putOptionalTmcMessage(ISerializer iSerializer, TmcMessage tmcMessage) {
        boolean bl = tmcMessage == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = tmcMessage.getMessageID();
            iSerializer.putInt64(l);
            long l2 = tmcMessage.getStreetSignId();
            iSerializer.putInt64(l2);
            String string = tmcMessage.getDirectionOfRoad1();
            iSerializer.putOptionalString(string);
            String string2 = tmcMessage.getDirectionOfRoad2();
            iSerializer.putOptionalString(string2);
            String string3 = tmcMessage.getStartLocation();
            iSerializer.putOptionalString(string3);
            String string4 = tmcMessage.getEndLocation();
            iSerializer.putOptionalString(string4);
            String[] stringArray = tmcMessage.getEventText();
            iSerializer.putOptionalStringVarArray(stringArray);
            int[] nArray = tmcMessage.getIconListId();
            iSerializer.putOptionalInt32VarArray(nArray);
            int n = tmcMessage.getRouteRelevance();
            iSerializer.putInt32(n);
            long l3 = tmcMessage.getEventAverageSpeed();
            iSerializer.putInt64(l3);
            long l4 = tmcMessage.getEventDuration();
            iSerializer.putInt64(l4);
            boolean bl2 = tmcMessage.isIsBidirectional();
            iSerializer.putBool(bl2);
            boolean bl3 = tmcMessage.isHasGeoPos();
            iSerializer.putBool(bl3);
            int n2 = tmcMessage.getGeoPosLongitude();
            iSerializer.putInt32(n2);
            int n3 = tmcMessage.getGeoPosLatitude();
            iSerializer.putInt32(n3);
            long l5 = tmcMessage.getEventDelay();
            iSerializer.putInt64(l5);
            long l6 = tmcMessage.getDistanceToEvent();
            iSerializer.putInt64(l6);
            long l7 = tmcMessage.getMessageCount();
            iSerializer.putInt64(l7);
            long l8 = tmcMessage.getVersionInfo();
            iSerializer.putInt64(l8);
            long l9 = tmcMessage.getAttentionPoint1();
            iSerializer.putInt64(l9);
            long l10 = tmcMessage.getAttentionPoint2();
            iSerializer.putInt64(l10);
            boolean bl4 = tmcMessage.isAttentionPoint1Announcment();
            iSerializer.putBool(bl4);
            boolean bl5 = tmcMessage.isAttentionPoint2Announcment();
            iSerializer.putBool(bl5);
            String string5 = tmcMessage.getProviderName();
            iSerializer.putOptionalString(string5);
            long l11 = tmcMessage.getTimeStamp();
            iSerializer.putInt64(l11);
            String string6 = tmcMessage.getRoadName();
            iSerializer.putOptionalString(string6);
            boolean bl6 = tmcMessage.isIsArea();
            iSerializer.putBool(bl6);
            boolean bl7 = tmcMessage.isShouldBeAnnounced();
            iSerializer.putBool(bl7);
            String string7 = tmcMessage.getRoadNumber();
            iSerializer.putOptionalString(string7);
            boolean bl8 = tmcMessage.isUrbanFlag();
            iSerializer.putBool(bl8);
            long l12 = tmcMessage.getReserved();
            iSerializer.putInt64(l12);
            long l13 = tmcMessage.getLocationID();
            iSerializer.putInt64(l13);
            String string8 = tmcMessage.getUrgent();
            iSerializer.putOptionalString(string8);
            short s = tmcMessage.getCountryCodeTMC();
            iSerializer.putInt16(s);
            String string9 = tmcMessage.getCountryAbbreviation();
            iSerializer.putOptionalString(string9);
            String string10 = tmcMessage.getRoadClass();
            iSerializer.putOptionalString(string10);
            int[] nArray2 = tmcMessage.getEventCode();
            iSerializer.putOptionalInt32VarArray(nArray2);
            String string11 = tmcMessage.getRawData();
            iSerializer.putOptionalString(string11);
            long l14 = tmcMessage.getAffectedRoadLength();
            iSerializer.putInt64(l14);
            TmcPhoneme tmcPhoneme = tmcMessage.getPhoneme();
            TmcPhonemeSerializer.putOptionalTmcPhoneme(iSerializer, tmcPhoneme);
            int n4 = tmcMessage.getRouteDeviationIndication();
            iSerializer.putInt32(n4);
            long l15 = tmcMessage.getStartTime();
            iSerializer.putInt64(l15);
            long l16 = tmcMessage.getEndTime();
            iSerializer.putInt64(l16);
            long l17 = tmcMessage.getEstimaedLastingTime();
            iSerializer.putInt64(l17);
            boolean bl9 = tmcMessage.isAffectsHOVLane();
            iSerializer.putBool(bl9);
            int n5 = tmcMessage.getMessageSource();
            iSerializer.putInt32(n5);
            int n6 = tmcMessage.getDestinationIndex();
            iSerializer.putInt32(n6);
            long l18 = tmcMessage.getStartTimeToDestination();
            iSerializer.putInt64(l18);
            String string12 = tmcMessage.getExitNumber();
            iSerializer.putOptionalString(string12);
            int n7 = tmcMessage.getExitIconId();
            iSerializer.putInt32(n7);
            String string13 = tmcMessage.getStreetCardinalDirection();
            iSerializer.putOptionalString(string13);
            long l19 = tmcMessage.getAffectedLengthOnRoute();
            iSerializer.putInt64(l19);
            long l20 = tmcMessage.getEventDelayOnRoute();
            iSerializer.putInt64(l20);
            int n8 = tmcMessage.getEventType();
            iSerializer.putInt32(n8);
        }
    }

    public static void putOptionalTmcMessageVarArray(ISerializer iSerializer, TmcMessage[] tmcMessageArray) {
        boolean bl = tmcMessageArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(tmcMessageArray.length);
            for (int i2 = 0; i2 < tmcMessageArray.length; ++i2) {
                TmcMessageSerializer.putOptionalTmcMessage(iSerializer, tmcMessageArray[i2]);
            }
        }
    }

    public static TmcMessage getOptionalTmcMessage(IDeserializer iDeserializer) {
        TmcMessage tmcMessage = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            long l;
            long l2;
            String string;
            int n2;
            String string2;
            long l3;
            int n3;
            int n4;
            boolean bl2;
            long l4;
            long l5;
            long l6;
            int n5;
            TmcPhoneme tmcPhoneme;
            long l7;
            String string3;
            String string4;
            String string5;
            short s;
            String string6;
            long l8;
            long l9;
            boolean bl3;
            String string7;
            boolean bl4;
            boolean bl5;
            String string8;
            long l10;
            String string9;
            boolean bl6;
            boolean bl7;
            long l11;
            long l12;
            long l13;
            long l14;
            long l15;
            long l16;
            int n6;
            int n7;
            boolean bl8;
            boolean bl9;
            long l17;
            long l18;
            int n8;
            String string10;
            String string11;
            String string12;
            String string13;
            long l19;
            long l20;
            tmcMessage = new TmcMessage();
            tmcMessage.messageID = l20 = iDeserializer.getInt64();
            tmcMessage.streetSignId = l19 = iDeserializer.getInt64();
            tmcMessage.directionOfRoad1 = string13 = iDeserializer.getOptionalString();
            tmcMessage.directionOfRoad2 = string12 = iDeserializer.getOptionalString();
            tmcMessage.startLocation = string11 = iDeserializer.getOptionalString();
            tmcMessage.endLocation = string10 = iDeserializer.getOptionalString();
            String[] stringArray = iDeserializer.getOptionalStringVarArray();
            tmcMessage.eventText = stringArray;
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            tmcMessage.iconListId = nArray;
            tmcMessage.routeRelevance = n8 = iDeserializer.getInt32();
            tmcMessage.eventAverageSpeed = l18 = iDeserializer.getInt64();
            tmcMessage.eventDuration = l17 = iDeserializer.getInt64();
            tmcMessage.isBidirectional = bl9 = iDeserializer.getBool();
            tmcMessage.hasGeoPos = bl8 = iDeserializer.getBool();
            tmcMessage.geoPosLongitude = n7 = iDeserializer.getInt32();
            tmcMessage.geoPosLatitude = n6 = iDeserializer.getInt32();
            tmcMessage.eventDelay = l16 = iDeserializer.getInt64();
            tmcMessage.distanceToEvent = l15 = iDeserializer.getInt64();
            tmcMessage.messageCount = l14 = iDeserializer.getInt64();
            tmcMessage.versionInfo = l13 = iDeserializer.getInt64();
            tmcMessage.attentionPoint1 = l12 = iDeserializer.getInt64();
            tmcMessage.attentionPoint2 = l11 = iDeserializer.getInt64();
            tmcMessage.attentionPoint1Announcment = bl7 = iDeserializer.getBool();
            tmcMessage.attentionPoint2Announcment = bl6 = iDeserializer.getBool();
            tmcMessage.providerName = string9 = iDeserializer.getOptionalString();
            tmcMessage.timeStamp = l10 = iDeserializer.getInt64();
            tmcMessage.roadName = string8 = iDeserializer.getOptionalString();
            tmcMessage.isArea = bl5 = iDeserializer.getBool();
            tmcMessage.shouldBeAnnounced = bl4 = iDeserializer.getBool();
            tmcMessage.roadNumber = string7 = iDeserializer.getOptionalString();
            tmcMessage.urbanFlag = bl3 = iDeserializer.getBool();
            tmcMessage.reserved = l9 = iDeserializer.getInt64();
            tmcMessage.locationID = l8 = iDeserializer.getInt64();
            tmcMessage.urgent = string6 = iDeserializer.getOptionalString();
            tmcMessage.countryCodeTMC = s = iDeserializer.getInt16();
            tmcMessage.countryAbbreviation = string5 = iDeserializer.getOptionalString();
            tmcMessage.roadClass = string4 = iDeserializer.getOptionalString();
            int[] nArray2 = iDeserializer.getOptionalInt32VarArray();
            tmcMessage.eventCode = nArray2;
            tmcMessage.rawData = string3 = iDeserializer.getOptionalString();
            tmcMessage.affectedRoadLength = l7 = iDeserializer.getInt64();
            tmcMessage.phoneme = tmcPhoneme = TmcPhonemeSerializer.getOptionalTmcPhoneme(iDeserializer);
            tmcMessage.routeDeviationIndication = n5 = iDeserializer.getInt32();
            tmcMessage.startTime = l6 = iDeserializer.getInt64();
            tmcMessage.endTime = l5 = iDeserializer.getInt64();
            tmcMessage.estimaedLastingTime = l4 = iDeserializer.getInt64();
            tmcMessage.affectsHOVLane = bl2 = iDeserializer.getBool();
            tmcMessage.messageSource = n4 = iDeserializer.getInt32();
            tmcMessage.destinationIndex = n3 = iDeserializer.getInt32();
            tmcMessage.startTimeToDestination = l3 = iDeserializer.getInt64();
            tmcMessage.exitNumber = string2 = iDeserializer.getOptionalString();
            tmcMessage.exitIconId = n2 = iDeserializer.getInt32();
            tmcMessage.streetCardinalDirection = string = iDeserializer.getOptionalString();
            tmcMessage.affectedLengthOnRoute = l2 = iDeserializer.getInt64();
            tmcMessage.eventDelayOnRoute = l = iDeserializer.getInt64();
            tmcMessage.eventType = n = iDeserializer.getInt32();
        }
        return tmcMessage;
    }

    public static TmcMessage[] getOptionalTmcMessageVarArray(IDeserializer iDeserializer) {
        TmcMessage[] tmcMessageArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            tmcMessageArray = new TmcMessage[n];
            for (int i2 = 0; i2 < n; ++i2) {
                tmcMessageArray[i2] = TmcMessageSerializer.getOptionalTmcMessage(iDeserializer);
            }
        }
        return tmcMessageArray;
    }
}

