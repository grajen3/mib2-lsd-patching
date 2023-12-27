/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.AutomaticRedial_AutomaticRedialState;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class AutomaticRedial_Status
implements StatusProperty {
    public final AutomaticRedial_AutomaticRedialState automaticRedialState = new AutomaticRedial_AutomaticRedialState();

    public AutomaticRedial_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public AutomaticRedial_Status(BitStream bitStream) {
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
        AutomaticRedial_Status automaticRedial_Status = (AutomaticRedial_Status)bAPEntity;
        return this.automaticRedialState.equalTo(automaticRedial_Status.automaticRedialState);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "AutomaticRedial_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.automaticRedialState.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 57;
    }

    @Override
    public int getFunctionId() {
        return AutomaticRedial_Status.functionId();
    }
}

