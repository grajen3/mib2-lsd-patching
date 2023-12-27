/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class DialNumber_StartResult
implements StartResultMethod {
    public final BAPString telNumber = new BAPString(41);
    private static final int MAX_TEL_NUMBER_LENGTH;
    public final BAPString name = new BAPString(150);
    private static final int MAX_NAME_LENGTH;

    public DialNumber_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public DialNumber_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.telNumber.reset();
        this.name.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DialNumber_StartResult dialNumber_StartResult = (DialNumber_StartResult)bAPEntity;
        return this.telNumber.equalTo(dialNumber_StartResult.telNumber) && this.name.equalTo(dialNumber_StartResult.name);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "DialNumber_StartResult:";
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
        this.telNumber.deserialize(bitStream);
        this.name.deserialize(bitStream);
    }

    public static int functionId() {
        return 26;
    }

    @Override
    public int getFunctionId() {
        return DialNumber_StartResult.functionId();
    }
}

