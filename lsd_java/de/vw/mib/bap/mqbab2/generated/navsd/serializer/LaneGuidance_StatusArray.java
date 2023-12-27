/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.LaneGuidance_LaneGuidance;
import de.vw.mib.bap.stream.BitStream;

public final class LaneGuidance_StatusArray
implements BAPStatusArray {
    public int asg_Id;
    private static final int ASG_ID_BITSIZE;
    public static final int ASG_ID_DEFAULT_ASG_ANY_ASG_SPONTAENOUS_FSG_MESSAGE;
    public static final int ASG_ID_INSTRUMENT_CLUSTER;
    public static final int ASG_ID_HEAD_UP_DISPLAY;
    public static final int ASG_ID_OPERATING_UNIT_REAR_DF4_2;
    public static final int ASG_ID_INSTRUMENT_CLUSTER_TO_BE_EVALUATED_BY_ALL_AS_GS_DF4_4;
    public static final int ASG_ID_HEAD_UP_DISPLAY_TO_BE_EVALUATED_BY_ALL_AS_GS_DF4_4;
    public static final int ASG_ID_OPERATING_UNIT_REAR_TO_BE_EVALUATED_BY_ALL_AS_GS_DF4_4;
    public int taid;
    private static final int TAID_BITSIZE;
    public int laneGuidanceOnOff;
    public static final int LANE_GUIDANCE_ON_OFF_LANE_GUIDANCE_SHALL_NOT_BE_DISPLAYED;
    public static final int LANE_GUIDANCE_ON_OFF_DISPLAY_LANE_GUIDANCE;
    public static final int LANE_GUIDANCE_ON_OFF_NOT_SUPPORTED;
    private ArrayHeader arrayHeader = new ArrayHeader();
    private BAPArrayData laneGuidance = new BAPArrayData(8);
    private static final int MAX_LANE_GUIDANCE_ELEMENTS;

    @Override
    public int getAsgId() {
        return this.asg_Id & 7;
    }

    @Override
    public void setAsgId(int n) {
        this.asg_Id = this.asg_Id & 8 | n & 7;
    }

    @Override
    public boolean isBroadcast() {
        return this.asg_Id >>> 3 == 1;
    }

    @Override
    public void setBroadcast(boolean bl) {
        this.asg_Id = bl ? this.asg_Id | 8 : this.asg_Id & 7;
    }

    @Override
    public int getTransactionId() {
        return this.taid;
    }

    @Override
    public void setTransactionId(int n) {
        this.taid = n;
    }

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.arrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.arrayHeader;
    }

    @Override
    public void setArrayData(BAPArrayData bAPArrayData) {
        this.laneGuidance = bAPArrayData;
    }

    @Override
    public BAPArrayData getArrayData() {
        return this.laneGuidance;
    }

    @Override
    public BAPArrayElement createArrayElement() {
        return new LaneGuidance_LaneGuidance(this.getArrayHeader());
    }

    public LaneGuidance_StatusArray() {
        this.internalReset();
        this.customInitialization();
    }

    public LaneGuidance_StatusArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.asg_Id = 0;
        this.taid = 0;
        this.laneGuidanceOnOff = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.arrayHeader.reset();
        this.laneGuidance.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        LaneGuidance_StatusArray laneGuidance_StatusArray = (LaneGuidance_StatusArray)bAPEntity;
        return this.asg_Id == laneGuidance_StatusArray.asg_Id && this.taid == laneGuidance_StatusArray.taid && this.laneGuidanceOnOff == laneGuidance_StatusArray.laneGuidanceOnOff && this.arrayHeader.equalTo(laneGuidance_StatusArray.arrayHeader) && this.laneGuidance.equalTo(laneGuidance_StatusArray.laneGuidance);
    }

    @Override
    public int getNumberOfElements() {
        return 0;
    }

    @Override
    public void setNumberOfElements(int n) {
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "LaneGuidance_StatusArray:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBits(4, this.asg_Id);
        bitStream.pushBits(4, this.taid);
        bitStream.pushByte((byte)this.laneGuidanceOnOff);
        this.arrayHeader.serialize(bitStream);
        this.laneGuidance.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 24;
    }

    @Override
    public int getFunctionId() {
        return LaneGuidance_StatusArray.functionId();
    }
}

