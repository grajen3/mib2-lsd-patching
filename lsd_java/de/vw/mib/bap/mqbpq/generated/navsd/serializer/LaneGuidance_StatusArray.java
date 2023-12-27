/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.LaneGuidance_LaneGuidance;
import de.vw.mib.bap.stream.BitStream;

public final class LaneGuidance_StatusArray
implements BAPStatusArray {
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

    public LaneGuidance_StatusArray() {
        this.internalReset();
        this.customInitialization();
    }

    public LaneGuidance_StatusArray(BitStream bitStream) {
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
        LaneGuidance_StatusArray laneGuidance_StatusArray = (LaneGuidance_StatusArray)bAPEntity;
        return this.laneGuidanceOnOff == laneGuidance_StatusArray.laneGuidanceOnOff && this.arrayHeader.equalTo(laneGuidance_StatusArray.arrayHeader) && this.laneGuidance.equalTo(laneGuidance_StatusArray.laneGuidance);
    }

    @Override
    public int getAsgId() {
        throw new UnsupportedOperationException("This operation is not supported in LaneGuidance_StatusArray");
    }

    @Override
    public void setAsgId(int n) {
        throw new UnsupportedOperationException("This operation is not supported in LaneGuidance_StatusArray");
    }

    @Override
    public boolean isBroadcast() {
        throw new UnsupportedOperationException("This operation is not supported in LaneGuidance_StatusArray");
    }

    @Override
    public void setBroadcast(boolean bl) {
        throw new UnsupportedOperationException("This operation is not supported in LaneGuidance_StatusArray");
    }

    @Override
    public int getTransactionId() {
        throw new UnsupportedOperationException("This operation is not supported in LaneGuidance_StatusArray");
    }

    @Override
    public void setTransactionId(int n) {
        throw new UnsupportedOperationException("This operation is not supported in LaneGuidance_StatusArray");
    }

    @Override
    public int getNumberOfElements() {
        throw new UnsupportedOperationException("This operation is not supported in LaneGuidance_StatusArray");
    }

    @Override
    public void setNumberOfElements(int n) {
        throw new UnsupportedOperationException("This operation is not supported in LaneGuidance_StatusArray");
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
        bitStream.pushByte((byte)this.laneGuidanceOnOff);
        this.arrayHeader.serialize(bitStream);
        this.laneGuidance.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 23;
    }

    @Override
    public int getFunctionId() {
        return LaneGuidance_StatusArray.functionId();
    }
}

