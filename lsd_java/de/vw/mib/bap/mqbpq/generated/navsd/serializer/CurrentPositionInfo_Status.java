/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentPositionInfo_Status
implements StatusProperty {
    public final BAPString positionInfo = new BAPString(75);
    private static final int MAX_POSITION_INFO_LENGTH;

    public CurrentPositionInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentPositionInfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.positionInfo.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentPositionInfo_Status currentPositionInfo_Status = (CurrentPositionInfo_Status)bAPEntity;
        return this.positionInfo.equalTo(currentPositionInfo_Status.positionInfo);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "CurrentPositionInfo_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.positionInfo.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 19;
    }

    @Override
    public int getFunctionId() {
        return CurrentPositionInfo_Status.functionId();
    }
}

