/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.asl.internal.ocu.generated.eni.serializer.PrivacySetup_Setup;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class PrivacySetup_SetGet
implements SetGetProperty {
    public PrivacySetup_Setup setup = new PrivacySetup_Setup();
    public int reserve1;
    public static final int RESERVE1_MIN;
    private static final int RESERVE1_BITSIZE;
    public int reserve2;
    public static final int RESERVE2_MIN;
    private static final int RESERVE2_BITSIZE;

    public PrivacySetup_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public PrivacySetup_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserve1 = 0;
        this.reserve2 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.setup.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PrivacySetup_SetGet privacySetup_SetGet = (PrivacySetup_SetGet)bAPEntity;
        return this.setup.equalTo(privacySetup_SetGet.setup) && this.reserve1 == privacySetup_SetGet.reserve1 && this.reserve2 == privacySetup_SetGet.reserve2;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "PrivacySetup_SetGet:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.setup.serialize(bitStream);
        bitStream.pushBits(4, this.reserve1);
        bitStream.pushBits(4, this.reserve2);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.setup.deserialize(bitStream);
        this.reserve1 = bitStream.popFrontBits(4);
        this.reserve2 = bitStream.popFrontBits(4);
    }

    public static int functionId() {
        return 24;
    }

    @Override
    public int getFunctionId() {
        return PrivacySetup_SetGet.functionId();
    }
}

