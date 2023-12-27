/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tmc;

import org.dsi.ifc.tmc.TmcPhoneme;

public class TmcMessage {
    public long messageID;
    public long streetSignId;
    public String directionOfRoad1;
    public String directionOfRoad2;
    public String startLocation;
    public String endLocation;
    public String[] eventText;
    public int[] iconListId;
    public int routeRelevance;
    public long eventAverageSpeed;
    public long eventDuration;
    public boolean isBidirectional;
    public boolean hasGeoPos;
    public int geoPosLongitude;
    public int geoPosLatitude;
    public long eventDelay;
    public long distanceToEvent;
    public long messageCount;
    public long versionInfo;
    public long attentionPoint1;
    public long attentionPoint2;
    public boolean attentionPoint1Announcment;
    public boolean attentionPoint2Announcment;
    public String providerName;
    public long timeStamp;
    public String roadName;
    public boolean isArea;
    public boolean shouldBeAnnounced;
    public String roadNumber;
    public boolean urbanFlag;
    public long reserved;
    public long locationID;
    public String urgent;
    public short countryCodeTMC;
    public String countryAbbreviation;
    public String roadClass;
    public int[] eventCode;
    public String rawData;
    public long affectedRoadLength;
    public TmcPhoneme phoneme;
    public int routeDeviationIndication;
    public long startTime;
    public long endTime;
    public long estimaedLastingTime;
    public boolean affectsHOVLane;
    public int messageSource;
    public int destinationIndex;
    public long startTimeToDestination;
    public String exitNumber;
    public int exitIconId;
    public String streetCardinalDirection;
    public long affectedLengthOnRoute;
    public long eventDelayOnRoute;
    public int eventType;

    public TmcMessage() {
        this.messageID = 0L;
        this.streetSignId = 0L;
        this.directionOfRoad1 = null;
        this.directionOfRoad2 = null;
        this.startLocation = null;
        this.endLocation = null;
        this.eventText = null;
        this.iconListId = null;
        this.routeRelevance = 0;
        this.eventAverageSpeed = 0L;
        this.eventDuration = 0L;
        this.isBidirectional = false;
        this.hasGeoPos = false;
        this.geoPosLongitude = 0;
        this.geoPosLatitude = 0;
        this.eventDelay = 0L;
        this.distanceToEvent = 0L;
        this.messageCount = 0L;
        this.versionInfo = 0L;
        this.attentionPoint1 = 0L;
        this.attentionPoint2 = 0L;
        this.attentionPoint1Announcment = false;
        this.attentionPoint2Announcment = false;
        this.providerName = null;
        this.timeStamp = 0L;
        this.roadName = null;
        this.isArea = false;
        this.shouldBeAnnounced = false;
        this.roadNumber = null;
        this.urbanFlag = false;
        this.reserved = 0L;
        this.locationID = 0L;
        this.urgent = null;
        this.countryCodeTMC = 0;
        this.countryAbbreviation = null;
        this.roadClass = null;
        this.eventCode = null;
        this.rawData = null;
        this.affectedRoadLength = 0L;
        this.phoneme = null;
        this.routeDeviationIndication = 0;
        this.startTime = 0L;
        this.endTime = 0L;
        this.estimaedLastingTime = 0L;
        this.affectsHOVLane = false;
        this.messageSource = 0;
        this.destinationIndex = 0;
        this.startTimeToDestination = 0L;
        this.exitNumber = null;
        this.exitIconId = 0;
        this.streetCardinalDirection = null;
        this.affectedLengthOnRoute = 0L;
        this.eventDelayOnRoute = 0L;
        this.eventType = 0;
    }

