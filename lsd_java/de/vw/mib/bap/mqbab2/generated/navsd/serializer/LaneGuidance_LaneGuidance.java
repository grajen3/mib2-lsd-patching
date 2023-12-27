/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.stream.BitStream;

public final class LaneGuidance_LaneGuidance
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_LANE_DIRECTION_LANE_SIDESTREETS_LANE_TYPE_LANE_MARKING_LEFT_LANE_MARKING_RIGHT_LANE_DESCRIPTION_GUIDANCE_INFO;
    public static final int RECORD_ADDRESS_LANE_DIRECTION_LANE_SIDESTREETS_LANE_TYPE_LANE_DESCRIPTION_GUIDANCE_INFO;
    public static final int RECORD_ADDRESS_LANE_DIRECTION_LANE_DESCRIPTION_GUIDANCE_INFO;
    public static final int RECORD_ADDRESS_LANE_DESCRIPTION_GUIDANCE_INFO;
    public static final int RECORD_ADDRESS_POS;
    private int pos;
    public int laneDirection;
    public final BAPString laneSidestreets;
    private static final int MAX_LANE_SIDESTREETS_LENGTH;
    public int laneType;
    public static final int LANE_TYPE_UNSPECIFIC_LANE_TYPE;
    public static final int LANE_TYPE_NORMAL_LANE;
    public static final int LANE_TYPE_LANE_BLOCKED;
    public static final int LANE_TYPE_LANE_FORBIDDEN;
    public static final int LANE_TYPE_LANE_RESTRICTED;
    public static final int LANE_TYPE_BREAKDOWN_LANE;
    public static final int LANE_TYPE_DYNAMICALLY_CONTROLLED;
    public static final int LANE_TYPE_CAR_POOLS;
    public static final int LANE_TYPE_BUS_LANE;
    public static final int LANE_TYPE_BICYCLE_LANE;
    public static final int LANE_TYPE_TAXI_LANE;
    public static final int LANE_TYPE_TRUCK_LANE;
    public static final int LANE_TYPE_BUS_BICYCLE_LANE;
    public static final int LANE_TYPE_BUS_TAXI_LANE;
    public static final int LANE_TYPE_TAXI_BICYCLE_LANE;
    public static final int LANE_TYPE_BUS_TAXI_BICYCLE_LANE;
    public static final int LANE_TYPE_GREEN_STRIP;
    public static final int LANE_TYPE_MOTORWAY_HIGHWAY_LANE;
    public static final int LANE_TYPE_TRAMWAY_ON_NORMAL_ROAD;
    public static final int LANE_TYPE_SEPARATED_TRAMWAY;
    public static final int LANE_TYPE_EXIT_LANE;
    public static final int LANE_TYPE_ENTER_LANE;
    public static final int LANE_TYPE_TOLL_LANE;
    public static final int LANE_TYPE_FURTHER_LANES_ON_THE_LEFT_HAND_SIDE_NOT_SHOWN;
    public static final int LANE_TYPE_FURTHER_LANES_ON_THE_RIGHT_HAND_SIDE_NOT_SHOWN;
    public static final int LANE_TYPE_HIDE_LANE;
    public static final int LANE_TYPE_ETC_NON_ETC_MIXED_LANE_DF4_4;
    public int laneMarking_left;
    private static final int LANE_MARKING_LEFT_BITSIZE;
    public static final int LANE_MARKING_LEFT_NO_LANE_MARKING_AT_THE_LEFT_BORDER_OF_THE_LANE_NO_LINE;
    public static final int LANE_MARKING_LEFT_SOLID_DIVIDER_LINE;
    public static final int LANE_MARKING_LEFT_DASHED_DIVIDER_LINE;
    public int laneMarking_right;
    private static final int LANE_MARKING_RIGHT_BITSIZE;
    public static final int LANE_MARKING_RIGHT_NO_LANE_MARKING_AT_THE_RIGHT_BORDER_OF_THE_LANE;
    public static final int LANE_MARKING_RIGHT_SOLID_DIVIDER_LINE;
    public static final int LANE_MARKING_RIGHT_DASHED_DIVIDER_LINE;
    public int laneDescription;
    private static final int LANE_DESCRIPTION_BITSIZE;
    public static final int LANE_DESCRIPTION_LANE_AVAILABLE;
    public static final int LANE_DESCRIPTION_LANE_MERGING_TO_LEFT;
    public static final int LANE_DESCRIPTION_LANE_MERGING_TO_RIGHT;
    public static final int LANE_DESCRIPTION_LANE_ENDING_LATER;
    public static final int LANE_DESCRIPTION_FORBIDDEN_LANE;
    public static final int LANE_DESCRIPTION_LANE_EXPANDING_TO_LEFT;
    public static final int LANE_DESCRIPTION_LANE_EXPANDING_TO_RIGHT;
    public static final int LANE_DESCRIPTION_LANE_AVAILABLE_LATER;
    public static final int LANE_DESCRIPTION_MULTIPLE_ADDITIONAL_LANE_BEGIN;
    public static final int LANE_DESCRIPTION_MULTIPLE_CONTINUATION_WITH_LANE_ENDS;
    public static final int LANE_DESCRIPTION_LANE_BEGINS_IN_THE_MIDDLE;
    public static final int LANE_DESCRIPTION_NOT_SUPPORTED_NO_DESCRIPTION_AVAILABLE;
    public int guidanceInfo;
    private static final int GUIDANCE_INFO_BITSIZE;
    public static final int GUIDANCE_INFO_NOT_RECOMMENDED_LANE;
    public static final int GUIDANCE_INFO_RECOMMENDED_LANE;
    public static final int GUIDANCE_INFO_BEST_RECOMMENDATION;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    @Override
    public void setPos(int n) {
        this.pos = n;
    }

    @Override
    public int getPos() {
        return this.pos;
    }

    public LaneGuidance_LaneGuidance(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.laneSidestreets = new BAPString(17);
        this.internalReset();
        this.customInitialization();
    }

    public LaneGuidance_LaneGuidance(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pos = 0;
        this.laneDirection = 0;
        this.laneType = 0;
        this.laneMarking_left = 0;
        this.laneMarking_right = 0;
        this.laneDescription = 0;
        this.guidanceInfo = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.laneSidestreets.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        LaneGuidance_LaneGuidance laneGuidance_LaneGuidance = (LaneGuidance_LaneGuidance)bAPEntity;
        return this.arrayHeader.equalTo(laneGuidance_LaneGuidance.arrayHeader) && this.pos == laneGuidance_LaneGuidance.pos && this.laneDirection == laneGuidance_LaneGuidance.laneDirection && this.laneSidestreets.equalTo(laneGuidance_LaneGuidance.laneSidestreets) && this.laneType == laneGuidance_LaneGuidance.laneType && this.laneMarking_left == laneGuidance_LaneGuidance.laneMarking_left && this.laneMarking_right == laneGuidance_LaneGuidance.laneMarking_right && this.laneDescription == laneGuidance_LaneGuidance.laneDescription && this.guidanceInfo == laneGuidance_LaneGuidance.guidanceInfo;
    }

    private void customInitialization() {
        this.laneSidestreets.setRawContent();
    }

    @Override
    public String toString() {
        return "LaneGuidance_LaneGuidance:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        switch (this.arrayHeader.getSerializationRecordAddress()) {
            case 0: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.laneDirection);
                this.laneSidestreets.serialize(bitStream);
                bitStream.pushByte((byte)this.laneType);
                bitStream.pushBits(4, this.laneMarking_left);
                bitStream.pushBits(4, this.laneMarking_right);
                bitStream.pushBits(4, this.laneDescription);
                bitStream.pushBits(4, this.guidanceInfo);
                break;
            }
            case 1: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.laneDirection);
                this.laneSidestreets.serialize(bitStream);
                bitStream.pushByte((byte)this.laneType);
                bitStream.pushBits(4, this.laneDescription);
                bitStream.pushBits(4, this.guidanceInfo);
                break;
            }
            case 2: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushByte((byte)this.laneDirection);
                bitStream.pushBits(4, this.laneDescription);
                bitStream.pushBits(4, this.guidanceInfo);
                break;
            }
            case 3: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                bitStream.pushBits(4, this.laneDescription);
                bitStream.pushBits(4, this.guidanceInfo);
                break;
            }
            case 15: {
                this.arrayHeader.serializePosOfArrayElement(bitStream, this);
                break;
            }
        }
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

