/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.RingToneMuteOnOff_RingToneMuteOnOff;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class RingToneMuteOnOff_SetGet
implements SetGetProperty {
    public final RingToneMuteOnOff_RingToneMuteOnOff ringToneMuteOnOff = new RingToneMuteOnOff_RingToneMuteOnOff();

    public RingToneMuteOnOff_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public RingToneMuteOnOff_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.ringToneMuteOnOff.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        RingToneMuteOnOff_SetGet ringToneMuteOnOff_SetGet = (RingToneMuteOnOff_SetGet)bAPEntity;
        return this.ringToneMuteOnOff.equalTo(ringToneMuteOnOff_SetGet.ringToneMuteOnOff);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "RingToneMuteOnOff_SetGet:";
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
        this.ringToneMuteOnOff.deserialize(bitStream);
    }

    public static int functionId() {
        return 56;
    }

    @Override
    public int getFunctionId() {
        return RingToneMuteOnOff_SetGet.functionId();
    }
}

