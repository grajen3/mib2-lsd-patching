/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class PrivacySetup_Setup
implements BAPEntity {
    private static final int RESERVED_BIT_3__7_BITSIZE;
    public boolean privacyModeNadOffViaDiagIsActiveDf3_6;
    public boolean privacyModeNadOffIsActiveDf3_6;
    public boolean privacyModeIsActive;

    public PrivacySetup_Setup() {
        this.internalReset();
        this.customInitialization();
    }

    public PrivacySetup_Setup(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.privacyModeNadOffViaDiagIsActiveDf3_6 = false;
        this.privacyModeNadOffIsActiveDf3_6 = false;
        this.privacyModeIsActive = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PrivacySetup_Setup privacySetup_Setup = (PrivacySetup_Setup)bAPEntity;
        return this.privacyModeNadOffViaDiagIsActiveDf3_6 == privacySetup_Setup.privacyModeNadOffViaDiagIsActiveDf3_6 && this.privacyModeNadOffIsActiveDf3_6 == privacySetup_Setup.privacyModeNadOffIsActiveDf3_6 && this.privacyModeIsActive == privacySetup_Setup.privacyModeIsActive;
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
        bitStream.resetBits(5);
        bitStream.pushBoolean(this.privacyModeNadOffViaDiagIsActiveDf3_6);
        bitStream.pushBoolean(this.privacyModeNadOffIsActiveDf3_6);
        bitStream.pushBoolean(this.privacyModeIsActive);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(5);
        this.privacyModeNadOffViaDiagIsActiveDf3_6 = bitStream.popFrontBoolean();
        this.privacyModeNadOffIsActiveDf3_6 = bitStream.popFrontBoolean();
        this.privacyModeIsActive = bitStream.popFrontBoolean();
    }
}

