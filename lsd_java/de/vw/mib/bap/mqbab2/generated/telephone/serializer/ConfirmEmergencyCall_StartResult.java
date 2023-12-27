/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class ConfirmEmergencyCall_StartResult
implements StartResultMethod {
    public int control;
    public static final int CONTROL_CONFIRM;
    public static final int CONTROL_CANCEL;

    public ConfirmEmergencyCall_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public ConfirmEmergencyCall_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.control = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ConfirmEmergencyCall_StartResult confirmEmergencyCall_StartResult = (ConfirmEmergencyCall_StartResult)bAPEntity;
        return this.control == confirmEmergencyCall_StartResult.control;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "ConfirmEmergencyCall_StartResult:";
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
        this.control = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 28;
    }

    @Override
    public int getFunctionId() {
        return ConfirmEmergencyCall_StartResult.functionId();
    }
}

