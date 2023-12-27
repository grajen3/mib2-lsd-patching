/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class TMCinfo_Status$TMCinfo$Length_Validity
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean lengthValid;

    public TMCinfo_Status$TMCinfo$Length_Validity() {
        this.internalReset();
        this.customInitialization();
    }

    public TMCinfo_Status$TMCinfo$Length_Validity(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.lengthValid = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TMCinfo_Status$TMCinfo$Length_Validity tMCinfo_Status$TMCinfo$Length_Validity = (TMCinfo_Status$TMCinfo$Length_Validity)bAPEntity;
        return this.lengthValid == tMCinfo_Status$TMCinfo$Length_Validity.lengthValid;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Length_Validity:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.lengthValid);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }
}

