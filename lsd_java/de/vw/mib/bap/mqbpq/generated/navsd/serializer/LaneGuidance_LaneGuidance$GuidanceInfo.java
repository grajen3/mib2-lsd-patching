/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class LaneGuidance_LaneGuidance$GuidanceInfo
implements BAPEntity {
    public boolean reserved_bit_7;
    public boolean reserved_bit_6;
    public boolean reserved_bit_5;
    public boolean reserved_bit_4;
    public boolean reserved_bit_3;
    public boolean reserved_bit_2;
    public boolean reserved_bit_1;
    public boolean recommendedLane;

    public LaneGuidance_LaneGuidance$GuidanceInfo() {
        this.internalReset();
        this.customInitialization();
    }

    public LaneGuidance_LaneGuidance$GuidanceInfo(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_7 = false;
        this.reserved_bit_6 = false;
        this.reserved_bit_5 = false;
        this.reserved_bit_4 = false;
        this.reserved_bit_3 = false;
        this.reserved_bit_2 = false;
        this.reserved_bit_1 = false;
        this.recommendedLane = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        LaneGuidance_LaneGuidance$GuidanceInfo laneGuidance_LaneGuidance$GuidanceInfo = (LaneGuidance_LaneGuidance$GuidanceInfo)bAPEntity;
        return this.reserved_bit_7 == laneGuidance_LaneGuidance$GuidanceInfo.reserved_bit_7 && this.reserved_bit_6 == laneGuidance_LaneGuidance$GuidanceInfo.reserved_bit_6 && this.reserved_bit_5 == laneGuidance_LaneGuidance$GuidanceInfo.reserved_bit_5 && this.reserved_bit_4 == laneGuidance_LaneGuidance$GuidanceInfo.reserved_bit_4 && this.reserved_bit_3 == laneGuidance_LaneGuidance$GuidanceInfo.reserved_bit_3 && this.reserved_bit_2 == laneGuidance_LaneGuidance$GuidanceInfo.reserved_bit_2 && this.reserved_bit_1 == laneGuidance_LaneGuidance$GuidanceInfo.reserved_bit_1 && this.recommendedLane == laneGuidance_LaneGuidance$GuidanceInfo.recommendedLane;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "GuidanceInfo:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_7);
        bitStream.pushBoolean(this.reserved_bit_6);
        bitStream.pushBoolean(this.reserved_bit_5);
        bitStream.pushBoolean(this.reserved_bit_4);
        bitStream.pushBoolean(this.reserved_bit_3);
        bitStream.pushBoolean(this.reserved_bit_2);
        bitStream.pushBoolean(this.reserved_bit_1);
        bitStream.pushBoolean(this.recommendedLane);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

