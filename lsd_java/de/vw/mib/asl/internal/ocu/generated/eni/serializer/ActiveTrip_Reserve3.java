/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveTrip_Reserve3
implements BAPEntity {
    public static final int RESERVE3_1_MIN;
    public int reserve3_1;
    public static final int RESERVE3_2_MIN;
    public int reserve3_2;

    public ActiveTrip_Reserve3() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveTrip_Reserve3(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserve3_1 = 0;
        this.reserve3_2 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveTrip_Reserve3 activeTrip_Reserve3 = (ActiveTrip_Reserve3)bAPEntity;
        return this.reserve3_1 == activeTrip_Reserve3.reserve3_1 && this.reserve3_2 == activeTrip_Reserve3.reserve3_2;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ActiveTrip_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushInt(this.reserve3_1);
        bitStream.pushInt(this.reserve3_2);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserve3_1 = bitStream.popFrontInt();
        this.reserve3_2 = bitStream.popFrontInt();
    }
}

