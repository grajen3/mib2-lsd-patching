/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class ActiveMonitorings_Extension1
implements BAPEntity {
    private static final int RESERVED_BIT_0__7_BITSIZE;

    public ActiveMonitorings_Extension1() {
        this.internalReset();
        this.customInitialization();
    }

    public ActiveMonitorings_Extension1(BitStream bitStream) {
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
        ActiveMonitorings_Extension1 activeMonitorings_Extension1 = (ActiveMonitorings_Extension1)bAPEntity;
        return this.equals(activeMonitorings_Extension1);
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

