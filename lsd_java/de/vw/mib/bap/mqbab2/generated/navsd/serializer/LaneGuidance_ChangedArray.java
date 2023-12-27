/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.LaneGuidance_LaneGuidance;
import de.vw.mib.bap.stream.BitStream;

public final class LaneGuidance_ChangedArray
implements BAPChangedArray {
    public int laneGuidanceOnOff;
    public static final int LANE_GUIDANCE_ON_OFF_LANE_GUIDANCE_SHALL_NOT_BE_DISPLAYED;
    public static final int LANE_GUIDANCE_ON_OFF_DISPLAY_LANE_GUIDANCE;
    public static final int LANE_GUIDANCE_ON_OFF_NOT_SUPPORTED;
    private ArrayHeader arrayHeader = new ArrayHeader();
    private BAPArrayData laneGuidance = new BAPArrayData(8);
    private static final int MAX_LANE_GUIDANCE_ELEMENTS;

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

    public LaneGuidance_ChangedArray() {
        this.internalReset();
        this.customInitialization();
    }

    public LaneGuidance_ChangedArray(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
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
        LaneGuidance_ChangedArray laneGuidance_ChangedArray = (LaneGuidance_ChangedArray)bAPEntity;
        return this.laneGuidanceOnOff == laneGuidance_ChangedArray.laneGuidanceOnOff && this.arrayHeader.equalTo(laneGuidance_ChangedArray.arrayHeader) && this.laneGuidance.equalTo(laneGuidance_ChangedArray.laneGuidance);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "LaneGuidance_ChangedArray:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
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
        return LaneGuidance_ChangedArray.functionId();
    }
}

