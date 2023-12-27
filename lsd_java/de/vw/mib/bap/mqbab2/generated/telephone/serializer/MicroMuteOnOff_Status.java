/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.MicroMuteOnOff_MicroMuteOnOff;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MicroMuteOnOff_Status
implements StatusProperty {
    public final MicroMuteOnOff_MicroMuteOnOff microMuteOnOff = new MicroMuteOnOff_MicroMuteOnOff();

    public MicroMuteOnOff_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MicroMuteOnOff_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.microMuteOnOff.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MicroMuteOnOff_Status microMuteOnOff_Status = (MicroMuteOnOff_Status)bAPEntity;
        return this.microMuteOnOff.equalTo(microMuteOnOff_Status.microMuteOnOff);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MicroMuteOnOff_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.microMuteOnOff.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 34;
    }

    @Override
    public int getFunctionId() {
        return MicroMuteOnOff_Status.functionId();
    }
}

