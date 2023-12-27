/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.RingToneMuteOnOff_RingToneMuteOnOff;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class RingToneMuteOnOff_Status
implements StatusProperty {
    public final RingToneMuteOnOff_RingToneMuteOnOff ringToneMuteOnOff = new RingToneMuteOnOff_RingToneMuteOnOff();

    public RingToneMuteOnOff_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public RingToneMuteOnOff_Status(BitStream bitStream) {
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
        RingToneMuteOnOff_Status ringToneMuteOnOff_Status = (RingToneMuteOnOff_Status)bAPEntity;
        return this.ringToneMuteOnOff.equalTo(ringToneMuteOnOff_Status.ringToneMuteOnOff);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "RingToneMuteOnOff_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.ringToneMuteOnOff.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 56;
    }

    @Override
    public int getFunctionId() {
        return RingToneMuteOnOff_Status.functionId();
    }
}

