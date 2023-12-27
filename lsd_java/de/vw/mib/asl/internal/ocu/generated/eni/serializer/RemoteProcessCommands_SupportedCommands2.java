/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class RemoteProcessCommands_SupportedCommands2
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean requestNewLanguageSupportedDf3_4;

    public RemoteProcessCommands_SupportedCommands2() {
        this.internalReset();
        this.customInitialization();
    }

    public RemoteProcessCommands_SupportedCommands2(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.requestNewLanguageSupportedDf3_4 = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        RemoteProcessCommands_SupportedCommands2 remoteProcessCommands_SupportedCommands2 = (RemoteProcessCommands_SupportedCommands2)bAPEntity;
        return this.requestNewLanguageSupportedDf3_4 == remoteProcessCommands_SupportedCommands2.requestNewLanguageSupportedDf3_4;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "RemoteProcessCommands_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.requestNewLanguageSupportedDf3_4);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.requestNewLanguageSupportedDf3_4 = bitStream.popFrontBoolean();
    }
}

