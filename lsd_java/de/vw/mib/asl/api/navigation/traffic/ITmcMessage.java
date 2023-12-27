/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.traffic;

import de.vw.mib.asl.api.navigation.traffic.ITmcPhoneme;

public interface ITmcMessage {
    default public String[] getEventText() {
    }

    default public long getMessageID() {
    }

    default public ITmcPhoneme getTmcPhoneme() {
    }

    default public long getTimeStamp() {
    }

    default public int[] getIconListId() {
    }

    default public long getStreetSignId() {
    }

    default public boolean isArea() {
    }

    default public long getAffectedLengthOnRoute() {
    }

    default public long getAffectedRoadLength() {
    }

    default public long getAttentionPoint1() {
    }

    default public long getAttentionPoint2() {
    }

    default public String getCountryAbbreviation() {
    }

    default public short getCountryCodeTMC() {
    }

    default public int getDestinationIndex() {
    }

    default public String getDirectionOfRoad1() {
    }

    default public String getDirectionOfRoad2() {
    }

    default public long getDistanceToEvent() {
    }

    default public String getEndLocation() {
    }

    default public long getEndTime() {
    }

    default public long getEventAverageSpeed() {
    }

    default public int[] getEventCode() {
    }

    default public long getEventDelay() {
    }

    default public long getEventDelayOnRoute() {
    }

    default public long getEventDuration() {
    }

    default public int getEventType() {
    }

    default public int getExitIconId() {
    }

    default public String getExitNumber() {
    }

    default public int getGeoPosLatitude() {
    }

    default public int getGeoPosLongitude() {
    }

    default public long getLocationID() {
    }

    default public long getMessageCount() {
    }

    default public int getMessageSource() {
    }

    default public String getProviderName() {
    }

    default public String getRawData() {
    }

    default public long getReserved() {
    }

    default public String getRoadClass() {
    }

    default public String getRoadName() {
    }

    default public String getRoadNumber() {
    }

    default public int getRouteDeviationIndication() {
    }

    default public int getRouteRelevance() {
    }

    default public String getStartLocation() {
    }

    default public long getStartTime() {
    }

    default public long getStartTimeToDestination() {
    }

    default public String getStreetCardinalDirection() {
    }

    default public String getUrgent() {
    }

    default public long getVersionInfo() {
    }

    default public boolean isAffectsHOVLane() {
    }

    default public boolean isAttentionPoint1Announcment() {
    }

    default public boolean isAttentionPoint2Announcment() {
    }

    default public boolean isHasGeoPos() {
    }

    default public boolean isBidirectional() {
    }

    default public boolean isShouldBeAnnounced() {
    }

    default public boolean isUrbanFlag() {
    }
}

