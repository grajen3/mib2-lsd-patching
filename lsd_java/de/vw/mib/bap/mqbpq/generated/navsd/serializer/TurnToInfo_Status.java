/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class TurnToInfo_Status
implements StatusProperty {
    public final BAPString turnToInfo = new BAPString(75);
    private static final int MAX_TURN_TO_INFO_LENGTH;

    public TurnToInfo_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public TurnToInfo_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.turnToInfo.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TurnToInfo_Status turnToInfo_Status = (TurnToInfo_Status)bAPEntity;
        return this.turnToInfo.equalTo(turnToInfo_Status.turnToInfo);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "TurnToInfo_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.turnToInfo.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 20;
    }

    @Override
    public int getFunctionId() {
        return TurnToInfo_Status.functionId();
    }
}

