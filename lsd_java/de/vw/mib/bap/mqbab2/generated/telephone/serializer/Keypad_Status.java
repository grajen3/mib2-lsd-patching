/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.Keypad_Status$KeyStatus;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class Keypad_Status
implements StatusProperty {
    public final Keypad_Status$KeyStatus keyStatus = new Keypad_Status$KeyStatus();

    public Keypad_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public Keypad_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.keyStatus.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Keypad_Status keypad_Status = (Keypad_Status)bAPEntity;
        return this.keyStatus.equalTo(keypad_Status.keyStatus);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "Keypad_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.keyStatus.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 42;
    }

    @Override
    public int getFunctionId() {
        return Keypad_Status.functionId();
    }
}

