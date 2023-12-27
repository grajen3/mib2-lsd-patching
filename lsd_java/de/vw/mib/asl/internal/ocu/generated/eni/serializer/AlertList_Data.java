/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.asl.internal.ocu.generated.eni.serializer.AlertList_Attributes;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.AlertList_PeriodicSchedule;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class AlertList_Data
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_CUSTOMER_NAME_ALERT_TYPE_SPEED_LIMIT_ZONE_SHAPE_ZONE_TYPE_ATTRIBUTES_FIRST_RADIUS_WIDTH_SECOND_RADIUS_HEIGHT_ROTATION_ANGLE_POSITION_LATITUDE_POSITION_LONGITUDE_START_END_PERIODIC_SCHEDULE_PERIODIC_START_TIME_PERIODIC_END_TIME_WEEK_INTERVAL;
    public static final int RECORD_ADDRESS_POS;
    public static final int POS_MIN;
    public int pos;
    private static final int MAX_CUSTOMERNAME_LENGTH;
    public final BAPString customerName;
    public static final int ALERT_TYPE_UNKNOWN;
    public static final int ALERT_TYPE_SPEED_ALERT;
    public static final int ALERT_TYPE_GEOFENCE_ALERT;
    public static final int ALERT_TYPE_VALET_ALERT;
    public static final int ALERT_TYPE_CUREFEW_ALERT;
    public int alertType;
    public static final int SPEED_LIMIT_MIN;
    public int speedLimit;
    public static final int ZONE_SHAPE_NOT_AVAILABLE;
    public static final int ZONE_SHAPE_ELLIPSE;
    public static final int ZONE_SHAPE_RECTANGLE;
    public int zoneShape;
    public static final int ZONE_TYPE_NOT_AVAILABLE;
    public static final int ZONE_TYPE_GREEN_ZONE;
    public static final int ZONE_TYPE_RED_ZONE;
    public int zoneType;
    public AlertList_Attributes attributes;
    public static final int FIRST_RADIUS_WIDTH_MIN;
    public int firstRadius_Width;
    public static final int SECOND_RADIUS_HEIGHT_MIN;
    public int secondRadius_Height;
    public static final int ROTATION_ANGLE_MIN;
    public int rotationAngle;
    public static final int POSITION_LATITUDE_MIN;
    public int position_Latitude;
    public static final int POSITION_LONGITUDE_MIN;
    public int position_Longitude;
    private static final int MAX_START_LENGTH;
    public final BAPString start;
    private static final int MAX_END_LENGTH;
    public final BAPString end;
    public AlertList_PeriodicSchedule periodicSchedule;
    private static final int MAX_PERIODICSTARTTIME_LENGTH;
    public final BAPString periodicStartTime;
    private static final int MAX_PERIODICENDTIME_LENGTH;
    public final BAPString periodicEndTime;
    public static final int WEEK_INTERVAL_MIN;
    public int weekInterval;
    private static final int MAX_EXTENSION_LENGTH;
    public final BAPString extension;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public AlertList_Data(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.customerName = new BAPString(61);
        this.attributes = new AlertList_Attributes();
        this.start = new BAPString(18);
        this.end = new BAPString(18);
        this.periodicSchedule = new AlertList_PeriodicSchedule();
        this.periodicStartTime = new BAPString(6);
        this.periodicEndTime = new BAPString(6);
        this.extension = new BAPString(2);
        this.internalReset();
        this.customInitialization();
    }

    public AlertList_Data(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.alertType = 0;
        this.speedLimit = 0;
        this.zoneShape = 0;
        this.zoneType = 0;
        this.firstRadius_Width = 0;
        this.secondRadius_Height = 0;
        this.rotationAngle = 0;
        this.position_Latitude = -90;
        this.position_Longitude = -180;
        this.weekInterval = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.customerName.reset();
        this.attributes.reset();
        this.start.reset();
        this.end.reset();
        this.periodicSchedule.reset();
        this.periodicStartTime.reset();
        this.periodicEndTime.reset();
        this.extension.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        AlertList_Data alertList_Data = (AlertList_Data)bAPEntity;
        return this.arrayHeader.equalTo(alertList_Data.arrayHeader) && this.pos == alertList_Data.pos && this.customerName.equalTo(alertList_Data.customerName) && this.alertType == alertList_Data.alertType && this.speedLimit == alertList_Data.speedLimit && this.zoneShape == alertList_Data.zoneShape && this.zoneType == alertList_Data.zoneType && this.attributes.equalTo(alertList_Data.attributes) && this.firstRadius_Width == alertList_Data.firstRadius_Width && this.secondRadius_Height == alertList_Data.secondRadius_Height && this.rotationAngle == alertList_Data.rotationAngle && this.position_Latitude == alertList_Data.position_Latitude && this.position_Longitude == alertList_Data.position_Longitude && this.start.equalTo(alertList_Data.start) && this.end.equalTo(alertList_Data.end) && this.periodicSchedule.equalTo(alertList_Data.periodicSchedule) && this.periodicStartTime.equalTo(alertList_Data.periodicStartTime) && this.periodicEndTime.equalTo(alertList_Data.periodicEndTime) && this.weekInterval == alertList_Data.weekInterval && this.extension.equalTo(alertList_Data.extension);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "AlertList_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                this.customerName.serialize(bitStream);
                bitStream.pushByte((byte)this.alertType);
                bitStream.pushByte((byte)this.speedLimit);
                bitStream.pushByte((byte)this.zoneShape);
                bitStream.pushByte((byte)this.zoneType);
                this.attributes.serialize(bitStream);
                bitStream.pushInt(this.firstRadius_Width);
                bitStream.pushInt(this.secondRadius_Height);
                bitStream.pushShort((short)this.rotationAngle);
                bitStream.pushInt(this.position_Latitude);
                bitStream.pushInt(this.position_Longitude);
                this.start.serialize(bitStream);
                this.end.serialize(bitStream);
                this.periodicSchedule.serialize(bitStream);
                this.periodicStartTime.serialize(bitStream);
                this.periodicEndTime.serialize(bitStream);
                bitStream.pushByte((byte)this.weekInterval);
                break;
            }
        }
    }

    @Override
    public void deserialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 15: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                break;
            }
            case 1: {
                this.arrayHeader.deserializePosOfArrayElement(bitStream, this);
                this.customerName.deserialize(bitStream);
                this.alertType = bitStream.popFrontByte();
                this.speedLimit = bitStream.popFrontByte();
                this.zoneShape = bitStream.popFrontByte();
                this.zoneType = bitStream.popFrontByte();
                this.attributes.deserialize(bitStream);
                this.firstRadius_Width = bitStream.popFrontInt();
                this.secondRadius_Height = bitStream.popFrontInt();
                this.rotationAngle = bitStream.popFrontShort();
                this.position_Latitude = bitStream.popFrontInt();
                this.position_Longitude = bitStream.popFrontInt();
                this.start.deserialize(bitStream);
                this.end.deserialize(bitStream);
                this.periodicSchedule.deserialize(bitStream);
                this.periodicStartTime.deserialize(bitStream);
                this.periodicEndTime.deserialize(bitStream);
                this.weekInterval = bitStream.popFrontByte();
                break;
            }
        }
    }

    @Override
    public void setPos(int n) {
        this.pos = n;
    }

    @Override
    public int getPos() {
        return this.pos;
    }
}

