/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.LaneGuidance_LaneGuidance$GuidanceInfo;
import de.vw.mib.bap.stream.BitStream;

public final class LaneGuidance_LaneGuidance
implements BAPArrayElement {
    private ArrayHeader arrayHeader;
    public static final int RECORD_ADDRESS_LANE_DIRECTION_LANE_DESCRIPTION_GUIDANCE_INFO;
    public static final int RECORD_ADDRESS_LANE_DIRECTION_LANE_DESCRIPTION;
    public static final int RECORD_ADDRESS_GUIDANCE_INFO;
    public int laneDirection;
    private static final int LANE_DIRECTION_BITSIZE;
    public static final int LANE_DIRECTION_UNKNOWN_NO_DIERECTION_INFO;
    public static final int LANE_DIRECTION_STRAIGHT;
    public static final int LANE_DIRECTION_STRAIGHT_AND_RIGHT_90;
    public static final int LANE_DIRECTION_STRAIGHT_AND_LEFT_90;
    public static final int LANE_DIRECTION_RIGHT_90;
    public static final int LANE_DIRECTION_LEFT_90;
    public static final int LANE_DIRECTION_RIGHT_45;
    public static final int LANE_DIRECTION_LEFT_45;
    public static final int LANE_DIRECTION_NOT_SUPPORTED;
    public int laneDescription;
    private static final int LANE_DESCRIPTION_BITSIZE;
    public static final int LANE_DESCRIPTION_LANE_AVAILABLE;
    public static final int LANE_DESCRIPTION_LANE_MERGING_TO_LEFT;
    public static final int LANE_DESCRIPTION_ANE_MERGING_TO_RIGHT;
    public static final int LANE_DESCRIPTION_LANDE_ENDING_LATER;
    public static final int LANE_DESCRIPTION_LANE_EXPANDING_TO_LEFT;
    public static final int LANE_DESCRIPTION_LANE_EXPANDING_TO_RIGHT;
    public static final int LANE_DESCRIPTION_LANE_AVAILABLE_LATER;
    public static final int LANE_DESCRIPTION_NOT_SUPPORTED;
    public final LaneGuidance_LaneGuidance$GuidanceInfo guidanceInfo;

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    public LaneGuidance_LaneGuidance(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
        this.guidanceInfo = new LaneGuidance_LaneGuidance$GuidanceInfo();
        this.internalReset();
        this.customInitialization();
    }

    public LaneGuidance_LaneGuidance(BitStream bitStream, ArrayHeader arrayHeader) {
        this(arrayHeader);
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.laneDirection = 0;
        this.laneDescription = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.guidanceInfo.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        LaneGuidance_LaneGuidance laneGuidance_LaneGuidance = (LaneGuidance_LaneGuidance)bAPEntity;
        return this.arrayHeader.equalTo(laneGuidance_LaneGuidance.arrayHeader) && this.laneDirection == laneGuidance_LaneGuidance.laneDirection && this.laneDescription == laneGuidance_LaneGuidance.laneDescription && this.guidanceInfo.equalTo(laneGuidance_LaneGuidance.guidanceInfo);
    }

    @Override
    public int getPos() {
        throw new UnsupportedOperationException("This operation is not supported in LaneGuidance_LaneGuidance");
    }

    @Override
    public void setPos(int n) {
        throw new UnsupportedOperationException("This operation is not supported in LaneGuidance_LaneGuidance");
    }

    private void customInitialization() {
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
                bitStream.pushBits(4, this.laneDirection);
                bitStream.pushBits(4, this.laneDescription);
                this.guidanceInfo.serialize(bitStream);
                break;
            }
            case 1: {
                bitStream.pushBits(4, this.laneDirection);
                bitStream.pushBits(4, this.laneDescription);
                break;
            }
            case 2: {
                this.guidanceInfo.serialize(bitStream);
                break;
            }
        }
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

