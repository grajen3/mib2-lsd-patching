/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class NbSpeller_StartResult
implements StartResultMethod {
    public int mode;
    public static final int MODE_MATCH_SPELLER;
    public static final int MODE_NEXT_CHARACTER;
    public static final int MODE_PREVIOUS_CHARACTER;
    public final BAPString searchString = new BAPString(51);
    private static final int MAX_SEARCH_STRING_LENGTH;

    public NbSpeller_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public NbSpeller_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.mode = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.searchString.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        NbSpeller_StartResult nbSpeller_StartResult = (NbSpeller_StartResult)bAPEntity;
        return this.mode == nbSpeller_StartResult.mode && this.searchString.equalTo(nbSpeller_StartResult.searchString);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "NbSpeller_StartResult:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.mode = bitStream.popFrontByte();
        this.searchString.deserialize(bitStream);
    }

    public static int functionId() {
        return 42;
    }

    @Override
    public int getFunctionId() {
        return NbSpeller_StartResult.functionId();
    }
}

