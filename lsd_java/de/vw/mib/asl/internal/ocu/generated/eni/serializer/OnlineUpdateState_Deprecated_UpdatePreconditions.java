/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OnlineUpdateState_Deprecated_CurrentStates0;
import de.vw.mib.asl.internal.ocu.generated.eni.serializer.OnlineUpdateState_Deprecated_Precondition0;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class OnlineUpdateState_Deprecated_UpdatePreconditions
implements BAPEntity {
    public OnlineUpdateState_Deprecated_Precondition0 precondition0 = new OnlineUpdateState_Deprecated_Precondition0();
    public static final int PRECONDITION1_MIN;
    public int precondition1;
    public OnlineUpdateState_Deprecated_CurrentStates0 currentStates0 = new OnlineUpdateState_Deprecated_CurrentStates0();
    public static final int CURRENT_STATES1_MIN;
    public int currentStates1;

    public OnlineUpdateState_Deprecated_UpdatePreconditions() {
        this.internalReset();
        this.customInitialization();
    }

    public OnlineUpdateState_Deprecated_UpdatePreconditions(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.precondition1 = 0;
        this.currentStates1 = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
        this.precondition0.reset();
        this.currentStates0.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        OnlineUpdateState_Deprecated_UpdatePreconditions onlineUpdateState_Deprecated_UpdatePreconditions = (OnlineUpdateState_Deprecated_UpdatePreconditions)bAPEntity;
        return this.precondition0.equalTo(onlineUpdateState_Deprecated_UpdatePreconditions.precondition0) && this.precondition1 == onlineUpdateState_Deprecated_UpdatePreconditions.precondition1 && this.currentStates0.equalTo(onlineUpdateState_Deprecated_UpdatePreconditions.currentStates0) && this.currentStates1 == onlineUpdateState_Deprecated_UpdatePreconditions.currentStates1;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "OnlineUpdateState_Deprecated_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.precondition0.serialize(bitStream);
        bitStream.pushByte((byte)this.precondition1);
        this.currentStates0.serialize(bitStream);
        bitStream.pushByte((byte)this.currentStates1);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.precondition0.deserialize(bitStream);
        this.precondition1 = bitStream.popFrontByte();
        this.currentStates0.deserialize(bitStream);
        this.currentStates1 = bitStream.popFrontByte();
    }
}

