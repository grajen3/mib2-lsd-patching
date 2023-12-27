/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class AnnouncementInfo_Status
implements StatusProperty {
    public int announcementType;
    public static final int ANNOUNCEMENT_TYPE_WARNING_SERVICE;
    public static final int ANNOUNCEMENT_TYPE_TMC_TTS_TMC_READING;
    public static final int ANNOUNCEMENT_TYPE_EMERGENCY_INFORMATION_EMERGENCY_ANNOUNCEMENT;
    public static final int ANNOUNCEMENT_TYPE_FINANCIAL_REPORT;
    public static final int ANNOUNCEMENT_TYPE_SPORT_REPORT;
    public static final int ANNOUNCEMENT_TYPE_PROGRAMME_INFORMATION_RADIO_INFO;
    public static final int ANNOUNCEMENT_TYPE_SPECIAL_EVENT_INFORMATION_ON_UNSCHEDULED_OR_PREVIOUSLY_UNFORESEEN_EVENTS;
    public static final int ANNOUNCEMENT_TYPE_EVENT_ANNOUNCEMENT;
    public static final int ANNOUNCEMENT_TYPE_AREA_WEATHER;
    public static final int ANNOUNCEMENT_TYPE_NEWS;
    public static final int ANNOUNCEMENT_TYPE_TRANSPORT_FLASH_E_G_SCHEDULES_OF_BUSES_FERRIES_PLANES_OR_TRAINS;
    public static final int ANNOUNCEMENT_TYPE_TRAFFIC_ANNOUNCEMENT_ROAD_TRAFFIC_FLASH_I_E_INFORMATION_ABOUT_PROBLEMS_ON_THE_ROAD;
    public static final int ANNOUNCEMENT_TYPE_RDS_PTY31_ANNOUNCEMENT_KATASTROPHENMELDUNG;
    public static final int ANNOUNCEMENT_TYPE_NO_MESSAGE_ANNOUNCEMENT_ACTIVE;
    public final BAPString stationName = new BAPString(49);
    private static final int MAX_STATIONNAME_LENGTH;

    public AnnouncementInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public AnnouncementInfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.announcementType = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.stationName.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        AnnouncementInfo_Status announcementInfo_Status = (AnnouncementInfo_Status)bAPEntity;
        return this.announcementType == announcementInfo_Status.announcementType && this.stationName.equalTo(announcementInfo_Status.stationName);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "AnnouncementInfo_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.announcementType);
        this.stationName.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.announcementType = bitStream.popFrontByte();
        this.stationName.deserialize(bitStream);
    }

    public static int functionId() {
        return 28;
    }

    @Override
    public int getFunctionId() {
        return AnnouncementInfo_Status.functionId();
    }
}