    public TmcMessage(long l, long l2, String string, String string2, String string3, String string4, String[] stringArray, int[] nArray, int n, long l3, long l4, boolean bl, boolean bl2, int n2, int n3, long l5, long l6, long l7, long l8, long l9, long l10, boolean bl3, boolean bl4, String string5, long l11, String string6, boolean bl5, boolean bl6, String string7, boolean bl7, long l12, long l13, String string8, short s, String string9, String string10, int[] nArray2, String string11, long l14, TmcPhoneme tmcPhoneme, int n4, long l15, long l16, long l17, boolean bl8, int n5, int n6, long l18, String string12, int n7, String string13) {
        this.messageID = l;
        this.streetSignId = l2;
        this.directionOfRoad1 = string;
        this.directionOfRoad2 = string2;
        this.startLocation = string3;
        this.endLocation = string4;
        this.eventText = stringArray;
        this.iconListId = nArray;
        this.routeRelevance = n;
        this.eventAverageSpeed = l3;
        this.eventDuration = l4;
        this.isBidirectional = bl;
        this.hasGeoPos = bl2;
        this.geoPosLongitude = n2;
        this.geoPosLatitude = n3;
        this.eventDelay = l5;
        this.distanceToEvent = l6;
        this.messageCount = l7;
        this.versionInfo = l8;
        this.attentionPoint1 = l9;
        this.attentionPoint2 = l10;
        this.attentionPoint1Announcment = bl3;
        this.attentionPoint2Announcment = bl4;
        this.providerName = string5;
        this.timeStamp = l11;
        this.roadName = string6;
        this.isArea = bl5;
        this.shouldBeAnnounced = bl6;
        this.roadNumber = string7;
        this.urbanFlag = bl7;
        this.reserved = l12;
        this.locationID = l13;
        this.urgent = string8;
        this.countryCodeTMC = s;
        this.countryAbbreviation = string9;
        this.roadClass = string10;
        this.eventCode = nArray2;
        this.rawData = string11;
        this.affectedRoadLength = l14;
        this.phoneme = tmcPhoneme;
        this.routeDeviationIndication = n4;
        this.startTime = l15;
        this.endTime = l16;
        this.estimaedLastingTime = l17;
        this.affectsHOVLane = bl8;
        this.messageSource = n5;
        this.destinationIndex = n6;
        this.startTimeToDestination = l18;
        this.exitNumber = string12;
        this.exitIconId = n7;
        this.streetCardinalDirection = string13;
        this.affectedLengthOnRoute = 0L;
        this.eventDelayOnRoute = 0L;
        this.eventType = 0;
    }

    public TmcMessage(long l, long l2, String string, String string2, String string3, String string4, String[] stringArray, int[] nArray, int n, long l3, long l4, boolean bl, boolean bl2, int n2, int n3, long l5, long l6, long l7, long l8, long l9, long l10, boolean bl3, boolean bl4, String string5, long l11, String string6, boolean bl5, boolean bl6, String string7, boolean bl7, long l12, long l13, String string8, short s, String string9, String string10, int[] nArray2, String string11, long l14, TmcPhoneme tmcPhoneme, int n4, long l15, long l16, long l17, boolean bl8, int n5, int n6, long l18, String string12, int n7, String string13, long l19, long l20, int n8) {
        this.messageID = l;
        this.streetSignId = l2;
        this.directionOfRoad1 = string;
        this.directionOfRoad2 = string2;
        this.startLocation = string3;
        this.endLocation = string4;
        this.eventText = stringArray;
        this.iconListId = nArray;
        this.routeRelevance = n;
        this.eventAverageSpeed = l3;
        this.eventDuration = l4;
        this.isBidirectional = bl;
        this.hasGeoPos = bl2;
        this.geoPosLongitude = n2;
        this.geoPosLatitude = n3;
        this.eventDelay = l5;
        this.distanceToEvent = l6;
        this.messageCount = l7;
        this.versionInfo = l8;
        this.attentionPoint1 = l9;
        this.attentionPoint2 = l10;
        this.attentionPoint1Announcment = bl3;
        this.attentionPoint2Announcment = bl4;
        this.providerName = string5;
        this.timeStamp = l11;
        this.roadName = string6;
        this.isArea = bl5;
        this.shouldBeAnnounced = bl6;
        this.roadNumber = string7;
        this.urbanFlag = bl7;
        this.reserved = l12;
        this.locationID = l13;
        this.urgent = string8;
        this.countryCodeTMC = s;
        this.countryAbbreviation = string9;
        this.roadClass = string10;
        this.eventCode = nArray2;
        this.rawData = string11;
        this.affectedRoadLength = l14;
        this.phoneme = tmcPhoneme;
        this.routeDeviationIndication = n4;
        this.startTime = l15;
        this.endTime = l16;
        this.estimaedLastingTime = l17;
        this.affectsHOVLane = bl8;
        this.messageSource = n5;
        this.destinationIndex = n6;
        this.startTimeToDestination = l18;
        this.exitNumber = string12;
        this.exitIconId = n7;
        this.streetCardinalDirection = string13;
        this.affectedLengthOnRoute = l19;
        this.eventDelayOnRoute = l20;
        this.eventType = 0;
    }

