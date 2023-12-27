/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SignalQuality2_Status
implements StatusProperty {
    public int quality;

    public SignalQuality2_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public SignalQuality2_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.quality = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SignalQuality2_Status signalQuality2_Status = (SignalQuality2_Status)bAPEntity;
        return this.quality == signalQuality2_Status.quality;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "SignalQuality2_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.quality);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 20;
    }

    @Override
    public int getFunctionId() {
        return SignalQuality2_Status.functionId();
    }
}

