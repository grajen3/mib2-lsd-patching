/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_GeneralSettings
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean eCallOnlyModeDf3_5;

    public FSG_Setup_GeneralSettings() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_GeneralSettings(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.eCallOnlyModeDf3_5 = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_GeneralSettings fSG_Setup_GeneralSettings = (FSG_Setup_GeneralSettings)bAPEntity;
        return this.eCallOnlyModeDf3_5 == fSG_Setup_GeneralSettings.eCallOnlyModeDf3_5;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "FSG_Setup_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.eCallOnlyModeDf3_5);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.eCallOnlyModeDf3_5 = bitStream.popFrontBoolean();
    }
}