    public long getMessageID() {
        return this.messageID;
    }

    public long getStreetSignId() {
        return this.streetSignId;
    }

    public String getDirectionOfRoad1() {
        return this.directionOfRoad1;
    }

    public String getDirectionOfRoad2() {
        return this.directionOfRoad2;
    }

    public String getStartLocation() {
        return this.startLocation;
    }

    public String getEndLocation() {
        return this.endLocation;
    }

    public String[] getEventText() {
        return this.eventText;
    }

    public int[] getIconListId() {
        return this.iconListId;
    }

    public int getRouteRelevance() {
        return this.routeRelevance;
    }

    public long getEventAverageSpeed() {
        return this.eventAverageSpeed;
    }

    public long getEventDuration() {
        return this.eventDuration;
    }

    public boolean isIsBidirectional() {
        return this.isBidirectional;
    }

    public boolean isHasGeoPos() {
        return this.hasGeoPos;
    }

    public int getGeoPosLongitude() {
        return this.geoPosLongitude;
    }

    public int getGeoPosLatitude() {
        return this.geoPosLatitude;
    }

    public long getEventDelay() {
        return this.eventDelay;
    }

    public long getDistanceToEvent() {
        return this.distanceToEvent;
    }

    public long getMessageCount() {
        return this.messageCount;
    }

    public long getVersionInfo() {
        return this.versionInfo;
    }

    public long getAttentionPoint1() {
        return this.attentionPoint1;
    }

    public long getAttentionPoint2() {
        return this.attentionPoint2;
    }

    public boolean isAttentionPoint1Announcment() {
        return this.attentionPoint1Announcment;
    }

