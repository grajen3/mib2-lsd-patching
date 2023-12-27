/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.MicroMuteOnOff_MicroMuteOnOff;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MicroMuteOnOff_SetGet
implements SetGetProperty {
    public final MicroMuteOnOff_MicroMuteOnOff microMuteOnOff = new MicroMuteOnOff_MicroMuteOnOff();

    public MicroMuteOnOff_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public MicroMuteOnOff_SetGet(BitStream bitStream) {
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
        MicroMuteOnOff_SetGet microMuteOnOff_SetGet = (MicroMuteOnOff_SetGet)bAPEntity;
        return this.microMuteOnOff.equalTo(microMuteOnOff_SetGet.microMuteOnOff);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "MicroMuteOnOff_SetGet:";
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
        this.microMuteOnOff.deserialize(bitStream);
    }

    public static int functionId() {
        return 34;
    }

    @Override
    public int getFunctionId() {
        return MicroMuteOnOff_SetGet.functionId();
    }
}

