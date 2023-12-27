/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class PrivacySetup_ModificationState
implements BAPEntity {
    private static final int RESERVED_BIT_1__3_BITSIZE;
    public boolean canBeModified;

    public PrivacySetup_ModificationState() {
        this.internalReset();
        this.customInitialization();
    }

    public PrivacySetup_ModificationState(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.canBeModified = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PrivacySetup_ModificationState privacySetup_ModificationState = (PrivacySetup_ModificationState)bAPEntity;
        return this.canBeModified == privacySetup_ModificationState.canBeModified;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "PrivacySetup_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(3);
        bitStream.pushBoolean(this.canBeModified);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(3);
        this.canBeModified = bitStream.popFrontBoolean();
    }
}

