/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.AutomaticRedial_AutomaticRedialState;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class AutomaticRedial_SetGet
implements SetGetProperty {
    public final AutomaticRedial_AutomaticRedialState automaticRedialState = new AutomaticRedial_AutomaticRedialState();

    public AutomaticRedial_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public AutomaticRedial_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.automaticRedialState.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        AutomaticRedial_SetGet automaticRedial_SetGet = (AutomaticRedial_SetGet)bAPEntity;
        return this.automaticRedialState.equalTo(automaticRedial_SetGet.automaticRedialState);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "AutomaticRedial_SetGet:";
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
        this.automaticRedialState.deserialize(bitStream);
    }

    public static int functionId() {
        return 57;
    }

    @Override
    public int getFunctionId() {
        return AutomaticRedial_SetGet.functionId();
    }
}