    public boolean isAttentionPoint2Announcment() {
        return this.attentionPoint2Announcment;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public String getRoadName() {
        return this.roadName;
    }

    public boolean isIsArea() {
        return this.isArea;
    }

    public boolean isShouldBeAnnounced() {
        return this.shouldBeAnnounced;
    }

    public String getRoadNumber() {
        return this.roadNumber;
    }

    public boolean isUrbanFlag() {
        return this.urbanFlag;
    }

    public long getReserved() {
        return this.reserved;
    }

    public long getLocationID() {
        return this.locationID;
    }

    public String getUrgent() {
        return this.urgent;
    }

    public short getCountryCodeTMC() {
        return this.countryCodeTMC;
    }

    public String getCountryAbbreviation() {
        return this.countryAbbreviation;
    }

    public String getRoadClass() {
        return this.roadClass;
    }

    public int[] getEventCode() {
        return this.eventCode;
    }

    public String getRawData() {
        return this.rawData;
    }

    public long getAffectedRoadLength() {
        return this.affectedRoadLength;
    }

    public TmcPhoneme getPhoneme() {
        return this.phoneme;
    }

    public int getRouteDeviationIndication() {
        return this.routeDeviationIndication;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEstimaedLastingTime() {
        return this.estimaedLastingTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public boolean isAffectsHOVLane() {
        return this.affectsHOVLane;
    }

    public int getMessageSource() {
        return this.messageSource;
    }

    public int getDestinationIndex() {
        return this.destinationIndex;
    }

    public long getStartTimeToDestination() {
        return this.startTimeToDestination;
    }

    public String getExitNumber() {
        return this.exitNumber;
    }

    public int getExitIconId() {
        return this.exitIconId;
    }

    public String getStreetCardinalDirection() {
        return this.streetCardinalDirection;
    }

    public long getAffectedLengthOnRoute() {
        return this.affectedLengthOnRoute;
    }

    public long getEventDelayOnRoute() {
        return this.eventDelayOnRoute;
    }

    public int getEventType() {
        return this.eventType;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(4750);
        stringBuffer.append("TmcMessage");
        stringBuffer.append('(');
        stringBuffer.append("messageID");
        stringBuffer.append('=');
        stringBuffer.append(this.messageID);
        stringBuffer.append(',');
        stringBuffer.append("streetSignId");
        stringBuffer.append('=');
        stringBuffer.append(this.streetSignId);
        stringBuffer.append(',');
        stringBuffer.append("directionOfRoad1");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.directionOfRoad1);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("directionOfRoad2");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.directionOfRoad2);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("startLocation");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.startLocation);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("endLocation");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.endLocation);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("eventText");
        stringBuffer.append('[');
        if (this.eventText != null) {
            stringBuffer.append(this.eventText.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.eventText != null) {
            n3 = this.eventText.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.eventText[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.eventText);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("iconListId");
        stringBuffer.append('[');
        if (this.iconListId != null) {
            stringBuffer.append(this.iconListId.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.iconListId != null) {
            n3 = this.iconListId.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.iconListId[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.iconListId);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("routeRelevance");
        stringBuffer.append('=');
        stringBuffer.append(this.routeRelevance);
        stringBuffer.append(',');
        stringBuffer.append("eventAverageSpeed");
        stringBuffer.append('=');
        stringBuffer.append(this.eventAverageSpeed);
        stringBuffer.append(',');
        stringBuffer.append("eventDuration");
        stringBuffer.append('=');
        stringBuffer.append(this.eventDuration);
        stringBuffer.append(',');
        stringBuffer.append("isBidirectional");
        stringBuffer.append('=');
        stringBuffer.append(this.isBidirectional);
        stringBuffer.append(',');
        stringBuffer.append("hasGeoPos");
        stringBuffer.append('=');
        stringBuffer.append(this.hasGeoPos);
        stringBuffer.append(',');
        stringBuffer.append("geoPosLongitude");
        stringBuffer.append('=');
        stringBuffer.append(this.geoPosLongitude);
        stringBuffer.append(',');
        stringBuffer.append("geoPosLatitude");
        stringBuffer.append('=');
        stringBuffer.append(this.geoPosLatitude);
        stringBuffer.append(',');
        stringBuffer.append("eventDelay");
        stringBuffer.append('=');
        stringBuffer.append(this.eventDelay);
        stringBuffer.append(',');
        stringBuffer.append("distanceToEvent");
        stringBuffer.append('=');
        stringBuffer.append(this.distanceToEvent);
        stringBuffer.append(',');
        stringBuffer.append("messageCount");
        stringBuffer.append('=');
        stringBuffer.append(this.messageCount);
        stringBuffer.append(',');
        stringBuffer.append("versionInfo");
        stringBuffer.append('=');
        stringBuffer.append(this.versionInfo);
        stringBuffer.append(',');
        stringBuffer.append("attentionPoint1");
        stringBuffer.append('=');
        stringBuffer.append(this.attentionPoint1);
        stringBuffer.append(',');
        stringBuffer.append("attentionPoint2");
        stringBuffer.append('=');
        stringBuffer.append(this.attentionPoint2);
        stringBuffer.append(',');
        stringBuffer.append("attentionPoint1Announcment");
        stringBuffer.append('=');
        stringBuffer.append(this.attentionPoint1Announcment);
        stringBuffer.append(',');
        stringBuffer.append("attentionPoint2Announcment");
        stringBuffer.append('=');
        stringBuffer.append(this.attentionPoint2Announcment);
        stringBuffer.append(',');
        stringBuffer.append("providerName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.providerName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("timeStamp");
        stringBuffer.append('=');
        stringBuffer.append(this.timeStamp);
        stringBuffer.append(',');
        stringBuffer.append("roadName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.roadName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("isArea");
        stringBuffer.append('=');
        stringBuffer.append(this.isArea);
        stringBuffer.append(',');
        stringBuffer.append("shouldBeAnnounced");
        stringBuffer.append('=');
        stringBuffer.append(this.shouldBeAnnounced);
        stringBuffer.append(',');
        stringBuffer.append("roadNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.roadNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("urbanFlag");
        stringBuffer.append('=');
        stringBuffer.append(this.urbanFlag);
        stringBuffer.append(',');
        stringBuffer.append("reserved");
        stringBuffer.append('=');
        stringBuffer.append(this.reserved);
        stringBuffer.append(',');
        stringBuffer.append("locationID");
        stringBuffer.append('=');
        stringBuffer.append(this.locationID);
        stringBuffer.append(',');
        stringBuffer.append("urgent");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.urgent);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("countryCodeTMC");
        stringBuffer.append('=');
        stringBuffer.append(this.countryCodeTMC);
        stringBuffer.append(',');
        stringBuffer.append("countryAbbreviation");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.countryAbbreviation);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("roadClass");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.roadClass);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("eventCode");
        stringBuffer.append('[');
        if (this.eventCode != null) {
            stringBuffer.append(this.eventCode.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.eventCode != null) {
            n3 = this.eventCode.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.eventCode[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.eventCode);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("rawData");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.rawData);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("affectedRoadLength");
        stringBuffer.append('=');
        stringBuffer.append(this.affectedRoadLength);
        stringBuffer.append(',');
        stringBuffer.append("phoneme");
        stringBuffer.append('=');
        stringBuffer.append(this.phoneme);
        stringBuffer.append(',');
        stringBuffer.append("routeDeviationIndication");
        stringBuffer.append('=');
        stringBuffer.append(this.routeDeviationIndication);
        stringBuffer.append(',');
        stringBuffer.append("startTime");
        stringBuffer.append('=');
        stringBuffer.append(this.startTime);
        stringBuffer.append(',');
        stringBuffer.append("endTime");
        stringBuffer.append('=');
        stringBuffer.append(this.endTime);
        stringBuffer.append(',');
        stringBuffer.append("estimaedLastingTime");
        stringBuffer.append('=');
        stringBuffer.append(this.estimaedLastingTime);
        stringBuffer.append(',');
        stringBuffer.append("affectsHOVLane");
        stringBuffer.append('=');
        stringBuffer.append(this.affectsHOVLane);
        stringBuffer.append(',');
        stringBuffer.append("messageSource");
        stringBuffer.append('=');
        stringBuffer.append(this.messageSource);
        stringBuffer.append(',');
        stringBuffer.append("destinationIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.destinationIndex);
        stringBuffer.append(',');
        stringBuffer.append("startTimeToDestination");
        stringBuffer.append('=');
        stringBuffer.append(this.startTimeToDestination);
        stringBuffer.append(',');
        stringBuffer.append("exitNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.exitNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("exitIconId");
        stringBuffer.append('=');
        stringBuffer.append(this.exitIconId);
        stringBuffer.append(',');
        stringBuffer.append("streetCardinalDirection");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.streetCardinalDirection);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("affectedLengthOnRoute");
        stringBuffer.append('=');
        stringBuffer.append(this.affectedLengthOnRoute);
        stringBuffer.append(',');
        stringBuffer.append("eventDelayOnRoute");
        stringBuffer.append('=');
        stringBuffer.append(this.eventDelayOnRoute);
        stringBuffer.append(',');
        stringBuffer.append("eventType");
        stringBuffer.append('=');
        stringBuffer.append(this.eventType);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

