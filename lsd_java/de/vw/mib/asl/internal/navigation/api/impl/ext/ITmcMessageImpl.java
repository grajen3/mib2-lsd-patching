/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.api.impl.ext;

import de.vw.mib.asl.api.navigation.traffic.ITmcMessage;
import de.vw.mib.asl.api.navigation.traffic.ITmcPhoneme;
import de.vw.mib.asl.internal.navigation.api.impl.ext.ITmcPhonemeImpl;
import org.dsi.ifc.tmc.TmcMessage;

public class ITmcMessageImpl
implements ITmcMessage {
    private long messageID;
    private String[] eventText;
    private boolean isArea;
    private long streetSignId;
    private int[] iconListId;
    private long timeStamp;
    private ITmcPhoneme tmcPhoneme;
    private long affectedLengthOnRoute;
    private long affectedRoadLength;
    private long attentionPoint1;
    private long attentionPoint2;
    private String countryAbbreviation;
    private short countryCodeTMC;
    private int destinationIndex;
    private String directionOfRoad1;
    private String directionOfRoad2;
    private long distanceToEvent;
    private String endLocation;
    private long endTime;
    private long eventAverageSpeed;
    private int[] eventCode;
    private long eventDelay;
    private long eventDelayOnRoute;
    private long eventDuration;
    private int eventType;
    private int exitIconId;
    private String exitNumber;
    private int geoPosLatitude;
    private int geoPosLongitude;
    private long locationID;
    private long messageCount;
    private int messageSource;
    private String providerName;
    private String rawData;
    private long reserved;
    private String roadClass;
    private String roadName;
    private String roadNumber;
    private int routeDeviationIndication;
    private int routeRelevance;
    private String startLocation;
    private long startTime;
    private long startTimeToDestination;
    private String streetCardinalDirection;
    private String urgent;
    private long versionInfo;
    private boolean affectsHOVLane;
    private boolean attentionPoint1Announcment;
    private boolean attentionPoint2Announcment;
    private boolean hasGeoPos;
    private boolean isBidirectional;
    private boolean shouldBeAnnounced;
    private boolean urbanFlag;

    public ITmcMessageImpl(TmcMessage tmcMessage) {
        if (tmcMessage != null) {
            this.messageID = tmcMessage.getMessageID();
            this.eventText = tmcMessage.getEventText();
            this.isArea = tmcMessage.isIsArea();
            this.streetSignId = tmcMessage.getStreetSignId();
            this.iconListId = tmcMessage.getIconListId();
            this.timeStamp = tmcMessage.getTimeStamp();
            this.affectedLengthOnRoute = tmcMessage.getAffectedLengthOnRoute();
            this.affectedRoadLength = tmcMessage.getAffectedRoadLength();
            this.attentionPoint1 = tmcMessage.getAttentionPoint1();
            this.attentionPoint2 = tmcMessage.getAttentionPoint2();
            this.countryAbbreviation = tmcMessage.getCountryAbbreviation();
            this.countryCodeTMC = tmcMessage.getCountryCodeTMC();
            this.destinationIndex = tmcMessage.getDestinationIndex();
            this.directionOfRoad1 = tmcMessage.getDirectionOfRoad1();
            this.directionOfRoad2 = tmcMessage.getDirectionOfRoad2();
            this.distanceToEvent = tmcMessage.getDistanceToEvent();
            this.endLocation = tmcMessage.getEndLocation();
            this.endTime = tmcMessage.getEndTime();
            this.eventAverageSpeed = tmcMessage.getEventAverageSpeed();
            this.eventCode = tmcMessage.getEventCode();
            this.eventDelay = tmcMessage.getEventDelay();
            this.eventDelayOnRoute = tmcMessage.getEventDelayOnRoute();
            this.eventDuration = tmcMessage.getEventDuration();
            this.eventType = tmcMessage.getEventType();
            this.exitIconId = tmcMessage.getExitIconId();
            this.exitNumber = tmcMessage.getExitNumber();
            this.geoPosLatitude = tmcMessage.getGeoPosLatitude();
            this.geoPosLongitude = tmcMessage.getGeoPosLongitude();
            this.locationID = tmcMessage.getLocationID();
            this.messageCount = tmcMessage.getMessageCount();
            this.messageSource = tmcMessage.getMessageSource();
            this.providerName = tmcMessage.getProviderName();
            this.rawData = tmcMessage.getRawData();
            this.reserved = tmcMessage.getReserved();
            this.roadClass = tmcMessage.getRoadClass();
            this.roadName = tmcMessage.getRoadName();
            this.roadNumber = tmcMessage.getRoadNumber();
            this.routeDeviationIndication = tmcMessage.getRouteDeviationIndication();
            this.routeRelevance = tmcMessage.getRouteRelevance();
            this.startLocation = tmcMessage.getStartLocation();
            this.startTime = tmcMessage.getStartTime();
            this.startTimeToDestination = tmcMessage.getStartTimeToDestination();
            this.streetCardinalDirection = tmcMessage.getStreetCardinalDirection();
            this.urgent = tmcMessage.getUrgent();
            this.versionInfo = tmcMessage.getVersionInfo();
            this.affectsHOVLane = tmcMessage.isAffectsHOVLane();
            this.attentionPoint1Announcment = tmcMessage.isAttentionPoint1Announcment();
            this.attentionPoint2Announcment = tmcMessage.isAttentionPoint2Announcment();
            this.hasGeoPos = tmcMessage.isHasGeoPos();
            this.isBidirectional = tmcMessage.isIsBidirectional();
            this.shouldBeAnnounced = tmcMessage.isShouldBeAnnounced();
            this.urbanFlag = tmcMessage.isUrbanFlag();
            this.tmcPhoneme = new ITmcPhonemeImpl(tmcMessage.getPhoneme());
        } else {
            this.messageID = 0L;
            this.eventText = new String[0];
            this.isArea = false;
            this.streetSignId = 0L;
            this.iconListId = new int[0];
            this.timeStamp = 0L;
            this.affectedLengthOnRoute = 0L;
            this.affectedRoadLength = 0L;
            this.attentionPoint1 = 0L;
            this.attentionPoint2 = 0L;
            this.countryAbbreviation = "";
            this.countryCodeTMC = 0;
            this.destinationIndex = 0;
            this.directionOfRoad1 = "";
            this.directionOfRoad2 = "";
            this.distanceToEvent = 0L;
            this.endLocation = "";
            this.endTime = 0L;
            this.eventAverageSpeed = 0L;
            this.eventCode = new int[0];
            this.eventDelay = 0L;
            this.eventDelayOnRoute = 0L;
            this.eventDuration = 0L;
            this.eventType = 0;
            this.exitIconId = 0;
            this.exitNumber = "";
            this.geoPosLatitude = 0;
            this.geoPosLongitude = 0;
            this.locationID = 0L;
            this.messageCount = 0L;
            this.messageSource = 0;
            this.providerName = "";
            this.rawData = "";
            this.reserved = 0L;
            this.roadClass = "";
            this.roadName = "";
            this.roadNumber = "";
            this.routeDeviationIndication = 0;
            this.routeRelevance = 0;
            this.startLocation = "";
            this.startTime = 0L;
            this.startTimeToDestination = 0L;
            this.streetCardinalDirection = "";
            this.urgent = "";
            this.versionInfo = 0L;
            this.affectsHOVLane = false;
            this.attentionPoint1Announcment = false;
            this.attentionPoint2Announcment = false;
            this.hasGeoPos = false;
            this.isBidirectional = false;
            this.shouldBeAnnounced = false;
            this.urbanFlag = false;
            this.tmcPhoneme = new ITmcPhonemeImpl(null);
        }
    }

    @Override
    public long getMessageID() {
        return this.messageID;
    }

    @Override
    public String[] getEventText() {
        return this.eventText;
    }

    @Override
    public boolean isArea() {
        return this.isArea;
    }

    @Override
    public long getStreetSignId() {
        return this.streetSignId;
    }

    @Override
    public int[] getIconListId() {
        return this.iconListId;
    }

    @Override
    public long getTimeStamp() {
        return this.timeStamp;
    }

    @Override
    public long getAffectedLengthOnRoute() {
        return this.affectedLengthOnRoute;
    }

    @Override
    public long getAffectedRoadLength() {
        return this.affectedRoadLength;
    }

    @Override
    public ITmcPhoneme getTmcPhoneme() {
        return this.tmcPhoneme;
    }

    @Override
    public long getAttentionPoint1() {
        return this.attentionPoint1;
    }

    @Override
    public long getAttentionPoint2() {
        return this.attentionPoint2;
    }

    @Override
    public String getCountryAbbreviation() {
        return this.countryAbbreviation;
    }

    @Override
    public short getCountryCodeTMC() {
        return this.countryCodeTMC;
    }

    @Override
    public int getDestinationIndex() {
        return this.destinationIndex;
    }

    @Override
    public String getDirectionOfRoad1() {
        return this.directionOfRoad1;
    }

    @Override
    public String getDirectionOfRoad2() {
        return this.directionOfRoad2;
    }

    @Override
    public long getDistanceToEvent() {
        return this.distanceToEvent;
    }

    @Override
    public String getEndLocation() {
        return this.endLocation;
    }

    @Override
    public long getEndTime() {
        return this.endTime;
    }

    @Override
    public long getEventAverageSpeed() {
        return this.eventAverageSpeed;
    }

    @Override
    public int[] getEventCode() {
        return this.eventCode;
    }

    @Override
    public long getEventDelay() {
        return this.eventDelay;
    }

    @Override
    public long getEventDelayOnRoute() {
        return this.eventDelayOnRoute;
    }

    @Override
    public long getEventDuration() {
        return this.eventDuration;
    }

    @Override
    public int getEventType() {
        return this.eventType;
    }

    @Override
    public int getExitIconId() {
        return this.exitIconId;
    }

    @Override
    public String getExitNumber() {
        return this.exitNumber;
    }

    @Override
    public int getGeoPosLatitude() {
        return this.geoPosLatitude;
    }

    @Override
    public int getGeoPosLongitude() {
        return this.geoPosLongitude;
    }

    @Override
    public long getLocationID() {
        return this.locationID;
    }

    @Override
    public long getMessageCount() {
        return this.messageCount;
    }

    @Override
    public int getMessageSource() {
        return this.messageSource;
    }

    @Override
    public String getProviderName() {
        return this.providerName;
    }

    @Override
    public String getRawData() {
        return this.rawData;
    }

    @Override
    public long getReserved() {
        return this.reserved;
    }

    @Override
    public String getRoadClass() {
        return this.roadClass;
    }

    @Override
    public String getRoadName() {
        return this.roadName;
    }

    @Override
    public String getRoadNumber() {
        return this.roadNumber;
    }

    @Override
    public int getRouteDeviationIndication() {
        return this.routeDeviationIndication;
    }

    @Override
    public int getRouteRelevance() {
        return this.routeRelevance;
    }

    @Override
    public String getStartLocation() {
        return this.startLocation;
    }

    @Override
    public long getStartTime() {
        return this.startTime;
    }

    @Override
    public long getStartTimeToDestination() {
        return this.startTimeToDestination;
    }

    @Override
    public String getStreetCardinalDirection() {
        return this.streetCardinalDirection;
    }

    @Override
    public String getUrgent() {
        return this.urgent;
    }

    @Override
    public long getVersionInfo() {
        return this.versionInfo;
    }

    @Override
    public boolean isAffectsHOVLane() {
        return this.affectsHOVLane;
    }

    @Override
    public boolean isAttentionPoint1Announcment() {
        return this.attentionPoint1Announcment;
    }

    @Override
    public boolean isAttentionPoint2Announcment() {
        return this.attentionPoint2Announcment;
    }

    @Override
    public boolean isHasGeoPos() {
        return this.hasGeoPos;
    }

    @Override
    public boolean isBidirectional() {
        return this.isBidirectional;
    }

    @Override
    public boolean isShouldBeAnnounced() {
        return this.shouldBeAnnounced;
    }

    @Override
    public boolean isUrbanFlag() {
        return this.urbanFlag;
    }
}

