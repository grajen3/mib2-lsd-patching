/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveMonitorings_Extension2
implements BAPEntity {
    private static final int RESERVED_BIT_0__7_BITSIZE;

    public ActiveMonitorings_Extension2() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveMonitorings_Extension2(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ActiveMonitorings_Extension2 activeMonitorings_Extension2 = (ActiveMonitorings_Extension2)bAPEntity;
        return this.equals(activeMonitorings_Extension2);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ActiveMonitorings_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(8);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(8);
    }
}

